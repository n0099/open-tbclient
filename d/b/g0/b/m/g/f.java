package d.b.g0.b.m.g;

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
import d.b.g0.a.i2.u;
import d.b.g0.a.k;
import d.b.g0.b.i.v;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.b.m.g.c f47435a;

        public a(d.b.g0.b.m.g.c cVar) {
            this.f47435a = cVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            if (oneKeyLoginResult == null) {
                this.f47435a.a(null);
                return;
            }
            boolean z = oneKeyLoginResult.enable;
            String str = oneKeyLoginResult.operator;
            String str2 = oneKeyLoginResult.encryptPhoneNum;
            boolean z2 = oneKeyLoginResult.hasHistory;
            d.b.g0.b.m.g.a aVar = new d.b.g0.b.m.g.a();
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
            this.f47435a.a(QuickLoginInfo.a(aVar));
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            super.unAvailable(oneKeyLoginResult);
            this.f47435a.a(null);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.b.m.g.c f47436c;

        public b(d.b.g0.b.m.g.c cVar) {
            this.f47436c = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            if (a2 == null) {
                this.f47436c.a(null);
                return;
            }
            a2.setClassLoader(QuickLoginInfo.class.getClassLoader());
            QuickLoginInfo quickLoginInfo = (QuickLoginInfo) a2.getParcelable("quick_login_info_result");
            if (quickLoginInfo == null) {
                this.f47436c.a(null);
            } else {
                this.f47436c.a(quickLoginInfo);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f47437a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f47438b;

        public c(Activity activity, e eVar) {
            this.f47437a = activity;
            this.f47438b = eVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            v.a().k(this.f47437a, oneKeyLoginResult.sign, this.f47438b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            this.f47438b.onResult(-1);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f47439a;

        public d(e eVar) {
            this.f47439a = eVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Bundle bundle = delegateResult.mResult;
            if (this.f47439a != null) {
                this.f47439a.onResult(u.f(bundle, "quick_login", -1));
            }
        }
    }

    static {
        boolean z = k.f45050a;
    }

    public static void a(d.b.g0.b.m.g.c cVar) {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(cVar));
    }

    public static void b(d.b.g0.b.m.g.c cVar) {
        if (ProcessUtils.isMainProcess()) {
            a(cVar);
        } else {
            c(cVar);
        }
    }

    public static void c(d.b.g0.b.m.g.c cVar) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            cVar.a(null);
            return;
        }
        d.b.g0.a.n1.c.e.a q = O.q();
        if (q == null) {
            cVar.a(null);
        } else {
            q.J(null, d.b.g0.b.m.g.b.class, new b(cVar));
        }
    }

    public static void d(Activity activity, int i, e eVar) {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new c(activity, eVar));
    }

    public static void e(Activity activity, int i, e eVar) {
        if (ProcessUtils.isMainProcess()) {
            d(activity, i, eVar);
        } else {
            f(activity, i, eVar);
        }
    }

    public static void f(Activity activity, int i, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("quick_login_mode", i);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, d.b.g0.b.m.g.d.class, bundle, new d(eVar));
    }
}
