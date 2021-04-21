package d.b.h0.a.b1.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.b.h0.a.p.c.r0;
/* loaded from: classes2.dex */
public class a implements d.b.h0.a.b1.a {

    /* renamed from: a  reason: collision with root package name */
    public r0 f44274a;

    /* renamed from: b  reason: collision with root package name */
    public String f44275b;

    /* renamed from: c  reason: collision with root package name */
    public c f44276c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44277d;

    /* renamed from: e  reason: collision with root package name */
    public Context f44278e;

    public a(Context context, @NonNull c cVar) {
        this.f44278e = context;
        this.f44276c = cVar;
        this.f44275b = cVar.n;
        i();
        g();
    }

    @Override // d.b.h0.a.b1.a
    public Object a() {
        return this;
    }

    @Override // d.b.h0.a.b1.a
    public String b() {
        return this.f44276c.f43835g;
    }

    @Override // d.b.h0.a.b1.a
    public String c() {
        return this.f44275b;
    }

    @Override // d.b.h0.a.b1.a
    public void d(boolean z) {
    }

    @Override // d.b.h0.a.b1.a
    public String e() {
        c cVar = this.f44276c;
        return cVar != null ? cVar.x : "";
    }

    @Override // d.b.h0.a.b1.a
    public void f(boolean z) {
        if (z) {
            if (this.f44277d) {
                i().resume();
            }
            i().a();
        } else if (this.f44274a != null) {
            this.f44277d = i().isPlaying();
            i().pause();
            i().b();
        }
    }

    public final void g() {
        if (TextUtils.isEmpty(this.f44275b)) {
            return;
        }
        d.b.h0.a.b1.b.a(this);
    }

    public c h() {
        return this.f44276c;
    }

    public r0 i() {
        if (this.f44274a == null) {
            d.b.h0.a.c0.c.g("VrVideo", "create player");
            this.f44274a = d.b.h0.a.w0.a.e0().create();
        }
        return this.f44274a;
    }

    public void j(c cVar) {
        d.b.h0.a.c0.c.g("VrVideo", "Open Player " + cVar.n);
        r0 r0Var = this.f44274a;
        if (r0Var != null) {
            r0Var.c(cVar, this.f44278e);
        }
        this.f44276c = cVar;
    }

    public void k(c cVar) {
        d.b.h0.a.c0.c.a("VrVideo", "update 接口");
        r0 r0Var = this.f44274a;
        if (r0Var != null) {
            r0Var.d(cVar, true);
        }
        this.f44276c = cVar;
    }

    @Override // d.b.h0.a.b1.a
    public boolean onBackPressed() {
        d.b.h0.a.c0.c.g("VrVideo", "onBackPressed");
        r0 r0Var = this.f44274a;
        return r0Var != null && r0Var.onBackPressed();
    }

    @Override // d.b.h0.a.b1.a
    public void onDestroy() {
        d.b.h0.a.c0.c.g("VrVideo", MissionEvent.MESSAGE_DESTROY);
        r0 r0Var = this.f44274a;
        if (r0Var != null) {
            r0Var.stop();
            this.f44274a = null;
        }
        d.b.h0.a.b1.b.j(this);
    }
}
