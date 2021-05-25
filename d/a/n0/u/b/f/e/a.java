package d.a.n0.u.b.f.e;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.l0.a.k;
import d.a.m0.l0.d;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f61274a = k.f43199a;

    /* renamed from: d.a.n0.u.b.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1631a implements d.a.n0.u.b.f.d.a {
        public C1631a() {
        }

        @Override // d.a.n0.u.b.f.d.a
        public void a(Bundle bundle) {
            a.this.mResult.putInt("status_code", bundle.getInt("result_code"));
            a.this.mResult.putString("params", bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
            a.this.finish();
        }
    }

    public static Bundle b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("order_info", str);
        return bundle;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (this.mParams.isEmpty()) {
            if (f61274a) {
                Log.d("BaiFuBaoPayDelegation", "onExec params is null.");
            }
            return false;
        }
        if (f61274a) {
            Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
        }
        Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
        if (!d.c().g()) {
            l.L(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
            return false;
        } else if (getAgent() instanceof Activity) {
            d.a.n0.u.b.f.a aVar = new d.a.n0.u.b.f.a();
            aVar.mParams.putInt("type", 1);
            aVar.mParams.putString("orderInfo", this.mParams.getString("order_info"));
            aVar.b(getAgent());
            aVar.c(new C1631a());
            aVar.onExec();
            return false;
        } else {
            return false;
        }
    }
}
