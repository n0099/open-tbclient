package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f29979a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public FileLock f29980b;

    /* renamed from: c  reason: collision with root package name */
    public String f29981c;

    public a(String str, FileLock fileLock) {
        this.f29981c = str;
        this.f29980b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f29979a) {
            Lock lock = f29979a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f29979a.put(str, lock);
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
        synchronized (f29979a) {
            this.f29980b.a();
            this.f29980b.b();
            f29979a.get(this.f29981c).unlock();
        }
    }
}
