package d.b.g0.t;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f49813a = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + ZeusWebViewPreloadClass.ZEUS_FILE_DIR + File.separator + "libs";

    static {
        String str = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";
    }

    public static boolean a() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    public static boolean b() {
        StringBuilder sb = new StringBuilder();
        sb.append(f49813a);
        sb.append(File.separator);
        sb.append("libzeuswebviewchromium.so");
        return new File(sb.toString()).exists() && a();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void c(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_full_install", z).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void d() {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", false).commit();
    }
}
