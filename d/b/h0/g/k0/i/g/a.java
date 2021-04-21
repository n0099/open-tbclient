package d.b.h0.g.k0.i.g;

import android.content.Context;
import androidx.annotation.NonNull;
import d.b.h0.a.i2.k0;
import d.b.h0.g.k0.i.b.a;
/* loaded from: classes3.dex */
public class a implements d.b.h0.g.k0.i.b.b {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.g.k0.i.b.b f49030e;

    /* renamed from: d.b.h0.g.k0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1010a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49031e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.k0.i.b.d f49032f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a.b f49033g;

        public RunnableC1010a(int i, d.b.h0.g.k0.i.b.d dVar, a.b bVar) {
            this.f49031e = i;
            this.f49032f = dVar;
            this.f49033g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context b2 = d.b.h0.g.k0.c.b();
            if (b2 == null) {
                d.b.h0.a.c0.c.b("RecommendButton", "context is null.");
                return;
            }
            a.this.f49030e = d.b.h0.g.k0.i.b.a.c(this.f49031e, b2, this.f49032f);
            a.this.f49030e.o(this.f49033g);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.k0.i.e.a f49035e;

        public b(d.b.h0.g.k0.i.e.a aVar) {
            this.f49035e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49030e != null) {
                a.this.f49030e.h(this.f49035e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.b f49037e;

        public c(a.b bVar) {
            this.f49037e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49030e != null) {
                a.this.f49030e.o(this.f49037e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49039e;

        public d(boolean z) {
            this.f49039e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49030e != null) {
                a.this.f49030e.z(this.f49039e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49030e != null) {
                a.this.f49030e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49030e != null) {
                a.this.f49030e.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49030e != null) {
                a.this.f49030e.destroy();
            }
        }
    }

    public a(int i, @NonNull d.b.h0.g.k0.i.b.d dVar, a.b bVar) {
        k0.X(new RunnableC1010a(i, dVar, bVar));
    }

    @Override // d.b.h0.g.k0.i.a
    public void destroy() {
        k0.X(new g());
    }

    @Override // d.b.h0.g.k0.i.b.b
    public void h(d.b.h0.g.k0.i.e.a aVar) {
        k0.X(new b(aVar));
    }

    @Override // d.b.h0.g.k0.i.a
    public void hide() {
        k0.X(new f());
    }

    @Override // d.b.h0.g.k0.i.b.b
    public void o(a.b bVar) {
        k0.X(new c(bVar));
    }

    @Override // d.b.h0.g.k0.i.a
    public void show() {
        k0.X(new e());
    }

    @Override // d.b.h0.g.k0.i.b.b
    public void z(boolean z) {
        k0.X(new d(z));
    }
}
