package d.b.j0.s.b.i;

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
import d.b.c.e.p.l;
import d.b.h0.a.q1.b.f.d;
import d.b.h0.a.r1.e;
import d.b.h0.a.w0.c.f;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes4.dex */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public static BroadcastReceiver f61811a;

    /* loaded from: classes4.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.z.e.a f61812a;

        public a(b bVar, d.b.z.e.a aVar) {
            this.f61812a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            this.f61812a.onPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
        }
    }

    /* renamed from: d.b.j0.s.b.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1589b implements d.b.j0.s.b.i.d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.z.e.a f61813a;

        public C1589b(b bVar, d.b.z.e.a aVar) {
            this.f61813a = aVar;
        }

        @Override // d.b.j0.s.b.i.d.a
        public void a(Bundle bundle) {
            d.b.z.e.a aVar = this.f61813a;
            if (aVar == null) {
                return;
            }
            aVar.onPayResult(bundle.getInt("result_code"), bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BroadcastReceiver {
        public final /* synthetic */ d.b.z.e.a val$callback;

        public c(d.b.z.e.a aVar) {
            this.val$callback = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            intent.getExtras();
            this.val$callback.onPayResult(intent.getExtras().getInt("errorCode", -1), intent.getExtras().getString("errorMsg"));
        }
    }

    @Override // d.b.h0.a.w0.c.f
    public void a(Context context, JSONObject jSONObject, d.b.z.e.a aVar) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
        PayReq e2 = e(jSONObject);
        createWXAPI.registerApp(e2.appId);
        if (!createWXAPI.isWXAppInstalled()) {
            aVar.onPayResult(3, "wx_not_installed");
            d.f(context, "您没有安装微信，请选择其他支付方式").C();
        } else if (e.y() == null) {
        } else {
            if (!createWXAPI.sendReq(e2)) {
                aVar.onPayResult(6, "wx_start_failed");
            }
            if (f61811a != null) {
                TbadkCoreApplication.getInst().unregisterReceiver(f61811a);
            }
            f61811a = new c(aVar);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("WXPayResult");
            TbadkCoreApplication.getInst().registerReceiver(f61811a, intentFilter);
        }
    }

    @Override // d.b.h0.a.w0.c.f
    public boolean b(Context context) {
        if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
            return true;
        }
        d.f(context, "您没有安装微信，请选择其他支付方式").C();
        return false;
    }

    @Override // d.b.h0.a.w0.c.f
    public void c(Activity activity, String str, d.b.z.e.a aVar) {
        DelegateUtils.callOnMainWithActivity(d.b.h0.a.z0.f.V().getActivity(), MainProcessDelegateActivity.class, d.b.j0.s.b.i.e.a.class, d.b.j0.s.b.i.e.a.b(str), new a(this, aVar));
    }

    @Override // d.b.h0.a.w0.c.f
    public void d(Activity activity, String str, d.b.z.e.a aVar) {
        if (!d.b.i0.l0.c.c().g()) {
            l.K(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
            return;
        }
        e y = e.y();
        if (y == null || y.A() == null) {
            return;
        }
        d.b.j0.s.b.i.a aVar2 = new d.b.j0.s.b.i.a();
        aVar2.mParams.putInt("type", 2);
        aVar2.mParams.putString("orderInfo", str);
        aVar2.b(y.A());
        aVar2.c(new C1589b(this, aVar));
        aVar2.onExec();
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
