package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Lock> f7485a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static ReentrantLock f7486b = new ReentrantLock();
    private String c;
    private FileLock d;

    private b(String str, FileLock fileLock) {
        this.c = str;
        this.d = fileLock;
    }

    public static b a(String str) throws Exception {
        f7486b.lock();
        try {
            FileLock a2 = FileLock.a(str);
            Lock lock = f7485a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f7485a.put(str, lock);
            }
            lock.lock();
            return new b(str, a2);
        } catch (Exception e) {
            f7486b.unlock();
            throw e;
        }
    }

    public void a() {
        try {
            this.d.a();
            this.d.b();
            Lock lock = f7485a.get(this.c);
            if (lock != null) {
                lock.unlock();
            }
        } finally {
            f7486b.unlock();
        }
    }
}
