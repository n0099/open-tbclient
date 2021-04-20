package d.b.g0.f.f.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f48177b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48178c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f48179a = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f48178c == null) {
            synchronized (d.b.g0.f.f.a.class) {
                if (f48178c == null) {
                    f48178c = new b();
                }
            }
        }
        return f48178c;
    }

    public boolean b() {
        return this.f48179a.getBoolean(f48177b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f48179a.edit();
        edit.putBoolean(f48177b, z);
        edit.commit();
    }
}
