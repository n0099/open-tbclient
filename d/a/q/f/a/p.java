package d.a.q.f.a;

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
        public static HashMap<String, Integer> f64177a;

        /* renamed from: b  reason: collision with root package name */
        public static a f64178b;

        /* renamed from: d.a.q.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1787a {

            /* renamed from: a  reason: collision with root package name */
            public String f64179a;

            /* renamed from: b  reason: collision with root package name */
            public String f64180b;

            /* renamed from: c  reason: collision with root package name */
            public String f64181c;

            /* renamed from: d  reason: collision with root package name */
            public int f64182d;

            public C1787a(Context context) {
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                        this.f64179a = lowerCase;
                        this.f64180b = "10.0.0.172";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.f64179a = lowerCase;
                        this.f64180b = "10.0.0.200";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                        this.f64179a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                this.f64180b = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f64180b.trim())) {
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
                        this.f64181c = "wifi";
                    } else {
                        a(context, networkInfo);
                        this.f64181c = this.f64179a;
                    }
                    this.f64182d = networkInfo.getSubtype();
                    networkInfo.getSubtypeName();
                }
            }

            public int c() {
                return this.f64182d;
            }

            public String d() {
                return this.f64181c;
            }
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            f64177a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f64177a.put("3GNET", 21);
            f64177a.put("3GWAP", 22);
            f64177a.put("CMNET", 31);
            f64177a.put("UNINET", 32);
            f64177a.put("CTNET", 33);
            f64177a.put("CMWAP", 41);
            f64177a.put("UNIWAP", 42);
            f64177a.put("CTWAP", 43);
            f64178b = new a();
        }

        public static a a() {
            return f64178b;
        }

        public String b(Context context) {
            StringBuilder sb;
            C1787a c1787a = new C1787a(context);
            String d2 = c1787a.d();
            int c2 = c1787a.c();
            if (TextUtils.isEmpty(d2)) {
                sb = new StringBuilder();
            } else {
                Integer num = f64177a.get(d2.toUpperCase());
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
        public static b f64183c = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f64184a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f64185b;

        public static b a() {
            return f64183c;
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
                if (TextUtils.isEmpty(this.f64184a)) {
                    this.f64184a = c(context);
                }
            }
            return this.f64184a;
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
            DisplayMetrics displayMetrics = this.f64185b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public final int f(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f64185b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public final int g(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f64185b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public final void h(Context context) {
            if (context != null && this.f64185b == null) {
                this.f64185b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static c f64186e = new c();

        /* renamed from: a  reason: collision with root package name */
        public String f64187a;

        /* renamed from: b  reason: collision with root package name */
        public String f64188b;

        /* renamed from: c  reason: collision with root package name */
        public String f64189c;

        /* renamed from: d  reason: collision with root package name */
        public String f64190d;

        public c() {
            c();
        }

        public static c a() {
            return f64186e;
        }

        public String b() {
            return this.f64190d;
        }

        public final void c() {
            String str = Build.MODEL;
            this.f64187a = str;
            if (TextUtils.isEmpty(str)) {
                this.f64187a = "NUL";
            } else {
                this.f64187a = this.f64187a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f64188b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f64188b = "NUL";
            } else {
                this.f64188b = this.f64188b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f64189c = str3;
            this.f64189c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f64189c.replace("_", "-");
            this.f64190d = d();
        }

        public final String d() {
            String str = this.f64187a;
            String str2 = this.f64189c;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = this.f64188b;
            return str + "_" + str2 + "_" + i2 + "_" + str3;
        }
    }

    @Override // d.a.q.f.a.l
    public String a() {
        return c.a().b();
    }

    @Override // d.a.q.f.a.l
    public String a(Context context) {
        return b.a().b(context);
    }

    @Override // d.a.q.f.a.l
    public long b() {
        return System.currentTimeMillis();
    }

    @Override // d.a.q.f.a.l
    public String b(Context context) {
        return (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName();
    }

    @Override // d.a.q.f.a.l
    public String c(Context context) {
        return d.a.q.b.d(context).f();
    }

    @Override // d.a.q.f.a.l
    public String d(Context context) {
        return a.a().b(context);
    }
}
