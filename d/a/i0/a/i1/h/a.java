package d.a.i0.a.i1.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.i0.a.e0.d;
import d.a.i0.a.p.d.c1;
/* loaded from: classes3.dex */
public class a implements d.a.i0.a.i1.a {

    /* renamed from: a  reason: collision with root package name */
    public c1 f42831a;

    /* renamed from: b  reason: collision with root package name */
    public String f42832b;

    /* renamed from: c  reason: collision with root package name */
    public c f42833c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42834d;

    /* renamed from: e  reason: collision with root package name */
    public Context f42835e;

    public a(Context context, @NonNull c cVar) {
        this.f42835e = context;
        this.f42833c = cVar;
        this.f42832b = cVar.n;
        e();
        a();
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f42832b)) {
            return;
        }
        d.a.i0.a.i1.b.a(this);
    }

    @Override // d.a.i0.a.i1.a
    public String b() {
        return this.f42833c.f40672g;
    }

    @Override // d.a.i0.a.i1.a
    public String c() {
        return this.f42832b;
    }

    public c d() {
        return this.f42833c;
    }

    public c1 e() {
        if (this.f42831a == null) {
            d.g("VrVideo", "create player");
            this.f42831a = d.a.i0.a.c1.a.s0().create();
        }
        return this.f42831a;
    }

    @Override // d.a.i0.a.i1.a
    public String f() {
        c cVar = this.f42833c;
        return cVar != null ? cVar.x : "";
    }

    public void g(c cVar) {
        d.g("VrVideo", "Open Player " + cVar.n);
        c1 c1Var = this.f42831a;
        if (c1Var != null) {
            c1Var.e(cVar, this.f42835e);
        }
        this.f42833c = cVar;
    }

    public void h(c cVar) {
        d.a("VrVideo", "update 接口");
        c1 c1Var = this.f42831a;
        if (c1Var != null) {
            c1Var.d(cVar, true);
        }
        this.f42833c = cVar;
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
        if (z) {
            if (this.f42834d) {
                e().resume();
            }
            e().b();
        } else if (this.f42831a != null) {
            this.f42834d = e().isPlaying();
            e().pause();
            e().c();
        }
    }

    @Override // d.a.i0.a.i1.a
    public boolean onBackPressed() {
        d.g("VrVideo", "onBackPressed");
        c1 c1Var = this.f42831a;
        return c1Var != null && c1Var.onBackPressed();
    }

    @Override // d.a.i0.a.i1.a
    public void onDestroy() {
        d.g("VrVideo", MissionEvent.MESSAGE_DESTROY);
        c1 c1Var = this.f42831a;
        if (c1Var != null) {
            c1Var.stop();
            this.f42831a = null;
        }
        d.a.i0.a.i1.b.j(this);
    }
}
