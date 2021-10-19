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
    public j.a.a.e.k.c f79448a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f79449b;

    /* renamed from: c  reason: collision with root package name */
    public AppPayServiceListener f79450c;

    /* renamed from: d  reason: collision with root package name */
    public j.a.a.e.k.d f79451d;

    /* renamed from: e  reason: collision with root package name */
    public String f79452e;

    /* renamed from: f  reason: collision with root package name */
    public PayFlowType f79453f;

    /* renamed from: g  reason: collision with root package name */
    public int f79454g;

    /* renamed from: h  reason: collision with root package name */
    public int f79455h;

    /* loaded from: classes2.dex */
    public class a implements j.a.a.e.o.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79456a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f79457b;

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
            this.f79457b = fVar;
            this.f79456a = absViewEventHandler;
        }

        @Override // j.a.a.e.o.d.a
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayAmountDialog");
                this.f79457b.q(cancelType, this.f79456a);
                j.a.a.e.k.g.a(this.f79457b.f79454g, this.f79457b.f79455h, cancelType);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IYYPayAmountView.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f79458a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f79459b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f79460c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79461d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f79463f;

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
            this.f79463f = fVar;
            this.f79458a = dialog;
            this.f79459b = activity;
            this.f79460c = viewParams;
            this.f79461d = iPayCallback;
            this.f79462e = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RLog.error("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
                j.a.a.e.n.i.f79529a.b(this.f79458a);
                RLog.info("YYPayDialogController", "showPayAmountDialog onRefreshViewFail notifyViewStateChange");
                this.f79463f.r(this.f79462e, PayDialogType.PAY_NONE_DIALOG);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list) == null) {
                RLog.info("YYPayDialogController", "showInputNumberDialog");
                j.a.a.e.n.i.f79529a.b(this.f79458a);
                this.f79463f.v(activity, list, this.f79460c, this.f79461d);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(j.a.a.e.l.a aVar, List<PayWayInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, list) == null) {
                RLog.info("YYPayDialogController", "toPayWayDialog");
                j.a.a.e.n.i.f79529a.b(this.f79458a);
                this.f79463f.z(this.f79459b, aVar, list, this.f79460c, this.f79461d);
                j.a.a.e.m.a.b(this.f79463f.f79454g, this.f79463f.f79455h, UiEventType.purchasegotopay);
                RLog.warn("YYPayDialogController", UiEventType.purchasegotopay);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements j.a.a.e.o.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f79465b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f79466c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f79467d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79468e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f79469f;

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
            this.f79469f = fVar;
            this.f79464a = absViewEventHandler;
            this.f79465b = activity;
            this.f79466c = list;
            this.f79467d = viewParams;
            this.f79468e = iPayCallback;
        }

        @Override // j.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissInputDialog");
                this.f79469f.q(cancelType, this.f79464a);
            }
        }

        @Override // j.a.a.e.o.d.b
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                j.a.a.e.l.a o = this.f79469f.o((int) (i2 * 100.0d));
                RLog.info("YYPayDialogController", "showPayWayDialog: mPayAmountCustom:%s", o);
                this.f79469f.z(this.f79465b, o, this.f79466c, this.f79467d, this.f79468e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements j.a.a.e.o.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f79470a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79471b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f79472c;

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
            this.f79472c = fVar;
            this.f79470a = iAppPayService;
            this.f79471b = absViewEventHandler;
        }

        @Override // j.a.a.e.o.d.a
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "on payWayDialog cancel clickArea：" + cancelType.name());
                if (this.f79472c.f79450c != null) {
                    RLog.debug("YYPayDialogController", "showPayWayDialog removePayListener");
                    this.f79470a.removePayListener(this.f79472c.f79450c);
                    this.f79472c.f79450c = null;
                    this.f79472c.f79452e = null;
                }
                this.f79472c.q(cancelType, this.f79471b);
                j.a.a.e.k.g.b(this.f79472c.f79454g, this.f79472c.f79455h, cancelType);
                RLog.info("YYPayDialogController", "dismissPayWayDialog");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements IYYPayWayView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f79473a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f79474b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f79475c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f79476d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79478f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f79479g;

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
            this.f79479g = fVar;
            this.f79473a = activity;
            this.f79474b = dialog;
            this.f79475c = iYYPayWayView;
            this.f79476d = bVar;
            this.f79477e = iPayCallback;
            this.f79478f = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(j.a.a.e.l.c cVar, j.a.a.e.l.a aVar, AppCustomExpand appCustomExpand) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, aVar, appCustomExpand) == null) {
                this.f79479g.u(this.f79473a, cVar, aVar, this.f79474b, this.f79475c, appCustomExpand, this.f79476d, this.f79477e);
            }
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void onRefreshViewFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                Dialog dialog = this.f79474b;
                if (dialog != null) {
                    dialog.dismiss();
                }
                RLog.info("YYPayDialogController", "showPayWayDialog onRefreshViewFail notifyViewStateChange");
                this.f79479g.r(this.f79478f, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    /* renamed from: j.a.a.e.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2152f extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f79480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f79481b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f79482c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f79483d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f79485f;

        public C2152f(f fVar, Activity activity, IYYPayWayView.b bVar, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
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
            this.f79485f = fVar;
            this.f79480a = activity;
            this.f79481b = bVar;
            this.f79482c = dialog;
            this.f79483d = iYYPayWayView;
            this.f79484e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                super.onCurrencyChargeMessage(currencyChargeMessage);
                String traceid = currencyChargeMessage.reqParams.getTraceid();
                RLog.info("YYPayDialogController", "onCurrencyChargeMessage messgaeTraceId:" + traceid + " message:" + currencyChargeMessage.toString());
                if (!traceid.equals(this.f79485f.f79452e)) {
                    RLog.warn("YYPayDialogController", "messgaeTraceId not equal mTraceId");
                    return;
                }
                boolean z = false;
                boolean z2 = currencyChargeMessage.status == 1;
                if (j.a.a.e.n.i.f79529a.a(this.f79480a)) {
                    IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                    IYYPayWayView.b bVar2 = this.f79481b;
                    z = (z2 && (bVar2 != null && bVar2.f80298d)) ? true : true;
                    currencyChargeMessage.payMethod = currencyChargeMessage.reqParams.getPayMethod();
                    if (z) {
                        this.f79485f.x(this.f79480a, currencyChargeMessage, this.f79482c, bVar, this.f79483d, this.f79481b);
                    } else {
                        j.a.a.e.n.i.f79529a.b(this.f79482c);
                    }
                }
                IPayCallback iPayCallback = this.f79484e;
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
                    IYYPayWayView.b bVar3 = this.f79481b;
                    j.a.a.e.m.a.d(this.f79485f.f79454g, currencyChargeMessage.usedChannel, (bVar3 == null || bVar3.f80300f != PaySource.WALLET) ? "7" : "14", payChannel, payMethod, String.valueOf(cid));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements IPayCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f79486a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f79487b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f79488c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f79489d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.l.c f79490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f79491f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f79492g;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79493e;

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
                this.f79493e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f79493e;
                    gVar.f79492g.t(gVar.f79488c, gVar.f79489d, true);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79494e;

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
                this.f79494e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f79494e;
                    gVar.f79492g.t(gVar.f79488c, gVar.f79489d, false);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79495e;

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
                this.f79495e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!j.a.a.e.n.f.a(this.f79495e.f79490e.f79520a) && !PayType.UNION_PAY.getChannel().equals(this.f79495e.f79490e.f79520a.getChannel()) && !PayType.MOCK_TEST_PAY.getChannel().equals(this.f79495e.f79490e.f79520a.getChannel())) {
                        g gVar = this.f79495e;
                        gVar.f79492g.t(gVar.f79488c, gVar.f79489d, true);
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
            public final /* synthetic */ g f79496e;

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
                this.f79496e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.f79496e;
                    gVar.f79492g.t(gVar.f79488c, gVar.f79489d, false);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f79497e;

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
                this.f79497e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    cVar.f80293a = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    IYYPayWayView.b bVar = this.f79497e.f79491f;
                    if (bVar != null) {
                        cVar.f80294b = bVar.f80299e;
                        PaySource paySource = bVar.f80300f;
                    }
                    g gVar = this.f79497e;
                    gVar.f79492g.y(gVar.f79487b, cVar);
                    j.a.a.e.n.i.f79529a.b(this.f79497e.f79488c);
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
            this.f79492g = fVar;
            this.f79486a = iPayCallback;
            this.f79487b = activity;
            this.f79488c = dialog;
            this.f79489d = iYYPayWayView;
            this.f79490e = cVar;
            this.f79491f = bVar;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
                IPayCallback iPayCallback = this.f79486a;
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, str, payCallBackBean);
                }
                this.f79492g.p(i2, str, payCallBackBean);
                if (j.a.a.e.n.i.f79529a.a(this.f79487b)) {
                    if (i2 == PayStatus.CANCEL.getCode()) {
                        RLog.info("YYPayDialogController", "取消支付 code:" + i2);
                        this.f79487b.runOnUiThread(new d(this));
                        return;
                    }
                    this.f79487b.runOnUiThread(new e(this));
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onPayStart");
                IPayCallback iPayCallback = this.f79486a;
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
                IPayCallback iPayCallback = this.f79486a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
                if (j.a.a.e.n.i.f79529a.a(this.f79487b)) {
                    if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                        this.f79487b.runOnUiThread(new a(this));
                    } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                    } else {
                        this.f79487b.runOnUiThread(new b(this));
                    }
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
                RLog.info("YYPayDialogController", "requestPayInternal onSuccess");
                if (j.a.a.e.n.i.f79529a.a(this.f79487b)) {
                    this.f79487b.runOnUiThread(new c(this));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements j.a.a.e.o.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f79499b;

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
            this.f79499b = fVar;
            this.f79498a = absViewEventHandler;
        }

        @Override // j.a.a.e.o.d.a
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("YYPayDialogController", "dismissPayResultDialog");
                this.f79499b.q(cancelType, this.f79498a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements IYYPayResultView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f79500a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f79501b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f79502c;

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
            this.f79502c = fVar;
            this.f79500a = dialog;
            this.f79501b = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Dialog dialog = this.f79500a;
                if (dialog != null) {
                    dialog.dismiss();
                }
                RLog.info("YYPayDialogController", "onBtnConfirm onPayFlowFinish");
                this.f79502c.r(this.f79501b, PayDialogType.PAY_NONE_DIALOG);
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
        this.f79454g = i2;
        this.f79455h = i3;
        this.f79451d = dVar;
        this.f79449b = dVar != null ? dVar.getPayUIKitConfig() : null;
        this.f79448a = cVar;
        this.f79453f = payFlowType;
        RLog.info("YYPayDialogController", "new PayDialogController");
    }

    public void A(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bVar, iPayCallback) == null) {
            IAppPayService a2 = j.a.a.e.n.b.a(this.f79454g, this.f79455h);
            if (a2 == null) {
                RLog.error("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            IYYPayWayView b2 = this.f79448a.b(activity, bVar);
            b2.refreshView();
            AbsViewEventHandler absViewEventHandler = bVar != null ? bVar.f80299e : null;
            r(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            RLog.info("YYPayDialogController", "showPayWayDialog");
            Dialog c2 = j.a.a.e.o.d.d.f79586b.c(activity, activity.getString(j.a.a.e.f.pay_ui_dialog_pay_title), b2.getContentView(), new d(this, a2, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            b2.setCallback(new e(this, activity, c2, b2, bVar, iPayCallback, absViewEventHandler));
            C2152f c2152f = new C2152f(this, activity, bVar, c2, b2, iPayCallback);
            this.f79450c = c2152f;
            a2.addPayListener(c2152f);
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
            PayUIKitConfig payUIKitConfig = this.f79449b;
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
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, payCallBackBean) == null) || (dVar = this.f79451d) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f79451d == null) {
            return;
        }
        RLog.info("YYPayDialogController", "onPayFlowFinish");
        PayFlowType payFlowType = PayFlowType.DIOALOG_PAY_FLOW;
        if (payFlowType == this.f79453f) {
            this.f79451d.onPayFlowFinish(payFlowType);
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
                j.a.a.e.o.d.d.f79586b.d(dialog);
            } else {
                j.a.a.e.o.d.d.f79586b.b(dialog);
            }
        }
    }

    public final void u(Activity activity, j.a.a.e.l.c cVar, j.a.a.e.l.a aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{activity, cVar, aVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info("YYPayDialogController", " requestPayInternal");
            g gVar = new g(this, iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar);
            this.f79452e = TraceIdUtil.newTraceId();
            RLog.info("YYPayDialogController", " requestPayInternal new mTraceId:" + this.f79452e);
            this.f79448a.a(activity, cVar, aVar, appCustomExpand, gVar, this.f79452e);
        }
    }

    public final void v(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, list, viewParams, iPayCallback) == null) {
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            r(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            RLog.info("YYPayDialogController", "showInputDialog");
            j.a.a.e.o.d.c.f79555a.f(activity, new c(this, absViewEventHandler, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f79449b);
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
                IYYPayAmountView i3 = this.f79448a.i(activity, viewParams);
                i3.refreshView();
                String string = activity.getString(j.a.a.e.f.pay_ui_dialog_title);
                if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                    string = viewParams.payAmountDialogTitle;
                }
                RLog.info("YYPayDialogController", "showPayAmountDialog");
                r(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
                i3.setCallback(new b(this, j.a.a.e.o.d.d.f79586b.c(activity, string, i3.getContentView(), new a(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG), activity, viewParams, iPayCallback, absViewEventHandler));
            }
        }
    }

    public final void x(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (!j.a.a.e.n.f.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod) && !PayType.MOCK_TEST_PAY.getChannel().equals(currencyChargeMessage.payChannel) && !PayType.UNION_PAY.getChannel().equals(currencyChargeMessage.payChannel)) {
                j.a.a.e.n.i.f79529a.b(dialog);
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                cVar.f80293a = bVar;
                cVar.f80294b = bVar2.f80299e;
                PaySource paySource = bVar2.f80300f;
                y(activity, cVar);
                return;
            }
            t(dialog, iYYPayWayView, false);
        }
    }

    public final void y(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, activity, cVar) == null) {
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f80294b : null;
            r(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            IYYPayResultView c2 = this.f79448a.c(activity, cVar);
            RLog.info("YYPayDialogController", "showPayResultDialog");
            c2.setCallback(new i(this, j.a.a.e.o.d.d.f79586b.c(activity, activity.getString(j.a.a.e.f.pay_ui_dialog_pay_title), c2.getContentView(), new h(this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG), absViewEventHandler));
        }
    }

    public void z(Activity activity, j.a.a.e.l.a aVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048588, this, activity, aVar, list, viewParams, iPayCallback) == null) {
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f80296b = aVar;
            bVar.f80295a = list;
            if (viewParams != null) {
                bVar.f80297c = viewParams.appCustomExpand;
                bVar.f80298d = viewParams.closeOnSuccess;
                bVar.f80299e = viewParams.viewEventListener;
            }
            A(activity, bVar, iPayCallback);
        }
    }
}
