package d.a.l0.a.h0.o.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.a1.e;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42510a = k.f43199a;

    public static a a(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.appCategory != 0) {
            return null;
        }
        File i2 = e.C0561e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (!i2.exists()) {
            if (f42510a) {
                Log.w("PrefetchUtils", "aiapp dir not exist ");
            }
            return null;
        }
        a aVar = new a();
        if (new File(i2, "app.json").exists()) {
            if (f42510a) {
                Log.d("PrefetchUtils", "find main pkg's app config file");
            }
            aVar.f42507a = i2;
            return aVar;
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            String g2 = o0.g(str);
            int lastIndexOf = g2.lastIndexOf(File.separator);
            if (lastIndexOf >= 0) {
                g2 = g2.substring(0, lastIndexOf);
            }
            if (new File(i2, g2).exists()) {
                int lastIndexOf2 = g2.lastIndexOf(File.separator);
                while (lastIndexOf2 >= 0) {
                    g2 = g2.substring(0, lastIndexOf2);
                    if (new File(i2, g2 + File.separator + "app.json").exists()) {
                        if (f42510a) {
                            Log.d("PrefetchUtils", "isInDependentPkg=true, pagePath=" + g2);
                        }
                        aVar.f42508b = true;
                        aVar.f42509c = g2;
                        aVar.f42507a = new File(i2, g2);
                        return aVar;
                    }
                    lastIndexOf2 = g2.lastIndexOf(File.separator);
                }
                return null;
            }
            return null;
        }
    }
}
