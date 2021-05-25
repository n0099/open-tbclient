package d.a.l0.b.n.d;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46370b = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f46371a = new Bundle();

    /* renamed from: d.a.l0.b.n.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0953a implements d.a.l0.b.n.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f46372a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.m.a f46373b;

        /* renamed from: d.a.l0.b.n.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0954a implements Runnable {
            public RunnableC0954a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.z1.b.d.a.c(C0953a.this.f46372a);
            }
        }

        public C0953a(ViewGroup viewGroup, d.a.l0.a.m.a aVar) {
            this.f46372a = viewGroup;
            this.f46373b = aVar;
        }

        @Override // d.a.l0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            ViewGroup viewGroup = this.f46372a;
            if (viewGroup != null) {
                viewGroup.post(new RunnableC0954a());
            }
            if (a.this.i(quickLoginInfo)) {
                a.this.f46371a.putParcelable("quick_login_info", quickLoginInfo);
            }
            String T = d.a.l0.a.a2.d.g().r().L().T();
            String appId = d.a.l0.a.a2.d.g().getAppId();
            a.this.f46371a.putString("app_name", d.a.l0.a.a2.d.g().r().O());
            a.this.f46371a.putString("appid", appId);
            a.this.f46371a.putString("launch_from", T);
            if (a.f46370b) {
                Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + a.this.f46371a.toString());
            }
            d.a("show", "login", null, T, appId);
            a.this.f(this.f46373b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.m.a f46376a;

        public b(a aVar, d.a.l0.a.m.a aVar2) {
            this.f46376a = aVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (delegateResult.isOk()) {
                this.f46376a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                return;
            }
            this.f46376a.onResult(-2);
        }
    }

    public final void e(d.a.l0.a.m.a aVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.f46371a);
        activity.startActivity(intent);
        activity.overridePendingTransition(d.a.l0.b.b.login_get_mobile_act_enter, 0);
        c.c(aVar);
    }

    public final void f(d.a.l0.a.m.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            e(aVar);
        } else {
            g(aVar);
        }
    }

    public final void g(d.a.l0.a.m.a aVar) {
        DelegateUtils.callOnMainWithActivity(f.V().getActivity(), PluginDelegateActivity.class, d.a.l0.b.n.d.b.class, this.f46371a, new b(this, aVar));
    }

    public void h(d.a.l0.a.m.a aVar) {
        ViewGroup viewGroup;
        SwanAppActivity x = d.a.l0.a.a2.d.g().x();
        if (x == null || x.isFinishing()) {
            viewGroup = null;
        } else {
            viewGroup = (ViewGroup) x.findViewById(16908290);
            d.a.l0.a.z1.b.d.a.f(x, viewGroup, x.getResources().getString(g.swanapp_login_loading));
        }
        d.a.l0.b.n.g.f.b(new C0953a(viewGroup, aVar));
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        return quickLoginInfo != null && quickLoginInfo.supportQuickLogin;
    }
}
