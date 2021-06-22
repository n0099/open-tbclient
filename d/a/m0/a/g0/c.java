package d.a.m0.a.g0;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import d.a.m0.a.e2.c.h;
import d.a.m0.a.k;
import d.a.m0.a.v2.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45672a = k.f46983a;

    static {
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception e2) {
            if (f45672a) {
                Log.w("RealCookieManager", "static createInstance err=" + e2 + " trace=" + Log.getStackTraceString(e2));
            }
        }
    }

    public void a() {
        if (d.f()) {
            if (f45672a) {
                Log.i("RealCookieManager", "syncCookie: hasLollipop flush");
            }
            CookieManager.getInstance().flush();
            android.webkit.CookieManager.getInstance().flush();
            return;
        }
        if (f45672a) {
            Log.i("RealCookieManager", "syncCookie: noLollipop sync");
        }
        CookieSyncManager.getInstance().sync();
    }

    @Override // d.a.m0.a.e2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        if (f45672a) {
            Log.i("RealCookieManager", "getCookie: httpUrl=" + str);
        }
        String str2 = "";
        try {
            str2 = CookieManager.getInstance().getCookie(str);
            if (f45672a) {
                Log.d("RealCookieManager", "RealCookieManager:" + str2);
            }
        } catch (Exception e2) {
            if (f45672a) {
                Log.e("RealCookieManager", "getCookie: err=" + e2 + " trace=" + Log.getStackTraceString(e2));
            }
        }
        if (f45672a) {
            Log.i("RealCookieManager", "getCookie: ret cookie=" + str2 + " for httpUrl=" + str);
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
        if (f45672a) {
            Log.d("RealCookieManager", "storeCookie: httpUrl= " + str);
            StringBuilder sb = new StringBuilder();
            sb.append("storeCookie: cookies=");
            sb.append(list == null ? -1 : list.size());
            Log.i("RealCookieManager", sb.toString());
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            for (String str2 : list) {
                if (f45672a) {
                    Log.i("RealCookieManager", "storeCookie: cookies item=" + str2);
                }
                CookieManager.getInstance().setCookie(str, str2);
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            a();
        } catch (Exception e2) {
            if (f45672a) {
                Log.e("RealCookieManager", "storeCookie: err=" + e2 + " trace=" + Log.getStackTraceString(e2));
            }
        }
    }
}
