package d.a.i0.a.s2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import d.a.i0.a.k;
import d.a.i0.a.l;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44515a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44516b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static String f44517f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f44518g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f44519h = "(Baidu; P1 %s)";

        /* renamed from: i  reason: collision with root package name */
        public static String f44520i = "%s/%s";

        /* renamed from: a  reason: collision with root package name */
        public String f44521a;

        /* renamed from: b  reason: collision with root package name */
        public String f44522b;

        /* renamed from: c  reason: collision with root package name */
        public String f44523c;

        /* renamed from: d  reason: collision with root package name */
        public String f44524d;

        /* renamed from: e  reason: collision with root package name */
        public String f44525e;

        public String a() {
            String format = String.format(f44517f, this.f44521a, this.f44522b);
            String format2 = String.format(f44518g, this.f44521a, this.f44523c, this.f44524d);
            String format3 = String.format(f44520i, this.f44523c, this.f44524d);
            String format4 = String.format(f44519h, this.f44525e);
            if (e()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        public a b(String str) {
            this.f44521a = str;
            return this;
        }

        public a c(String str) {
            this.f44523c = str;
            return this;
        }

        public a d(String str) {
            this.f44524d = str;
            return this;
        }

        public final boolean e() {
            return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f44523c);
        }

        public a f(String str) {
            this.f44525e = str;
            return this;
        }

        public a g(String str) {
            this.f44522b = str;
            return this;
        }
    }

    public static Context a() {
        return d.a.i0.a.c1.a.b();
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
        String a2 = d.a.i0.a.c1.a.m().a();
        a aVar = new a();
        aVar.b(str);
        aVar.g(l.a());
        aVar.c(a2);
        aVar.d(f());
        aVar.f(b());
        return aVar.a();
    }

    public static String f() {
        if (!TextUtils.isEmpty(f44516b)) {
            return f44516b;
        }
        try {
            String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            f44516b = str;
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f44515a) {
                e2.printStackTrace();
                return "0.8";
            }
            return "0.8";
        }
    }
}
