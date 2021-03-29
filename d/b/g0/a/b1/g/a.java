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
    public static final boolean f43515h = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public j f43516a;

    /* renamed from: b  reason: collision with root package name */
    public String f43517b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.b1.g.c f43518c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43519d;

    /* renamed from: e  reason: collision with root package name */
    public Context f43520e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43521f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.a.b1.g.b f43522g;

    /* renamed from: d.b.g0.a.b1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0611a implements j.a {
        public C0611a() {
        }

        @Override // d.b.g0.a.w0.c.j.a
        public void d(j jVar) {
            if (a.this.f43522g != null) {
                a.this.f43522g.d(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.b.g0.a.w0.c.j.b
        public boolean b(j jVar, int i, int i2) {
            return a.this.f43522g != null && a.this.f43522g.b(jVar, i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.b.g0.a.w0.c.j.d
        public void a(j jVar) {
            if (a.this.f43522g != null) {
                a.this.f43522g.a(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.b.g0.a.w0.c.j.e
        public void c(j jVar) {
            if (a.this.f43522g != null) {
                a.this.f43522g.c(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.b.g0.a.w0.c.j.f
        public void f(j jVar) {
            if (a.this.f43522g != null) {
                a.this.f43522g.f(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.b.g0.a.w0.c.j.c
        public void e(j jVar) {
            if (a.this.f43522g != null) {
                a.this.f43522g.e(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.b.g0.a.b1.g.c cVar) {
        this.f43520e = context;
        this.f43518c = cVar;
        this.f43517b = cVar.n;
        l();
        h();
    }

    public void A(d.b.g0.a.b1.g.c cVar) {
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.d(cVar);
        }
    }

    public void B(d.b.g0.a.b1.g.c cVar) {
        if (f43515h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.k(cVar, true);
        }
        this.f43518c = cVar;
    }

    public final boolean C() {
        d.b.g0.a.b1.g.c cVar = this.f43518c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f43517b) || TextUtils.isEmpty(this.f43518c.f43113f)) ? false : true;
    }

    @Override // d.b.g0.a.b1.a
    public Object a() {
        return this;
    }

    @Override // d.b.g0.a.b1.a
    public String b() {
        return this.f43518c.f43114g;
    }

    @Override // d.b.g0.a.b1.a
    public String c() {
        return this.f43517b;
    }

    @Override // d.b.g0.a.b1.a
    public void d(boolean z) {
    }

    @Override // d.b.g0.a.b1.a
    public String e() {
        d.b.g0.a.b1.g.c cVar = this.f43518c;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.b.g0.a.b1.a
    public void f(boolean z) {
        this.f43521f = z;
        if (z) {
            if (this.f43519d) {
                l().resume();
            }
            l().a();
        } else if (this.f43516a != null) {
            this.f43519d = l().isPlaying();
            l().pause();
            l().b();
        }
    }

    public final void h() {
        if (TextUtils.isEmpty(this.f43517b)) {
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
        return this.f43518c;
    }

    public j l() {
        if (this.f43516a == null) {
            d.b.g0.a.c0.c.g("video", "create player");
            j d0 = d.b.g0.a.w0.a.d0();
            d0.c(this.f43520e, this.f43518c);
            this.f43516a = d0;
            d0.j(new C0611a());
            this.f43516a.g(new b());
            this.f43516a.q(new c());
            this.f43516a.m(new d());
            this.f43516a.n(new e());
            this.f43516a.p(new f());
        }
        return this.f43516a;
    }

    public void m() {
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.h();
        }
    }

    public boolean n() {
        j jVar = this.f43516a;
        return jVar != null && jVar.isEnd();
    }

    public boolean o() {
        j jVar = this.f43516a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.b.g0.a.b1.a
    public boolean onBackPressed() {
        d.b.g0.a.c0.c.g("video", "onBackPressed");
        j jVar = this.f43516a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.b.g0.a.b1.a
    public void onDestroy() {
        d.b.g0.a.c0.c.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.stop();
            this.f43516a = null;
        }
        d.b.g0.a.b1.b.j(this);
    }

    public void p(boolean z) {
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public void q(d.b.g0.a.b1.g.c cVar) {
        d.b.g0.a.c0.c.g("video", "Open Player " + cVar.n);
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.f(cVar);
        }
        this.f43518c = cVar;
    }

    public void r() {
        if (C()) {
            l().pause();
        }
    }

    public void s(String str) {
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.l(str);
        }
    }

    public void t() {
        j jVar;
        if (!C() || o() || !this.f43521f || (jVar = this.f43516a) == null) {
            return;
        }
        jVar.resume();
    }

    public void u(int i) {
        j jVar;
        if (C() && (jVar = this.f43516a) != null) {
            jVar.seekTo(i);
        }
    }

    public void v(boolean z, int i) {
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.o(z, i);
        }
    }

    public void w(d.b.g0.a.b1.g.b bVar) {
        this.f43522g = bVar;
    }

    public void x(boolean z) {
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.e(z);
        }
    }

    public void y(FrameLayout frameLayout) {
        j jVar = this.f43516a;
        if (jVar != null) {
            jVar.i(frameLayout);
        }
    }

    public void z(d.b.g0.a.b1.g.b bVar) {
        this.f43522g = bVar;
    }
}
