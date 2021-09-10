package j.a.a.e.k;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.cache.CacheEngine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.NetworkUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.TraceIdUtil;
import com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayStatus;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j.a.a.e.k.c f79094a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f79095b;

    /* renamed from: c  reason: collision with root package name */
    public AppPayServiceListener f79096c;

    /* renamed from: d  reason: collision with root package name */
    public j.a.a.e.k.d f79097d;

    /* renamed from: e  reason: collision with root package name */
    public String f79098e;

    /* renamed from: f  reason: collision with root package name */
    public PayFlowType f79099f;

    /* renamed from: g  reason: collision with root package name */
    public int f79100g;

    /* renamed from: h  reason: collision with root package name */
    public int f79101h;

    /* loaded from: classes2.dex */
    public class a implements j.a.a.e.o.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79102a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f79103b;

        public a(f fVar, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79103b = fVar;
            this.f79102a = absViewEventHandler;
        }

        @Override // j.a.a.e.o.d.a
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayAmountDialog");
                this.f79103b.q(cancelType, this.f79102a);
                j.a.a.e.k.g.a(this.f79103b.f79100g, this.f79103b.f79101h, cancelType);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IYYPayAmountView.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f79104a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f79105b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f79106c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79107d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f79109f;

        public b(f fVar, Dialog dialog, Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dialog, activity, viewParams, iPayCallback, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79109f = fVar;
            this.f79104a = dialog;
            this.f79105b = activity;
            this.f79106c = viewParams;
            this.f79107d = iPayCallback;
            this.f79108e = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RLog.error("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
                j.a.a.e.n.i.f79175a.b(this.f79104a);
                RLog.info("YYPayDialogController", "showPayAmountDialog onRefreshViewFail notifyViewStateChange");
                this.f79109f.r(this.f79108e, PayDialogType.PAY_NONE_DIALOG);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
                RLog.info("YYPayDialogController", "showInputNumberDialog");
                j.a.a.e.n.i.f79175a.b(this.f79104a);
                this.f79109f.v(activity, list, this.f79106c, this.f79107d);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(j.a.a.e.l.a aVar, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, list) == null) {
                RLog.info("YYPayDialogController", "toPayWayDialog");
                j.a.a.e.n.i.f79175a.b(this.f79104a);
                this.f79109f.z(this.f79105b, aVar, list, this.f79106c, this.f79107d);
                j.a.a.e.m.a.b(this.f79109f.f79100g, this.f79109f.f79101h, UiEventType.purchasegotopay);
                RLog.warn("YYPayDialogController", UiEventType.purchasegotopay);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements j.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79110a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f79111b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f79112c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f79113d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f79115f;

        public c(f fVar, AbsViewEventHandler absViewEventHandler, Activity activity, List list, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, absViewEventHandler, activity, list, viewParams, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79115f = fVar;
            this.f79110a = absViewEventHandler;
            this.f79111b = activity;
            this.f79112c = list;
            this.f79113d = viewParams;
            this.f79114e = iPayCallback;
        }

        @Override // j.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissInputDialog");
                this.f79115f.q(cancelType, this.f79110a);
            }
        }

        @Override // j.a.a.e.o.d.b
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                j.a.a.e.l.a o = this.f79115f.o((int) (i2 * 100.0d));
                RLog.info("YYPayDialogController", "showPayWayDialog: mPayAmountCustom:%s", o);
                this.f79115f.z(this.f79111b, o, this.f79112c, this.f79113d, this.f79114e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements j.a.a.e.o.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f79116a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f79118c;

        public d(f fVar, IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iAppPayService, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79118c = fVar;
            this.f79116a = iAppPayService;
            this.f79117b = absViewEventHandler;
        }

        @Override // j.a.a.e.o.d.a
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "on payWayDialog cancel clickArea：" + cancelType.name());
                if (this.f79118c.f79096c != null) {
                    RLog.debug("YYPayDialogController", "showPayWayDialog removePayListener");
                    this.f79116a.removePayListener(this.f79118c.f79096c);
                    this.f79118c.f79096c = null;
                    this.f79118c.f79098e = null;
                }
                this.f79118c.q(cancelType, this.f79117b);
                j.a.a.e.k.g.b(this.f79118c.f79100g, this.f79118c.f79101h, cancelType);
                RLog.info("YYPayDialogController", "dismissPayWayDialog");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements IYYPayWayView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f79119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f79120b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f79121c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f79122d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f79125g;

        public e(f fVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, activity, dialog, iYYPayWayView, bVar, iPayCallback, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79125g = fVar;
            this.f79119a = activity;
            this.f79120b = dialog;
            this.f79121c = iYYPayWayView;
            this.f79122d = bVar;
            this.f79123e = iPayCallback;
            this.f79124f = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(j.a.a.e.l.c cVar, j.a.a.e.l.a aVar, AppCustomExpand appCustomExpand) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, aVar, appCustomExpand) == null) {
                this.f79125g.u(this.f79119a, cVar, aVar, this.f79120b, this.f79121c, appCustomExpand, this.f79122d, this.f79123e);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                Dialog dialog = this.f79120b;
                if (dialog != null) {
                    dialog.dismiss();
                }
                RLog.info("YYPayDialogController", "showPayWayDialog onRefreshViewFail notifyViewStateChange");
                this.f79125g.r(this.f79124f, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    /* renamed from: j.a.a.e.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2146f extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f79126a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f79127b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f79128c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f79129d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f79131f;

        public C2146f(f fVar, Activity activity, IYYPayWayView.b bVar, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, activity, bVar, dialog, iYYPayWayView, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79131f = fVar;
            this.f79126a = activity;
            this.f79127b = bVar;
            this.f79128c = dialog;
            this.f79129d = iYYPayWayView;
            this.f79130e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                super.onCurrencyChargeMessage(currencyChargeMessage);
                String traceid = currencyChargeMessage.reqParams.getTraceid();
                RLog.info("YYPayDialogController", "onCurrencyChargeMessage messgaeTraceId:" + traceid + " message:" + currencyChargeMessage.toString());
                if (!traceid.equals(this.f79131f.f79098e)) {
                    RLog.warn("YYPayDialogController", "messgaeTraceId not equal mTraceId");
                    return;
                }
                boolean z = false;
                boolean z2 = currencyChargeMessage.status == 1;
                if (j.a.a.e.n.i.f79175a.a(this.f79126a)) {
                    IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                    IYYPayWayView.b bVar2 = this.f79127b;
                    z = (z2 && (bVar2 != null && bVar2.f79944d)) ? true : true;
                    currencyChargeMessage.payMethod = currencyChargeMessage.reqParams.getPayMethod();
                    if (z) {
                        this.f79131f.x(this.f79126a, currencyChargeMessage, this.f79128c, bVar, this.f79129d, this.f79127b);
                    } else {
                        j.a.a.e.n.i.f79175a.b(this.f79128c);
                    }
                }
                IPayCallback iPayCallback = this.f79130e;
                if (iPayCallback != null) {
                    if (z2) {
                        iPayCallback.onSuccess(currencyChargeMessage, null);
                    } else {
                        iPayCallback.onFail(currencyChargeMessage.status, "", null);
                    }
                }
                if (z2) {
                    int cid = currencyChargeMessage.reqParams.getCid();
                    String payChannel = currencyChargeMessage.reqParams.getPayChannel();
                    String payMethod = currencyChargeMessage.reqParams.getPayMethod();
                    IYYPayWayView.b bVar3 = this.f79127b;
                    j.a.a.e.m.a.d(this.f79131f.f79100g, currencyChargeMessage.usedChannel, (bVar3 == null || bVar3.f79946f != PaySource.WALLET) ? "7" : "14", payChannel, payMethod, String.valueOf(cid));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements IPayCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79132a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f79133b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f79134c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f79135d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.l.c f79136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f79137f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f79138g;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79139e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79139e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f79139e;
                    gVar.f79138g.t(gVar.f79134c, gVar.f79135d, true);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79140e;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79140e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f79140e;
                    gVar.f79138g.t(gVar.f79134c, gVar.f79135d, false);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79141e;

            public c(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79141e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!j.a.a.e.n.f.a(this.f79141e.f79136e.f79166a) && !PayType.UNION_PAY.getChannel().equals(this.f79141e.f79136e.f79166a.getChannel()) && !PayType.MOCK_TEST_PAY.getChannel().equals(this.f79141e.f79136e.f79166a.getChannel())) {
                        g gVar = this.f79141e;
                        gVar.f79138g.t(gVar.f79134c, gVar.f79135d, true);
                        return;
                    }
                    RLog.info("YYPayDialogController", "requestPayInternal onSuccess h5 not loadding");
                }
            }
        }

        /* loaded from: classes2.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79142e;

            public d(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79142e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f79142e;
                    gVar.f79138g.t(gVar.f79134c, gVar.f79135d, false);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79143e;

            public e(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79143e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    cVar.f79939a = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    IYYPayWayView.b bVar = this.f79143e.f79137f;
                    if (bVar != null) {
                        cVar.f79940b = bVar.f79945e;
                        PaySource paySource = bVar.f79946f;
                    }
                    g gVar = this.f79143e;
                    gVar.f79138g.y(gVar.f79133b, cVar);
                    j.a.a.e.n.i.f79175a.b(this.f79143e.f79134c);
                }
            }
        }

        public g(f fVar, IPayCallback iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, j.a.a.e.l.c cVar, IYYPayWayView.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79138g = fVar;
            this.f79132a = iPayCallback;
            this.f79133b = activity;
            this.f79134c = dialog;
            this.f79135d = iYYPayWayView;
            this.f79136e = cVar;
            this.f79137f = bVar;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
                IPayCallback iPayCallback = this.f79132a;
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, str, payCallBackBean);
                }
                this.f79138g.p(i2, str, payCallBackBean);
                if (j.a.a.e.n.i.f79175a.a(this.f79133b)) {
                    if (i2 == PayStatus.CANCEL.getCode()) {
                        RLog.info("YYPayDialogController", "取消支付 code:" + i2);
                        this.f79133b.runOnUiThread(new d(this));
                        return;
                    }
                    this.f79133b.runOnUiThread(new e(this));
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onPayStart");
                IPayCallback iPayCallback = this.f79132a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStart();
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseStatus, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onPayStatus code " + purchaseStatus.getCode() + " msg: " + purchaseStatus.getMessage());
                IPayCallback iPayCallback = this.f79132a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
                if (j.a.a.e.n.i.f79175a.a(this.f79133b)) {
                    if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                        this.f79133b.runOnUiThread(new a(this));
                    } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                    } else {
                        this.f79133b.runOnUiThread(new b(this));
                    }
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onSuccess");
                if (j.a.a.e.n.i.f79175a.a(this.f79133b)) {
                    this.f79133b.runOnUiThread(new c(this));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements j.a.a.e.o.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79144a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f79145b;

        public h(f fVar, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79145b = fVar;
            this.f79144a = absViewEventHandler;
        }

        @Override // j.a.a.e.o.d.a
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayResultDialog");
                this.f79145b.q(cancelType, this.f79144a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements IYYPayResultView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f79146a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79147b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f79148c;

        public i(f fVar, Dialog dialog, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dialog, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79148c = fVar;
            this.f79146a = dialog;
            this.f79147b = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Dialog dialog = this.f79146a;
                if (dialog != null) {
                    dialog.dismiss();
                }
                RLog.info("YYPayDialogController", "onBtnConfirm onPayFlowFinish");
                this.f79148c.r(this.f79147b, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    public f(int i2, int i3, j.a.a.e.k.d dVar, j.a.a.e.k.c cVar, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), dVar, cVar, payFlowType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79100g = i2;
        this.f79101h = i3;
        this.f79097d = dVar;
        this.f79095b = dVar != null ? dVar.getPayUIKitConfig() : null;
        this.f79094a = cVar;
        this.f79099f = payFlowType;
        RLog.info("YYPayDialogController", "new PayDialogController");
    }

    public void A(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bVar, iPayCallback) == null) {
            IAppPayService a2 = j.a.a.e.n.b.a(this.f79100g, this.f79101h);
            if (a2 == null) {
                RLog.error("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            IYYPayWayView b2 = this.f79094a.b(activity, bVar);
            b2.refreshView();
            AbsViewEventHandler absViewEventHandler = bVar != null ? bVar.f79945e : null;
            r(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            RLog.info("YYPayDialogController", "showPayWayDialog");
            Dialog c2 = j.a.a.e.o.d.d.f79232b.c(activity, activity.getString(j.a.a.e.f.pay_ui_dialog_pay_title), b2.getContentView(), new d(this, a2, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            b2.setCallback(new e(this, activity, c2, b2, bVar, iPayCallback, absViewEventHandler));
            C2146f c2146f = new C2146f(this, activity, bVar, c2, b2, iPayCallback);
            this.f79096c = c2146f;
            a2.addPayListener(c2146f);
            RLog.debug("YYPayDialogController", "showPayWayDialog addPayListener");
        }
    }

    public j.a.a.e.l.a o(int i2) {
        InterceptResult invokeI;
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.cid = 0;
            productInfo.productId = "";
            productInfo.srcCurrencySymbol = "";
            productInfo.srcAmount = Double.valueOf(i2 / 100.0d);
            PayUIKitConfig payUIKitConfig = this.f79095b;
            if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null && middleRevenueConfig.getCurrencyType() == 4) {
                productInfo.destAmount = i2;
                return new j.a.a.e.l.a(productInfo, 4);
            }
            productInfo.destAmount = i2;
            return new j.a.a.e.l.a(productInfo);
        }
        return (j.a.a.e.l.a) invokeI.objValue;
    }

    public final void p(int i2, String str, PayCallBackBean payCallBackBean) {
        j.a.a.e.k.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, payCallBackBean) == null) || (dVar = this.f79097d) == null) {
            return;
        }
        dVar.notifyYYPayFailListener(i2, str, payCallBackBean);
    }

    public final void q(CancelType cancelType, AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cancelType, absViewEventHandler) == null) {
            RLog.info("YYPayDialogController", "notifyViewFlowClose clickArea:" + cancelType);
            if (cancelType == CancelType.BUTTOM_AREA_CLICK || cancelType == CancelType.EMPTY_AREA_CLICK || cancelType == CancelType.ON_DIALOG_CANCEL || cancelType == CancelType.ON_START_SHOW_FAIL) {
                RLog.info("YYPayDialogController", "notifyViewFlowClose onPayFlowFinish");
                r(absViewEventHandler, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    public final void r(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, absViewEventHandler, payDialogType) == null) {
            if (payDialogType == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info("YYPayDialogController", "notifyViewStateChange PAY_NONE_DIALOG onPayFlowFinish");
                s();
            }
            if (absViewEventHandler != null && payDialogType != null) {
                RLog.info("YYPayDialogController", "notifyViewStateChange payDialogType:" + payDialogType.name());
                absViewEventHandler.onViewStateChange(payDialogType);
                return;
            }
            RLog.info("YYPayDialogController", "notifyViewStateChange null");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f79097d == null) {
            return;
        }
        RLog.info("YYPayDialogController", "onPayFlowFinish");
        PayFlowType payFlowType = PayFlowType.DIOALOG_PAY_FLOW;
        if (payFlowType == this.f79099f) {
            this.f79097d.onPayFlowFinish(payFlowType);
        }
    }

    public final void t(Dialog dialog, IYYPayWayView iYYPayWayView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, dialog, iYYPayWayView, z) == null) {
            IYYPayWayView.PayViewState payViewState = z ? IYYPayWayView.PayViewState.WAITING_VIEW_STATE : IYYPayWayView.PayViewState.SELECTING_VIEW_STATE;
            if (iYYPayWayView != null) {
                iYYPayWayView.setViewState(payViewState);
            }
            if (z) {
                j.a.a.e.o.d.d.f79232b.d(dialog);
            } else {
                j.a.a.e.o.d.d.f79232b.b(dialog);
            }
        }
    }

    public final void u(Activity activity, j.a.a.e.l.c cVar, j.a.a.e.l.a aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{activity, cVar, aVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info("YYPayDialogController", " requestPayInternal");
            g gVar = new g(this, iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar);
            this.f79098e = TraceIdUtil.newTraceId();
            RLog.info("YYPayDialogController", " requestPayInternal new mTraceId:" + this.f79098e);
            this.f79094a.a(activity, cVar, aVar, appCustomExpand, gVar, this.f79098e);
        }
    }

    public final void v(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, list, viewParams, iPayCallback) == null) {
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            r(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            RLog.info("YYPayDialogController", "showInputDialog");
            j.a.a.e.o.d.c.f79201a.f(activity, new c(this, absViewEventHandler, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f79095b);
        }
    }

    public void w(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, iPayCallback, viewParams) == null) {
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            if (!NetworkUtil.isNetworkStrictlyAvailable(activity)) {
                Toast.makeText(activity, "网络不给力，请稍后重试", 1).show();
                RLog.error("YYPayDialogController", "showPayAmountDialog fail: network error", new Object[0]);
                q(CancelType.ON_START_SHOW_FAIL, absViewEventHandler);
            } else if (viewParams != null && (i2 = viewParams.targetAmount) > 0) {
                if (i2 > 5.0E7d) {
                    viewParams.targetAmount = CacheEngine.MAX_DISK_CACHE;
                }
                z(activity, o(viewParams.targetAmount), null, viewParams, iPayCallback);
                RLog.info("YYPayDialogController", "showPayAmountDialog targetAmount:" + viewParams.targetAmount);
            } else {
                IYYPayAmountView i3 = this.f79094a.i(activity, viewParams);
                i3.refreshView();
                String string = activity.getString(j.a.a.e.f.pay_ui_dialog_title);
                if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                    string = viewParams.payAmountDialogTitle;
                }
                RLog.info("YYPayDialogController", "showPayAmountDialog");
                r(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
                i3.setCallback(new b(this, j.a.a.e.o.d.d.f79232b.c(activity, string, i3.getContentView(), new a(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG), activity, viewParams, iPayCallback, absViewEventHandler));
            }
        }
    }

    public final void x(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (!j.a.a.e.n.f.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod) && !PayType.MOCK_TEST_PAY.getChannel().equals(currencyChargeMessage.payChannel) && !PayType.UNION_PAY.getChannel().equals(currencyChargeMessage.payChannel)) {
                j.a.a.e.n.i.f79175a.b(dialog);
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                cVar.f79939a = bVar;
                cVar.f79940b = bVar2.f79945e;
                PaySource paySource = bVar2.f79946f;
                y(activity, cVar);
                return;
            }
            t(dialog, iYYPayWayView, false);
        }
    }

    public final void y(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, activity, cVar) == null) {
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f79940b : null;
            r(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            IYYPayResultView c2 = this.f79094a.c(activity, cVar);
            RLog.info("YYPayDialogController", "showPayResultDialog");
            c2.setCallback(new i(this, j.a.a.e.o.d.d.f79232b.c(activity, activity.getString(j.a.a.e.f.pay_ui_dialog_pay_title), c2.getContentView(), new h(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG), absViewEventHandler));
        }
    }

    public void z(Activity activity, j.a.a.e.l.a aVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048588, this, activity, aVar, list, viewParams, iPayCallback) == null) {
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f79942b = aVar;
            bVar.f79941a = list;
            if (viewParams != null) {
                bVar.f79943c = viewParams.appCustomExpand;
                bVar.f79944d = viewParams.closeOnSuccess;
                bVar.f79945e = viewParams.viewEventListener;
            }
            A(activity, bVar, iPayCallback);
        }
    }
}
