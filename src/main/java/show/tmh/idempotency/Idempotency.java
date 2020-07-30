package show.tmh.idempotency;

import show.tmh.idempotency.storage.Storage;

/**
 * 幂等组件入口
 */
public class Idempotency {

    private Storage storage;

    public boolean saveIfAbsent(String id){
        return storage.saveIfAbsent(id);
    }

    public void delete(String id){
        storage.delete(id);
    }

}
