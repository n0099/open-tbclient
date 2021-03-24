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
    public static final boolean f44593a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44594b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static String f44595f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f44596g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f44597h = "(Baidu; P1 %s)";
        public static String i = "%s/%s";

        /* renamed from: a  reason: collision with root package name */
        public String f44598a;

        /* renamed from: b  reason: collision with root package name */
        public String f44599b;

        /* renamed from: c  reason: collision with root package name */
        public String f44600c;

        /* renamed from: d  reason: collision with root package name */
        public String f44601d;

        /* renamed from: e  reason: collision with root package name */
        public String f44602e;

        public String a() {
            String format = String.format(f44595f, this.f44598a, this.f44599b);
            String format2 = String.format(f44596g, this.f44598a, this.f44600c, this.f44601d);
            String format3 = String.format(i, this.f44600c, this.f44601d);
            String format4 = String.format(f44597h, this.f44602e);
            if (e()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        public a b(String str) {
            this.f44598a = str;
            return this;
        }

        public a c(String str) {
            this.f44600c = str;
            return this;
        }

        public a d(String str) {
            this.f44601d = str;
            return this;
        }

        public final boolean e() {
            return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f44600c);
        }

        public a f(String str) {
            this.f44602e = str;
            return this;
        }

        public a g(String str) {
            this.f44599b = str;
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
        if (!TextUtils.isEmpty(f44594b)) {
            return f44594b;
        }
        try {
            String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            f44594b = str;
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f44593a) {
                e2.printStackTrace();
                return "0.8";
            }
            return "0.8";
        }
    }
}
