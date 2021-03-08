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
/* loaded from: classes6.dex */
public class a {
    private static JSONObject c;
    private static JSONObject d;
    private static Boolean e;
    private static boolean f;
    private static final f<Integer, a> qiH = new f<>(8, 8);
    private static final a qiI = new a(null);
    private static a qiJ;
    private final JSONObject h;
    private final JSONObject i;
    private int k;
    private final Boolean qiK;

    static {
        a();
    }

    public static void a() {
        JSONObject z = b.z();
        f = z.optInt("disable_task_setting", 0) == 1;
        c = z.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = z.optJSONObject("bugfix");
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
        this.qiK = bool;
    }

    @NonNull
    public static JSONObject b() {
        return b.z();
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
    public static a eIH() {
        return qiI;
    }

    @NonNull
    public static a Sa(int i) {
        return a(i, (c) null);
    }

    private static a a(int i, c cVar) {
        a aVar = qiJ;
        if (aVar == null || aVar.k != i) {
            synchronized (qiH) {
                aVar = qiH.get(Integer.valueOf(i));
            }
            if (aVar == null) {
                aVar = cVar == null ? Sb(i) : s(cVar);
                synchronized (qiH) {
                    qiH.put(Integer.valueOf(i), aVar);
                }
            }
            aVar.k = i;
            qiJ = aVar;
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
            } else if (this.qiK != null) {
                return this.qiK.booleanValue();
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

    public JSONObject abM(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONObject(str) : this.h.optJSONObject(str);
    }

    public JSONArray abN(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONArray(str) : this.h.optJSONArray(str);
    }

    public static boolean g(String str) {
        return c != null && c.optInt(str, 0) == 1;
    }

    @NonNull
    public static a fp(JSONObject jSONObject) {
        a aVar;
        if (jSONObject == null || jSONObject == b() || f) {
            return qiI;
        }
        a aVar2 = qiJ;
        if (aVar2 == null || aVar2.h != jSONObject) {
            synchronized (qiH) {
                Iterator<a> it = qiH.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.h == jSONObject) {
                            qiJ = aVar;
                            break;
                        }
                    } else {
                        aVar = new a(jSONObject);
                        qiJ = aVar;
                        break;
                    }
                }
            }
            return aVar;
        }
        return aVar2;
    }

    public static void e(int i, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f) {
            synchronized (qiH) {
                a aVar = qiJ;
                if (aVar != null && aVar.h == jSONObject) {
                    aVar.k = i;
                } else {
                    Iterator<a> it = qiH.values().iterator();
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
                    qiJ = aVar;
                }
                qiH.put(Integer.valueOf(i), aVar);
            }
        }
    }

    public static void b(int i) {
        a aVar = qiJ;
        if (aVar != null && aVar.k == i) {
            qiJ = null;
        }
        synchronized (qiH) {
            qiH.remove(Integer.valueOf(i));
        }
    }

    private static a Sb(int i) {
        c h;
        if (f) {
            return qiI;
        }
        Context eGG = b.eGG();
        if (eGG != null && (h = com.ss.android.socialbase.downloader.downloader.f.iC(eGG).h(i)) != null) {
            return s(h);
        }
        return qiI;
    }

    private static a s(c cVar) {
        if (f) {
            return qiI;
        }
        try {
            String R = cVar.R();
            if (!TextUtils.isEmpty(R)) {
                return new a(new JSONObject(R));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return qiI;
    }
}
