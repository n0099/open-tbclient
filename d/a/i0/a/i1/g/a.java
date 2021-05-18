package d.a.i0.a.i1.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.i0.a.c1.d.j;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class a implements d.a.i0.a.i1.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f42791h = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public j f42792a;

    /* renamed from: b  reason: collision with root package name */
    public String f42793b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.i1.g.c f42794c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42795d;

    /* renamed from: e  reason: collision with root package name */
    public Context f42796e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42797f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.a.i1.g.b f42798g;

    /* renamed from: d.a.i0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0705a implements j.a {
        public C0705a() {
        }

        @Override // d.a.i0.a.c1.d.j.a
        public void b(j jVar) {
            if (a.this.f42798g != null) {
                a.this.f42798g.b(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.i0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            return a.this.f42798g != null && a.this.f42798g.f(jVar, i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.i0.a.c1.d.j.d
        public void e(j jVar) {
            if (a.this.f42798g != null) {
                a.this.f42798g.e(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.i0.a.c1.d.j.e
        public void a(j jVar) {
            if (a.this.f42798g != null) {
                a.this.f42798g.a(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.a.i0.a.c1.d.j.f
        public void d(j jVar) {
            if (a.this.f42798g != null) {
                a.this.f42798g.d(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.i0.a.c1.d.j.c
        public void c(j jVar) {
            if (a.this.f42798g != null) {
                a.this.f42798g.c(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.a.i0.a.i1.g.c cVar) {
        this.f42796e = context;
        this.f42794c = cVar;
        this.f42793b = cVar.n;
        h();
        d();
    }

    @Override // d.a.i0.a.i1.a
    public String b() {
        return this.f42794c.f40672g;
    }

    @Override // d.a.i0.a.i1.a
    public String c() {
        return this.f42793b;
    }

    public final void d() {
        if (TextUtils.isEmpty(this.f42793b)) {
            return;
        }
        d.a.i0.a.i1.b.a(this);
    }

    public int e() {
        return h().getCurrentPosition();
    }

    @Override // d.a.i0.a.i1.a
    public String f() {
        d.a.i0.a.i1.g.c cVar = this.f42794c;
        return cVar != null ? cVar.D : "";
    }

    public d.a.i0.a.i1.g.c g() {
        return this.f42794c;
    }

    public j h() {
        if (this.f42792a == null) {
            d.a.i0.a.e0.d.g("video", "create player");
            j r0 = d.a.i0.a.c1.a.r0();
            r0.e(this.f42796e, this.f42794c);
            this.f42792a = r0;
            r0.g(new C0705a());
            this.f42792a.p(new b());
            this.f42792a.m(new c());
            this.f42792a.j(new d());
            this.f42792a.k(new e());
            this.f42792a.q(new f());
        }
        return this.f42792a;
    }

    @Override // d.a.i0.a.i1.a
    public Object i() {
        return this;
    }

    @Override // d.a.i0.a.i1.a
    public void j(boolean z) {
    }

    @Override // d.a.i0.a.i1.a
    public void k(boolean z) {
        this.f42797f = z;
        if (z) {
            if (this.f42795d) {
                h().resume();
            }
            h().b();
        } else if (this.f42792a != null) {
            this.f42795d = h().isPlaying();
            h().pause();
            h().c();
        }
    }

    public void l() {
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.f();
        }
    }

    public boolean m() {
        j jVar = this.f42792a;
        return jVar != null && jVar.isEnd();
    }

    public boolean n() {
        j jVar = this.f42792a;
        return jVar != null && jVar.isPlaying();
    }

    public void o(d.a.i0.a.i1.g.c cVar) {
        d.a.i0.a.e0.d.g("video", "Open Player " + cVar.n);
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.o(cVar);
        }
        this.f42794c = cVar;
    }

    @Override // d.a.i0.a.i1.a
    public boolean onBackPressed() {
        d.a.i0.a.e0.d.g("video", "onBackPressed");
        j jVar = this.f42792a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.i0.a.i1.a
    public void onDestroy() {
        d.a.i0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.stop();
            this.f42792a = null;
        }
        d.a.i0.a.i1.b.j(this);
    }

    public void p() {
        if (z()) {
            h().pause();
        }
    }

    public void q(String str) {
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.i(str);
        }
    }

    public void r() {
        j jVar;
        if (!z() || n() || !this.f42797f || (jVar = this.f42792a) == null) {
            return;
        }
        jVar.resume();
    }

    public void s(int i2) {
        j jVar;
        if (z() && (jVar = this.f42792a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.l(z, i2);
        }
    }

    public void u(d.a.i0.a.i1.g.b bVar) {
        this.f42798g = bVar;
    }

    public void v(boolean z) {
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.d(z);
        }
    }

    public void w(FrameLayout frameLayout) {
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    public void x(d.a.i0.a.i1.g.c cVar) {
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.n(cVar);
        }
    }

    public void y(d.a.i0.a.i1.g.c cVar) {
        if (f42791h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f42792a;
        if (jVar != null) {
            jVar.h(cVar, true);
        }
        this.f42794c = cVar;
    }

    public final boolean z() {
        d.a.i0.a.i1.g.c cVar = this.f42794c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f42793b) || TextUtils.isEmpty(this.f42794c.f40671f)) ? false : true;
    }
}
