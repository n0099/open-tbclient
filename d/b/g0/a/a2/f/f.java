package d.b.g0.a.a2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
/* loaded from: classes2.dex */
public class f extends a {
    @Override // d.b.g0.a.a2.f.a
    @NonNull
    public String c() {
        String j = d.b.g0.a.a2.b.j(d.b.g0.a.r1.d.e().getAppId());
        return TextUtils.isEmpty(j) ? "" : j;
    }

    @Override // d.b.g0.a.a2.f.d
    public long getMaxSize() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }
}
