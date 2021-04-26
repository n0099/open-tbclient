package d.a.h0.b.i;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
@Singleton
@Service
/* loaded from: classes3.dex */
public class w implements d.a.h0.a.p.c.e {
    @Override // d.a.h0.a.p.c.e
    public void a(Activity activity, Bundle bundle, d.a.h0.a.m.a aVar) {
        a.P(activity, false, bundle, aVar);
    }

    @Override // d.a.h0.a.p.c.e
    public void b(d.a.h0.a.m.c cVar) {
        a.c(cVar);
    }

    @Override // d.a.h0.a.p.c.e
    public String c(@NonNull Context context) {
        return a.i(context);
    }

    @Override // d.a.h0.a.p.c.e
    public boolean d(Context context) {
        return a.I(context);
    }

    @Override // d.a.h0.a.p.c.e
    public String e(Context context) {
        return a.y(context);
    }

    @Override // d.a.h0.a.p.c.e
    public String f(@NonNull Context context) {
        return a.l(context);
    }

    @Override // d.a.h0.a.p.c.e
    public void g(d.a.h0.a.m.a aVar) {
        new d.a.h0.b.m.d.a().h(aVar);
    }
}
