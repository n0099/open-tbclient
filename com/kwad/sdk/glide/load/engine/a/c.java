package com.kwad.sdk.glide.load.engine.a;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f10157a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f10158b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f10159a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f10160b;

        a() {
        }
    }

    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f10161a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f10161a) {
                poll = this.f10161a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f10161a) {
                if (this.f10161a.size() < 10) {
                    this.f10161a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f10157a.get(str);
            if (aVar == null) {
                aVar = this.f10158b.a();
                this.f10157a.put(str, aVar);
            }
            aVar.f10160b++;
        }
        aVar.f10159a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.kwad.sdk.glide.g.j.a(this.f10157a.get(str));
            if (aVar.f10160b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f10160b);
            }
            aVar.f10160b--;
            if (aVar.f10160b == 0) {
                a remove = this.f10157a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f10158b.a(remove);
            }
        }
        aVar.f10159a.unlock();
    }
}
