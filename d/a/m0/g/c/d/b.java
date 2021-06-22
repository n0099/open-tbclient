package d.a.m0.g.c.d;

import android.content.SharedPreferences;
import com.baidu.android.util.KVStorageFactory;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f50787b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f50788c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f50789a = KVStorageFactory.getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f50788c == null) {
            synchronized (b.class) {
                if (f50788c == null) {
                    f50788c = new b();
                }
            }
        }
        return f50788c;
    }

    public boolean b() {
        return this.f50789a.getBoolean(f50787b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f50789a.edit();
        edit.putBoolean(f50787b, z);
        edit.apply();
    }
}
