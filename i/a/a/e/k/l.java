package i.a.a.e.k;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
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
public class l implements i.a.a.e.k.c, i.a.a.e.k.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayUIKitConfig f72247a;

    /* renamed from: b  reason: collision with root package name */
    public AppPayServiceListener f72248b;

    /* renamed from: c  reason: collision with root package name */
    public h f72249c;

    /* renamed from: d  reason: collision with root package name */
    public String f72250d;

    /* renamed from: e  reason: collision with root package name */
    public i.a.a.e.k.b f72251e;

    /* renamed from: f  reason: collision with root package name */
    public i.a.a.e.k.f f72252f;

    /* renamed from: g  reason: collision with root package name */
    public int f72253g;

    /* renamed from: h  reason: collision with root package name */
    public int f72254h;

    /* renamed from: i  reason: collision with root package name */
    public PayFlowType f72255i;
    public i j;
    public Handler k;

    /* loaded from: classes3.dex */
    public class a extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f72256a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f72257b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72258c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72259d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72260e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f72261f;

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
            this.f72261f = lVar;
            this.f72256a = activity;
            this.f72257b = dialog;
            this.f72258c = iYYPayWayView;
            this.f72259d = bVar;
            this.f72260e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                this.f72261f.v(currencyChargeMessage, this.f72256a, this.f72257b, this.f72258c, this.f72259d, this.f72260e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f72262e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f72263f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72264g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ l f72265h;

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
            this.f72265h = lVar;
            this.f72262e = activity;
            this.f72263f = dialog;
            this.f72264g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && i.a.a.e.n.n.f72367a.a(this.f72262e)) {
                this.f72265h.x(this.f72263f, this.f72264g, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f72266e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f72267f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f72268g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72269h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Dialog f72270i;
        public final /* synthetic */ l j;

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
            this.j = lVar;
            this.f72266e = activity;
            this.f72267f = i2;
            this.f72268g = str;
            this.f72269h = bVar;
            this.f72270i = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.j.f(null);
                if (i.a.a.e.n.n.f72367a.a(this.f72266e)) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    IYYPayResultView.b bVar = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    cVar.f73128a = bVar;
                    bVar.a(this.f72267f);
                    cVar.f73128a.b(this.f72268g);
                    IYYPayWayView.b bVar2 = this.f72269h;
                    if (bVar2 != null) {
                        cVar.f73129b = bVar2.f73134e;
                    }
                    this.j.B(this.f72266e, cVar);
                    i.a.a.e.n.h.a(this.f72270i, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f72271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.l.f f72272f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Dialog f72273g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72274h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ l f72275i;

        public d(l lVar, Activity activity, i.a.a.e.l.f fVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
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
            this.f72275i = lVar;
            this.f72271e = activity;
            this.f72272f = fVar;
            this.f72273g = dialog;
            this.f72274h = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72275i.j.f(null);
                if (i.a.a.e.n.n.f72367a.a(this.f72271e)) {
                    PayType payType = this.f72272f.f72357a;
                    if (payType == null) {
                        RLog.error("PayFlowController", "updateViewOnPaySuccess error payType null", new Object[0]);
                    } else if (!i.a.a.e.n.j.b(payType.getChannel(), this.f72272f.f72357a.getMethod())) {
                        this.f72275i.x(this.f72273g, this.f72274h, true);
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
        public final /* synthetic */ Activity f72276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f72277f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72278g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ l f72279h;

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
            this.f72279h = lVar;
            this.f72276e = activity;
            this.f72277f = dialog;
            this.f72278g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && i.a.a.e.n.n.f72367a.a(this.f72276e)) {
                this.f72279h.x(this.f72277f, this.f72278g, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f72280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f72281f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72282g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ l f72283h;

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
            this.f72283h = lVar;
            this.f72280e = activity;
            this.f72281f = dialog;
            this.f72282g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && i.a.a.e.n.n.f72367a.a(this.f72280e)) {
                this.f72283h.x(this.f72281f, this.f72282g, false);
            }
        }
    }

    public l(int i2, int i3, h hVar, i.a.a.e.k.f fVar, i.a.a.e.k.b bVar, i iVar, PayFlowType payFlowType) {
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
        this.k = new Handler(Looper.getMainLooper());
        this.f72253g = i2;
        this.f72254h = i3;
        this.f72249c = hVar;
        this.f72247a = hVar != null ? hVar.getPayUIKitConfig() : null;
        this.f72252f = fVar;
        this.f72251e = bVar;
        this.j = iVar;
        this.f72255i = payFlowType;
        RLog.info("PayFlowController", "create PayFlowController: " + this + " mPayFlowType:" + this.f72255i.name());
    }

    public void A(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, iPayCallback, viewParams) == null) {
            RLog.info("PayFlowController", "showPayAmountDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            if (p(activity, absViewEventHandler) && !u(activity, iPayCallback, viewParams)) {
                IYYPayAmountView f2 = this.f72252f.f(activity, viewParams);
                f2.refreshView();
                f2.setCallback(new i.a.a.e.k.o.c(this.f72253g, this.f72254h, r(activity, f2, absViewEventHandler, viewParams), viewParams, activity, iPayCallback, this));
            }
        }
    }

    public void B(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, cVar) == null) {
            RLog.info("PayFlowController", "showPayResultDialog");
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f73129b : null;
            IYYPayResultView c2 = this.f72252f.c(activity, cVar);
            c2.setCallback(new i.a.a.e.k.o.h(activity, c2, absViewEventHandler, s(activity, cVar, c2), this));
        }
    }

    public final void C(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (i.a.a.e.n.j.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod)) {
                x(dialog, iYYPayWayView, false);
                return;
            }
            i.a.a.e.n.h.a(dialog, PayDialogType.PAY_WAY_DIALOG);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.f73128a = bVar;
            cVar.f73129b = bVar2.f73134e;
            B(activity, cVar);
        }
    }

    public void D(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, bVar, iPayCallback) == null) {
            IAppPayService b2 = i.a.a.e.n.b.b(this.f72253g, this.f72254h);
            if (b2 == null) {
                RLog.error("PayFlowController", "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            bVar.f73135f = this.f72255i;
            IYYPayWayView b3 = this.f72252f.b(activity, bVar);
            b3.refreshView();
            Dialog t = t(activity, b3, b2, bVar != null ? bVar.f73134e : null);
            IYYPayWayView.b bVar2 = bVar;
            b3.setCallback(new i.a.a.e.k.o.j(activity, t, b3, bVar2, iPayCallback, this));
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
            i.a.a.e.m.b.d(this.f72253g, currencyChargeMessage.usedChannel, this.f72255i == PayFlowType.ACTIVITY_PAY_FLOW ? "14" : "7", str, str2, String.valueOf(i2));
            RLog.info("PayFlowController", "statisticOnCurrencyChargeMessage payChannel:" + str + " payMethod:" + str2);
        }
    }

    public void F(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, dialog, iYYPayWayView, bVar, currencyChargeMessage) == null) {
            boolean z = false;
            boolean z2 = currencyChargeMessage.status == 1;
            if (i.a.a.e.n.n.f72367a.a(activity)) {
                IYYPayResultView.b bVar2 = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                if ((z2 && (bVar != null && bVar.f73133d)) ? true : true) {
                    C(activity, currencyChargeMessage, dialog, bVar2, iYYPayWayView, bVar);
                } else {
                    i.a.a.e.n.h.b(dialog, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    @Override // i.a.a.e.k.c
    public void a(int i2, String str, PayCallBackBean payCallBackBean) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048582, this, i2, str, payCallBackBean) == null) || (hVar = this.f72249c) == null) {
            return;
        }
        hVar.notifyYYPayFailListener(i2, str, payCallBackBean);
    }

    @Override // i.a.a.e.k.c
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

    @Override // i.a.a.e.k.c
    public void c(Activity activity, i.a.a.e.l.f fVar, i.a.a.e.l.c cVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, fVar, cVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info("PayFlowController", " requestPayInternal");
            i.a.a.e.k.o.f fVar2 = new i.a.a.e.k.o.f(this.f72253g, this.f72254h, iPayCallback, activity, dialog, iYYPayWayView, this, fVar, bVar, this);
            this.f72250d = TraceIdUtil.newTraceId();
            RLog.info("PayFlowController", " requestPayInternal new mTraceId:" + this.f72250d);
            this.f72251e.a(activity, this.f72255i, fVar, cVar, appCustomExpand, fVar2, this.f72250d);
        }
    }

    @Override // i.a.a.e.k.e
    public void d(Activity activity, i.a.a.e.l.f fVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, fVar, dialog, iYYPayWayView) == null) {
            RLog.info("PayFlowController", "updateViewOnPaySuccess mPayFlowType" + this.f72255i.name());
            if (this.f72255i == PayFlowType.NO_PAY_FLOW) {
                RLog.info("PayFlowController", "updateViewOnPayFail 但支付流程已结束");
            } else {
                z(new d(this, activity, fVar, dialog, iYYPayWayView));
            }
        }
    }

    @Override // i.a.a.e.k.c
    public void e(Activity activity, i.a.a.e.l.c cVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, activity, cVar, list, viewParams, iPayCallback) == null) {
            RLog.info("PayFlowController", "showPayWayDialog");
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f73131b = cVar;
            bVar.f73130a = list;
            if (viewParams != null) {
                bVar.f73132c = viewParams.appCustomExpand;
                bVar.f73133d = viewParams.closeOnSuccess;
                bVar.f73134e = viewParams.viewEventListener;
            }
            D(activity, bVar, iPayCallback);
        }
    }

    @Override // i.a.a.e.k.c
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

    @Override // i.a.a.e.k.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f72250d = null;
            IAppPayService b2 = i.a.a.e.n.b.b(this.f72253g, this.f72254h);
            if (b2 == null) {
                RLog.error("PayFlowController", "unregisterPayServiceListener null appPayService", new Object[0]);
            } else if (this.f72248b != null) {
                RLog.info("PayFlowController", "unregisterPayServiceListener");
                b2.removePayListener(this.f72248b);
                this.f72248b = null;
            }
        }
    }

    @Override // i.a.a.e.k.c
    public void h(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, activity, list, viewParams, iPayCallback) == null) {
            RLog.info("PayFlowController", "showInputDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            f(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            i.a.a.e.o.g.e.f72432a.f(activity, new i.a.a.e.k.o.b(this, absViewEventHandler, this.f72247a, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f72247a);
        }
    }

    @Override // i.a.a.e.k.c
    public boolean i(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, activity, iYYPayResultView, absViewEventHandler)) == null) {
            if (this.j.e(activity, new i.a.a.e.k.o.e(), this, absViewEventHandler)) {
                RLog.info("PayFlowController", "showPayGiftDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // i.a.a.e.k.e
    public void j(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, activity, dialog, iYYPayWayView, purchaseStatus) == null) {
            RLog.info("PayFlowController", "updateViewOnPayStatus  mPayFlowType" + this.f72255i.name());
            if (this.f72255i == PayFlowType.NO_PAY_FLOW) {
                RLog.info("PayFlowController", "updateViewOnPayFail 但支付流程已结束");
            } else if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                z(new e(this, activity, dialog, iYYPayWayView));
            } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
            } else {
                z(new f(this, activity, dialog, iYYPayWayView));
            }
        }
    }

    @Override // i.a.a.e.k.c
    public boolean k(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, activity, iYYPayWayView, absViewEventHandler)) == null) {
            if (this.j.d(activity, new i.a.a.e.k.o.d(iYYPayWayView), this, absViewEventHandler)) {
                RLog.info("PayFlowController", "showConfirmFinishDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // i.a.a.e.k.e
    public void l(int i2, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), str, activity, dialog, iYYPayWayView, bVar}) == null) {
            RLog.info("PayFlowController", "updateViewOnPayFail mPayFlowType" + this.f72255i.name());
            if (this.f72255i == PayFlowType.NO_PAY_FLOW) {
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
            this.f72255i = payFlowType;
            this.j.j(payFlowType);
        }
    }

    public final Dialog r(Activity activity, IYYPayAmountView iYYPayAmountView, AbsViewEventHandler absViewEventHandler, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, activity, iYYPayAmountView, absViewEventHandler, viewParams)) == null) {
            RLog.info("PayFlowController", "createPayAmountDialog");
            String string = activity.getString(i.a.a.e.f.pay_ui_dialog_title);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            String str = string;
            f(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            return i.a.a.e.o.g.a.f72402b.d(activity, str, iYYPayAmountView.getContentView(), new i.a.a.e.k.o.a(this.f72253g, this.f72254h, this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    public final Dialog s(Activity activity, IYYPayResultView.c cVar, IYYPayResultView iYYPayResultView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, activity, cVar, iYYPayResultView)) == null) {
            RLog.info("PayFlowController", "createPayResultDialog");
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f73129b : null;
            f(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            return i.a.a.e.o.g.a.f72402b.d(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), iYYPayResultView.getContentView(), new i.a.a.e.k.o.g(absViewEventHandler, this, activity, iYYPayResultView), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final Dialog t(Activity activity, IYYPayWayView iYYPayWayView, IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048598, this, activity, iYYPayWayView, iAppPayService, absViewEventHandler)) == null) {
            RLog.info("PayFlowController", "createPayWayDialog");
            f(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            return i.a.a.e.o.g.a.f72402b.d(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), iYYPayWayView.getContentView(), new i.a.a.e.k.o.i(this.f72253g, this.f72254h, activity, iYYPayWayView, absViewEventHandler, this), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
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
                    viewParams.targetAmount = CacheEngine.MAX_DISK_CACHE;
                }
                e(activity, i.a.a.e.n.b.a(viewParams.targetAmount, this.f72247a), null, viewParams, iPayCallback);
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
            if (!str.equals(this.f72250d)) {
                RLog.warn("PayFlowController", "messgaeTraceId not equal mTraceId");
                return;
            }
            boolean z = currencyChargeMessage.status == 1;
            this.j.h(currencyChargeMessage.giftBagsInfo);
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
            RLog.info("PayFlowController", "onPayFlowFinish mPayFlowType:" + this.f72255i);
            h hVar = this.f72249c;
            if (hVar == null || (payFlowType = PayFlowType.DIOALOG_PAY_FLOW) != this.f72255i) {
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
                i.a.a.e.o.g.a.f72402b.e(dialog);
            } else {
                i.a.a.e.o.g.a.f72402b.b(dialog);
            }
        }
    }

    public void y(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048603, this, activity, dialog, iYYPayWayView, bVar, iPayCallback) == null) {
            IAppPayService b2 = i.a.a.e.n.b.b(this.f72253g, this.f72254h);
            if (b2 == null) {
                RLog.error("PayFlowController", "registerPayServiceListener null appPayService", new Object[0]);
                return;
            }
            this.f72248b = new a(this, activity, dialog, iYYPayWayView, bVar, iPayCallback);
            RLog.info("PayFlowController", "registerPayServiceListener");
            b2.addPayListener(this.f72248b);
        }
    }

    public final void z(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.k.post(runnable);
            }
        }
    }
}
