package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f30257a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f30258b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public String f30259c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f30260d;

    public b(String str, FileLock fileLock) {
        this.f30259c = str;
        this.f30260d = fileLock;
    }

    public static b a(String str) throws Exception {
        f30258b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f30257a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f30257a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e2) {
            f30258b.unlock();
            throw e2;
        }
    }

    public void a() {
        try {
            this.f30260d.a();
            this.f30260d.b();
            Lock lock = f30257a.get(this.f30259c);
            if (lock == null) {
                return;
            }
            lock.unlock();
        } finally {
            f30258b.unlock();
        }
    }
}
