package i.a.a.e.k;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.H5PayFlowModel;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes9.dex */
public interface b {
    void a(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand, IPayCallback iPayCallback, String str);

    IYYPayWayView b(Activity activity, IYYPayWayView.b bVar);

    IYYPayResultView c(Activity activity, IYYPayResultView.c cVar);

    void clear();

    void d(Activity activity);

    void e(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void g(Activity activity, IYYPayAmountView.ViewParams viewParams);

    PayUIKitConfig getPayUIKitConfig();

    void h(GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult);

    IYYPayAmountView i(Activity activity, IYYPayAmountView.ViewParams viewParams);

    void j(Activity activity, String str, String str2);

    H5PayFlowModel k();

    void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult);

    void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult);
}
