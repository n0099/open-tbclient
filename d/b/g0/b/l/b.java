package d.b.g0.b.l;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import d.b.g0.a.v1.c.g;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47722a = k.f45443a;

    static {
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception unused) {
        }
    }

    public void a() {
        if (d.b.g0.a.i2.c.f()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }

    @Override // d.b.g0.a.v1.c.g, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        String str2 = "";
        try {
            str2 = CookieManager.getInstance().getCookie(str);
            if (f47722a) {
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
        if (f47722a) {
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
