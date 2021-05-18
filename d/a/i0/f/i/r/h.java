package d.a.i0.f.i.r;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f46657a;

    public static int a(float f2) {
        return (int) (f2 * d(AppRuntime.getAppContext()));
    }

    public static String b() {
        String substring = new a().a(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String s = d.a.i0.f.i.m.a.b().s();
        return "38" + substring + s.substring(0, 4);
    }

    public static String c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(";");
            int length = split.length;
            for (int i2 = 0; i2 != length; i2++) {
                String trim = split[i2].trim();
                String[] split2 = trim.split("=");
                if (split2.length >= 2 && TextUtils.equals(str2, split2[0])) {
                    if (split2.length == 2) {
                        return split2[1];
                    }
                    return trim.substring(split2[0].length() + 1);
                }
            }
        }
        return null;
    }

    public static float d(Context context) {
        n(AppRuntime.getAppContext());
        DisplayMetrics displayMetrics = f46657a;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static String e() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
    }

    public static String f() {
        String str = Build.VERSION.RELEASE;
        return TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
    }

    public static String g() {
        String str = Build.MANUFACTURER;
        return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
    }

    public static int h(Context context) {
        n(AppRuntime.getAppContext());
        DisplayMetrics displayMetrics = f46657a;
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return 0;
    }

    public static int i(@Nullable Context context) {
        n(AppRuntime.getAppContext());
        DisplayMetrics displayMetrics = f46657a;
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public static String j() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    public static String k() {
        return AppRuntime.getAppContext().getPackageName();
    }

    public static String l() {
        try {
            Context appContext = AppRuntime.getAppContext();
            return appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static void n(Context context) {
        if (f46657a == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext != null) {
                context = appContext;
            }
            if (context == null) {
                return;
            }
            f46657a = context.getResources().getDisplayMetrics();
        }
    }

    public static boolean o() {
        return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, d.a.i0.f.i.m.a.b().a());
    }

    public static int p(float f2) {
        return (int) (f2 / d(AppRuntime.getAppContext()));
    }
}
