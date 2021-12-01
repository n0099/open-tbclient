package j.a.a.e.k;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import tv.athena.revenue.payui.model.H5PayFlowModel;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes3.dex */
public class n implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f64145b;

    /* renamed from: c  reason: collision with root package name */
    public j.a.a.e.l.b f64146c;

    /* renamed from: d  reason: collision with root package name */
    public l f64147d;

    /* renamed from: e  reason: collision with root package name */
    public i f64148e;

    /* renamed from: f  reason: collision with root package name */
    public PayUIKitConfig f64149f;

    /* renamed from: g  reason: collision with root package name */
    public h f64150g;

    /* renamed from: h  reason: collision with root package name */
    public H5PayFlowModel f64151h;

    /* renamed from: i  reason: collision with root package name */
    public f f64152i;

    /* renamed from: j  reason: collision with root package name */
    public b f64153j;

    public n(int i2, int i3, j.a.a.e.l.b bVar, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), bVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("YYPayController", "create YYPayController:" + this + " appId:" + i2 + " userChannel:" + i3);
        this.a = i2;
        this.f64146c = bVar;
        this.f64145b = i3;
        this.f64150g = hVar;
        this.f64149f = hVar != null ? hVar.getPayUIKitConfig() : null;
        i iVar = new i();
        this.f64148e = iVar;
        m mVar = new m(this.a, this.f64145b, this.f64146c, iVar, this.f64149f);
        this.f64152i = mVar;
        this.f64148e.c(mVar);
        this.f64153j = new j(this.a, this.f64145b, this.f64149f, this.f64146c);
    }

    @Override // j.a.a.e.k.g
    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            RLog.info("YYPayController", "startWalletActivity");
            clear();
            String c2 = j.a.a.e.l.e.c(this.f64149f);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + j.a.a.e.n.m.a(c2));
            j.a.a.e.n.f.a(this.a, this.f64145b, this.f64149f, activity, c2, "我的钱包");
            j.a.a.e.m.b.b(this.a, this.f64145b, UiEventType.walletshow);
        }
    }

    @Override // j.a.a.e.k.g
    public void b(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, iPayCallback) == null) {
            RLog.info("YYPayController", "startPayChannelDialog");
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            H5PayFlowModel h5PayFlowModel = this.f64151h;
            if (h5PayFlowModel != null) {
                bVar.f64814c = h5PayFlowModel.appCustomExpand;
                bVar.f64816e = h5PayFlowModel.viewEventListener;
                RLog.info("YYPayController", "startPayChannelDialog use H5PayFlowModel");
            }
            this.f64147d = new l(this.a, this.f64145b, this.f64150g, this.f64152i, this.f64153j, this.f64148e, PayFlowType.ACTIVITY_PAY_FLOW);
            this.f64148e.j(PayFlowType.ACTIVITY_PAY_FLOW);
            this.f64147d.D(activity, bVar, iPayCallback);
        }
    }

    @Override // j.a.a.e.k.g
    public void c(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewParams, iPayCallback) == null) {
            RLog.info("YYPayController", "startPayDialog");
            clear();
            f(viewParams);
            this.f64147d = new l(this.a, this.f64145b, this.f64150g, this.f64152i, this.f64153j, this.f64148e, PayFlowType.DIOALOG_PAY_FLOW);
            this.f64148e.j(PayFlowType.DIOALOG_PAY_FLOW);
            this.f64147d.A(activity, iPayCallback, viewParams);
            j.a.a.e.m.b.b(this.a, this.f64145b, UiEventType.purchaseshow);
        }
    }

    @Override // j.a.a.e.k.g
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RLog.info("YYPayController", "clear() :" + this);
            l lVar = this.f64147d;
            if (lVar != null) {
                lVar.q();
                this.f64147d = null;
            }
            this.f64151h = null;
        }
    }

    @Override // j.a.a.e.k.g
    public void d(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, viewParams) == null) {
            RLog.info("YYPayController", "startWalletActivity2");
            clear();
            f(viewParams);
            String c2 = j.a.a.e.l.e.c(this.f64149f);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + j.a.a.e.n.m.a(c2));
            j.a.a.e.n.f.a(this.a, this.f64145b, this.f64149f, activity, c2, "我的钱包");
            j.a.a.e.m.b.b(this.a, this.f64145b, UiEventType.walletshow);
        }
    }

    @Override // j.a.a.e.k.a
    public H5PayFlowModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64151h : (H5PayFlowModel) invokeV.objValue;
    }

    public final void f(IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewParams) == null) {
            if (viewParams != null) {
                H5PayFlowModel h5PayFlowModel = new H5PayFlowModel();
                this.f64151h = h5PayFlowModel;
                h5PayFlowModel.appCustomExpand = viewParams.appCustomExpand;
                h5PayFlowModel.viewEventListener = viewParams.viewEventListener;
                RLog.info("YYPayController", "createH5PayFlowModel  mH5PayFlowModel:" + this.f64151h);
                return;
            }
            RLog.info("YYPayController", "createH5PayFlowModel but viewParams null");
        }
    }
}
