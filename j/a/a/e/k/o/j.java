package j.a.a.e.k.o;

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
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes3.dex */
public class j implements IYYPayWayView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f64189b;

    /* renamed from: c  reason: collision with root package name */
    public IYYPayWayView f64190c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayWayView.b f64191d;

    /* renamed from: e  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f64192e;

    /* renamed from: f  reason: collision with root package name */
    public j.a.a.e.k.c f64193f;

    public j(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, j.a.a.e.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dialog, iYYPayWayView, bVar, iPayCallback, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayViewCallback", "create PayWayViewCallback");
        this.a = activity;
        this.f64189b = dialog;
        this.f64190c = iYYPayWayView;
        this.f64191d = bVar;
        this.f64192e = iPayCallback;
        this.f64193f = cVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void a(j.a.a.e.l.f fVar, j.a.a.e.l.c cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, fVar, cVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay");
            this.f64193f.c(this.a, fVar, cVar, this.f64189b, this.f64190c, appCustomExpand, this.f64191d, this.f64192e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayWayViewCallback", "showPayWayDialog onInterruptePayFlow");
            j.a.a.e.n.h.b(this.f64189b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void onRefreshViewFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail");
            j.a.a.e.n.h.b(this.f64189b, PayDialogType.PAY_WAY_DIALOG);
        }
    }
}
