package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30072a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f30073b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f30074c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f30075d;

    public b(String str, FileLock fileLock) {
        this.f30074c = str;
        this.f30075d = fileLock;
    }

    public static b a(String str) throws Exception {
        f30073b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f30072a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30072a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f30073b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f30075d.a();
            this.f30075d.b();
            Lock lock = f30072a.get(this.f30074c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f30073b.unlock();
        }
    }
}
