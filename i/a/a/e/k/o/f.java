package i.a.a.e.k.o;

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

    /* renamed from: a  reason: collision with root package name */
    public int f72315a;

    /* renamed from: b  reason: collision with root package name */
    public int f72316b;

    /* renamed from: c  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f72317c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f72318d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f72319e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayWayView f72320f;

    /* renamed from: g  reason: collision with root package name */
    public i.a.a.e.k.e f72321g;

    /* renamed from: h  reason: collision with root package name */
    public i.a.a.e.l.f f72322h;

    /* renamed from: i  reason: collision with root package name */
    public IYYPayWayView.b f72323i;
    public i.a.a.e.k.c j;

    public f(int i2, int i3, IPayCallback<CurrencyChargeMessage> iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, i.a.a.e.k.e eVar, i.a.a.e.l.f fVar, IYYPayWayView.b bVar, i.a.a.e.k.c cVar) {
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
        this.f72315a = i2;
        this.f72316b = i3;
        this.f72317c = iPayCallback;
        this.f72318d = activity;
        this.f72319e = dialog;
        this.f72320f = iYYPayWayView;
        this.f72321g = eVar;
        this.f72322h = fVar;
        this.f72323i = bVar;
        this.j = cVar;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f72317c;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, payCallBackBean);
            }
            this.j.a(i2, str, payCallBackBean);
            i.a.a.e.m.a.b(this.f72315a, this.f72316b, i2, str);
            this.f72321g.l(i2, str, this.f72318d, this.f72319e, this.f72320f, this.f72323i);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onPayStart");
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f72317c;
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
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.f72317c;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
            this.f72321g.j(this.f72318d, this.f72319e, this.f72320f, purchaseStatus);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onSuccess");
            this.f72321g.d(this.f72318d, this.f72322h, this.f72319e, this.f72320f);
        }
    }
}
