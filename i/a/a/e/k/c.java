package i.a.a.e.k;

import android.app.Activity;
import android.app.Dialog;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes3.dex */
public interface c {
    void a(int i2, String str, PayCallBackBean payCallBackBean);

    void b(CancelType cancelType, AbsViewEventHandler absViewEventHandler);

    void c(Activity activity, i.a.a.e.l.f fVar, i.a.a.e.l.c cVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void e(Activity activity, i.a.a.e.l.c cVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void f(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType);

    void g();

    void h(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    boolean i(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler);

    boolean k(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler);
}
