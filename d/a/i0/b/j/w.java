package d.a.i0.b.j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import d.a.i0.a.p.d.n;
@Singleton
@Service
/* loaded from: classes3.dex */
public class w implements d.a.i0.a.p.d.n {
    @Override // d.a.i0.a.p.d.n
    public void a(n.a aVar) {
        aVar.onFinish();
    }

    @Override // d.a.i0.a.p.d.n
    public void b(Activity activity, Bundle bundle, d.a.i0.a.m.a aVar) {
        a.N(activity, false, bundle, aVar);
    }

    @Override // d.a.i0.a.p.d.n
    public void c(d.a.i0.a.m.c cVar) {
        a.c(cVar);
    }

    @Override // d.a.i0.a.p.d.n
    public String d(@NonNull Context context) {
        return a.i(context);
    }

    @Override // d.a.i0.a.p.d.n
    public boolean e(Context context) {
        return a.G(context);
    }

    @Override // d.a.i0.a.p.d.n
    public String f(@NonNull Context context) {
        return a.l(context);
    }

    @Override // d.a.i0.a.p.d.n
    public void g(n.c cVar) {
        cVar.a(true);
    }

    @Override // d.a.i0.a.p.d.n
    public String h(Context context) {
        return a.y(context);
    }

    @Override // d.a.i0.a.p.d.n
    public String i(@NonNull Context context) {
        return a.l(context);
    }

    @Override // d.a.i0.a.p.d.n
    public void j(d.a.i0.a.m.a aVar) {
        new d.a.i0.b.n.d.a().h(aVar);
    }
}
