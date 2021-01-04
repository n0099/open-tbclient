package com.ss.android.socialbase.downloader.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
    private static final f<Integer, a> qaf = new f<>(8, 8);
    private static final a qag = new a(null);
    private static a qah;
    private final JSONObject h;
    private final JSONObject i;
    private int k;
    private final Boolean qai;

    static {
        a();
    }

    public static void a() {
        JSONObject eET = b.eET();
        f = eET.optInt("disable_task_setting", 0) == 1;
        c = eET.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = eET.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
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
            if (optJSONObject == null || !optJSONObject.has("default") || g("default")) {
                bool = null;
                jSONObject2 = optJSONObject;
            } else {
                bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
                jSONObject2 = optJSONObject;
            }
        }
        this.i = jSONObject2;
        this.qai = bool;
    }

    @NonNull
    public static JSONObject b() {
        return b.eET();
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
    public static a eJs() {
        return qag;
    }

    @NonNull
    public static a SR(int i) {
        return a(i, (c) null);
    }

    private static a a(int i, c cVar) {
        a aVar = qah;
        if (aVar == null || aVar.k != i) {
            synchronized (qaf) {
                aVar = qaf.get(Integer.valueOf(i));
            }
            if (aVar == null) {
                aVar = cVar == null ? SS(i) : s(cVar);
                synchronized (qaf) {
                    qaf.put(Integer.valueOf(i), aVar);
                }
            }
            aVar.k = i;
            qah = aVar;
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
            } else if (this.qai != null) {
                return this.qai.booleanValue();
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

    public JSONObject abA(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONObject(str) : this.h.optJSONObject(str);
    }

    public JSONArray abB(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONArray(str) : this.h.optJSONArray(str);
    }

    public static boolean g(String str) {
        return c != null && c.optInt(str, 0) == 1;
    }

    @NonNull
    public static a fl(JSONObject jSONObject) {
        a aVar;
        if (jSONObject == null || jSONObject == b() || f) {
            return qag;
        }
        a aVar2 = qah;
        if (aVar2 == null || aVar2.h != jSONObject) {
            synchronized (qaf) {
                Iterator<a> it = qaf.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.h == jSONObject) {
                            qah = aVar;
                            break;
                        }
                    } else {
                        aVar = new a(jSONObject);
                        qah = aVar;
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
            synchronized (qaf) {
                a aVar = qah;
                if (aVar != null && aVar.h == jSONObject) {
                    aVar.k = i;
                } else {
                    Iterator<a> it = qaf.values().iterator();
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
                    qah = aVar;
                }
                qaf.put(Integer.valueOf(i), aVar);
            }
        }
    }

    public static void b(int i) {
        a aVar = qah;
        if (aVar != null && aVar.k == i) {
            qah = null;
        }
        synchronized (qaf) {
            qaf.remove(Integer.valueOf(i));
        }
    }

    private static a SS(int i) {
        c h;
        if (f) {
            return qag;
        }
        Context eHp = b.eHp();
        if (eHp != null && (h = com.ss.android.socialbase.downloader.downloader.f.iA(eHp).h(i)) != null) {
            return s(h);
        }
        return qag;
    }

    private static a s(c cVar) {
        if (f) {
            return qag;
        }
        try {
            String R = cVar.R();
            if (!TextUtils.isEmpty(R)) {
                return new a(new JSONObject(R));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return qag;
    }
}
