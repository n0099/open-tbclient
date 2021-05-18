package d.a.i0.a.p.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.i0.a.p.d.n;
/* loaded from: classes2.dex */
public class i implements d.a.i0.a.p.d.n {

    /* renamed from: a  reason: collision with root package name */
    public Boolean f43788a;

    @Override // d.a.i0.a.p.d.n
    public void a(n.a aVar) {
        if (aVar != null) {
            aVar.onFinish();
        }
    }

    @Override // d.a.i0.a.p.d.n
    public void b(Activity activity, Bundle bundle, d.a.i0.a.m.a aVar) {
        d.a.i0.a.s.a.f.f44406d.i(aVar);
    }

    @Override // d.a.i0.a.p.d.n
    public void c(d.a.i0.a.m.c cVar) {
        if (cVar == null) {
            return;
        }
        d.a.i0.a.s.a.f.f44406d.m(cVar);
    }

    @Override // d.a.i0.a.p.d.n
    public String d(@NonNull Context context) {
        return d.a.i0.a.s.a.d.f44401a.a();
    }

    @Override // d.a.i0.a.p.d.n
    public boolean e(Context context) {
        boolean g2 = d.a.i0.a.s.a.f.f44406d.g();
        this.f43788a = Boolean.TRUE;
        return g2;
    }

    @Override // d.a.i0.a.p.d.n
    public String f(@NonNull Context context) {
        return d.a.i0.u.b.b(context).a();
    }

    @Override // d.a.i0.a.p.d.n
    public void g(n.c cVar) {
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // d.a.i0.a.p.d.n
    public String h(Context context) {
        return d.a.i0.a.s.a.h.f44417b.a();
    }

    @Override // d.a.i0.a.p.d.n
    public String i(@NonNull Context context) {
        return d.a.i0.u.b.b(context).a();
    }

    @Override // d.a.i0.a.p.d.n
    public void j(d.a.i0.a.m.a aVar) {
    }

    public boolean k(Context context) {
        if (this.f43788a == null) {
            e(context);
        }
        Boolean bool = this.f43788a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
