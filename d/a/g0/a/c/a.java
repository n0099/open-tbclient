package d.a.g0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f39927d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f39928e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f39929f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f39930a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f39931b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f39932c;

    public void a() {
        this.f39930a.clear();
    }

    public String b(int i2, String str) {
        String str2;
        if (i2 == f39927d) {
            str2 = this.f39930a.get(str);
        } else if (i2 == f39928e) {
            str2 = this.f39931b.get(str);
        } else {
            if (i2 == f39929f) {
                SharedPreferences sharedPreferences = this.f39932c;
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
        this.f39932c = sharedPreferences;
    }

    public void d(int i2, String str, String str2) {
        if (i2 == f39927d) {
            this.f39930a.put(str, str2);
        } else if (i2 == f39928e) {
            this.f39931b.put(str, str2);
        } else if (i2 == f39929f) {
            SharedPreferences sharedPreferences = this.f39932c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
