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
    public d.a.l0.a.c1.d.j f40923a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.f.i.l.e f40924b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40925c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.i1.g.c f40926d;

    /* renamed from: e  reason: collision with root package name */
    public String f40927e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40928f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40929g;

    /* loaded from: classes3.dex */
    public class a implements j.a {
        public a() {
        }

        @Override // d.a.l0.a.c1.d.j.a
        public void b(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f40924b != null) {
                e.this.f40924b.onCompletion();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.l0.a.c1.d.j.b
        public boolean f(d.a.l0.a.c1.d.j jVar, int i2, int i3) {
            return e.this.f40924b != null && e.this.f40924b.onError();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.l0.a.c1.d.j.d
        public void e(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f40924b != null) {
                e.this.f40924b.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.l0.a.c1.d.j.e
        public void a(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f40924b != null) {
                e.this.f40924b.onResume();
            }
        }
    }

    /* renamed from: d.a.l0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0577e implements j.f {
        public C0577e() {
        }

        @Override // d.a.l0.a.c1.d.j.f
        public void d(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f40924b != null) {
                e.this.f40924b.onStart();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.l0.a.c1.d.j.c
        public void c(d.a.l0.a.c1.d.j jVar) {
            if (e.this.f40924b != null) {
                e.this.f40924b.onPause();
            }
        }
    }

    @Override // d.a.l0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        d.a.l0.a.c1.d.j jVar = this.f40923a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    @Override // d.a.l0.a.i1.a
    public String b() {
        return this.f40926d.f40846g;
    }

    @Override // d.a.l0.a.i1.a
    public String c() {
        return this.f40927e;
    }

    @Override // d.a.l0.f.i.m.b.c
    public void d(boolean z) {
        d.a.l0.a.c1.d.j jVar = this.f40923a;
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
        d.a.l0.a.i1.g.c cVar = this.f40926d;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.a.l0.f.i.m.b.c
    public void g(d.a.l0.f.i.l.e eVar) {
        this.f40924b = eVar;
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
        this.f40926d = p;
        d.a.l0.a.c1.d.j jVar = this.f40923a;
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
        d.a.l0.a.c1.d.j jVar = this.f40923a;
        return jVar != null && jVar.isEnd();
    }

    @Override // d.a.l0.f.i.m.b.c
    public boolean isPlaying() {
        d.a.l0.a.c1.d.j jVar = this.f40923a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.a.l0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.l0.a.i1.a
    public void k(boolean z) {
        this.f40928f = z;
        if (this.f40923a == null) {
            return;
        }
        if (z) {
            if (this.f40929g) {
                o().resume();
            }
            o().b();
            return;
        }
        this.f40929g = o().isPlaying();
        o().pause();
        o().c();
    }

    public final void m() {
        if (TextUtils.isEmpty(this.f40927e)) {
            return;
        }
        d.a.l0.a.i1.b.a(this);
    }

    @Override // d.a.l0.f.i.m.b.c
    public void mute(boolean z) {
        d.a.l0.a.c1.d.j jVar = this.f40923a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public e n(Context context, @NonNull d.a.l0.f.i.j.b bVar) {
        this.f40925c = context;
        d.a.l0.a.i1.g.c p = p(bVar);
        this.f40926d = p;
        this.f40927e = p.n;
        o();
        m();
        return this;
    }

    public d.a.l0.a.c1.d.j o() {
        if (this.f40923a == null) {
            d.a.l0.a.c1.d.j r0 = d.a.l0.a.c1.a.r0();
            r0.e(this.f40925c, this.f40926d);
            this.f40923a = r0;
            r0.g(new a());
            this.f40923a.p(new b());
            this.f40923a.m(new c());
            this.f40923a.j(new d());
            this.f40923a.k(new C0577e());
            this.f40923a.q(new f());
        }
        return this.f40923a;
    }

    @Override // d.a.l0.a.i1.a
    public boolean onBackPressed() {
        d.a.l0.a.c1.d.j jVar = this.f40923a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.l0.a.i1.a
    public void onDestroy() {
        d.a.l0.a.c1.d.j jVar = this.f40923a;
        if (jVar != null) {
            jVar.stop();
            this.f40923a = null;
        }
        d.a.l0.a.i1.b.j(this);
    }

    public d.a.l0.a.i1.g.c p(d.a.l0.f.i.j.b bVar) {
        d.a.l0.a.i1.g.c cVar = new d.a.l0.a.i1.g.c();
        cVar.n = "SwanAdPlayer";
        cVar.f40845f = "SwanAdPlayer";
        cVar.s = bVar.f46702f;
        cVar.o = bVar.f46698b;
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
        d.a.l0.a.i1.g.c cVar = this.f40926d;
        return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
    }

    @Override // d.a.l0.f.i.m.b.c
    public void resume() {
        d.a.l0.a.c1.d.j jVar;
        if (!q() || isPlaying() || !this.f40928f || (jVar = this.f40923a) == null) {
            return;
        }
        jVar.resume();
    }

    @Override // d.a.l0.f.i.m.b.c
    public void stop() {
        d.a.l0.a.c1.d.j jVar = this.f40923a;
        if (jVar != null) {
            jVar.stop();
            this.f40923a = null;
        }
    }
}
