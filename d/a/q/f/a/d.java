package d.a.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.a.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f64154a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f64155b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f64156c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f64157d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f64158a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f64159a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f64160b;
    }

    @Override // d.a.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f64156c = bVar;
        bVar.f64159a = t;
        bVar.f64160b = bundle;
        this.f64154a = true;
        this.f64155b.countDown();
    }

    @Override // d.a.q.c
    public void b(int i2, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f64157d = aVar;
        aVar.f64158a = bundle;
        this.f64154a = false;
        this.f64155b.countDown();
    }

    public b<T> c() {
        return this.f64156c;
    }

    public boolean d(int i2) {
        try {
            this.f64155b.await(i2, TimeUnit.MILLISECONDS);
            if (this.f64157d == null) {
                this.f64157d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f64154a;
    }

    public a e() {
        return this.f64157d;
    }
}
