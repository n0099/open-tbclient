package d.a.l0.g.c.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50661c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f50662d = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50663a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.u0.b f50665c;

        public a(b bVar, String str, String str2, d.a.l0.a.u0.b bVar2) {
            this.f50663a = str;
            this.f50664b = str2;
            this.f50665c = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (b.f50661c) {
                Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",packageName：" + this.f50663a + ",result:" + delegateResult.mResult);
            }
            String string = delegateResult.mResult.getString("packageName");
            if (!TextUtils.isEmpty(this.f50663a) && !TextUtils.equals(this.f50663a, string)) {
                if (d.a.l0.g.c.e.a.h(AppRuntime.getAppContext(), this.f50663a)) {
                    if (!TextUtils.isEmpty(this.f50664b)) {
                        d.a.l0.g.c.i.c.a(this.f50663a, this.f50664b, "success", "", null);
                    }
                    this.f50665c.a(new JSONObject());
                    return;
                }
                if (!TextUtils.isEmpty(this.f50664b)) {
                    d.a.l0.g.c.i.c.a(this.f50663a, this.f50664b, com.baidu.pass.biometrics.face.liveness.b.b.g0, "", null);
                }
                this.f50665c.onFail(31003, "apk install cancel");
            } else if (!delegateResult.isOk()) {
                if (!TextUtils.isEmpty(this.f50664b)) {
                    d.a.l0.g.c.i.c.a(this.f50663a, this.f50664b, com.baidu.pass.biometrics.face.liveness.b.b.g0, "", null);
                }
                this.f50665c.onFail(31003, "apk install cancel");
            } else {
                d.a.l0.g.c.a.n().t(this.f50663a);
                b.g(delegateResult.mResult, this.f50665c);
            }
        }
    }

    /* renamed from: d.a.l0.g.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1053b extends d.a.l0.a.v1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f50666c;

        /* renamed from: d  reason: collision with root package name */
        public String f50667d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.l0.a.u0.b f50668e;

        public C1053b(String str, String str2, d.a.l0.a.u0.b bVar) {
            this.f50667d = str;
            this.f50666c = str2;
            this.f50668e = bVar;
        }

        @Override // d.a.l0.a.v1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.a.l0.a.v1.a.b.c.a
        public boolean c() {
            return true;
        }

        public final void e() {
            d.a.l0.a.u0.b bVar = this.f50668e;
            if (bVar != null) {
                bVar.onFail(31018, "download process is killed");
                b.e(this.f50667d, this.f50666c, 31018);
                this.f50668e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.a.b.c.c, d.a.l0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            d.a.l0.a.u0.b bVar2 = this.f50668e;
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
        public WeakReference<C1053b> f50669e;

        public c(C1053b c1053b) {
            this.f50669e = new WeakReference<>(c1053b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f50661c) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.f50669e.get() != null) {
                this.f50669e.get().e();
            }
        }
    }

    public b() {
        super("appDownloadManager");
    }

    public static void e(String str, String str2, int i2) {
        d.a.l0.g.c.i.c.a(str, str2, com.baidu.pass.biometrics.face.liveness.b.b.g0, String.valueOf(i2), null);
    }

    public static void g(@NonNull Bundle bundle, @NonNull d.a.l0.a.u0.b bVar) {
        String string = bundle.getString("functionType");
        if (string == null) {
            bVar.onFail(1001, "");
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int i2 = bundle.getInt(l.f1987a, 1001);
        if (f50661c) {
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
            bVar.a(w.d(string2));
        } else if (c2 != 1) {
        } else {
            bVar.onFail(i2, string2);
        }
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        String str;
        String str2;
        if (f50661c) {
            Log.d("appManagerAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            str = optJSONObject.optString("packageName");
            str2 = optJSONObject.optString("installSource");
        } else {
            str = null;
            str2 = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, optString);
        bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
        bundle.putString("ubc_params", new d.a.l0.g.c.i.a().a());
        if (TextUtils.equals(optString, "installApp")) {
            if (!TextUtils.isEmpty(str2)) {
                d.a.l0.g.c.i.c.a(str, str2, IntentConfig.START, "", null);
            }
            f(bundle, str, str2, bVar);
            return null;
        }
        d.a.l0.a.v1.c.e.a z = d.a.l0.a.a2.d.g().z();
        if (z != null) {
            C1053b c1053b = new C1053b(str, optString, bVar);
            z.L(bundle, d.a.l0.g.c.d.e.class, c1053b);
            z.J(new c(c1053b));
        }
        return null;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, String str2, @NonNull d.a.l0.a.u0.b bVar) {
        SwanAppActivity x = d.a.l0.a.a2.d.g().x();
        if (x == null) {
            bVar.onFail(1001, "");
        } else if (d.a.l0.g.c.e.a.h(AppRuntime.getAppContext(), str)) {
            bVar.a(new JSONObject());
        } else {
            if (f50661c) {
                Log.d("appManagerAction", "InstallAppDelegation handleInstall");
            }
            DelegateUtils.callOnMainWithActivity(x, InstallPluginDelegateActivity.class, d.a.l0.g.c.e.b.class, bundle, new a(this, str, str2, bVar));
        }
    }
}
