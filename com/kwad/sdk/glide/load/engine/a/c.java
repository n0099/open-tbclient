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
    private final Map<String, a> f10455a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f10456b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f10457a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f10458b;

        a() {
        }
    }

    /* loaded from: classes5.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f10459a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f10459a) {
                poll = this.f10459a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f10459a) {
                if (this.f10459a.size() < 10) {
                    this.f10459a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f10455a.get(str);
            if (aVar == null) {
                aVar = this.f10456b.a();
                this.f10455a.put(str, aVar);
            }
            aVar.f10458b++;
        }
        aVar.f10457a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.kwad.sdk.glide.g.j.a(this.f10455a.get(str));
            if (aVar.f10458b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f10458b);
            }
            aVar.f10458b--;
            if (aVar.f10458b == 0) {
                a remove = this.f10455a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f10456b.a(remove);
            }
        }
        aVar.f10457a.unlock();
    }
}
