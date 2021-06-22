package d.a.o0.u.b.k;

import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class a {
    public static boolean a() {
        return d.a.m0.a.c1.a.H().a();
    }

    public static void b() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        int i2 = a() ? 2 : 1;
        if (defaultNightMode != i2) {
            AppCompatDelegate.setDefaultNightMode(i2);
        }
    }

    public static void c(boolean z) {
        Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
        intent.putExtra("key_night_mode", z);
        LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
    }
}
