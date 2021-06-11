package d.a.g0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f43608d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f43609e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f43610f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f43611a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f43612b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f43613c;

    public void a() {
        this.f43611a.clear();
    }

    public String b(int i2, String str) {
        String str2;
        if (i2 == f43608d) {
            str2 = this.f43611a.get(str);
        } else if (i2 == f43609e) {
            str2 = this.f43612b.get(str);
        } else {
            if (i2 == f43610f) {
                SharedPreferences sharedPreferences = this.f43613c;
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
        this.f43613c = sharedPreferences;
    }

    public void d(int i2, String str, String str2) {
        if (i2 == f43608d) {
            this.f43611a.put(str, str2);
        } else if (i2 == f43609e) {
            this.f43612b.put(str, str2);
        } else if (i2 == f43610f) {
            SharedPreferences sharedPreferences = this.f43613c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
