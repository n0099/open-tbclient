package d.a.l0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class b extends d.a.l0.a.h0.l.g.a {
    public static final boolean l = k.f46875a;

    public b(boolean z, boolean z2) {
        super(z, z2);
        if (l) {
            Log.d("PreloadMasterManagerMulti", "PreloadMasterManagerMulti created");
        }
    }

    public boolean w(PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
        if (this.f45921e == null || this.f45921e.f45940b == null) {
            return false;
        }
        return (pMSAppInfo.versionCode == this.f45921e.f45940b.versionCode && TextUtils.equals(pMSAppInfo.appId, this.f45921e.f45939a) && !m(cVar, this.f45921e.f45941c)) ? false : true;
    }
}
