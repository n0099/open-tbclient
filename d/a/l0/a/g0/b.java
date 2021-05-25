package d.a.l0.a.g0;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.l0.a.e2.c.h;
import d.a.l0.a.k;
import d.a.l0.a.v1.b.d;
import d.a.l0.a.v1.b.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f41886b = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public CookieManager f41887a;

    public b() {
        this.f41887a = null;
        this.f41887a = new c();
    }

    public final Bundle a(String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        return bundle;
    }

    @Override // d.a.l0.a.e2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        if (ProcessUtils.isMainProcess()) {
            return this.f41887a.getCookie(str);
        }
        f b2 = d.b(a.class, a(str, "", 4));
        if (b2.a()) {
            String string = b2.f45297a.getString("result");
            if (f41886b) {
                Log.d("DelegationCookieManager", "getCookie cookie : " + string);
            }
            return string;
        }
        return "";
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.f41887a.shouldAcceptCookie(str, str2);
        }
        f b2 = d.b(a.class, a(str, str2, 1));
        if (b2.a()) {
            return b2.f45297a.getBoolean("result");
        }
        return false;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.f41887a.shouldSendCookie(str, str2);
        }
        f b2 = d.b(a.class, a(str, str2, 2));
        if (b2.a()) {
            return b2.f45297a.getBoolean("result");
        }
        return false;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        if (ProcessUtils.isMainProcess()) {
            this.f41887a.storeCookie(str, list);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", 3);
        bundle.putString("param1", str);
        bundle.putStringArrayList("param2", (ArrayList) list);
        d.b(a.class, bundle);
        if (f41886b) {
            Log.d("DelegationCookieManager", "set cookies for " + str);
        }
    }
}
