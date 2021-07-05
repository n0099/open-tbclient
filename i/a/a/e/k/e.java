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
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.b f75783a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f75784b;

    /* renamed from: c  reason: collision with root package name */
    public AppPayServiceListener f75785c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.k.c f75786d;

    /* renamed from: e  reason: collision with root package name */
    public String f75787e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f75788f;

    /* renamed from: g  reason: collision with root package name */
    public int f75789g;

    /* renamed from: h  reason: collision with root package name */
    public int f75790h;

    /* loaded from: classes10.dex */
    public class a implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f75791a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f75792b;

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
            this.f75792b = eVar;
            this.f75791a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayAmountDialog");
                this.f75792b.r(cancelType, this.f75791a);
                i.a.a.e.k.f.a(this.f75792b.f75789g, this.f75792b.f75790h, cancelType);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements IYYPayAmountView.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f75793a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f75794b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f75795c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f75796d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f75797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f75798f;

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
            this.f75798f = eVar;
            this.f75793a = dialog;
            this.f75794b = activity;
            this.f75795c = viewParams;
            this.f75796d = iPayCallback;
            this.f75797e = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RLog.error("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
                i.a.a.e.n.h.f75864a.b(this.f75793a);
                this.f75798f.s(this.f75797e, PayDialogType.PAY_NONE_DIALOG);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
                RLog.info("YYPayDialogController", "showInputNumberDialog");
                i.a.a.e.n.h.f75864a.b(this.f75793a);
                this.f75798f.v(activity, list, this.f75795c, this.f75796d);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(i.a.a.e.l.a aVar, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, list) == null) {
                RLog.info("YYPayDialogController", "toPayWayDialog");
                i.a.a.e.n.h.f75864a.b(this.f75793a);
                this.f75798f.z(this.f75794b, aVar, list, this.f75795c, this.f75796d);
                i.a.a.e.m.a.b(this.f75798f.f75789g, this.f75798f.f75790h, UiEventType.purchasegotopay);
                RLog.warn("YYPayDialogController", UiEventType.purchasegotopay);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements i.a.a.e.o.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f75799a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f75800b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f75801c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f75802d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f75803e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f75804f;

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
            this.f75804f = eVar;
            this.f75799a = absViewEventHandler;
            this.f75800b = activity;
            this.f75801c = list;
            this.f75802d = viewParams;
            this.f75803e = iPayCallback;
        }

        @Override // i.a.a.e.o.d.c
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissInputDialog");
                this.f75804f.r(cancelType, this.f75799a);
            }
        }

        @Override // i.a.a.e.o.d.c
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                i.a.a.e.l.a p = this.f75804f.p((int) (i2 * 100.0d));
                RLog.info("YYPayDialogController", "showPayWayDialog: mPayAmountCustom:%s", p);
                this.f75804f.z(this.f75800b, p, this.f75801c, this.f75802d, this.f75803e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f75805a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f75806b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f75807c;

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
            this.f75807c = eVar;
            this.f75805a = iAppPayService;
            this.f75806b = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "on payWayDialog cancel");
                if (this.f75807c.f75785c != null) {
                    RLog.debug("YYPayDialogController", "showPayWayDialog removePayListener");
                    this.f75805a.removePayListener(this.f75807c.f75785c);
                    this.f75807c.f75785c = null;
                    this.f75807c.f75787e = null;
                }
                this.f75807c.r(cancelType, this.f75806b);
                i.a.a.e.k.f.b(this.f75807c.f75789g, this.f75807c.f75790h, cancelType);
                RLog.info("YYPayDialogController", "dismissPayWayDialog");
            }
        }
    }

    /* renamed from: i.a.a.e.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C2117e implements IYYPayWayView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f75808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f75809b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f75810c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f75811d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f75812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f75813f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f75814g;

        public C2117e(e eVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
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
            this.f75814g = eVar;
            this.f75808a = activity;
            this.f75809b = dialog;
            this.f75810c = iYYPayWayView;
            this.f75811d = bVar;
            this.f75812e = iPayCallback;
            this.f75813f = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, aVar, appCustomExpand) == null) {
                this.f75814g.u(this.f75808a, cVar, aVar, this.f75809b, this.f75810c, appCustomExpand, this.f75811d, this.f75812e);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                Dialog dialog = this.f75809b;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.f75814g.s(this.f75813f, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f75815a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f75816b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f75817c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f75818d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f75819e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f75820f;

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
            this.f75820f = eVar;
            this.f75815a = activity;
            this.f75816b = bVar;
            this.f75817c = dialog;
            this.f75818d = iYYPayWayView;
            this.f75819e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                super.onCurrencyChargeMessage(currencyChargeMessage);
                String traceid = currencyChargeMessage.reqParams.getTraceid();
                RLog.info("YYPayDialogController", "onCurrencyChargeMessage messgaeTraceId:" + traceid + " message:" + currencyChargeMessage.toString());
                if (!traceid.equals(this.f75820f.f75787e)) {
                    RLog.warn("YYPayDialogController", "messgaeTraceId not equal mTraceId");
                    return;
                }
                boolean z = false;
                boolean z2 = currencyChargeMessage.status == 1;
                if (i.a.a.e.n.h.f75864a.a(this.f75815a)) {
                    IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                    IYYPayWayView.b bVar2 = this.f75816b;
                    z = (z2 && (bVar2 != null && bVar2.f76703d)) ? true : true;
                    currencyChargeMessage.payMethod = currencyChargeMessage.reqParams.getPayMethod();
                    if (z) {
                        this.f75820f.x(this.f75815a, currencyChargeMessage, this.f75817c, bVar, this.f75818d, this.f75816b);
                    } else {
                        i.a.a.e.n.h.f75864a.b(this.f75817c);
                    }
                }
                IPayCallback iPayCallback = this.f75819e;
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
                    IYYPayWayView.b bVar3 = this.f75816b;
                    i.a.a.e.m.a.d(this.f75820f.f75789g, currencyChargeMessage.usedChannel, (bVar3 == null || bVar3.f76705f != PaySource.WALLET) ? "7" : "14", payChannel, payMethod, String.valueOf(cid));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements IPayCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f75821a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f75822b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f75823c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f75824d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.l.c f75825e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f75826f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f75827g;

        /* loaded from: classes10.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f75828e;

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
                this.f75828e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f75828e;
                    gVar.f75827g.t(gVar.f75823c, gVar.f75824d, true);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f75829e;

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
                this.f75829e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f75829e;
                    gVar.f75827g.t(gVar.f75823c, gVar.f75824d, false);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f75830e;

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
                this.f75830e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!i.a.a.e.n.e.a(this.f75830e.f75825e.f75855a) && !PayType.MOCK_TEST_PAY.getChannel().equals(this.f75830e.f75825e.f75855a.getChannel())) {
                        g gVar = this.f75830e;
                        gVar.f75827g.t(gVar.f75823c, gVar.f75824d, true);
                        return;
                    }
                    RLog.info("YYPayDialogController", "requestPayInternal onSuccess h5 not loadding");
                }
            }
        }

        /* loaded from: classes10.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f75831e;

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
                this.f75831e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f75831e;
                    gVar.f75827g.t(gVar.f75823c, gVar.f75824d, false);
                }
            }
        }

        /* renamed from: i.a.a.e.k.e$g$e  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2118e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f75832e;

            public RunnableC2118e(g gVar) {
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
                this.f75832e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    cVar.f76698a = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    IYYPayWayView.b bVar = this.f75832e.f75826f;
                    if (bVar != null) {
                        cVar.f76699b = bVar.f76704e;
                        PaySource paySource = bVar.f76705f;
                    }
                    g gVar = this.f75832e;
                    gVar.f75827g.y(gVar.f75822b, cVar);
                    i.a.a.e.n.h.f75864a.b(this.f75832e.f75823c);
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
            this.f75827g = eVar;
            this.f75821a = iPayCallback;
            this.f75822b = activity;
            this.f75823c = dialog;
            this.f75824d = iYYPayWayView;
            this.f75825e = cVar;
            this.f75826f = bVar;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
                this.f75827g.f75788f = false;
                IPayCallback iPayCallback = this.f75821a;
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, str, payCallBackBean);
                }
                this.f75827g.q(i2, str, payCallBackBean);
                if (i.a.a.e.n.h.f75864a.a(this.f75822b)) {
                    if (i2 == PayStatus.CANCEL.getCode()) {
                        RLog.info("YYPayDialogController", "取消支付 code:" + i2);
                        this.f75822b.runOnUiThread(new d(this));
                        return;
                    }
                    this.f75822b.runOnUiThread(new RunnableC2118e(this));
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onPayStart");
                IPayCallback iPayCallback = this.f75821a;
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
                IPayCallback iPayCallback = this.f75821a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
                if (i.a.a.e.n.h.f75864a.a(this.f75822b)) {
                    if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                        this.f75822b.runOnUiThread(new a(this));
                    } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                    } else {
                        this.f75822b.runOnUiThread(new b(this));
                    }
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onSuccess");
                this.f75827g.f75788f = false;
                if (i.a.a.e.n.h.f75864a.a(this.f75822b)) {
                    this.f75822b.runOnUiThread(new c(this));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h implements i.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f75833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f75834b;

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
            this.f75834b = eVar;
            this.f75833a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayResultDialog");
                this.f75834b.r(cancelType, this.f75833a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class i implements IYYPayResultView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f75835a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f75836b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f75837c;

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
            this.f75837c = eVar;
            this.f75835a = dialog;
            this.f75836b = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Dialog dialog = this.f75835a;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.f75837c.s(this.f75836b, PayDialogType.PAY_NONE_DIALOG);
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
        this.f75788f = false;
        this.f75789g = i2;
        this.f75790h = i3;
        this.f75786d = cVar;
        this.f75784b = cVar != null ? cVar.getPayUIKitConfig() : null;
        this.f75783a = bVar;
        RLog.info("YYPayDialogController", "new PayDialogController mOnPayRequest:" + this.f75788f);
    }

    public void A(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bVar, iPayCallback) == null) {
            IAppPayService a2 = i.a.a.e.n.a.a(this.f75789g, this.f75790h);
            if (a2 == null) {
                RLog.error("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            IYYPayWayView b2 = this.f75783a.b(activity, bVar);
            b2.refreshView();
            AbsViewEventHandler absViewEventHandler = bVar != null ? bVar.f76704e : null;
            s(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            RLog.info("YYPayDialogController", "showPayWayDialog");
            Dialog c2 = i.a.a.e.o.d.e.f75922b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), b2.getContentView(), new d(this, a2, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            b2.setCallback(new C2117e(this, activity, c2, b2, bVar, iPayCallback, absViewEventHandler));
            f fVar = new f(this, activity, bVar, c2, b2, iPayCallback);
            this.f75785c = fVar;
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
            PayUIKitConfig payUIKitConfig = this.f75784b;
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
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, payCallBackBean) == null) || (cVar = this.f75786d) == null) {
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
                i.a.a.e.o.d.e.f75922b.d(dialog);
            } else {
                i.a.a.e.o.d.e.f75922b.b(dialog);
            }
        }
    }

    public final void u(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{activity, cVar, aVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info("YYPayDialogController", " requestPayInternal mOnPayRequest:" + this.f75788f);
            if (this.f75788f) {
                RLog.info("YYPayDialogController", " requestPayInternal but OnPayRequest now");
                return;
            }
            g gVar = new g(this, iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar);
            this.f75787e = TraceIdUtil.newTraceId();
            this.f75788f = true;
            RLog.info("YYPayDialogController", " requestPayInternal new mTraceId:" + this.f75787e + " mOnPayRequest:" + this.f75788f);
            this.f75783a.a(activity, cVar, aVar, appCustomExpand, gVar, this.f75787e);
        }
    }

    public final void v(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, list, viewParams, iPayCallback) == null) {
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            s(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            RLog.info("YYPayDialogController", "showInputDialog");
            i.a.a.e.o.d.d.f75891a.f(activity, new c(this, absViewEventHandler, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f75784b);
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
                IYYPayAmountView i3 = this.f75783a.i(activity, viewParams);
                i3.refreshView();
                String string = activity.getString(i.a.a.e.f.pay_ui_dialog_title);
                if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                    string = viewParams.payAmountDialogTitle;
                }
                RLog.info("YYPayDialogController", "showPayAmountDialog");
                s(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
                i3.setCallback(new b(this, i.a.a.e.o.d.e.f75922b.c(activity, string, i3.getContentView(), new a(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG), activity, viewParams, iPayCallback, absViewEventHandler));
            }
        }
    }

    public final void x(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (!i.a.a.e.n.e.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod) && !PayType.MOCK_TEST_PAY.getChannel().equals(currencyChargeMessage.payChannel)) {
                i.a.a.e.n.h.f75864a.b(dialog);
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                cVar.f76698a = bVar;
                cVar.f76699b = bVar2.f76704e;
                PaySource paySource = bVar2.f76705f;
                y(activity, cVar);
                return;
            }
            t(dialog, iYYPayWayView, false);
        }
    }

    public final void y(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, activity, cVar) == null) {
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f76699b : null;
            s(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            IYYPayResultView c2 = this.f75783a.c(activity, cVar);
            RLog.info("YYPayDialogController", "showPayResultDialog");
            c2.setCallback(new i(this, i.a.a.e.o.d.e.f75922b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), c2.getContentView(), new h(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG), absViewEventHandler));
        }
    }

    public void z(Activity activity, i.a.a.e.l.a aVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048587, this, activity, aVar, list, viewParams, iPayCallback) == null) {
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f76701b = aVar;
            bVar.f76700a = list;
            if (viewParams != null) {
                bVar.f76702c = viewParams.appCustomExpand;
                bVar.f76703d = viewParams.closeOnSuccess;
                bVar.f76704e = viewParams.viewEventListener;
            }
            A(activity, bVar, iPayCallback);
        }
    }
}
