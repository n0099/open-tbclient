package com.kwad.sdk.glide.load.engine.a;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f36102a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f36103b = new b();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Lock f36104a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        public int f36105b;
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<a> f36106a = new ArrayDeque();

        public a a() {
            a poll;
            synchronized (this.f36106a) {
                poll = this.f36106a.poll();
            }
            return poll == null ? new a() : poll;
        }

        public void a(a aVar) {
            synchronized (this.f36106a) {
                if (this.f36106a.size() < 10) {
                    this.f36106a.offer(aVar);
                }
            }
        }
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f36102a.get(str);
            if (aVar == null) {
                aVar = this.f36103b.a();
                this.f36102a.put(str, aVar);
            }
            aVar.f36105b++;
        }
        aVar.f36104a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.kwad.sdk.glide.g.j.a(this.f36102a.get(str));
            if (aVar.f36105b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f36105b);
            }
            int i2 = aVar.f36105b - 1;
            aVar.f36105b = i2;
            if (i2 == 0) {
                a remove = this.f36102a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f36103b.a(remove);
            }
        }
        aVar.f36104a.unlock();
    }
}
