package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f29971a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public FileLock f29972b;

    /* renamed from: c  reason: collision with root package name */
    public String f29973c;

    public a(String str, FileLock fileLock) {
        this.f29973c = str;
        this.f29972b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f29971a) {
            Lock lock = f29971a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f29971a.put(str, lock);
            }
            if (lock.tryLock()) {
                try {
                    FileLock c2 = FileLock.c(str);
                    if (c2 == null) {
                        lock.unlock();
                        return null;
                    }
                    return new a(str, c2);
                } catch (Exception e2) {
                    lock.lock();
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(new RuntimeException(e2));
                    return null;
                }
            }
            return null;
        }
    }

    public void a() {
        synchronized (f29971a) {
            this.f29972b.a();
            this.f29972b.b();
            f29971a.get(this.f29973c).unlock();
        }
    }
}
