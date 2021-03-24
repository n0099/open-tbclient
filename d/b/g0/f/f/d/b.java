package d.b.g0.f.f.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f47784b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47785c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f47786a = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f47785c == null) {
            synchronized (d.b.g0.f.f.a.class) {
                if (f47785c == null) {
                    f47785c = new b();
                }
            }
        }
        return f47785c;
    }

    public boolean b() {
        return this.f47786a.getBoolean(f47784b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f47786a.edit();
        edit.putBoolean(f47784b, z);
        edit.commit();
    }
}
