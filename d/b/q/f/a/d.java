package d.b.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.b.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f64365a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f64366b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f64367c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f64368d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f64369a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f64370a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f64371b;
    }

    @Override // d.b.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f64367c = bVar;
        bVar.f64370a = t;
        bVar.f64371b = bundle;
        this.f64365a = true;
        this.f64366b.countDown();
    }

    @Override // d.b.q.c
    public void b(int i, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f64368d = aVar;
        aVar.f64369a = bundle;
        this.f64365a = false;
        this.f64366b.countDown();
    }

    public b<T> c() {
        return this.f64367c;
    }

    public boolean d(int i) {
        try {
            this.f64366b.await(i, TimeUnit.MILLISECONDS);
            if (this.f64368d == null) {
                this.f64368d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f64365a;
    }

    public a e() {
        return this.f64368d;
    }
}
