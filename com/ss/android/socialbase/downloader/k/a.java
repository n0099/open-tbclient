package com.ss.android.socialbase.downloader.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.f;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static JSONObject c;
    private static JSONObject d;
    private static Boolean e;
    private static boolean f;
    private static final f<Integer, a> pXn = new f<>(8, 8);
    private static final a pXo = new a(null);
    private static a pXp;
    private final JSONObject h;
    private final JSONObject i;
    private int k;
    private final Boolean pXq;

    static {
        a();
    }

    public static void a() {
        JSONObject eBG = b.eBG();
        f = eBG.optInt("disable_task_setting", 0) == 1;
        c = eBG.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = eBG.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT)) {
            bool = Boolean.valueOf(optJSONObject.optInt(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT, 0) == 1);
        }
        d = optJSONObject;
        e = bool;
    }

    private a(JSONObject jSONObject) {
        Boolean bool;
        JSONObject jSONObject2;
        this.h = jSONObject;
        if (jSONObject == null || g("bugfix")) {
            bool = null;
            jSONObject2 = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject == null || !optJSONObject.has(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT) || g(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT)) {
                bool = null;
                jSONObject2 = optJSONObject;
            } else {
                bool = Boolean.valueOf(optJSONObject.optInt(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT, 0) == 1);
                jSONObject2 = optJSONObject;
            }
        }
        this.i = jSONObject2;
        this.pXq = bool;
    }

    @NonNull
    public static JSONObject b() {
        return b.eBG();
    }

    public static void a(String str, boolean z) {
        try {
            if (d == null) {
                d = new JSONObject();
            }
            d.put(str, z ? 1 : 0);
        } catch (JSONException e2) {
        }
    }

    @NonNull
    public static a eGg() {
        return pXo;
    }

    @NonNull
    public static a RA(int i) {
        return a(i, (c) null);
    }

    private static a a(int i, c cVar) {
        a aVar = pXp;
        if (aVar == null || aVar.k != i) {
            synchronized (pXn) {
                aVar = pXn.get(Integer.valueOf(i));
            }
            if (aVar == null) {
                aVar = cVar == null ? RB(i) : s(cVar);
                synchronized (pXn) {
                    pXn.put(Integer.valueOf(i), aVar);
                }
            }
            aVar.k = i;
            pXp = aVar;
        }
        return aVar;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public boolean b(String str, boolean z) {
        if (this.i != null && !g(str)) {
            if (this.i.has(str)) {
                return this.i.optInt(str, z ? 1 : 0) == 1;
            } else if (this.pXq != null) {
                return this.pXq.booleanValue();
            }
        }
        if (d != null) {
            if (d.has(str)) {
                return d.optInt(str, z ? 1 : 0) == 1;
            } else if (e != null) {
                return e.booleanValue();
            }
        }
        return z;
    }

    public int b(String str) {
        return a(str, 0);
    }

    public int a(String str, int i) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optInt(str, i) : this.h.optInt(str, i);
    }

    public long a(String str, long j) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optLong(str, j) : this.h.optLong(str, j);
    }

    public double e(String str, double d2) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optDouble(str, d2) : this.h.optDouble(str, d2);
    }

    public boolean c(String str) {
        return c(str, false);
    }

    public boolean c(String str, boolean z) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optBoolean(str, z) : this.h.optBoolean(str, z);
    }

    public String d(String str) {
        return a(str, "");
    }

    public String a(String str, String str2) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optString(str, str2) : this.h.optString(str, str2);
    }

    public JSONObject aau(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONObject(str) : this.h.optJSONObject(str);
    }

    public JSONArray aav(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONArray(str) : this.h.optJSONArray(str);
    }

    public static boolean g(String str) {
        return c != null && c.optInt(str, 0) == 1;
    }

    @NonNull
    public static a fl(JSONObject jSONObject) {
        a aVar;
        if (jSONObject == null || jSONObject == b() || f) {
            return pXo;
        }
        a aVar2 = pXp;
        if (aVar2 == null || aVar2.h != jSONObject) {
            synchronized (pXn) {
                Iterator<a> it = pXn.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.h == jSONObject) {
                            pXp = aVar;
                            break;
                        }
                    } else {
                        aVar = new a(jSONObject);
                        pXp = aVar;
                        break;
                    }
                }
            }
            return aVar;
        }
        return aVar2;
    }

    public static void a(int i, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f) {
            synchronized (pXn) {
                a aVar = pXp;
                if (aVar != null && aVar.h == jSONObject) {
                    aVar.k = i;
                } else {
                    Iterator<a> it = pXn.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar = null;
                            break;
                        }
                        aVar = it.next();
                        if (aVar.h == jSONObject) {
                            aVar.k = i;
                            break;
                        }
                    }
                    if (aVar == null) {
                        aVar = new a(jSONObject);
                        aVar.k = i;
                    }
                    pXp = aVar;
                }
                pXn.put(Integer.valueOf(i), aVar);
            }
        }
    }

    public static void b(int i) {
        a aVar = pXp;
        if (aVar != null && aVar.k == i) {
            pXp = null;
        }
        synchronized (pXn) {
            pXn.remove(Integer.valueOf(i));
        }
    }

    private static a RB(int i) {
        c h;
        if (f) {
            return pXo;
        }
        Context eEd = b.eEd();
        if (eEd != null && (h = com.ss.android.socialbase.downloader.downloader.f.iy(eEd).h(i)) != null) {
            return s(h);
        }
        return pXo;
    }

    private static a s(c cVar) {
        if (f) {
            return pXo;
        }
        try {
            String R = cVar.R();
            if (!TextUtils.isEmpty(R)) {
                return new a(new JSONObject(R));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return pXo;
    }
}
