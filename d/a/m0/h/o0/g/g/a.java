package d.a.m0.h.o0.g.g;

import android.content.Context;
import androidx.annotation.NonNull;
import d.a.m0.a.v2.q0;
import d.a.m0.h.o0.g.b.a;
/* loaded from: classes3.dex */
public class a implements d.a.m0.h.o0.g.b.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.h.o0.g.b.b f51400e;

    /* renamed from: d.a.m0.h.o0.g.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1105a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.o0.g.b.d f51402f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a.b f51403g;

        public RunnableC1105a(int i2, d.a.m0.h.o0.g.b.d dVar, a.b bVar) {
            this.f51401e = i2;
            this.f51402f = dVar;
            this.f51403g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context b2 = d.a.m0.h.o0.b.b();
            if (b2 == null) {
                d.a.m0.a.e0.d.b("RecommendButton", "context is null.");
                return;
            }
            a.this.f51400e = d.a.m0.h.o0.g.b.a.c(this.f51401e, b2, this.f51402f);
            a.this.f51400e.u(this.f51403g);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.o0.g.e.a f51405e;

        public b(d.a.m0.h.o0.g.e.a aVar) {
            this.f51405e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51400e != null) {
                a.this.f51400e.d(this.f51405e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.b f51407e;

        public c(a.b bVar) {
            this.f51407e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51400e != null) {
                a.this.f51400e.u(this.f51407e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f51409e;

        public d(boolean z) {
            this.f51409e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51400e != null) {
                a.this.f51400e.m(this.f51409e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51400e != null) {
                a.this.f51400e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51400e != null) {
                a.this.f51400e.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51400e != null) {
                a.this.f51400e.destroy();
            }
        }
    }

    public a(int i2, @NonNull d.a.m0.h.o0.g.b.d dVar, a.b bVar) {
        q0.b0(new RunnableC1105a(i2, dVar, bVar));
    }

    @Override // d.a.m0.h.o0.g.b.b
    public void d(d.a.m0.h.o0.g.e.a aVar) {
        q0.b0(new b(aVar));
    }

    @Override // d.a.m0.h.o0.g.a
    public void destroy() {
        q0.b0(new g());
    }

    @Override // d.a.m0.h.o0.g.a
    public void hide() {
        q0.b0(new f());
    }

    @Override // d.a.m0.h.o0.g.b.b
    public void m(boolean z) {
        q0.b0(new d(z));
    }

    @Override // d.a.m0.h.o0.g.a
    public void show() {
        q0.b0(new e());
    }

    @Override // d.a.m0.h.o0.g.b.b
    public void u(a.b bVar) {
        q0.b0(new c(bVar));
    }
}
