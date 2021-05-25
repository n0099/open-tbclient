package d.a.l0.h.o0.g.g;

import android.content.Context;
import androidx.annotation.NonNull;
import d.a.l0.a.v2.q0;
import d.a.l0.h.o0.g.b.a;
/* loaded from: classes3.dex */
public class a implements d.a.l0.h.o0.g.b.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.h.o0.g.b.b f47618e;

    /* renamed from: d.a.l0.h.o0.g.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1046a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.o0.g.b.d f47620f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a.b f47621g;

        public RunnableC1046a(int i2, d.a.l0.h.o0.g.b.d dVar, a.b bVar) {
            this.f47619e = i2;
            this.f47620f = dVar;
            this.f47621g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context b2 = d.a.l0.h.o0.b.b();
            if (b2 == null) {
                d.a.l0.a.e0.d.b("RecommendButton", "context is null.");
                return;
            }
            a.this.f47618e = d.a.l0.h.o0.g.b.a.c(this.f47619e, b2, this.f47620f);
            a.this.f47618e.u(this.f47621g);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.o0.g.e.a f47623e;

        public b(d.a.l0.h.o0.g.e.a aVar) {
            this.f47623e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47618e != null) {
                a.this.f47618e.d(this.f47623e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.b f47625e;

        public c(a.b bVar) {
            this.f47625e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47618e != null) {
                a.this.f47618e.u(this.f47625e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47627e;

        public d(boolean z) {
            this.f47627e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47618e != null) {
                a.this.f47618e.m(this.f47627e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47618e != null) {
                a.this.f47618e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47618e != null) {
                a.this.f47618e.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47618e != null) {
                a.this.f47618e.destroy();
            }
        }
    }

    public a(int i2, @NonNull d.a.l0.h.o0.g.b.d dVar, a.b bVar) {
        q0.b0(new RunnableC1046a(i2, dVar, bVar));
    }

    @Override // d.a.l0.h.o0.g.b.b
    public void d(d.a.l0.h.o0.g.e.a aVar) {
        q0.b0(new b(aVar));
    }

    @Override // d.a.l0.h.o0.g.a
    public void destroy() {
        q0.b0(new g());
    }

    @Override // d.a.l0.h.o0.g.a
    public void hide() {
        q0.b0(new f());
    }

    @Override // d.a.l0.h.o0.g.b.b
    public void m(boolean z) {
        q0.b0(new d(z));
    }

    @Override // d.a.l0.h.o0.g.a
    public void show() {
        q0.b0(new e());
    }

    @Override // d.a.l0.h.o0.g.b.b
    public void u(a.b bVar) {
        q0.b0(new c(bVar));
    }
}
