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
/* loaded from: classes7.dex */
public class a {
    public static final h<Integer, a> a = new h<>(16, 16);

    /* renamed from: b  reason: collision with root package name */
    public static final a f43333b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f43334c;

    /* renamed from: d  reason: collision with root package name */
    public static JSONObject f43335d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f43336e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f43337f;

    /* renamed from: g  reason: collision with root package name */
    public static a f43338g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f43339h;
    public final JSONObject i;
    public final Boolean j;
    public int k;

    static {
        a();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.f43339h = jSONObject;
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
        this.i = jSONObject2;
        this.j = bool;
    }

    public static void a() {
        JSONObject E = c.E();
        f43337f = E.optInt("disable_task_setting", 0) == 1;
        f43334c = E.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = E.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f43335d = optJSONObject;
        f43336e = bool;
    }

    @NonNull
    public static JSONObject b() {
        return c.E();
    }

    @NonNull
    public static a c() {
        return f43333b;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = f43334c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f43339h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f43339h.optJSONObject(str);
        }
        return b().optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.f43339h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f43339h.optJSONArray(str);
        }
        return b().optJSONArray(str);
    }

    public boolean b(String str, boolean z) {
        if (this.i != null && !f(str)) {
            if (this.i.has(str)) {
                return this.i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.j;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f43335d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f43335d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f43336e;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String c(String str) {
        return a(str, "");
    }

    public static a c(int i) {
        DownloadInfo downloadInfo;
        if (f43337f) {
            return f43333b;
        }
        Context N = c.N();
        if (N != null && (downloadInfo = Downloader.getInstance(N).getDownloadInfo(i)) != null) {
            return b(downloadInfo);
        }
        return f43333b;
    }

    public static void a(String str, boolean z) {
        try {
            if (f43335d == null) {
                f43335d = new JSONObject();
            }
            f43335d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static a a(int i) {
        return a(i, (DownloadInfo) null);
    }

    public int b(String str) {
        return a(str, 0);
    }

    @NonNull
    public static a a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f43333b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    public static void b(int i) {
        a aVar = f43338g;
        if (aVar != null && aVar.k == i) {
            f43338g = null;
        }
        synchronized (a) {
            a.remove(Integer.valueOf(i));
        }
    }

    public static a a(int i, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = f43338g;
        if (aVar2 == null || aVar2.k != i) {
            synchronized (a) {
                aVar = a.get(Integer.valueOf(i));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? c(i) : b(downloadInfo);
                synchronized (a) {
                    a.put(Integer.valueOf(i), aVar);
                }
            }
            aVar.k = i;
            f43338g = aVar;
            return aVar;
        }
        return aVar2;
    }

    public static a b(DownloadInfo downloadInfo) {
        if (f43337f) {
            return f43333b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f43333b;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int a(String str, int i) {
        JSONObject jSONObject = this.f43339h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f43339h.optInt(str, i);
        }
        return b().optInt(str, i);
    }

    public long a(String str, long j) {
        JSONObject jSONObject = this.f43339h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f43339h.optLong(str, j);
        }
        return b().optLong(str, j);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f43339h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f43339h.optDouble(str, d2);
        }
        return b().optDouble(str, d2);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.f43339h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f43339h.optString(str, str2);
        }
        return b().optString(str, str2);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f43337f) {
            a aVar = f43338g;
            if (aVar == null || aVar.f43339h != jSONObject) {
                synchronized (a) {
                    for (a aVar2 : a.values()) {
                        if (aVar2.f43339h == jSONObject) {
                            f43338g = aVar2;
                            return aVar2;
                        }
                    }
                    a aVar3 = new a(jSONObject);
                    f43338g = aVar3;
                    return aVar3;
                }
            }
            return aVar;
        }
        return f43333b;
    }

    public static void a(int i, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f43337f) {
            return;
        }
        synchronized (a) {
            a aVar = f43338g;
            if (aVar != null && aVar.f43339h == jSONObject) {
                aVar.k = i;
            } else {
                aVar = null;
                Iterator<a> it = a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f43339h == jSONObject) {
                        next.k = i;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.k = i;
                }
                f43338g = aVar;
            }
            a.put(Integer.valueOf(i), aVar);
        }
    }
}
