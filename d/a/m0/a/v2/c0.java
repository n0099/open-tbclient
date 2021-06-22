package d.a.m0.a.v2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f49155a;

    public static Context a() {
        return AppRuntime.getAppContext();
    }

    public static boolean b(String str, boolean z) {
        return c().getBoolean(str, z);
    }

    public static SharedPreferences c() {
        if (f49155a == null) {
            f49155a = PreferenceManager.getDefaultSharedPreferences(a());
        }
        return f49155a;
    }
}
