package d.a.i0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import d.a.i0.a.c1.d.j;
@Service
/* loaded from: classes3.dex */
public class e implements d.a.i0.f.i.m.b.c, d.a.i0.a.i1.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.c1.d.j f40749a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.f.i.l.e f40750b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40751c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.i1.g.c f40752d;

    /* renamed from: e  reason: collision with root package name */
    public String f40753e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40754f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40755g;

    /* loaded from: classes3.dex */
    public class a implements j.a {
        public a() {
        }

        @Override // d.a.i0.a.c1.d.j.a
        public void b(d.a.i0.a.c1.d.j jVar) {
            if (e.this.f40750b != null) {
                e.this.f40750b.onCompletion();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.i0.a.c1.d.j.b
        public boolean f(d.a.i0.a.c1.d.j jVar, int i2, int i3) {
            return e.this.f40750b != null && e.this.f40750b.onError();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.i0.a.c1.d.j.d
        public void e(d.a.i0.a.c1.d.j jVar) {
            if (e.this.f40750b != null) {
                e.this.f40750b.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.i0.a.c1.d.j.e
        public void a(d.a.i0.a.c1.d.j jVar) {
            if (e.this.f40750b != null) {
                e.this.f40750b.onResume();
            }
        }
    }

    /* renamed from: d.a.i0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0566e implements j.f {
        public C0566e() {
        }

        @Override // d.a.i0.a.c1.d.j.f
        public void d(d.a.i0.a.c1.d.j jVar) {
            if (e.this.f40750b != null) {
                e.this.f40750b.onStart();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.i0.a.c1.d.j.c
        public void c(d.a.i0.a.c1.d.j jVar) {
            if (e.this.f40750b != null) {
                e.this.f40750b.onPause();
            }
        }
    }

    @Override // d.a.i0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    @Override // d.a.i0.a.i1.a
    public String b() {
        return this.f40752d.f40672g;
    }

    @Override // d.a.i0.a.i1.a
    public String c() {
        return this.f40753e;
    }

    @Override // d.a.i0.f.i.m.b.c
    public void d(boolean z) {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        if (jVar != null) {
            jVar.d(z);
        }
    }

    @Override // d.a.i0.f.i.m.b.c
    public /* bridge */ /* synthetic */ d.a.i0.f.i.m.b.c e(Context context, @NonNull d.a.i0.f.i.j.b bVar) {
        n(context, bVar);
        return this;
    }

    @Override // d.a.i0.a.i1.a
    public String f() {
        d.a.i0.a.i1.g.c cVar = this.f40752d;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.a.i0.f.i.m.b.c
    public void g(d.a.i0.f.i.l.e eVar) {
        this.f40750b = eVar;
    }

    @Override // d.a.i0.f.i.m.b.c
    public int getCurrentPosition() {
        return o().getCurrentPosition();
    }

    @Override // d.a.i0.f.i.m.b.c
    public int getDuration() {
        return o().getDuration();
    }

    @Override // d.a.i0.f.i.m.b.c
    public void h(d.a.i0.f.i.j.b bVar) {
        d.a.i0.a.i1.g.c p = p(bVar);
        this.f40752d = p;
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        if (jVar != null) {
            jVar.o(p);
        }
    }

    @Override // d.a.i0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.i0.f.i.m.b.c
    public boolean isEnd() {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        return jVar != null && jVar.isEnd();
    }

    @Override // d.a.i0.f.i.m.b.c
    public boolean isPlaying() {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.a.i0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.i0.a.i1.a
    public void k(boolean z) {
        this.f40754f = z;
        if (this.f40749a == null) {
            return;
        }
        if (z) {
            if (this.f40755g) {
                o().resume();
            }
            o().b();
            return;
        }
        this.f40755g = o().isPlaying();
        o().pause();
        o().c();
    }

    public final void m() {
        if (TextUtils.isEmpty(this.f40753e)) {
            return;
        }
        d.a.i0.a.i1.b.a(this);
    }

    @Override // d.a.i0.f.i.m.b.c
    public void mute(boolean z) {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public e n(Context context, @NonNull d.a.i0.f.i.j.b bVar) {
        this.f40751c = context;
        d.a.i0.a.i1.g.c p = p(bVar);
        this.f40752d = p;
        this.f40753e = p.n;
        o();
        m();
        return this;
    }

    public d.a.i0.a.c1.d.j o() {
        if (this.f40749a == null) {
            d.a.i0.a.c1.d.j r0 = d.a.i0.a.c1.a.r0();
            r0.e(this.f40751c, this.f40752d);
            this.f40749a = r0;
            r0.g(new a());
            this.f40749a.p(new b());
            this.f40749a.m(new c());
            this.f40749a.j(new d());
            this.f40749a.k(new C0566e());
            this.f40749a.q(new f());
        }
        return this.f40749a;
    }

    @Override // d.a.i0.a.i1.a
    public boolean onBackPressed() {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.i0.a.i1.a
    public void onDestroy() {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        if (jVar != null) {
            jVar.stop();
            this.f40749a = null;
        }
        d.a.i0.a.i1.b.j(this);
    }

    public d.a.i0.a.i1.g.c p(d.a.i0.f.i.j.b bVar) {
        d.a.i0.a.i1.g.c cVar = new d.a.i0.a.i1.g.c();
        cVar.n = "SwanAdPlayer";
        cVar.f40671f = "SwanAdPlayer";
        cVar.s = bVar.f46526f;
        cVar.o = bVar.f46522b;
        cVar.B = bVar.o;
        cVar.M = bVar.z;
        cVar.I = bVar.v;
        cVar.C = bVar.p;
        return cVar;
    }

    @Override // d.a.i0.f.i.m.b.c
    public void pause() {
        if (q()) {
            o().pause();
        }
    }

    public final boolean q() {
        d.a.i0.a.i1.g.c cVar = this.f40752d;
        return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
    }

    @Override // d.a.i0.f.i.m.b.c
    public void resume() {
        d.a.i0.a.c1.d.j jVar;
        if (!q() || isPlaying() || !this.f40754f || (jVar = this.f40749a) == null) {
            return;
        }
        jVar.resume();
    }

    @Override // d.a.i0.f.i.m.b.c
    public void stop() {
        d.a.i0.a.c1.d.j jVar = this.f40749a;
        if (jVar != null) {
            jVar.stop();
            this.f40749a = null;
        }
    }
}
