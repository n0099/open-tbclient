package d.b.h0.b.m.g;

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
import d.b.h0.a.i2.u;
import d.b.h0.a.k;
import d.b.h0.b.i.v;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.b.m.g.c f48157a;

        public a(d.b.h0.b.m.g.c cVar) {
            this.f48157a = cVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            if (oneKeyLoginResult == null) {
                this.f48157a.a(null);
                return;
            }
            boolean z = oneKeyLoginResult.enable;
            String str = oneKeyLoginResult.operator;
            String str2 = oneKeyLoginResult.encryptPhoneNum;
            boolean z2 = oneKeyLoginResult.hasHistory;
            d.b.h0.b.m.g.a aVar = new d.b.h0.b.m.g.a();
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
            this.f48157a.a(QuickLoginInfo.a(aVar));
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            super.unAvailable(oneKeyLoginResult);
            this.f48157a.a(null);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.b.h0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.b.m.g.c f48158c;

        public b(d.b.h0.b.m.g.c cVar) {
            this.f48158c = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.n1.a.b.c.b, d.b.h0.a.n1.a.b.c.c, d.b.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.h0.a.n1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            if (a2 == null) {
                this.f48158c.a(null);
                return;
            }
            a2.setClassLoader(QuickLoginInfo.class.getClassLoader());
            QuickLoginInfo quickLoginInfo = (QuickLoginInfo) a2.getParcelable("quick_login_info_result");
            if (quickLoginInfo == null) {
                this.f48158c.a(null);
            } else {
                this.f48158c.a(quickLoginInfo);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f48159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48160b;

        public c(Activity activity, e eVar) {
            this.f48159a = activity;
            this.f48160b = eVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            v.a().k(this.f48159a, oneKeyLoginResult.sign, this.f48160b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            this.f48160b.onResult(-1);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f48161a;

        public d(e eVar) {
            this.f48161a = eVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Bundle bundle = delegateResult.mResult;
            if (this.f48161a != null) {
                this.f48161a.onResult(u.f(bundle, "quick_login", -1));
            }
        }
    }

    static {
        boolean z = k.f45772a;
    }

    public static void a(d.b.h0.b.m.g.c cVar) {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(cVar));
    }

    public static void b(d.b.h0.b.m.g.c cVar) {
        if (ProcessUtils.isMainProcess()) {
            a(cVar);
        } else {
            c(cVar);
        }
    }

    public static void c(d.b.h0.b.m.g.c cVar) {
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            cVar.a(null);
            return;
        }
        d.b.h0.a.n1.c.e.a q = O.q();
        if (q == null) {
            cVar.a(null);
        } else {
            q.J(null, d.b.h0.b.m.g.b.class, new b(cVar));
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
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, d.b.h0.b.m.g.d.class, bundle, new d(eVar));
    }
}
