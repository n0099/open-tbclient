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
/* loaded from: classes3.dex */
public class n implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72289a;

    /* renamed from: b  reason: collision with root package name */
    public int f72290b;

    /* renamed from: c  reason: collision with root package name */
    public i.a.a.e.l.b f72291c;

    /* renamed from: d  reason: collision with root package name */
    public l f72292d;

    /* renamed from: e  reason: collision with root package name */
    public i f72293e;

    /* renamed from: f  reason: collision with root package name */
    public PayUIKitConfig f72294f;

    /* renamed from: g  reason: collision with root package name */
    public h f72295g;

    /* renamed from: h  reason: collision with root package name */
    public H5PayFlowModel f72296h;

    /* renamed from: i  reason: collision with root package name */
    public f f72297i;
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
        this.f72289a = i2;
        this.f72291c = bVar;
        this.f72290b = i3;
        this.f72295g = hVar;
        this.f72294f = hVar != null ? hVar.getPayUIKitConfig() : null;
        i iVar = new i();
        this.f72293e = iVar;
        m mVar = new m(this.f72289a, this.f72290b, this.f72291c, iVar, this.f72294f);
        this.f72297i = mVar;
        this.f72293e.c(mVar);
        this.j = new j(this.f72289a, this.f72290b, this.f72294f, this.f72291c);
    }

    @Override // i.a.a.e.k.g
    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            RLog.info("YYPayController", "startWalletActivity");
            clear();
            String c2 = i.a.a.e.l.e.c(this.f72294f);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + i.a.a.e.n.m.a(c2));
            i.a.a.e.n.f.a(this.f72289a, this.f72290b, this.f72294f, activity, c2, "我的钱包");
            i.a.a.e.m.b.b(this.f72289a, this.f72290b, UiEventType.walletshow);
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
            H5PayFlowModel h5PayFlowModel = this.f72296h;
            if (h5PayFlowModel != null) {
                bVar.f73132c = h5PayFlowModel.appCustomExpand;
                bVar.f73134e = h5PayFlowModel.viewEventListener;
                RLog.info("YYPayController", "startPayChannelDialog use H5PayFlowModel");
            }
            this.f72292d = new l(this.f72289a, this.f72290b, this.f72295g, this.f72297i, this.j, this.f72293e, PayFlowType.ACTIVITY_PAY_FLOW);
            this.f72293e.j(PayFlowType.ACTIVITY_PAY_FLOW);
            this.f72292d.D(activity, bVar, iPayCallback);
        }
    }

    @Override // i.a.a.e.k.g
    public void c(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewParams, iPayCallback) == null) {
            RLog.info("YYPayController", "startPayDialog");
            clear();
            f(viewParams);
            this.f72292d = new l(this.f72289a, this.f72290b, this.f72295g, this.f72297i, this.j, this.f72293e, PayFlowType.DIOALOG_PAY_FLOW);
            this.f72293e.j(PayFlowType.DIOALOG_PAY_FLOW);
            this.f72292d.A(activity, iPayCallback, viewParams);
            i.a.a.e.m.b.b(this.f72289a, this.f72290b, UiEventType.purchaseshow);
        }
    }

    @Override // i.a.a.e.k.g
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RLog.info("YYPayController", "clear() :" + this);
            l lVar = this.f72292d;
            if (lVar != null) {
                lVar.q();
                this.f72292d = null;
            }
            this.f72296h = null;
        }
    }

    @Override // i.a.a.e.k.g
    public void d(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, viewParams) == null) {
            RLog.info("YYPayController", "startWalletActivity2");
            clear();
            f(viewParams);
            String c2 = i.a.a.e.l.e.c(this.f72294f);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + i.a.a.e.n.m.a(c2));
            i.a.a.e.n.f.a(this.f72289a, this.f72290b, this.f72294f, activity, c2, "我的钱包");
            i.a.a.e.m.b.b(this.f72289a, this.f72290b, UiEventType.walletshow);
        }
    }

    @Override // i.a.a.e.k.a
    public H5PayFlowModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f72296h : (H5PayFlowModel) invokeV.objValue;
    }

    public final void f(IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewParams) == null) {
            if (viewParams != null) {
                H5PayFlowModel h5PayFlowModel = new H5PayFlowModel();
                this.f72296h = h5PayFlowModel;
                h5PayFlowModel.appCustomExpand = viewParams.appCustomExpand;
                h5PayFlowModel.viewEventListener = viewParams.viewEventListener;
                RLog.info("YYPayController", "createH5PayFlowModel  mH5PayFlowModel:" + this.f72296h);
                return;
            }
            RLog.info("YYPayController", "createH5PayFlowModel but viewParams null");
        }
    }
}
