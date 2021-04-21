package com.kwad.sdk.glide.load.engine.a;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f35802a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f35803b = new b();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Lock f35804a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        public int f35805b;
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<a> f35806a = new ArrayDeque();

        public a a() {
            a poll;
            synchronized (this.f35806a) {
                poll = this.f35806a.poll();
            }
            return poll == null ? new a() : poll;
        }

        public void a(a aVar) {
            synchronized (this.f35806a) {
                if (this.f35806a.size() < 10) {
                    this.f35806a.offer(aVar);
                }
            }
        }
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f35802a.get(str);
            if (aVar == null) {
                aVar = this.f35803b.a();
                this.f35802a.put(str, aVar);
            }
            aVar.f35805b++;
        }
        aVar.f35804a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.kwad.sdk.glide.g.j.a(this.f35802a.get(str));
            if (aVar.f35805b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f35805b);
            }
            int i = aVar.f35805b - 1;
            aVar.f35805b = i;
            if (i == 0) {
                a remove = this.f35802a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f35803b.a(remove);
            }
        }
        aVar.f35804a.unlock();
    }
}
