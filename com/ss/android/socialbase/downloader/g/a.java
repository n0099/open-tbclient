package com.ss.android.socialbase.downloader.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static final h<Integer, a> a = new h<>(16, 16);

    /* renamed from: b  reason: collision with root package name */
    public static final a f60106b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f60107c;

    /* renamed from: d  reason: collision with root package name */
    public static JSONObject f60108d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f60109e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f60110f;

    /* renamed from: g  reason: collision with root package name */
    public static a f60111g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f60112h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f60113i;

    /* renamed from: j  reason: collision with root package name */
    public final Boolean f60114j;
    public int k;

    static {
        a();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f60112h = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || f("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !f("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.f60113i = jSONObject2;
        this.f60114j = bool;
    }

    public static void a() {
        JSONObject E = c.E();
        f60110f = E.optInt("disable_task_setting", 0) == 1;
        f60107c = E.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = E.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f60108d = optJSONObject;
        f60109e = bool;
    }

    @NonNull
    public static JSONObject b() {
        return c.E();
    }

    @NonNull
    public static a c() {
        return f60106b;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = f60107c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f60112h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f60112h.optJSONObject(str);
        }
        return b().optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.f60112h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f60112h.optJSONArray(str);
        }
        return b().optJSONArray(str);
    }

    public boolean b(String str, boolean z) {
        if (this.f60113i != null && !f(str)) {
            if (this.f60113i.has(str)) {
                return this.f60113i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f60114j;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f60108d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f60108d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f60109e;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String c(String str) {
        return a(str, "");
    }

    public static a c(int i2) {
        DownloadInfo downloadInfo;
        if (f60110f) {
            return f60106b;
        }
        Context N = c.N();
        if (N != null && (downloadInfo = Downloader.getInstance(N).getDownloadInfo(i2)) != null) {
            return b(downloadInfo);
        }
        return f60106b;
    }

    public static void a(String str, boolean z) {
        try {
            if (f60108d == null) {
                f60108d = new JSONObject();
            }
            f60108d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static a a(int i2) {
        return a(i2, (DownloadInfo) null);
    }

    public int b(String str) {
        return a(str, 0);
    }

    @NonNull
    public static a a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f60106b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    public static void b(int i2) {
        a aVar = f60111g;
        if (aVar != null && aVar.k == i2) {
            f60111g = null;
        }
        synchronized (a) {
            a.remove(Integer.valueOf(i2));
        }
    }

    public static a a(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = f60111g;
        if (aVar2 == null || aVar2.k != i2) {
            synchronized (a) {
                aVar = a.get(Integer.valueOf(i2));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? c(i2) : b(downloadInfo);
                synchronized (a) {
                    a.put(Integer.valueOf(i2), aVar);
                }
            }
            aVar.k = i2;
            f60111g = aVar;
            return aVar;
        }
        return aVar2;
    }

    public static a b(DownloadInfo downloadInfo) {
        if (f60110f) {
            return f60106b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f60106b;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int a(String str, int i2) {
        JSONObject jSONObject = this.f60112h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f60112h.optInt(str, i2);
        }
        return b().optInt(str, i2);
    }

    public long a(String str, long j2) {
        JSONObject jSONObject = this.f60112h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f60112h.optLong(str, j2);
        }
        return b().optLong(str, j2);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f60112h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f60112h.optDouble(str, d2);
        }
        return b().optDouble(str, d2);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.f60112h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f60112h.optString(str, str2);
        }
        return b().optString(str, str2);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f60110f) {
            a aVar = f60111g;
            if (aVar == null || aVar.f60112h != jSONObject) {
                synchronized (a) {
                    for (a aVar2 : a.values()) {
                        if (aVar2.f60112h == jSONObject) {
                            f60111g = aVar2;
                            return aVar2;
                        }
                    }
                    a aVar3 = new a(jSONObject);
                    f60111g = aVar3;
                    return aVar3;
                }
            }
            return aVar;
        }
        return f60106b;
    }

    public static void a(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f60110f) {
            return;
        }
        synchronized (a) {
            a aVar = f60111g;
            if (aVar != null && aVar.f60112h == jSONObject) {
                aVar.k = i2;
            } else {
                aVar = null;
                Iterator<a> it = a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f60112h == jSONObject) {
                        next.k = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.k = i2;
                }
                f60111g = aVar;
            }
            a.put(Integer.valueOf(i2), aVar);
        }
    }
}
