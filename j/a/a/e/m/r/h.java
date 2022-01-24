package j.a.a.e.m.r;

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
/* loaded from: classes4.dex */
public class h implements IPayCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f62360b;

    /* renamed from: c  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f62361c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f62362d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f62363e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayWayView f62364f;

    /* renamed from: g  reason: collision with root package name */
    public j.a.a.e.m.h f62365g;

    /* renamed from: h  reason: collision with root package name */
    public j.a.a.e.n.f f62366h;

    /* renamed from: i  reason: collision with root package name */
    public IYYPayWayView.b f62367i;

    /* renamed from: j  reason: collision with root package name */
    public j.a.a.e.m.f f62368j;

    public h(int i2, int i3, IPayCallback<CurrencyChargeMessage> iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, j.a.a.e.m.h hVar, j.a.a.e.n.f fVar, IYYPayWayView.b bVar, j.a.a.e.m.f fVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), iPayCallback, activity, dialog, iYYPayWayView, hVar, fVar, bVar, fVar2};
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
        this.f62360b = i3;
        this.f62361c = iPayCallback;
        this.f62362d = activity;
        this.f62363e = dialog;
        this.f62364f = iYYPayWayView;
        this.f62365g = hVar;
        this.f62366h = fVar;
        this.f62367i = bVar;
        this.f62368j = fVar2;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f62361c;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, payCallBackBean);
            }
            this.f62368j.b(i2, str, payCallBackBean);
            j.a.a.e.o.a.b(this.a, this.f62360b, i2, str);
            this.f62365g.o(i2, str, this.f62362d, this.f62363e, this.f62364f, this.f62367i);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onPayStart");
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f62361c;
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
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f62361c;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
            this.f62365g.l(this.f62362d, this.f62363e, this.f62364f, purchaseStatus);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onSuccess");
            this.f62365g.f(this.f62362d, this.f62366h, this.f62363e, this.f62364f);
        }
    }
}
