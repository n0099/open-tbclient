package d.a.h0.a.e0.q.e;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.h0.a.i2.g0;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42281a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42282b;

    /* renamed from: d.a.h0.a.e0.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0650a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", a.c());
            return bundle2;
        }
    }

    static {
        f42282b = ProcessUtils.isMainProcess() ? e("swan_prefetch_app_data") : b();
        if (f42281a) {
            Log.i("PrefetchABSwitcher", "prefetch switch - " + f42282b);
        }
    }

    public static int a() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_app_data", -1);
    }

    public static boolean b() {
        long currentTimeMillis = f42281a ? System.currentTimeMillis() : 0L;
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0650a.class, null);
        boolean z = false;
        if (callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false)) {
            z = true;
        }
        if (f42281a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("PrefetchABSwitcher", "get prefetch switch cross precess cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return z;
    }

    public static boolean c() {
        return f42282b;
    }

    public static boolean d() {
        return !g0.b("3.210.0");
    }

    public static boolean e(String str) {
        int a2;
        if (f42281a) {
            if (d.a.h0.a.m1.a.a.S() || (a2 = a()) == 1) {
                return true;
            }
            if (a2 == 0) {
                return false;
            }
        }
        d.a.h0.a.w0.a.N().getSwitch(str, 0);
        if (f42281a) {
            Log.d("PrefetchABSwitcher", str + " value from AB : 0");
        }
        return false;
    }
}
