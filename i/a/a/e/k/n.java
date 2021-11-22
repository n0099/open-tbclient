package i.a.a.e.k;

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
/* loaded from: classes2.dex */
public class n implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f73207a;

    /* renamed from: b  reason: collision with root package name */
    public int f73208b;

    /* renamed from: c  reason: collision with root package name */
    public i.a.a.e.l.b f73209c;

    /* renamed from: d  reason: collision with root package name */
    public l f73210d;

    /* renamed from: e  reason: collision with root package name */
    public i f73211e;

    /* renamed from: f  reason: collision with root package name */
    public PayUIKitConfig f73212f;

    /* renamed from: g  reason: collision with root package name */
    public h f73213g;

    /* renamed from: h  reason: collision with root package name */
    public H5PayFlowModel f73214h;

    /* renamed from: i  reason: collision with root package name */
    public f f73215i;
    public b j;

    public n(int i2, int i3, i.a.a.e.l.b bVar, h hVar) {
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
        this.f73207a = i2;
        this.f73209c = bVar;
        this.f73208b = i3;
        this.f73213g = hVar;
        this.f73212f = hVar != null ? hVar.getPayUIKitConfig() : null;
        i iVar = new i();
        this.f73211e = iVar;
        m mVar = new m(this.f73207a, this.f73208b, this.f73209c, iVar, this.f73212f);
        this.f73215i = mVar;
        this.f73211e.c(mVar);
        this.j = new j(this.f73207a, this.f73208b, this.f73212f, this.f73209c);
    }

    @Override // i.a.a.e.k.g
    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            RLog.info("YYPayController", "startWalletActivity");
            clear();
            String c2 = i.a.a.e.l.e.c(this.f73212f);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + i.a.a.e.n.m.a(c2));
            i.a.a.e.n.f.a(this.f73207a, this.f73208b, this.f73212f, activity, c2, "我的钱包");
            i.a.a.e.m.b.b(this.f73207a, this.f73208b, UiEventType.walletshow);
        }
    }

    @Override // i.a.a.e.k.g
    public void b(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, iPayCallback) == null) {
            RLog.info("YYPayController", "startPayChannelDialog");
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            H5PayFlowModel h5PayFlowModel = this.f73214h;
            if (h5PayFlowModel != null) {
                bVar.f74052c = h5PayFlowModel.appCustomExpand;
                bVar.f74054e = h5PayFlowModel.viewEventListener;
                RLog.info("YYPayController", "startPayChannelDialog use H5PayFlowModel");
            }
            this.f73210d = new l(this.f73207a, this.f73208b, this.f73213g, this.f73215i, this.j, this.f73211e, PayFlowType.ACTIVITY_PAY_FLOW);
            this.f73211e.j(PayFlowType.ACTIVITY_PAY_FLOW);
            this.f73210d.D(activity, bVar, iPayCallback);
        }
    }

    @Override // i.a.a.e.k.g
    public void c(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewParams, iPayCallback) == null) {
            RLog.info("YYPayController", "startPayDialog");
            clear();
            f(viewParams);
            this.f73210d = new l(this.f73207a, this.f73208b, this.f73213g, this.f73215i, this.j, this.f73211e, PayFlowType.DIOALOG_PAY_FLOW);
            this.f73211e.j(PayFlowType.DIOALOG_PAY_FLOW);
            this.f73210d.A(activity, iPayCallback, viewParams);
            i.a.a.e.m.b.b(this.f73207a, this.f73208b, UiEventType.purchaseshow);
        }
    }

    @Override // i.a.a.e.k.g
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RLog.info("YYPayController", "clear() :" + this);
            l lVar = this.f73210d;
            if (lVar != null) {
                lVar.q();
                this.f73210d = null;
            }
            this.f73214h = null;
        }
    }

    @Override // i.a.a.e.k.g
    public void d(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, viewParams) == null) {
            RLog.info("YYPayController", "startWalletActivity2");
            clear();
            f(viewParams);
            String c2 = i.a.a.e.l.e.c(this.f73212f);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + i.a.a.e.n.m.a(c2));
            i.a.a.e.n.f.a(this.f73207a, this.f73208b, this.f73212f, activity, c2, "我的钱包");
            i.a.a.e.m.b.b(this.f73207a, this.f73208b, UiEventType.walletshow);
        }
    }

    @Override // i.a.a.e.k.a
    public H5PayFlowModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f73214h : (H5PayFlowModel) invokeV.objValue;
    }

    public final void f(IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewParams) == null) {
            if (viewParams != null) {
                H5PayFlowModel h5PayFlowModel = new H5PayFlowModel();
                this.f73214h = h5PayFlowModel;
                h5PayFlowModel.appCustomExpand = viewParams.appCustomExpand;
                h5PayFlowModel.viewEventListener = viewParams.viewEventListener;
                RLog.info("YYPayController", "createH5PayFlowModel  mH5PayFlowModel:" + this.f73214h);
                return;
            }
            RLog.info("YYPayController", "createH5PayFlowModel but viewParams null");
        }
    }
}
