package d.a.q.f.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d<T> implements d.a.q.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f67828a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f67829b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public b<T> f67830c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f67831d = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f67832a;
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f67833a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f67834b;
    }

    @Override // d.a.q.c
    public void a(T t, Bundle bundle) {
        b<T> bVar = new b<>();
        this.f67830c = bVar;
        bVar.f67833a = t;
        bVar.f67834b = bundle;
        this.f67828a = true;
        this.f67829b.countDown();
    }

    @Override // d.a.q.c
    public void b(int i2, Throwable th, Bundle bundle) {
        a aVar = new a();
        this.f67831d = aVar;
        aVar.f67832a = bundle;
        this.f67828a = false;
        this.f67829b.countDown();
    }

    public b<T> c() {
        return this.f67830c;
    }

    public boolean d(int i2) {
        try {
            this.f67829b.await(i2, TimeUnit.MILLISECONDS);
            if (this.f67831d == null) {
                this.f67831d = new a();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.f67828a;
    }

    public a e() {
        return this.f67831d;
    }
}
