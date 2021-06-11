package i.a.a.e.k;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.model.H5PayFlowModel;
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.YYPayAmountView;
import tv.athena.revenue.payui.view.YYPayResultView;
import tv.athena.revenue.payui.view.YYPayWayView;
/* loaded from: classes8.dex */
public class g implements i.a.a.e.k.b {

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.a f72142a;

    /* renamed from: b  reason: collision with root package name */
    public e f72143b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f72144c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.k.c f72145d;

    /* renamed from: e  reason: collision with root package name */
    public H5PayFlowModel f72146e;

    /* renamed from: f  reason: collision with root package name */
    public int f72147f;

    /* renamed from: g  reason: collision with root package name */
    public int f72148g;

    /* loaded from: classes8.dex */
    public class a implements IResult<ProductListResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f72149a;

        public a(g gVar, IResult iResult) {
            this.f72149a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            IResult iResult = this.f72149a;
            if (iResult != null) {
                iResult.onSuccess(productListResult, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult = this.f72149a;
            if (iResult != null) {
                iResult.onFail(i2, str, payCallBackBean);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IResult<MyBalanceResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f72150a;

        public b(g gVar, IResult iResult) {
            this.f72150a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            IResult iResult = this.f72150a;
            if (iResult != null) {
                iResult.onSuccess(myBalanceResult, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult = this.f72150a;
            if (iResult != null) {
                iResult.onFail(i2, str, payCallBackBean);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements IResult<BannerConfigResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f72151a;

        public c(g gVar, IResult iResult) {
            this.f72151a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            IResult iResult = this.f72151a;
            if (iResult != null) {
                iResult.onSuccess(bannerConfigResult, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult = this.f72151a;
            if (iResult != null) {
                iResult.onFail(i2, str, payCallBackBean);
            }
        }
    }

    public g(int i2, int i3, i.a.a.e.k.a aVar, i.a.a.e.k.c cVar) {
        this.f72147f = i2;
        this.f72142a = aVar;
        this.f72148g = i3;
        this.f72145d = cVar;
        this.f72144c = cVar != null ? cVar.getPayUIKitConfig() : null;
        RLog.info("YYPayController", "new YYPayController mAppId:" + i2 + " mUserChannel:" + i3);
    }

    @Override // i.a.a.e.k.b
    public void a(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand, IPayCallback iPayCallback, String str) {
        i.a.a.e.k.a aVar2 = this.f72142a;
        if (aVar2 == null) {
            RLog.error("YYPayController", "payRequest error modelProvider null", new Object[0]);
            return;
        }
        i.a.a.b.b.a.a d2 = aVar2.d();
        d2.r(iPayCallback);
        d2.p(activity);
        d2.u(aVar.f72152a);
        d2.v(cVar.f72159a);
        d2.q(appCustomExpand);
        d2.z(str);
        if (cVar.f72159a == PayType.DXM_PAY_KJ) {
            d2.w(i.a.a.e.l.b.b(this.f72144c));
        }
        IMiddleRevenue middleRevenue = RevenueManager.instance().getMiddleRevenue(this.f72147f, this.f72148g);
        if (middleRevenue != null && middleRevenue.getMiddlePayService() != null) {
            middleRevenue.getMiddlePayService().a(d2);
        } else {
            RLog.error("YYPayController", "requestPay error middleRevenue null", new Object[0]);
        }
    }

    @Override // i.a.a.e.k.b
    public IYYPayWayView b(Activity activity, IYYPayWayView.b bVar) {
        return new YYPayWayView(activity, this.f72147f, this.f72148g, bVar, this.f72142a, this);
    }

    @Override // i.a.a.e.k.b
    public IYYPayResultView c(Activity activity, IYYPayResultView.c cVar) {
        return new YYPayResultView(activity, this, this.f72142a, this.f72147f, this.f72148g, cVar);
    }

    @Override // i.a.a.e.k.b
    public void clear() {
        this.f72143b = null;
        this.f72146e = null;
        RLog.info("YYPayController", "clear() destory H5PayFlowModel");
    }

    @Override // i.a.a.e.k.b
    public void d(Activity activity) {
        clear();
        String c2 = i.a.a.e.l.b.c(this.f72144c);
        RLog.info("YYPayController", "startWalletActivity walletUrl:" + c2);
        j(activity, c2, "我的钱包");
    }

    @Override // i.a.a.e.k.b
    public void e(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        if (this.f72146e != null) {
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            H5PayFlowModel h5PayFlowModel = this.f72146e;
            bVar.f72922c = h5PayFlowModel.appCustomExpand;
            bVar.f72924e = h5PayFlowModel.viewEventListener;
            bVar.f72925f = PaySource.WALLET;
            RLog.info("YYPayController", "startPayChannelDialog use H5PayFlowModel");
        }
        e eVar = new e(this.f72147f, this.f72148g, this.f72145d, this);
        this.f72143b = eVar;
        eVar.A(activity, bVar, iPayCallback);
    }

    @Override // i.a.a.e.k.b
    public void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        clear();
        l(viewParams);
        e eVar = new e(this.f72147f, this.f72148g, this.f72145d, this);
        this.f72143b = eVar;
        eVar.w(activity, iPayCallback, viewParams);
        i.a.a.e.m.a.b(this.f72147f, this.f72148g, UiEventType.purchaseshow);
        RLog.warn("YYPayController", UiEventType.purchaseshow);
    }

    @Override // i.a.a.e.k.b
    public void g(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        clear();
        l(viewParams);
        String c2 = i.a.a.e.l.b.c(this.f72144c);
        RLog.info("YYPayController", "startWalletActivity walletUrl:" + c2);
        j(activity, c2, "我的钱包");
    }

    @Override // i.a.a.e.k.b
    public PayUIKitConfig getPayUIKitConfig() {
        return this.f72144c;
    }

    @Override // i.a.a.e.k.b
    public void h(GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        IAppPayService a2 = i.a.a.e.n.a.a(getBannerConfigReqParams.getAppId(), getBannerConfigReqParams.getUsedChannel());
        if (a2 != null) {
            a2.queryBannerConfigRequest(getBannerConfigReqParams, new c(this, iResult));
        } else {
            RLog.error("YYPayController", "queryBannerConfig null appPayService", new Object[0]);
        }
    }

    @Override // i.a.a.e.k.b
    public IYYPayAmountView i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        return new YYPayAmountView(activity, this.f72147f, this.f72148g, this, viewParams, this.f72142a);
    }

    @Override // i.a.a.e.k.b
    public void j(Activity activity, String str, String str2) {
        PayUIKitConfig payUIKitConfig = this.f72144c;
        if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
            if (TextUtils.isEmpty(str)) {
                RLog.error("YYPayController", "startActivity error url null", new Object[0]);
                return;
            }
            str2 = (str2 == null || str2.isEmpty()) ? "" : "";
            Intent intent = new Intent(activity, PayCommonWebActivity.class);
            intent.putExtra(H5PayConstant.EXTRA_TITLE, str2);
            intent.putExtra(H5PayConstant.EXTRA_URL, str);
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.f72147f);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.f72148g);
            if (str.equals(i.a.a.e.l.b.c(this.f72144c))) {
                RLog.debug("YYPayController", "startPayWebActivity is wallet");
                intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 1);
            }
            activity.startActivity(intent);
        }
        i.a.a.e.m.a.b(this.f72147f, this.f72148g, UiEventType.walletshow);
        RLog.info("YYPayController", UiEventType.walletshow);
    }

    @Override // i.a.a.e.k.b
    public H5PayFlowModel k() {
        return this.f72146e;
    }

    public final void l(IYYPayAmountView.ViewParams viewParams) {
        if (viewParams != null) {
            H5PayFlowModel h5PayFlowModel = new H5PayFlowModel();
            this.f72146e = h5PayFlowModel;
            h5PayFlowModel.appCustomExpand = viewParams.appCustomExpand;
            h5PayFlowModel.viewEventListener = viewParams.viewEventListener;
            RLog.info("YYPayController", "createH5PayFlowModel  H5PayFlowModel");
        }
    }

    @Override // i.a.a.e.k.b
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        IAppPayService a2 = i.a.a.e.n.a.a(queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel());
        if (a2 != null) {
            a2.queryMyBalance(queryCurrencyReqParams, new b(this, iResult));
        } else {
            RLog.error("YYPayController", "queryMyBalance null appPayService", new Object[0]);
        }
    }

    @Override // i.a.a.e.k.b
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        IAppPayService a2 = i.a.a.e.n.a.a(queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel());
        if (a2 != null) {
            a2.queryProductList(queryCurrencyReqParams, new a(this, iResult));
        } else {
            RLog.error("YYPayController", "queryProductList null appPayService", new Object[0]);
        }
    }
}
