package j.a.a.e.m;

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
/* loaded from: classes4.dex */
public class o implements j.a.a.e.m.f, h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64684b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f64685c;

    /* renamed from: d  reason: collision with root package name */
    public AppPayServiceListener f64686d;

    /* renamed from: e  reason: collision with root package name */
    public k f64687e;

    /* renamed from: f  reason: collision with root package name */
    public String f64688f;

    /* renamed from: g  reason: collision with root package name */
    public j.a.a.e.m.e f64689g;

    /* renamed from: h  reason: collision with root package name */
    public i f64690h;

    /* renamed from: i  reason: collision with root package name */
    public int f64691i;

    /* renamed from: j  reason: collision with root package name */
    public int f64692j;

    /* renamed from: k  reason: collision with root package name */
    public PayFlowType f64693k;
    public PayDialogType l;
    public j.a.a.e.m.d m;
    public Handler n;

    /* loaded from: classes4.dex */
    public class a extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f64694b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64695c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f64696d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f64697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ o f64698f;

        public a(o oVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, activity, dialog, iYYPayWayView, bVar, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64698f = oVar;
            this.a = activity;
            this.f64694b = dialog;
            this.f64695c = iYYPayWayView;
            this.f64696d = bVar;
            this.f64697e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                this.f64698f.y(currencyChargeMessage, this.a, this.f64694b, this.f64695c, this.f64696d, this.f64697e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64701g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f64702h;

        public b(o oVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64702h = oVar;
            this.f64699e = activity;
            this.f64700f = dialog;
            this.f64701g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.a.a.e.p.q.a.a(this.f64699e)) {
                this.f64702h.z(this.f64700f, this.f64701g, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f64704f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64705g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f64706h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Dialog f64707i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ o f64708j;

        public c(o oVar, Activity activity, int i2, String str, IYYPayWayView.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, activity, Integer.valueOf(i2), str, bVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64708j = oVar;
            this.f64703e = activity;
            this.f64704f = i2;
            this.f64705g = str;
            this.f64706h = bVar;
            this.f64707i = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64708j.m.d(null);
                if (j.a.a.e.p.q.a.a(this.f64703e)) {
                    IYYPayResultView.c cVar = new IYYPayResultView.c();
                    IYYPayResultView.b bVar = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                    cVar.a = bVar;
                    bVar.a(this.f64704f);
                    cVar.a.b(this.f64705g);
                    IYYPayWayView.b bVar2 = this.f64706h;
                    if (bVar2 != null) {
                        cVar.f65384b = bVar2.f65388e;
                    }
                    this.f64708j.C(this.f64703e, cVar);
                    j.a.a.e.p.h.a(this.f64707i, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.n.f f64710f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Dialog f64711g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64712h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ o f64713i;

        public d(o oVar, Activity activity, j.a.a.e.n.f fVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, activity, fVar, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64713i = oVar;
            this.f64709e = activity;
            this.f64710f = fVar;
            this.f64711g = dialog;
            this.f64712h = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64713i.m.d(null);
                if (j.a.a.e.p.q.a.a(this.f64709e)) {
                    PayType payType = this.f64710f.a;
                    if (payType == null) {
                        RLog.error(this.f64713i.a, "updateViewOnPaySuccess error payType null", new Object[0]);
                    } else if (j.a.a.e.p.l.b(payType.getChannel(), this.f64710f.a.getMethod())) {
                        RLog.info(this.f64713i.a, "updateViewOnPaySuccess but h5 not loadding");
                    } else {
                        this.f64713i.z(this.f64711g, this.f64712h, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64716g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f64717h;

        public e(o oVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64717h = oVar;
            this.f64714e = activity;
            this.f64715f = dialog;
            this.f64716g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.a.a.e.p.q.a.a(this.f64714e)) {
                this.f64717h.z(this.f64715f, this.f64716g, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f64718e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64719f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f64720g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f64721h;

        public f(o oVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64721h = oVar;
            this.f64718e = activity;
            this.f64719f = dialog;
            this.f64720g = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.a.a.e.p.q.a.a(this.f64718e)) {
                this.f64721h.z(this.f64719f, this.f64720g, false);
            }
        }
    }

    public o(Context context, int i2, int i3, k kVar, i iVar, j.a.a.e.m.e eVar, j.a.a.e.m.d dVar, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), kVar, iVar, eVar, dVar, payFlowType, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
        this.f64684b = context;
        this.f64691i = i2;
        this.f64692j = i3;
        this.f64687e = kVar;
        this.f64685c = payUIKitConfig;
        this.f64690h = iVar;
        this.f64689g = eVar;
        this.m = dVar;
        this.f64693k = payFlowType;
        RLog.info(str, "create PayFlowHandlerImpl: " + this + " mPayFlowType:" + this.f64693k.name());
    }

    public void A(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, activity, dialog, iYYPayWayView, bVar, iPayCallback) == null) {
            IAppPayService b2 = j.a.a.e.p.b.b(this.f64691i, this.f64692j);
            if (b2 == null) {
                RLog.error(this.a, "registerPayServiceListener null appPayService", new Object[0]);
                return;
            }
            this.f64686d = new a(this, activity, dialog, iYYPayWayView, bVar, iPayCallback);
            RLog.info(this.a, "registerPayServiceListener");
            b2.addPayListener(this.f64686d);
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
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f65384b : null;
            IYYPayResultView f2 = this.f64690h.f(activity, cVar, this.m);
            f2.setCallback(new j.a.a.e.m.r.j(activity, f2, absViewEventHandler, v(activity, cVar, f2), this));
        }
    }

    public final void D(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2}) == null) {
            if (j.a.a.e.p.l.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod)) {
                z(dialog, iYYPayWayView, false);
                return;
            }
            j.a.a.e.p.h.a(dialog, PayDialogType.PAY_WAY_DIALOG);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.a = bVar;
            cVar.f65384b = bVar2.f65388e;
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
            int i2 = currencyChargeMessage.cid;
            String str2 = currencyChargeMessage.payChannel;
            String str3 = currencyChargeMessage.payMethod;
            j.a.a.e.o.b.d(this.f64691i, currencyChargeMessage.usedChannel, this.f64693k == PayFlowType.WALLET_PAY_FLOW ? "14" : "7", str2, str3, String.valueOf(i2));
            String str4 = this.a;
            RLog.info(str4, "statisticOnCurrencyChargeMessage payChannel:" + str2 + " payMethod:" + str3);
        }
    }

    public void F(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, dialog, iYYPayWayView, bVar, currencyChargeMessage) == null) {
            boolean z = false;
            boolean z2 = currencyChargeMessage.status == 1;
            if (j.a.a.e.p.q.a.a(activity)) {
                IYYPayResultView.b bVar2 = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                if ((z2 && (bVar != null && bVar.f65387d)) ? true : true) {
                    D(activity, currencyChargeMessage, dialog, bVar2, iYYPayWayView, bVar);
                } else {
                    j.a.a.e.p.h.b(dialog, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    @Override // j.a.a.e.m.f
    public void a(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, bVar, iPayCallback) == null) {
            IAppPayService b2 = j.a.a.e.p.b.b(this.f64691i, this.f64692j);
            if (b2 == null) {
                RLog.error(this.a, "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            bVar.f65389f = this.f64693k;
            IYYPayWayView e2 = this.f64690h.e(activity, bVar, this.m);
            e2.refreshView();
            Dialog w = w(activity, e2, b2, bVar != null ? bVar.f65388e : null);
            IYYPayWayView.b bVar2 = bVar;
            e2.setCallback(new j.a.a.e.m.r.l(activity, w, e2, bVar2, iPayCallback, this));
            A(activity, w, e2, bVar2, iPayCallback);
            RLog.debug(this.a, "showPayWayDialog addPayListener");
        }
    }

    @Override // j.a.a.e.m.f
    public void b(int i2, String str, PayCallBackBean payCallBackBean) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i2, str, payCallBackBean) == null) || (kVar = this.f64687e) == null) {
            return;
        }
        kVar.a(i2, str, payCallBackBean);
    }

    @Override // j.a.a.e.m.f
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

    @Override // j.a.a.e.m.f
    public void d(Activity activity, j.a.a.e.n.f fVar, j.a.a.e.n.c cVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, fVar, cVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            RLog.info(this.a, " requestPayInternal");
            j.a.a.e.m.r.h hVar = new j.a.a.e.m.r.h(this.f64691i, this.f64692j, iPayCallback, activity, dialog, iYYPayWayView, this, fVar, bVar, this);
            this.f64688f = TraceIdUtil.newTraceId();
            String str = this.a;
            RLog.info(str, " requestPayInternal new mTraceId:" + this.f64688f);
            this.f64689g.a(activity, this.f64693k, fVar, cVar, appCustomExpand, hVar, this.f64688f);
        }
    }

    @Override // j.a.a.e.m.f
    public void e(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, activity, iPayCallback, viewParams) == null) {
            RLog.info(this.a, "showPayAmountDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            if (t(activity, absViewEventHandler) && !x(activity, iPayCallback, viewParams)) {
                IYYPayAmountView a2 = this.f64690h.a(activity, viewParams, this.m);
                a2.refreshView();
                a2.setCallback(new j.a.a.e.m.r.c(this.f64691i, this.f64692j, u(activity, a2, absViewEventHandler, viewParams), viewParams, activity, iPayCallback, this));
            }
        }
    }

    @Override // j.a.a.e.m.h
    public void f(Activity activity, j.a.a.e.n.f fVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, activity, fVar, dialog, iYYPayWayView) == null) {
            String str = this.a;
            RLog.info(str, "updateViewOnPaySuccess mPayFlowType" + this.f64693k.name());
            if (this.l == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
            } else {
                B(new d(this, activity, fVar, dialog, iYYPayWayView));
            }
        }
    }

    @Override // j.a.a.e.m.f
    public void g(Activity activity, j.a.a.e.n.c cVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048588, this, activity, cVar, list, viewParams, iPayCallback) == null) {
            RLog.info(this.a, "showPayWayDialog");
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.f65385b = cVar;
            bVar.a = list;
            if (viewParams != null) {
                bVar.f65386c = viewParams.appCustomExpand;
                bVar.f65387d = viewParams.closeOnSuccess;
                bVar.f65388e = viewParams.viewEventListener;
            }
            a(activity, bVar, iPayCallback);
        }
    }

    @Override // j.a.a.e.m.f
    public void h(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, absViewEventHandler, payDialogType) == null) {
            String name = payDialogType != null ? payDialogType.name() : StringUtil.NULL_STRING;
            String str = this.a;
            RLog.info(str, "notifyPayFlowChange payDialogType:" + name);
            this.l = payDialogType;
            j.a.a.e.a.c(this.f64691i, this.f64692j, this.f64693k, payDialogType);
            if (absViewEventHandler != null && payDialogType != null) {
                absViewEventHandler.onViewStateChange(payDialogType);
            } else {
                RLog.debug(this.a, "notifyPayFlowChange null");
            }
        }
    }

    @Override // j.a.a.e.m.f
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f64688f = null;
            IAppPayService b2 = j.a.a.e.p.b.b(this.f64691i, this.f64692j);
            if (b2 == null) {
                RLog.error(this.a, "unregisterPayServiceListener null appPayService", new Object[0]);
            } else if (this.f64686d != null) {
                RLog.info(this.a, "unregisterPayServiceListener");
                b2.removePayListener(this.f64686d);
                this.f64686d = null;
            }
        }
    }

    @Override // j.a.a.e.m.f
    public void j(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, activity, list, viewParams, iPayCallback) == null) {
            RLog.info(this.a, "showInputDialog");
            AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
            h(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
            j.a.a.e.q.g.e.a.f(activity, new j.a.a.e.m.r.b(this, absViewEventHandler, this.f64685c, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f64685c, this.f64693k);
        }
    }

    @Override // j.a.a.e.m.f
    public boolean k(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, activity, iYYPayResultView, absViewEventHandler)) == null) {
            if (this.m.b(activity, new j.a.a.e.m.r.f(), this, absViewEventHandler)) {
                RLog.info(this.a, "showPayGiftDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // j.a.a.e.m.h
    public void l(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048593, this, activity, dialog, iYYPayWayView, purchaseStatus) == null) {
            String str = this.a;
            RLog.info(str, "updateViewOnPayStatus  mPayFlowType" + this.f64693k.name());
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

    @Override // j.a.a.e.m.f
    public boolean m(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, activity, iYYPayWayView, absViewEventHandler)) == null) {
            if (this.m.e(activity, new j.a.a.e.m.r.d(iYYPayWayView), this, absViewEventHandler)) {
                RLog.info(this.a, "showConfirmFinishDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // j.a.a.e.m.f
    public PayDialogType n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l : (PayDialogType) invokeV.objValue;
    }

    @Override // j.a.a.e.m.h
    public void o(int i2, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), str, activity, dialog, iYYPayWayView, bVar}) == null) {
            String str2 = this.a;
            RLog.info(str2, "updateViewOnPayFail mPayFlowType" + this.f64693k.name());
            if (this.l == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
            } else if (i2 == PayStatus.CANCEL.getCode()) {
                String str3 = this.a;
                RLog.info(str3, "updateViewOnPayFail 用户取消支付 code:" + i2);
                B(new b(this, activity, dialog, iYYPayWayView));
            } else {
                B(new c(this, activity, i2, str, bVar, dialog));
            }
        }
    }

    @Override // j.a.a.e.m.f
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
            String string = activity.getString(j.a.a.e.h.pay_ui_dialog_title);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            String str = string;
            h(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            return j.a.a.e.q.g.a.f64805b.d(activity, str, iYYPayAmountView.getContentView(), new j.a.a.e.m.r.a(this.f64691i, this.f64692j, this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG, this.f64693k);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    public final Dialog v(Activity activity, IYYPayResultView.c cVar, IYYPayResultView iYYPayResultView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, activity, cVar, iYYPayResultView)) == null) {
            RLog.info(this.a, "createPayResultDialog");
            AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f65384b : null;
            h(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
            return j.a.a.e.q.g.a.f64805b.d(activity, activity.getString(j.a.a.e.h.pay_ui_dialog_pay_title), iYYPayResultView.getContentView(), new j.a.a.e.m.r.i(absViewEventHandler, this, activity, iYYPayResultView), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG, this.f64693k);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final Dialog w(Activity activity, IYYPayWayView iYYPayWayView, IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048601, this, activity, iYYPayWayView, iAppPayService, absViewEventHandler)) == null) {
            RLog.info(this.a, "createPayWayDialog");
            h(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            return j.a.a.e.q.g.a.f64805b.d(activity, activity.getString(j.a.a.e.h.pay_ui_dialog_pay_title), iYYPayWayView.getContentView(), new j.a.a.e.m.r.k(this.f64691i, this.f64692j, activity, iYYPayWayView, absViewEventHandler, this), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG, this.f64693k);
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
                g(activity, j.a.a.e.p.b.a(viewParams.targetAmount, this.f64685c), null, viewParams, iPayCallback);
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
            if (!str.equals(this.f64688f)) {
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
                j.a.a.e.q.g.a.f64805b.e(dialog);
            } else {
                j.a.a.e.q.g.a.f64805b.b(dialog);
            }
        }
    }
}
