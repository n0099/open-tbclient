package d.b.i0.s.b.b;

import android.content.Context;
import android.provider.Settings;
import com.baidu.pyramid.annotation.Service;
import d.b.g0.a.p.c.t;
@Service
/* loaded from: classes4.dex */
public class c implements t {
    @Override // d.b.g0.a.p.c.t
    public String a(Context context) {
        return d.b.q.b.d(context).e();
    }

    @Override // d.b.g0.a.p.c.t
    public String getAndroidId(Context context) {
        return Settings.System.getString(context.getContentResolver(), "android_id");
    }
}
