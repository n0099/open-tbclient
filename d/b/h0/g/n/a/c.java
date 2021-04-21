package d.b.h0.g.n.a;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class c {
    public static boolean a(String str) {
        return TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("KEY_DEBUG_SWAN_GAME_CORE_MODE", "none"), str);
    }
}
