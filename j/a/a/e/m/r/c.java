package j.a.a.e.m.r;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class c implements IYYPayAmountView.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f62521b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f62522c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f62523d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f62524e;

    /* renamed from: f  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f62525f;

    /* renamed from: g  reason: collision with root package name */
    public j.a.a.e.m.f f62526g;

    public c(int i2, int i3, Dialog dialog, IYYPayAmountView.ViewParams viewParams, Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, j.a.a.e.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), dialog, viewParams, activity, iPayCallback, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayAmountViewCallback", "create PayAmountViewCallback appId:" + i2 + " userChannel:" + i3);
        this.a = i2;
        this.f62521b = i3;
        this.f62522c = dialog;
        this.f62523d = viewParams;
        this.f62524e = activity;
        this.f62525f = iPayCallback;
        this.f62526g = fVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onRefreshViewFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            RLog.error("PayAmountViewCallback", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
            j.a.a.e.p.h.b(this.f62522c, PayDialogType.PAY_AMOUNT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
            RLog.info("PayAmountViewCallback", "showInputNumberDialog");
            j.a.a.e.p.h.a(this.f62522c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f62526g.j(activity, list, this.f62523d, this.f62525f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toPayWayDialog(j.a.a.e.n.c cVar, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, list) == null) {
            RLog.info("PayAmountViewCallback", "toPayWayDialog");
            j.a.a.e.p.h.a(this.f62522c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f62526g.g(this.f62524e, cVar, list, this.f62523d, this.f62525f);
            j.a.a.e.o.b.b(this.a, this.f62521b, UiEventType.purchasegotopay);
        }
    }
}
