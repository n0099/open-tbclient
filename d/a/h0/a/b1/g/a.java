package d.a.h0.a.b1.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.h0.a.k;
import d.a.h0.a.w0.c.j;
/* loaded from: classes3.dex */
public class a implements d.a.h0.a.b1.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f41518h = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public j f41519a;

    /* renamed from: b  reason: collision with root package name */
    public String f41520b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.b1.g.c f41521c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41522d;

    /* renamed from: e  reason: collision with root package name */
    public Context f41523e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41524f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.a.b1.g.b f41525g;

    /* renamed from: d.a.h0.a.b1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0582a implements j.a {
        public C0582a() {
        }

        @Override // d.a.h0.a.w0.c.j.a
        public void b(j jVar) {
            if (a.this.f41525g != null) {
                a.this.f41525g.b(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.a.h0.a.w0.c.j.b
        public boolean f(j jVar, int i2, int i3) {
            return a.this.f41525g != null && a.this.f41525g.f(jVar, i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.a.h0.a.w0.c.j.d
        public void e(j jVar) {
            if (a.this.f41525g != null) {
                a.this.f41525g.e(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.a.h0.a.w0.c.j.e
        public void a(j jVar) {
            if (a.this.f41525g != null) {
                a.this.f41525g.a(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.a.h0.a.w0.c.j.f
        public void d(j jVar) {
            if (a.this.f41525g != null) {
                a.this.f41525g.d(jVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.a.h0.a.w0.c.j.c
        public void c(j jVar) {
            if (a.this.f41525g != null) {
                a.this.f41525g.c(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.a.h0.a.b1.g.c cVar) {
        this.f41523e = context;
        this.f41521c = cVar;
        this.f41520b = cVar.n;
        l();
        h();
    }

    public void A(d.a.h0.a.b1.g.c cVar) {
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.m(cVar);
        }
    }

    public void B(d.a.h0.a.b1.g.c cVar) {
        if (f41518h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.g(cVar, true);
        }
        this.f41521c = cVar;
    }

    public final boolean C() {
        d.a.h0.a.b1.g.c cVar = this.f41521c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f41520b) || TextUtils.isEmpty(this.f41521c.f41092f)) ? false : true;
    }

    @Override // d.a.h0.a.b1.a
    public String a() {
        return this.f41521c.f41093g;
    }

    @Override // d.a.h0.a.b1.a
    public String b() {
        return this.f41520b;
    }

    @Override // d.a.h0.a.b1.a
    public String c() {
        d.a.h0.a.b1.g.c cVar = this.f41521c;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.a.h0.a.b1.a
    public Object d() {
        return this;
    }

    @Override // d.a.h0.a.b1.a
    public void e(boolean z) {
    }

    @Override // d.a.h0.a.b1.a
    public void f(boolean z) {
        this.f41524f = z;
        if (z) {
            if (this.f41522d) {
                l().resume();
            }
            l().a();
        } else if (this.f41519a != null) {
            this.f41522d = l().isPlaying();
            l().pause();
            l().b();
        }
    }

    public final void h() {
        if (TextUtils.isEmpty(this.f41520b)) {
            return;
        }
        d.a.h0.a.b1.b.a(this);
    }

    public int i() {
        return l().getCurrentPosition();
    }

    public int j() {
        return l().getDuration();
    }

    public d.a.h0.a.b1.g.c k() {
        return this.f41521c;
    }

    public j l() {
        if (this.f41519a == null) {
            d.a.h0.a.c0.c.g("video", "create player");
            j d0 = d.a.h0.a.w0.a.d0();
            d0.c(this.f41523e, this.f41521c);
            this.f41519a = d0;
            d0.f(new C0582a());
            this.f41519a.p(new b());
            this.f41519a.l(new c());
            this.f41519a.i(new d());
            this.f41519a.j(new e());
            this.f41519a.q(new f());
        }
        return this.f41519a;
    }

    public void m() {
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.d();
        }
    }

    public boolean n() {
        j jVar = this.f41519a;
        return jVar != null && jVar.isEnd();
    }

    public boolean o() {
        j jVar = this.f41519a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.a.h0.a.b1.a
    public boolean onBackPressed() {
        d.a.h0.a.c0.c.g("video", "onBackPressed");
        j jVar = this.f41519a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.a.h0.a.b1.a
    public void onDestroy() {
        d.a.h0.a.c0.c.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.stop();
            this.f41519a = null;
        }
        d.a.h0.a.b1.b.j(this);
    }

    public void p(boolean z) {
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public void q(d.a.h0.a.b1.g.c cVar) {
        d.a.h0.a.c0.c.g("video", "Open Player " + cVar.n);
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.o(cVar);
        }
        this.f41521c = cVar;
    }

    public void r() {
        if (C()) {
            l().pause();
        }
    }

    public void s(String str) {
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.h(str);
        }
    }

    public void t() {
        j jVar;
        if (!C() || o() || !this.f41524f || (jVar = this.f41519a) == null) {
            return;
        }
        jVar.resume();
    }

    public void u(int i2) {
        j jVar;
        if (C() && (jVar = this.f41519a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void v(boolean z, int i2) {
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.k(z, i2);
        }
    }

    public void w(d.a.h0.a.b1.g.b bVar) {
        this.f41525g = bVar;
    }

    public void x(boolean z) {
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.n(z);
        }
    }

    public void y(FrameLayout frameLayout) {
        j jVar = this.f41519a;
        if (jVar != null) {
            jVar.e(frameLayout);
        }
    }

    public void z(d.a.h0.a.b1.g.b bVar) {
        this.f41525g = bVar;
    }
}
