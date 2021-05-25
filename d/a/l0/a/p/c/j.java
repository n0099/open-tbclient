package d.a.l0.a.p.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.l0.a.p.d.n;
/* loaded from: classes2.dex */
public class j implements d.a.l0.a.p.d.n {

    /* renamed from: a  reason: collision with root package name */
    public Boolean f43964a;

    @Override // d.a.l0.a.p.d.n
    public void a(n.a aVar) {
        if (aVar != null) {
            aVar.onFinish();
        }
    }

    @Override // d.a.l0.a.p.d.n
    public void b(Activity activity, Bundle bundle, d.a.l0.a.m.a aVar) {
        d.a.l0.a.s.a.f.f44582d.i(aVar);
    }

    @Override // d.a.l0.a.p.d.n
    public void c(d.a.l0.a.m.c cVar) {
        if (cVar == null) {
            return;
        }
        d.a.l0.a.s.a.f.f44582d.m(cVar);
    }

    @Override // d.a.l0.a.p.d.n
    public String d(@NonNull Context context) {
        return d.a.l0.a.s.a.d.f44577a.a();
    }

    @Override // d.a.l0.a.p.d.n
    public boolean e(Context context) {
        boolean g2 = d.a.l0.a.s.a.f.f44582d.g();
        this.f43964a = Boolean.TRUE;
        return g2;
    }

    @Override // d.a.l0.a.p.d.n
    public String f(@NonNull Context context) {
        return d.a.l0.u.b.b(context).a();
    }

    @Override // d.a.l0.a.p.d.n
    public void g(n.c cVar) {
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // d.a.l0.a.p.d.n
    public String h(Context context) {
        return d.a.l0.a.s.a.h.f44593b.a();
    }

    @Override // d.a.l0.a.p.d.n
    public String i(@NonNull Context context) {
        return d.a.l0.u.b.b(context).a();
    }

    @Override // d.a.l0.a.p.d.n
    public void j(d.a.l0.a.m.a aVar) {
    }

    public boolean k(Context context) {
        if (this.f43964a == null) {
            e(context);
        }
        Boolean bool = this.f43964a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
