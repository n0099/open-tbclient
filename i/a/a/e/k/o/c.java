package i.a.a.e.k.o;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
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
/* loaded from: classes3.dex */
public class c implements IYYPayAmountView.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72308a;

    /* renamed from: b  reason: collision with root package name */
    public int f72309b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f72310c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f72311d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f72312e;

    /* renamed from: f  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f72313f;

    /* renamed from: g  reason: collision with root package name */
    public i.a.a.e.k.c f72314g;

    public c(int i2, int i3, Dialog dialog, IYYPayAmountView.ViewParams viewParams, Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, i.a.a.e.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), dialog, viewParams, activity, iPayCallback, cVar};
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
        this.f72308a = i2;
        this.f72309b = i3;
        this.f72310c = dialog;
        this.f72311d = viewParams;
        this.f72312e = activity;
        this.f72313f = iPayCallback;
        this.f72314g = cVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public Dialog getPayAmountDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72310c : (Dialog) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onRefreshViewFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            RLog.error("PayAmountViewCallback", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
            i.a.a.e.n.h.b(this.f72310c, PayDialogType.PAY_AMOUNT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, list) == null) {
            RLog.info("PayAmountViewCallback", "showInputNumberDialog");
            i.a.a.e.n.h.a(this.f72310c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f72314g.h(activity, list, this.f72311d, this.f72313f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toPayWayDialog(i.a.a.e.l.c cVar, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, list) == null) {
            RLog.info("PayAmountViewCallback", "toPayWayDialog");
            i.a.a.e.n.h.a(this.f72310c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f72314g.e(this.f72312e, cVar, list, this.f72311d, this.f72313f);
            i.a.a.e.m.b.b(this.f72308a, this.f72309b, UiEventType.purchasegotopay);
        }
    }
}
