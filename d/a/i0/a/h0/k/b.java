package d.a.i0.a.h0.k;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42033a = k.f43025a;

    public b(d.a.i0.a.h0.f.a aVar) {
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (f42033a) {
            Log.d("DaemonJsBridge", "slave id: " + str + " data: " + str2);
        }
        int i2 = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            i2 = 202;
        } else {
            d.a.i0.a.g1.f.V().z(new d.a.i0.a.o0.d.d(str, str2), false);
        }
        return UnitedSchemeUtility.wrapCallbackParams(i2).toString();
    }
}
