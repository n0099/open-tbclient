package d.o.a.e.b.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.i.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.g.d;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final g<Integer, a> f71101e = new g<>(16, 16);

    /* renamed from: f  reason: collision with root package name */
    public static final a f71102f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    public static JSONObject f71103g;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f71104h;

    /* renamed from: i  reason: collision with root package name */
    public static Boolean f71105i;
    public static boolean j;
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f71106a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f71107b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f71108c;

    /* renamed from: d  reason: collision with root package name */
    public int f71109d;

    static {
        i();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f71106a = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || w("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !w("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.f71107b = jSONObject2;
        this.f71108c = bool;
    }

    @NonNull
    public static a d(int i2) {
        return e(i2, null);
    }

    public static a e(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = k;
        if (aVar2 == null || aVar2.f71109d != i2) {
            synchronized (f71101e) {
                aVar = f71101e.get(Integer.valueOf(i2));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? s(i2) : n(downloadInfo);
                synchronized (f71101e) {
                    f71101e.put(Integer.valueOf(i2), aVar);
                }
            }
            aVar.f71109d = i2;
            k = aVar;
            return aVar;
        }
        return aVar2;
    }

    @NonNull
    public static a f(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f71102f;
        }
        return e(downloadInfo.c0(), downloadInfo);
    }

    @NonNull
    public static a g(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != o() && !j) {
            a aVar = k;
            if (aVar == null || aVar.f71106a != jSONObject) {
                synchronized (f71101e) {
                    for (a aVar2 : f71101e.values()) {
                        if (aVar2.f71106a == jSONObject) {
                            k = aVar2;
                            return aVar2;
                        }
                    }
                    a aVar3 = new a(jSONObject);
                    k = aVar3;
                    return aVar3;
                }
            }
            return aVar;
        }
        return f71102f;
    }

    public static void i() {
        JSONObject e2 = d.e();
        j = e2.optInt("disable_task_setting", 0) == 1;
        f71103g = e2.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = e2.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f71104h = optJSONObject;
        f71105i = bool;
    }

    public static void j(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == o() || j) {
            return;
        }
        synchronized (f71101e) {
            a aVar = k;
            if (aVar != null && aVar.f71106a == jSONObject) {
                aVar.f71109d = i2;
            } else {
                aVar = null;
                Iterator<a> it = f71101e.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f71106a == jSONObject) {
                        next.f71109d = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f71109d = i2;
                }
                k = aVar;
            }
            f71101e.put(Integer.valueOf(i2), aVar);
        }
    }

    public static void k(String str, boolean z) {
        try {
            if (f71104h == null) {
                f71104h = new JSONObject();
            }
            f71104h.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static a n(DownloadInfo downloadInfo) {
        if (j) {
            return f71102f;
        }
        try {
            String K = downloadInfo.K();
            if (!TextUtils.isEmpty(K)) {
                return new a(new JSONObject(K));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f71102f;
    }

    @NonNull
    public static JSONObject o() {
        return d.e();
    }

    public static void p(int i2) {
        a aVar = k;
        if (aVar != null && aVar.f71109d == i2) {
            k = null;
        }
        synchronized (f71101e) {
            f71101e.remove(Integer.valueOf(i2));
        }
    }

    @NonNull
    public static a r() {
        return f71102f;
    }

    public static a s(int i2) {
        DownloadInfo f2;
        if (j) {
            return f71102f;
        }
        Context l = d.l();
        if (l != null && (f2 = d.o.a.e.b.g.a.l(l).f(i2)) != null) {
            return n(f2);
        }
        return f71102f;
    }

    public static boolean w(String str) {
        JSONObject jSONObject = f71103g;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f71106a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f71106a.optDouble(str, d2);
        }
        return o().optDouble(str, d2);
    }

    public int b(String str, int i2) {
        JSONObject jSONObject = this.f71106a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f71106a.optInt(str, i2);
        }
        return o().optInt(str, i2);
    }

    public long c(String str, long j2) {
        JSONObject jSONObject = this.f71106a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f71106a.optLong(str, j2);
        }
        return o().optLong(str, j2);
    }

    public String h(String str, String str2) {
        JSONObject jSONObject = this.f71106a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f71106a.optString(str, str2);
        }
        return o().optString(str, str2);
    }

    public boolean l(String str) {
        return q(str, false);
    }

    public int m(String str) {
        return b(str, 0);
    }

    public boolean q(String str, boolean z) {
        if (this.f71107b != null && !w(str)) {
            if (this.f71107b.has(str)) {
                return this.f71107b.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f71108c;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f71104h;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f71104h.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f71105i;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String t(String str) {
        return h(str, "");
    }

    public JSONObject u(String str) {
        JSONObject jSONObject = this.f71106a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f71106a.optJSONObject(str);
        }
        return o().optJSONObject(str);
    }

    public JSONArray v(String str) {
        JSONObject jSONObject = this.f71106a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f71106a.optJSONArray(str);
        }
        return o().optJSONArray(str);
    }
}
