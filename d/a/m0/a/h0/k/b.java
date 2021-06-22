package d.a.m0.a.h0.k;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45991a = k.f46983a;

    public b(d.a.m0.a.h0.f.a aVar) {
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (f45991a) {
            Log.d("DaemonJsBridge", "slave id: " + str + " data: " + str2);
        }
        int i2 = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            i2 = 202;
        } else {
            d.a.m0.a.g1.f.V().z(new d.a.m0.a.o0.d.d(str, str2), false);
        }
        return UnitedSchemeUtility.wrapCallbackParams(i2).toString();
    }
}
