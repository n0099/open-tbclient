package d.a.j;

import android.text.TextUtils;
import d.a.j.d.a.g;
import d.a.j.f;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f40228a;

    /* renamed from: b  reason: collision with root package name */
    public String f40229b;

    /* renamed from: c  reason: collision with root package name */
    public int f40230c = 2;

    /* renamed from: d  reason: collision with root package name */
    public int f40231d = 0;

    public static j a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        j jVar = new j();
        jVar.f40228a = str;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        jVar.f40231d = length;
        if (length < 14) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            jVar.f40229b = str2;
        }
        return jVar;
    }

    public static boolean c(int i2) {
        return i2 >= 14;
    }

    public static boolean d(String str) {
        return TextUtils.isEmpty(str);
    }

    public static j e(String str) {
        return g(j(str));
    }

    public static j g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            String str2 = "0";
            String str3 = "0";
            while (keys.hasNext()) {
                String next = keys.next();
                if (!i("ZGV2aWNlaWQ=").equals(next) && !i("dmVy").equals(next)) {
                    str3 = jSONObject.optString(next, "0");
                }
            }
            String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
            int i2 = jSONObject.getInt(i("dmVy"));
            int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
            if (!TextUtils.isEmpty(string)) {
                j jVar = new j();
                jVar.f40228a = string;
                jVar.f40230c = i2;
                jVar.f40231d = length;
                if (length < 14) {
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    jVar.f40229b = str2;
                }
                jVar.k();
                return jVar;
            }
        } catch (JSONException e2) {
            d.a.j.i.c.c(e2);
        }
        return null;
    }

    public static String i(String str) {
        return new String(f.b.b(str.getBytes()));
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] a2 = g.a();
            return new String(d.a.j.d.a.c.d(a2, a2, f.b.b(str.getBytes())));
        } catch (Exception e2) {
            d.a.j.i.c.c(e2);
            return "";
        }
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] a2 = g.a();
            return f.b.a(d.a.j.d.a.c.c(a2, a2, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            d.a.j.i.c.c(e2);
            return "";
        }
    }

    public boolean b() {
        return d(this.f40229b);
    }

    public boolean f() {
        return c(this.f40231d);
    }

    public String h() {
        return m(l());
    }

    public boolean k() {
        String str;
        if (f()) {
            str = "O";
        } else if (!b()) {
            return false;
        } else {
            str = "0";
        }
        this.f40229b = str;
        return true;
    }

    public final String l() {
        try {
            return new JSONObject().put(i("ZGV2aWNlaWQ="), this.f40228a).put(i("aW1laQ=="), this.f40229b).put(i("dmVy"), this.f40230c).toString();
        } catch (JSONException e2) {
            d.a.j.i.c.c(e2);
            return null;
        }
    }
}
