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
/* loaded from: classes2.dex */
public class c implements IYYPayAmountView.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f73227a;

    /* renamed from: b  reason: collision with root package name */
    public int f73228b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f73229c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f73230d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f73231e;

    /* renamed from: f  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f73232f;

    /* renamed from: g  reason: collision with root package name */
    public i.a.a.e.k.c f73233g;

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
        this.f73227a = i2;
        this.f73228b = i3;
        this.f73229c = dialog;
        this.f73230d = viewParams;
        this.f73231e = activity;
        this.f73232f = iPayCallback;
        this.f73233g = cVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public Dialog getPayAmountDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73229c : (Dialog) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onRefreshViewFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            RLog.error("PayAmountViewCallback", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
            i.a.a.e.n.h.b(this.f73229c, PayDialogType.PAY_AMOUNT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, list) == null) {
            RLog.info("PayAmountViewCallback", "showInputNumberDialog");
            i.a.a.e.n.h.a(this.f73229c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f73233g.h(activity, list, this.f73230d, this.f73232f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toPayWayDialog(i.a.a.e.l.c cVar, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, list) == null) {
            RLog.info("PayAmountViewCallback", "toPayWayDialog");
            i.a.a.e.n.h.a(this.f73229c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f73233g.e(this.f73231e, cVar, list, this.f73230d, this.f73232f);
            i.a.a.e.m.b.b(this.f73227a, this.f73228b, UiEventType.purchasegotopay);
        }
    }
}
