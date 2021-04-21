package d.b.h0.f.f.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import d.b.h0.a.i2.v;
import d.b.h0.a.k;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48489c = k.f45772a;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f48490d = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48491a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.p0.b f48492b;

        public a(b bVar, String str, d.b.h0.a.p0.b bVar2) {
            this.f48491a = str;
            this.f48492b = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (b.f48489c) {
                Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",result:" + delegateResult.mResult);
            }
            String string = delegateResult.mResult.getString("packageName");
            if (!TextUtils.isEmpty(this.f48491a) && !TextUtils.equals(this.f48491a, string)) {
                if (d.b.h0.f.f.e.a.g(AppRuntime.getAppContext(), this.f48491a)) {
                    this.f48492b.a(new JSONObject());
                } else {
                    this.f48492b.onFail(31003, "apk install cancel");
                }
            } else if (delegateResult.isOk()) {
                b.g(delegateResult.mResult, this.f48492b);
            } else {
                this.f48492b.onFail(31003, "apk install cancel");
            }
        }
    }

    /* renamed from: d.b.h0.f.f.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0974b extends d.b.h0.a.n1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f48493c;

        /* renamed from: d  reason: collision with root package name */
        public String f48494d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.h0.a.p0.b f48495e;

        public C0974b(String str, String str2, d.b.h0.a.p0.b bVar) {
            this.f48494d = str;
            this.f48493c = str2;
            this.f48495e = bVar;
        }

        @Override // d.b.h0.a.n1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.b.h0.a.n1.a.b.c.a
        public boolean c() {
            return true;
        }

        public final void e() {
            d.b.h0.a.p0.b bVar = this.f48495e;
            if (bVar != null) {
                bVar.onFail(31018, "download process is killed");
                b.e(this.f48494d, this.f48493c, 31018);
                this.f48495e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.n1.a.b.c.c, d.b.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.h0.a.n1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            d.b.h0.a.p0.b bVar2 = this.f48495e;
            if (bVar2 == null) {
                return;
            }
            if (a2 != null) {
                b.g(a2, bVar2);
            } else {
                bVar2.onFail(1001, "");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<C0974b> f48496e;

        public c(C0974b c0974b) {
            this.f48496e = new WeakReference<>(c0974b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f48489c) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.f48496e.get() != null) {
                this.f48496e.get().e();
            }
        }
    }

    public b() {
        super("appDownloadManager");
    }

    public static void e(String str, String str2, int i) {
        d.b.h0.f.f.h.c.a(str, str2, "fail", String.valueOf(i), null);
    }

    public static void g(@NonNull Bundle bundle, @NonNull d.b.h0.a.p0.b bVar) {
        String string = bundle.getString("functionType");
        if (string == null) {
            bVar.onFail(1001, "");
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int i = bundle.getInt(l.f2017a, 1001);
        if (f48489c) {
            Log.d("appManagerAction", "handleResult:function = " + string + ",result = " + string2);
        }
        char c2 = 65535;
        int hashCode = string.hashCode();
        if (hashCode != -1013362275) {
            if (hashCode == -530890460 && string.equals("onSuccess")) {
                c2 = 0;
            }
        } else if (string.equals("onFail")) {
            c2 = 1;
        }
        if (c2 == 0) {
            bVar.a(v.b(string2));
        } else if (c2 != 1) {
        } else {
            bVar.onFail(i, string2);
        }
    }

    @Override // d.b.h0.f.i.a
    public d.b.h0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.b.h0.a.p0.b bVar) {
        if (f48489c) {
            Log.d("appManagerAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString2 = optJSONObject != null ? optJSONObject.optString("packageName") : null;
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, optString);
        bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
        bundle.putString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, new d.b.h0.f.f.h.a().a());
        if (TextUtils.equals(optString, "installApp")) {
            f(bundle, optString2, bVar);
            return null;
        }
        d.b.h0.a.n1.c.e.a q = d.b.h0.a.r1.d.e().q();
        if (q != null) {
            C0974b c0974b = new C0974b(optString2, optString, bVar);
            q.J(bundle, d.b.h0.f.f.d.d.class, c0974b);
            q.H(new c(c0974b));
        }
        return null;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, @NonNull d.b.h0.a.p0.b bVar) {
        SwanAppActivity n = d.b.h0.a.r1.d.e().n();
        if (n == null) {
            bVar.onFail(1001, "");
            return;
        }
        if (f48489c) {
            Log.d("appManagerAction", "InstallAppDelegation handleInstall");
        }
        DelegateUtils.callOnMainWithActivity(n, PluginDelegateActivity.class, d.b.h0.f.f.e.b.class, bundle, new a(this, str, bVar));
    }
}
