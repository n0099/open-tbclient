package d.b.d0.a.c;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f43155d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f43156e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f43157f = 3;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f43158a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f43159b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f43160c;

    public void a() {
        this.f43158a.clear();
    }

    public String b(int i, String str) {
        String str2;
        if (i == f43155d) {
            str2 = this.f43158a.get(str);
        } else if (i == f43156e) {
            str2 = this.f43159b.get(str);
        } else {
            if (i == f43157f) {
                SharedPreferences sharedPreferences = this.f43160c;
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
        this.f43160c = sharedPreferences;
    }

    public void d(int i, String str, String str2) {
        if (i == f43155d) {
            this.f43158a.put(str, str2);
        } else if (i == f43156e) {
            this.f43159b.put(str, str2);
        } else if (i == f43157f) {
            SharedPreferences sharedPreferences = this.f43160c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
