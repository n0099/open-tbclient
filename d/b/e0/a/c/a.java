package d.b.e0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f42763d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f42764e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f42765f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f42766a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f42767b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f42768c;

    public void a() {
        this.f42766a.clear();
    }

    public String b(int i, String str) {
        String str2;
        if (i == f42763d) {
            str2 = this.f42766a.get(str);
        } else if (i == f42764e) {
            str2 = this.f42767b.get(str);
        } else {
            if (i == f42765f) {
                SharedPreferences sharedPreferences = this.f42768c;
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
        this.f42768c = sharedPreferences;
    }

    public void d(int i, String str, String str2) {
        if (i == f42763d) {
            this.f42766a.put(str, str2);
        } else if (i == f42764e) {
            this.f42767b.put(str, str2);
        } else if (i == f42765f) {
            SharedPreferences sharedPreferences = this.f42768c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
