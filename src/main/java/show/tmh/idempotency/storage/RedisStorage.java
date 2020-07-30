package show.tmh.idempotency.storage;

import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

/**
 * redis存储的实现
 */
public class RedisStorage implements Storage {

    private StringRedisTemplate redisTemplate;

    public RedisStorage(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean saveIfAbsent(String id) {
        return redisTemplate.execute(
                (RedisCallback<Boolean>) redisConnection -> redisConnection.set(id.getBytes(), "".getBytes(), Expiration.seconds(60 * 60 * 24),
                        RedisStringCommands.SetOption.SET_IF_ABSENT));
    }

    @Override
    public void delete(String id) {
        redisTemplate.execute((RedisCallback<Object>) redisConnection -> redisConnection.del(id.getBytes()));
    }
}
