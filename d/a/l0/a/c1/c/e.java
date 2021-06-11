package d.a.l0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import d.a.l0.a.c1.d.j;
@Service
/* loaded from: classes3.dex */
public class e implements d.a.l0.f.i.m.b.c, d.a.l0.a.i1.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.c1.d.j f44599a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.f.i.l.e f44600b;

    /* renamed from: c  reason: collision with root package name */
    public Context f44601c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.i1.g.c f44602d;

    /* renamed from: e  reason: collision with root package name */
    public String f44603e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44604f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44605g;

    /* loaded from: classes3.dex */
    public class a implements j.a {
        public a() {
        }

        @Override // d.a.l0.a.c1.d.j.a
        public void b(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f44600b != null) {
                e.this.f44600b.onCompletion();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.l0.a.c1.d.j.b
        public boolean f(d.a.l0.a.c1.d.j jVar, int i2, int i3) {
            return e.this.f44600b != null && e.this.f44600b.onError();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.l0.a.c1.d.j.d
        public void e(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f44600b != null) {
                e.this.f44600b.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.l0.a.c1.d.j.e
        public void a(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f44600b != null) {
                e.this.f44600b.onResume();
            }
        }
    }

    /* renamed from: d.a.l0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0633e implements j.f {
        public C0633e() {
        }

        @Override // d.a.l0.a.c1.d.j.f
        public void d(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f44600b != null) {
                e.this.f44600b.onStart();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.l0.a.c1.d.j.c
        public void c(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f44600b != null) {
                e.this.f44600b.onPause();
            }
        }
    }

    @Override // d.a.l0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    @Override // d.a.l0.a.i1.a
    public String b() {
        return this.f44602d.f44522g;
    }

    @Override // d.a.l0.a.i1.a
    public String c() {
        return this.f44603e;
    }

    @Override // d.a.l0.f.i.m.b.c
    public void d(boolean z) {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        if (jVar != null) {
            jVar.d(z);
        }
    }

    @Override // d.a.l0.f.i.m.b.c
    public /* bridge */ /* synthetic */ d.a.l0.f.i.m.b.c e(Context context, @NonNull d.a.l0.f.i.j.b bVar) {
        n(context, bVar);
        return this;
    }

    @Override // d.a.l0.a.i1.a
    public String f() {
        d.a.l0.a.i1.g.c cVar = this.f44602d;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.a.l0.f.i.m.b.c
    public void g(d.a.l0.f.i.l.e eVar) {
        this.f44600b = eVar;
    }

    @Override // d.a.l0.f.i.m.b.c
    public int getCurrentPosition() {
        return o().getCurrentPosition();
    }

    @Override // d.a.l0.f.i.m.b.c
    public int getDuration() {
        return o().getDuration();
    }

    @Override // d.a.l0.f.i.m.b.c
    public void h(d.a.l0.f.i.j.b bVar) {
        d.a.l0.a.i1.g.c p = p(bVar);
        this.f44602d = p;
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        if (jVar != null) {
            jVar.o(p);
        }
    }

    @Override // d.a.l0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.l0.f.i.m.b.c
    public boolean isEnd() {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        return jVar != null && jVar.isEnd();
    }

    @Override // d.a.l0.f.i.m.b.c
    public boolean isPlaying() {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.a.l0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.l0.a.i1.a
    public void k(boolean z) {
        this.f44604f = z;
        if (this.f44599a == null) {
            return;
        }
        if (z) {
            if (this.f44605g) {
                o().resume();
            }
            o().b();
            return;
        }
        this.f44605g = o().isPlaying();
        o().pause();
        o().c();
    }

    public final void m() {
        if (TextUtils.isEmpty(this.f44603e)) {
            return;
        }
        d.a.l0.a.i1.b.a(this);
    }

    @Override // d.a.l0.f.i.m.b.c
    public void mute(boolean z) {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public e n(Context context, @NonNull d.a.l0.f.i.j.b bVar) {
        this.f44601c = context;
        d.a.l0.a.i1.g.c p = p(bVar);
        this.f44602d = p;
        this.f44603e = p.n;
        o();
        m();
        return this;
    }

    public d.a.l0.a.c1.d.j o() {
        if (this.f44599a == null) {
            d.a.l0.a.c1.d.j r0 = d.a.l0.a.c1.a.r0();
            r0.e(this.f44601c, this.f44602d);
            this.f44599a = r0;
            r0.g(new a());
            this.f44599a.p(new b());
            this.f44599a.m(new c());
            this.f44599a.j(new d());
            this.f44599a.k(new C0633e());
            this.f44599a.q(new f());
        }
        return this.f44599a;
    }

    @Override // d.a.l0.a.i1.a
    public boolean onBackPressed() {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.l0.a.i1.a
    public void onDestroy() {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        if (jVar != null) {
            jVar.stop();
            this.f44599a = null;
        }
        d.a.l0.a.i1.b.j(this);
    }

    public d.a.l0.a.i1.g.c p(d.a.l0.f.i.j.b bVar) {
        d.a.l0.a.i1.g.c cVar = new d.a.l0.a.i1.g.c();
        cVar.n = "SwanAdPlayer";
        cVar.f44521f = "SwanAdPlayer";
        cVar.s = bVar.f50376f;
        cVar.o = bVar.f50372b;
        cVar.B = bVar.o;
        cVar.M = bVar.z;
        cVar.I = bVar.v;
        cVar.C = bVar.p;
        return cVar;
    }

    @Override // d.a.l0.f.i.m.b.c
    public void pause() {
        if (q()) {
            o().pause();
        }
    }

    public final boolean q() {
        d.a.l0.a.i1.g.c cVar = this.f44602d;
        return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
    }

    @Override // d.a.l0.f.i.m.b.c
    public void resume() {
        d.a.l0.a.c1.d.j jVar;
        if (!q() || isPlaying() || !this.f44604f || (jVar = this.f44599a) == null) {
            return;
        }
        jVar.resume();
    }

    @Override // d.a.l0.f.i.m.b.c
    public void stop() {
        d.a.l0.a.c1.d.j jVar = this.f44599a;
        if (jVar != null) {
            jVar.stop();
            this.f44599a = null;
        }
    }
}
