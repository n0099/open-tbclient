package d.b.i0.s.b.n;

import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class a {
    public static boolean a() {
        return d.b.g0.a.w0.a.z().a();
    }

    public static void b() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        int i = a() ? 2 : 1;
        if (defaultNightMode != i) {
            AppCompatDelegate.setDefaultNightMode(i);
        }
    }

    public static void c(boolean z) {
        Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
        intent.putExtra("key_night_mode", z);
        LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
    }
}
