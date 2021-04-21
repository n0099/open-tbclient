package d.b.j0.s.b.i.e;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.a.k;
import d.b.i0.l0.c;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f61815a = k.f45772a;

    /* renamed from: d.b.j0.s.b.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1590a implements d.b.j0.s.b.i.d.a {
        public C1590a() {
        }

        @Override // d.b.j0.s.b.i.d.a
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
            if (f61815a) {
                Log.d("BaiFuBaoPayDelegation", "onExec params is null.");
            }
            return false;
        }
        if (f61815a) {
            Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
        }
        Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
        if (!c.c().g()) {
            l.K(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
            return false;
        } else if (getAgent() instanceof Activity) {
            d.b.j0.s.b.i.a aVar = new d.b.j0.s.b.i.a();
            aVar.mParams.putInt("type", 1);
            aVar.mParams.putString("orderInfo", this.mParams.getString("order_info"));
            aVar.b(getAgent());
            aVar.c(new C1590a());
            aVar.onExec();
            return false;
        } else {
            return false;
        }
    }
}
