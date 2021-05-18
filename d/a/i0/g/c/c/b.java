package d.a.i0.g.c.c;

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
import d.a.i0.a.k;
import d.a.i0.a.v2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.i0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46811c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f46812d = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46813a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46814b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.u0.b f46815c;

        public a(b bVar, String str, String str2, d.a.i0.a.u0.b bVar2) {
            this.f46813a = str;
            this.f46814b = str2;
            this.f46815c = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (b.f46811c) {
                Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",packageName：" + this.f46813a + ",result:" + delegateResult.mResult);
            }
            String string = delegateResult.mResult.getString("packageName");
            if (!TextUtils.isEmpty(this.f46813a) && !TextUtils.equals(this.f46813a, string)) {
                if (d.a.i0.g.c.e.a.h(AppRuntime.getAppContext(), this.f46813a)) {
                    if (!TextUtils.isEmpty(this.f46814b)) {
                        d.a.i0.g.c.i.c.a(this.f46813a, this.f46814b, "success", "", null);
                    }
                    this.f46815c.b(new JSONObject());
                    return;
                }
                if (!TextUtils.isEmpty(this.f46814b)) {
                    d.a.i0.g.c.i.c.a(this.f46813a, this.f46814b, "fail", "", null);
                }
                this.f46815c.onFail(31003, "apk install cancel");
            } else if (!delegateResult.isOk()) {
                if (!TextUtils.isEmpty(this.f46814b)) {
                    d.a.i0.g.c.i.c.a(this.f46813a, this.f46814b, "fail", "", null);
                }
                this.f46815c.onFail(31003, "apk install cancel");
            } else {
                d.a.i0.g.c.a.n().t(this.f46813a);
                b.g(delegateResult.mResult, this.f46815c);
            }
        }
    }

    /* renamed from: d.a.i0.g.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0986b extends d.a.i0.a.v1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f46816c;

        /* renamed from: d  reason: collision with root package name */
        public String f46817d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.i0.a.u0.b f46818e;

        public C0986b(String str, String str2, d.a.i0.a.u0.b bVar) {
            this.f46817d = str;
            this.f46816c = str2;
            this.f46818e = bVar;
        }

        @Override // d.a.i0.a.v1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.a.i0.a.v1.a.b.c.a
        public boolean c() {
            return true;
        }

        public final void e() {
            d.a.i0.a.u0.b bVar = this.f46818e;
            if (bVar != null) {
                bVar.onFail(31018, "download process is killed");
                b.e(this.f46817d, this.f46816c, 31018);
                this.f46818e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v1.a.b.c.c, d.a.i0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.i0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            d.a.i0.a.u0.b bVar2 = this.f46818e;
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
        public WeakReference<C0986b> f46819e;

        public c(C0986b c0986b) {
            this.f46819e = new WeakReference<>(c0986b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f46811c) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.f46819e.get() != null) {
                this.f46819e.get().e();
            }
        }
    }

    public b() {
        super("appDownloadManager");
    }

    public static void e(String str, String str2, int i2) {
        d.a.i0.g.c.i.c.a(str, str2, "fail", String.valueOf(i2), null);
    }

    public static void g(@NonNull Bundle bundle, @NonNull d.a.i0.a.u0.b bVar) {
        String string = bundle.getString("functionType");
        if (string == null) {
            bVar.onFail(1001, "");
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int i2 = bundle.getInt(l.f1974a, 1001);
        if (f46811c) {
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
            bVar.b(w.d(string2));
        } else if (c2 != 1) {
        } else {
            bVar.onFail(i2, string2);
        }
    }

    @Override // d.a.i0.g.f.a
    public d.a.i0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.i0.a.u0.b bVar) {
        String str;
        String str2;
        if (f46811c) {
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
        bundle.putString("ubc_params", new d.a.i0.g.c.i.a().a());
        if (TextUtils.equals(optString, "installApp")) {
            if (!TextUtils.isEmpty(str2)) {
                d.a.i0.g.c.i.c.a(str, str2, IntentConfig.START, "", null);
            }
            f(bundle, str, str2, bVar);
            return null;
        }
        d.a.i0.a.v1.c.e.a z = d.a.i0.a.a2.d.g().z();
        if (z != null) {
            C0986b c0986b = new C0986b(str, optString, bVar);
            z.L(bundle, d.a.i0.g.c.d.e.class, c0986b);
            z.J(new c(c0986b));
        }
        return null;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, String str2, @NonNull d.a.i0.a.u0.b bVar) {
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
        if (x == null) {
            bVar.onFail(1001, "");
        } else if (d.a.i0.g.c.e.a.h(AppRuntime.getAppContext(), str)) {
            bVar.b(new JSONObject());
        } else {
            if (f46811c) {
                Log.d("appManagerAction", "InstallAppDelegation handleInstall");
            }
            DelegateUtils.callOnMainWithActivity(x, InstallPluginDelegateActivity.class, d.a.i0.g.c.e.b.class, bundle, new a(this, str, str2, bVar));
        }
    }
}
