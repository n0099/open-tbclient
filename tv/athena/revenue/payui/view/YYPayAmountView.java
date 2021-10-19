package tv.athena.revenue.payui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
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
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import j.a.a.e.n.h;
import j.a.a.e.n.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes2.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean A;
    public volatile boolean B;
    public int C;
    public int D;

    /* renamed from: e  reason: collision with root package name */
    public Activity f80301e;

    /* renamed from: f  reason: collision with root package name */
    public Button f80302f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80303g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80304h;

    /* renamed from: i  reason: collision with root package name */
    public View f80305i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f80306j;
    public j.a.a.e.k.a k;
    public NoScrollGridView l;
    public PluginCenterTopBanner m;
    public j.a.a.e.o.b.a n;
    public QueryCurrencyReqParams o;
    public j.a.a.e.k.c p;
    public List<j.a.a.e.l.a> q;
    public List<BannerConfigItem.BannerInfo> r;
    public IYYPayAmountView.ViewParams s;
    public MyBalanceInfo.Account t;
    public long u;
    public List<PayWayInfo> v;
    public j.a.a.e.l.a w;
    public int x;
    public IYYPayAmountView.Callback y;
    public String z;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f80307e;

        public a(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80307e = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                j.a.a.e.l.a item = this.f80307e.n.getItem(i2);
                if (item.f79515c) {
                    this.f80307e.G();
                    return;
                }
                this.f80307e.w = item;
                this.f80307e.n.d(i2);
                this.f80307e.n.notifyDataSetChanged();
                this.f80307e.K(item);
                j.a.a.e.m.a.d(this.f80307e.C, this.f80307e.D, "3", "", "", String.valueOf((this.f80307e.w == null || this.f80307e.w.f79513a == null) ? 0 : this.f80307e.w.f79513a.cid));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f80308e;

        public b(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80308e = yYPayAmountView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f80308e.y();
                j.a.a.e.m.a.d(this.f80308e.C, this.f80308e.D, "2", "", "", String.valueOf((this.f80308e.w == null || this.f80308e.w.f79513a == null) ? 0 : this.f80308e.w.f79513a.cid));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f80309e;

        public c(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80309e = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || i2 >= this.f80309e.r.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.f80309e.r.get(i2);
            RLog.debug("YYPayAmountView", "updateBanner: click=" + bannerInfo.jumpData);
            if (this.f80309e.s == null || this.f80309e.s.viewEventListener == null) {
                return;
            }
            this.f80309e.s.viewEventListener.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f80310a;

        public d(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80310a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                this.f80310a.A = false;
                this.f80310a.I(productListResult);
                this.f80310a.C();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                this.f80310a.A = false;
                RLog.error("YYPayAmountView", "queryProductList onFail code:" + i2 + " failReason:" + str, new Object[0]);
                if (i.f79529a.a(this.f80310a.f80301e) && i2 != -800) {
                    String str2 = "请求服务失败 code:" + i2 + " failReason:" + str;
                    if (i2 == -500) {
                        str2 = "网络不给力，请稍后重试";
                    }
                    Toast.makeText(this.f80310a.f80301e, str2, 1).show();
                }
                if (this.f80310a.y != null) {
                    this.f80310a.y.onRefreshViewFail(i2, str);
                }
                this.f80310a.C();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f80311e;

        public e(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80311e = yYPayAmountView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                j.a.a.e.n.a.a(String.valueOf(this.f80311e.u), this.f80311e.f80301e);
                Toast.makeText(this.f80311e.f80301e, "YY号已复制到剪贴板", 1).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements IResult<MyBalanceResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f80312a;

        public f(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80312a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) {
                this.f80312a.B = false;
                RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
                if (myBalanceResult == null) {
                    RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
                    return;
                }
                this.f80312a.u = myBalanceResult.getMyBalanceInfo() != null ? myBalanceResult.getMyBalanceInfo().getImid() : 0L;
                this.f80312a.M();
                PayUIKitConfig payUIKitConfig = this.f80312a.p.getPayUIKitConfig();
                MiddleRevenueConfig middleRevenueConfig = payUIKitConfig != null ? payUIKitConfig.revenueConfig : null;
                MyBalanceInfo.Account myBalance = middleRevenueConfig != null ? myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType()) : null;
                if (myBalance != null) {
                    this.f80312a.t = myBalance;
                    this.f80312a.L();
                    RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + myBalance);
                    this.f80312a.C();
                    return;
                }
                RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                this.f80312a.B = false;
                RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i2 + " failReason:" + str, new Object[0]);
                this.f80312a.C();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f80313a;

        public g(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80313a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) {
                RLog.info("YYPayAmountView", "queryBannerConfig() onSuccess:" + bannerConfigResult);
                this.f80313a.r.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.f80313a.x = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f80313a.r.addAll(list);
                this.f80313a.J();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.error("YYPayAmountView", "queryBannerConfig onFail code:" + i2 + " failReason:" + str, new Object[0]);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountView(Activity activity, int i2, int i3, j.a.a.e.k.c cVar, IYYPayAmountView.ViewParams viewParams, j.a.a.e.k.a aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), cVar, viewParams, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.z = "Y币";
        this.f80301e = activity;
        this.k = aVar;
        this.p = cVar;
        this.s = viewParams;
        this.o = aVar.c();
        this.C = i2;
        this.D = i3;
        B(activity);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j.a.a.e.n.e.a(this.f80305i, this.f80306j);
        }
    }

    public final void B(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            j.a.a.e.k.c cVar = this.p;
            PayUIKitConfig payUIKitConfig = cVar != null ? cVar.getPayUIKitConfig() : null;
            LayoutInflater.from(new ContextThemeWrapper(activity, h.f79528a.a(payUIKitConfig))).inflate(j.a.a.e.e.pay_ui_layout_pay_amount_view, (ViewGroup) this, true);
            this.f80303g = (TextView) findViewById(j.a.a.e.d.tv_amount);
            this.f80304h = (TextView) findViewById(j.a.a.e.d.tv_yy);
            j.a.a.e.o.b.a aVar = new j.a.a.e.o.b.a(this.f80301e, this.q, payUIKitConfig);
            this.n = aVar;
            aVar.c(this.z);
            NoScrollGridView noScrollGridView = (NoScrollGridView) findViewById(j.a.a.e.d.grid_recharge_amount);
            this.l = noScrollGridView;
            noScrollGridView.setSelector(j.a.a.e.c.pay_ui_selector_transparent);
            this.l.setAdapter((ListAdapter) this.n);
            this.l.setOnItemClickListener(new a(this));
            Button button = (Button) findViewById(j.a.a.e.d.btn_confirm_recharge);
            this.f80302f = button;
            button.setOnClickListener(new b(this));
            K(this.n.b());
            this.m = (PluginCenterTopBanner) findViewById(j.a.a.e.d.banner);
            j.a.a.e.k.c cVar2 = this.p;
            if (cVar2 != null && cVar2.getPayUIKitConfig() != null) {
                this.m.setImageLoaderSupplier(this.p.getPayUIKitConfig().imageLoaderSupplier);
            }
            this.f80305i = findViewById(j.a.a.e.d.root_loading);
            this.f80306j = (ImageView) findViewById(j.a.a.e.d.iv_loading_circle);
            j.a.a.e.m.a.d(this.C, this.D, "1", "", "", "");
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.A || this.B) {
            return;
        }
        A();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.p == null) {
            return;
        }
        GetBannerConfigReqParams a2 = this.k.a();
        if (a2 == null) {
            RLog.error("YYPayAmountView", "queryBannerConfig error reqParams null", new Object[0]);
            return;
        }
        a2.setTypes(new int[]{1});
        RLog.info("YYPayAmountView", "queryBannerConfig: " + a2);
        this.p.h(a2, new g(this));
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.p == null) {
            return;
        }
        QueryCurrencyReqParams b2 = this.k.b();
        if (b2 == null) {
            RLog.error("YYPayAmountView", "queryMyBalance error reqParams null", new Object[0]);
            return;
        }
        this.B = true;
        this.p.queryMyBalance(b2, new f(this));
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.p == null) {
            return;
        }
        this.A = true;
        this.p.queryProductList(this.o, new d(this));
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<PayWayInfo> list = this.v;
            if (list == null) {
                RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.y;
            if (callback != null) {
                callback.showInputNumberDialog(this.f80301e, list);
            }
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j.a.a.e.n.e.b(this.f80305i, this.f80306j);
        }
    }

    public final void I(ProductListResult productListResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, productListResult) == null) {
            if (productListResult == null) {
                RLog.error("YYPayAmountView", "showProductListView null", new Object[0]);
            } else if (this.l != null && this.n != null) {
                String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
                this.z = currencyName;
                this.n.c(currencyName);
                List<ProductInfo> productInfoList = productListResult.getProductInfoList();
                if (productInfoList != null && productInfoList.size() != 0) {
                    this.q.clear();
                    int i2 = 0;
                    for (int i3 = 0; i3 < productInfoList.size(); i3++) {
                        j.a.a.e.l.a aVar = new j.a.a.e.l.a(productInfoList.get(i3), productListResult.getCurrencyType());
                        if (aVar.a() == 10.0d) {
                            i2 = i3;
                        }
                        this.q.add(aVar);
                    }
                    if (this.q.size() < 6) {
                        this.q.add(new j.a.a.e.l.a(true));
                    }
                    this.l.setNumColumns(z(this.n.getCount()));
                    this.n.notifyDataSetChanged();
                    List<PayWayInfo> payWayInfoList = productListResult.getPayWayInfoList();
                    this.v = payWayInfoList;
                    if (payWayInfoList != null) {
                        Iterator<PayWayInfo> it = payWayInfoList.iterator();
                        while (it.hasNext()) {
                            RLog.debug("YYPayAmountView", "payWayInfo-> " + it.next());
                        }
                    }
                    this.w = this.q.get(i2);
                    this.n.d(i2);
                    this.n.notifyDataSetChanged();
                    K(this.n.b());
                    j.a.a.e.l.b.f79516a = productListResult.getPaysSettingInfo();
                    return;
                }
                RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            RLog.debug("YYPayAmountView", "updateBanner: count=" + this.r.size());
            if (this.r.size() == 0) {
                this.m.setVisibility(8);
                return;
            }
            int i2 = this.x;
            if (i2 > 0) {
                this.m.setFlipInterval(i2);
            }
            this.m.setData(this.r);
            this.m.setOnItemClickListener(new c(this));
            this.m.setVisibility(0);
        }
    }

    public final void K(j.a.a.e.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (this.f80302f == null) {
                RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
            } else if (aVar == null) {
                RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
            } else {
                this.f80302f.setText("立即充值" + j.a.a.e.n.g.a(aVar.b().doubleValue()) + "元");
            }
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void L() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.t == null) {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
            } else if (this.f80303g != null && (activity = this.f80301e) != null && !activity.isFinishing()) {
                String str = null;
                MyBalanceInfo.Account account = this.t;
                int i2 = account.currencyType;
                String a2 = j.a.a.e.n.g.a(account.amount / 100.0d);
                IYYPayAmountView.ViewParams viewParams = this.s;
                if (viewParams != null) {
                    int i3 = viewParams.targetAmount;
                    long j2 = this.t.amount;
                    if (i3 > j2) {
                        str = j.a.a.e.n.g.a((i3 - j2) / 100.0d);
                    }
                }
                this.f80303g.setVisibility(0);
                if (str == null) {
                    if (i2 == 4) {
                        this.f80303g.setText(String.format(this.f80301e.getString(j.a.a.e.f.pay_ui_str_wallet_amount), a2));
                        return;
                    } else {
                        this.f80303g.setText(String.format(this.f80301e.getString(j.a.a.e.f.pay_ui_str_wallet_amount_other), a2));
                        return;
                    }
                }
                this.f80303g.setTextColor(this.f80301e.getResources().getColor(j.a.a.e.a.pay_ui_color_FF3355));
                if (i2 == 4) {
                    this.f80303g.setText(String.format(this.f80301e.getString(j.a.a.e.f.pay_ui_str_wallet_amount_not_enough), a2, str));
                } else {
                    this.f80303g.setText(String.format(this.f80301e.getString(j.a.a.e.f.pay_ui_str_wallet_amount_not_enough_other), a2, str));
                }
            } else {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
            }
        }
    }

    public final void M() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (textView = this.f80304h) == null || this.u == 0) {
            return;
        }
        textView.setVisibility(0);
        this.f80304h.setText(String.format(this.f80301e.getString(j.a.a.e.f.pay_ui_yy_number), Long.valueOf(this.u)));
        this.f80304h.setOnLongClickListener(new e(this));
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, j.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, j.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            H();
            F();
            E();
            D();
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, callback) == null) {
            this.y = callback;
        }
    }

    public final void y() {
        List<PayWayInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            j.a.a.e.l.a aVar = this.w;
            if (aVar != null && (list = this.v) != null) {
                IYYPayAmountView.Callback callback = this.y;
                if (callback != null) {
                    callback.toPayWayDialog(aVar, list);
                    return;
                }
                return;
            }
            RLog.error("YYPayAmountView", "confirmRecharge data null", new Object[0]);
        }
    }

    public final int z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? i2 < 5 ? 2 : 3 : invokeI.intValue;
    }
}
