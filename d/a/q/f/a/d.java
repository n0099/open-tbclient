package d.a.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.a.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f63641a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f63642b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f63643c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f63644d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f63645a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f63646a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f63647b;
    }

    @Override // d.a.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f63643c = bVar;
        bVar.f63646a = t;
        bVar.f63647b = bundle;
        this.f63641a = true;
        this.f63642b.countDown();
    }

    @Override // d.a.q.c
    public void b(int i2, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f63644d = aVar;
        aVar.f63645a = bundle;
        this.f63641a = false;
        this.f63642b.countDown();
    }

    public b<T> c() {
        return this.f63643c;
    }

    public boolean d(int i2) {
        try {
            this.f63642b.await(i2, TimeUnit.MILLISECONDS);
            if (this.f63644d == null) {
                this.f63644d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f63641a;
    }

    public a e() {
        return this.f63644d;
    }
}
