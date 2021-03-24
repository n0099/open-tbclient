package d.b.e0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f42762d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f42763e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f42764f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f42765a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f42766b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f42767c;

    public void a() {
        this.f42765a.clear();
    }

    public String b(int i, String str) {
        String str2;
        if (i == f42762d) {
            str2 = this.f42765a.get(str);
        } else if (i == f42763e) {
            str2 = this.f42766b.get(str);
        } else {
            if (i == f42764f) {
                SharedPreferences sharedPreferences = this.f42767c;
                if (sharedPreferences != null) {
                    str2 = sharedPreferences.getString(str, "");
                } else {
                    Log.e("TAG", "prefs data store is null");
                }
            }
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    public void c(SharedPreferences sharedPreferences) {
        this.f42767c = sharedPreferences;
    }

    public void d(int i, String str, String str2) {
        if (i == f42762d) {
            this.f42765a.put(str, str2);
        } else if (i == f42763e) {
            this.f42766b.put(str, str2);
        } else if (i == f42764f) {
            SharedPreferences sharedPreferences = this.f42767c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
