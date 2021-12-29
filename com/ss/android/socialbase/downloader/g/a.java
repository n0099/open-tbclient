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
/* loaded from: classes3.dex */
public class a {
    public static final h<Integer, a> a = new h<>(16, 16);

    /* renamed from: b  reason: collision with root package name */
    public static final a f62415b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f62416c;

    /* renamed from: d  reason: collision with root package name */
    public static JSONObject f62417d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f62418e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f62419f;

    /* renamed from: g  reason: collision with root package name */
    public static a f62420g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f62421h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f62422i;

    /* renamed from: j  reason: collision with root package name */
    public final Boolean f62423j;

    /* renamed from: k  reason: collision with root package name */
    public int f62424k;

    static {
        a();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f62421h = jSONObject;
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
        this.f62422i = jSONObject2;
        this.f62423j = bool;
    }

    public static void a() {
        JSONObject E = c.E();
        f62419f = E.optInt("disable_task_setting", 0) == 1;
        f62416c = E.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = E.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f62417d = optJSONObject;
        f62418e = bool;
    }

    @NonNull
    public static JSONObject b() {
        return c.E();
    }

    @NonNull
    public static a c() {
        return f62415b;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = f62416c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f62421h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f62421h.optJSONObject(str);
        }
        return b().optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.f62421h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f62421h.optJSONArray(str);
        }
        return b().optJSONArray(str);
    }

    public boolean b(String str, boolean z) {
        if (this.f62422i != null && !f(str)) {
            if (this.f62422i.has(str)) {
                return this.f62422i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f62423j;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f62417d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f62417d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f62418e;
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
        if (f62419f) {
            return f62415b;
        }
        Context N = c.N();
        if (N != null && (downloadInfo = Downloader.getInstance(N).getDownloadInfo(i2)) != null) {
            return b(downloadInfo);
        }
        return f62415b;
    }

    public static void a(String str, boolean z) {
        try {
            if (f62417d == null) {
                f62417d = new JSONObject();
            }
            f62417d.put(str, z ? 1 : 0);
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
            return f62415b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    public static void b(int i2) {
        a aVar = f62420g;
        if (aVar != null && aVar.f62424k == i2) {
            f62420g = null;
        }
        synchronized (a) {
            a.remove(Integer.valueOf(i2));
        }
    }

    public static a a(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = f62420g;
        if (aVar2 == null || aVar2.f62424k != i2) {
            synchronized (a) {
                aVar = a.get(Integer.valueOf(i2));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? c(i2) : b(downloadInfo);
                synchronized (a) {
                    a.put(Integer.valueOf(i2), aVar);
                }
            }
            aVar.f62424k = i2;
            f62420g = aVar;
            return aVar;
        }
        return aVar2;
    }

    public static a b(DownloadInfo downloadInfo) {
        if (f62419f) {
            return f62415b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f62415b;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int a(String str, int i2) {
        JSONObject jSONObject = this.f62421h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f62421h.optInt(str, i2);
        }
        return b().optInt(str, i2);
    }

    public long a(String str, long j2) {
        JSONObject jSONObject = this.f62421h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f62421h.optLong(str, j2);
        }
        return b().optLong(str, j2);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f62421h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f62421h.optDouble(str, d2);
        }
        return b().optDouble(str, d2);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.f62421h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f62421h.optString(str, str2);
        }
        return b().optString(str, str2);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f62419f) {
            a aVar = f62420g;
            if (aVar == null || aVar.f62421h != jSONObject) {
                synchronized (a) {
                    for (a aVar2 : a.values()) {
                        if (aVar2.f62421h == jSONObject) {
                            f62420g = aVar2;
                            return aVar2;
                        }
                    }
                    a aVar3 = new a(jSONObject);
                    f62420g = aVar3;
                    return aVar3;
                }
            }
            return aVar;
        }
        return f62415b;
    }

    public static void a(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f62419f) {
            return;
        }
        synchronized (a) {
            a aVar = f62420g;
            if (aVar != null && aVar.f62421h == jSONObject) {
                aVar.f62424k = i2;
            } else {
                aVar = null;
                Iterator<a> it = a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f62421h == jSONObject) {
                        next.f62424k = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f62424k = i2;
                }
                f62420g = aVar;
            }
            a.put(Integer.valueOf(i2), aVar);
        }
    }
}
