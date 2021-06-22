package d.a.m0.a.i1.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.m0.a.c1.d.j;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.i1.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46749h = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public j f46750a;

    /* renamed from: b  reason: collision with root package name */
    public String f46751b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.i1.g.c f46752c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46753d;

    /* renamed from: e  reason: collision with root package name */
    public Context f46754e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46755f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.i1.g.b f46756g;

    /* renamed from: d.a.m0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0775a implements j.a {
        public C0775a() {
        }

        @Override // d.a.m0.a.c1.d.j.a
        public void b(j jVar) {
            if (a.this.f46756g != null) {
                a.this.f46756g.b(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.m0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            return a.this.f46756g != null && a.this.f46756g.f(jVar, i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.m0.a.c1.d.j.d
        public void e(j jVar) {
            if (a.this.f46756g != null) {
                a.this.f46756g.e(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.m0.a.c1.d.j.e
        public void a(j jVar) {
            if (a.this.f46756g != null) {
                a.this.f46756g.a(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.a.m0.a.c1.d.j.f
        public void d(j jVar) {
            if (a.this.f46756g != null) {
                a.this.f46756g.d(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.m0.a.c1.d.j.c
        public void c(j jVar) {
            if (a.this.f46756g != null) {
                a.this.f46756g.c(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.a.m0.a.i1.g.c cVar) {
        this.f46754e = context;
        this.f46752c = cVar;
        this.f46751b = cVar.n;
        h();
        d();
    }

    @Override // d.a.m0.a.i1.a
    public String b() {
        return this.f46752c.f44630g;
    }

    @Override // d.a.m0.a.i1.a
    public String c() {
        return this.f46751b;
    }

    public final void d() {
        if (TextUtils.isEmpty(this.f46751b)) {
            return;
        }
        d.a.m0.a.i1.b.a(this);
    }

    public int e() {
        return h().getCurrentPosition();
    }

    @Override // d.a.m0.a.i1.a
    public String f() {
        d.a.m0.a.i1.g.c cVar = this.f46752c;
        return cVar != null ? cVar.D : "";
    }

    public d.a.m0.a.i1.g.c g() {
        return this.f46752c;
    }

    public j h() {
        if (this.f46750a == null) {
            d.a.m0.a.e0.d.g("video", "create player");
            j r0 = d.a.m0.a.c1.a.r0();
            r0.e(this.f46754e, this.f46752c);
            this.f46750a = r0;
            r0.g(new C0775a());
            this.f46750a.p(new b());
            this.f46750a.m(new c());
            this.f46750a.j(new d());
            this.f46750a.k(new e());
            this.f46750a.q(new f());
        }
        return this.f46750a;
    }

    @Override // d.a.m0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.m0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.m0.a.i1.a
    public void k(boolean z) {
        this.f46755f = z;
        if (z) {
            if (this.f46753d) {
                h().resume();
            }
            h().b();
        } else if (this.f46750a != null) {
            this.f46753d = h().isPlaying();
            h().pause();
            h().c();
        }
    }

    public void l() {
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.f();
        }
    }

    public boolean m() {
        j jVar = this.f46750a;
        return jVar != null && jVar.isEnd();
    }

    public boolean n() {
        j jVar = this.f46750a;
        return jVar != null && jVar.isPlaying();
    }

    public void o(d.a.m0.a.i1.g.c cVar) {
        d.a.m0.a.e0.d.g("video", "Open Player " + cVar.n);
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.o(cVar);
        }
        this.f46752c = cVar;
    }

    @Override // d.a.m0.a.i1.a
    public boolean onBackPressed() {
        d.a.m0.a.e0.d.g("video", "onBackPressed");
        j jVar = this.f46750a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.m0.a.i1.a
    public void onDestroy() {
        d.a.m0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.stop();
            this.f46750a = null;
        }
        d.a.m0.a.i1.b.j(this);
    }

    public void p() {
        if (z()) {
            h().pause();
        }
    }

    public void q(String str) {
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.i(str);
        }
    }

    public void r() {
        j jVar;
        if (!z() || n() || !this.f46755f || (jVar = this.f46750a) == null) {
            return;
        }
        jVar.resume();
    }

    public void s(int i2) {
        j jVar;
        if (z() && (jVar = this.f46750a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.l(z, i2);
        }
    }

    public void u(d.a.m0.a.i1.g.b bVar) {
        this.f46756g = bVar;
    }

    public void v(boolean z) {
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.d(z);
        }
    }

    public void w(FrameLayout frameLayout) {
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    public void x(d.a.m0.a.i1.g.c cVar) {
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.n(cVar);
        }
    }

    public void y(d.a.m0.a.i1.g.c cVar) {
        if (f46749h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f46750a;
        if (jVar != null) {
            jVar.h(cVar, true);
        }
        this.f46752c = cVar;
    }

    public final boolean z() {
        d.a.m0.a.i1.g.c cVar = this.f46752c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f46751b) || TextUtils.isEmpty(this.f46752c.f44629f)) ? false : true;
    }
}
