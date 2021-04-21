package d.b.h0.a.b1.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.b.h0.a.k;
import d.b.h0.a.w0.c.j;
/* loaded from: classes2.dex */
public class a implements d.b.h0.a.b1.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44236h = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public j f44237a;

    /* renamed from: b  reason: collision with root package name */
    public String f44238b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.b1.g.c f44239c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44240d;

    /* renamed from: e  reason: collision with root package name */
    public Context f44241e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44242f = true;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.a.b1.g.b f44243g;

    /* renamed from: d.b.h0.a.b1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0643a implements j.a {
        public C0643a() {
        }

        @Override // d.b.h0.a.w0.c.j.a
        public void d(j jVar) {
            if (a.this.f44243g != null) {
                a.this.f44243g.d(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // d.b.h0.a.w0.c.j.b
        public boolean b(j jVar, int i, int i2) {
            return a.this.f44243g != null && a.this.f44243g.b(jVar, i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements j.d {
        public c() {
        }

        @Override // d.b.h0.a.w0.c.j.d
        public void a(j jVar) {
            if (a.this.f44243g != null) {
                a.this.f44243g.a(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements j.e {
        public d() {
        }

        @Override // d.b.h0.a.w0.c.j.e
        public void c(j jVar) {
            if (a.this.f44243g != null) {
                a.this.f44243g.c(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.b.h0.a.w0.c.j.f
        public void f(j jVar) {
            if (a.this.f44243g != null) {
                a.this.f44243g.f(jVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements j.c {
        public f() {
        }

        @Override // d.b.h0.a.w0.c.j.c
        public void e(j jVar) {
            if (a.this.f44243g != null) {
                a.this.f44243g.e(jVar);
            }
        }
    }

    public a(Context context, @NonNull d.b.h0.a.b1.g.c cVar) {
        this.f44241e = context;
        this.f44239c = cVar;
        this.f44238b = cVar.n;
        l();
        h();
    }

    public void A(d.b.h0.a.b1.g.c cVar) {
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.d(cVar);
        }
    }

    public void B(d.b.h0.a.b1.g.c cVar) {
        if (f44236h) {
            Log.e("SwanAppVideoPlayer", "update 接口");
        }
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.k(cVar, true);
        }
        this.f44239c = cVar;
    }

    public final boolean C() {
        d.b.h0.a.b1.g.c cVar = this.f44239c;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f44238b) || TextUtils.isEmpty(this.f44239c.f43834f)) ? false : true;
    }

    @Override // d.b.h0.a.b1.a
    public Object a() {
        return this;
    }

    @Override // d.b.h0.a.b1.a
    public String b() {
        return this.f44239c.f43835g;
    }

    @Override // d.b.h0.a.b1.a
    public String c() {
        return this.f44238b;
    }

    @Override // d.b.h0.a.b1.a
    public void d(boolean z) {
    }

    @Override // d.b.h0.a.b1.a
    public String e() {
        d.b.h0.a.b1.g.c cVar = this.f44239c;
        return cVar != null ? cVar.D : "";
    }

    @Override // d.b.h0.a.b1.a
    public void f(boolean z) {
        this.f44242f = z;
        if (z) {
            if (this.f44240d) {
                l().resume();
            }
            l().a();
        } else if (this.f44237a != null) {
            this.f44240d = l().isPlaying();
            l().pause();
            l().b();
        }
    }

    public final void h() {
        if (TextUtils.isEmpty(this.f44238b)) {
            return;
        }
        d.b.h0.a.b1.b.a(this);
    }

    public int i() {
        return l().getCurrentPosition();
    }

    public int j() {
        return l().getDuration();
    }

    public d.b.h0.a.b1.g.c k() {
        return this.f44239c;
    }

    public j l() {
        if (this.f44237a == null) {
            d.b.h0.a.c0.c.g("video", "create player");
            j d0 = d.b.h0.a.w0.a.d0();
            d0.c(this.f44241e, this.f44239c);
            this.f44237a = d0;
            d0.j(new C0643a());
            this.f44237a.g(new b());
            this.f44237a.q(new c());
            this.f44237a.m(new d());
            this.f44237a.n(new e());
            this.f44237a.p(new f());
        }
        return this.f44237a;
    }

    public void m() {
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.h();
        }
    }

    public boolean n() {
        j jVar = this.f44237a;
        return jVar != null && jVar.isEnd();
    }

    public boolean o() {
        j jVar = this.f44237a;
        return jVar != null && jVar.isPlaying();
    }

    @Override // d.b.h0.a.b1.a
    public boolean onBackPressed() {
        d.b.h0.a.c0.c.g("video", "onBackPressed");
        j jVar = this.f44237a;
        return jVar != null && jVar.onBackPressed();
    }

    @Override // d.b.h0.a.b1.a
    public void onDestroy() {
        d.b.h0.a.c0.c.g("video", MissionEvent.MESSAGE_DESTROY);
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.stop();
            this.f44237a = null;
        }
        d.b.h0.a.b1.b.j(this);
    }

    public void p(boolean z) {
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.mute(z);
        }
    }

    public void q(d.b.h0.a.b1.g.c cVar) {
        d.b.h0.a.c0.c.g("video", "Open Player " + cVar.n);
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.f(cVar);
        }
        this.f44239c = cVar;
    }

    public void r() {
        if (C()) {
            l().pause();
        }
    }

    public void s(String str) {
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.l(str);
        }
    }

    public void t() {
        j jVar;
        if (!C() || o() || !this.f44242f || (jVar = this.f44237a) == null) {
            return;
        }
        jVar.resume();
    }

    public void u(int i) {
        j jVar;
        if (C() && (jVar = this.f44237a) != null) {
            jVar.seekTo(i);
        }
    }

    public void v(boolean z, int i) {
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.o(z, i);
        }
    }

    public void w(d.b.h0.a.b1.g.b bVar) {
        this.f44243g = bVar;
    }

    public void x(boolean z) {
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.e(z);
        }
    }

    public void y(FrameLayout frameLayout) {
        j jVar = this.f44237a;
        if (jVar != null) {
            jVar.i(frameLayout);
        }
    }

    public void z(d.b.h0.a.b1.g.b bVar) {
        this.f44243g = bVar;
    }
}
