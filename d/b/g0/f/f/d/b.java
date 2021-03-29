package d.b.g0.f.f.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f47785b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47786c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f47787a = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f47786c == null) {
            synchronized (d.b.g0.f.f.a.class) {
                if (f47786c == null) {
                    f47786c = new b();
                }
            }
        }
        return f47786c;
    }

    public boolean b() {
        return this.f47787a.getBoolean(f47785b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f47787a.edit();
        edit.putBoolean(f47785b, z);
        edit.commit();
    }
}
