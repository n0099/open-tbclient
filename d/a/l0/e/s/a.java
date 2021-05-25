package d.a.l0.e.s;

import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import d.a.l0.a.p.d.e;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements e {
    @Override // d.a.l0.a.p.d.e
    public String a(Context context) {
        return context.getPackageName() + ".swan.fileprovider";
    }
}
