package d.b.p.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.b.p.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f65059a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f65060b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f65061c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f65062d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f65063a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f65064a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f65065b;
    }

    @Override // d.b.p.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f65061c = bVar;
        bVar.f65064a = t;
        bVar.f65065b = bundle;
        this.f65059a = true;
        this.f65060b.countDown();
    }

    @Override // d.b.p.c
    public void b(int i, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f65062d = aVar;
        aVar.f65063a = bundle;
        this.f65059a = false;
        this.f65060b.countDown();
    }

    public b<T> c() {
        return this.f65061c;
    }

    public boolean d(int i) {
        try {
            this.f65060b.await(i, TimeUnit.MILLISECONDS);
            if (this.f65062d == null) {
                this.f65062d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f65059a;
    }

    public a e() {
        return this.f65062d;
    }
}
