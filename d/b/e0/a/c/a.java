package d.b.e0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f43419d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f43420e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f43421f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f43422a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f43423b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f43424c;

    public void a() {
        this.f43422a.clear();
    }

    public String b(int i, String str) {
        String str2;
        if (i == f43419d) {
            str2 = this.f43422a.get(str);
        } else if (i == f43420e) {
            str2 = this.f43423b.get(str);
        } else {
            if (i == f43421f) {
                SharedPreferences sharedPreferences = this.f43424c;
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
        this.f43424c = sharedPreferences;
    }

    public void d(int i, String str, String str2) {
        if (i == f43419d) {
            this.f43422a.put(str, str2);
        } else if (i == f43420e) {
            this.f43423b.put(str, str2);
        } else if (i == f43421f) {
            SharedPreferences sharedPreferences = this.f43424c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
