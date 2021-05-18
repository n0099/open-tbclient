package d.a.e0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f39908d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f39909e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f39910f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f39911a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f39912b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f39913c;

    public void a() {
        this.f39911a.clear();
    }

    public String b(int i2, String str) {
        String str2;
        if (i2 == f39908d) {
            str2 = this.f39911a.get(str);
        } else if (i2 == f39909e) {
            str2 = this.f39912b.get(str);
        } else {
            if (i2 == f39910f) {
                SharedPreferences sharedPreferences = this.f39913c;
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
        this.f39913c = sharedPreferences;
    }

    public void d(int i2, String str, String str2) {
        if (i2 == f39908d) {
            this.f39911a.put(str, str2);
        } else if (i2 == f39909e) {
            this.f39912b.put(str, str2);
        } else if (i2 == f39910f) {
            SharedPreferences sharedPreferences = this.f39913c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
