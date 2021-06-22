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
        public static HashMap<String, Integer> f67851a;

        /* renamed from: b  reason: collision with root package name */
        public static a f67852b;

        /* renamed from: d.a.q.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1847a {

            /* renamed from: a  reason: collision with root package name */
            public String f67853a;

            /* renamed from: b  reason: collision with root package name */
            public String f67854b;

            /* renamed from: c  reason: collision with root package name */
            public String f67855c;

            /* renamed from: d  reason: collision with root package name */
            public int f67856d;

            public C1847a(Context context) {
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                        this.f67853a = lowerCase;
                        this.f67854b = "10.0.0.172";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.f67853a = lowerCase;
                        this.f67854b = "10.0.0.200";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                        this.f67853a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                this.f67854b = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f67854b.trim())) {
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
                        this.f67855c = "wifi";
                    } else {
                        a(context, networkInfo);
                        this.f67855c = this.f67853a;
                    }
                    this.f67856d = networkInfo.getSubtype();
                    networkInfo.getSubtypeName();
                }
            }

            public int c() {
                return this.f67856d;
            }

            public String d() {
                return this.f67855c;
            }
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            f67851a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f67851a.put("3GNET", 21);
            f67851a.put("3GWAP", 22);
            f67851a.put("CMNET", 31);
            f67851a.put("UNINET", 32);
            f67851a.put("CTNET", 33);
            f67851a.put("CMWAP", 41);
            f67851a.put("UNIWAP", 42);
            f67851a.put("CTWAP", 43);
            f67852b = new a();
        }

        public static a a() {
            return f67852b;
        }

        public String b(Context context) {
            StringBuilder sb;
            C1847a c1847a = new C1847a(context);
            String d2 = c1847a.d();
            int c2 = c1847a.c();
            if (TextUtils.isEmpty(d2)) {
                sb = new StringBuilder();
            } else {
                Integer num = f67851a.get(d2.toUpperCase());
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
        public static b f67857c = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f67858a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f67859b;

        public static b a() {
            return f67857c;
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
                if (TextUtils.isEmpty(this.f67858a)) {
                    this.f67858a = c(context);
                }
            }
            return this.f67858a;
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
            DisplayMetrics displayMetrics = this.f67859b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public final int f(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f67859b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public final int g(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f67859b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public final void h(Context context) {
            if (context != null && this.f67859b == null) {
                this.f67859b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static c f67860e = new c();

        /* renamed from: a  reason: collision with root package name */
        public String f67861a;

        /* renamed from: b  reason: collision with root package name */
        public String f67862b;

        /* renamed from: c  reason: collision with root package name */
        public String f67863c;

        /* renamed from: d  reason: collision with root package name */
        public String f67864d;

        public c() {
            c();
        }

        public static c a() {
            return f67860e;
        }

        public String b() {
            return this.f67864d;
        }

        public final void c() {
            String str = Build.MODEL;
            this.f67861a = str;
            if (TextUtils.isEmpty(str)) {
                this.f67861a = "NUL";
            } else {
                this.f67861a = this.f67861a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f67862b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f67862b = "NUL";
            } else {
                this.f67862b = this.f67862b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f67863c = str3;
            this.f67863c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f67863c.replace("_", "-");
            this.f67864d = d();
        }

        public final String d() {
            String str = this.f67861a;
            String str2 = this.f67863c;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = this.f67862b;
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
