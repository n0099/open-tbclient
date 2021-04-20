package d.b.g0.b.l;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.b.g0.a.k;
import d.b.g0.a.v1.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47720b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public CookieManager f47721a;

    public a() {
        this.f47721a = null;
        this.f47721a = new b();
    }

    public final Bundle a(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        return bundle;
    }

    @Override // d.b.g0.a.v1.c.g, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        if (ProcessUtils.isMainProcess()) {
            return this.f47721a.getCookie(str);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a(str, "", 4));
        if (callOnMainWithContentProvider.isOk()) {
            String string = callOnMainWithContentProvider.mResult.getString("result");
            if (f47720b) {
                Log.d("DelegationCookieManager", "getCookie cookie : " + string);
            }
            return string;
        }
        return "";
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.f47721a.shouldAcceptCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a(str, str2, 1));
        if (callOnMainWithContentProvider.isOk()) {
            return callOnMainWithContentProvider.mResult.getBoolean("result");
        }
        return false;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.f47721a.shouldSendCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a(str, str2, 2));
        if (callOnMainWithContentProvider.isOk()) {
            return callOnMainWithContentProvider.mResult.getBoolean("result");
        }
        return false;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        if (ProcessUtils.isMainProcess()) {
            this.f47721a.storeCookie(str, list);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", 3);
        bundle.putString("param1", str);
        bundle.putStringArrayList("param2", (ArrayList) list);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
        if (f47720b) {
            Log.d("DelegationCookieManager", "set cookies for " + str);
        }
    }
}
