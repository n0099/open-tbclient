package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class zx9 implements qx9, sx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public PayUIKitConfig c;
    public AppPayServiceListener d;
    public vx9 e;
    public String f;
    public px9 g;
    public tx9 h;
    public int i;
    public int j;
    public PayFlowType k;
    public PayDialogType l;
    public ox9 m;
    public Handler n;

    /* loaded from: classes7.dex */
    public class a extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ IYYPayWayView.b d;
        public final /* synthetic */ IPayCallback e;
        public final /* synthetic */ zx9 f;

        public a(zx9 zx9Var, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, activity, dialog, iYYPayWayView, bVar, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zx9Var;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
            this.d = bVar;
            this.e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                this.f.y(currencyChargeMessage, this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ zx9 d;

        public b(zx9 zx9Var, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zx9Var;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && pz9.a.a(this.a)) {
                this.d.z(this.b, this.c, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ IYYPayWayView.b d;
        public final /* synthetic */ Dialog e;
        public final /* synthetic */ zx9 f;

        public c(zx9 zx9Var, Activity activity, int i, String str, IYYPayWayView.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, activity, Integer.valueOf(i), str, bVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zx9Var;
            this.a = activity;
            this.b = i;
            this.c = str;
            this.d = bVar;
            this.e = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.m.d(null);
                if (pz9.a.a(this.a)) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    IYYPayResultView.b bVar = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    cVar.a = bVar;
                    bVar.a(this.b);
                    cVar.a.b(this.c);
                    IYYPayWayView.b bVar2 = this.d;
                    if (bVar2 != null) {
                        cVar.b = bVar2.e;
                    }
                    this.f.C(this.a, cVar);
                    gz9.a(this.e, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ty9 b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IYYPayWayView d;
        public final /* synthetic */ zx9 e;

        public d(zx9 zx9Var, Activity activity, ty9 ty9Var, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, activity, ty9Var, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zx9Var;
            this.a = activity;
            this.b = ty9Var;
            this.c = dialog;
            this.d = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.m.d(null);
                if (pz9.a.a(this.a)) {
                    PayType payType = this.b.a;
                    if (payType == null) {
                        RLog.error(this.e.a, "updateViewOnPaySuccess error payType null", new Object[0]);
                    } else if (kz9.b(payType.getChannel(), this.b.a.getMethod())) {
                        RLog.info(this.e.a, "updateViewOnPaySuccess but h5 not loadding");
                    } else {
                        this.e.z(this.c, this.d, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ zx9 d;

        public e(zx9 zx9Var, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zx9Var;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && pz9.a.a(this.a)) {
                this.d.z(this.b, this.c, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ zx9 d;

        public f(zx9 zx9Var, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zx9Var;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && pz9.a.a(this.a)) {
                this.d.z(this.b, this.c, false);
            }
        }
    }

    public zx9(Context context, int i, int i2, vx9 vx9Var, tx9 tx9Var, px9 px9Var, ox9 ox9Var, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), vx9Var, tx9Var, px9Var, ox9Var, payFlowType, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "PayFlowHandlerImpl";
        this.l = PayDialogType.PAY_NONE_DIALOG;
        this.n = new Handler(Looper.getMainLooper());
        String str = this.a + "@" + hashCode();
        this.a = str;
        this.b = context;
        this.i = i;
        this.j = i2;
        this.e = vx9Var;
        this.c = payUIKitConfig;
        this.h = tx9Var;
        this.g = px9Var;
        this.m = ox9Var;
        this.k = payFlowType;
        RLog.info(str, "create PayFlowHandlerImpl: " + this + " mPayFlowType:" + this.k.name());
    }

    public void A(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, activity, dialog, iYYPayWayView, bVar, iPayCallback) == null) {
            IAppPayService b2 = az9.b(this.i, this.j);
            if (b2 == null) {
                RLog.error(this.a, "registerPayServiceListener null appPayService", new Object[0]);
                return;
            }
            this.d = new a(this, activity, dialog, iYYPayWayView, bVar, iPayCallback);
            RLog.info(this.a, "registerPayServiceListener");
            b2.addPayListener(this.d);
        }
    }

    public final void B(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.n.post(runnable);
            }
        }
    }

    public void C(Activity activity, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, cVar) == null) {
            RLog.info(this.a, "showPayResultDialog");
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.b : null;
            IYYPayResultView f2 = this.h.f(activity, cVar, this.m);
            f2.setCallback(new ly9(activity, f2, absViewEventHandler, v(activity, cVar, f2), this));
        }
    }

    public final void D(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (kz9.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod)) {
                z(dialog, iYYPayWayView, false);
                return;
            }
            gz9.a(dialog, PayDialogType.PAY_WAY_DIALOG);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.a = bVar;
            cVar.b = bVar2.e;
            C(activity, cVar);
        }
    }

    public final void E(CurrencyChargeMessage currencyChargeMessage, IYYPayWayView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, currencyChargeMessage, bVar) == null) {
            if (!(currencyChargeMessage.status == 1)) {
                String str = this.a;
                RLog.info(str, "statisticOnCurrencyChargeMessage but pay fail status:" + currencyChargeMessage.status);
                return;
            }
            int i = currencyChargeMessage.cid;
            String str2 = currencyChargeMessage.payChannel;
            String str3 = currencyChargeMessage.payMethod;
            yy9.d(this.i, currencyChargeMessage.usedChannel, this.k == PayFlowType.WALLET_PAY_FLOW ? "14" : "7", str2, str3, String.valueOf(i));
            String str4 = this.a;
            RLog.info(str4, "statisticOnCurrencyChargeMessage payChannel:" + str2 + " payMethod:" + str3);
        }
    }

    public void F(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, dialog, iYYPayWayView, bVar, currencyChargeMessage) == null) {
            boolean z = false;
            boolean z2 = currencyChargeMessage.status == 1;
            if (pz9.a.a(activity)) {
                IYYPayResultView.b bVar2 = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                if ((z2 && (bVar != null && bVar.d)) ? true : true) {
                    D(activity, currencyChargeMessage, dialog, bVar2, iYYPayWayView, bVar);
                } else {
                    gz9.b(dialog, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    @Override // com.repackage.qx9
    public void a(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, bVar, iPayCallback) == null) {
            IAppPayService b2 = az9.b(this.i, this.j);
            if (b2 == null) {
                RLog.error(this.a, "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            bVar.f = this.k;
            IYYPayWayView e2 = this.h.e(activity, bVar, this.m);
            e2.refreshView();
            Dialog w = w(activity, e2, b2, bVar != null ? bVar.e : null);
            IYYPayWayView.b bVar2 = bVar;
            e2.setCallback(new ny9(activity, w, e2, bVar2, iPayCallback, this));
            A(activity, w, e2, bVar2, iPayCallback);
            RLog.debug(this.a, "showPayWayDialog addPayListener");
        }
    }

    @Override // com.repackage.qx9
    public void b(int i, String str, PayCallBackBean payCallBackBean) {
        vx9 vx9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i, str, payCallBackBean) == null) || (vx9Var = this.e) == null) {
            return;
        }
        vx9Var.a(i, str, payCallBackBean);
    }

    @Override // com.repackage.qx9
    public void c(CancelType cancelType, AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cancelType, absViewEventHandler) == null) {
            boolean z = cancelType == CancelType.BUTTOM_AREA_CLICK || cancelType == CancelType.EMPTY_AREA_CLICK || cancelType == CancelType.ON_DIALOG_CANCEL || cancelType == CancelType.ON_START_SHOW_FAIL;
            String str = this.a;
            RLog.info(str, "checkNotifyViewFlowClose clickArea:" + cancelType.name() + " shouldNotifyPayFlowChange:" + z);
            if (z) {
                h(absViewEventHandler, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    @Override // com.repackage.qx9
    public void d(Activity activity, ty9 ty9Var, qy9 qy9Var, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, ty9Var, qy9Var, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info(this.a, " requestPayInternal");
            jy9 jy9Var = new jy9(this.i, this.j, iPayCallback, activity, dialog, iYYPayWayView, this, ty9Var, bVar, this);
            this.f = TraceIdUtil.newTraceId();
            String str = this.a;
            RLog.info(str, " requestPayInternal new mTraceId:" + this.f);
            this.g.a(activity, this.k, ty9Var, qy9Var, appCustomExpand, jy9Var, this.f);
        }
    }

    @Override // com.repackage.qx9
    public void e(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, activity, iPayCallback, viewParams) == null) {
            RLog.info(this.a, "showPayAmountDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            if (t(activity, absViewEventHandler) && !x(activity, iPayCallback, viewParams)) {
                IYYPayAmountView a2 = this.h.a(activity, viewParams, this.m);
                a2.refreshView();
                a2.setCallback(new ey9(this.i, this.j, u(activity, a2, absViewEventHandler, viewParams), viewParams, activity, iPayCallback, this));
            }
        }
    }

    @Override // com.repackage.sx9
    public void f(Activity activity, ty9 ty9Var, Dialog dialog, IYYPayWayView iYYPayWayView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, activity, ty9Var, dialog, iYYPayWayView) == null) {
            String str = this.a;
            RLog.info(str, "updateViewOnPaySuccess mPayFlowType" + this.k.name());
            if (this.l == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
            } else {
                B(new d(this, activity, ty9Var, dialog, iYYPayWayView));
            }
        }
    }

    @Override // com.repackage.qx9
    public void g(Activity activity, qy9 qy9Var, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048588, this, activity, qy9Var, list, viewParams, iPayCallback) == null) {
            RLog.info(this.a, "showPayWayDialog");
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.b = qy9Var;
            bVar.a = list;
            if (viewParams != null) {
                bVar.c = viewParams.appCustomExpand;
                bVar.d = viewParams.closeOnSuccess;
                bVar.e = viewParams.viewEventListener;
            }
            a(activity, bVar, iPayCallback);
        }
    }

    @Override // com.repackage.qx9
    public void h(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, absViewEventHandler, payDialogType) == null) {
            String name = payDialogType != null ? payDialogType.name() : StringUtil.NULL_STRING;
            String str = this.a;
            RLog.info(str, "notifyPayFlowChange payDialogType:" + name);
            this.l = payDialogType;
            bx9.c(this.i, this.j, this.k, payDialogType);
            if (absViewEventHandler != null && payDialogType != null) {
                absViewEventHandler.onViewStateChange(payDialogType);
            } else {
                RLog.debug(this.a, "notifyPayFlowChange null");
            }
        }
    }

    @Override // com.repackage.qx9
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f = null;
            IAppPayService b2 = az9.b(this.i, this.j);
            if (b2 == null) {
                RLog.error(this.a, "unregisterPayServiceListener null appPayService", new Object[0]);
            } else if (this.d != null) {
                RLog.info(this.a, "unregisterPayServiceListener");
                b2.removePayListener(this.d);
                this.d = null;
            }
        }
    }

    @Override // com.repackage.qx9
    public void j(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, activity, list, viewParams, iPayCallback) == null) {
            RLog.info(this.a, "showInputDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            h(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            e0a.a.f(activity, new dy9(this, absViewEventHandler, this.c, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.c, this.k);
        }
    }

    @Override // com.repackage.qx9
    public boolean k(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, activity, iYYPayResultView, absViewEventHandler)) == null) {
            if (this.m.b(activity, new hy9(), this, absViewEventHandler)) {
                RLog.info(this.a, "showPayGiftDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.repackage.sx9
    public void l(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048593, this, activity, dialog, iYYPayWayView, purchaseStatus) == null) {
            String str = this.a;
            RLog.info(str, "updateViewOnPayStatus  mPayFlowType" + this.k.name());
            if (this.l == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
            } else if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                B(new e(this, activity, dialog, iYYPayWayView));
            } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
            } else {
                B(new f(this, activity, dialog, iYYPayWayView));
            }
        }
    }

    @Override // com.repackage.qx9
    public boolean m(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, activity, iYYPayWayView, absViewEventHandler)) == null) {
            if (this.m.e(activity, new fy9(iYYPayWayView), this, absViewEventHandler)) {
                RLog.info(this.a, "showConfirmFinishDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.repackage.qx9
    public PayDialogType n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l : (PayDialogType) invokeV.objValue;
    }

    @Override // com.repackage.sx9
    public void o(int i, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, activity, dialog, iYYPayWayView, bVar}) == null) {
            String str2 = this.a;
            RLog.info(str2, "updateViewOnPayFail mPayFlowType" + this.k.name());
            if (this.l == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
            } else if (i == PayStatus.CANCEL.getCode()) {
                String str3 = this.a;
                RLog.info(str3, "updateViewOnPayFail 用户取消支付 code:" + i);
                B(new b(this, activity, dialog, iYYPayWayView));
            } else {
                B(new c(this, activity, i, str, bVar, dialog));
            }
        }
    }

    @Override // com.repackage.qx9
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            String str = this.a;
            RLog.info(str, "clear:" + this);
            this.l = PayDialogType.PAY_NONE_DIALOG;
        }
    }

    public final boolean t(Activity activity, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, activity, absViewEventHandler)) == null) {
            if (NetworkUtil.isNetworkStrictlyAvailable(activity)) {
                return true;
            }
            Toast.makeText(activity, "网络不给力,请稍后重试(c)", 1).show();
            RLog.error(this.a, "showPayAmountDialog fail: network error", new Object[0]);
            c(CancelType.ON_START_SHOW_FAIL, absViewEventHandler);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final Dialog u(Activity activity, IYYPayAmountView iYYPayAmountView, AbsViewEventHandler absViewEventHandler, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048599, this, activity, iYYPayAmountView, absViewEventHandler, viewParams)) == null) {
            RLog.info(this.a, "createPayAmountDialog");
            String string = activity.getString(R.string.obfuscated_res_0x7f0f0d4d);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            String str = string;
            h(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            return a0a.b.d(activity, str, iYYPayAmountView.getContentView(), new cy9(this.i, this.j, this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG, this.k);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    public final Dialog v(Activity activity, IYYPayResultView.c cVar, IYYPayResultView iYYPayResultView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, activity, cVar, iYYPayResultView)) == null) {
            RLog.info(this.a, "createPayResultDialog");
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.b : null;
            h(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            return a0a.b.d(activity, activity.getString(R.string.obfuscated_res_0x7f0f0d4c), iYYPayResultView.getContentView(), new ky9(absViewEventHandler, this, activity, iYYPayResultView), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG, this.k);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final Dialog w(Activity activity, IYYPayWayView iYYPayWayView, IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048601, this, activity, iYYPayWayView, iAppPayService, absViewEventHandler)) == null) {
            RLog.info(this.a, "createPayWayDialog");
            h(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            return a0a.b.d(activity, activity.getString(R.string.obfuscated_res_0x7f0f0d4c), iYYPayWayView.getContentView(), new my9(this.i, this.j, activity, iYYPayWayView, absViewEventHandler, this), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG, this.k);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    public final boolean x(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, activity, iPayCallback, viewParams)) == null) {
            boolean z = viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_QUICK_PAY;
            String str = this.a;
            RLog.info(str, "fastShowPayWayDialog isQuickPay:" + z);
            if (z) {
                if (viewParams.targetAmount > 5.0E7d) {
                    viewParams.targetAmount = 50000000;
                }
                g(activity, az9.a(viewParams.targetAmount, this.c), null, viewParams, iPayCallback);
                String str2 = this.a;
                RLog.info(str2, "fastShowPayWayDialog targetAmount:" + viewParams.targetAmount);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void y(CurrencyChargeMessage currencyChargeMessage, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{currencyChargeMessage, activity, dialog, iYYPayWayView, bVar, iPayCallback}) == null) {
            String str = currencyChargeMessage.traceid;
            String str2 = this.a;
            RLog.info(str2, "onCurrencyChargeMessage messgaeTraceId:" + str + " message:" + currencyChargeMessage.toString());
            if (!str.equals(this.f)) {
                RLog.warn(this.a, "messgaeTraceId not equal mTraceId");
                return;
            }
            boolean z = currencyChargeMessage.status == 1;
            this.m.f(currencyChargeMessage.giftBagsInfo);
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

    public final void z(Dialog dialog, IYYPayWayView iYYPayWayView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048604, this, dialog, iYYPayWayView, z) == null) {
            RLog.info(this.a, "refreshPayWayView");
            IYYPayWayView.PayViewState payViewState = z ? IYYPayWayView.PayViewState.WAITING_VIEW_STATE : IYYPayWayView.PayViewState.SELECTING_VIEW_STATE;
            if (iYYPayWayView != null) {
                iYYPayWayView.setViewState(payViewState);
            }
            if (z) {
                a0a.b.e(dialog);
            } else {
                a0a.b.b(dialog);
            }
        }
    }
}
