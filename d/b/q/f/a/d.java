package d.b.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.b.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f65323a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f65324b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f65325c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f65326d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f65327a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f65328a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f65329b;
    }

    @Override // d.b.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f65325c = bVar;
        bVar.f65328a = t;
        bVar.f65329b = bundle;
        this.f65323a = true;
        this.f65324b.countDown();
    }

    @Override // d.b.q.c
    public void b(int i, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f65326d = aVar;
        aVar.f65327a = bundle;
        this.f65323a = false;
        this.f65324b.countDown();
    }

    public b<T> c() {
        return this.f65325c;
    }

    public boolean d(int i) {
        try {
            this.f65324b.await(i, TimeUnit.MILLISECONDS);
            if (this.f65326d == null) {
                this.f65326d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f65323a;
    }

    public a e() {
        return this.f65326d;
    }
}
