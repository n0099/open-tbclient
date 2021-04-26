package d.a.h0.f.f.c;

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
import d.a.h0.a.i2.v;
import d.a.h0.a.k;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45949c = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f45950d = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45951a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.p0.b f45952b;

        public a(b bVar, String str, d.a.h0.a.p0.b bVar2) {
            this.f45951a = str;
            this.f45952b = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (b.f45949c) {
                Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",result:" + delegateResult.mResult);
            }
            String string = delegateResult.mResult.getString("packageName");
            if (!TextUtils.isEmpty(this.f45951a) && !TextUtils.equals(this.f45951a, string)) {
                if (d.a.h0.f.f.e.a.g(AppRuntime.getAppContext(), this.f45951a)) {
                    this.f45952b.a(new JSONObject());
                } else {
                    this.f45952b.onFail(31003, "apk install cancel");
                }
            } else if (delegateResult.isOk()) {
                b.g(delegateResult.mResult, this.f45952b);
            } else {
                this.f45952b.onFail(31003, "apk install cancel");
            }
        }
    }

    /* renamed from: d.a.h0.f.f.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0913b extends d.a.h0.a.n1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f45953c;

        /* renamed from: d  reason: collision with root package name */
        public String f45954d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.h0.a.p0.b f45955e;

        public C0913b(String str, String str2, d.a.h0.a.p0.b bVar) {
            this.f45954d = str;
            this.f45953c = str2;
            this.f45955e = bVar;
        }

        @Override // d.a.h0.a.n1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.a.h0.a.n1.a.b.c.a
        public boolean c() {
            return true;
        }

        public final void e() {
            d.a.h0.a.p0.b bVar = this.f45955e;
            if (bVar != null) {
                bVar.onFail(31018, "download process is killed");
                b.e(this.f45954d, this.f45953c, 31018);
                this.f45955e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.n1.a.b.c.c, d.a.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.a.h0.a.n1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            d.a.h0.a.p0.b bVar2 = this.f45955e;
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
        public WeakReference<C0913b> f45956e;

        public c(C0913b c0913b) {
            this.f45956e = new WeakReference<>(c0913b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f45949c) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.f45956e.get() != null) {
                this.f45956e.get().e();
            }
        }
    }

    public b() {
        super("appDownloadManager");
    }

    public static void e(String str, String str2, int i2) {
        d.a.h0.f.f.h.c.a(str, str2, "fail", String.valueOf(i2), null);
    }

    public static void g(@NonNull Bundle bundle, @NonNull d.a.h0.a.p0.b bVar) {
        String string = bundle.getString("functionType");
        if (string == null) {
            bVar.onFail(1001, "");
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int i2 = bundle.getInt(l.f1974a, 1001);
        if (f45949c) {
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
            bVar.onFail(i2, string2);
        }
    }

    @Override // d.a.h0.f.i.a
    public d.a.h0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.a.h0.a.p0.b bVar) {
        if (f45949c) {
            Log.d("appManagerAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString2 = optJSONObject != null ? optJSONObject.optString("packageName") : null;
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, optString);
        bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
        bundle.putString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, new d.a.h0.f.f.h.a().a());
        if (TextUtils.equals(optString, "installApp")) {
            f(bundle, optString2, bVar);
            return null;
        }
        d.a.h0.a.n1.c.e.a x = d.a.h0.a.r1.d.e().x();
        if (x != null) {
            C0913b c0913b = new C0913b(optString2, optString, bVar);
            x.J(bundle, d.a.h0.f.f.d.d.class, c0913b);
            x.H(new c(c0913b));
        }
        return null;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, @NonNull d.a.h0.a.p0.b bVar) {
        SwanAppActivity v = d.a.h0.a.r1.d.e().v();
        if (v == null) {
            bVar.onFail(1001, "");
            return;
        }
        if (f45949c) {
            Log.d("appManagerAction", "InstallAppDelegation handleInstall");
        }
        DelegateUtils.callOnMainWithActivity(v, PluginDelegateActivity.class, d.a.h0.f.f.e.b.class, bundle, new a(this, str, bVar));
    }
}
