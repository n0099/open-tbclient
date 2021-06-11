package d.a.l0.g.c.d;

import android.content.SharedPreferences;
import com.baidu.android.util.KVStorageFactory;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f50679b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f50680c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f50681a = KVStorageFactory.getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f50680c == null) {
            synchronized (b.class) {
                if (f50680c == null) {
                    f50680c = new b();
                }
            }
        }
        return f50680c;
    }

    public boolean b() {
        return this.f50681a.getBoolean(f50679b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f50681a.edit();
        edit.putBoolean(f50679b, z);
        edit.apply();
    }
}
