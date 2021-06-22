package d.a.m0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.h0.l.g.a {
    public static final boolean l = k.f46983a;

    public b(boolean z, boolean z2) {
        super(z, z2);
        if (l) {
            Log.d("PreloadMasterManagerMulti", "PreloadMasterManagerMulti created");
        }
    }

    public boolean w(PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
        if (this.f46029e == null || this.f46029e.f46048b == null) {
            return false;
        }
        return (pMSAppInfo.versionCode == this.f46029e.f46048b.versionCode && TextUtils.equals(pMSAppInfo.appId, this.f46029e.f46047a) && !m(cVar, this.f46029e.f46049c)) ? false : true;
    }
}
