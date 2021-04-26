package d.a.h0.g.k0.i.g;

import android.content.Context;
import androidx.annotation.NonNull;
import d.a.h0.a.i2.k0;
import d.a.h0.g.k0.i.b.a;
/* loaded from: classes3.dex */
public class a implements d.a.h0.g.k0.i.b.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.g.k0.i.b.b f46507e;

    /* renamed from: d.a.h0.g.k0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0949a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.k0.i.b.d f46509f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a.b f46510g;

        public RunnableC0949a(int i2, d.a.h0.g.k0.i.b.d dVar, a.b bVar) {
            this.f46508e = i2;
            this.f46509f = dVar;
            this.f46510g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context b2 = d.a.h0.g.k0.c.b();
            if (b2 == null) {
                d.a.h0.a.c0.c.b("RecommendButton", "context is null.");
                return;
            }
            a.this.f46507e = d.a.h0.g.k0.i.b.a.c(this.f46508e, b2, this.f46509f);
            a.this.f46507e.v(this.f46510g);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.k0.i.e.a f46512e;

        public b(d.a.h0.g.k0.i.e.a aVar) {
            this.f46512e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46507e != null) {
                a.this.f46507e.e(this.f46512e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.b f46514e;

        public c(a.b bVar) {
            this.f46514e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46507e != null) {
                a.this.f46507e.v(this.f46514e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46516e;

        public d(boolean z) {
            this.f46516e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46507e != null) {
                a.this.f46507e.o(this.f46516e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46507e != null) {
                a.this.f46507e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46507e != null) {
                a.this.f46507e.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46507e != null) {
                a.this.f46507e.destroy();
            }
        }
    }

    public a(int i2, @NonNull d.a.h0.g.k0.i.b.d dVar, a.b bVar) {
        k0.X(new RunnableC0949a(i2, dVar, bVar));
    }

    @Override // d.a.h0.g.k0.i.a
    public void destroy() {
        k0.X(new g());
    }

    @Override // d.a.h0.g.k0.i.b.b
    public void e(d.a.h0.g.k0.i.e.a aVar) {
        k0.X(new b(aVar));
    }

    @Override // d.a.h0.g.k0.i.a
    public void hide() {
        k0.X(new f());
    }

    @Override // d.a.h0.g.k0.i.b.b
    public void o(boolean z) {
        k0.X(new d(z));
    }

    @Override // d.a.h0.g.k0.i.a
    public void show() {
        k0.X(new e());
    }

    @Override // d.a.h0.g.k0.i.b.b
    public void v(a.b bVar) {
        k0.X(new c(bVar));
    }
}
