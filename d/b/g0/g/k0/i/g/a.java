package d.b.g0.g.k0.i.g;

import android.content.Context;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.k0;
import d.b.g0.g.k0.i.b.a;
/* loaded from: classes3.dex */
public class a implements d.b.g0.g.k0.i.b.b {

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.k0.i.b.b f48309e;

    /* renamed from: d.b.g0.g.k0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0978a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48310e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.k0.i.b.d f48311f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a.b f48312g;

        public RunnableC0978a(int i, d.b.g0.g.k0.i.b.d dVar, a.b bVar) {
            this.f48310e = i;
            this.f48311f = dVar;
            this.f48312g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context b2 = d.b.g0.g.k0.c.b();
            if (b2 == null) {
                d.b.g0.a.c0.c.b("RecommendButton", "context is null.");
                return;
            }
            a.this.f48309e = d.b.g0.g.k0.i.b.a.c(this.f48310e, b2, this.f48311f);
            a.this.f48309e.o(this.f48312g);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.k0.i.e.a f48314e;

        public b(d.b.g0.g.k0.i.e.a aVar) {
            this.f48314e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48309e != null) {
                a.this.f48309e.h(this.f48314e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.b f48316e;

        public c(a.b bVar) {
            this.f48316e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48309e != null) {
                a.this.f48309e.o(this.f48316e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48318e;

        public d(boolean z) {
            this.f48318e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48309e != null) {
                a.this.f48309e.z(this.f48318e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48309e != null) {
                a.this.f48309e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48309e != null) {
                a.this.f48309e.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48309e != null) {
                a.this.f48309e.destroy();
            }
        }
    }

    public a(int i, @NonNull d.b.g0.g.k0.i.b.d dVar, a.b bVar) {
        k0.X(new RunnableC0978a(i, dVar, bVar));
    }

    @Override // d.b.g0.g.k0.i.a
    public void destroy() {
        k0.X(new g());
    }

    @Override // d.b.g0.g.k0.i.b.b
    public void h(d.b.g0.g.k0.i.e.a aVar) {
        k0.X(new b(aVar));
    }

    @Override // d.b.g0.g.k0.i.a
    public void hide() {
        k0.X(new f());
    }

    @Override // d.b.g0.g.k0.i.b.b
    public void o(a.b bVar) {
        k0.X(new c(bVar));
    }

    @Override // d.b.g0.g.k0.i.a
    public void show() {
        k0.X(new e());
    }

    @Override // d.b.g0.g.k0.i.b.b
    public void z(boolean z) {
        k0.X(new d(z));
    }
}
