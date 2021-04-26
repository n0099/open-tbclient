package d.a.h0.a.b1.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.h0.a.p.c.r0;
/* loaded from: classes3.dex */
public class a implements d.a.h0.a.b1.a {

    /* renamed from: a  reason: collision with root package name */
    public r0 f41558a;

    /* renamed from: b  reason: collision with root package name */
    public String f41559b;

    /* renamed from: c  reason: collision with root package name */
    public c f41560c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41561d;

    /* renamed from: e  reason: collision with root package name */
    public Context f41562e;

    public a(Context context, @NonNull c cVar) {
        this.f41562e = context;
        this.f41560c = cVar;
        this.f41559b = cVar.n;
        i();
        g();
    }

    @Override // d.a.h0.a.b1.a
    public String a() {
        return this.f41560c.f41093g;
    }

    @Override // d.a.h0.a.b1.a
    public String b() {
        return this.f41559b;
    }

    @Override // d.a.h0.a.b1.a
    public String c() {
        c cVar = this.f41560c;
        return cVar != null ? cVar.x : "";
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
        if (z) {
            if (this.f41561d) {
                i().resume();
            }
            i().a();
        } else if (this.f41558a != null) {
            this.f41561d = i().isPlaying();
            i().pause();
            i().b();
        }
    }

    public final void g() {
        if (TextUtils.isEmpty(this.f41559b)) {
            return;
        }
        d.a.h0.a.b1.b.a(this);
    }

    public c h() {
        return this.f41560c;
    }

    public r0 i() {
        if (this.f41558a == null) {
            d.a.h0.a.c0.c.g("VrVideo", "create player");
            this.f41558a = d.a.h0.a.w0.a.e0().create();
        }
        return this.f41558a;
    }

    public void j(c cVar) {
        d.a.h0.a.c0.c.g("VrVideo", "Open Player " + cVar.n);
        r0 r0Var = this.f41558a;
        if (r0Var != null) {
            r0Var.d(cVar, this.f41562e);
        }
        this.f41560c = cVar;
    }

    public void k(c cVar) {
        d.a.h0.a.c0.c.a("VrVideo", "update 接口");
        r0 r0Var = this.f41558a;
        if (r0Var != null) {
            r0Var.c(cVar, true);
        }
        this.f41560c = cVar;
    }

    @Override // d.a.h0.a.b1.a
    public boolean onBackPressed() {
        d.a.h0.a.c0.c.g("VrVideo", "onBackPressed");
        r0 r0Var = this.f41558a;
        return r0Var != null && r0Var.onBackPressed();
    }

    @Override // d.a.h0.a.b1.a
    public void onDestroy() {
        d.a.h0.a.c0.c.g("VrVideo", MissionEvent.MESSAGE_DESTROY);
        r0 r0Var = this.f41558a;
        if (r0Var != null) {
            r0Var.stop();
            this.f41558a = null;
        }
        d.a.h0.a.b1.b.j(this);
    }
}
