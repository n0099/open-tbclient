package com.kwad.sdk.glide.load.engine.a;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f10454a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f10455b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f10456a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f10457b;

        a() {
        }
    }

    /* loaded from: classes5.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f10458a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f10458a) {
                poll = this.f10458a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f10458a) {
                if (this.f10458a.size() < 10) {
                    this.f10458a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f10454a.get(str);
            if (aVar == null) {
                aVar = this.f10455b.a();
                this.f10454a.put(str, aVar);
            }
            aVar.f10457b++;
        }
        aVar.f10456a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.kwad.sdk.glide.g.j.a(this.f10454a.get(str));
            if (aVar.f10457b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f10457b);
            }
            aVar.f10457b--;
            if (aVar.f10457b == 0) {
                a remove = this.f10454a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f10455b.a(remove);
            }
        }
        aVar.f10456a.unlock();
    }
}
