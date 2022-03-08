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
/* loaded from: classes8.dex */
public class a {
    public static final h<Integer, a> a = new h<>(16, 16);

    /* renamed from: b  reason: collision with root package name */
    public static final a f58623b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f58624c;

    /* renamed from: d  reason: collision with root package name */
    public static JSONObject f58625d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f58626e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f58627f;

    /* renamed from: g  reason: collision with root package name */
    public static a f58628g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f58629h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f58630i;

    /* renamed from: j  reason: collision with root package name */
    public final Boolean f58631j;
    public int k;

    static {
        a();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f58629h = jSONObject;
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
        this.f58630i = jSONObject2;
        this.f58631j = bool;
    }

    public static void a() {
        JSONObject E = c.E();
        f58627f = E.optInt("disable_task_setting", 0) == 1;
        f58624c = E.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = E.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f58625d = optJSONObject;
        f58626e = bool;
    }

    @NonNull
    public static JSONObject b() {
        return c.E();
    }

    @NonNull
    public static a c() {
        return f58623b;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = f58624c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f58629h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f58629h.optJSONObject(str);
        }
        return b().optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.f58629h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f58629h.optJSONArray(str);
        }
        return b().optJSONArray(str);
    }

    public boolean b(String str, boolean z) {
        if (this.f58630i != null && !f(str)) {
            if (this.f58630i.has(str)) {
                return this.f58630i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f58631j;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f58625d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f58625d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f58626e;
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
        if (f58627f) {
            return f58623b;
        }
        Context N = c.N();
        if (N != null && (downloadInfo = Downloader.getInstance(N).getDownloadInfo(i2)) != null) {
            return b(downloadInfo);
        }
        return f58623b;
    }

    public static void a(String str, boolean z) {
        try {
            if (f58625d == null) {
                f58625d = new JSONObject();
            }
            f58625d.put(str, z ? 1 : 0);
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
            return f58623b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    public static void b(int i2) {
        a aVar = f58628g;
        if (aVar != null && aVar.k == i2) {
            f58628g = null;
        }
        synchronized (a) {
            a.remove(Integer.valueOf(i2));
        }
    }

    public static a a(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = f58628g;
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
            f58628g = aVar;
            return aVar;
        }
        return aVar2;
    }

    public static a b(DownloadInfo downloadInfo) {
        if (f58627f) {
            return f58623b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f58623b;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int a(String str, int i2) {
        JSONObject jSONObject = this.f58629h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f58629h.optInt(str, i2);
        }
        return b().optInt(str, i2);
    }

    public long a(String str, long j2) {
        JSONObject jSONObject = this.f58629h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f58629h.optLong(str, j2);
        }
        return b().optLong(str, j2);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f58629h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f58629h.optDouble(str, d2);
        }
        return b().optDouble(str, d2);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.f58629h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f58629h.optString(str, str2);
        }
        return b().optString(str, str2);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f58627f) {
            a aVar = f58628g;
            if (aVar == null || aVar.f58629h != jSONObject) {
                synchronized (a) {
                    for (a aVar2 : a.values()) {
                        if (aVar2.f58629h == jSONObject) {
                            f58628g = aVar2;
                            return aVar2;
                        }
                    }
                    a aVar3 = new a(jSONObject);
                    f58628g = aVar3;
                    return aVar3;
                }
            }
            return aVar;
        }
        return f58623b;
    }

    public static void a(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f58627f) {
            return;
        }
        synchronized (a) {
            a aVar = f58628g;
            if (aVar != null && aVar.f58629h == jSONObject) {
                aVar.k = i2;
            } else {
                aVar = null;
                Iterator<a> it = a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f58629h == jSONObject) {
                        next.k = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.k = i2;
                }
                f58628g = aVar;
            }
            a.put(Integer.valueOf(i2), aVar);
        }
    }
}
