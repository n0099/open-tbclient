package d.a.l0.b.n.g;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import d.a.l0.a.k;
import d.a.l0.b.j.v;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.b.n.g.c f50072a;

        public a(d.a.l0.b.n.g.c cVar) {
            this.f50072a = cVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            if (oneKeyLoginResult == null) {
                this.f50072a.a(null);
                return;
            }
            boolean z = oneKeyLoginResult.enable;
            String str = oneKeyLoginResult.operator;
            String str2 = oneKeyLoginResult.encryptPhoneNum;
            boolean z2 = oneKeyLoginResult.hasHistory;
            d.a.l0.b.n.g.a aVar = new d.a.l0.b.n.g.a();
            aVar.j(z);
            aVar.k(str);
            aVar.g(str2);
            aVar.h(z2);
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 2154) {
                if (hashCode != 2161) {
                    if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                        c2 = 1;
                    }
                } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                    c2 = 2;
                }
            } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 0;
            }
            if (c2 == 0) {
                aVar.i(12);
            } else if (c2 == 1) {
                aVar.i(13);
            } else if (c2 == 2) {
                aVar.i(14);
            }
            this.f50072a.a(QuickLoginInfo.a(aVar));
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            super.unAvailable(oneKeyLoginResult);
            this.f50072a.a(null);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a.l0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.b.n.g.c f50073c;

        public b(d.a.l0.b.n.g.c cVar) {
            this.f50073c = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.a.b.c.b, d.a.l0.a.v1.a.b.c.c, d.a.l0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            if (a2 == null) {
                this.f50073c.a(null);
                return;
            }
            a2.setClassLoader(QuickLoginInfo.class.getClassLoader());
            QuickLoginInfo quickLoginInfo = (QuickLoginInfo) a2.getParcelable("quick_login_info_result");
            if (quickLoginInfo == null) {
                this.f50073c.a(null);
            } else {
                this.f50073c.a(quickLoginInfo);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f50074a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f50075b;

        public c(Activity activity, e eVar) {
            this.f50074a = activity;
            this.f50075b = eVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            v.a().n(this.f50074a, oneKeyLoginResult.sign, this.f50075b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            this.f50075b.onResult(-1);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f50076a;

        public d(e eVar) {
            this.f50076a = eVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Bundle bundle = delegateResult.mResult;
            if (this.f50076a != null) {
                this.f50076a.onResult(d.a.l0.a.v2.v.f(bundle, "quick_login", -1));
            }
        }
    }

    static {
        boolean z = k.f46875a;
    }

    public static void a(d.a.l0.b.n.g.c cVar) {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(cVar));
    }

    public static void b(d.a.l0.b.n.g.c cVar) {
        if (ProcessUtils.isMainProcess()) {
            a(cVar);
        } else {
            c(cVar);
        }
    }

    public static void c(d.a.l0.b.n.g.c cVar) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            cVar.a(null);
            return;
        }
        d.a.l0.a.v1.c.e.a z = Q.z();
        if (z == null) {
            cVar.a(null);
        } else {
            z.L(null, d.a.l0.b.n.g.b.class, new b(cVar));
        }
    }

    public static void d(Activity activity, int i2, e eVar) {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new c(activity, eVar));
    }

    public static void e(Activity activity, int i2, e eVar) {
        if (ProcessUtils.isMainProcess()) {
            d(activity, i2, eVar);
        } else {
            f(activity, i2, eVar);
        }
    }

    public static void f(Activity activity, int i2, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("quick_login_mode", i2);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, d.a.l0.b.n.g.d.class, bundle, new d(eVar));
    }
}
