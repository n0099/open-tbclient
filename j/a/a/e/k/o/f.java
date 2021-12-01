package j.a.a.e.k.o;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes3.dex */
public class f implements IPayCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f64169b;

    /* renamed from: c  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f64170c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f64171d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f64172e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayWayView f64173f;

    /* renamed from: g  reason: collision with root package name */
    public j.a.a.e.k.e f64174g;

    /* renamed from: h  reason: collision with root package name */
    public j.a.a.e.l.f f64175h;

    /* renamed from: i  reason: collision with root package name */
    public IYYPayWayView.b f64176i;

    /* renamed from: j  reason: collision with root package name */
    public j.a.a.e.k.c f64177j;

    public f(int i2, int i3, IPayCallback<CurrencyChargeMessage> iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, j.a.a.e.k.e eVar, j.a.a.e.l.f fVar, IYYPayWayView.b bVar, j.a.a.e.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), iPayCallback, activity, dialog, iYYPayWayView, eVar, fVar, bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayInternalCallback", "create PayInternalCallback appId:" + i2 + " userChannel:" + i3);
        this.a = i2;
        this.f64169b = i3;
        this.f64170c = iPayCallback;
        this.f64171d = activity;
        this.f64172e = dialog;
        this.f64173f = iYYPayWayView;
        this.f64174g = eVar;
        this.f64175h = fVar;
        this.f64176i = bVar;
        this.f64177j = cVar;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f64170c;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, payCallBackBean);
            }
            this.f64177j.a(i2, str, payCallBackBean);
            j.a.a.e.m.a.b(this.a, this.f64169b, i2, str);
            this.f64174g.l(i2, str, this.f64171d, this.f64172e, this.f64173f, this.f64176i);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onPayStart");
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f64170c;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseStatus, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onPayStatus code " + purchaseStatus.getCode() + " msg: " + purchaseStatus.getMessage());
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f64170c;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
            this.f64174g.j(this.f64171d, this.f64172e, this.f64173f, purchaseStatus);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onSuccess");
            this.f64174g.d(this.f64171d, this.f64175h, this.f64172e, this.f64173f);
        }
    }
}
