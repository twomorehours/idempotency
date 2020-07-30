package show.tmh.idempotency.generator;

import java.util.UUID;

/**
 * ID生成器
 */
public class IdempotencyGenerator {

    public String generateId(String bizName) {
        return bizName + "-" + UUID.randomUUID().toString().replace("-", "");
    }
}
