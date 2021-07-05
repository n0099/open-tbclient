package i.a.a.e.k;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.model.H5PayFlowModel;
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.YYPayAmountView;
import tv.athena.revenue.payui.view.YYPayResultView;
import tv.athena.revenue.payui.view.YYPayWayView;
/* loaded from: classes10.dex */
public class g implements i.a.a.e.k.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.a f75838a;

    /* renamed from: b  reason: collision with root package name */
    public e f75839b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f75840c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.k.c f75841d;

    /* renamed from: e  reason: collision with root package name */
    public H5PayFlowModel f75842e;

    /* renamed from: f  reason: collision with root package name */
    public int f75843f;

    /* renamed from: g  reason: collision with root package name */
    public int f75844g;

    /* loaded from: classes10.dex */
    public class a implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f75845a;

        public a(g gVar, IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75845a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) || (iResult = this.f75845a) == null) {
                return;
            }
            iResult.onSuccess(productListResult, payCallBackBean);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) || (iResult = this.f75845a) == null) {
                return;
            }
            iResult.onFail(i2, str, payCallBackBean);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements IResult<MyBalanceResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f75846a;

        public b(g gVar, IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75846a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) || (iResult = this.f75846a) == null) {
                return;
            }
            iResult.onSuccess(myBalanceResult, payCallBackBean);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) || (iResult = this.f75846a) == null) {
                return;
            }
            iResult.onFail(i2, str, payCallBackBean);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f75847a;

        public c(g gVar, IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75847a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) || (iResult = this.f75847a) == null) {
                return;
            }
            iResult.onSuccess(bannerConfigResult, payCallBackBean);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) || (iResult = this.f75847a) == null) {
                return;
            }
            iResult.onFail(i2, str, payCallBackBean);
        }
    }

    public g(int i2, int i3, i.a.a.e.k.a aVar, i.a.a.e.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75843f = i2;
        this.f75838a = aVar;
        this.f75844g = i3;
        this.f75841d = cVar;
        this.f75840c = cVar != null ? cVar.getPayUIKitConfig() : null;
        RLog.info("YYPayController", "new YYPayController mAppId:" + i2 + " mUserChannel:" + i3);
    }

    @Override // i.a.a.e.k.b
    public void a(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand, IPayCallback iPayCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, cVar, aVar, appCustomExpand, iPayCallback, str}) == null) {
            i.a.a.e.k.a aVar2 = this.f75838a;
            if (aVar2 == null) {
                RLog.error("YYPayController", "payRequest error modelProvider null", new Object[0]);
                return;
            }
            i.a.a.b.b.a.a d2 = aVar2.d();
            d2.r(iPayCallback);
            d2.p(activity);
            d2.u(aVar.f75848a);
            d2.v(cVar.f75855a);
            d2.q(appCustomExpand);
            d2.z(str);
            if (cVar.f75855a == PayType.DXM_PAY_KJ) {
                d2.w(i.a.a.e.l.b.b(this.f75840c));
            }
            IMiddleRevenue middleRevenue = RevenueManager.instance().getMiddleRevenue(this.f75843f, this.f75844g);
            if (middleRevenue != null && middleRevenue.getMiddlePayService() != null) {
                middleRevenue.getMiddlePayService().a(d2);
            } else {
                RLog.error("YYPayController", "requestPay error middleRevenue null", new Object[0]);
            }
        }
    }

    @Override // i.a.a.e.k.b
    public IYYPayWayView b(Activity activity, IYYPayWayView.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar)) == null) ? new YYPayWayView(activity, this.f75843f, this.f75844g, bVar, this.f75838a, this) : (IYYPayWayView) invokeLL.objValue;
    }

    @Override // i.a.a.e.k.b
    public IYYPayResultView c(Activity activity, IYYPayResultView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, cVar)) == null) ? new YYPayResultView(activity, this, this.f75838a, this.f75843f, this.f75844g, cVar) : (IYYPayResultView) invokeLL.objValue;
    }

    @Override // i.a.a.e.k.b
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f75839b = null;
            this.f75842e = null;
            RLog.info("YYPayController", "clear() destory H5PayFlowModel");
        }
    }

    @Override // i.a.a.e.k.b
    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            clear();
            String c2 = i.a.a.e.l.b.c(this.f75840c);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + c2);
            j(activity, c2, "我的钱包");
        }
    }

    @Override // i.a.a.e.k.b
    public void e(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, bVar, iPayCallback) == null) {
            if (this.f75842e != null) {
                if (bVar == null) {
                    bVar = new IYYPayWayView.b();
                }
                H5PayFlowModel h5PayFlowModel = this.f75842e;
                bVar.f76702c = h5PayFlowModel.appCustomExpand;
                bVar.f76704e = h5PayFlowModel.viewEventListener;
                bVar.f76705f = PaySource.WALLET;
                RLog.info("YYPayController", "startPayChannelDialog use H5PayFlowModel");
            }
            e eVar = new e(this.f75843f, this.f75844g, this.f75841d, this);
            this.f75839b = eVar;
            eVar.A(activity, bVar, iPayCallback);
        }
    }

    @Override // i.a.a.e.k.b
    public void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, viewParams, iPayCallback) == null) {
            clear();
            l(viewParams);
            e eVar = new e(this.f75843f, this.f75844g, this.f75841d, this);
            this.f75839b = eVar;
            eVar.w(activity, iPayCallback, viewParams);
            i.a.a.e.m.a.b(this.f75843f, this.f75844g, UiEventType.purchaseshow);
            RLog.warn("YYPayController", UiEventType.purchaseshow);
        }
    }

    @Override // i.a.a.e.k.b
    public void g(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, viewParams) == null) {
            clear();
            l(viewParams);
            String c2 = i.a.a.e.l.b.c(this.f75840c);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + c2);
            j(activity, c2, "我的钱包");
        }
    }

    @Override // i.a.a.e.k.b
    public PayUIKitConfig getPayUIKitConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f75840c : (PayUIKitConfig) invokeV.objValue;
    }

    @Override // i.a.a.e.k.b
    public void h(GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, getBannerConfigReqParams, iResult) == null) {
            IAppPayService a2 = i.a.a.e.n.a.a(getBannerConfigReqParams.getAppId(), getBannerConfigReqParams.getUsedChannel());
            if (a2 != null) {
                a2.queryBannerConfigRequest(getBannerConfigReqParams, new c(this, iResult));
            } else {
                RLog.error("YYPayController", "queryBannerConfig null appPayService", new Object[0]);
            }
        }
    }

    @Override // i.a.a.e.k.b
    public IYYPayAmountView i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, activity, viewParams)) == null) ? new YYPayAmountView(activity, this.f75843f, this.f75844g, this, viewParams, this.f75838a) : (IYYPayAmountView) invokeLL.objValue;
    }

    @Override // i.a.a.e.k.b
    public void j(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, activity, str, str2) == null) {
            PayUIKitConfig payUIKitConfig = this.f75840c;
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                if (TextUtils.isEmpty(str)) {
                    RLog.error("YYPayController", "startActivity error url null", new Object[0]);
                    return;
                }
                str2 = (str2 == null || str2.isEmpty()) ? "" : "";
                Intent intent = new Intent(activity, PayCommonWebActivity.class);
                intent.putExtra(H5PayConstant.EXTRA_TITLE, str2);
                intent.putExtra(H5PayConstant.EXTRA_URL, str);
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.f75843f);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.f75844g);
                if (str.equals(i.a.a.e.l.b.c(this.f75840c))) {
                    RLog.debug("YYPayController", "startPayWebActivity is wallet");
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 1);
                }
                activity.startActivity(intent);
            }
            i.a.a.e.m.a.b(this.f75843f, this.f75844g, UiEventType.walletshow);
            RLog.info("YYPayController", UiEventType.walletshow);
        }
    }

    @Override // i.a.a.e.k.b
    public H5PayFlowModel k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f75842e : (H5PayFlowModel) invokeV.objValue;
    }

    public final void l(IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, viewParams) == null) || viewParams == null) {
            return;
        }
        H5PayFlowModel h5PayFlowModel = new H5PayFlowModel();
        this.f75842e = h5PayFlowModel;
        h5PayFlowModel.appCustomExpand = viewParams.appCustomExpand;
        h5PayFlowModel.viewEventListener = viewParams.viewEventListener;
        RLog.info("YYPayController", "createH5PayFlowModel  H5PayFlowModel");
    }

    @Override // i.a.a.e.k.b
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, queryCurrencyReqParams, iResult) == null) {
            IAppPayService a2 = i.a.a.e.n.a.a(queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel());
            if (a2 != null) {
                a2.queryMyBalance(queryCurrencyReqParams, new b(this, iResult));
            } else {
                RLog.error("YYPayController", "queryMyBalance null appPayService", new Object[0]);
            }
        }
    }

    @Override // i.a.a.e.k.b
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, queryCurrencyReqParams, iResult) == null) {
            IAppPayService a2 = i.a.a.e.n.a.a(queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel());
            if (a2 != null) {
                a2.queryProductList(queryCurrencyReqParams, new a(this, iResult));
            } else {
                RLog.error("YYPayController", "queryProductList null appPayService", new Object[0]);
            }
        }
    }
}
