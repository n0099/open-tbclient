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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.b f72817a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f72818b;

    /* renamed from: c  reason: collision with root package name */
    public AppPayServiceListener f72819c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.k.c f72820d;

    /* renamed from: e  reason: collision with root package name */
    public String f72821e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72822f;

    /* renamed from: g  reason: collision with root package name */
    public int f72823g;

    /* renamed from: h  reason: collision with root package name */
    public int f72824h;

    /* loaded from: classes8.dex */
    public class a implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72825a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f72826b;

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
            this.f72826b = eVar;
            this.f72825a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayAmountDialog");
                this.f72826b.r(cancelType, this.f72825a);
                i.a.a.e.k.f.a(this.f72826b.f72823g, this.f72826b.f72824h, cancelType);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IYYPayAmountView.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f72827a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72828b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f72829c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72830d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f72832f;

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
            this.f72832f = eVar;
            this.f72827a = dialog;
            this.f72828b = activity;
            this.f72829c = viewParams;
            this.f72830d = iPayCallback;
            this.f72831e = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RLog.error("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
                i.a.a.e.n.h.f72898a.b(this.f72827a);
                this.f72832f.s(this.f72831e, PayDialogType.PAY_NONE_DIALOG);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
                RLog.info("YYPayDialogController", "showInputNumberDialog");
                i.a.a.e.n.h.f72898a.b(this.f72827a);
                this.f72832f.v(activity, list, this.f72829c, this.f72830d);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(i.a.a.e.l.a aVar, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, list) == null) {
                RLog.info("YYPayDialogController", "toPayWayDialog");
                i.a.a.e.n.h.f72898a.b(this.f72827a);
                this.f72832f.z(this.f72828b, aVar, list, this.f72829c, this.f72830d);
                i.a.a.e.m.a.b(this.f72832f.f72823g, this.f72832f.f72824h, UiEventType.purchasegotopay);
                RLog.warn("YYPayDialogController", UiEventType.purchasegotopay);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i.a.a.e.o.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72834b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f72835c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f72836d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f72838f;

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
            this.f72838f = eVar;
            this.f72833a = absViewEventHandler;
            this.f72834b = activity;
            this.f72835c = list;
            this.f72836d = viewParams;
            this.f72837e = iPayCallback;
        }

        @Override // i.a.a.e.o.d.c
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissInputDialog");
                this.f72838f.r(cancelType, this.f72833a);
            }
        }

        @Override // i.a.a.e.o.d.c
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                i.a.a.e.l.a p = this.f72838f.p((int) (i2 * 100.0d));
                RLog.info("YYPayDialogController", "showPayWayDialog: mPayAmountCustom:%s", p);
                this.f72838f.z(this.f72834b, p, this.f72835c, this.f72836d, this.f72837e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f72839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72840b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f72841c;

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
            this.f72841c = eVar;
            this.f72839a = iAppPayService;
            this.f72840b = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "on payWayDialog cancel");
                if (this.f72841c.f72819c != null) {
                    RLog.debug("YYPayDialogController", "showPayWayDialog removePayListener");
                    this.f72839a.removePayListener(this.f72841c.f72819c);
                    this.f72841c.f72819c = null;
                    this.f72841c.f72821e = null;
                }
                this.f72841c.r(cancelType, this.f72840b);
                i.a.a.e.k.f.b(this.f72841c.f72823g, this.f72841c.f72824h, cancelType);
                RLog.info("YYPayDialogController", "dismissPayWayDialog");
            }
        }
    }

    /* renamed from: i.a.a.e.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2085e implements IYYPayWayView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f72842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f72843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72844c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72845d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f72848g;

        public C2085e(e eVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
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
            this.f72848g = eVar;
            this.f72842a = activity;
            this.f72843b = dialog;
            this.f72844c = iYYPayWayView;
            this.f72845d = bVar;
            this.f72846e = iPayCallback;
            this.f72847f = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, aVar, appCustomExpand) == null) {
                this.f72848g.u(this.f72842a, cVar, aVar, this.f72843b, this.f72844c, appCustomExpand, this.f72845d, this.f72846e);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                Dialog dialog = this.f72843b;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.f72848g.s(this.f72847f, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f72849a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72850b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f72851c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72852d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f72854f;

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
            this.f72854f = eVar;
            this.f72849a = activity;
            this.f72850b = bVar;
            this.f72851c = dialog;
            this.f72852d = iYYPayWayView;
            this.f72853e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                super.onCurrencyChargeMessage(currencyChargeMessage);
                String traceid = currencyChargeMessage.reqParams.getTraceid();
                RLog.info("YYPayDialogController", "onCurrencyChargeMessage messgaeTraceId:" + traceid + " message:" + currencyChargeMessage.toString());
                if (!traceid.equals(this.f72854f.f72821e)) {
                    RLog.warn("YYPayDialogController", "messgaeTraceId not equal mTraceId");
                    return;
                }
                boolean z = false;
                boolean z2 = currencyChargeMessage.status == 1;
                if (i.a.a.e.n.h.f72898a.a(this.f72849a)) {
                    IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                    IYYPayWayView.b bVar2 = this.f72850b;
                    z = (z2 && (bVar2 != null && bVar2.f73737d)) ? true : true;
                    currencyChargeMessage.payMethod = currencyChargeMessage.reqParams.getPayMethod();
                    if (z) {
                        this.f72854f.x(this.f72849a, currencyChargeMessage, this.f72851c, bVar, this.f72852d, this.f72850b);
                    } else {
                        i.a.a.e.n.h.f72898a.b(this.f72851c);
                    }
                }
                IPayCallback iPayCallback = this.f72853e;
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
                    IYYPayWayView.b bVar3 = this.f72850b;
                    i.a.a.e.m.a.d(this.f72854f.f72823g, currencyChargeMessage.usedChannel, (bVar3 == null || bVar3.f73739f != PaySource.WALLET) ? "7" : "14", payChannel, payMethod, String.valueOf(cid));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements IPayCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72855a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72856b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f72857c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72858d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.l.c f72859e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72860f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f72861g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f72862e;

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
                this.f72862e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f72862e;
                    gVar.f72861g.t(gVar.f72857c, gVar.f72858d, true);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f72863e;

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
                this.f72863e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f72863e;
                    gVar.f72861g.t(gVar.f72857c, gVar.f72858d, false);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f72864e;

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
                this.f72864e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!i.a.a.e.n.e.a(this.f72864e.f72859e.f72889a) && !PayType.MOCK_TEST_PAY.getChannel().equals(this.f72864e.f72859e.f72889a.getChannel())) {
                        g gVar = this.f72864e;
                        gVar.f72861g.t(gVar.f72857c, gVar.f72858d, true);
                        return;
                    }
                    RLog.info("YYPayDialogController", "requestPayInternal onSuccess h5 not loadding");
                }
            }
        }

        /* loaded from: classes8.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f72865e;

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
                this.f72865e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f72865e;
                    gVar.f72861g.t(gVar.f72857c, gVar.f72858d, false);
                }
            }
        }

        /* renamed from: i.a.a.e.k.e$g$e  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC2086e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f72866e;

            public RunnableC2086e(g gVar) {
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
                this.f72866e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    cVar.f73732a = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    IYYPayWayView.b bVar = this.f72866e.f72860f;
                    if (bVar != null) {
                        cVar.f73733b = bVar.f73738e;
                        PaySource paySource = bVar.f73739f;
                    }
                    g gVar = this.f72866e;
                    gVar.f72861g.y(gVar.f72856b, cVar);
                    i.a.a.e.n.h.f72898a.b(this.f72866e.f72857c);
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
            this.f72861g = eVar;
            this.f72855a = iPayCallback;
            this.f72856b = activity;
            this.f72857c = dialog;
            this.f72858d = iYYPayWayView;
            this.f72859e = cVar;
            this.f72860f = bVar;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
                this.f72861g.f72822f = false;
                IPayCallback iPayCallback = this.f72855a;
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, str, payCallBackBean);
                }
                this.f72861g.q(i2, str, payCallBackBean);
                if (i.a.a.e.n.h.f72898a.a(this.f72856b)) {
                    if (i2 == PayStatus.CANCEL.getCode()) {
                        RLog.info("YYPayDialogController", "取消支付 code:" + i2);
                        this.f72856b.runOnUiThread(new d(this));
                        return;
                    }
                    this.f72856b.runOnUiThread(new RunnableC2086e(this));
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onPayStart");
                IPayCallback iPayCallback = this.f72855a;
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
                IPayCallback iPayCallback = this.f72855a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
                if (i.a.a.e.n.h.f72898a.a(this.f72856b)) {
                    if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                        this.f72856b.runOnUiThread(new a(this));
                    } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                    } else {
                        this.f72856b.runOnUiThread(new b(this));
                    }
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onSuccess");
                this.f72861g.f72822f = false;
                if (i.a.a.e.n.h.f72898a.a(this.f72856b)) {
                    this.f72856b.runOnUiThread(new c(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f72868b;

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
            this.f72868b = eVar;
            this.f72867a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayResultDialog");
                this.f72868b.r(cancelType, this.f72867a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements IYYPayResultView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f72869a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72870b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f72871c;

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
            this.f72871c = eVar;
            this.f72869a = dialog;
            this.f72870b = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Dialog dialog = this.f72869a;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.f72871c.s(this.f72870b, PayDialogType.PAY_NONE_DIALOG);
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
        this.f72822f = false;
        this.f72823g = i2;
        this.f72824h = i3;
        this.f72820d = cVar;
        this.f72818b = cVar != null ? cVar.getPayUIKitConfig() : null;
        this.f72817a = bVar;
        RLog.info("YYPayDialogController", "new PayDialogController mOnPayRequest:" + this.f72822f);
    }

    public void A(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bVar, iPayCallback) == null) {
            IAppPayService a2 = i.a.a.e.n.a.a(this.f72823g, this.f72824h);
            if (a2 == null) {
                RLog.error("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            IYYPayWayView b2 = this.f72817a.b(activity, bVar);
            b2.refreshView();
            AbsViewEventHandler absViewEventHandler = bVar != null ? bVar.f73738e : null;
            s(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            RLog.info("YYPayDialogController", "showPayWayDialog");
            Dialog c2 = i.a.a.e.o.d.e.f72956b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), b2.getContentView(), new d(this, a2, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            b2.setCallback(new C2085e(this, activity, c2, b2, bVar, iPayCallback, absViewEventHandler));
            f fVar = new f(this, activity, bVar, c2, b2, iPayCallback);
            this.f72819c = fVar;
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
            PayUIKitConfig payUIKitConfig = this.f72818b;
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
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, payCallBackBean) == null) || (cVar = this.f72820d) == null) {
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
                i.a.a.e.o.d.e.f72956b.d(dialog);
            } else {
                i.a.a.e.o.d.e.f72956b.b(dialog);
            }
        }
    }

    public final void u(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{activity, cVar, aVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info("YYPayDialogController", " requestPayInternal mOnPayRequest:" + this.f72822f);
            if (this.f72822f) {
                RLog.info("YYPayDialogController", " requestPayInternal but OnPayRequest now");
                return;
            }
            g gVar = new g(this, iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar);
            this.f72821e = TraceIdUtil.newTraceId();
            this.f72822f = true;
            RLog.info("YYPayDialogController", " requestPayInternal new mTraceId:" + this.f72821e + " mOnPayRequest:" + this.f72822f);
            this.f72817a.a(activity, cVar, aVar, appCustomExpand, gVar, this.f72821e);
        }
    }

    public final void v(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, list, viewParams, iPayCallback) == null) {
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            s(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            RLog.info("YYPayDialogController", "showInputDialog");
            i.a.a.e.o.d.d.f72925a.f(activity, new c(this, absViewEventHandler, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f72818b);
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
                IYYPayAmountView i3 = this.f72817a.i(activity, viewParams);
                i3.refreshView();
                String string = activity.getString(i.a.a.e.f.pay_ui_dialog_title);
                if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                    string = viewParams.payAmountDialogTitle;
                }
                RLog.info("YYPayDialogController", "showPayAmountDialog");
                s(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
                i3.setCallback(new b(this, i.a.a.e.o.d.e.f72956b.c(activity, string, i3.getContentView(), new a(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG), activity, viewParams, iPayCallback, absViewEventHandler));
            }
        }
    }

    public final void x(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (!i.a.a.e.n.e.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod) && !PayType.MOCK_TEST_PAY.getChannel().equals(currencyChargeMessage.payChannel)) {
                i.a.a.e.n.h.f72898a.b(dialog);
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                cVar.f73732a = bVar;
                cVar.f73733b = bVar2.f73738e;
                PaySource paySource = bVar2.f73739f;
                y(activity, cVar);
                return;
            }
            t(dialog, iYYPayWayView, false);
        }
    }

    public final void y(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, activity, cVar) == null) {
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f73733b : null;
            s(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            IYYPayResultView c2 = this.f72817a.c(activity, cVar);
            RLog.info("YYPayDialogController", "showPayResultDialog");
            c2.setCallback(new i(this, i.a.a.e.o.d.e.f72956b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), c2.getContentView(), new h(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG), absViewEventHandler));
        }
    }

    public void z(Activity activity, i.a.a.e.l.a aVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048587, this, activity, aVar, list, viewParams, iPayCallback) == null) {
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f73735b = aVar;
            bVar.f73734a = list;
            if (viewParams != null) {
                bVar.f73736c = viewParams.appCustomExpand;
                bVar.f73737d = viewParams.closeOnSuccess;
                bVar.f73738e = viewParams.viewEventListener;
            }
            A(activity, bVar, iPayCallback);
        }
    }
}
