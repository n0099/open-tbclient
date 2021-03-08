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
    private final Map<String, a> f6721a = new HashMap();
    private final b b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f6722a = new ReentrantLock();
        int b;

        a() {
        }
    }

    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f6723a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f6723a) {
                poll = this.f6723a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f6723a) {
                if (this.f6723a.size() < 10) {
                    this.f6723a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f6721a.get(str);
            if (aVar == null) {
                aVar = this.b.a();
                this.f6721a.put(str, aVar);
            }
            aVar.b++;
        }
        aVar.f6722a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.kwad.sdk.glide.g.j.a(this.f6721a.get(str));
            if (aVar.b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
            aVar.b--;
            if (aVar.b == 0) {
                a remove = this.f6721a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.b.a(remove);
            }
        }
        aVar.f6722a.unlock();
    }
}
