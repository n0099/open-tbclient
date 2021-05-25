package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30069a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public FileLock f30070b;

    /* renamed from: c  reason: collision with root package name */
    public String f30071c;

    public a(String str, FileLock fileLock) {
        this.f30071c = str;
        this.f30070b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f30069a) {
            Lock lock = f30069a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30069a.put(str, lock);
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
        synchronized (f30069a) {
            this.f30070b.a();
            this.f30070b.b();
            f30069a.get(this.f30071c).unlock();
        }
    }
}
