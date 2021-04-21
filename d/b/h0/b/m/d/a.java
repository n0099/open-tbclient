package d.b.h0.b.m.d;

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
import d.b.h0.a.k;
import d.b.h0.a.z0.f;
import d.b.h0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48129b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f48130a = new Bundle();

    /* renamed from: d.b.h0.b.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0942a implements d.b.h0.b.m.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f48131a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.m.a f48132b;

        /* renamed from: d.b.h0.b.m.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0943a implements Runnable {
            public RunnableC0943a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.a.q1.b.d.a.c(C0942a.this.f48131a);
            }
        }

        public C0942a(ViewGroup viewGroup, d.b.h0.a.m.a aVar) {
            this.f48131a = viewGroup;
            this.f48132b = aVar;
        }

        @Override // d.b.h0.b.m.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            ViewGroup viewGroup = this.f48131a;
            if (viewGroup != null) {
                viewGroup.post(new RunnableC0943a());
            }
            if (a.this.i(quickLoginInfo)) {
                a.this.f48130a.putParcelable("quick_login_info", quickLoginInfo);
            }
            String S = d.b.h0.a.r1.d.e().s().J().S();
            String appId = d.b.h0.a.r1.d.e().getAppId();
            a.this.f48130a.putString(DpStatConstants.KEY_APP_NAME, d.b.h0.a.r1.d.e().s().M());
            a.this.f48130a.putString("appid", appId);
            a.this.f48130a.putString("launch_from", S);
            if (a.f48129b) {
                Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + a.this.f48130a.toString());
            }
            d.a("show", "login", null, S, appId);
            a.this.f(this.f48132b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.m.a f48135a;

        public b(a aVar, d.b.h0.a.m.a aVar2) {
            this.f48135a = aVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (delegateResult.isOk()) {
                this.f48135a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                return;
            }
            this.f48135a.onResult(-2);
        }
    }

    public final void e(d.b.h0.a.m.a aVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.f48130a);
        activity.startActivity(intent);
        activity.overridePendingTransition(d.b.h0.b.b.login_get_mobile_act_enter, 0);
        c.c(aVar);
    }

    public final void f(d.b.h0.a.m.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            e(aVar);
        } else {
            g(aVar);
        }
    }

    public final void g(d.b.h0.a.m.a aVar) {
        DelegateUtils.callOnMainWithActivity(f.V().getActivity(), PluginDelegateActivity.class, d.b.h0.b.m.d.b.class, this.f48130a, new b(this, aVar));
    }

    public void h(d.b.h0.a.m.a aVar) {
        ViewGroup viewGroup;
        SwanAppActivity n = d.b.h0.a.r1.d.e().n();
        if (n == null || n.isFinishing()) {
            viewGroup = null;
        } else {
            viewGroup = (ViewGroup) n.findViewById(16908290);
            d.b.h0.a.q1.b.d.a.f(n, viewGroup, n.getResources().getString(g.swanapp_login_loading));
        }
        d.b.h0.b.m.g.f.b(new C0942a(viewGroup, aVar));
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        return quickLoginInfo != null && quickLoginInfo.supportQuickLogin;
    }
}
