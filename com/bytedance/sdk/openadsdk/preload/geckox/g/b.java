package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30288a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f30289b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f30290c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f30291d;

    public b(String str, FileLock fileLock) {
        this.f30290c = str;
        this.f30291d = fileLock;
    }

    public static b a(String str) throws Exception {
        f30289b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f30288a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30288a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f30289b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f30291d.a();
            this.f30291d.b();
            Lock lock = f30288a.get(this.f30290c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f30289b.unlock();
        }
    }
}
