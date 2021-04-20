package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f29974a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f29975b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f29976c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f29977d;

    public b(String str, FileLock fileLock) {
        this.f29976c = str;
        this.f29977d = fileLock;
    }

    public static b a(String str) throws Exception {
        f29975b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f29974a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f29974a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f29975b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f29977d.a();
            this.f29977d.b();
            Lock lock = f29974a.get(this.f29976c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f29975b.unlock();
        }
    }
}
