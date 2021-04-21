package d.b.h0.f.f.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f48506b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48507c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f48508a = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f48507c == null) {
            synchronized (d.b.h0.f.f.a.class) {
                if (f48507c == null) {
                    f48507c = new b();
                }
            }
        }
        return f48507c;
    }

    public boolean b() {
        return this.f48508a.getBoolean(f48506b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f48508a.edit();
        edit.putBoolean(f48506b, z);
        edit.commit();
    }
}
