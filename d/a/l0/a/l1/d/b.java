package d.a.l0.a.l1.d;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47047a = k.f46875a;

    public static String a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            if (f47047a) {
                Log.e("AppInfoExt", "appInfo can not be null, please check");
                return "";
            }
            return "";
        }
        String str = pMSAppInfo.serverExt;
        if (f47047a) {
            Log.d("AppInfoExt", "appId - " + pMSAppInfo.appId + ",get app info' ext - " + str);
        }
        return str;
    }
}
