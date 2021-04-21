package com.pgl.sys.ces;

import android.content.Context;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import d.n.a.b.e;
import d.n.b.b.a.f;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends Thread implements d.n.b.b.d.b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f38374c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f38375d = false;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f38376e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f38377f = false;
    public static boolean m = false;
    public static Map<String, Object> n;

    /* renamed from: b  reason: collision with root package name */
    public Context f38379b;

    /* renamed from: g  reason: collision with root package name */
    public String f38380g;
    public d.n.b.b.d.a l;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38378a = false;

    /* renamed from: h  reason: collision with root package name */
    public String f38381h = "";
    public String i = "";
    public String j = "";
    public boolean k = false;

    public b(Context context, String str, d.n.b.b.d.a aVar) {
        this.f38379b = null;
        this.f38380g = "";
        this.l = null;
        setName("CZL-00");
        this.f38379b = context;
        this.f38380g = str;
        this.l = aVar;
    }

    public static b a() {
        return f38376e;
    }

    public static b a(Context context, String str, int i, d.n.b.b.d.a aVar) {
        if (f38376e == null) {
            synchronized (b.class) {
                if (f38376e == null) {
                    if (context == null) {
                        context = d.n.b.b.a.a.d().getApplicationContext();
                    }
                    if (context == null) {
                        return null;
                    }
                    f38376e = new b(context, str, aVar);
                }
                d.n.a.a.a.b(i);
                e.c(context, "nms");
                a(context);
            }
        }
        return f38376e;
    }

    public static void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (!f38377f) {
                    try {
                        a.meta(101, null, "0");
                        a.meta(1020, null, "" + b());
                        a.meta(105, null, "" + d.n.b.b.a.a.c(context));
                        a.meta(106, null, "" + d.n.b.b.a.a.b(context));
                        a.meta(107, null, "" + d.n.b.b.a.a.f(context));
                        a.meta(108, null, "" + d.n.b.b.a.a.h(context));
                        a.meta(109, null, "" + d.n.b.b.a.a.e());
                        a.meta(110, null, "" + d.n.b.b.a.a.g());
                        f38377f = true;
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
                d.f38386a = 0;
                d.a(b.this.f38379b);
            }
        }.start();
    }

    public static String b() {
        return a().f38380g;
    }

    public static String c() {
        return a().i;
    }

    public static String d() {
        return a().f38381h;
    }

    public static d.n.b.b.d.a e() {
        return a().l;
    }

    public static int f() {
        try {
            return d.n.b.b.a.a.a() != null ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean g() {
        return this.k;
    }

    private void h() {
        d.n.b.a.b.b(this.f38379b, b(), new d.n.b.a.a.a() { // from class: com.pgl.sys.ces.b.2
            @Override // d.n.b.a.a.a
            public void a(String str) {
                boolean unused = b.m = true;
            }
        });
    }

    public void SetRegionType(int i) {
        d.n.a.a.a.b(i);
    }

    public Object a(int i, Object obj) {
        String trim;
        String str = null;
        if (i == 123) {
            return d.n.b.b.a.e.a(this.f38379b);
        }
        if (i == 121) {
            return d.n.b.b.a.c.e(this.f38379b);
        }
        if (i == 122) {
            return d.n.b.b.a.c.a();
        }
        if (i == 126) {
            return d.n.b.b.a.c.g(this.f38379b);
        }
        if (i == 127) {
            return d.n.b.b.a.c.b(this.f38379b);
        }
        if (i == 128) {
            return d.n.b.b.a.c.d(this.f38379b);
        }
        if (i == 120) {
            return d.n.b.b.a.b.a();
        }
        if (i == 124) {
            return f.b(this.f38379b);
        }
        if (i == 130) {
            return f.a(this.f38379b);
        }
        if (i == 125) {
            return f.c(this.f38379b);
        }
        if (i == 129) {
            return d.n.b.b.a.d.a(this.f38379b);
        }
        if (i == 131) {
            return d.n.b.a.b.a();
        }
        if (i == 132) {
            reportNow((String) obj);
            return null;
        } else if (i == 134) {
            return d.n.b.b.b.b.a(this.f38379b).d();
        } else {
            if (i == 140) {
                return d.n.b.b.b.a.b(this.f38379b).f();
            }
            if (i == 133) {
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
            } else if (i != 135) {
                if (i == 136) {
                    try {
                        return this.f38379b.getPackageManager().getPackageInfo(this.f38379b.getPackageName(), 64).signatures[0].toByteArray();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                } else if (i == 201) {
                    return d.n.b.b.a.c.f(this.f38379b);
                } else {
                    if (i == 202) {
                        return d.n.b.b.a.c.c();
                    }
                    if (i == 236) {
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

    public String debugEntry(Context context, int i) {
        return (String) a.meta(1024768, null, null);
    }

    @Override // d.n.b.b.d.b
    public String onEvent() {
        return d.n.b.a.b.a();
    }

    @Override // d.n.b.b.d.b
    public String pullSg() {
        return c.a();
    }

    @Override // d.n.b.b.d.b
    public String pullVer(String str) {
        return c.a(str);
    }

    @Override // d.n.b.b.d.b
    public void reportNow(final String str) {
        try {
            new Thread("CZL-LRT") { // from class: com.pgl.sys.ces.b.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        long timeInMillis = b.a().f38378a ? Calendar.getInstance().getTimeInMillis() : 0L;
                        byte[] bArr = (byte[]) a.meta(222, b.this.f38379b, str);
                        long timeInMillis2 = b.a().f38378a ? Calendar.getInstance().getTimeInMillis() : 0L;
                        if (b.a().f38378a) {
                            Log.d("CZL_Efficient", "[Efficient] report : " + (timeInMillis2 - timeInMillis));
                        }
                        if (bArr == null || bArr.length <= 0) {
                            throw new NullPointerException("NullPointerException");
                        }
                        new d.n.b.b.c.a(b.this.f38379b, b.this.f38381h).d(1, 2, bArr);
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
        d.n.a.b.f.a(10000L);
        h();
        d.n.a.b.f.a(10000L);
        reportNow("CZL-L1st");
        while (true) {
            int i = 0;
            do {
                d.n.b.b.b.b.a(this.f38379b).c();
                d.n.b.b.b.a.b(this.f38379b).e();
                if (i == 10) {
                    reportNow("CZL-LLP");
                }
                i++;
                a.meta(1213, null, Thread.currentThread().getName() + "-" + i);
                d.n.a.b.f.a(180000L);
            } while (i <= 10);
        }
    }

    @Override // d.n.b.b.d.b
    public void setCustomInfo(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            n = hashMap;
        }
    }

    public void setEfficientDebug(boolean z) {
        this.f38378a = z;
    }

    @Override // d.n.b.b.d.b
    public void setParams(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.i = str;
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
