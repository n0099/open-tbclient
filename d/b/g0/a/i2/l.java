package d.b.g0.a.i2;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f45112a;

    public static String a() {
        if (TextUtils.isEmpty(f45112a)) {
            synchronized (l.class) {
                f45112a = b();
            }
        }
        return f45112a;
    }

    public static String b() {
        String str = Build.MODEL;
        String replace = TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
        String str2 = Build.VERSION.RELEASE;
        String replace2 = TextUtils.isEmpty(str2) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str2.replace("_", "-");
        int i = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        String replace3 = TextUtils.isEmpty(str3) ? "NUL" : str3.replace("_", "-");
        return replace + "_" + replace2 + "_" + i + "_" + replace3;
    }
}
