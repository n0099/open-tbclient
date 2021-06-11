package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30172a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public FileLock f30173b;

    /* renamed from: c  reason: collision with root package name */
    public String f30174c;

    public a(String str, FileLock fileLock) {
        this.f30174c = str;
        this.f30173b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f30172a) {
            Lock lock = f30172a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30172a.put(str, lock);
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
        synchronized (f30172a) {
            this.f30173b.a();
            this.f30173b.b();
            f30172a.get(this.f30174c).unlock();
        }
    }
}
