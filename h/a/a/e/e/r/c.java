package h.a.a.e.e.r;

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
/* loaded from: classes7.dex */
public class c implements IYYPayAmountView.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f45173b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f45174c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f45175d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f45176e;

    /* renamed from: f  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f45177f;

    /* renamed from: g  reason: collision with root package name */
    public h.a.a.e.e.f f45178g;

    public c(int i, int i2, Dialog dialog, IYYPayAmountView.ViewParams viewParams, Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, h.a.a.e.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), dialog, viewParams, activity, iPayCallback, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayAmountViewCallback", "create PayAmountViewCallback appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.f45173b = i2;
        this.f45174c = dialog;
        this.f45175d = viewParams;
        this.f45176e = activity;
        this.f45177f = iPayCallback;
        this.f45178g = fVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            RLog.error("PayAmountViewCallback", "showPayAmountDialog onFail code:" + i + " failReason:" + str, new Object[0]);
            h.a.a.e.h.h.b(this.f45174c, PayDialogType.PAY_AMOUNT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
            RLog.info("PayAmountViewCallback", "showInputNumberDialog");
            h.a.a.e.h.h.a(this.f45174c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f45178g.j(activity, list, this.f45175d, this.f45177f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toPayWayDialog(h.a.a.e.f.c cVar, List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, list) == null) {
            RLog.info("PayAmountViewCallback", "toPayWayDialog");
            h.a.a.e.h.h.a(this.f45174c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.f45178g.g(this.f45176e, cVar, list, this.f45175d, this.f45177f);
            h.a.a.e.g.b.b(this.a, this.f45173b, UiEventType.purchasegotopay);
        }
    }
}
