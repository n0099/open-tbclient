package d.b.g0.a.b1.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.b.g0.a.k;
import d.b.g0.a.w0.c.j;
/* loaded from: classes2.dex */
public class a implements d.b.g0.a.b1.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43907h = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public j f43908a;

    /* renamed from: b  reason: collision with root package name */
    public String f43909b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.b1.g.c f43910c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43911d;

    /* renamed from: e  reason: collision with root package name */
    public Context f43912e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43913f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.a.b1.g.b f43914g;

    /* renamed from: d.b.g0.a.b1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0623a implements j.a {
        public C0623a() {
        }

        @Override // d.b.g0.a.w0.c.j.a
        public void d(j jVar) {
            if (a.this.f43914g != null) {
                a.this.f43914g.d(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.b.g0.a.w0.c.j.b
        public boolean b(j jVar, int i, int i2) {
            return a.this.f43914g != null && a.this.f43914g.b(jVar, i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.b.g0.a.w0.c.j.d
        public void a(j jVar) {
            if (a.this.f43914g != null) {
                a.this.f43914g.a(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.b.g0.a.w0.c.j.e
        public void c(j jVar) {
            if (a.this.f43914g != null) {
                a.this.f43914g.c(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.b.g0.a.w0.c.j.f
        public void f(j jVar) {
            if (a.this.f43914g != null) {
                a.this.f43914g.f(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.b.g0.a.w0.c.j.c
        public void e(j jVar) {
            if (a.this.f43914g != null) {
                a.this.f43914g.e(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.b.g0.a.b1.g.c cVar) {
        this.f43912e = context;
        this.f43910c = cVar;
        this.f43909b = cVar.n;
        l();
        h();
    }

    public void A(d.b.g0.a.b1.g.c cVar) {
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.d(cVar);
        }
    }

    public void B(d.b.g0.a.b1.g.c cVar) {
        if (f43907h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.k(cVar, true);
        }
        this.f43910c = cVar;
    }

    public final boolean C() {
        d.b.g0.a.b1.g.c cVar = this.f43910c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f43909b) || TextUtils.isEmpty(this.f43910c.f43505f)) ? false : true;
    }

    @Override // d.b.g0.a.b1.a
    public Object a() {
        return this;
    }

    @Override // d.b.g0.a.b1.a
    public String b() {
        return this.f43910c.f43506g;
    }

    @Override // d.b.g0.a.b1.a
    public String c() {
        return this.f43909b;
    }

    @Override // d.b.g0.a.b1.a
    public void d(boolean z) {
    }

    @Override // d.b.g0.a.b1.a
    public String e() {
        d.b.g0.a.b1.g.c cVar = this.f43910c;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.b.g0.a.b1.a
    public void f(boolean z) {
        this.f43913f = z;
        if (z) {
            if (this.f43911d) {
                l().resume();
            }
            l().a();
        } else if (this.f43908a != null) {
            this.f43911d = l().isPlaying();
            l().pause();
            l().b();
        }
    }

    public final void h() {
        if (TextUtils.isEmpty(this.f43909b)) {
            return;
        }
        d.b.g0.a.b1.b.a(this);
    }

    public int i() {
        return l().getCurrentPosition();
    }

    public int j() {
        return l().getDuration();
    }

    public d.b.g0.a.b1.g.c k() {
        return this.f43910c;
    }

    public j l() {
        if (this.f43908a == null) {
            d.b.g0.a.c0.c.g("video", "create player");
            j d0 = d.b.g0.a.w0.a.d0();
            d0.c(this.f43912e, this.f43910c);
            this.f43908a = d0;
            d0.j(new C0623a());
            this.f43908a.g(new b());
            this.f43908a.q(new c());
            this.f43908a.m(new d());
            this.f43908a.n(new e());
            this.f43908a.p(new f());
        }
        return this.f43908a;
    }

    public void m() {
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.h();
        }
    }

    public boolean n() {
        j jVar = this.f43908a;
        return jVar != null && jVar.isEnd();
    }

    public boolean o() {
        j jVar = this.f43908a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.b.g0.a.b1.a
    public boolean onBackPressed() {
        d.b.g0.a.c0.c.g("video", "onBackPressed");
        j jVar = this.f43908a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.b.g0.a.b1.a
    public void onDestroy() {
        d.b.g0.a.c0.c.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.stop();
            this.f43908a = null;
        }
        d.b.g0.a.b1.b.j(this);
    }

    public void p(boolean z) {
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public void q(d.b.g0.a.b1.g.c cVar) {
        d.b.g0.a.c0.c.g("video", "Open Player " + cVar.n);
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.f(cVar);
        }
        this.f43910c = cVar;
    }

    public void r() {
        if (C()) {
            l().pause();
        }
    }

    public void s(String str) {
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.l(str);
        }
    }

    public void t() {
        j jVar;
        if (!C() || o() || !this.f43913f || (jVar = this.f43908a) == null) {
            return;
        }
        jVar.resume();
    }

    public void u(int i) {
        j jVar;
        if (C() && (jVar = this.f43908a) != null) {
            jVar.seekTo(i);
        }
    }

    public void v(boolean z, int i) {
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.o(z, i);
        }
    }

    public void w(d.b.g0.a.b1.g.b bVar) {
        this.f43914g = bVar;
    }

    public void x(boolean z) {
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.e(z);
        }
    }

    public void y(FrameLayout frameLayout) {
        j jVar = this.f43908a;
        if (jVar != null) {
            jVar.i(frameLayout);
        }
    }

    public void z(d.b.g0.a.b1.g.b bVar) {
        this.f43914g = bVar;
    }
}
