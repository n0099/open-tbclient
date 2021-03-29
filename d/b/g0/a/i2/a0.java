package d.b.g0.a.i2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f44661a;

    public static Context a() {
        return AppRuntime.getAppContext();
    }

    public static boolean b(String str, boolean z) {
        return c().getBoolean(str, z);
    }

    public static SharedPreferences c() {
        if (f44661a == null) {
            f44661a = PreferenceManager.getDefaultSharedPreferences(a());
        }
        return f44661a;
    }

    public static void d(String str, boolean z) {
        SharedPreferences.Editor edit = c().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
