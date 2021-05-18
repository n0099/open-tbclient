package d.a.k0.s.b.f;

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
import d.a.i0.a.c1.d.f;
import d.a.i0.a.z1.b.f.e;
import d.a.j0.l0.d;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes4.dex */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public static BroadcastReceiver f60697a;

    /* loaded from: classes4.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.z.e.a f60698a;

        public a(b bVar, d.a.z.e.a aVar) {
            this.f60698a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            this.f60698a.onPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
        }
    }

    /* renamed from: d.a.k0.s.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1599b implements d.a.k0.s.b.f.d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.z.e.a f60699a;

        public C1599b(b bVar, d.a.z.e.a aVar) {
            this.f60699a = aVar;
        }

        @Override // d.a.k0.s.b.f.d.a
        public void a(Bundle bundle) {
            d.a.z.e.a aVar = this.f60699a;
            if (aVar == null) {
                return;
            }
            aVar.onPayResult(bundle.getInt("result_code"), bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BroadcastReceiver {
        public final /* synthetic */ d.a.z.e.a val$callback;

        public c(d.a.z.e.a aVar) {
            this.val$callback = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            intent.getExtras();
            this.val$callback.onPayResult(intent.getExtras().getInt("errorCode", -1), intent.getExtras().getString("errorMsg"));
        }
    }

    @Override // d.a.i0.a.c1.d.f
    public boolean a(Context context) {
        if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
            return true;
        }
        e.g(context, "您没有安装微信，请选择其他支付方式").F();
        return false;
    }

    @Override // d.a.i0.a.c1.d.f
    public void b(Activity activity, String str, d.a.z.e.a aVar) {
        if (!d.c().g()) {
            l.L(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
            return;
        }
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null || i2.k() == null) {
            return;
        }
        d.a.k0.s.b.f.a aVar2 = new d.a.k0.s.b.f.a();
        aVar2.mParams.putInt("type", 2);
        aVar2.mParams.putString("orderInfo", str);
        aVar2.b(i2.k());
        aVar2.c(new C1599b(this, aVar));
        aVar2.onExec();
    }

    @Override // d.a.i0.a.c1.d.f
    public void c(Context context, JSONObject jSONObject, d.a.z.e.a aVar) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
        PayReq e2 = e(jSONObject);
        createWXAPI.registerApp(e2.appId);
        if (!createWXAPI.isWXAppInstalled()) {
            aVar.onPayResult(3, "wx_not_installed");
            e.g(context, "您没有安装微信，请选择其他支付方式").F();
        } else if (d.a.i0.a.a2.e.i() == null) {
        } else {
            if (!createWXAPI.sendReq(e2)) {
                aVar.onPayResult(6, "wx_start_failed");
            }
            if (f60697a != null) {
                TbadkCoreApplication.getInst().unregisterReceiver(f60697a);
            }
            f60697a = new c(aVar);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("WXPayResult");
            TbadkCoreApplication.getInst().registerReceiver(f60697a, intentFilter);
        }
    }

    @Override // d.a.i0.a.c1.d.f
    public void d(Activity activity, String str, d.a.z.e.a aVar) {
        DelegateUtils.callOnMainWithActivity(d.a.i0.a.g1.f.V().getActivity(), MainProcessDelegateActivity.class, d.a.k0.s.b.f.e.a.class, d.a.k0.s.b.f.e.a.b(str), new a(this, aVar));
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
