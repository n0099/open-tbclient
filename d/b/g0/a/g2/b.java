package d.b.g0.a.g2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import d.b.g0.a.k;
import d.b.g0.a.l;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44594a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44595b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static String f44596f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f44597g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f44598h = "(Baidu; P1 %s)";
        public static String i = "%s/%s";

        /* renamed from: a  reason: collision with root package name */
        public String f44599a;

        /* renamed from: b  reason: collision with root package name */
        public String f44600b;

        /* renamed from: c  reason: collision with root package name */
        public String f44601c;

        /* renamed from: d  reason: collision with root package name */
        public String f44602d;

        /* renamed from: e  reason: collision with root package name */
        public String f44603e;

        public String a() {
            String format = String.format(f44596f, this.f44599a, this.f44600b);
            String format2 = String.format(f44597g, this.f44599a, this.f44601c, this.f44602d);
            String format3 = String.format(i, this.f44601c, this.f44602d);
            String format4 = String.format(f44598h, this.f44603e);
            if (e()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        public a b(String str) {
            this.f44599a = str;
            return this;
        }

        public a c(String str) {
            this.f44601c = str;
            return this;
        }

        public a d(String str) {
            this.f44602d = str;
            return this;
        }

        public final boolean e() {
            return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f44601c);
        }

        public a f(String str) {
            this.f44603e = str;
            return this;
        }

        public a g(String str) {
            this.f44600b = str;
            return this;
        }
    }

    public static Context a() {
        return d.b.g0.a.w0.a.c();
    }

    public static String b() {
        String str = Build.VERSION.RELEASE;
        return TextUtils.isEmpty(str) ? "0.0" : str.replace("_", "-");
    }

    public static String c() {
        return e(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME);
    }

    public static String d() {
        return e("swan");
    }

    public static String e(String str) {
        String g2 = d.b.g0.a.w0.a.k().g();
        a aVar = new a();
        aVar.b(str);
        aVar.g(l.a());
        aVar.c(g2);
        aVar.d(f());
        aVar.f(b());
        return aVar.a();
    }

    public static String f() {
        if (!TextUtils.isEmpty(f44595b)) {
            return f44595b;
        }
        try {
            String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            f44595b = str;
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f44594a) {
                e2.printStackTrace();
                return "0.8";
            }
            return "0.8";
        }
    }
}
