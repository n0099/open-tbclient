package d.a.h0.f.f.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f45966b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f45967c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f45968a = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f45967c == null) {
            synchronized (d.a.h0.f.f.a.class) {
                if (f45967c == null) {
                    f45967c = new b();
                }
            }
        }
        return f45967c;
    }

    public boolean b() {
        return this.f45968a.getBoolean(f45966b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f45968a.edit();
        edit.putBoolean(f45966b, z);
        edit.commit();
    }
}
