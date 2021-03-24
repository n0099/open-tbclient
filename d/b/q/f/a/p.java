package d.b.q.f.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class p implements l {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static HashMap<String, Integer> f64386a;

        /* renamed from: b  reason: collision with root package name */
        public static a f64387b;

        /* renamed from: d.b.q.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1751a {

            /* renamed from: a  reason: collision with root package name */
            public String f64388a;

            /* renamed from: b  reason: collision with root package name */
            public String f64389b;

            /* renamed from: c  reason: collision with root package name */
            public String f64390c;

            /* renamed from: d  reason: collision with root package name */
            public int f64391d;

            public C1751a(Context context) {
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                        this.f64388a = lowerCase;
                        this.f64389b = "10.0.0.172";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.f64388a = lowerCase;
                        this.f64389b = "10.0.0.200";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                        this.f64388a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                this.f64389b = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f64389b.trim())) {
                    return;
                }
                Integer.toString(defaultPort);
            }

            @SuppressLint({"MissingPermission"})
            public final void b(Context context) {
                NetworkInfo networkInfo;
                try {
                    networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception unused) {
                    networkInfo = null;
                }
                if (networkInfo != null) {
                    if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                        this.f64390c = "wifi";
                    } else {
                        a(context, networkInfo);
                        this.f64390c = this.f64388a;
                    }
                    this.f64391d = networkInfo.getSubtype();
                    networkInfo.getSubtypeName();
                }
            }

            public int c() {
                return this.f64391d;
            }

            public String d() {
                return this.f64390c;
            }
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            f64386a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f64386a.put("3GNET", 21);
            f64386a.put("3GWAP", 22);
            f64386a.put("CMNET", 31);
            f64386a.put("UNINET", 32);
            f64386a.put("CTNET", 33);
            f64386a.put("CMWAP", 41);
            f64386a.put("UNIWAP", 42);
            f64386a.put("CTWAP", 43);
            f64387b = new a();
        }

        public static a a() {
            return f64387b;
        }

        public String b(Context context) {
            StringBuilder sb;
            C1751a c1751a = new C1751a(context);
            String d2 = c1751a.d();
            int c2 = c1751a.c();
            if (TextUtils.isEmpty(d2)) {
                sb = new StringBuilder();
            } else {
                Integer num = f64386a.get(d2.toUpperCase());
                r3 = num != null ? num : 5;
                sb = new StringBuilder();
            }
            sb.append(r3);
            sb.append("_");
            sb.append(c2);
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        public static b f64392c = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f64393a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f64394b;

        public static b a() {
            return f64392c;
        }

        public static String d(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "0.8";
            }
        }

        public String b(Context context) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(this.f64393a)) {
                    this.f64393a = c(context);
                }
            }
            return this.f64393a;
        }

        public final String c(Context context) {
            int e2 = e(context.getApplicationContext());
            int f2 = f(context.getApplicationContext());
            int g2 = g(context.getApplicationContext());
            String d2 = d(context.getApplicationContext());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(e2);
            stringBuffer.append("_");
            stringBuffer.append(f2);
            stringBuffer.append("_");
            stringBuffer.append("android");
            stringBuffer.append("_");
            stringBuffer.append(d2);
            stringBuffer.append("_");
            stringBuffer.append(g2);
            return stringBuffer.toString();
        }

        public final int e(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f64394b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public final int f(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f64394b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public final int g(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f64394b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public final void h(Context context) {
            if (context != null && this.f64394b == null) {
                this.f64394b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static c f64395e = new c();

        /* renamed from: a  reason: collision with root package name */
        public String f64396a;

        /* renamed from: b  reason: collision with root package name */
        public String f64397b;

        /* renamed from: c  reason: collision with root package name */
        public String f64398c;

        /* renamed from: d  reason: collision with root package name */
        public String f64399d;

        public c() {
            c();
        }

        public static c a() {
            return f64395e;
        }

        public String b() {
            return this.f64399d;
        }

        public final void c() {
            String str = Build.MODEL;
            this.f64396a = str;
            if (TextUtils.isEmpty(str)) {
                this.f64396a = "NUL";
            } else {
                this.f64396a = this.f64396a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f64397b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f64397b = "NUL";
            } else {
                this.f64397b = this.f64397b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f64398c = str3;
            this.f64398c = TextUtils.isEmpty(str3) ? "0.0" : this.f64398c.replace("_", "-");
            this.f64399d = d();
        }

        public final String d() {
            String str = this.f64396a;
            String str2 = this.f64398c;
            int i = Build.VERSION.SDK_INT;
            String str3 = this.f64397b;
            return str + "_" + str2 + "_" + i + "_" + str3;
        }
    }

    @Override // d.b.q.f.a.l
    public String a() {
        return c.a().b();
    }

    @Override // d.b.q.f.a.l
    public String a(Context context) {
        return b.a().b(context);
    }

    @Override // d.b.q.f.a.l
    public long b() {
        return System.currentTimeMillis();
    }

    @Override // d.b.q.f.a.l
    public String b(Context context) {
        return (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName();
    }

    @Override // d.b.q.f.a.l
    public String c(Context context) {
        return d.b.q.b.d(context).f();
    }

    @Override // d.b.q.f.a.l
    public String d(Context context) {
        return a.a().b(context);
    }
}
