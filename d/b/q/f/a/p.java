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
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class p implements l {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static HashMap<String, Integer> f65345a;

        /* renamed from: b  reason: collision with root package name */
        public static a f65346b;

        /* renamed from: d.b.q.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1783a {

            /* renamed from: a  reason: collision with root package name */
            public String f65347a;

            /* renamed from: b  reason: collision with root package name */
            public String f65348b;

            /* renamed from: c  reason: collision with root package name */
            public String f65349c;

            /* renamed from: d  reason: collision with root package name */
            public int f65350d;

            public C1783a(Context context) {
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                        this.f65347a = lowerCase;
                        this.f65348b = "10.0.0.172";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.f65347a = lowerCase;
                        this.f65348b = "10.0.0.200";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                        this.f65347a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                this.f65348b = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f65348b.trim())) {
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
                        this.f65349c = "wifi";
                    } else {
                        a(context, networkInfo);
                        this.f65349c = this.f65347a;
                    }
                    this.f65350d = networkInfo.getSubtype();
                    networkInfo.getSubtypeName();
                }
            }

            public int c() {
                return this.f65350d;
            }

            public String d() {
                return this.f65349c;
            }
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            f65345a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f65345a.put("3GNET", 21);
            f65345a.put("3GWAP", 22);
            f65345a.put("CMNET", 31);
            f65345a.put("UNINET", 32);
            f65345a.put("CTNET", 33);
            f65345a.put("CMWAP", 41);
            f65345a.put("UNIWAP", 42);
            f65345a.put("CTWAP", 43);
            f65346b = new a();
        }

        public static a a() {
            return f65346b;
        }

        public String b(Context context) {
            StringBuilder sb;
            C1783a c1783a = new C1783a(context);
            String d2 = c1783a.d();
            int c2 = c1783a.c();
            if (TextUtils.isEmpty(d2)) {
                sb = new StringBuilder();
            } else {
                Integer num = f65345a.get(d2.toUpperCase());
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
        public static b f65351c = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f65352a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f65353b;

        public static b a() {
            return f65351c;
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
                if (TextUtils.isEmpty(this.f65352a)) {
                    this.f65352a = c(context);
                }
            }
            return this.f65352a;
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
            DisplayMetrics displayMetrics = this.f65353b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public final int f(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f65353b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public final int g(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f65353b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public final void h(Context context) {
            if (context != null && this.f65353b == null) {
                this.f65353b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static c f65354e = new c();

        /* renamed from: a  reason: collision with root package name */
        public String f65355a;

        /* renamed from: b  reason: collision with root package name */
        public String f65356b;

        /* renamed from: c  reason: collision with root package name */
        public String f65357c;

        /* renamed from: d  reason: collision with root package name */
        public String f65358d;

        public c() {
            c();
        }

        public static c a() {
            return f65354e;
        }

        public String b() {
            return this.f65358d;
        }

        public final void c() {
            String str = Build.MODEL;
            this.f65355a = str;
            if (TextUtils.isEmpty(str)) {
                this.f65355a = "NUL";
            } else {
                this.f65355a = this.f65355a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f65356b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f65356b = "NUL";
            } else {
                this.f65356b = this.f65356b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f65357c = str3;
            this.f65357c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f65357c.replace("_", "-");
            this.f65358d = d();
        }

        public final String d() {
            String str = this.f65355a;
            String str2 = this.f65357c;
            int i = Build.VERSION.SDK_INT;
            String str3 = this.f65356b;
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
