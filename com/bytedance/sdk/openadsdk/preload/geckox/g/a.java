package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Lock> f7783a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private FileLock f7784b;
    private String c;

    private a(String str, FileLock fileLock) {
        this.c = str;
        this.f7784b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f7783a) {
            Lock lock = f7783a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f7783a.put(str, lock);
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
        synchronized (f7783a) {
            this.f7784b.a();
            this.f7784b.b();
            f7783a.get(this.c).unlock();
        }
    }
}
