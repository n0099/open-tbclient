package d.a.m0.g.c.c;

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
import d.a.m0.a.k;
import d.a.m0.a.v2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.m0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50769c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f50770d = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50771a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50772b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.u0.b f50773c;

        public a(b bVar, String str, String str2, d.a.m0.a.u0.b bVar2) {
            this.f50771a = str;
            this.f50772b = str2;
            this.f50773c = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (b.f50769c) {
                Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",packageName：" + this.f50771a + ",result:" + delegateResult.mResult);
            }
            String string = delegateResult.mResult.getString("packageName");
            if (!TextUtils.isEmpty(this.f50771a) && !TextUtils.equals(this.f50771a, string)) {
                if (d.a.m0.g.c.e.a.h(AppRuntime.getAppContext(), this.f50771a)) {
                    if (!TextUtils.isEmpty(this.f50772b)) {
                        d.a.m0.g.c.i.c.a(this.f50771a, this.f50772b, "success", "", null);
                    }
                    this.f50773c.a(new JSONObject());
                    return;
                }
                if (!TextUtils.isEmpty(this.f50772b)) {
                    d.a.m0.g.c.i.c.a(this.f50771a, this.f50772b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                }
                this.f50773c.onFail(31003, "apk install cancel");
            } else if (!delegateResult.isOk()) {
                if (!TextUtils.isEmpty(this.f50772b)) {
                    d.a.m0.g.c.i.c.a(this.f50771a, this.f50772b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                }
                this.f50773c.onFail(31003, "apk install cancel");
            } else {
                d.a.m0.g.c.a.n().t(this.f50771a);
                b.g(delegateResult.mResult, this.f50773c);
            }
        }
    }

    /* renamed from: d.a.m0.g.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1056b extends d.a.m0.a.v1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f50774c;

        /* renamed from: d  reason: collision with root package name */
        public String f50775d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.m0.a.u0.b f50776e;

        public C1056b(String str, String str2, d.a.m0.a.u0.b bVar) {
            this.f50775d = str;
            this.f50774c = str2;
            this.f50776e = bVar;
        }

        @Override // d.a.m0.a.v1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.a.m0.a.v1.a.b.c.a
        public boolean c() {
            return true;
        }

        public final void e() {
            d.a.m0.a.u0.b bVar = this.f50776e;
            if (bVar != null) {
                bVar.onFail(31018, "download process is killed");
                b.e(this.f50775d, this.f50774c, 31018);
                this.f50776e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v1.a.b.c.c, d.a.m0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.m0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            d.a.m0.a.u0.b bVar2 = this.f50776e;
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
        public WeakReference<C1056b> f50777e;

        public c(C1056b c1056b) {
            this.f50777e = new WeakReference<>(c1056b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f50769c) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.f50777e.get() != null) {
                this.f50777e.get().e();
            }
        }
    }

    public b() {
        super("appDownloadManager");
    }

    public static void e(String str, String str2, int i2) {
        d.a.m0.g.c.i.c.a(str, str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(i2), null);
    }

    public static void g(@NonNull Bundle bundle, @NonNull d.a.m0.a.u0.b bVar) {
        String string = bundle.getString("functionType");
        if (string == null) {
            bVar.onFail(1001, "");
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int i2 = bundle.getInt(l.f1987a, 1001);
        if (f50769c) {
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

    @Override // d.a.m0.g.f.a
    public d.a.m0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.m0.a.u0.b bVar) {
        String str;
        String str2;
        if (f50769c) {
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
        bundle.putString("ubc_params", new d.a.m0.g.c.i.a().a());
        if (TextUtils.equals(optString, "installApp")) {
            if (!TextUtils.isEmpty(str2)) {
                d.a.m0.g.c.i.c.a(str, str2, IntentConfig.START, "", null);
            }
            f(bundle, str, str2, bVar);
            return null;
        }
        d.a.m0.a.v1.c.e.a z = d.a.m0.a.a2.d.g().z();
        if (z != null) {
            C1056b c1056b = new C1056b(str, optString, bVar);
            z.L(bundle, d.a.m0.g.c.d.e.class, c1056b);
            z.J(new c(c1056b));
        }
        return null;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, String str2, @NonNull d.a.m0.a.u0.b bVar) {
        SwanAppActivity x = d.a.m0.a.a2.d.g().x();
        if (x == null) {
            bVar.onFail(1001, "");
        } else if (d.a.m0.g.c.e.a.h(AppRuntime.getAppContext(), str)) {
            bVar.a(new JSONObject());
        } else {
            if (f50769c) {
                Log.d("appManagerAction", "InstallAppDelegation handleInstall");
            }
            DelegateUtils.callOnMainWithActivity(x, InstallPluginDelegateActivity.class, d.a.m0.g.c.e.b.class, bundle, new a(this, str, str2, bVar));
        }
    }
}
