package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30254a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public FileLock f30255b;

    /* renamed from: c  reason: collision with root package name */
    public String f30256c;

    public a(String str, FileLock fileLock) {
        this.f30256c = str;
        this.f30255b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f30254a) {
            Lock lock = f30254a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30254a.put(str, lock);
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
        synchronized (f30254a) {
            this.f30255b.a();
            this.f30255b.b();
            f30254a.get(this.f30256c).unlock();
        }
    }
}
