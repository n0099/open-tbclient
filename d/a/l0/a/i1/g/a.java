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
    public static final boolean f42965h = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public j f42966a;

    /* renamed from: b  reason: collision with root package name */
    public String f42967b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.i1.g.c f42968c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42969d;

    /* renamed from: e  reason: collision with root package name */
    public Context f42970e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42971f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.i1.g.b f42972g;

    /* renamed from: d.a.l0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0716a implements j.a {
        public C0716a() {
        }

        @Override // d.a.l0.a.c1.d.j.a
        public void b(j jVar) {
            if (a.this.f42972g != null) {
                a.this.f42972g.b(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.l0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            return a.this.f42972g != null && a.this.f42972g.f(jVar, i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.l0.a.c1.d.j.d
        public void e(j jVar) {
            if (a.this.f42972g != null) {
                a.this.f42972g.e(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.l0.a.c1.d.j.e
        public void a(j jVar) {
            if (a.this.f42972g != null) {
                a.this.f42972g.a(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.a.l0.a.c1.d.j.f
        public void d(j jVar) {
            if (a.this.f42972g != null) {
                a.this.f42972g.d(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.l0.a.c1.d.j.c
        public void c(j jVar) {
            if (a.this.f42972g != null) {
                a.this.f42972g.c(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.a.l0.a.i1.g.c cVar) {
        this.f42970e = context;
        this.f42968c = cVar;
        this.f42967b = cVar.n;
        h();
        d();
    }

    @Override // d.a.l0.a.i1.a
    public String b() {
        return this.f42968c.f40846g;
    }

    @Override // d.a.l0.a.i1.a
    public String c() {
        return this.f42967b;
    }

    public final void d() {
        if (TextUtils.isEmpty(this.f42967b)) {
            return;
        }
        d.a.l0.a.i1.b.a(this);
    }

    public int e() {
        return h().getCurrentPosition();
    }

    @Override // d.a.l0.a.i1.a
    public String f() {
        d.a.l0.a.i1.g.c cVar = this.f42968c;
        return cVar != null ? cVar.D : "";
    }

    public d.a.l0.a.i1.g.c g() {
        return this.f42968c;
    }

    public j h() {
        if (this.f42966a == null) {
            d.a.l0.a.e0.d.g("video", "create player");
            j r0 = d.a.l0.a.c1.a.r0();
            r0.e(this.f42970e, this.f42968c);
            this.f42966a = r0;
            r0.g(new C0716a());
            this.f42966a.p(new b());
            this.f42966a.m(new c());
            this.f42966a.j(new d());
            this.f42966a.k(new e());
            this.f42966a.q(new f());
        }
        return this.f42966a;
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
        this.f42971f = z;
        if (z) {
            if (this.f42969d) {
                h().resume();
            }
            h().b();
        } else if (this.f42966a != null) {
            this.f42969d = h().isPlaying();
            h().pause();
            h().c();
        }
    }

    public void l() {
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.f();
        }
    }

    public boolean m() {
        j jVar = this.f42966a;
        return jVar != null && jVar.isEnd();
    }

    public boolean n() {
        j jVar = this.f42966a;
        return jVar != null && jVar.isPlaying();
    }

    public void o(d.a.l0.a.i1.g.c cVar) {
        d.a.l0.a.e0.d.g("video", "Open Player " + cVar.n);
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.o(cVar);
        }
        this.f42968c = cVar;
    }

    @Override // d.a.l0.a.i1.a
    public boolean onBackPressed() {
        d.a.l0.a.e0.d.g("video", "onBackPressed");
        j jVar = this.f42966a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.l0.a.i1.a
    public void onDestroy() {
        d.a.l0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.stop();
            this.f42966a = null;
        }
        d.a.l0.a.i1.b.j(this);
    }

    public void p() {
        if (z()) {
            h().pause();
        }
    }

    public void q(String str) {
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.i(str);
        }
    }

    public void r() {
        j jVar;
        if (!z() || n() || !this.f42971f || (jVar = this.f42966a) == null) {
            return;
        }
        jVar.resume();
    }

    public void s(int i2) {
        j jVar;
        if (z() && (jVar = this.f42966a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.l(z, i2);
        }
    }

    public void u(d.a.l0.a.i1.g.b bVar) {
        this.f42972g = bVar;
    }

    public void v(boolean z) {
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.d(z);
        }
    }

    public void w(FrameLayout frameLayout) {
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.a(frameLayout);
        }
    }

    public void x(d.a.l0.a.i1.g.c cVar) {
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.n(cVar);
        }
    }

    public void y(d.a.l0.a.i1.g.c cVar) {
        if (f42965h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f42966a;
        if (jVar != null) {
            jVar.h(cVar, true);
        }
        this.f42968c = cVar;
    }

    public final boolean z() {
        d.a.l0.a.i1.g.c cVar = this.f42968c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f42967b) || TextUtils.isEmpty(this.f42968c.f40845f)) ? false : true;
    }
}
