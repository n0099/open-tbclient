package com.pgl.sys.ces;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.kwad.sdk.collector.AppStatusRules;
import com.pgl.a.b.e;
import com.pgl.sys.ces.a.f;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends Thread implements com.pgl.sys.ces.d.b {
    private static Map<String, Object> n;

    /* renamed from: b  reason: collision with root package name */
    public Context f11399b;
    private String g;
    private com.pgl.sys.ces.d.a l;
    private static volatile b e = null;
    private static boolean f = false;
    public static boolean c = false;
    public static boolean d = false;
    private static boolean m = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11398a = false;
    private String h = "";
    private String i = "";
    private String j = "";
    private boolean k = false;

    private b(Context context, String str, com.pgl.sys.ces.d.a aVar) {
        this.f11399b = null;
        this.g = "";
        this.l = null;
        setName("CZL-00");
        this.f11399b = context;
        this.g = str;
        this.l = aVar;
    }

    public static b a() {
        return e;
    }

    public static b a(Context context, String str, int i, com.pgl.sys.ces.d.a aVar) {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    if (context == null) {
                        context = com.pgl.sys.ces.a.a.eDK().getApplicationContext();
                    }
                    if (context == null) {
                        return null;
                    }
                    e = new b(context, str, aVar);
                }
                com.pgl.a.a.a.a(i);
                e.a(context, "nms");
                a(context);
            }
        }
        return e;
    }

    private static void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (!f) {
                    try {
                        a.meta(101, null, "0");
                        a.meta(1020, null, "" + b());
                        a.meta(105, null, "" + com.pgl.sys.ces.a.a.b(context));
                        a.meta(106, null, "" + com.pgl.sys.ces.a.a.a(context));
                        a.meta(107, null, "" + com.pgl.sys.ces.a.a.c(context));
                        a.meta(108, null, "" + com.pgl.sys.ces.a.a.d(context));
                        a.meta(109, null, "" + com.pgl.sys.ces.a.a.c());
                        a.meta(110, null, "" + com.pgl.sys.ces.a.a.d());
                        f = true;
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.pgl.sys.ces.b$1] */
    private void a(String str) {
        new Thread("CZL-" + str) { // from class: com.pgl.sys.ces.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.f11408a = 0;
                d.a(b.this.f11399b);
            }
        }.start();
    }

    public static String b() {
        return a().g;
    }

    public static String c() {
        return a().i;
    }

    public static String d() {
        return a().h;
    }

    public static com.pgl.sys.ces.d.a e() {
        return a().l;
    }

    public static int f() {
        try {
            return com.pgl.sys.ces.a.a.eDJ() != null ? 1 : 0;
        } catch (Throwable th) {
            return -1;
        }
    }

    private boolean g() {
        return this.k;
    }

    private void h() {
        com.pgl.sys.a.a.a(this.f11399b, b(), new com.pgl.sys.a.a.a() { // from class: com.pgl.sys.ces.b.2
            @Override // com.pgl.sys.a.a.a
            public void a(String str) {
                boolean unused = b.m = true;
            }
        });
    }

    private boolean i() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f11399b.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    if (activeNetworkInfo.isConnected()) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public void SetRegionType(int i) {
        com.pgl.a.a.a.a(i);
    }

    public Object a(int i, Object obj) {
        String str;
        if (i == 123) {
            return com.pgl.sys.ces.a.e.a(this.f11399b);
        }
        if (i == 121) {
            return com.pgl.sys.ces.a.c.c(this.f11399b);
        }
        if (i == 122) {
            return com.pgl.sys.ces.a.c.a();
        }
        if (i == 126) {
            return com.pgl.sys.ces.a.c.e(this.f11399b);
        }
        if (i == 127) {
            return com.pgl.sys.ces.a.c.a(this.f11399b);
        }
        if (i == 128) {
            return com.pgl.sys.ces.a.c.b(this.f11399b);
        }
        if (i == 120) {
            return com.pgl.sys.ces.a.b.a();
        }
        if (i == 124) {
            return f.b(this.f11399b);
        }
        if (i == 130) {
            return f.a(this.f11399b);
        }
        if (i == 125) {
            return f.c(this.f11399b);
        }
        if (i == 129) {
            return com.pgl.sys.ces.a.d.a(this.f11399b);
        }
        if (i == 131) {
            return com.pgl.sys.a.a.a();
        }
        if (i == 132) {
            reportNow((String) obj);
            return null;
        } else if (i == 134) {
            return com.pgl.sys.ces.b.a.iv(this.f11399b).a();
        } else {
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
                } catch (Throwable th) {
                    str = null;
                }
                return str == null ? "{}" : str.trim();
            } else if (i == 135) {
                String a2 = c.a();
                return a2 == null ? "0000000000000000000000000000000000000000" : a2.trim();
            } else if (i == 136) {
                try {
                    return this.f11399b.getPackageManager().getPackageInfo(this.f11399b.getPackageName(), 64).signatures[0].toByteArray();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return null;
                }
            } else if (i == 201) {
                return com.pgl.sys.ces.a.c.d(this.f11399b);
            } else {
                if (i == 202) {
                    return com.pgl.sys.ces.a.c.b();
                }
                return null;
            }
        }
    }

    public String debugEntry(Context context, int i) {
        return (String) a.meta(1024768, null, null);
    }

    public String onEvent() {
        return com.pgl.sys.a.a.a();
    }

    @Override // com.pgl.sys.ces.d.b
    public String pullSg() {
        return c.a();
    }

    @Override // com.pgl.sys.ces.d.b
    public String pullVer(String str) {
        return c.a(str);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.pgl.sys.ces.b$3] */
    @Override // com.pgl.sys.ces.d.b
    public void reportNow(final String str) {
        try {
            new Thread("CZL-LRT") { // from class: com.pgl.sys.ces.b.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        long timeInMillis = b.a().f11398a ? Calendar.getInstance().getTimeInMillis() : 0L;
                        byte[] bArr = (byte[]) a.meta(222, b.this.f11399b, str);
                        long timeInMillis2 = b.a().f11398a ? Calendar.getInstance().getTimeInMillis() : 0L;
                        if (b.a().f11398a) {
                            Log.d("CZL_Efficient", "[Efficient] report : " + (timeInMillis2 - timeInMillis));
                        }
                        if (bArr == null || bArr.length <= 0) {
                            throw new NullPointerException("NullPointerException");
                        }
                        new com.pgl.sys.ces.c.a(b.this.f11399b, b.this.h).d(1, 2, bArr);
                    } catch (Throwable th) {
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
        com.pgl.a.b.f.a(10000L);
        a("SP1");
        com.pgl.a.b.f.a(10000L);
        h();
        com.pgl.a.b.f.a(40000L);
        reportNow("CZL-L1st");
        while (true) {
            com.pgl.a.b.f.a(7200000L);
            if (i()) {
                reportNow("CZL-LLP");
                com.pgl.a.b.f.a(AppStatusRules.DEFAULT_GRANULARITY);
                a("CZL-LSP");
            }
        }
    }

    @Override // com.pgl.sys.ces.d.b
    public void setCustomInfo(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            n = hashMap;
        }
    }

    public void setEfficientDebug(boolean z) {
        this.f11398a = z;
    }

    @Override // com.pgl.sys.ces.d.b
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
        } catch (Throwable th) {
        }
    }
}
