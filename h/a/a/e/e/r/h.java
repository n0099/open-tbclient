package h.a.a.e.e.r;

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
/* loaded from: classes7.dex */
public class h implements IPayCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f45179b;

    /* renamed from: c  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f45180c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f45181d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f45182e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayWayView f45183f;

    /* renamed from: g  reason: collision with root package name */
    public h.a.a.e.e.h f45184g;

    /* renamed from: h  reason: collision with root package name */
    public h.a.a.e.f.f f45185h;
    public IYYPayWayView.b i;
    public h.a.a.e.e.f j;

    public h(int i, int i2, IPayCallback<CurrencyChargeMessage> iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, h.a.a.e.e.h hVar, h.a.a.e.f.f fVar, IYYPayWayView.b bVar, h.a.a.e.e.f fVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), iPayCallback, activity, dialog, iYYPayWayView, hVar, fVar, bVar, fVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayInternalCallback", "create PayInternalCallback appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.f45179b = i2;
        this.f45180c = iPayCallback;
        this.f45181d = activity;
        this.f45182e = dialog;
        this.f45183f = iYYPayWayView;
        this.f45184g = hVar;
        this.f45185h = fVar;
        this.i = bVar;
        this.j = fVar2;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onFail code:" + i + " failReason:" + str);
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f45180c;
            if (iPayCallback != null) {
                iPayCallback.onFail(i, str, payCallBackBean);
            }
            this.j.b(i, str, payCallBackBean);
            h.a.a.e.g.a.b(this.a, this.f45179b, i, str);
            this.f45184g.o(i, str, this.f45181d, this.f45182e, this.f45183f, this.i);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onPayStart");
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f45180c;
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
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f45180c;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
            this.f45184g.l(this.f45181d, this.f45182e, this.f45183f, purchaseStatus);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onSuccess");
            this.f45184g.f(this.f45181d, this.f45185h, this.f45182e, this.f45183f);
        }
    }
}
