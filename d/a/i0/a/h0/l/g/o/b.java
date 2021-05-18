package d.a.i0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.h0.l.g.a {
    public static final boolean l = k.f43025a;

    public b(boolean z, boolean z2) {
        super(z, z2);
        if (l) {
            Log.d("PreloadMasterManagerMulti", "PreloadMasterManagerMulti created");
        }
    }

    public boolean w(PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
        if (this.f42071e == null || this.f42071e.f42090b == null) {
            return false;
        }
        return (pMSAppInfo.versionCode == this.f42071e.f42090b.versionCode && TextUtils.equals(pMSAppInfo.appId, this.f42071e.f42089a) && !m(cVar, this.f42071e.f42091c)) ? false : true;
    }
}
