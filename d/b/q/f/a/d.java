package d.b.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.b.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f64364a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f64365b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f64366c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f64367d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f64368a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f64369a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f64370b;
    }

    @Override // d.b.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f64366c = bVar;
        bVar.f64369a = t;
        bVar.f64370b = bundle;
        this.f64364a = true;
        this.f64365b.countDown();
    }

    @Override // d.b.q.c
    public void b(int i, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f64367d = aVar;
        aVar.f64368a = bundle;
        this.f64364a = false;
        this.f64365b.countDown();
    }

    public b<T> c() {
        return this.f64366c;
    }

    public boolean d(int i) {
        try {
            this.f64365b.await(i, TimeUnit.MILLISECONDS);
            if (this.f64367d == null) {
                this.f64367d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f64364a;
    }

    public a e() {
        return this.f64367d;
    }
}
