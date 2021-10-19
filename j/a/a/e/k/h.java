package j.a.a.e.k;

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
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.YYPayAmountView;
import tv.athena.revenue.payui.view.YYPayResultView;
import tv.athena.revenue.payui.view.YYPayWayView;
/* loaded from: classes2.dex */
public class h implements j.a.a.e.k.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j.a.a.e.k.a f79503a;

    /* renamed from: b  reason: collision with root package name */
    public f f79504b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f79505c;

    /* renamed from: d  reason: collision with root package name */
    public d f79506d;

    /* renamed from: e  reason: collision with root package name */
    public H5PayFlowModel f79507e;

    /* renamed from: f  reason: collision with root package name */
    public int f79508f;

    /* renamed from: g  reason: collision with root package name */
    public int f79509g;

    /* loaded from: classes2.dex */
    public class a implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f79510a;

        public a(h hVar, IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79510a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) || (iResult = this.f79510a) == null) {
                return;
            }
            iResult.onSuccess(productListResult, payCallBackBean);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) || (iResult = this.f79510a) == null) {
                return;
            }
            iResult.onFail(i2, str, payCallBackBean);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IResult<MyBalanceResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f79511a;

        public b(h hVar, IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79511a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) || (iResult = this.f79511a) == null) {
                return;
            }
            iResult.onSuccess(myBalanceResult, payCallBackBean);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) || (iResult = this.f79511a) == null) {
                return;
            }
            iResult.onFail(i2, str, payCallBackBean);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResult f79512a;

        public c(h hVar, IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79512a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) || (iResult = this.f79512a) == null) {
                return;
            }
            iResult.onSuccess(bannerConfigResult, payCallBackBean);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) || (iResult = this.f79512a) == null) {
                return;
            }
            iResult.onFail(i2, str, payCallBackBean);
        }
    }

    public h(int i2, int i3, j.a.a.e.k.a aVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), aVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79508f = i2;
        this.f79503a = aVar;
        this.f79509g = i3;
        this.f79506d = dVar;
        this.f79505c = dVar != null ? dVar.getPayUIKitConfig() : null;
        RLog.info("YYPayController", "new YYPayController mAppId:" + i2 + " mUserChannel:" + i3);
    }

    @Override // j.a.a.e.k.c
    public void a(Activity activity, j.a.a.e.l.c cVar, j.a.a.e.l.a aVar, AppCustomExpand appCustomExpand, IPayCallback iPayCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, cVar, aVar, appCustomExpand, iPayCallback, str}) == null) {
            j.a.a.e.k.a aVar2 = this.f79503a;
            if (aVar2 == null) {
                RLog.error("YYPayController", "payRequest error modelProvider null", new Object[0]);
                return;
            }
            j.a.a.b.b.a.a d2 = aVar2.d();
            d2.r(iPayCallback);
            d2.p(activity);
            d2.u(aVar.f79513a);
            d2.v(cVar.f79520a);
            d2.q(appCustomExpand);
            d2.z(str);
            PayType payType = cVar.f79520a;
            if (payType == PayType.DXM_PAY_KJ || payType == PayType.UNION_PAY) {
                d2.w(j.a.a.e.l.b.b(this.f79505c));
            }
            IMiddleRevenue middleRevenue = RevenueManager.instance().getMiddleRevenue(this.f79508f, this.f79509g);
            if (middleRevenue != null && middleRevenue.getMiddlePayService() != null) {
                middleRevenue.getMiddlePayService().a(d2);
            } else {
                RLog.error("YYPayController", "requestPay error middleRevenue null", new Object[0]);
            }
        }
    }

    @Override // j.a.a.e.k.c
    public IYYPayWayView b(Activity activity, IYYPayWayView.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar)) == null) ? new YYPayWayView(activity, this.f79508f, this.f79509g, bVar, this.f79503a, this) : (IYYPayWayView) invokeLL.objValue;
    }

    @Override // j.a.a.e.k.c
    public IYYPayResultView c(Activity activity, IYYPayResultView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, cVar)) == null) ? new YYPayResultView(activity, this, this.f79503a, this.f79508f, this.f79509g, cVar) : (IYYPayResultView) invokeLL.objValue;
    }

    @Override // j.a.a.e.k.c
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RLog.info("YYPayController", "clear()");
            this.f79504b = null;
            this.f79507e = null;
        }
    }

    @Override // j.a.a.e.k.c
    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            clear();
            String c2 = j.a.a.e.l.b.c(this.f79505c);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + c2);
            j(activity, c2, "我的钱包");
        }
    }

    @Override // j.a.a.e.k.c
    public void e(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, bVar, iPayCallback) == null) {
            if (this.f79507e != null) {
                if (bVar == null) {
                    bVar = new IYYPayWayView.b();
                }
                H5PayFlowModel h5PayFlowModel = this.f79507e;
                bVar.f80297c = h5PayFlowModel.appCustomExpand;
                bVar.f80299e = h5PayFlowModel.viewEventListener;
                bVar.f80300f = PaySource.WALLET;
                RLog.info("YYPayController", "startPayChannelDialog use H5PayFlowModel");
            }
            f fVar = new f(this.f79508f, this.f79509g, this.f79506d, this, PayFlowType.ACTIVITY_PAY_FLOW);
            this.f79504b = fVar;
            fVar.A(activity, bVar, iPayCallback);
        }
    }

    @Override // j.a.a.e.k.c
    public void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, viewParams, iPayCallback) == null) {
            clear();
            l(viewParams);
            f fVar = new f(this.f79508f, this.f79509g, this.f79506d, this, PayFlowType.DIOALOG_PAY_FLOW);
            this.f79504b = fVar;
            fVar.w(activity, iPayCallback, viewParams);
            j.a.a.e.m.a.b(this.f79508f, this.f79509g, UiEventType.purchaseshow);
            RLog.warn("YYPayController", UiEventType.purchaseshow);
        }
    }

    @Override // j.a.a.e.k.c
    public void g(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, viewParams) == null) {
            clear();
            l(viewParams);
            String c2 = j.a.a.e.l.b.c(this.f79505c);
            RLog.info("YYPayController", "startWalletActivity walletUrl:" + c2);
            j(activity, c2, "我的钱包");
        }
    }

    @Override // j.a.a.e.k.c
    public PayUIKitConfig getPayUIKitConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f79505c : (PayUIKitConfig) invokeV.objValue;
    }

    @Override // j.a.a.e.k.c
    public void h(GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, getBannerConfigReqParams, iResult) == null) {
            IAppPayService a2 = j.a.a.e.n.b.a(getBannerConfigReqParams.getAppId(), getBannerConfigReqParams.getUsedChannel());
            if (a2 != null) {
                a2.queryBannerConfigRequest(getBannerConfigReqParams, new c(this, iResult));
            } else {
                RLog.error("YYPayController", "queryBannerConfig null appPayService", new Object[0]);
            }
        }
    }

    @Override // j.a.a.e.k.c
    public IYYPayAmountView i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, activity, viewParams)) == null) ? new YYPayAmountView(activity, this.f79508f, this.f79509g, this, viewParams, this.f79503a) : (IYYPayAmountView) invokeLL.objValue;
    }

    @Override // j.a.a.e.k.c
    public void j(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, activity, str, str2) == null) {
            PayUIKitConfig payUIKitConfig = this.f79505c;
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                if (TextUtils.isEmpty(str)) {
                    RLog.error("YYPayController", "startActivity error url null", new Object[0]);
                    return;
                }
                str2 = (str2 == null || str2.isEmpty()) ? "" : "";
                Intent intent = new Intent(activity, PayCommonWebActivity.class);
                intent.putExtra(H5PayConstant.EXTRA_TITLE, str2);
                intent.putExtra(H5PayConstant.EXTRA_URL, str);
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.f79508f);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.f79509g);
                if (str.equals(j.a.a.e.l.b.c(this.f79505c))) {
                    RLog.debug("YYPayController", "startPayWebActivity is wallet");
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 1);
                }
                activity.startActivity(intent);
            }
            j.a.a.e.m.a.b(this.f79508f, this.f79509g, UiEventType.walletshow);
            RLog.info("YYPayController", UiEventType.walletshow);
        }
    }

    @Override // j.a.a.e.k.c
    public H5PayFlowModel k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f79507e : (H5PayFlowModel) invokeV.objValue;
    }

    public final void l(IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, viewParams) == null) || viewParams == null) {
            return;
        }
        H5PayFlowModel h5PayFlowModel = new H5PayFlowModel();
        this.f79507e = h5PayFlowModel;
        h5PayFlowModel.appCustomExpand = viewParams.appCustomExpand;
        h5PayFlowModel.viewEventListener = viewParams.viewEventListener;
        RLog.info("YYPayController", "createH5PayFlowModel  H5PayFlowModel");
    }

    @Override // j.a.a.e.k.c
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, queryCurrencyReqParams, iResult) == null) {
            IAppPayService a2 = j.a.a.e.n.b.a(queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel());
            if (a2 != null) {
                a2.queryMyBalance(queryCurrencyReqParams, new b(this, iResult));
            } else {
                RLog.error("YYPayController", "queryMyBalance null appPayService", new Object[0]);
            }
        }
    }

    @Override // j.a.a.e.k.c
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, queryCurrencyReqParams, iResult) == null) {
            IAppPayService a2 = j.a.a.e.n.b.a(queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel());
            if (a2 != null) {
                a2.queryProductList(queryCurrencyReqParams, new a(this, iResult));
            } else {
                RLog.error("YYPayController", "queryProductList null appPayService", new Object[0]);
            }
        }
    }
}
