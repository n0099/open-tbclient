package d.a.l0.a.s2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import d.a.l0.a.k;
import d.a.l0.a.l;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44691a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44692b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static String f44693f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f44694g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f44695h = "(Baidu; P1 %s)";

        /* renamed from: i  reason: collision with root package name */
        public static String f44696i = "%s/%s";

        /* renamed from: a  reason: collision with root package name */
        public String f44697a;

        /* renamed from: b  reason: collision with root package name */
        public String f44698b;

        /* renamed from: c  reason: collision with root package name */
        public String f44699c;

        /* renamed from: d  reason: collision with root package name */
        public String f44700d;

        /* renamed from: e  reason: collision with root package name */
        public String f44701e;

        public String a() {
            String format = String.format(f44693f, this.f44697a, this.f44698b);
            String format2 = String.format(f44694g, this.f44697a, this.f44699c, this.f44700d);
            String format3 = String.format(f44696i, this.f44699c, this.f44700d);
            String format4 = String.format(f44695h, this.f44701e);
            if (e()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        public a b(String str) {
            this.f44697a = str;
            return this;
        }

        public a c(String str) {
            this.f44699c = str;
            return this;
        }

        public a d(String str) {
            this.f44700d = str;
            return this;
        }

        public final boolean e() {
            return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f44699c);
        }

        public a f(String str) {
            this.f44701e = str;
            return this;
        }

        public a g(String str) {
            this.f44698b = str;
            return this;
        }
    }

    public static Context a() {
        return d.a.l0.a.c1.a.b();
    }

    public static String b() {
        String str = Build.VERSION.RELEASE;
        return TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
    }

    public static String c() {
        return e(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME);
    }

    public static String d() {
        return e("swan");
    }

    public static String e(String str) {
        String a2 = d.a.l0.a.c1.a.m().a();
        a aVar = new a();
        aVar.b(str);
        aVar.g(l.a());
        aVar.c(a2);
        aVar.d(f());
        aVar.f(b());
        return aVar.a();
    }

    public static String f() {
        if (!TextUtils.isEmpty(f44692b)) {
            return f44692b;
        }
        try {
            String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            f44692b = str;
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f44691a) {
                e2.printStackTrace();
                return "0.8";
            }
            return "0.8";
        }
    }
}
