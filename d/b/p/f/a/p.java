package d.b.p.f.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class p implements l {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static HashMap<String, Integer> f65081a;

        /* renamed from: b  reason: collision with root package name */
        public static a f65082b;

        /* renamed from: d.b.p.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1764a {

            /* renamed from: a  reason: collision with root package name */
            public String f65083a;

            /* renamed from: b  reason: collision with root package name */
            public String f65084b;

            /* renamed from: c  reason: collision with root package name */
            public String f65085c;

            /* renamed from: d  reason: collision with root package name */
            public int f65086d;

            public C1764a(Context context) {
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                        this.f65083a = lowerCase;
                        this.f65084b = "10.0.0.172";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.f65083a = lowerCase;
                        this.f65084b = "10.0.0.200";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                        this.f65083a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                this.f65084b = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f65084b.trim())) {
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
                        this.f65085c = "wifi";
                    } else {
                        a(context, networkInfo);
                        this.f65085c = this.f65083a;
                    }
                    this.f65086d = networkInfo.getSubtype();
                    networkInfo.getSubtypeName();
                }
            }

            public int c() {
                return this.f65086d;
            }

            public String d() {
                return this.f65085c;
            }
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            f65081a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f65081a.put("3GNET", 21);
            f65081a.put("3GWAP", 22);
            f65081a.put("CMNET", 31);
            f65081a.put("UNINET", 32);
            f65081a.put("CTNET", 33);
            f65081a.put("CMWAP", 41);
            f65081a.put("UNIWAP", 42);
            f65081a.put("CTWAP", 43);
            f65082b = new a();
        }

        public static a a() {
            return f65082b;
        }

        public String b(Context context) {
            StringBuilder sb;
            C1764a c1764a = new C1764a(context);
            String d2 = c1764a.d();
            int c2 = c1764a.c();
            if (TextUtils.isEmpty(d2)) {
                sb = new StringBuilder();
            } else {
                Integer num = f65081a.get(d2.toUpperCase());
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
        public static b f65087c = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f65088a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f65089b;

        public static b a() {
            return f65087c;
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
                if (TextUtils.isEmpty(this.f65088a)) {
                    this.f65088a = c(context);
                }
            }
            return this.f65088a;
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
            DisplayMetrics displayMetrics = this.f65089b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public final int f(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f65089b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public final int g(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f65089b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public final void h(Context context) {
            if (context != null && this.f65089b == null) {
                this.f65089b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static c f65090e = new c();

        /* renamed from: a  reason: collision with root package name */
        public String f65091a;

        /* renamed from: b  reason: collision with root package name */
        public String f65092b;

        /* renamed from: c  reason: collision with root package name */
        public String f65093c;

        /* renamed from: d  reason: collision with root package name */
        public String f65094d;

        public c() {
            c();
        }

        public static c a() {
            return f65090e;
        }

        public String b() {
            return this.f65094d;
        }

        public final void c() {
            String str = Build.MODEL;
            this.f65091a = str;
            if (TextUtils.isEmpty(str)) {
                this.f65091a = "NUL";
            } else {
                this.f65091a = this.f65091a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f65092b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f65092b = "NUL";
            } else {
                this.f65092b = this.f65092b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f65093c = str3;
            this.f65093c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f65093c.replace("_", "-");
            this.f65094d = d();
        }

        public final String d() {
            String str = this.f65091a;
            String str2 = this.f65093c;
            int i = Build.VERSION.SDK_INT;
            String str3 = this.f65092b;
            return str + "_" + str2 + "_" + i + "_" + str3;
        }
    }

    @Override // d.b.p.f.a.l
    public String a() {
        return c.a().b();
    }

    @Override // d.b.p.f.a.l
    public String a(Context context) {
        return b.a().b(context);
    }

    @Override // d.b.p.f.a.l
    public long b() {
        return System.currentTimeMillis();
    }

    @Override // d.b.p.f.a.l
    public String b(Context context) {
        return (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName();
    }

    @Override // d.b.p.f.a.l
    public String c(Context context) {
        return d.b.p.b.d(context).f();
    }

    @Override // d.b.p.f.a.l
    public String d(Context context) {
        return a.a().b(context);
    }
}
