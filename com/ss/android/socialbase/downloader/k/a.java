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
    private static final f<Integer, a> qhR = new f<>(8, 8);
    private static final a qhS = new a(null);
    private static a qhT;
    private final JSONObject h;
    private final JSONObject i;
    private int k;
    private final Boolean qhU;

    static {
        a();
    }

    public static void a() {
        JSONObject eEf = b.eEf();
        f = eEf.optInt("disable_task_setting", 0) == 1;
        c = eEf.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = eEf.optJSONObject("bugfix");
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
        this.qhU = bool;
    }

    @NonNull
    public static JSONObject b() {
        return b.eEf();
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
    public static a eIF() {
        return qhS;
    }

    @NonNull
    public static a RW(int i) {
        return a(i, (c) null);
    }

    private static a a(int i, c cVar) {
        a aVar = qhT;
        if (aVar == null || aVar.k != i) {
            synchronized (qhR) {
                aVar = qhR.get(Integer.valueOf(i));
            }
            if (aVar == null) {
                aVar = cVar == null ? RX(i) : s(cVar);
                synchronized (qhR) {
                    qhR.put(Integer.valueOf(i), aVar);
                }
            }
            aVar.k = i;
            qhT = aVar;
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
            } else if (this.qhU != null) {
                return this.qhU.booleanValue();
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

    public JSONObject abH(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONObject(str) : this.h.optJSONObject(str);
    }

    public JSONArray abI(String str) {
        return (this.h == null || !this.h.has(str) || g(str)) ? b().optJSONArray(str) : this.h.optJSONArray(str);
    }

    public static boolean g(String str) {
        return c != null && c.optInt(str, 0) == 1;
    }

    @NonNull
    public static a fm(JSONObject jSONObject) {
        a aVar;
        if (jSONObject == null || jSONObject == b() || f) {
            return qhS;
        }
        a aVar2 = qhT;
        if (aVar2 == null || aVar2.h != jSONObject) {
            synchronized (qhR) {
                Iterator<a> it = qhR.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.h == jSONObject) {
                            qhT = aVar;
                            break;
                        }
                    } else {
                        aVar = new a(jSONObject);
                        qhT = aVar;
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
            synchronized (qhR) {
                a aVar = qhT;
                if (aVar != null && aVar.h == jSONObject) {
                    aVar.k = i;
                } else {
                    Iterator<a> it = qhR.values().iterator();
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
                    qhT = aVar;
                }
                qhR.put(Integer.valueOf(i), aVar);
            }
        }
    }

    public static void b(int i) {
        a aVar = qhT;
        if (aVar != null && aVar.k == i) {
            qhT = null;
        }
        synchronized (qhR) {
            qhR.remove(Integer.valueOf(i));
        }
    }

    private static a RX(int i) {
        c h;
        if (f) {
            return qhS;
        }
        Context eGC = b.eGC();
        if (eGC != null && (h = com.ss.android.socialbase.downloader.downloader.f.iB(eGC).h(i)) != null) {
            return s(h);
        }
        return qhS;
    }

    private static a s(c cVar) {
        if (f) {
            return qhS;
        }
        try {
            String R = cVar.R();
            if (!TextUtils.isEmpty(R)) {
                return new a(new JSONObject(R));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return qhS;
    }
}
