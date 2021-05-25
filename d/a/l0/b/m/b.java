package d.a.l0.b.m;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.e2.c.h;
import d.a.l0.a.k;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46292a = k.f43199a;

    static {
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception unused) {
        }
    }

    public void a() {
        if (d.a.l0.a.v2.d.f()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }

    @Override // d.a.l0.a.e2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        String str2 = "";
        try {
            str2 = CookieManager.getInstance().getCookie(str);
            if (f46292a) {
                Log.d("RealCookieManager", "RealCookieManager:" + str2);
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        if (f46292a) {
            Log.d("RealCookieManager", "storeCookie httpUrl: " + str);
            Log.d("RealCookieManager", "storeCookie cookies: " + list);
        }
        try {
            for (String str2 : list) {
                CookieManager.getInstance().setCookie(str, str2);
            }
            a();
        } catch (Exception unused) {
        }
    }
}
