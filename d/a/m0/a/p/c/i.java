package d.a.m0.a.p.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.m0.a.p.d.n;
/* loaded from: classes2.dex */
public class i implements d.a.m0.a.p.d.n {

    /* renamed from: a  reason: collision with root package name */
    public Boolean f47746a;

    @Override // d.a.m0.a.p.d.n
    public void a(n.a aVar) {
        if (aVar != null) {
            aVar.onFinish();
        }
    }

    @Override // d.a.m0.a.p.d.n
    public void b(Activity activity, Bundle bundle, d.a.m0.a.m.a aVar) {
        d.a.m0.a.s.a.f.f48364d.i(aVar);
    }

    @Override // d.a.m0.a.p.d.n
    public void c(d.a.m0.a.m.c cVar) {
        if (cVar == null) {
            return;
        }
        d.a.m0.a.s.a.f.f48364d.m(cVar);
    }

    @Override // d.a.m0.a.p.d.n
    public String d(@NonNull Context context) {
        return d.a.m0.a.s.a.d.f48359a.a();
    }

    @Override // d.a.m0.a.p.d.n
    public boolean e(Context context) {
        boolean g2 = d.a.m0.a.s.a.f.f48364d.g();
        this.f47746a = Boolean.TRUE;
        return g2;
    }

    @Override // d.a.m0.a.p.d.n
    public String f(@NonNull Context context) {
        return d.a.m0.u.b.b(context).a();
    }

    @Override // d.a.m0.a.p.d.n
    public void g(n.c cVar) {
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // d.a.m0.a.p.d.n
    public String h(Context context) {
        return d.a.m0.a.s.a.h.f48375b.a();
    }

    @Override // d.a.m0.a.p.d.n
    public String i(@NonNull Context context) {
        return d.a.m0.u.b.b(context).a();
    }

    @Override // d.a.m0.a.p.d.n
    public void j(d.a.m0.a.m.a aVar) {
    }

    public boolean k(Context context) {
        if (this.f47746a == null) {
            e(context);
        }
        Boolean bool = this.f47746a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
