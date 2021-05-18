package d.a.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.a.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f64278a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f64279b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f64280c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f64281d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f64282a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f64283a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f64284b;
    }

    @Override // d.a.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f64280c = bVar;
        bVar.f64283a = t;
        bVar.f64284b = bundle;
        this.f64278a = true;
        this.f64279b.countDown();
    }

    @Override // d.a.q.c
    public void b(int i2, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f64281d = aVar;
        aVar.f64282a = bundle;
        this.f64278a = false;
        this.f64279b.countDown();
    }

    public b<T> c() {
        return this.f64280c;
    }

    public boolean d(int i2) {
        try {
            this.f64279b.await(i2, TimeUnit.MILLISECONDS);
            if (this.f64281d == null) {
                this.f64281d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f64278a;
    }

    public a e() {
        return this.f64281d;
    }
}
