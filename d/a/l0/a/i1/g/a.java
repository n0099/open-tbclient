package d.a.l0.a.i1.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.l0.a.c1.d.j;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.i1.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46641h = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public j f46642a;

    /* renamed from: b  reason: collision with root package name */
    public String f46643b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.i1.g.c f46644c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46645d;

    /* renamed from: e  reason: collision with root package name */
    public Context f46646e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46647f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.i1.g.b f46648g;

    /* renamed from: d.a.l0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0772a implements j.a {
        public C0772a() {
        }

        @Override // d.a.l0.a.c1.d.j.a
        public void b(j jVar) {
            if (a.this.f46648g != null) {
                a.this.f46648g.b(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.l0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            return a.this.f46648g != null && a.this.f46648g.f(jVar, i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.l0.a.c1.d.j.d
        public void e(j jVar) {
            if (a.this.f46648g != null) {
                a.this.f46648g.e(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.l0.a.c1.d.j.e
        public void a(j jVar) {
            if (a.this.f46648g != null) {
                a.this.f46648g.a(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.a.l0.a.c1.d.j.f
        public void d(j jVar) {
            if (a.this.f46648g != null) {
                a.this.f46648g.d(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.l0.a.c1.d.j.c
        public void c(j jVar) {
            if (a.this.f46648g != null) {
                a.this.f46648g.c(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.a.l0.a.i1.g.c cVar) {
        this.f46646e = context;
        this.f46644c = cVar;
        this.f46643b = cVar.n;
        h();
        d();
    }

    @Override // d.a.l0.a.i1.a
    public String b() {
        return this.f46644c.f44522g;
    }

    @Override // d.a.l0.a.i1.a
    public String c() {
        return this.f46643b;
    }

    public final void d() {
        if (TextUtils.isEmpty(this.f46643b)) {
            return;
        }
        d.a.l0.a.i1.b.a(this);
    }

    public int e() {
        return h().getCurrentPosition();
    }

    @Override // d.a.l0.a.i1.a
    public String f() {
        d.a.l0.a.i1.g.c cVar = this.f46644c;
        return cVar != null ? cVar.D : "";
    }

    public d.a.l0.a.i1.g.c g() {
        return this.f46644c;
    }

    public j h() {
        if (this.f46642a == null) {
            d.a.l0.a.e0.d.g("video", "create player");
            j r0 = d.a.l0.a.c1.a.r0();
            r0.e(this.f46646e, this.f46644c);
            this.f46642a = r0;
            r0.g(new C0772a());
            this.f46642a.p(new b());
            this.f46642a.m(new c());
            this.f46642a.j(new d());
            this.f46642a.k(new e());
            this.f46642a.q(new f());
        }
        return this.f46642a;
    }

    @Override // d.a.l0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.l0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.l0.a.i1.a
    public void k(boolean z) {
        this.f46647f = z;
        if (z) {
            if (this.f46645d) {
                h().resume();
            }
            h().b();
        } else if (this.f46642a != null) {
            this.f46645d = h().isPlaying();
            h().pause();
            h().c();
        }
    }

    public void l() {
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.f();
        }
    }

    public boolean m() {
        j jVar = this.f46642a;
        return jVar != null && jVar.isEnd();
    }

    public boolean n() {
        j jVar = this.f46642a;
        return jVar != null && jVar.isPlaying();
    }

    public void o(d.a.l0.a.i1.g.c cVar) {
        d.a.l0.a.e0.d.g("video", "Open Player " + cVar.n);
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.o(cVar);
        }
        this.f46644c = cVar;
    }

    @Override // d.a.l0.a.i1.a
    public boolean onBackPressed() {
        d.a.l0.a.e0.d.g("video", "onBackPressed");
        j jVar = this.f46642a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.l0.a.i1.a
    public void onDestroy() {
        d.a.l0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.stop();
            this.f46642a = null;
        }
        d.a.l0.a.i1.b.j(this);
    }

    public void p() {
        if (z()) {
            h().pause();
        }
    }

    public void q(String str) {
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.i(str);
        }
    }

    public void r() {
        j jVar;
        if (!z() || n() || !this.f46647f || (jVar = this.f46642a) == null) {
            return;
        }
        jVar.resume();
    }

    public void s(int i2) {
        j jVar;
        if (z() && (jVar = this.f46642a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.l(z, i2);
        }
    }

    public void u(d.a.l0.a.i1.g.b bVar) {
        this.f46648g = bVar;
    }

    public void v(boolean z) {
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.d(z);
        }
    }

    public void w(FrameLayout frameLayout) {
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    public void x(d.a.l0.a.i1.g.c cVar) {
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.n(cVar);
        }
    }

    public void y(d.a.l0.a.i1.g.c cVar) {
        if (f46641h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f46642a;
        if (jVar != null) {
            jVar.h(cVar, true);
        }
        this.f46644c = cVar;
    }

    public final boolean z() {
        d.a.l0.a.i1.g.c cVar = this.f46644c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f46643b) || TextUtils.isEmpty(this.f46644c.f44521f)) ? false : true;
    }
}
