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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final g<Integer, a> f66586e = new g<>(16, 16);

    /* renamed from: f  reason: collision with root package name */
    public static final a f66587f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    public static JSONObject f66588g;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f66589h;

    /* renamed from: i  reason: collision with root package name */
    public static Boolean f66590i;
    public static boolean j;
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f66591a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f66592b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f66593c;

    /* renamed from: d  reason: collision with root package name */
    public int f66594d;

    static {
        i();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f66591a = jSONObject;
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
        this.f66592b = jSONObject2;
        this.f66593c = bool;
    }

    @NonNull
    public static a d(int i2) {
        return e(i2, null);
    }

    public static a e(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = k;
        if (aVar2 == null || aVar2.f66594d != i2) {
            synchronized (f66586e) {
                aVar = f66586e.get(Integer.valueOf(i2));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? s(i2) : n(downloadInfo);
                synchronized (f66586e) {
                    f66586e.put(Integer.valueOf(i2), aVar);
                }
            }
            aVar.f66594d = i2;
            k = aVar;
            return aVar;
        }
        return aVar2;
    }

    @NonNull
    public static a f(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f66587f;
        }
        return e(downloadInfo.c0(), downloadInfo);
    }

    @NonNull
    public static a g(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != o() && !j) {
            a aVar = k;
            if (aVar == null || aVar.f66591a != jSONObject) {
                synchronized (f66586e) {
                    for (a aVar2 : f66586e.values()) {
                        if (aVar2.f66591a == jSONObject) {
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
        return f66587f;
    }

    public static void i() {
        JSONObject e2 = d.e();
        j = e2.optInt("disable_task_setting", 0) == 1;
        f66588g = e2.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = e2.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f66589h = optJSONObject;
        f66590i = bool;
    }

    public static void j(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == o() || j) {
            return;
        }
        synchronized (f66586e) {
            a aVar = k;
            if (aVar != null && aVar.f66591a == jSONObject) {
                aVar.f66594d = i2;
            } else {
                aVar = null;
                Iterator<a> it = f66586e.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f66591a == jSONObject) {
                        next.f66594d = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f66594d = i2;
                }
                k = aVar;
            }
            f66586e.put(Integer.valueOf(i2), aVar);
        }
    }

    public static void k(String str, boolean z) {
        try {
            if (f66589h == null) {
                f66589h = new JSONObject();
            }
            f66589h.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static a n(DownloadInfo downloadInfo) {
        if (j) {
            return f66587f;
        }
        try {
            String K = downloadInfo.K();
            if (!TextUtils.isEmpty(K)) {
                return new a(new JSONObject(K));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f66587f;
    }

    @NonNull
    public static JSONObject o() {
        return d.e();
    }

    public static void p(int i2) {
        a aVar = k;
        if (aVar != null && aVar.f66594d == i2) {
            k = null;
        }
        synchronized (f66586e) {
            f66586e.remove(Integer.valueOf(i2));
        }
    }

    @NonNull
    public static a r() {
        return f66587f;
    }

    public static a s(int i2) {
        DownloadInfo f2;
        if (j) {
            return f66587f;
        }
        Context l = d.l();
        if (l != null && (f2 = d.o.a.e.b.g.a.l(l).f(i2)) != null) {
            return n(f2);
        }
        return f66587f;
    }

    public static boolean w(String str) {
        JSONObject jSONObject = f66588g;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f66591a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f66591a.optDouble(str, d2);
        }
        return o().optDouble(str, d2);
    }

    public int b(String str, int i2) {
        JSONObject jSONObject = this.f66591a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f66591a.optInt(str, i2);
        }
        return o().optInt(str, i2);
    }

    public long c(String str, long j2) {
        JSONObject jSONObject = this.f66591a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f66591a.optLong(str, j2);
        }
        return o().optLong(str, j2);
    }

    public String h(String str, String str2) {
        JSONObject jSONObject = this.f66591a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f66591a.optString(str, str2);
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
        if (this.f66592b != null && !w(str)) {
            if (this.f66592b.has(str)) {
                return this.f66592b.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f66593c;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f66589h;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f66589h.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f66590i;
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
        JSONObject jSONObject = this.f66591a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f66591a.optJSONObject(str);
        }
        return o().optJSONObject(str);
    }

    public JSONArray v(String str) {
        JSONObject jSONObject = this.f66591a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f66591a.optJSONArray(str);
        }
        return o().optJSONArray(str);
    }
}
