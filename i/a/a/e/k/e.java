package i.a.a.e.k;

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
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.b f73271a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f73272b;

    /* renamed from: c  reason: collision with root package name */
    public AppPayServiceListener f73273c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.k.c f73274d;

    /* renamed from: e  reason: collision with root package name */
    public String f73275e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f73276f;

    /* renamed from: g  reason: collision with root package name */
    public int f73277g;

    /* renamed from: h  reason: collision with root package name */
    public int f73278h;

    /* loaded from: classes9.dex */
    public class a implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f73279a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f73280b;

        public a(e eVar, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73280b = eVar;
            this.f73279a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayAmountDialog");
                this.f73280b.r(cancelType, this.f73279a);
                i.a.a.e.k.f.a(this.f73280b.f73277g, this.f73280b.f73278h, cancelType);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements IYYPayAmountView.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f73281a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f73282b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f73283c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f73284d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f73285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f73286f;

        public b(e eVar, Dialog dialog, Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, dialog, activity, viewParams, iPayCallback, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73286f = eVar;
            this.f73281a = dialog;
            this.f73282b = activity;
            this.f73283c = viewParams;
            this.f73284d = iPayCallback;
            this.f73285e = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RLog.error("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
                i.a.a.e.n.h.f73352a.b(this.f73281a);
                this.f73286f.s(this.f73285e, PayDialogType.PAY_NONE_DIALOG);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
                RLog.info("YYPayDialogController", "showInputNumberDialog");
                i.a.a.e.n.h.f73352a.b(this.f73281a);
                this.f73286f.v(activity, list, this.f73283c, this.f73284d);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(i.a.a.e.l.a aVar, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, list) == null) {
                RLog.info("YYPayDialogController", "toPayWayDialog");
                i.a.a.e.n.h.f73352a.b(this.f73281a);
                this.f73286f.z(this.f73282b, aVar, list, this.f73283c, this.f73284d);
                i.a.a.e.m.a.b(this.f73286f.f73277g, this.f73286f.f73278h, UiEventType.purchasegotopay);
                RLog.warn("YYPayDialogController", UiEventType.purchasegotopay);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements i.a.a.e.o.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f73287a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f73288b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f73289c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f73290d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f73291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f73292f;

        public c(e eVar, AbsViewEventHandler absViewEventHandler, Activity activity, List list, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, absViewEventHandler, activity, list, viewParams, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73292f = eVar;
            this.f73287a = absViewEventHandler;
            this.f73288b = activity;
            this.f73289c = list;
            this.f73290d = viewParams;
            this.f73291e = iPayCallback;
        }

        @Override // i.a.a.e.o.d.c
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissInputDialog");
                this.f73292f.r(cancelType, this.f73287a);
            }
        }

        @Override // i.a.a.e.o.d.c
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                i.a.a.e.l.a p = this.f73292f.p((int) (i2 * 100.0d));
                RLog.info("YYPayDialogController", "showPayWayDialog: mPayAmountCustom:%s", p);
                this.f73292f.z(this.f73288b, p, this.f73289c, this.f73290d, this.f73291e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f73293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f73294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f73295c;

        public d(e eVar, IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, iAppPayService, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73295c = eVar;
            this.f73293a = iAppPayService;
            this.f73294b = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "on payWayDialog cancel");
                if (this.f73295c.f73273c != null) {
                    RLog.debug("YYPayDialogController", "showPayWayDialog removePayListener");
                    this.f73293a.removePayListener(this.f73295c.f73273c);
                    this.f73295c.f73273c = null;
                    this.f73295c.f73275e = null;
                }
                this.f73295c.r(cancelType, this.f73294b);
                i.a.a.e.k.f.b(this.f73295c.f73277g, this.f73295c.f73278h, cancelType);
                RLog.info("YYPayDialogController", "dismissPayWayDialog");
            }
        }
    }

    /* renamed from: i.a.a.e.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C2084e implements IYYPayWayView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f73296a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f73297b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f73298c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f73299d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f73300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f73301f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f73302g;

        public C2084e(e eVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, activity, dialog, iYYPayWayView, bVar, iPayCallback, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73302g = eVar;
            this.f73296a = activity;
            this.f73297b = dialog;
            this.f73298c = iYYPayWayView;
            this.f73299d = bVar;
            this.f73300e = iPayCallback;
            this.f73301f = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, aVar, appCustomExpand) == null) {
                this.f73302g.u(this.f73296a, cVar, aVar, this.f73297b, this.f73298c, appCustomExpand, this.f73299d, this.f73300e);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                Dialog dialog = this.f73297b;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.f73302g.s(this.f73301f, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f73303a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f73304b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f73305c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f73306d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f73307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f73308f;

        public f(e eVar, Activity activity, IYYPayWayView.b bVar, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, activity, bVar, dialog, iYYPayWayView, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73308f = eVar;
            this.f73303a = activity;
            this.f73304b = bVar;
            this.f73305c = dialog;
            this.f73306d = iYYPayWayView;
            this.f73307e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                super.onCurrencyChargeMessage(currencyChargeMessage);
                String traceid = currencyChargeMessage.reqParams.getTraceid();
                RLog.info("YYPayDialogController", "onCurrencyChargeMessage messgaeTraceId:" + traceid + " message:" + currencyChargeMessage.toString());
                if (!traceid.equals(this.f73308f.f73275e)) {
                    RLog.warn("YYPayDialogController", "messgaeTraceId not equal mTraceId");
                    return;
                }
                boolean z = false;
                boolean z2 = currencyChargeMessage.status == 1;
                if (i.a.a.e.n.h.f73352a.a(this.f73303a)) {
                    IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                    IYYPayWayView.b bVar2 = this.f73304b;
                    z = (z2 && (bVar2 != null && bVar2.f74193d)) ? true : true;
                    currencyChargeMessage.payMethod = currencyChargeMessage.reqParams.getPayMethod();
                    if (z) {
                        this.f73308f.x(this.f73303a, currencyChargeMessage, this.f73305c, bVar, this.f73306d, this.f73304b);
                    } else {
                        i.a.a.e.n.h.f73352a.b(this.f73305c);
                    }
                }
                IPayCallback iPayCallback = this.f73307e;
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
                    IYYPayWayView.b bVar3 = this.f73304b;
                    i.a.a.e.m.a.d(this.f73308f.f73277g, currencyChargeMessage.usedChannel, (bVar3 == null || bVar3.f74195f != PaySource.WALLET) ? "7" : "14", payChannel, payMethod, String.valueOf(cid));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements IPayCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f73309a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f73310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f73311c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f73312d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.l.c f73313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f73314f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f73315g;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f73316e;

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
                this.f73316e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f73316e;
                    gVar.f73315g.t(gVar.f73311c, gVar.f73312d, true);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f73317e;

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
                this.f73317e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f73317e;
                    gVar.f73315g.t(gVar.f73311c, gVar.f73312d, false);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f73318e;

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
                this.f73318e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!i.a.a.e.n.e.a(this.f73318e.f73313e.f73343a) && !PayType.MOCK_TEST_PAY.getChannel().equals(this.f73318e.f73313e.f73343a.getChannel())) {
                        g gVar = this.f73318e;
                        gVar.f73315g.t(gVar.f73311c, gVar.f73312d, true);
                        return;
                    }
                    RLog.info("YYPayDialogController", "requestPayInternal onSuccess h5 not loadding");
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f73319e;

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
                this.f73319e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f73319e;
                    gVar.f73315g.t(gVar.f73311c, gVar.f73312d, false);
                }
            }
        }

        /* renamed from: i.a.a.e.k.e$g$e  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC2085e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f73320e;

            public RunnableC2085e(g gVar) {
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
                this.f73320e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    cVar.f74188a = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    IYYPayWayView.b bVar = this.f73320e.f73314f;
                    if (bVar != null) {
                        cVar.f74189b = bVar.f74194e;
                        PaySource paySource = bVar.f74195f;
                    }
                    g gVar = this.f73320e;
                    gVar.f73315g.y(gVar.f73310b, cVar);
                    i.a.a.e.n.h.f73352a.b(this.f73320e.f73311c);
                }
            }
        }

        public g(e eVar, IPayCallback iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, i.a.a.e.l.c cVar, IYYPayWayView.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73315g = eVar;
            this.f73309a = iPayCallback;
            this.f73310b = activity;
            this.f73311c = dialog;
            this.f73312d = iYYPayWayView;
            this.f73313e = cVar;
            this.f73314f = bVar;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
                this.f73315g.f73276f = false;
                IPayCallback iPayCallback = this.f73309a;
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, str, payCallBackBean);
                }
                this.f73315g.q(i2, str, payCallBackBean);
                if (i.a.a.e.n.h.f73352a.a(this.f73310b)) {
                    if (i2 == PayStatus.CANCEL.getCode()) {
                        RLog.info("YYPayDialogController", "取消支付 code:" + i2);
                        this.f73310b.runOnUiThread(new d(this));
                        return;
                    }
                    this.f73310b.runOnUiThread(new RunnableC2085e(this));
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onPayStart");
                IPayCallback iPayCallback = this.f73309a;
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
                IPayCallback iPayCallback = this.f73309a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
                if (i.a.a.e.n.h.f73352a.a(this.f73310b)) {
                    if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                        this.f73310b.runOnUiThread(new a(this));
                    } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                    } else {
                        this.f73310b.runOnUiThread(new b(this));
                    }
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onSuccess");
                this.f73315g.f73276f = false;
                if (i.a.a.e.n.h.f73352a.a(this.f73310b)) {
                    this.f73310b.runOnUiThread(new c(this));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f73321a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f73322b;

        public h(e eVar, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73322b = eVar;
            this.f73321a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayResultDialog");
                this.f73322b.r(cancelType, this.f73321a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements IYYPayResultView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f73323a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f73324b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f73325c;

        public i(e eVar, Dialog dialog, AbsViewEventHandler absViewEventHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, dialog, absViewEventHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73325c = eVar;
            this.f73323a = dialog;
            this.f73324b = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Dialog dialog = this.f73323a;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.f73325c.s(this.f73324b, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    public e(int i2, int i3, i.a.a.e.k.c cVar, i.a.a.e.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), cVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73276f = false;
        this.f73277g = i2;
        this.f73278h = i3;
        this.f73274d = cVar;
        this.f73272b = cVar != null ? cVar.getPayUIKitConfig() : null;
        this.f73271a = bVar;
        RLog.info("YYPayDialogController", "new PayDialogController mOnPayRequest:" + this.f73276f);
    }

    public void A(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bVar, iPayCallback) == null) {
            IAppPayService a2 = i.a.a.e.n.a.a(this.f73277g, this.f73278h);
            if (a2 == null) {
                RLog.error("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            IYYPayWayView b2 = this.f73271a.b(activity, bVar);
            b2.refreshView();
            AbsViewEventHandler absViewEventHandler = bVar != null ? bVar.f74194e : null;
            s(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            RLog.info("YYPayDialogController", "showPayWayDialog");
            Dialog c2 = i.a.a.e.o.d.e.f73410b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), b2.getContentView(), new d(this, a2, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            b2.setCallback(new C2084e(this, activity, c2, b2, bVar, iPayCallback, absViewEventHandler));
            f fVar = new f(this, activity, bVar, c2, b2, iPayCallback);
            this.f73273c = fVar;
            a2.addPayListener(fVar);
            RLog.debug("YYPayDialogController", "showPayWayDialog addPayListener");
        }
    }

    public i.a.a.e.l.a p(int i2) {
        InterceptResult invokeI;
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.cid = 0;
            productInfo.productId = "";
            productInfo.srcCurrencySymbol = "";
            productInfo.srcAmount = Double.valueOf(i2 / 100.0d);
            PayUIKitConfig payUIKitConfig = this.f73272b;
            if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null && middleRevenueConfig.getCurrencyType() == 4) {
                productInfo.destAmount = i2;
                return new i.a.a.e.l.a(productInfo, 4);
            }
            productInfo.destAmount = i2;
            return new i.a.a.e.l.a(productInfo);
        }
        return (i.a.a.e.l.a) invokeI.objValue;
    }

    public final void q(int i2, String str, PayCallBackBean payCallBackBean) {
        i.a.a.e.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, payCallBackBean) == null) || (cVar = this.f73274d) == null) {
            return;
        }
        cVar.notifyYYPayFailListener(i2, str, payCallBackBean);
    }

    public final void r(CancelType cancelType, AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cancelType, absViewEventHandler) == null) {
            RLog.info("YYPayDialogController", "notifyViewFlowClose");
            if (absViewEventHandler == null) {
                RLog.info("YYPayDialogController", "notifyViewFlowClose listener null");
            } else if (cancelType == CancelType.BUTTOM_AREA_CLICK || cancelType == CancelType.EMPTY_AREA_CLICK || cancelType == CancelType.ON_DIALOG_CANCEL || cancelType == CancelType.ON_START_SHOW_FAIL) {
                s(absViewEventHandler, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    public final void s(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, absViewEventHandler, payDialogType) == null) {
            if (absViewEventHandler != null && payDialogType != null) {
                RLog.info("YYPayDialogController", "notifyViewStateChange payDialogType:" + payDialogType.name());
                absViewEventHandler.onViewStateChange(payDialogType);
                return;
            }
            RLog.info("YYPayDialogController", "notifyViewStateChange null");
        }
    }

    public final void t(Dialog dialog, IYYPayWayView iYYPayWayView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, dialog, iYYPayWayView, z) == null) {
            IYYPayWayView.PayViewState payViewState = z ? IYYPayWayView.PayViewState.WAITING_VIEW_STATE : IYYPayWayView.PayViewState.SELECTING_VIEW_STATE;
            if (iYYPayWayView != null) {
                iYYPayWayView.setViewState(payViewState);
            }
            if (z) {
                i.a.a.e.o.d.e.f73410b.d(dialog);
            } else {
                i.a.a.e.o.d.e.f73410b.b(dialog);
            }
        }
    }

    public final void u(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{activity, cVar, aVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info("YYPayDialogController", " requestPayInternal mOnPayRequest:" + this.f73276f);
            if (this.f73276f) {
                RLog.info("YYPayDialogController", " requestPayInternal but OnPayRequest now");
                return;
            }
            g gVar = new g(this, iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar);
            this.f73275e = TraceIdUtil.newTraceId();
            this.f73276f = true;
            RLog.info("YYPayDialogController", " requestPayInternal new mTraceId:" + this.f73275e + " mOnPayRequest:" + this.f73276f);
            this.f73271a.a(activity, cVar, aVar, appCustomExpand, gVar, this.f73275e);
        }
    }

    public final void v(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, list, viewParams, iPayCallback) == null) {
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            s(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            RLog.info("YYPayDialogController", "showInputDialog");
            i.a.a.e.o.d.d.f73379a.f(activity, new c(this, absViewEventHandler, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f73272b);
        }
    }

    public void w(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, iPayCallback, viewParams) == null) {
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            if (!NetworkUtil.isNetworkStrictlyAvailable(activity)) {
                Toast.makeText(activity, "网络不给力，请稍后重试", 1).show();
                RLog.error("YYPayDialogController", "showPayAmountDialog fail: network error", new Object[0]);
                r(CancelType.ON_START_SHOW_FAIL, absViewEventHandler);
            } else if (viewParams != null && (i2 = viewParams.targetAmount) > 0) {
                if (i2 > 5.0E7d) {
                    viewParams.targetAmount = CacheEngine.MAX_DISK_CACHE;
                }
                z(activity, p(viewParams.targetAmount), null, viewParams, iPayCallback);
                RLog.info("YYPayDialogController", "showPayAmountDialog targetAmount:" + viewParams.targetAmount);
            } else {
                IYYPayAmountView i3 = this.f73271a.i(activity, viewParams);
                i3.refreshView();
                String string = activity.getString(i.a.a.e.f.pay_ui_dialog_title);
                if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                    string = viewParams.payAmountDialogTitle;
                }
                RLog.info("YYPayDialogController", "showPayAmountDialog");
                s(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
                i3.setCallback(new b(this, i.a.a.e.o.d.e.f73410b.c(activity, string, i3.getContentView(), new a(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG), activity, viewParams, iPayCallback, absViewEventHandler));
            }
        }
    }

    public final void x(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (!i.a.a.e.n.e.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod) && !PayType.MOCK_TEST_PAY.getChannel().equals(currencyChargeMessage.payChannel)) {
                i.a.a.e.n.h.f73352a.b(dialog);
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                cVar.f74188a = bVar;
                cVar.f74189b = bVar2.f74194e;
                PaySource paySource = bVar2.f74195f;
                y(activity, cVar);
                return;
            }
            t(dialog, iYYPayWayView, false);
        }
    }

    public final void y(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, activity, cVar) == null) {
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f74189b : null;
            s(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            IYYPayResultView c2 = this.f73271a.c(activity, cVar);
            RLog.info("YYPayDialogController", "showPayResultDialog");
            c2.setCallback(new i(this, i.a.a.e.o.d.e.f73410b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), c2.getContentView(), new h(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG), absViewEventHandler));
        }
    }

    public void z(Activity activity, i.a.a.e.l.a aVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048587, this, activity, aVar, list, viewParams, iPayCallback) == null) {
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f74191b = aVar;
            bVar.f74190a = list;
            if (viewParams != null) {
                bVar.f74192c = viewParams.appCustomExpand;
                bVar.f74193d = viewParams.closeOnSuccess;
                bVar.f74194e = viewParams.viewEventListener;
            }
            A(activity, bVar, iPayCallback);
        }
    }
}
