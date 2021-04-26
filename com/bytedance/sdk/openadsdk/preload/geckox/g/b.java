package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30898a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f30899b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f30900c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f30901d;

    public b(String str, FileLock fileLock) {
        this.f30900c = str;
        this.f30901d = fileLock;
    }

    public static b a(String str) throws Exception {
        f30899b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f30898a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30898a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f30899b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f30901d.a();
            this.f30901d.b();
            Lock lock = f30898a.get(this.f30900c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f30899b.unlock();
        }
    }
}
