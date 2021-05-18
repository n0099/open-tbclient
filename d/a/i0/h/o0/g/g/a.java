package d.a.i0.h.o0.g.g;

import android.content.Context;
import androidx.annotation.NonNull;
import d.a.i0.a.v2.q0;
import d.a.i0.h.o0.g.b.a;
/* loaded from: classes3.dex */
public class a implements d.a.i0.h.o0.g.b.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.h.o0.g.b.b f47442e;

    /* renamed from: d.a.i0.h.o0.g.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1035a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.o0.g.b.d f47444f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a.b f47445g;

        public RunnableC1035a(int i2, d.a.i0.h.o0.g.b.d dVar, a.b bVar) {
            this.f47443e = i2;
            this.f47444f = dVar;
            this.f47445g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context b2 = d.a.i0.h.o0.b.b();
            if (b2 == null) {
                d.a.i0.a.e0.d.b("RecommendButton", "context is null.");
                return;
            }
            a.this.f47442e = d.a.i0.h.o0.g.b.a.c(this.f47443e, b2, this.f47444f);
            a.this.f47442e.u(this.f47445g);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.o0.g.e.a f47447e;

        public b(d.a.i0.h.o0.g.e.a aVar) {
            this.f47447e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47442e != null) {
                a.this.f47442e.d(this.f47447e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.b f47449e;

        public c(a.b bVar) {
            this.f47449e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47442e != null) {
                a.this.f47442e.u(this.f47449e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47451e;

        public d(boolean z) {
            this.f47451e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47442e != null) {
                a.this.f47442e.m(this.f47451e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47442e != null) {
                a.this.f47442e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47442e != null) {
                a.this.f47442e.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47442e != null) {
                a.this.f47442e.destroy();
            }
        }
    }

    public a(int i2, @NonNull d.a.i0.h.o0.g.b.d dVar, a.b bVar) {
        q0.b0(new RunnableC1035a(i2, dVar, bVar));
    }

    @Override // d.a.i0.h.o0.g.b.b
    public void d(d.a.i0.h.o0.g.e.a aVar) {
        q0.b0(new b(aVar));
    }

    @Override // d.a.i0.h.o0.g.a
    public void destroy() {
        q0.b0(new g());
    }

    @Override // d.a.i0.h.o0.g.a
    public void hide() {
        q0.b0(new f());
    }

    @Override // d.a.i0.h.o0.g.b.b
    public void m(boolean z) {
        q0.b0(new d(z));
    }

    @Override // d.a.i0.h.o0.g.a
    public void show() {
        q0.b0(new e());
    }

    @Override // d.a.i0.h.o0.g.b.b
    public void u(a.b bVar) {
        q0.b0(new c(bVar));
    }
}
