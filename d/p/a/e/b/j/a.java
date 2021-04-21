package d.p.a.e.b.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.i.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.g.d;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final g<Integer, a> f68219e = new g<>(16, 16);

    /* renamed from: f  reason: collision with root package name */
    public static final a f68220f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    public static JSONObject f68221g;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f68222h;
    public static Boolean i;
    public static boolean j;
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f68223a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f68224b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f68225c;

    /* renamed from: d  reason: collision with root package name */
    public int f68226d;

    static {
        i();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f68223a = jSONObject;
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
        this.f68224b = jSONObject2;
        this.f68225c = bool;
    }

    @NonNull
    public static a d(int i2) {
        return e(i2, null);
    }

    public static a e(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = k;
        if (aVar2 == null || aVar2.f68226d != i2) {
            synchronized (f68219e) {
                aVar = f68219e.get(Integer.valueOf(i2));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? s(i2) : n(downloadInfo);
                synchronized (f68219e) {
                    f68219e.put(Integer.valueOf(i2), aVar);
                }
            }
            aVar.f68226d = i2;
            k = aVar;
            return aVar;
        }
        return aVar2;
    }

    @NonNull
    public static a f(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f68220f;
        }
        return e(downloadInfo.c0(), downloadInfo);
    }

    @NonNull
    public static a g(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != o() && !j) {
            a aVar = k;
            if (aVar == null || aVar.f68223a != jSONObject) {
                synchronized (f68219e) {
                    for (a aVar2 : f68219e.values()) {
                        if (aVar2.f68223a == jSONObject) {
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
        return f68220f;
    }

    public static void i() {
        JSONObject e2 = d.e();
        j = e2.optInt("disable_task_setting", 0) == 1;
        f68221g = e2.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = e2.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f68222h = optJSONObject;
        i = bool;
    }

    public static void j(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == o() || j) {
            return;
        }
        synchronized (f68219e) {
            a aVar = k;
            if (aVar != null && aVar.f68223a == jSONObject) {
                aVar.f68226d = i2;
            } else {
                aVar = null;
                Iterator<a> it = f68219e.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f68223a == jSONObject) {
                        next.f68226d = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f68226d = i2;
                }
                k = aVar;
            }
            f68219e.put(Integer.valueOf(i2), aVar);
        }
    }

    public static void k(String str, boolean z) {
        try {
            if (f68222h == null) {
                f68222h = new JSONObject();
            }
            f68222h.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static a n(DownloadInfo downloadInfo) {
        if (j) {
            return f68220f;
        }
        try {
            String K = downloadInfo.K();
            if (!TextUtils.isEmpty(K)) {
                return new a(new JSONObject(K));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f68220f;
    }

    @NonNull
    public static JSONObject o() {
        return d.e();
    }

    public static void p(int i2) {
        a aVar = k;
        if (aVar != null && aVar.f68226d == i2) {
            k = null;
        }
        synchronized (f68219e) {
            f68219e.remove(Integer.valueOf(i2));
        }
    }

    @NonNull
    public static a r() {
        return f68220f;
    }

    public static a s(int i2) {
        DownloadInfo f2;
        if (j) {
            return f68220f;
        }
        Context l = d.l();
        if (l != null && (f2 = d.p.a.e.b.g.a.l(l).f(i2)) != null) {
            return n(f2);
        }
        return f68220f;
    }

    public static boolean w(String str) {
        JSONObject jSONObject = f68221g;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f68223a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f68223a.optDouble(str, d2);
        }
        return o().optDouble(str, d2);
    }

    public int b(String str, int i2) {
        JSONObject jSONObject = this.f68223a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f68223a.optInt(str, i2);
        }
        return o().optInt(str, i2);
    }

    public long c(String str, long j2) {
        JSONObject jSONObject = this.f68223a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f68223a.optLong(str, j2);
        }
        return o().optLong(str, j2);
    }

    public String h(String str, String str2) {
        JSONObject jSONObject = this.f68223a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f68223a.optString(str, str2);
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
        if (this.f68224b != null && !w(str)) {
            if (this.f68224b.has(str)) {
                return this.f68224b.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f68225c;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f68222h;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f68222h.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = i;
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
        JSONObject jSONObject = this.f68223a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f68223a.optJSONObject(str);
        }
        return o().optJSONObject(str);
    }

    public JSONArray v(String str) {
        JSONObject jSONObject = this.f68223a;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.f68223a.optJSONArray(str);
        }
        return o().optJSONArray(str);
    }
}
