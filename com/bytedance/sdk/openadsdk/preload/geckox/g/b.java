package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30175a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f30176b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f30177c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f30178d;

    public b(String str, FileLock fileLock) {
        this.f30177c = str;
        this.f30178d = fileLock;
    }

    public static b a(String str) throws Exception {
        f30176b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f30175a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30175a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f30176b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f30178d.a();
            this.f30178d.b();
            Lock lock = f30175a.get(this.f30177c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f30176b.unlock();
        }
    }
}
