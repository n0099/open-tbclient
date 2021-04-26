package d.a.j0.s.b.b;

import android.content.Context;
import android.provider.Settings;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.pyramid.annotation.Service;
import d.a.h0.a.p.c.t;
@Service
/* loaded from: classes4.dex */
public class c implements t {
    @Override // d.a.h0.a.p.c.t
    public String a(Context context) {
        return Settings.System.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
    }

    @Override // d.a.h0.a.p.c.t
    public String b(Context context) {
        return d.a.q.b.d(context).e();
    }
}
