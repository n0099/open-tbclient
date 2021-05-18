package d.a.i0.g.c.d;

import android.content.SharedPreferences;
import com.baidu.android.util.KVStorageFactory;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f46829b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46830c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f46831a = KVStorageFactory.getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    public static b a() {
        if (f46830c == null) {
            synchronized (b.class) {
                if (f46830c == null) {
                    f46830c = new b();
                }
            }
        }
        return f46830c;
    }

    public boolean b() {
        return this.f46831a.getBoolean(f46829b, true);
    }

    public void c(boolean z) {
        SharedPreferences.Editor edit = this.f46831a.edit();
        edit.putBoolean(f46829b, z);
        edit.apply();
    }
}
