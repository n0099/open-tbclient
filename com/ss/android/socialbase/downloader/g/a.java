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
    public static final a b = new a(null);
    public static JSONObject c;
    public static JSONObject d;
    public static Boolean e;
    public static boolean f;
    public static a g;
    public final JSONObject h;
    public final JSONObject i;
    public final Boolean j;
    public int k;

    static {
        a();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        this.h = jSONObject;
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

    @NonNull
    public static a a(int i) {
        return a(i, (DownloadInfo) null);
    }

    public static a a(int i, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = g;
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
            g = aVar;
            return aVar;
        }
        return aVar2;
    }

    @NonNull
    public static a a(DownloadInfo downloadInfo) {
        return downloadInfo == null ? b : a(downloadInfo.getId(), downloadInfo);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f) {
            return b;
        }
        a aVar = g;
        if (aVar == null || aVar.h != jSONObject) {
            synchronized (a) {
                for (a aVar2 : a.values()) {
                    if (aVar2.h == jSONObject) {
                        g = aVar2;
                        return aVar2;
                    }
                }
                a aVar3 = new a(jSONObject);
                g = aVar3;
                return aVar3;
            }
        }
        return aVar;
    }

    public static void a() {
        JSONObject E = c.E();
        f = E.optInt("disable_task_setting", 0) == 1;
        c = E.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = E.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        d = optJSONObject;
        e = bool;
    }

    public static void a(int i, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f) {
            return;
        }
        synchronized (a) {
            a aVar = g;
            if (aVar == null || aVar.h != jSONObject) {
                aVar = null;
                Iterator<a> it = a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.h == jSONObject) {
                        next.k = i;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.k = i;
                }
                g = aVar;
            } else {
                aVar.k = i;
            }
            a.put(Integer.valueOf(i), aVar);
        }
    }

    public static void a(String str, boolean z) {
        try {
            if (d == null) {
                d = new JSONObject();
            }
            d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a1654612903251dc(String str) {
        while (true) {
            char c2 = 'I';
            char c3 = '`';
            while (true) {
                switch (c2) {
                    case 'H':
                        c2 = 'J';
                        c3 = '7';
                    case 'I':
                        switch (c3) {
                            case '_':
                            case '`':
                                c2 = 'J';
                                c3 = '7';
                        }
                        break;
                    case 'J':
                        break;
                    default:
                        c2 = 'H';
                }
                switch (c3) {
                    case '7':
                        char[] charArray = str.toCharArray();
                        for (int i = 0; i < charArray.length; i++) {
                            charArray[i] = (char) (charArray[i] ^ i);
                        }
                        return new String(charArray);
                }
            }
        }
    }

    public static a b(DownloadInfo downloadInfo) {
        if (f) {
            return b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    @NonNull
    public static JSONObject b() {
        return c.E();
    }

    public static void b(int i) {
        a aVar = g;
        if (aVar != null && aVar.k == i) {
            g = null;
        }
        synchronized (a) {
            a.remove(Integer.valueOf(i));
        }
    }

    @NonNull
    public static a c() {
        return b;
    }

    public static a c(int i) {
        DownloadInfo downloadInfo;
        if (f) {
            return b;
        }
        Context N = c.N();
        return (N == null || (downloadInfo = Downloader.getInstance(N).getDownloadInfo(i)) == null) ? b : b(downloadInfo);
    }

    public static boolean f(String str) {
        JSONObject jSONObject = c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.h;
        return ((jSONObject == null || !jSONObject.has(str) || f(str)) ? b() : this.h).optDouble(str, d2);
    }

    public int a(String str, int i) {
        JSONObject jSONObject = this.h;
        return ((jSONObject == null || !jSONObject.has(str) || f(str)) ? b() : this.h).optInt(str, i);
    }

    public long a(String str, long j) {
        JSONObject jSONObject = this.h;
        return ((jSONObject == null || !jSONObject.has(str) || f(str)) ? b() : this.h).optLong(str, j);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.h;
        return ((jSONObject == null || !jSONObject.has(str) || f(str)) ? b() : this.h).optString(str, str2);
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int b(String str) {
        return a(str, 0);
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
        JSONObject jSONObject = d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = e;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String c(String str) {
        return a(str, "");
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.h;
        return ((jSONObject == null || !jSONObject.has(str) || f(str)) ? b() : this.h).optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.h;
        return ((jSONObject == null || !jSONObject.has(str) || f(str)) ? b() : this.h).optJSONArray(str);
    }
}
