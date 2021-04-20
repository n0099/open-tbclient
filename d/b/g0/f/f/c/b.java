package d.b.g0.f.f.c;

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
import d.b.g0.a.i2.v;
import d.b.g0.a.k;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48160c = k.f45443a;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f48161d = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.p0.b f48163b;

        public a(b bVar, String str, d.b.g0.a.p0.b bVar2) {
            this.f48162a = str;
            this.f48163b = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (b.f48160c) {
                Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",result:" + delegateResult.mResult);
            }
            String string = delegateResult.mResult.getString("packageName");
            if (!TextUtils.isEmpty(this.f48162a) && !TextUtils.equals(this.f48162a, string)) {
                if (d.b.g0.f.f.e.a.g(AppRuntime.getAppContext(), this.f48162a)) {
                    this.f48163b.a(new JSONObject());
                } else {
                    this.f48163b.onFail(31003, "apk install cancel");
                }
            } else if (delegateResult.isOk()) {
                b.g(delegateResult.mResult, this.f48163b);
            } else {
                this.f48163b.onFail(31003, "apk install cancel");
            }
        }
    }

    /* renamed from: d.b.g0.f.f.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0954b extends d.b.g0.a.n1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f48164c;

        /* renamed from: d  reason: collision with root package name */
        public String f48165d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.a.p0.b f48166e;

        public C0954b(String str, String str2, d.b.g0.a.p0.b bVar) {
            this.f48165d = str;
            this.f48164c = str2;
            this.f48166e = bVar;
        }

        @Override // d.b.g0.a.n1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.b.g0.a.n1.a.b.c.a
        public boolean c() {
            return true;
        }

        public final void e() {
            d.b.g0.a.p0.b bVar = this.f48166e;
            if (bVar != null) {
                bVar.onFail(31018, "download process is killed");
                b.e(this.f48165d, this.f48164c, 31018);
                this.f48166e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            d.b.g0.a.p0.b bVar2 = this.f48166e;
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
        public WeakReference<C0954b> f48167e;

        public c(C0954b c0954b) {
            this.f48167e = new WeakReference<>(c0954b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f48160c) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.f48167e.get() != null) {
                this.f48167e.get().e();
            }
        }
    }

    public b() {
        super("appDownloadManager");
    }

    public static void e(String str, String str2, int i) {
        d.b.g0.f.f.h.c.a(str, str2, "fail", String.valueOf(i), null);
    }

    public static void g(@NonNull Bundle bundle, @NonNull d.b.g0.a.p0.b bVar) {
        String string = bundle.getString("functionType");
        if (string == null) {
            bVar.onFail(1001, "");
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int i = bundle.getInt(l.f2017a, 1001);
        if (f48160c) {
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

    @Override // d.b.g0.f.i.a
    public d.b.g0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        if (f48160c) {
            Log.d("appManagerAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString2 = optJSONObject != null ? optJSONObject.optString("packageName") : null;
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, optString);
        bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
        bundle.putString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, new d.b.g0.f.f.h.a().a());
        if (TextUtils.equals(optString, "installApp")) {
            f(bundle, optString2, bVar);
            return null;
        }
        d.b.g0.a.n1.c.e.a q = d.b.g0.a.r1.d.e().q();
        if (q != null) {
            C0954b c0954b = new C0954b(optString2, optString, bVar);
            q.J(bundle, d.b.g0.f.f.d.d.class, c0954b);
            q.H(new c(c0954b));
        }
        return null;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, @NonNull d.b.g0.a.p0.b bVar) {
        SwanAppActivity n = d.b.g0.a.r1.d.e().n();
        if (n == null) {
            bVar.onFail(1001, "");
            return;
        }
        if (f48160c) {
            Log.d("appManagerAction", "InstallAppDelegation handleInstall");
        }
        DelegateUtils.callOnMainWithActivity(n, PluginDelegateActivity.class, d.b.g0.f.f.e.b.class, bundle, new a(this, str, bVar));
    }
}
