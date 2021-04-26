package d.a.e0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f40663d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f40664e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f40665f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f40666a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f40667b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f40668c;

    public void a() {
        this.f40666a.clear();
    }

    public String b(int i2, String str) {
        String str2;
        if (i2 == f40663d) {
            str2 = this.f40666a.get(str);
        } else if (i2 == f40664e) {
            str2 = this.f40667b.get(str);
        } else {
            if (i2 == f40665f) {
                SharedPreferences sharedPreferences = this.f40668c;
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
        this.f40668c = sharedPreferences;
    }

    public void d(int i2, String str, String str2) {
        if (i2 == f40663d) {
            this.f40666a.put(str, str2);
        } else if (i2 == f40664e) {
            this.f40667b.put(str, str2);
        } else if (i2 == f40665f) {
            SharedPreferences sharedPreferences = this.f40668c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
