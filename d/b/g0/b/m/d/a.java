package d.b.g0.b.m.d;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import d.b.g0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47407b = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f47408a = new Bundle();

    /* renamed from: d.b.g0.b.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0909a implements d.b.g0.b.m.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f47409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.m.a f47410b;

        /* renamed from: d.b.g0.b.m.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0910a implements Runnable {
            public RunnableC0910a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.q1.b.d.a.c(C0909a.this.f47409a);
            }
        }

        public C0909a(ViewGroup viewGroup, d.b.g0.a.m.a aVar) {
            this.f47409a = viewGroup;
            this.f47410b = aVar;
        }

        @Override // d.b.g0.b.m.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            ViewGroup viewGroup = this.f47409a;
            if (viewGroup != null) {
                viewGroup.post(new RunnableC0910a());
            }
            if (a.this.i(quickLoginInfo)) {
                a.this.f47408a.putParcelable("quick_login_info", quickLoginInfo);
            }
            String S = d.b.g0.a.r1.d.e().s().J().S();
            String appId = d.b.g0.a.r1.d.e().getAppId();
            a.this.f47408a.putString(DpStatConstants.KEY_APP_NAME, d.b.g0.a.r1.d.e().s().M());
            a.this.f47408a.putString("appid", appId);
            a.this.f47408a.putString("launch_from", S);
            if (a.f47407b) {
                Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + a.this.f47408a.toString());
            }
            d.a("show", "login", null, S, appId);
            a.this.f(this.f47410b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.m.a f47413a;

        public b(a aVar, d.b.g0.a.m.a aVar2) {
            this.f47413a = aVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (delegateResult.isOk()) {
                this.f47413a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                return;
            }
            this.f47413a.onResult(-2);
        }
    }

    public final void e(d.b.g0.a.m.a aVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.f47408a);
        activity.startActivity(intent);
        activity.overridePendingTransition(d.b.g0.b.b.login_get_mobile_act_enter, 0);
        c.c(aVar);
    }

    public final void f(d.b.g0.a.m.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            e(aVar);
        } else {
            g(aVar);
        }
    }

    public final void g(d.b.g0.a.m.a aVar) {
        DelegateUtils.callOnMainWithActivity(f.V().getActivity(), PluginDelegateActivity.class, d.b.g0.b.m.d.b.class, this.f47408a, new b(this, aVar));
    }

    public void h(d.b.g0.a.m.a aVar) {
        ViewGroup viewGroup;
        SwanAppActivity n = d.b.g0.a.r1.d.e().n();
        if (n == null || n.isFinishing()) {
            viewGroup = null;
        } else {
            viewGroup = (ViewGroup) n.findViewById(16908290);
            d.b.g0.a.q1.b.d.a.f(n, viewGroup, n.getResources().getString(g.swanapp_login_loading));
        }
        d.b.g0.b.m.g.f.b(new C0909a(viewGroup, aVar));
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        return quickLoginInfo != null && quickLoginInfo.supportQuickLogin;
    }
}
