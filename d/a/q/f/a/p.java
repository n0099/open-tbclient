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
        public static HashMap<String, Integer> f63664a;

        /* renamed from: b  reason: collision with root package name */
        public static a f63665b;

        /* renamed from: d.a.q.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1721a {

            /* renamed from: a  reason: collision with root package name */
            public String f63666a;

            /* renamed from: b  reason: collision with root package name */
            public String f63667b;

            /* renamed from: c  reason: collision with root package name */
            public String f63668c;

            /* renamed from: d  reason: collision with root package name */
            public int f63669d;

            public C1721a(Context context) {
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                        this.f63666a = lowerCase;
                        this.f63667b = "10.0.0.172";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.f63666a = lowerCase;
                        this.f63667b = "10.0.0.200";
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                        this.f63666a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                this.f63667b = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f63667b.trim())) {
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
                        this.f63668c = "wifi";
                    } else {
                        a(context, networkInfo);
                        this.f63668c = this.f63666a;
                    }
                    this.f63669d = networkInfo.getSubtype();
                    networkInfo.getSubtypeName();
                }
            }

            public int c() {
                return this.f63669d;
            }

            public String d() {
                return this.f63668c;
            }
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            f63664a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f63664a.put("3GNET", 21);
            f63664a.put("3GWAP", 22);
            f63664a.put("CMNET", 31);
            f63664a.put("UNINET", 32);
            f63664a.put("CTNET", 33);
            f63664a.put("CMWAP", 41);
            f63664a.put("UNIWAP", 42);
            f63664a.put("CTWAP", 43);
            f63665b = new a();
        }

        public static a a() {
            return f63665b;
        }

        public String b(Context context) {
            StringBuilder sb;
            C1721a c1721a = new C1721a(context);
            String d2 = c1721a.d();
            int c2 = c1721a.c();
            if (TextUtils.isEmpty(d2)) {
                sb = new StringBuilder();
            } else {
                Integer num = f63664a.get(d2.toUpperCase());
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
        public static b f63670c = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f63671a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f63672b;

        public static b a() {
            return f63670c;
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
                if (TextUtils.isEmpty(this.f63671a)) {
                    this.f63671a = c(context);
                }
            }
            return this.f63671a;
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
            DisplayMetrics displayMetrics = this.f63672b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public final int f(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f63672b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public final int g(Context context) {
            h(context);
            DisplayMetrics displayMetrics = this.f63672b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public final void h(Context context) {
            if (context != null && this.f63672b == null) {
                this.f63672b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static c f63673e = new c();

        /* renamed from: a  reason: collision with root package name */
        public String f63674a;

        /* renamed from: b  reason: collision with root package name */
        public String f63675b;

        /* renamed from: c  reason: collision with root package name */
        public String f63676c;

        /* renamed from: d  reason: collision with root package name */
        public String f63677d;

        public c() {
            c();
        }

        public static c a() {
            return f63673e;
        }

        public String b() {
            return this.f63677d;
        }

        public final void c() {
            String str = Build.MODEL;
            this.f63674a = str;
            if (TextUtils.isEmpty(str)) {
                this.f63674a = "NUL";
            } else {
                this.f63674a = this.f63674a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f63675b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f63675b = "NUL";
            } else {
                this.f63675b = this.f63675b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f63676c = str3;
            this.f63676c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f63676c.replace("_", "-");
            this.f63677d = d();
        }

        public final String d() {
            String str = this.f63674a;
            String str2 = this.f63676c;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = this.f63675b;
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
