package i.a.a.e.i;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes7.dex */
public interface c {
    IYYPayWayView a(Activity activity, IYYPayWayView.b bVar);

    IYYPayResultView b(Activity activity, IYYPayResultView.c cVar);

    void c(Activity activity, i.a.a.e.j.d dVar, i.a.a.e.j.b bVar, IPayCallback iPayCallback);

    void clear();

    void d(Activity activity);

    void e(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback);

    String f();

    IYYPayAmountView g(Activity activity, IYYPayAmountView.ViewParams viewParams);

    void h(Activity activity, String str, String str2);

    void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult);
}
