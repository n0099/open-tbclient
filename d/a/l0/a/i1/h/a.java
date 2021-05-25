package d.a.l0.a.i1.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.l0.a.e0.d;
import d.a.l0.a.p.d.c1;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.i1.a {

    /* renamed from: a  reason: collision with root package name */
    public c1 f43005a;

    /* renamed from: b  reason: collision with root package name */
    public String f43006b;

    /* renamed from: c  reason: collision with root package name */
    public c f43007c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43008d;

    /* renamed from: e  reason: collision with root package name */
    public Context f43009e;

    public a(Context context, @NonNull c cVar) {
        this.f43009e = context;
        this.f43007c = cVar;
        this.f43006b = cVar.n;
        e();
        a();
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f43006b)) {
            return;
        }
        d.a.l0.a.i1.b.a(this);
    }

    @Override // d.a.l0.a.i1.a
    public String b() {
        return this.f43007c.f40846g;
    }

    @Override // d.a.l0.a.i1.a
    public String c() {
        return this.f43006b;
    }

    public c d() {
        return this.f43007c;
    }

    public c1 e() {
        if (this.f43005a == null) {
            d.g("VrVideo", "create player");
            this.f43005a = d.a.l0.a.c1.a.s0().create();
        }
        return this.f43005a;
    }

    @Override // d.a.l0.a.i1.a
    public String f() {
        c cVar = this.f43007c;
        return cVar != null ? cVar.x : "";
    }

    public void g(c cVar) {
        d.g("VrVideo", "Open Player " + cVar.n);
        c1 c1Var = this.f43005a;
        if (c1Var != null) {
            c1Var.e(cVar, this.f43009e);
        }
        this.f43007c = cVar;
    }

    public void h(c cVar) {
        d.a("VrVideo", "update 接口");
        c1 c1Var = this.f43005a;
        if (c1Var != null) {
            c1Var.d(cVar, true);
        }
        this.f43007c = cVar;
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
        if (z) {
            if (this.f43008d) {
                e().resume();
            }
            e().b();
        } else if (this.f43005a != null) {
            this.f43008d = e().isPlaying();
            e().pause();
            e().c();
        }
    }

    @Override // d.a.l0.a.i1.a
    public boolean onBackPressed() {
        d.g("VrVideo", "onBackPressed");
        c1 c1Var = this.f43005a;
        return c1Var != null && c1Var.onBackPressed();
    }

    @Override // d.a.l0.a.i1.a
    public void onDestroy() {
        d.g("VrVideo", MissionEvent.MESSAGE_DESTROY);
        c1 c1Var = this.f43005a;
        if (c1Var != null) {
            c1Var.stop();
            this.f43005a = null;
        }
        d.a.l0.a.i1.b.j(this);
    }
}
