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
    public static final g<Integer, a> f67272e = new g<>(16, 16);

    /* renamed from: f  reason: collision with root package name */
    public static final a f67273f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    public static JSONObject f67274g;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f67275h;

    /* renamed from: i  reason: collision with root package name */
    public static Boolean f67276i;
    public static boolean j;
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f67277a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f67278b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f67279c;

    /* renamed from: d  reason: collision with root package name */
    public int f67280d;

    static {
        i();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f67277a = jSONObject;
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
        this.f67278b = jSONObject2;
        this.f67279c = bool;
    }

    @NonNull
    public static a d(int i2) {
        return e(i2, null);
    }

    public static a e(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = k;
        if (aVar2 == null || aVar2.f67280d != i2) {
            synchronized (f67272e) {
                aVar = f67272e.get(Integer.valueOf(i2));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? s(i2) : n(downloadInfo);
                synchronized (f67272e) {
                    f67272e.put(Integer.valueOf(i2), aVar);
                }
            }
            aVar.f67280d = i2;
            k = aVar;
            return aVar;
        }
        return aVar2;
    }

    @NonNull
    public static a f(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f67273f;
        }
        return e(downloadInfo.c0(), downloadInfo);
    }

    @NonNull
    public static a g(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != o() && !j) {
            a aVar = k;
            if (aVar == null || aVar.f67277a != jSONObject) {
                synchronized (f67272e) {
                    for (a aVar2 : f67272e.values()) {
                        if (aVar2.f67277a == jSONObject) {
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
        return f67273f;
    }

    public static void i() {
        JSONObject e2 = d.e();
        j = e2.optInt("disable_task_setting", 0) == 1;
        f67274g = e2.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = e2.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f67275h = optJSONObject;
        f67276i = bool;
    }

    public static void j(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == o() || j) {
            return;
        }
        synchronized (f67272e) {
            a aVar = k;
            if (aVar != null && aVar.f67277a == jSONObject) {
                aVar.f67280d = i2;
            } else {
                aVar = null;
                Iterator<a> it = f67272e.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f67277a == jSONObject) {
                        next.f67280d = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f67280d = i2;
                }
                k = aVar;
            }
            f67272e.put(Integer.valueOf(i2), aVar);
        }
    }

    public static void k(String str, boolean z) {
        try {
            if (f67275h == null) {
                f67275h = new JSONObject();
            }
            f67275h.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static a n(DownloadInfo downloadInfo) {
        if (j) {
            return f67273f;
        }
        try {
            String K = downloadInfo.K();
            if (!TextUtils.isEmpty(K)) {
                return new a(new JSONObject(K));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f67273f;
    }

    @NonNull
    public static JSONObject o() {
        return d.e();
    }

    public static void p(int i2) {
        a aVar = k;
        if (aVar != null && aVar.f67280d == i2) {
            k = null;
        }
        synchronized (f67272e) {
            f67272e.remove(Integer.valueOf(i2));
        }
    }

    @NonNull
    public static a r() {
        return f67273f;
    }

    public static a s(int i2) {
        DownloadInfo f2;
        if (j) {
            return f67273f;
        }
        Context l = d.l();
        if (l != null && (f2 = d.o.a.e.b.g.a.l(l).f(i2)) != null) {
            return n(f2);
        }
        return f67273f;
    }

    public static boolean w(String str) {
        JSONObject jSONObject = f67274g;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f67277a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f67277a.optDouble(str, d2);
        }
        return o().optDouble(str, d2);
    }

    public int b(String str, int i2) {
        JSONObject jSONObject = this.f67277a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f67277a.optInt(str, i2);
        }
        return o().optInt(str, i2);
    }

    public long c(String str, long j2) {
        JSONObject jSONObject = this.f67277a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f67277a.optLong(str, j2);
        }
        return o().optLong(str, j2);
    }

    public String h(String str, String str2) {
        JSONObject jSONObject = this.f67277a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f67277a.optString(str, str2);
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
        if (this.f67278b != null && !w(str)) {
            if (this.f67278b.has(str)) {
                return this.f67278b.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f67279c;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f67275h;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f67275h.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f67276i;
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
        JSONObject jSONObject = this.f67277a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f67277a.optJSONObject(str);
        }
        return o().optJSONObject(str);
    }

    public JSONArray v(String str) {
        JSONObject jSONObject = this.f67277a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f67277a.optJSONArray(str);
        }
        return o().optJSONArray(str);
    }
}
