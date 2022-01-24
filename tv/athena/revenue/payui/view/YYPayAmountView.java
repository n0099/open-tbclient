package tv.athena.revenue.payui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import j.a.a.e.p.n;
import j.a.a.e.p.o;
import j.a.a.e.p.q;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.adapter.PayAmountAdapter;
import tv.athena.revenue.payui.view.adapter.PayAmountGridItemDecoration;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes5.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAMPAIGN_ITEM_POSITION_OF_TWO_SPAN = 2;
    public static final int CAMPAIGN_ITEN_POSITION_OF_THREE_SPAN = 3;
    public static final int GRID_ITEM_COLUMN_SPACE = 10;
    public static final int GRID_ITEM_ROW_SPACE = 10;
    public static final int GRID_ITEM_THREE_SPAN_COUNT = 3;
    public static final int GRID_ITEM_TWO_SPAN_COUNT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public volatile boolean B;
    public volatile boolean C;
    public int D;
    public int E;
    public j.a.a.e.m.d F;
    public ProductListResult G;
    public MyBalanceInfo.Account H;

    /* renamed from: e  reason: collision with root package name */
    public Activity f62994e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62995f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62996g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62997h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62998i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f62999j;
    public View k;
    public ImageView l;
    public j.a.a.e.n.b m;
    public RecyclerView n;
    public PluginCenterTopBanner o;
    public PayAmountAdapter p;
    public PayUIKitConfig q;
    public List<j.a.a.e.n.c> r;
    public List<BannerConfigItem.BannerInfo> s;
    public IYYPayAmountView.ViewParams t;
    public long u;
    public List<PayWayInfo> v;
    public j.a.a.e.n.c w;
    public int x;
    public IYYPayAmountView.Callback y;
    public String z;

    /* loaded from: classes5.dex */
    public class a implements PayAmountAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

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
            this.a = yYPayAmountView;
        }

        @Override // tv.athena.revenue.payui.view.adapter.PayAmountAdapter.b
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                this.a.C(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f63000e;

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
            this.f63000e = yYPayAmountView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f63000e.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f63001e;

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
            this.f63001e = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || i2 >= this.f63001e.s.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.f63001e.s.get(i2);
            RLog.debug("YYPayAmountView", "onItemClick: click=" + bannerInfo.jumpData);
            if (this.f63001e.t != null && this.f63001e.t.viewEventListener != null) {
                this.f63001e.t.viewEventListener.onBannerClick(bannerInfo);
            }
            j.a.a.e.o.b.d(this.f63001e.D, this.f63001e.E, "19", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BannerItemSelectListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

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
            this.a = yYPayAmountView;
        }

        @Override // tv.athena.revenue.payui.model.BannerItemSelectListener
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 < 0 || i2 >= this.a.s.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.s.get(i2);
            RLog.debug("YYPayAmountView", "onItemSelected: item=" + bannerInfo);
            j.a.a.e.o.b.d(this.a.D, this.a.E, "18", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

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
            this.a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                this.a.B = false;
                this.a.G = productListResult;
                this.a.A();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                this.a.B = false;
                RLog.error("YYPayAmountView", "queryProductList onFail code:" + i2 + " failReason:" + str, new Object[0]);
                this.a.D(1021, i2, str);
                this.a.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f63002e;

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
            this.f63002e = yYPayAmountView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                j.a.a.e.p.a.a(String.valueOf(this.f63002e.u), this.f63002e.f62994e);
                Toast.makeText(this.f63002e.f62994e, "YY号已复制到剪贴板", 1).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements IResult<MyBalanceResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

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
            this.a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) {
                this.a.C = false;
                RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
                if (myBalanceResult == null) {
                    RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
                    return;
                }
                this.a.u = myBalanceResult.getMyBalanceInfo() != null ? myBalanceResult.getMyBalanceInfo().getImid() : 0L;
                this.a.R();
                MiddleRevenueConfig middleRevenueConfig = this.a.q != null ? this.a.q.revenueConfig : null;
                MyBalanceInfo.Account myBalance = middleRevenueConfig != null ? myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType()) : null;
                if (myBalance != null) {
                    this.a.H = myBalance;
                    this.a.A();
                    RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + myBalance);
                    return;
                }
                RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                this.a.C = false;
                RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i2 + " failReason:" + str, new Object[0]);
                this.a.D(1005, i2, str);
                this.a.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

        public h(YYPayAmountView yYPayAmountView) {
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
            this.a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) {
                RLog.info("YYPayAmountView", "queryBannerConfig() onSuccess:" + bannerConfigResult);
                this.a.s.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.a.x = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.a.s.addAll(list);
                this.a.M();
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

    /* loaded from: classes5.dex */
    public class i extends GridLayoutManager.SpanSizeLookup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridLayoutManager a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f63003b;

        public i(YYPayAmountView yYPayAmountView, GridLayoutManager gridLayoutManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView, gridLayoutManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63003b = yYPayAmountView;
            this.a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                j.a.a.e.n.c item = this.f63003b.p.getItem(i2);
                if (item == null || !item.f62388d) {
                    return 1;
                }
                return this.a.getSpanCount();
            }
            return invokeI.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig, IYYPayAmountView.ViewParams viewParams, j.a.a.e.n.b bVar, j.a.a.e.m.d dVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, viewParams, bVar, dVar};
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
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.z = "Y币";
        this.f62994e = activity;
        this.m = bVar;
        this.q = payUIKitConfig;
        this.t = viewParams;
        this.D = i2;
        this.E = i3;
        this.F = dVar;
        y(activity);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z();
            boolean z = (this.B || this.C) ? false : true;
            RLog.info("YYPayAmountView", "notifyUpdateDataView hasLoadAllData:" + z);
            if (z) {
                P();
                K(this.G);
            }
        }
    }

    public final void B() {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v();
            j.a.a.e.n.c cVar = this.w;
            j.a.a.e.o.b.d(this.D, this.E, "2", "", "", String.valueOf((cVar == null || (productInfo = cVar.a) == null) ? 0 : productInfo.cid));
        }
    }

    public final void C(int i2) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            j.a.a.e.n.c item = this.p.getItem(i2);
            int i3 = 0;
            if (item == null) {
                RLog.error("YYPayAmountView", "onPayAmountItemClick error payAmount null", new Object[0]);
            } else if (item.f62387c) {
                I();
                N(true);
            } else {
                this.w = item;
                this.p.setSelectedPosition(i2);
                this.p.notifyDataSetChanged();
                O(item);
                N(false);
                j.a.a.e.n.c cVar = this.w;
                if (cVar != null && (productInfo = cVar.a) != null) {
                    i3 = productInfo.cid;
                }
                j.a.a.e.o.b.d(this.D, this.E, "3", "", "", String.valueOf(i3));
            }
        }
    }

    public final void D(int i2, int i3, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) {
            if (q.a.a(this.f62994e) && i3 != -800) {
                if (i3 == -500) {
                    sb = new StringBuilder();
                    sb.append("网络不给力,请稍后重试(");
                    sb.append(i2);
                    sb.append("a)");
                } else {
                    sb = new StringBuilder();
                    sb.append("请求服务失败(");
                    sb.append(i2);
                    sb.append("a) code:");
                    sb.append(i3);
                    sb.append(" failReason:");
                    sb.append(str);
                }
                Toast.makeText(this.f62994e, sb.toString(), 1).show();
            }
            IYYPayAmountView.Callback callback = this.y;
            if (callback != null) {
                callback.onRefreshViewFail(i3, str);
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            GetBannerConfigReqParams a2 = this.m.a();
            a2.setTypes(new int[]{1});
            RLog.info("YYPayAmountView", "queryBannerConfig: " + a2);
            j.a.a.e.n.d.a(a2, new h(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            QueryCurrencyReqParams c2 = this.m.c();
            this.C = true;
            j.a.a.e.n.d.b(c2, new g(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.B = true;
            j.a.a.e.n.d.c(this.m.d(), new e(this));
        }
    }

    public final int H(ProductListResult productListResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, productListResult)) == null) {
            List<ProductInfo> productInfoList = productListResult.getProductInfoList();
            if (productInfoList != null && productInfoList.size() != 0) {
                this.r.clear();
                int i2 = 0;
                for (int i3 = 0; i3 < productInfoList.size(); i3++) {
                    j.a.a.e.n.c cVar = new j.a.a.e.n.c(productInfoList.get(i3), productListResult.getCurrencyType());
                    if (productInfoList.get(i3).cid == this.A) {
                        i2 = i3;
                    }
                    this.r.add(cVar);
                }
                int i4 = L() ? 0 : i2;
                if (this.r.size() < 6) {
                    this.r.add(new j.a.a.e.n.c(true));
                }
                return i4;
            }
            RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
            return -1;
        }
        return invokeL.intValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List<PayWayInfo> list = this.v;
            if (list == null) {
                RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.y;
            if (callback != null) {
                callback.showInputNumberDialog(this.f62994e, list);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            j.a.a.e.p.e.b(this.k, this.l);
        }
    }

    public final void K(ProductListResult productListResult) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, productListResult) == null) {
            if (productListResult == null) {
                RLog.error("YYPayAmountView", "showProductListView error result null", new Object[0]);
            } else if (this.n == null || this.p == null) {
            } else {
                this.A = productListResult.defaultCid;
                String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
                this.z = currencyName;
                this.p.setCurrencyName(currencyName);
                int H = H(productListResult);
                if (H < 0) {
                    RLog.error("YYPayAmountView", "showProductListView error defaultSelectIndex < 0", new Object[0]);
                    return;
                }
                boolean z = this.p.getCount() >= 2;
                int w = w(this.p.getCount());
                if (z) {
                    i2 = w != 2 ? 3 : 2;
                    j.a.a.e.n.c cVar = new j.a.a.e.n.c(null, 0);
                    cVar.f62388d = true;
                    this.r.add(i2, cVar);
                    if (H >= i2) {
                        H++;
                    }
                } else {
                    i2 = 0;
                }
                RLog.info("YYPayAmountView", "showProductListView mDefaultCid:" + this.A + " spanCount:" + w + " campaignItemPosition:" + i2 + " shouldAddCampaignItem:" + z + " defaultSelectIndex：" + H);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f62994e, w);
                gridLayoutManager.setSpanSizeLookup(new i(this, gridLayoutManager));
                this.n.setLayoutManager(gridLayoutManager);
                this.n.setAdapter(this.p);
                this.n.addItemDecoration(new PayAmountGridItemDecoration(w, j.a.a.e.p.c.a(10.0f), j.a.a.e.p.c.a(10.0f), i2, gridLayoutManager));
                this.p.setSpanCount(w);
                this.p.setCampaignItemPosition(i2);
                this.p.setSelectedPosition(H);
                this.p.notifyDataSetChanged();
                this.w = this.r.get(H);
                this.v = productListResult.getPayWayInfoList();
                N(false);
                O(this.p.getSelectedItem());
                Q(productListResult.getPaysSettingInfo());
                j.a.a.e.n.e.a = productListResult.getPaysSettingInfo();
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            List<j.a.a.e.n.c> list = this.r;
            if (list != null && !list.isEmpty()) {
                IYYPayAmountView.ViewParams viewParams = this.t;
                boolean z = viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_TARGET_PAY;
                RLog.info("YYPayAmountView", "tryModifyTargetAmount modifyTargetAmount:" + z);
                if (z) {
                    if (this.H != null) {
                        RLog.info("YYPayAmountView", "tryModifyTargetAmount targetAmount:" + this.t.targetAmount + " amount:" + this.H.amount);
                        int i2 = this.t.targetAmount;
                        long j2 = this.H.amount;
                        if (i2 > j2) {
                            j.a.a.e.n.c c2 = j.a.a.e.p.g.c(this.r, this.q, i2, j2);
                            RLog.error("YYPayAmountView", "tryModifyTargetAmount payAmount:" + c2, new Object[0]);
                            return c2 != null;
                        }
                        RLog.error("YYPayAmountView", "tryModifyTargetAmount but targetAmount <= mMyBalanceAccount.amount", new Object[0]);
                    } else {
                        RLog.error("YYPayAmountView", "tryModifyTargetAmount error mMyBalanceAccount null", new Object[0]);
                    }
                }
                return false;
            }
            RLog.error("YYPayAmountView", "tryModifyTargetAmount error mNormalPayAmountList null", new Object[0]);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RLog.debug("YYPayAmountView", "updateBanner: count=" + this.s.size());
            if (this.s.size() == 0) {
                this.o.setVisibility(8);
                return;
            }
            int i2 = this.x;
            if (i2 > 0) {
                this.o.setFlipInterval(i2);
            }
            this.o.setData(this.s);
            this.o.setOnItemClickListener(new c(this));
            this.o.setBannerItemSelectListener(new d(this));
            this.o.setVisibility(0);
        }
    }

    public final void N(boolean z) {
        j.a.a.e.n.c cVar;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (!z && (cVar = this.w) != null && (productInfo = cVar.a) != null && (list = productInfo.giftbags) != null && list.size() > 0) {
                this.F.d(this.w.a.giftbags.get(0));
                PayAmountAdapter payAmountAdapter = this.p;
                payAmountAdapter.uopdateCampaignSelectIndex(payAmountAdapter.getSelectedPosition());
                return;
            }
            this.F.d(null);
            this.p.uopdateCampaignSelectIndex(-1);
        }
    }

    public final void O(j.a.a.e.n.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            if (this.f62995f == null) {
                RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
            } else if (cVar == null) {
                RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
            } else {
                this.f62995f.setText("立即充值" + n.a(cVar.b()) + "元");
            }
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void P() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.H == null) {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
            } else if (this.f62997h != null && (activity = this.f62994e) != null && !activity.isFinishing()) {
                String str = null;
                MyBalanceInfo.Account account = this.H;
                int i2 = account.currencyType;
                String a2 = n.a(account.amount / 100.0d);
                IYYPayAmountView.ViewParams viewParams = this.t;
                if (viewParams != null) {
                    int i3 = viewParams.targetAmount;
                    long j2 = this.H.amount;
                    if (i3 > j2) {
                        str = n.a((i3 - j2) / 100.0d);
                    }
                }
                this.f62997h.setVisibility(0);
                if (str != null) {
                    if (i2 == 4) {
                        this.f62997h.setText(String.format(this.f62994e.getString(j.a.a.e.h.pay_ui_str_wallet_amount_not_enough), a2, str));
                    } else {
                        this.f62997h.setText(String.format(this.f62994e.getString(j.a.a.e.h.pay_ui_str_wallet_amount_not_enough_other), a2, str));
                    }
                } else if (i2 == 4) {
                    this.f62997h.setText(String.format(this.f62994e.getString(j.a.a.e.h.pay_ui_str_wallet_amount), a2));
                } else {
                    this.f62997h.setText(String.format(this.f62994e.getString(j.a.a.e.h.pay_ui_str_wallet_amount_other), a2));
                }
            } else {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
            }
        }
    }

    public final void Q(PaysSettingInfo paysSettingInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, paysSettingInfo) == null) || paysSettingInfo == null || TextUtils.isEmpty(paysSettingInfo.payRemindMsg) || this.f62999j == null) {
            return;
        }
        RLog.debug("YYPayAmountView", "updatePayRemindTextView payRemindMsg:" + paysSettingInfo.payRemindMsg);
        this.f62999j.setText(paysSettingInfo.payRemindMsg);
    }

    public final void R() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (textView = this.f62998i) == null || this.u == 0) {
            return;
        }
        textView.setVisibility(0);
        this.f62998i.setText(String.format(this.f62994e.getString(j.a.a.e.h.pay_ui_yy_number), Long.valueOf(this.u)));
        this.f62998i.setOnLongClickListener(new f(this));
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, j.a.a.e.q.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, j.a.a.e.q.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            J();
            G();
            F();
            E();
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, callback) == null) {
            this.y = callback;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            j.a.a.e.n.c cVar = this.w;
            if (cVar == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mSelectedPayAmount null", new Object[0]);
                return;
            }
            List<PayWayInfo> list = this.v;
            if (list == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mPayWayInfoList null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.y;
            if (callback != null) {
                callback.toPayWayDialog(cVar, list);
            }
        }
    }

    public final int w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? i2 < 5 ? 2 : 3 : invokeI.intValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j.a.a.e.p.e.a(this.k, this.l);
        }
    }

    public final void y(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, activity) == null) {
            LayoutInflater.from(new ContextThemeWrapper(activity, o.a.a(this.q))).inflate(j.a.a.e.g.pay_ui_layout_pay_amount_view, (ViewGroup) this, true);
            this.f62997h = (TextView) findViewById(j.a.a.e.f.tv_amount);
            this.f62998i = (TextView) findViewById(j.a.a.e.f.tv_yy);
            PayAmountAdapter payAmountAdapter = new PayAmountAdapter(this.f62994e, this.F, this.r, this.q);
            this.p = payAmountAdapter;
            payAmountAdapter.setCurrencyName(this.z);
            this.n = (RecyclerView) findViewById(j.a.a.e.f.grid_recharge_amount);
            this.p.setOnItemClickListener(new a(this));
            TextView textView = (TextView) findViewById(j.a.a.e.f.btn_confirm_recharge);
            this.f62995f = textView;
            textView.setOnClickListener(new b(this));
            O(this.p.getSelectedItem());
            PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(j.a.a.e.f.banner);
            this.o = pluginCenterTopBanner;
            PayUIKitConfig payUIKitConfig = this.q;
            if (payUIKitConfig != null) {
                pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
            }
            this.k = findViewById(j.a.a.e.f.root_loading);
            this.l = (ImageView) findViewById(j.a.a.e.f.iv_loading_circle);
            this.f62996g = (TextView) findViewById(j.a.a.e.f.tv_hint);
            this.f62999j = (TextView) findViewById(j.a.a.e.f.tvPayRemind);
            j.a.a.e.o.b.d(this.D, this.E, "1", "", "", "");
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean z = (this.B || this.C) ? false : true;
            RLog.info("YYPayAmountView", "notifyHideLoadingView hasLoadAllData:" + z);
            if (z) {
                x();
            }
        }
    }
}
