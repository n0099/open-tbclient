package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f29982a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f29983b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f29984c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f29985d;

    public b(String str, FileLock fileLock) {
        this.f29984c = str;
        this.f29985d = fileLock;
    }

    public static b a(String str) throws Exception {
        f29983b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f29982a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f29982a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f29983b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f29985d.a();
            this.f29985d.b();
            Lock lock = f29982a.get(this.f29984c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f29983b.unlock();
        }
    }
}
