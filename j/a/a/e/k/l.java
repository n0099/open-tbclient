package j.a.a.e.k;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes3.dex */
public class l implements j.a.a.e.k.c, j.a.a.e.k.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayUIKitConfig a;

    /* renamed from: b  reason: collision with root package name */
    public AppPayServiceListener f64103b;

    /* renamed from: c  reason: collision with root package name */
    public h f64104c;

    /* renamed from: d  reason: collision with root package name */
    public String f64105d;

    /* renamed from: e  reason: collision with root package name */
    public j.a.a.e.k.b f64106e;

    /* renamed from: f  reason: collision with root package name */
    public j.a.a.e.k.f f64107f;

    /* renamed from: g  reason: collision with root package name */
    public int f64108g;

    /* renamed from: h  reason: collision with root package name */
    public int f64109h;

    /* renamed from: i  reason: collision with root package name */
    public PayFlowType f64110i;

    /* renamed from: j  reason: collision with root package name */
    public i f64111j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f64112k;

    /* loaded from: classes3.dex */
    public class a extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f64113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64114c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f64115d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f64116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f64117f;

        public a(l lVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, activity, dialog, iYYPayWayView, bVar, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64117f = lVar;
            this.a = activity;
            this.f64113b = dialog;
            this.f64114c = iYYPayWayView;
            this.f64115d = bVar;
            this.f64116e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                this.f64117f.v(currencyChargeMessage, this.a, this.f64113b, this.f64114c, this.f64115d, this.f64116e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64119f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64120g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ l f64121h;

        public b(l lVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64121h = lVar;
            this.f64118e = activity;
            this.f64119f = dialog;
            this.f64120g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.a.a.e.n.n.a.a(this.f64118e)) {
                this.f64121h.x(this.f64119f, this.f64120g, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f64123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64124g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f64125h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Dialog f64126i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ l f64127j;

        public c(l lVar, Activity activity, int i2, String str, IYYPayWayView.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, activity, Integer.valueOf(i2), str, bVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64127j = lVar;
            this.f64122e = activity;
            this.f64123f = i2;
            this.f64124g = str;
            this.f64125h = bVar;
            this.f64126i = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64127j.f64111j.f(null);
                if (j.a.a.e.n.n.a.a(this.f64122e)) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    IYYPayResultView.b bVar = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    cVar.a = bVar;
                    bVar.a(this.f64123f);
                    cVar.a.b(this.f64124g);
                    IYYPayWayView.b bVar2 = this.f64125h;
                    if (bVar2 != null) {
                        cVar.f64812b = bVar2.f64816e;
                    }
                    this.f64127j.B(this.f64122e, cVar);
                    j.a.a.e.n.h.a(this.f64126i, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64128e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.l.f f64129f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Dialog f64130g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64131h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ l f64132i;

        public d(l lVar, Activity activity, j.a.a.e.l.f fVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, activity, fVar, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64132i = lVar;
            this.f64128e = activity;
            this.f64129f = fVar;
            this.f64130g = dialog;
            this.f64131h = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64132i.f64111j.f(null);
                if (j.a.a.e.n.n.a.a(this.f64128e)) {
                    PayType payType = this.f64129f.a;
                    if (payType == null) {
                        RLog.error("PayFlowController", "updateViewOnPaySuccess error payType null", new Object[0]);
                    } else if (!j.a.a.e.n.j.b(payType.getChannel(), this.f64129f.a.getMethod())) {
                        this.f64132i.x(this.f64130g, this.f64131h, true);
                    } else {
                        RLog.info("PayFlowController", "updateViewOnPaySuccess but h5 not loadding");
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64134f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64135g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ l f64136h;

        public e(l lVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64136h = lVar;
            this.f64133e = activity;
            this.f64134f = dialog;
            this.f64135g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.a.a.e.n.n.a.a(this.f64133e)) {
                this.f64136h.x(this.f64134f, this.f64135g, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ l f64140h;

        public f(l lVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64140h = lVar;
            this.f64137e = activity;
            this.f64138f = dialog;
            this.f64139g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.a.a.e.n.n.a.a(this.f64137e)) {
                this.f64140h.x(this.f64138f, this.f64139g, false);
            }
        }
    }

    public l(int i2, int i3, h hVar, j.a.a.e.k.f fVar, j.a.a.e.k.b bVar, i iVar, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), hVar, fVar, bVar, iVar, payFlowType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64112k = new Handler(Looper.getMainLooper());
        this.f64108g = i2;
        this.f64109h = i3;
        this.f64104c = hVar;
        this.a = hVar != null ? hVar.getPayUIKitConfig() : null;
        this.f64107f = fVar;
        this.f64106e = bVar;
        this.f64111j = iVar;
        this.f64110i = payFlowType;
        RLog.info("PayFlowController", "create PayFlowController: " + this + " mPayFlowType:" + this.f64110i.name());
    }

    public void A(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, iPayCallback, viewParams) == null) {
            RLog.info("PayFlowController", "showPayAmountDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            if (p(activity, absViewEventHandler) && !u(activity, iPayCallback, viewParams)) {
                IYYPayAmountView f2 = this.f64107f.f(activity, viewParams);
                f2.refreshView();
                f2.setCallback(new j.a.a.e.k.o.c(this.f64108g, this.f64109h, r(activity, f2, absViewEventHandler, viewParams), viewParams, activity, iPayCallback, this));
            }
        }
    }

    public void B(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, cVar) == null) {
            RLog.info("PayFlowController", "showPayResultDialog");
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f64812b : null;
            IYYPayResultView c2 = this.f64107f.c(activity, cVar);
            c2.setCallback(new j.a.a.e.k.o.h(activity, c2, absViewEventHandler, s(activity, cVar, c2), this));
        }
    }

    public final void C(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (j.a.a.e.n.j.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod)) {
                x(dialog, iYYPayWayView, false);
                return;
            }
            j.a.a.e.n.h.a(dialog, PayDialogType.PAY_WAY_DIALOG);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.a = bVar;
            cVar.f64812b = bVar2.f64816e;
            B(activity, cVar);
        }
    }

    public void D(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, bVar, iPayCallback) == null) {
            IAppPayService b2 = j.a.a.e.n.b.b(this.f64108g, this.f64109h);
            if (b2 == null) {
                RLog.error("PayFlowController", "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            bVar.f64817f = this.f64110i;
            IYYPayWayView b3 = this.f64107f.b(activity, bVar);
            b3.refreshView();
            Dialog t = t(activity, b3, b2, bVar != null ? bVar.f64816e : null);
            IYYPayWayView.b bVar2 = bVar;
            b3.setCallback(new j.a.a.e.k.o.j(activity, t, b3, bVar2, iPayCallback, this));
            y(activity, t, b3, bVar2, iPayCallback);
            RLog.debug("PayFlowController", "showPayWayDialog addPayListener");
        }
    }

    public final void E(CurrencyChargeMessage currencyChargeMessage, IYYPayWayView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, currencyChargeMessage, bVar) == null) {
            if (!(currencyChargeMessage.status == 1)) {
                RLog.info("PayFlowController", "statisticOnCurrencyChargeMessage but pay fail status:" + currencyChargeMessage.status);
                return;
            }
            int i2 = currencyChargeMessage.cid;
            String str = currencyChargeMessage.payChannel;
            String str2 = currencyChargeMessage.payMethod;
            j.a.a.e.m.b.d(this.f64108g, currencyChargeMessage.usedChannel, this.f64110i == PayFlowType.ACTIVITY_PAY_FLOW ? "14" : "7", str, str2, String.valueOf(i2));
            RLog.info("PayFlowController", "statisticOnCurrencyChargeMessage payChannel:" + str + " payMethod:" + str2);
        }
    }

    public void F(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, dialog, iYYPayWayView, bVar, currencyChargeMessage) == null) {
            boolean z = false;
            boolean z2 = currencyChargeMessage.status == 1;
            if (j.a.a.e.n.n.a.a(activity)) {
                IYYPayResultView.b bVar2 = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                if ((z2 && (bVar != null && bVar.f64815d)) ? true : true) {
                    C(activity, currencyChargeMessage, dialog, bVar2, iYYPayWayView, bVar);
                } else {
                    j.a.a.e.n.h.b(dialog, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    @Override // j.a.a.e.k.c
    public void a(int i2, String str, PayCallBackBean payCallBackBean) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048582, this, i2, str, payCallBackBean) == null) || (hVar = this.f64104c) == null) {
            return;
        }
        hVar.notifyYYPayFailListener(i2, str, payCallBackBean);
    }

    @Override // j.a.a.e.k.c
    public void b(CancelType cancelType, AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cancelType, absViewEventHandler) == null) {
            RLog.info("PayFlowController", "checkNotifyViewFlowClose clickArea:" + cancelType.name());
            if (cancelType == CancelType.BUTTOM_AREA_CLICK || cancelType == CancelType.EMPTY_AREA_CLICK || cancelType == CancelType.ON_DIALOG_CANCEL || cancelType == CancelType.ON_START_SHOW_FAIL) {
                RLog.info("PayFlowController", "checkNotifyViewFlowClose call notifyPayFlowChange");
                f(absViewEventHandler, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    @Override // j.a.a.e.k.c
    public void c(Activity activity, j.a.a.e.l.f fVar, j.a.a.e.l.c cVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, fVar, cVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info("PayFlowController", " requestPayInternal");
            j.a.a.e.k.o.f fVar2 = new j.a.a.e.k.o.f(this.f64108g, this.f64109h, iPayCallback, activity, dialog, iYYPayWayView, this, fVar, bVar, this);
            this.f64105d = TraceIdUtil.newTraceId();
            RLog.info("PayFlowController", " requestPayInternal new mTraceId:" + this.f64105d);
            this.f64106e.a(activity, this.f64110i, fVar, cVar, appCustomExpand, fVar2, this.f64105d);
        }
    }

    @Override // j.a.a.e.k.e
    public void d(Activity activity, j.a.a.e.l.f fVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, fVar, dialog, iYYPayWayView) == null) {
            RLog.info("PayFlowController", "updateViewOnPaySuccess mPayFlowType" + this.f64110i.name());
            if (this.f64110i == PayFlowType.NO_PAY_FLOW) {
                RLog.info("PayFlowController", "updateViewOnPayFail 但支付流程已结束");
            } else {
                z(new d(this, activity, fVar, dialog, iYYPayWayView));
            }
        }
    }

    @Override // j.a.a.e.k.c
    public void e(Activity activity, j.a.a.e.l.c cVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, activity, cVar, list, viewParams, iPayCallback) == null) {
            RLog.info("PayFlowController", "showPayWayDialog");
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f64813b = cVar;
            bVar.a = list;
            if (viewParams != null) {
                bVar.f64814c = viewParams.appCustomExpand;
                bVar.f64815d = viewParams.closeOnSuccess;
                bVar.f64816e = viewParams.viewEventListener;
            }
            D(activity, bVar, iPayCallback);
        }
    }

    @Override // j.a.a.e.k.c
    public void f(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, absViewEventHandler, payDialogType) == null) {
            String name = payDialogType != null ? payDialogType.name() : StringUtil.NULL_STRING;
            RLog.info("PayFlowController", "notifyPayFlowChange payDialogType:" + name);
            if (payDialogType == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info("PayFlowController", "notifyPayFlowChange call onPayFlowFinish");
                w();
            }
            if (absViewEventHandler != null && payDialogType != null) {
                absViewEventHandler.onViewStateChange(payDialogType);
            } else {
                RLog.debug("PayFlowController", "notifyPayFlowChange null");
            }
        }
    }

    @Override // j.a.a.e.k.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f64105d = null;
            IAppPayService b2 = j.a.a.e.n.b.b(this.f64108g, this.f64109h);
            if (b2 == null) {
                RLog.error("PayFlowController", "unregisterPayServiceListener null appPayService", new Object[0]);
            } else if (this.f64103b != null) {
                RLog.info("PayFlowController", "unregisterPayServiceListener");
                b2.removePayListener(this.f64103b);
                this.f64103b = null;
            }
        }
    }

    @Override // j.a.a.e.k.c
    public void h(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, activity, list, viewParams, iPayCallback) == null) {
            RLog.info("PayFlowController", "showInputDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            f(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            j.a.a.e.o.g.e.a.f(activity, new j.a.a.e.k.o.b(this, absViewEventHandler, this.a, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.a);
        }
    }

    @Override // j.a.a.e.k.c
    public boolean i(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, activity, iYYPayResultView, absViewEventHandler)) == null) {
            if (this.f64111j.e(activity, new j.a.a.e.k.o.e(), this, absViewEventHandler)) {
                RLog.info("PayFlowController", "showPayGiftDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // j.a.a.e.k.e
    public void j(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, activity, dialog, iYYPayWayView, purchaseStatus) == null) {
            RLog.info("PayFlowController", "updateViewOnPayStatus  mPayFlowType" + this.f64110i.name());
            if (this.f64110i == PayFlowType.NO_PAY_FLOW) {
                RLog.info("PayFlowController", "updateViewOnPayFail 但支付流程已结束");
            } else if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                z(new e(this, activity, dialog, iYYPayWayView));
            } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
            } else {
                z(new f(this, activity, dialog, iYYPayWayView));
            }
        }
    }

    @Override // j.a.a.e.k.c
    public boolean k(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, activity, iYYPayWayView, absViewEventHandler)) == null) {
            if (this.f64111j.d(activity, new j.a.a.e.k.o.d(iYYPayWayView), this, absViewEventHandler)) {
                RLog.info("PayFlowController", "showConfirmFinishDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // j.a.a.e.k.e
    public void l(int i2, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), str, activity, dialog, iYYPayWayView, bVar}) == null) {
            RLog.info("PayFlowController", "updateViewOnPayFail mPayFlowType" + this.f64110i.name());
            if (this.f64110i == PayFlowType.NO_PAY_FLOW) {
                RLog.info("PayFlowController", "updateViewOnPayFail 但支付流程已结束");
            } else if (i2 == PayStatus.CANCEL.getCode()) {
                RLog.info("PayFlowController", "updateViewOnPayFail 用户取消支付 code:" + i2);
                z(new b(this, activity, dialog, iYYPayWayView));
            } else {
                z(new c(this, activity, i2, str, bVar, dialog));
            }
        }
    }

    public final boolean p(Activity activity, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, activity, absViewEventHandler)) == null) {
            if (NetworkUtil.isNetworkStrictlyAvailable(activity)) {
                return true;
            }
            Toast.makeText(activity, "网络不给力,请稍后重试(c)", 1).show();
            RLog.error("PayFlowController", "showPayAmountDialog fail: network error", new Object[0]);
            b(CancelType.ON_START_SHOW_FAIL, absViewEventHandler);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            RLog.info("PayFlowController", "clear:" + this);
            PayFlowType payFlowType = PayFlowType.NO_PAY_FLOW;
            this.f64110i = payFlowType;
            this.f64111j.j(payFlowType);
        }
    }

    public final Dialog r(Activity activity, IYYPayAmountView iYYPayAmountView, AbsViewEventHandler absViewEventHandler, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, activity, iYYPayAmountView, absViewEventHandler, viewParams)) == null) {
            RLog.info("PayFlowController", "createPayAmountDialog");
            String string = activity.getString(j.a.a.e.f.pay_ui_dialog_title);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            String str = string;
            f(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            return j.a.a.e.o.g.a.f64233b.d(activity, str, iYYPayAmountView.getContentView(), new j.a.a.e.k.o.a(this.f64108g, this.f64109h, this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    public final Dialog s(Activity activity, IYYPayResultView.c cVar, IYYPayResultView iYYPayResultView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, activity, cVar, iYYPayResultView)) == null) {
            RLog.info("PayFlowController", "createPayResultDialog");
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f64812b : null;
            f(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            return j.a.a.e.o.g.a.f64233b.d(activity, activity.getString(j.a.a.e.f.pay_ui_dialog_pay_title), iYYPayResultView.getContentView(), new j.a.a.e.k.o.g(absViewEventHandler, this, activity, iYYPayResultView), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final Dialog t(Activity activity, IYYPayWayView iYYPayWayView, IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048598, this, activity, iYYPayWayView, iAppPayService, absViewEventHandler)) == null) {
            RLog.info("PayFlowController", "createPayWayDialog");
            f(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            return j.a.a.e.o.g.a.f64233b.d(activity, activity.getString(j.a.a.e.f.pay_ui_dialog_pay_title), iYYPayWayView.getContentView(), new j.a.a.e.k.o.i(this.f64108g, this.f64109h, activity, iYYPayWayView, absViewEventHandler, this), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    public final boolean u(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, activity, iPayCallback, viewParams)) == null) {
            boolean z = viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_QUICK_PAY;
            RLog.info("PayFlowController", "fastShowPayWayDialog isQuickPay:" + z);
            if (z) {
                if (viewParams.targetAmount > 5.0E7d) {
                    viewParams.targetAmount = 50000000;
                }
                e(activity, j.a.a.e.n.b.a(viewParams.targetAmount, this.a), null, viewParams, iPayCallback);
                RLog.info("PayFlowController", "fastShowPayWayDialog targetAmount:" + viewParams.targetAmount);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void v(CurrencyChargeMessage currencyChargeMessage, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{currencyChargeMessage, activity, dialog, iYYPayWayView, bVar, iPayCallback}) == null) {
            String str = currencyChargeMessage.traceid;
            RLog.info("PayFlowController", "onCurrencyChargeMessage messgaeTraceId:" + str + " message:" + currencyChargeMessage.toString());
            if (!str.equals(this.f64105d)) {
                RLog.warn("PayFlowController", "messgaeTraceId not equal mTraceId");
                return;
            }
            boolean z = currencyChargeMessage.status == 1;
            this.f64111j.h(currencyChargeMessage.giftBagsInfo);
            F(activity, dialog, iYYPayWayView, bVar, currencyChargeMessage);
            E(currencyChargeMessage, bVar);
            if (iPayCallback != null) {
                if (z) {
                    iPayCallback.onSuccess(currencyChargeMessage, null);
                } else {
                    iPayCallback.onFail(currencyChargeMessage.status, "", null);
                }
            }
        }
    }

    public final void w() {
        PayFlowType payFlowType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            RLog.info("PayFlowController", "onPayFlowFinish mPayFlowType:" + this.f64110i);
            h hVar = this.f64104c;
            if (hVar == null || (payFlowType = PayFlowType.DIOALOG_PAY_FLOW) != this.f64110i) {
                return;
            }
            hVar.onPayFlowFinish(payFlowType);
        }
    }

    public final void x(Dialog dialog, IYYPayWayView iYYPayWayView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048602, this, dialog, iYYPayWayView, z) == null) {
            RLog.info("PayFlowController", "refreshPayWayView");
            IYYPayWayView.PayViewState payViewState = z ? IYYPayWayView.PayViewState.WAITING_VIEW_STATE : IYYPayWayView.PayViewState.SELECTING_VIEW_STATE;
            if (iYYPayWayView != null) {
                iYYPayWayView.setViewState(payViewState);
            }
            if (z) {
                j.a.a.e.o.g.a.f64233b.e(dialog);
            } else {
                j.a.a.e.o.g.a.f64233b.b(dialog);
            }
        }
    }

    public void y(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048603, this, activity, dialog, iYYPayWayView, bVar, iPayCallback) == null) {
            IAppPayService b2 = j.a.a.e.n.b.b(this.f64108g, this.f64109h);
            if (b2 == null) {
                RLog.error("PayFlowController", "registerPayServiceListener null appPayService", new Object[0]);
                return;
            }
            this.f64103b = new a(this, activity, dialog, iYYPayWayView, bVar, iPayCallback);
            RLog.info("PayFlowController", "registerPayServiceListener");
            b2.addPayListener(this.f64103b);
        }
    }

    public final void z(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.f64112k.post(runnable);
            }
        }
    }
}
