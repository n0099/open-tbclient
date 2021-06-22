package d.a.o0.u.b.f;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import d.a.c.e.p.l;
import d.a.m0.a.c1.d.f;
import d.a.m0.a.z1.b.f.e;
import d.a.n0.l0.d;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes4.dex */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public static BroadcastReceiver f65104a;

    /* loaded from: classes4.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.b0.e.a f65105a;

        public a(b bVar, d.a.b0.e.a aVar) {
            this.f65105a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            this.f65105a.onPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
        }
    }

    /* renamed from: d.a.o0.u.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1691b implements d.a.o0.u.b.f.d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.b0.e.a f65106a;

        public C1691b(b bVar, d.a.b0.e.a aVar) {
            this.f65106a = aVar;
        }

        @Override // d.a.o0.u.b.f.d.a
        public void a(Bundle bundle) {
            d.a.b0.e.a aVar = this.f65106a;
            if (aVar == null) {
                return;
            }
            aVar.onPayResult(bundle.getInt("result_code"), bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BroadcastReceiver {
        public final /* synthetic */ d.a.b0.e.a val$callback;

        public c(d.a.b0.e.a aVar) {
            this.val$callback = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            intent.getExtras();
            this.val$callback.onPayResult(intent.getExtras().getInt("errorCode", -1), intent.getExtras().getString("errorMsg"));
        }
    }

    @Override // d.a.m0.a.c1.d.f
    public boolean a(Context context) {
        if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
            return true;
        }
        e.g(context, "您没有安装微信，请选择其他支付方式").F();
        return false;
    }

    @Override // d.a.m0.a.c1.d.f
    public void b(Activity activity, String str, d.a.b0.e.a aVar) {
        if (!d.c().g()) {
            l.L(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
            return;
        }
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null || i2.k() == null) {
            return;
        }
        d.a.o0.u.b.f.a aVar2 = new d.a.o0.u.b.f.a();
        aVar2.mParams.putInt("type", 2);
        aVar2.mParams.putString("orderInfo", str);
        aVar2.b(i2.k());
        aVar2.c(new C1691b(this, aVar));
        aVar2.onExec();
    }

    @Override // d.a.m0.a.c1.d.f
    public void c(Context context, JSONObject jSONObject, d.a.b0.e.a aVar) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
        PayReq e2 = e(jSONObject);
        createWXAPI.registerApp(e2.appId);
        if (!createWXAPI.isWXAppInstalled()) {
            aVar.onPayResult(3, "wx_not_installed");
            e.g(context, "您没有安装微信，请选择其他支付方式").F();
        } else if (d.a.m0.a.a2.e.i() == null) {
        } else {
            if (!createWXAPI.sendReq(e2)) {
                aVar.onPayResult(6, "wx_start_failed");
            }
            if (f65104a != null) {
                TbadkCoreApplication.getInst().unregisterReceiver(f65104a);
            }
            f65104a = new c(aVar);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("WXPayResult");
            TbadkCoreApplication.getInst().registerReceiver(f65104a, intentFilter);
        }
    }

    @Override // d.a.m0.a.c1.d.f
    public void d(Activity activity, String str, d.a.b0.e.a aVar) {
        DelegateUtils.callOnMainWithActivity(d.a.m0.a.g1.f.V().getActivity(), MainProcessDelegateActivity.class, d.a.o0.u.b.f.e.a.class, d.a.o0.u.b.f.e.a.b(str), new a(this, aVar));
    }

    public final PayReq e(JSONObject jSONObject) {
        PayReq payReq = new PayReq();
        payReq.appId = jSONObject.optString("appid");
        payReq.partnerId = jSONObject.optString("partnerid");
        payReq.prepayId = jSONObject.optString("prepayid");
        payReq.packageValue = jSONObject.optString("packagealias");
        payReq.nonceStr = jSONObject.optString("noncestr");
        payReq.timeStamp = jSONObject.optString("timestamp");
        payReq.sign = jSONObject.optString("sign");
        return payReq;
    }
}
