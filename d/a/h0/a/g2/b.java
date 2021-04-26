package d.a.h0.a.g2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import d.a.h0.a.k;
import d.a.h0.a.l;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42629a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42630b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static String f42631f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f42632g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f42633h = "(Baidu; P1 %s)";

        /* renamed from: i  reason: collision with root package name */
        public static String f42634i = "%s/%s";

        /* renamed from: a  reason: collision with root package name */
        public String f42635a;

        /* renamed from: b  reason: collision with root package name */
        public String f42636b;

        /* renamed from: c  reason: collision with root package name */
        public String f42637c;

        /* renamed from: d  reason: collision with root package name */
        public String f42638d;

        /* renamed from: e  reason: collision with root package name */
        public String f42639e;

        public String a() {
            String format = String.format(f42631f, this.f42635a, this.f42636b);
            String format2 = String.format(f42632g, this.f42635a, this.f42637c, this.f42638d);
            String format3 = String.format(f42634i, this.f42637c, this.f42638d);
            String format4 = String.format(f42633h, this.f42639e);
            if (e()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        public a b(String str) {
            this.f42635a = str;
            return this;
        }

        public a c(String str) {
            this.f42637c = str;
            return this;
        }

        public a d(String str) {
            this.f42638d = str;
            return this;
        }

        public final boolean e() {
            return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f42637c);
        }

        public a f(String str) {
            this.f42639e = str;
            return this;
        }

        public a g(String str) {
            this.f42636b = str;
            return this;
        }
    }

    public static Context a() {
        return d.a.h0.a.w0.a.c();
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
        String f2 = d.a.h0.a.w0.a.k().f();
        a aVar = new a();
        aVar.b(str);
        aVar.g(l.a());
        aVar.c(f2);
        aVar.d(f());
        aVar.f(b());
        return aVar.a();
    }

    public static String f() {
        if (!TextUtils.isEmpty(f42630b)) {
            return f42630b;
        }
        try {
            String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            f42630b = str;
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f42629a) {
                e2.printStackTrace();
                return "0.8";
            }
            return "0.8";
        }
    }
}
