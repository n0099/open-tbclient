package d.a.h0.b.j;

import android.app.Activity;
import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import d.a.h0.a.p.c.o;
@Singleton
@Service
/* loaded from: classes3.dex */
public class b implements o {
    @Override // d.a.h0.a.p.c.o
    public void a(Context context, String str, String str2, d.a.h0.a.n.a.b bVar) {
        if (bVar == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            bVar.a(0);
        } else {
            d.a.h0.b.i.a.e((Activity) context, bVar);
        }
    }
}
