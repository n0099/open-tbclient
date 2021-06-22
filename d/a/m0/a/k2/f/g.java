package d.a.m0.a.k2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class g extends a {
    @Override // d.a.m0.a.k2.f.a
    @NonNull
    public String c() {
        String z = d.a.m0.a.k2.b.z(d.a.m0.a.a2.d.g().getAppId());
        return TextUtils.isEmpty(z) ? "" : z;
    }

    @Override // d.a.m0.a.k2.f.e
    public long getMaxSize() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }
}
