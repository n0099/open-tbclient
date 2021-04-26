package d.a.h0.b.m.d;

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
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import d.a.h0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45575b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f45576a = new Bundle();

    /* renamed from: d.a.h0.b.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0881a implements d.a.h0.b.m.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f45577a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.m.a f45578b;

        /* renamed from: d.a.h0.b.m.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0882a implements Runnable {
            public RunnableC0882a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.a.q1.b.d.a.c(C0881a.this.f45577a);
            }
        }

        public C0881a(ViewGroup viewGroup, d.a.h0.a.m.a aVar) {
            this.f45577a = viewGroup;
            this.f45578b = aVar;
        }

        @Override // d.a.h0.b.m.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            ViewGroup viewGroup = this.f45577a;
            if (viewGroup != null) {
                viewGroup.post(new RunnableC0882a());
            }
            if (a.this.i(quickLoginInfo)) {
                a.this.f45576a.putParcelable("quick_login_info", quickLoginInfo);
            }
            String S = d.a.h0.a.r1.d.e().p().J().S();
            String appId = d.a.h0.a.r1.d.e().getAppId();
            a.this.f45576a.putString(DpStatConstants.KEY_APP_NAME, d.a.h0.a.r1.d.e().p().M());
            a.this.f45576a.putString("appid", appId);
            a.this.f45576a.putString("launch_from", S);
            if (a.f45575b) {
                Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + a.this.f45576a.toString());
            }
            d.a("show", "login", null, S, appId);
            a.this.f(this.f45578b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.m.a f45581a;

        public b(a aVar, d.a.h0.a.m.a aVar2) {
            this.f45581a = aVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (delegateResult.isOk()) {
                this.f45581a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                return;
            }
            this.f45581a.onResult(-2);
        }
    }

    public final void e(d.a.h0.a.m.a aVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.f45576a);
        activity.startActivity(intent);
        activity.overridePendingTransition(d.a.h0.b.b.login_get_mobile_act_enter, 0);
        c.c(aVar);
    }

    public final void f(d.a.h0.a.m.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            e(aVar);
        } else {
            g(aVar);
        }
    }

    public final void g(d.a.h0.a.m.a aVar) {
        DelegateUtils.callOnMainWithActivity(f.V().getActivity(), PluginDelegateActivity.class, d.a.h0.b.m.d.b.class, this.f45576a, new b(this, aVar));
    }

    public void h(d.a.h0.a.m.a aVar) {
        ViewGroup viewGroup;
        SwanAppActivity v = d.a.h0.a.r1.d.e().v();
        if (v == null || v.isFinishing()) {
            viewGroup = null;
        } else {
            viewGroup = (ViewGroup) v.findViewById(16908290);
            d.a.h0.a.q1.b.d.a.f(v, viewGroup, v.getResources().getString(g.swanapp_login_loading));
        }
        d.a.h0.b.m.g.f.b(new C0881a(viewGroup, aVar));
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        return quickLoginInfo != null && quickLoginInfo.supportQuickLogin;
    }
}
