package d.b.g0.a.b1.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.b.g0.a.p.c.r0;
/* loaded from: classes2.dex */
public class a implements d.b.g0.a.b1.a {

    /* renamed from: a  reason: collision with root package name */
    public r0 f43945a;

    /* renamed from: b  reason: collision with root package name */
    public String f43946b;

    /* renamed from: c  reason: collision with root package name */
    public c f43947c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43948d;

    /* renamed from: e  reason: collision with root package name */
    public Context f43949e;

    public a(Context context, @NonNull c cVar) {
        this.f43949e = context;
        this.f43947c = cVar;
        this.f43946b = cVar.n;
        i();
        g();
    }

    @Override // d.b.g0.a.b1.a
    public Object a() {
        return this;
    }

    @Override // d.b.g0.a.b1.a
    public String b() {
        return this.f43947c.f43506g;
    }

    @Override // d.b.g0.a.b1.a
    public String c() {
        return this.f43946b;
    }

    @Override // d.b.g0.a.b1.a
    public void d(boolean z) {
    }

    @Override // d.b.g0.a.b1.a
    public String e() {
        c cVar = this.f43947c;
        return cVar != null ? cVar.x : "";
    }

    @Override // d.b.g0.a.b1.a
    public void f(boolean z) {
        if (z) {
            if (this.f43948d) {
                i().resume();
            }
            i().a();
        } else if (this.f43945a != null) {
            this.f43948d = i().isPlaying();
            i().pause();
            i().b();
        }
    }

    public final void g() {
        if (TextUtils.isEmpty(this.f43946b)) {
            return;
        }
        d.b.g0.a.b1.b.a(this);
    }

    public c h() {
        return this.f43947c;
    }

    public r0 i() {
        if (this.f43945a == null) {
            d.b.g0.a.c0.c.g("VrVideo", "create player");
            this.f43945a = d.b.g0.a.w0.a.e0().create();
        }
        return this.f43945a;
    }

    public void j(c cVar) {
        d.b.g0.a.c0.c.g("VrVideo", "Open Player " + cVar.n);
        r0 r0Var = this.f43945a;
        if (r0Var != null) {
            r0Var.c(cVar, this.f43949e);
        }
        this.f43947c = cVar;
    }

    public void k(c cVar) {
        d.b.g0.a.c0.c.a("VrVideo", "update 接口");
        r0 r0Var = this.f43945a;
        if (r0Var != null) {
            r0Var.d(cVar, true);
        }
        this.f43947c = cVar;
    }

    @Override // d.b.g0.a.b1.a
    public boolean onBackPressed() {
        d.b.g0.a.c0.c.g("VrVideo", "onBackPressed");
        r0 r0Var = this.f43945a;
        return r0Var != null && r0Var.onBackPressed();
    }

    @Override // d.b.g0.a.b1.a
    public void onDestroy() {
        d.b.g0.a.c0.c.g("VrVideo", MissionEvent.MESSAGE_DESTROY);
        r0 r0Var = this.f43945a;
        if (r0Var != null) {
            r0Var.stop();
            this.f43945a = null;
        }
        d.b.g0.a.b1.b.j(this);
    }
}
