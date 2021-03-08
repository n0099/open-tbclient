package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Lock> f5078a = new HashMap();
    private FileLock b;
    private String c;

    private a(String str, FileLock fileLock) {
        this.c = str;
        this.b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f5078a) {
            Lock lock = f5078a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f5078a.put(str, lock);
            }
            if (lock.tryLock()) {
                try {
                    FileLock c = FileLock.c(str);
                    if (c == null) {
                        lock.unlock();
                        return null;
                    }
                    return new a(str, c);
                } catch (Exception e) {
                    lock.lock();
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(new RuntimeException(e));
                    return null;
                }
            }
            return null;
        }
    }

    public void a() {
        synchronized (f5078a) {
            this.b.a();
            this.b.b();
            f5078a.get(this.c).unlock();
        }
    }
}
