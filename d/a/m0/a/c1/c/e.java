package d.a.m0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import d.a.m0.a.c1.d.j;
@Service
/* loaded from: classes3.dex */
public class e implements d.a.m0.f.i.m.b.c, d.a.m0.a.i1.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.c1.d.j f44707a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.f.i.l.e f44708b;

    /* renamed from: c  reason: collision with root package name */
    public Context f44709c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.i1.g.c f44710d;

    /* renamed from: e  reason: collision with root package name */
    public String f44711e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44712f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44713g;

    /* loaded from: classes3.dex */
    public class a implements j.a {
        public a() {
        }

        @Override // d.a.m0.a.c1.d.j.a
        public void b(d.a.m0.a.c1.d.j jVar) {
            if (e.this.f44708b != null) {
                e.this.f44708b.onCompletion();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.m0.a.c1.d.j.b
        public boolean f(d.a.m0.a.c1.d.j jVar, int i2, int i3) {
            return e.this.f44708b != null && e.this.f44708b.onError();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.m0.a.c1.d.j.d
        public void e(d.a.m0.a.c1.d.j jVar) {
            if (e.this.f44708b != null) {
                e.this.f44708b.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.m0.a.c1.d.j.e
        public void a(d.a.m0.a.c1.d.j jVar) {
            if (e.this.f44708b != null) {
                e.this.f44708b.onResume();
            }
        }
    }

    /* renamed from: d.a.m0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0636e implements j.f {
        public C0636e() {
        }

        @Override // d.a.m0.a.c1.d.j.f
        public void d(d.a.m0.a.c1.d.j jVar) {
            if (e.this.f44708b != null) {
                e.this.f44708b.onStart();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.m0.a.c1.d.j.c
        public void c(d.a.m0.a.c1.d.j jVar) {
            if (e.this.f44708b != null) {
                e.this.f44708b.onPause();
            }
        }
    }

    @Override // d.a.m0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    @Override // d.a.m0.a.i1.a
    public String b() {
        return this.f44710d.f44630g;
    }

    @Override // d.a.m0.a.i1.a
    public String c() {
        return this.f44711e;
    }

    @Override // d.a.m0.f.i.m.b.c
    public void d(boolean z) {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        if (jVar != null) {
            jVar.d(z);
        }
    }

    @Override // d.a.m0.f.i.m.b.c
    public /* bridge */ /* synthetic */ d.a.m0.f.i.m.b.c e(Context context, @NonNull d.a.m0.f.i.j.b bVar) {
        n(context, bVar);
        return this;
    }

    @Override // d.a.m0.a.i1.a
    public String f() {
        d.a.m0.a.i1.g.c cVar = this.f44710d;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.a.m0.f.i.m.b.c
    public void g(d.a.m0.f.i.l.e eVar) {
        this.f44708b = eVar;
    }

    @Override // d.a.m0.f.i.m.b.c
    public int getCurrentPosition() {
        return o().getCurrentPosition();
    }

    @Override // d.a.m0.f.i.m.b.c
    public int getDuration() {
        return o().getDuration();
    }

    @Override // d.a.m0.f.i.m.b.c
    public void h(d.a.m0.f.i.j.b bVar) {
        d.a.m0.a.i1.g.c p = p(bVar);
        this.f44710d = p;
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        if (jVar != null) {
            jVar.o(p);
        }
    }

    @Override // d.a.m0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.m0.f.i.m.b.c
    public boolean isEnd() {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        return jVar != null && jVar.isEnd();
    }

    @Override // d.a.m0.f.i.m.b.c
    public boolean isPlaying() {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.a.m0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.m0.a.i1.a
    public void k(boolean z) {
        this.f44712f = z;
        if (this.f44707a == null) {
            return;
        }
        if (z) {
            if (this.f44713g) {
                o().resume();
            }
            o().b();
            return;
        }
        this.f44713g = o().isPlaying();
        o().pause();
        o().c();
    }

    public final void m() {
        if (TextUtils.isEmpty(this.f44711e)) {
            return;
        }
        d.a.m0.a.i1.b.a(this);
    }

    @Override // d.a.m0.f.i.m.b.c
    public void mute(boolean z) {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public e n(Context context, @NonNull d.a.m0.f.i.j.b bVar) {
        this.f44709c = context;
        d.a.m0.a.i1.g.c p = p(bVar);
        this.f44710d = p;
        this.f44711e = p.n;
        o();
        m();
        return this;
    }

    public d.a.m0.a.c1.d.j o() {
        if (this.f44707a == null) {
            d.a.m0.a.c1.d.j r0 = d.a.m0.a.c1.a.r0();
            r0.e(this.f44709c, this.f44710d);
            this.f44707a = r0;
            r0.g(new a());
            this.f44707a.p(new b());
            this.f44707a.m(new c());
            this.f44707a.j(new d());
            this.f44707a.k(new C0636e());
            this.f44707a.q(new f());
        }
        return this.f44707a;
    }

    @Override // d.a.m0.a.i1.a
    public boolean onBackPressed() {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.m0.a.i1.a
    public void onDestroy() {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        if (jVar != null) {
            jVar.stop();
            this.f44707a = null;
        }
        d.a.m0.a.i1.b.j(this);
    }

    public d.a.m0.a.i1.g.c p(d.a.m0.f.i.j.b bVar) {
        d.a.m0.a.i1.g.c cVar = new d.a.m0.a.i1.g.c();
        cVar.n = "SwanAdPlayer";
        cVar.f44629f = "SwanAdPlayer";
        cVar.s = bVar.f50484f;
        cVar.o = bVar.f50480b;
        cVar.B = bVar.o;
        cVar.M = bVar.z;
        cVar.I = bVar.v;
        cVar.C = bVar.p;
        return cVar;
    }

    @Override // d.a.m0.f.i.m.b.c
    public void pause() {
        if (q()) {
            o().pause();
        }
    }

    public final boolean q() {
        d.a.m0.a.i1.g.c cVar = this.f44710d;
        return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
    }

    @Override // d.a.m0.f.i.m.b.c
    public void resume() {
        d.a.m0.a.c1.d.j jVar;
        if (!q() || isPlaying() || !this.f44712f || (jVar = this.f44707a) == null) {
            return;
        }
        jVar.resume();
    }

    @Override // d.a.m0.f.i.m.b.c
    public void stop() {
        d.a.m0.a.c1.d.j jVar = this.f44707a;
        if (jVar != null) {
            jVar.stop();
            this.f44707a = null;
        }
    }
}
