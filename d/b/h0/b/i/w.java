package d.b.h0.b.i;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
@Singleton
@Service
/* loaded from: classes3.dex */
public class w implements d.b.h0.a.p.c.e {
    @Override // d.b.h0.a.p.c.e
    public String a(Context context) {
        return a.y(context);
    }

    @Override // d.b.h0.a.p.c.e
    public void b(Activity activity, Bundle bundle, d.b.h0.a.m.a aVar) {
        a.P(activity, false, bundle, aVar);
    }

    @Override // d.b.h0.a.p.c.e
    public String c(@NonNull Context context) {
        return a.l(context);
    }

    @Override // d.b.h0.a.p.c.e
    public void d(d.b.h0.a.m.c cVar) {
        a.c(cVar);
    }

    @Override // d.b.h0.a.p.c.e
    public String e(@NonNull Context context) {
        return a.i(context);
    }

    @Override // d.b.h0.a.p.c.e
    public void f(d.b.h0.a.m.a aVar) {
        new d.b.h0.b.m.d.a().h(aVar);
    }

    @Override // d.b.h0.a.p.c.e
    public boolean g(Context context) {
        return a.I(context);
    }
}
