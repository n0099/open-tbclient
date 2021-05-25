package i.a.a.e.i;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.payui.activity.ActivityPageType;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.controller.IYYPayCallback;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.YYPayAmountView;
import tv.athena.revenue.payui.view.YYPayResultView;
import tv.athena.revenue.payui.view.YYPayWayView;
/* loaded from: classes8.dex */
public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.i.a f68865a;

    /* renamed from: b  reason: collision with root package name */
    public IYYPayCallback f68866b;

    /* renamed from: c  reason: collision with root package name */
    public e f68867c;

    /* renamed from: d  reason: collision with root package name */
    public PayUIKitConfig f68868d;

    /* renamed from: e  reason: collision with root package name */
    public int f68869e;

    /* renamed from: f  reason: collision with root package name */
    public int f68870f;

    /* loaded from: classes8.dex */
    public class a implements IResult<ProductListResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f68871a;

        public a(f fVar, IResult iResult) {
            this.f68871a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, d.r.b.a.a.f.b bVar) {
            IResult iResult = this.f68871a;
            if (iResult != null) {
                iResult.onSuccess(productListResult, bVar);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            IResult iResult = this.f68871a;
            if (iResult != null) {
                iResult.onFail(i2, str, bVar);
            }
        }
    }

    public f(int i2, int i3, i.a.a.e.i.a aVar, PayUIKitConfig payUIKitConfig) {
        this.f68869e = i2;
        this.f68865a = aVar;
        this.f68870f = i3;
        this.f68868d = payUIKitConfig;
    }

    @Override // i.a.a.e.i.c
    public IYYPayWayView a(Activity activity, IYYPayWayView.b bVar) {
        return new YYPayWayView(activity, this.f68869e, this.f68870f, bVar, this);
    }

    @Override // i.a.a.e.i.c
    public IYYPayResultView b(Activity activity, IYYPayResultView.c cVar) {
        return new YYPayResultView(activity, this.f68869e, this.f68870f, cVar);
    }

    @Override // i.a.a.e.i.c
    public void c(Activity activity, i.a.a.e.j.d dVar, i.a.a.e.j.b bVar, IPayCallback iPayCallback) {
        i.a.a.e.i.a aVar = this.f68865a;
        if (aVar == null) {
            d.r.b.a.a.f.d.d.e("YYPayController", "payRequest error modelProvider null", new Object[0]);
            return;
        }
        i.a.a.b.b.a.a b2 = aVar.b();
        b2.o(iPayCallback);
        b2.n(activity);
        b2.r(bVar.f68873a);
        b2.s(dVar.f68877a);
        IMiddleRevenue middleRevenue = RevenueManager.instance().getMiddleRevenue(this.f68869e, this.f68870f);
        if (middleRevenue != null && middleRevenue.getMiddlePayService() != null) {
            middleRevenue.getMiddlePayService().e(b2);
        } else {
            d.r.b.a.a.f.d.d.e("YYPayController", "requestPay error middleRevenue null", new Object[0]);
        }
    }

    @Override // i.a.a.e.i.c
    public void clear() {
        this.f68867c = null;
        this.f68866b = null;
    }

    @Override // i.a.a.e.i.c
    public void d(Activity activity) {
        String i2 = i();
        d.r.b.a.a.f.d.d.b("YYPayController", "startWalletActivity walletUrl:" + i2);
        h(activity, i2, "我的钱包");
    }

    @Override // i.a.a.e.i.c
    public void e(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        e eVar = new e(this.f68869e, this.f68870f, this.f68868d, this);
        this.f68867c = eVar;
        eVar.m(activity, iPayCallback, viewParams);
        i.a.a.e.k.a.b(this.f68869e, this.f68870f, "purchaseshow");
        d.r.b.a.a.f.d.d.h("YYPayController", "purchaseshow");
    }

    @Override // i.a.a.e.i.c
    public String f() {
        return i.a.a.e.j.c.c(this.f68868d);
    }

    @Override // i.a.a.e.i.c
    public IYYPayAmountView g(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        return new YYPayAmountView(activity, this, this.f68866b, viewParams, this.f68865a);
    }

    @Override // i.a.a.e.i.c
    public void h(Activity activity, String str, String str2) {
        PayUIKitConfig payUIKitConfig = this.f68868d;
        if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
            if (TextUtils.isEmpty(str)) {
                d.r.b.a.a.f.d.d.e("YYPayController", "startActivity error url null", new Object[0]);
                return;
            }
            str2 = (str2 == null || str2.isEmpty()) ? "Pay" : "Pay";
            Intent intent = new Intent(activity, PayCommonWebActivity.class);
            intent.putExtra(PayCommonWebActivity.EXTRA_TITLE, str2);
            intent.putExtra(PayCommonWebActivity.EXTRA_URL, str);
            intent.putExtra(PayCommonWebActivity.EXTRA_APP_ID, this.f68869e);
            intent.putExtra(PayCommonWebActivity.EXTRA_USER_CHANNEL, this.f68870f);
            if (str.equals(i())) {
                d.r.b.a.a.f.d.d.b("YYPayController", "startPayWebActivity is wallet");
                intent.putExtra(PayCommonWebActivity.EXTRA_PAGE_TYPE, ActivityPageType.WALLET.ordinal());
            }
            activity.startActivity(intent);
        }
        i.a.a.e.k.a.b(this.f68869e, this.f68870f, "walletshow");
        d.r.b.a.a.f.d.d.h("YYPayController", "walletshow");
    }

    public String i() {
        return i.a.a.e.j.c.b(this.f68868d);
    }

    @Override // i.a.a.e.i.c
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        IAppPayService a2 = i.a.a.e.l.a.a(queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel());
        if (a2 != null) {
            a2.queryProductList(queryCurrencyReqParams, new a(this, iResult));
        } else {
            d.r.b.a.a.f.d.d.e("YYPayController", "queryProductList null appPayService", new Object[0]);
        }
    }
}
