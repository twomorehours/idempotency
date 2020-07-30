package show.tmh.idempotency.storage;

/**
 * 幂等熟虑存储的抽象
 */
public interface Storage {

    /**
     * 原子性存储幂等id
     * @param id 幂等id
     * @return 是否保存成功
     */
    boolean saveIfAbsent(String id);

    /**
     * 删除幂等id
     * @param id 幂等id
     */
    void delete(String id);
}
