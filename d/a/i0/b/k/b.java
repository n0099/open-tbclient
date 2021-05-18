package d.a.i0.b.k;

import android.app.Activity;
import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import d.a.i0.a.p.d.w;
@Singleton
@Service
/* loaded from: classes3.dex */
public class b implements w {
    @Override // d.a.i0.a.p.d.w
    public void a(Context context, String str, String str2, d.a.i0.a.n.a.b bVar) {
        if (bVar == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            bVar.a(0);
        } else {
            d.a.i0.b.j.a.e((Activity) context, bVar);
        }
    }
}
