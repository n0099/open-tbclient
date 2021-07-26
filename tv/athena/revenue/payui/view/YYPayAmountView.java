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
import i.a.a.e.n.g;
import i.a.a.e.n.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes9.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;

    /* renamed from: e  reason: collision with root package name */
    public Activity f74196e;

    /* renamed from: f  reason: collision with root package name */
    public Button f74197f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f74198g;

    /* renamed from: h  reason: collision with root package name */
    public View f74199h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f74200i;
    public i.a.a.e.k.a j;
    public NoScrollGridView k;
    public PluginCenterTopBanner l;
    public i.a.a.e.o.b.a m;
    public QueryCurrencyReqParams n;
    public i.a.a.e.k.b o;
    public List<i.a.a.e.l.a> p;
    public List<BannerConfigItem.BannerInfo> q;
    public IYYPayAmountView.ViewParams r;
    public MyBalanceInfo.Account s;
    public List<PayWayInfo> t;
    public i.a.a.e.l.a u;
    public int v;
    public IYYPayAmountView.Callback w;
    public String x;
    public volatile boolean y;
    public volatile boolean z;

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f74201e;

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
            this.f74201e = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                i.a.a.e.l.a item = this.f74201e.m.getItem(i2);
                if (item.f73338c) {
                    this.f74201e.D();
                    return;
                }
                this.f74201e.u = item;
                this.f74201e.m.d(i2);
                this.f74201e.m.notifyDataSetChanged();
                this.f74201e.H(item);
                i.a.a.e.m.a.d(this.f74201e.A, this.f74201e.B, "3", "", "", String.valueOf((this.f74201e.u == null || this.f74201e.u.f73336a == null) ? 0 : this.f74201e.u.f73336a.cid));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f74202e;

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
            this.f74202e = yYPayAmountView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f74202e.v();
                i.a.a.e.m.a.d(this.f74202e.A, this.f74202e.B, "2", "", "", String.valueOf((this.f74202e.u == null || this.f74202e.u.f73336a == null) ? 0 : this.f74202e.u.f73336a.cid));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f74203e;

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
            this.f74203e = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || i2 >= this.f74203e.q.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.f74203e.q.get(i2);
            RLog.debug("YYPayAmountView", "updateBanner: click=" + bannerInfo.jumpData);
            if (this.f74203e.r == null || this.f74203e.r.viewEventListener == null) {
                return;
            }
            this.f74203e.r.viewEventListener.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f74204a;

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
            this.f74204a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                this.f74204a.y = false;
                this.f74204a.F(productListResult);
                this.f74204a.z();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                this.f74204a.y = false;
                RLog.error("YYPayAmountView", "queryProductList onFail code:" + i2 + " failReason:" + str, new Object[0]);
                if (h.f73352a.a(this.f74204a.f74196e)) {
                    String str2 = "请求服务失败 code:" + i2 + " failReason:" + str;
                    if (i2 == -500) {
                        str2 = "网络不给力，请稍后重试";
                    }
                    Toast.makeText(this.f74204a.f74196e, str2, 1).show();
                }
                if (this.f74204a.w != null) {
                    this.f74204a.w.onRefreshViewFail(i2, str);
                }
                this.f74204a.z();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements IResult<MyBalanceResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f74205a;

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
            this.f74205a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) {
                this.f74205a.z = false;
                RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
                if (myBalanceResult != null) {
                    PayUIKitConfig payUIKitConfig = this.f74205a.o.getPayUIKitConfig();
                    MiddleRevenueConfig middleRevenueConfig = payUIKitConfig != null ? payUIKitConfig.revenueConfig : null;
                    MyBalanceInfo.Account myBalance = middleRevenueConfig != null ? myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType()) : null;
                    if (myBalance != null) {
                        this.f74205a.s = myBalance;
                        this.f74205a.I();
                        RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + myBalance);
                        this.f74205a.z();
                        return;
                    }
                    RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
                    return;
                }
                RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                this.f74205a.z = false;
                RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i2 + " failReason:" + str, new Object[0]);
                this.f74205a.z();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f74206a;

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
            this.f74206a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) {
                RLog.info("YYPayAmountView", "queryBannerConfig() onSuccess:" + bannerConfigResult);
                this.f74206a.q.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.f74206a.v = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f74206a.q.addAll(list);
                this.f74206a.G();
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
    public YYPayAmountView(Activity activity, int i2, int i3, i.a.a.e.k.b bVar, IYYPayAmountView.ViewParams viewParams, i.a.a.e.k.a aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), bVar, viewParams, aVar};
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
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.x = "Y币";
        this.f74196e = activity;
        this.j = aVar;
        this.o = bVar;
        this.r = viewParams;
        this.n = aVar.c();
        this.A = i2;
        this.B = i3;
        y(activity);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.o == null) {
            return;
        }
        GetBannerConfigReqParams a2 = this.j.a();
        if (a2 == null) {
            RLog.error("YYPayAmountView", "queryBannerConfig error reqParams null", new Object[0]);
            return;
        }
        a2.setTypes(new int[]{1});
        RLog.info("YYPayAmountView", "queryBannerConfig: " + a2);
        this.o.h(a2, new f(this));
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.o == null) {
            return;
        }
        QueryCurrencyReqParams b2 = this.j.b();
        if (b2 == null) {
            RLog.error("YYPayAmountView", "queryMyBalance error reqParams null", new Object[0]);
            return;
        }
        this.z = true;
        this.o.queryMyBalance(b2, new e(this));
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.o == null) {
            return;
        }
        this.y = true;
        this.o.queryProductList(this.n, new d(this));
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            List<PayWayInfo> list = this.t;
            if (list == null) {
                RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.w;
            if (callback != null) {
                callback.showInputNumberDialog(this.f74196e, list);
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i.a.a.e.n.d.b(this.f74199h, this.f74200i);
        }
    }

    public final void F(ProductListResult productListResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, productListResult) == null) {
            if (productListResult == null) {
                RLog.error("YYPayAmountView", "showProductListView null", new Object[0]);
            } else if (this.k != null && this.m != null) {
                String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
                this.x = currencyName;
                this.m.c(currencyName);
                List<ProductInfo> productInfoList = productListResult.getProductInfoList();
                if (productInfoList != null && productInfoList.size() != 0) {
                    this.p.clear();
                    int i2 = 0;
                    for (int i3 = 0; i3 < productInfoList.size(); i3++) {
                        i.a.a.e.l.a aVar = new i.a.a.e.l.a(productInfoList.get(i3), productListResult.getCurrencyType());
                        if (aVar.a() == 10.0d) {
                            i2 = i3;
                        }
                        this.p.add(aVar);
                    }
                    if (this.p.size() < 6) {
                        this.p.add(new i.a.a.e.l.a(true));
                    }
                    this.k.setNumColumns(w(this.m.getCount()));
                    this.m.notifyDataSetChanged();
                    List<PayWayInfo> payWayInfoList = productListResult.getPayWayInfoList();
                    this.t = payWayInfoList;
                    if (payWayInfoList != null) {
                        Iterator<PayWayInfo> it = payWayInfoList.iterator();
                        while (it.hasNext()) {
                            RLog.debug("YYPayAmountView", "payWayInfo-> " + it.next());
                        }
                    }
                    this.u = this.p.get(i2);
                    this.m.d(i2);
                    this.m.notifyDataSetChanged();
                    H(this.m.b());
                    i.a.a.e.l.b.f73339a = productListResult.getPaysSettingInfo();
                    return;
                }
                RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RLog.debug("YYPayAmountView", "updateBanner: count=" + this.q.size());
            if (this.q.size() == 0) {
                this.l.setVisibility(8);
                return;
            }
            int i2 = this.v;
            if (i2 > 0) {
                this.l.setFlipInterval(i2);
            }
            this.l.setData(this.q);
            this.l.setOnItemClickListener(new c(this));
            this.l.setVisibility(0);
        }
    }

    public final void H(i.a.a.e.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            if (this.f74197f == null) {
                RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
            } else if (aVar == null) {
                RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
            } else {
                this.f74197f.setText("立即充值" + i.a.a.e.n.f.a(aVar.b().doubleValue()) + "元");
            }
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void I() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.s == null) {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
            } else if (this.f74198g != null && (activity = this.f74196e) != null && !activity.isFinishing()) {
                String str = null;
                MyBalanceInfo.Account account = this.s;
                int i2 = account.currencyType;
                String a2 = i.a.a.e.n.f.a(account.amount / 100.0d);
                IYYPayAmountView.ViewParams viewParams = this.r;
                if (viewParams != null) {
                    int i3 = viewParams.targetAmount;
                    long j = this.s.amount;
                    if (i3 > j) {
                        str = i.a.a.e.n.f.a((i3 - j) / 100.0d);
                    }
                }
                this.f74198g.setVisibility(0);
                if (str == null) {
                    if (i2 == 4) {
                        this.f74198g.setText(String.format(this.f74196e.getString(i.a.a.e.f.pay_ui_str_wallet_amount), a2));
                        return;
                    } else {
                        this.f74198g.setText(String.format(this.f74196e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_other), a2));
                        return;
                    }
                }
                this.f74198g.setTextColor(this.f74196e.getResources().getColor(i.a.a.e.a.pay_ui_color_FF3355));
                if (i2 == 4) {
                    this.f74198g.setText(String.format(this.f74196e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_not_enough), a2, str));
                } else {
                    this.f74198g.setText(String.format(this.f74196e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_not_enough_other), a2, str));
                }
            } else {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            E();
            C();
            B();
            A();
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, callback) == null) {
            this.w = callback;
        }
    }

    public final void v() {
        List<PayWayInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            i.a.a.e.l.a aVar = this.u;
            if (aVar != null && (list = this.t) != null) {
                IYYPayAmountView.Callback callback = this.w;
                if (callback != null) {
                    callback.toPayWayDialog(aVar, list);
                    return;
                }
                return;
            }
            RLog.error("YYPayAmountView", "confirmRecharge data null", new Object[0]);
        }
    }

    public final int w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? i2 < 5 ? 2 : 3 : invokeI.intValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            i.a.a.e.n.d.a(this.f74199h, this.f74200i);
        }
    }

    public final void y(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            i.a.a.e.k.b bVar = this.o;
            PayUIKitConfig payUIKitConfig = bVar != null ? bVar.getPayUIKitConfig() : null;
            LayoutInflater.from(new ContextThemeWrapper(activity, g.f73351a.a(payUIKitConfig))).inflate(i.a.a.e.e.pay_ui_layout_pay_amount_view, (ViewGroup) this, true);
            this.f74198g = (TextView) findViewById(i.a.a.e.d.tv_amount);
            i.a.a.e.o.b.a aVar = new i.a.a.e.o.b.a(this.f74196e, this.p, payUIKitConfig);
            this.m = aVar;
            aVar.c(this.x);
            NoScrollGridView noScrollGridView = (NoScrollGridView) findViewById(i.a.a.e.d.grid_recharge_amount);
            this.k = noScrollGridView;
            noScrollGridView.setSelector(i.a.a.e.c.pay_ui_selector_transparent);
            this.k.setAdapter((ListAdapter) this.m);
            this.k.setOnItemClickListener(new a(this));
            Button button = (Button) findViewById(i.a.a.e.d.btn_confirm_recharge);
            this.f74197f = button;
            button.setOnClickListener(new b(this));
            H(this.m.b());
            this.l = (PluginCenterTopBanner) findViewById(i.a.a.e.d.banner);
            i.a.a.e.k.b bVar2 = this.o;
            if (bVar2 != null && bVar2.getPayUIKitConfig() != null) {
                this.l.setImageLoaderSupplier(this.o.getPayUIKitConfig().imageLoaderSupplier);
            }
            this.f74199h = findViewById(i.a.a.e.d.root_loading);
            this.f74200i = (ImageView) findViewById(i.a.a.e.d.iv_loading_circle);
            i.a.a.e.m.a.d(this.A, this.B, "1", "", "", "");
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.y || this.z) {
            return;
        }
        x();
    }
}
