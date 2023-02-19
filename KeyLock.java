import java.util.concurrent.locks.ReentrantLock;

public class KeyLock {

    private static final int LOCK_COUNT = 50;

    private static ReentrantLock[] locks = new ReentrantLock[LOCK_COUNT];

    static {
        for (int i = 0; i < LOCK_COUNT; i++) {
            locks[i] = new ReentrantLock(true);
        }
    }

    /**
     * 根据key计算获取某个已经初始化好的公平锁
     */
    public static void lock(String key) {
        ReentrantLock lock = locks[Math.abs(key.hashCode() % LOCK_COUNT)];
        lock.lock();
    }

    public static void unlock(String key) {
        ReentrantLock lock = locks[Math.abs(key.hashCode() % LOCK_COUNT)];
        lock.unlock();
    }
}
