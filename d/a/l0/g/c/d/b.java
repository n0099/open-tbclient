package d.a.l0.g.c.d;

import android.content.SharedPreferences;
import com.baidu.android.util.KVStorageFactory;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f47005b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47006c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f47007a = KVStorageFactory.getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f47006c == null) {
            synchronized (b.class) {
                if (f47006c == null) {
                    f47006c = new b();
                }
            }
        }
        return f47006c;
    }

    public boolean b() {
        return this.f47007a.getBoolean(f47005b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f47007a.edit();
        edit.putBoolean(f47005b, z);
        edit.apply();
    }
}
