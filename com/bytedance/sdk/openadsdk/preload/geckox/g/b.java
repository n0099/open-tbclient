package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30143a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f30144b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f30145c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f30146d;

    public b(String str, FileLock fileLock) {
        this.f30145c = str;
        this.f30146d = fileLock;
    }

    public static b a(String str) throws Exception {
        f30144b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f30143a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30143a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f30144b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f30146d.a();
            this.f30146d.b();
            Lock lock = f30143a.get(this.f30145c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f30144b.unlock();
        }
    }
}
