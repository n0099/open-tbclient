package d.a.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.a.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f67872a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f67873b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f67874c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f67875d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f67876a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f67877a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f67878b;
    }

    @Override // d.a.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f67874c = bVar;
        bVar.f67877a = t;
        bVar.f67878b = bundle;
        this.f67872a = true;
        this.f67873b.countDown();
    }

    @Override // d.a.q.c
    public void b(int i2, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f67875d = aVar;
        aVar.f67876a = bundle;
        this.f67872a = false;
        this.f67873b.countDown();
    }

    public b<T> c() {
        return this.f67874c;
    }

    public boolean d(int i2) {
        try {
            this.f67873b.await(i2, TimeUnit.MILLISECONDS);
            if (this.f67875d == null) {
                this.f67875d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f67872a;
    }

    public a e() {
        return this.f67875d;
    }
}
