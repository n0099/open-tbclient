package com.pgl.sys.ces;

import android.content.Context;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import d.m.a.b.e;
import d.m.b.b.a.f;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends Thread implements d.m.b.b.d.b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f35115c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f35116d = false;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f35117e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f35118f = false;
    public static boolean m = false;
    public static Map<String, Object> n;

    /* renamed from: b  reason: collision with root package name */
    public Context f35120b;

    /* renamed from: g  reason: collision with root package name */
    public String f35121g;
    public d.m.b.b.d.a l;

    /* renamed from: a  reason: collision with root package name */
    public boolean f35119a = false;

    /* renamed from: h  reason: collision with root package name */
    public String f35122h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f35123i = "";
    public String j = "";
    public boolean k = false;

    public b(Context context, String str, d.m.b.b.d.a aVar) {
        this.f35120b = null;
        this.f35121g = "";
        this.l = null;
        setName("CZL-00");
        this.f35120b = context;
        this.f35121g = str;
        this.l = aVar;
    }

    public static b a() {
        return f35117e;
    }

    public static b a(Context context, String str, int i2, d.m.b.b.d.a aVar) {
        if (f35117e == null) {
            synchronized (b.class) {
                if (f35117e == null) {
                    if (context == null) {
                        context = d.m.b.b.a.a.d().getApplicationContext();
                    }
                    if (context == null) {
                        return null;
                    }
                    f35117e = new b(context, str, aVar);
                }
                d.m.a.a.a.b(i2);
                e.c(context, "nms");
                a(context);
            }
        }
        return f35117e;
    }

    public static void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (!f35118f) {
                    try {
                        a.meta(101, null, "0");
                        a.meta(1020, null, "" + b());
                        a.meta(105, null, "" + d.m.b.b.a.a.c(context));
                        a.meta(106, null, "" + d.m.b.b.a.a.b(context));
                        a.meta(107, null, "" + d.m.b.b.a.a.f(context));
                        a.meta(108, null, "" + d.m.b.b.a.a.h(context));
                        a.meta(109, null, "" + d.m.b.b.a.a.e());
                        a.meta(110, null, "" + d.m.b.b.a.a.g());
                        f35118f = true;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void a(String str) {
        new Thread("CZL-" + str) { // from class: com.pgl.sys.ces.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.f35128a = 0;
                d.a(b.this.f35120b);
            }
        }.start();
    }

    public static String b() {
        return a().f35121g;
    }

    public static String c() {
        return a().f35123i;
    }

    public static String d() {
        return a().f35122h;
    }

    public static d.m.b.b.d.a e() {
        return a().l;
    }

    public static int f() {
        try {
            return d.m.b.b.a.a.a() != null ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean g() {
        return this.k;
    }

    private void h() {
        d.m.b.a.b.b(this.f35120b, b(), new d.m.b.a.a.a() { // from class: com.pgl.sys.ces.b.2
            @Override // d.m.b.a.a.a
            public void a(String str) {
                boolean unused = b.m = true;
            }
        });
    }

    public void SetRegionType(int i2) {
        d.m.a.a.a.b(i2);
    }

    public Object a(int i2, Object obj) {
        String trim;
        String str = null;
        if (i2 == 123) {
            return d.m.b.b.a.e.a(this.f35120b);
        }
        if (i2 == 121) {
            return d.m.b.b.a.c.e(this.f35120b);
        }
        if (i2 == 122) {
            return d.m.b.b.a.c.a();
        }
        if (i2 == 126) {
            return d.m.b.b.a.c.g(this.f35120b);
        }
        if (i2 == 127) {
            return d.m.b.b.a.c.b(this.f35120b);
        }
        if (i2 == 128) {
            return d.m.b.b.a.c.d(this.f35120b);
        }
        if (i2 == 120) {
            return d.m.b.b.a.b.a();
        }
        if (i2 == 124) {
            return f.b(this.f35120b);
        }
        if (i2 == 130) {
            return f.a(this.f35120b);
        }
        if (i2 == 125) {
            return f.c(this.f35120b);
        }
        if (i2 == 129) {
            return d.m.b.b.a.d.a(this.f35120b);
        }
        if (i2 == 131) {
            return d.m.b.a.b.a();
        }
        if (i2 == 132) {
            reportNow((String) obj);
            return null;
        } else if (i2 == 134) {
            return d.m.b.b.b.b.a(this.f35120b).d();
        } else {
            if (i2 == 140) {
                return d.m.b.b.b.a.b(this.f35120b).f();
            }
            if (i2 == 133) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, Object> entry : n.entrySet()) {
                        if (entry.getValue() == null) {
                            jSONObject.put(entry.getKey(), "");
                        } else {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    str = jSONObject.toString();
                } catch (Throwable unused) {
                }
                trim = str == null ? StringUtil.EMPTY_ARRAY : str.trim();
            } else if (i2 != 135) {
                if (i2 == 136) {
                    try {
                        return this.f35120b.getPackageManager().getPackageInfo(this.f35120b.getPackageName(), 64).signatures[0].toByteArray();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                } else if (i2 == 201) {
                    return d.m.b.b.a.c.f(this.f35120b);
                } else {
                    if (i2 == 202) {
                        return d.m.b.b.a.c.c();
                    }
                    if (i2 == 236) {
                        try {
                            return Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, (String) obj);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    return null;
                }
            } else {
                String a2 = c.a();
                trim = a2 == null ? "0000000000000000000000000000000000000000" : a2.trim();
            }
            return trim;
        }
    }

    public String debugEntry(Context context, int i2) {
        return (String) a.meta(1024768, null, null);
    }

    @Override // d.m.b.b.d.b
    public String onEvent() {
        return d.m.b.a.b.a();
    }

    @Override // d.m.b.b.d.b
    public String pullSg() {
        return c.a();
    }

    @Override // d.m.b.b.d.b
    public String pullVer(String str) {
        return c.a(str);
    }

    @Override // d.m.b.b.d.b
    public void reportNow(final String str) {
        try {
            new Thread("CZL-LRT") { // from class: com.pgl.sys.ces.b.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        long timeInMillis = b.a().f35119a ? Calendar.getInstance().getTimeInMillis() : 0L;
                        byte[] bArr = (byte[]) a.meta(222, b.this.f35120b, str);
                        long timeInMillis2 = b.a().f35119a ? Calendar.getInstance().getTimeInMillis() : 0L;
                        if (b.a().f35119a) {
                            Log.d("CZL_Efficient", "[Efficient] report : " + (timeInMillis2 - timeInMillis));
                        }
                        if (bArr == null || bArr.length <= 0) {
                            throw new NullPointerException("NullPointerException");
                        }
                        new d.m.b.b.c.a(b.this.f35120b, b.this.f35122h).d(1, 2, bArr);
                    } catch (Throwable unused) {
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.k = true;
        a("SP1");
        d.m.a.b.f.a(10000L);
        h();
        d.m.a.b.f.a(10000L);
        reportNow("CZL-L1st");
        while (true) {
            int i2 = 0;
            do {
                d.m.b.b.b.b.a(this.f35120b).c();
                d.m.b.b.b.a.b(this.f35120b).e();
                if (i2 == 10) {
                    reportNow("CZL-LLP");
                }
                i2++;
                a.meta(1213, null, Thread.currentThread().getName() + "-" + i2);
                d.m.a.b.f.a(180000L);
            } while (i2 <= 10);
        }
    }

    @Override // d.m.b.b.d.b
    public void setCustomInfo(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            n = hashMap;
        }
    }

    public void setEfficientDebug(boolean z) {
        this.f35119a = z;
    }

    @Override // d.m.b.b.d.b
    public void setParams(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.f35123i = str;
            a.meta(103, null, str);
        }
        if (str2 != null && str2.length() > 0) {
            this.j = str2;
            a.meta(104, null, str2);
        }
        if (isAlive() && g()) {
            return;
        }
        try {
            start();
        } catch (Throwable unused) {
        }
    }
}
