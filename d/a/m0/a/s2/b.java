package d.a.m0.a.s2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import d.a.m0.a.k;
import d.a.m0.a.l;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48473a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static String f48474b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static String f48475f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f48476g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f48477h = "(Baidu; P1 %s)";

        /* renamed from: i  reason: collision with root package name */
        public static String f48478i = "%s/%s";

        /* renamed from: a  reason: collision with root package name */
        public String f48479a;

        /* renamed from: b  reason: collision with root package name */
        public String f48480b;

        /* renamed from: c  reason: collision with root package name */
        public String f48481c;

        /* renamed from: d  reason: collision with root package name */
        public String f48482d;

        /* renamed from: e  reason: collision with root package name */
        public String f48483e;

        public String a() {
            String format = String.format(f48475f, this.f48479a, this.f48480b);
            String format2 = String.format(f48476g, this.f48479a, this.f48481c, this.f48482d);
            String format3 = String.format(f48478i, this.f48481c, this.f48482d);
            String format4 = String.format(f48477h, this.f48483e);
            if (e()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        public a b(String str) {
            this.f48479a = str;
            return this;
        }

        public a c(String str) {
            this.f48481c = str;
            return this;
        }

        public a d(String str) {
            this.f48482d = str;
            return this;
        }

        public final boolean e() {
            return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f48481c);
        }

        public a f(String str) {
            this.f48483e = str;
            return this;
        }

        public a g(String str) {
            this.f48480b = str;
            return this;
        }
    }

    public static Context a() {
        return d.a.m0.a.c1.a.b();
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
        String a2 = d.a.m0.a.c1.a.m().a();
        a aVar = new a();
        aVar.b(str);
        aVar.g(l.a());
        aVar.c(a2);
        aVar.d(f());
        aVar.f(b());
        return aVar.a();
    }

    public static String f() {
        if (!TextUtils.isEmpty(f48474b)) {
            return f48474b;
        }
        try {
            String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            f48474b = str;
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f48473a) {
                e2.printStackTrace();
                return "0.8";
            }
            return "0.8";
        }
    }
}
