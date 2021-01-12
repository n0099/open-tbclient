package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Lock> f7483a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private FileLock f7484b;
    private String c;

    private a(String str, FileLock fileLock) {
        this.c = str;
        this.f7484b = fileLock;
    }

    public static a a(String str) throws Exception {
        synchronized (f7483a) {
            Lock lock = f7483a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f7483a.put(str, lock);
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
        synchronized (f7483a) {
            this.f7484b.a();
            this.f7484b.b();
            f7483a.get(this.c).unlock();
        }
    }
}
