package com.kwad.sdk.glide.load.engine.a;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f10155a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f10156b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f10157a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f10158b;

        a() {
        }
    }

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f10159a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f10159a) {
                poll = this.f10159a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f10159a) {
                if (this.f10159a.size() < 10) {
                    this.f10159a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f10155a.get(str);
            if (aVar == null) {
                aVar = this.f10156b.a();
                this.f10155a.put(str, aVar);
            }
            aVar.f10158b++;
        }
        aVar.f10157a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.kwad.sdk.glide.g.j.a(this.f10155a.get(str));
            if (aVar.f10158b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f10158b);
            }
            aVar.f10158b--;
            if (aVar.f10158b == 0) {
                a remove = this.f10155a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f10156b.a(remove);
            }
        }
        aVar.f10157a.unlock();
    }
}
