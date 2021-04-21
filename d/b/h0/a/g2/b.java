package d.b.h0.a.g2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import d.b.h0.a.k;
import d.b.h0.a.l;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45315a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45316b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static String f45317f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f45318g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f45319h = "(Baidu; P1 %s)";
        public static String i = "%s/%s";

        /* renamed from: a  reason: collision with root package name */
        public String f45320a;

        /* renamed from: b  reason: collision with root package name */
        public String f45321b;

        /* renamed from: c  reason: collision with root package name */
        public String f45322c;

        /* renamed from: d  reason: collision with root package name */
        public String f45323d;

        /* renamed from: e  reason: collision with root package name */
        public String f45324e;

        public String a() {
            String format = String.format(f45317f, this.f45320a, this.f45321b);
            String format2 = String.format(f45318g, this.f45320a, this.f45322c, this.f45323d);
            String format3 = String.format(i, this.f45322c, this.f45323d);
            String format4 = String.format(f45319h, this.f45324e);
            if (e()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        public a b(String str) {
            this.f45320a = str;
            return this;
        }

        public a c(String str) {
            this.f45322c = str;
            return this;
        }

        public a d(String str) {
            this.f45323d = str;
            return this;
        }

        public final boolean e() {
            return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f45322c);
        }

        public a f(String str) {
            this.f45324e = str;
            return this;
        }

        public a g(String str) {
            this.f45321b = str;
            return this;
        }
    }

    public static Context a() {
        return d.b.h0.a.w0.a.c();
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
        String g2 = d.b.h0.a.w0.a.k().g();
        a aVar = new a();
        aVar.b(str);
        aVar.g(l.a());
        aVar.c(g2);
        aVar.d(f());
        aVar.f(b());
        return aVar.a();
    }

    public static String f() {
        if (!TextUtils.isEmpty(f45316b)) {
            return f45316b;
        }
        try {
            String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            f45316b = str;
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f45315a) {
                e2.printStackTrace();
                return "0.8";
            }
            return "0.8";
        }
    }
}
