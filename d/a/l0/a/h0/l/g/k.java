package d.a.l0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class k extends a {
    public static final boolean l = d.a.l0.a.k.f43199a;

    public k(boolean z, boolean z2) {
        super(z, z2);
        if (l) {
            Log.d("PreloadMasterManager", "PreloadMasterManagerSingle created");
        }
    }

    @Override // d.a.l0.a.h0.l.g.a
    public boolean k(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        PMSAppInfo g2 = g();
        if (g2 == null) {
            return false;
        }
        if (!TextUtils.equals(pMSAppInfo.appId, g2.appId)) {
            if (l) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
            return true;
        } else if (w(pMSAppInfo, cVar)) {
            if (l) {
                Log.w("PreloadMasterManager", "prefetch app is not the same !!!!");
                Log.w("PreloadMasterManager", "bind app info - " + g());
                Log.w("PreloadMasterManager", "prefetch app info - " + pMSAppInfo);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean w(PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
        PMSAppInfo g2 = g();
        if (this.f42243c == null) {
            return false;
        }
        return (pMSAppInfo.versionCode == g2.versionCode && TextUtils.equals(pMSAppInfo.appId, g2.appId) && !m(cVar, this.f42244d)) ? false : true;
    }
}
