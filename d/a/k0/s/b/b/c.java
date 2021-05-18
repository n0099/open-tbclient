package d.a.k0.s.b.b;

import android.content.Context;
import android.provider.Settings;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.pyramid.annotation.Service;
import d.a.i0.a.p.d.c0;
@Service
/* loaded from: classes4.dex */
public class c implements c0 {
    @Override // d.a.i0.a.p.d.c0
    public String a(Context context) {
        return Settings.System.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
    }

    @Override // d.a.i0.a.p.d.c0
    public String b(Context context) {
        return d.a.q.b.d(context).e();
    }
}
