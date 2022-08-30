package tv.athena.revenue.payui.view.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.tieba.R;
import com.baidu.tieba.c3a;
import com.baidu.tieba.d3a;
import com.baidu.tieba.e2a;
import com.baidu.tieba.f2a;
import com.baidu.tieba.f3a;
import com.baidu.tieba.g2a;
import com.baidu.tieba.h2a;
import com.baidu.tieba.m2a;
import com.baidu.tieba.o2a;
import com.baidu.tieba.q2a;
import com.baidu.tieba.s2a;
import com.baidu.tieba.u0a;
import com.baidu.tieba.u2a;
import com.baidu.tieba.y1a;
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
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PayAmountAdapter;
import tv.athena.revenue.payui.view.adapter.PayAmountGridItemDecoration;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes9.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public u0a B;
    public ProductListResult C;
    public MyBalanceInfo.Account D;
    public List<PayWayInfo> E;
    public String F;
    public Window G;
    public Activity a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public ImageView i;
    public e2a j;
    public RecyclerView k;
    public PluginCenterTopBanner l;
    public PayAmountAdapter m;
    public PayUIKitConfig n;
    public List<f2a> o;
    public List<BannerConfigItem.BannerInfo> p;
    public IYYPayAmountView.ViewParams q;
    public long r;
    public f2a s;
    public int t;
    public IYYPayAmountView.Callback u;
    public String v;
    public int w;
    public volatile boolean x;
    public volatile boolean y;
    public int z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayAmountView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements PayAmountAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

        public b(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayAmountView;
        }

        @Override // tv.athena.revenue.payui.view.adapter.PayAmountAdapter.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                this.a.E(i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

        public c(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayAmountView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements AdapterView.OnItemClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || i >= this.a.p.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.p.get(i);
            RLog.debug("YYPayAmountView", "onItemClick: click=" + bannerInfo.jumpData);
            if (this.a.q != null && this.a.q.viewEventListener != null) {
                this.a.q.viewEventListener.onBannerClick(bannerInfo);
            }
            m2a.d(this.a.z, this.a.A, "19", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BannerItemSelectListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayAmountView;
        }

        @Override // tv.athena.revenue.payui.model.BannerItemSelectListener
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i < 0 || i >= this.a.p.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.p.get(i);
            RLog.debug("YYPayAmountView", "onItemSelected: item=" + bannerInfo);
            m2a.d(this.a.z, this.a.A, "18", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes9.dex */
    public class f implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

        public f(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.x = false;
                this.a.C = productListResult;
                this.a.B();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                this.a.x = false;
                RLog.error("YYPayAmountView", "queryProductList onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.F(1021, i, str);
                this.a.A();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnLongClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayAmountView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                o2a.a(String.valueOf(this.a.r), this.a.a);
                Toast.makeText(this.a.a, "YY号已复制到剪贴板", 1).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h implements IResult<MyBalanceResult> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.y = false;
                RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
                if (myBalanceResult == null) {
                    RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
                    return;
                }
                this.a.r = myBalanceResult.getMyBalanceInfo() != null ? myBalanceResult.getMyBalanceInfo().getImid() : 0L;
                this.a.V();
                MiddleRevenueConfig middleRevenueConfig = this.a.n != null ? this.a.n.revenueConfig : null;
                MyBalanceInfo.Account myBalance = middleRevenueConfig != null ? myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType()) : null;
                if (myBalance != null) {
                    this.a.D = myBalance;
                    this.a.B();
                    RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + myBalance);
                    return;
                }
                RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                this.a.y = false;
                RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.F(1005, i, str);
                this.a.A();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayAmountView a;

        public i(YYPayAmountView yYPayAmountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.p.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.a.t = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.a.p.addAll(list);
                this.a.O();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.error("YYPayAmountView", "queryBannerConfig onFail code:" + i + " failReason:" + str, new Object[0]);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends GridLayoutManager.SpanSizeLookup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridLayoutManager a;
        public final /* synthetic */ YYPayAmountView b;

        public j(YYPayAmountView yYPayAmountView, GridLayoutManager gridLayoutManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayAmountView, gridLayoutManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yYPayAmountView;
            this.a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2a d = this.b.m.d(i);
                if (d == null || !d.d) {
                    return 1;
                }
                return this.a.getSpanCount();
            }
            return invokeI.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig, IYYPayAmountView.ViewParams viewParams, e2a e2aVar, u0a u0aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, viewParams, e2aVar, u0aVar};
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
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.v = "Y币";
        this.a = activity;
        this.j = e2aVar;
        this.n = payUIKitConfig;
        this.q = viewParams;
        this.z = i2;
        this.A = i3;
        this.B = u0aVar;
        z(activity);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = (this.x || this.y) ? false : true;
            RLog.info("YYPayAmountView", "notifyHideLoadingView hasLoadAllData:" + z);
            if (z) {
                y();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            A();
            boolean z = (this.x || this.y) ? false : true;
            RLog.info("YYPayAmountView", "notifyUpdateDataView hasLoadAllData:" + z);
            if (z) {
                S();
                M(this.C);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            IYYPayAmountView.ViewParams viewParams = this.q;
            if (viewParams == null) {
                RLog.error("YYPayAmountView", "onBtnLeftClick error mViewParams null", new Object[0]);
                return;
            }
            boolean z = viewParams.showFaqPage;
            if (z) {
                IYYPayAmountView.Callback callback = this.u;
                if (callback != null) {
                    callback.toHelpCenterPage();
                }
            } else {
                y1a.b(this.z, this.A);
            }
            m2a.d(this.z, this.A, "25", "", "", "");
            RLog.info("YYPayAmountView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.u);
        }
    }

    public final void D() {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w();
            f2a f2aVar = this.s;
            m2a.d(this.z, this.A, "2", "", "", String.valueOf((f2aVar == null || (productInfo = f2aVar.a) == null) ? 0 : productInfo.cid));
        }
    }

    public final void E(int i2) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            f2a d2 = this.m.d(i2);
            int i3 = 0;
            if (d2 == null) {
                RLog.error("YYPayAmountView", "onPayAmountItemClick error payAmount null", new Object[0]);
            } else if (d2.c) {
                K();
                Q(true);
            } else {
                this.s = d2;
                this.m.k(i2);
                this.m.notifyDataSetChanged();
                R(d2);
                Q(false);
                f2a f2aVar = this.s;
                if (f2aVar != null && (productInfo = f2aVar.a) != null) {
                    i3 = productInfo.cid;
                }
                m2a.d(this.z, this.A, "3", "", "", String.valueOf(i3));
            }
        }
    }

    public final void F(int i2, int i3, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            if (f3a.a.a(this.a) && i3 != -800) {
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
                Toast.makeText(this.a, sb.toString(), 1).show();
            }
            IYYPayAmountView.Callback callback = this.u;
            if (callback != null) {
                callback.onRefreshViewFail(i3, str);
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            GetBannerConfigReqParams a2 = this.j.a();
            a2.setTypes(new int[]{1});
            RLog.info("YYPayAmountView", "queryBannerConfig: " + a2);
            g2a.a(a2, new i(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            QueryCurrencyReqParams c2 = this.j.c();
            this.y = true;
            g2a.b(c2, new h(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.x = true;
            IYYPayAmountView.ViewParams viewParams = this.q;
            g2a.c(this.j.d(viewParams != null ? viewParams.clientInfoExpand : null), new f(this));
        }
    }

    public final int J(ProductListResult productListResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, productListResult)) == null) {
            List<ProductInfo> productInfoList = productListResult.getProductInfoList();
            if (productInfoList != null && productInfoList.size() != 0) {
                this.o.clear();
                int i2 = 0;
                for (int i3 = 0; i3 < productInfoList.size(); i3++) {
                    f2a f2aVar = new f2a(productInfoList.get(i3), productListResult.getCurrencyType());
                    if (productInfoList.get(i3).cid == this.w) {
                        i2 = i3;
                    }
                    this.o.add(f2aVar);
                }
                int i4 = N() ? 0 : i2;
                if (this.o.size() < 6) {
                    this.o.add(new f2a(true));
                }
                return i4;
            }
            RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
            return -1;
        }
        return invokeL.intValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<PayWayInfo> list = this.E;
            if (list == null) {
                RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.u;
            if (callback != null) {
                callback.showInputNumberDialog(this.a, list, this.F);
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            s2a.b(this.h, this.i);
        }
    }

    public final void M(ProductListResult productListResult) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, productListResult) == null) {
            if (productListResult == null) {
                RLog.error("YYPayAmountView", "showProductListView error result null", new Object[0]);
            } else if (this.k == null || this.m == null) {
            } else {
                this.w = productListResult.defaultCid;
                String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
                this.v = currencyName;
                this.m.i(currencyName);
                int J = J(productListResult);
                if (J < 0) {
                    RLog.error("YYPayAmountView", "showProductListView error defaultSelectIndex < 0", new Object[0]);
                    return;
                }
                boolean z = this.m.getCount() >= 2;
                int x = x(this.m.getCount());
                if (z) {
                    i2 = x != 2 ? 3 : 2;
                    f2a f2aVar = new f2a(null, 0);
                    f2aVar.d = true;
                    this.o.add(i2, f2aVar);
                    if (J >= i2) {
                        J++;
                    }
                } else {
                    i2 = 0;
                }
                RLog.info("YYPayAmountView", "showProductListView mDefaultCid:" + this.w + " spanCount:" + x + " campaignItemPosition:" + i2 + " shouldAddCampaignItem:" + z + " defaultSelectIndex：" + J);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a, x);
                gridLayoutManager.setSpanSizeLookup(new j(this, gridLayoutManager));
                this.k.setLayoutManager(gridLayoutManager);
                this.k.setAdapter(this.m);
                this.k.addItemDecoration(new PayAmountGridItemDecoration(x, q2a.a(10.0f), q2a.a(10.0f), i2, gridLayoutManager));
                this.m.l(x);
                this.m.h(i2);
                this.m.k(J);
                this.m.notifyDataSetChanged();
                this.s = this.o.get(J);
                this.E = productListResult.getPayWayInfoList();
                this.F = productListResult.getBubbleActMsg();
                P();
                Q(false);
                R(this.m.e());
                T(productListResult.getPaysSettingInfo());
                h2a.h(productListResult.getPaysSettingInfo(), "YYPayAmountView");
                U("showProductListView");
            }
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            List<f2a> list = this.o;
            if (list != null && !list.isEmpty()) {
                IYYPayAmountView.ViewParams viewParams = this.q;
                boolean z = viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_TARGET_PAY;
                RLog.info("YYPayAmountView", "tryModifyTargetAmount modifyTargetAmount:" + z);
                if (z) {
                    if (this.D != null) {
                        RLog.info("YYPayAmountView", "tryModifyTargetAmount targetAmount:" + this.q.targetAmount + " amount:" + this.D.amount);
                        int i2 = this.q.targetAmount;
                        long j2 = this.D.amount;
                        if (i2 > j2) {
                            f2a c2 = u2a.c(this.o, this.n, i2, j2);
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

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            RLog.debug("YYPayAmountView", "updateBanner: count=" + this.p.size());
            if (this.p.size() == 0) {
                this.l.setVisibility(8);
                return;
            }
            int i2 = this.t;
            if (i2 > 0) {
                this.l.setFlipInterval(i2);
            }
            this.l.setData(this.p);
            this.l.setOnItemClickListener(new d(this));
            this.l.setBannerItemSelectListener(new e(this));
            this.l.setVisibility(0);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RLog.info("YYPayAmountView", "updateBubbleMsgView mBubbleActMsg:" + this.F + " mTvBubbleMsg:" + this.g);
            TextView textView = this.g;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            if (!TextUtils.isEmpty(this.F)) {
                this.g.setVisibility(0);
                this.g.setText(this.F);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final void Q(boolean z) {
        f2a f2aVar;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (!z && (f2aVar = this.s) != null && (productInfo = f2aVar.a) != null && (list = productInfo.giftbags) != null && list.size() > 0) {
                this.B.d(this.s.a.giftbags.get(0));
                PayAmountAdapter payAmountAdapter = this.m;
                payAmountAdapter.n(payAmountAdapter.f());
                return;
            }
            this.B.d(null);
            this.m.n(-1);
        }
    }

    public final void R(f2a f2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, f2aVar) == null) {
            if (this.b == null) {
                RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
            } else if (f2aVar == null) {
                RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
            } else {
                this.b.setText("立即充值" + c3a.a(f2aVar.b()) + "元");
            }
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void S() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.D == null) {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
            } else if (this.d != null && (activity = this.a) != null && !activity.isFinishing()) {
                String str = null;
                MyBalanceInfo.Account account = this.D;
                int i2 = account.currencyType;
                String a2 = c3a.a(account.amount / 100.0d);
                IYYPayAmountView.ViewParams viewParams = this.q;
                if (viewParams != null) {
                    int i3 = viewParams.targetAmount;
                    long j2 = this.D.amount;
                    if (i3 > j2) {
                        str = c3a.a((i3 - j2) / 100.0d);
                    }
                }
                this.d.setVisibility(0);
                if (str != null) {
                    if (i2 == 4) {
                        this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d7d), a2, str));
                    } else {
                        this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d7e), a2, str));
                    }
                } else if (i2 == 4) {
                    this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d7c), a2));
                } else {
                    this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d7f), a2));
                }
            } else {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
            }
        }
    }

    public final void T(PaysSettingInfo paysSettingInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, paysSettingInfo) == null) || paysSettingInfo == null || TextUtils.isEmpty(paysSettingInfo.payRemindMsg) || this.f == null) {
            return;
        }
        RLog.debug("YYPayAmountView", "updatePayRemindTextView payRemindMsg:" + paysSettingInfo.payRemindMsg);
        this.f.setText(paysSettingInfo.payRemindMsg);
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (this.G != null && h2a.d() != null) {
                View findViewById = this.G.findViewById(R.id.obfuscated_res_0x7f090431);
                if (findViewById == null) {
                    RLog.error("YYPayAmountView", "updateTopLeftBtn error btnLeft null", new Object[0]);
                    return;
                }
                findViewById.setOnClickListener(new a(this));
                YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.z, this.A);
                IFeedbackServiceProxy feedbackServiceProxy = uIKit != null ? uIKit.getFeedbackServiceProxy() : null;
                boolean z = true;
                z = (h2a.d().feedbackSwitch != 1 || feedbackServiceProxy == null) ? false : false;
                findViewById.setVisibility(z ? 0 : 8);
                if (z) {
                    m2a.d(this.z, this.A, "24", "", "", "");
                }
                RLog.info("YYPayAmountView", "updateTopLeftBtn from:" + str + " proxy:" + feedbackServiceProxy + " feedbackSwitch:" + h2a.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
                return;
            }
            RLog.warn("YYPayAmountView", "updateTopLeftBtn from:" + str + " mWindow:" + this.G + " paysSettingInfo:" + h2a.d());
        }
    }

    public final void V() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (textView = this.e) == null || this.r == 0) {
            return;
        }
        textView.setVisibility(0);
        this.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d8c), Long.valueOf(this.r)));
        this.e.setOnLongClickListener(new g(this));
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.g3a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, window) == null) {
            RLog.debug("YYPayAmountView", "attachWindow window:" + window);
            this.G = window;
            IYYPayAmountView.ViewParams viewParams = this.q;
            if (viewParams != null) {
                refreshWindow(viewParams.windowParams);
            }
            U(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.g3a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.g3a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            L();
            I();
            H();
            G();
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.g3a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, windowParams) == null) {
            RLog.debug("YYPayAmountView", "refreshWindow params:" + windowParams + " mWindow:" + this.G);
            if (this.G == null || windowParams == null) {
                return;
            }
            IYYPayAmountView.ViewParams viewParams = this.q;
            if (viewParams != null) {
                viewParams.windowParams = windowParams;
            }
            WindowManager.LayoutParams attributes = this.G.getAttributes();
            attributes.dimAmount = windowParams.dimAmount;
            try {
                this.G.setAttributes(attributes);
            } catch (Exception e2) {
                RLog.error("YYPayAmountView", "refreshWindow e:" + e2, new Object[0]);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, callback) == null) {
            this.u = callback;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            f2a f2aVar = this.s;
            if (f2aVar == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mSelectedPayAmount null", new Object[0]);
                return;
            }
            List<PayWayInfo> list = this.E;
            if (list == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mPayWayInfoList null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.u;
            if (callback != null) {
                callback.toPayWayDialog(f2aVar, list, this.F);
            }
        }
    }

    public final int x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? i2 < 5 ? 2 : 3 : invokeI.intValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            s2a.a(this.h, this.i);
        }
    }

    public final void z(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, activity) == null) {
            LayoutInflater.from(new ContextThemeWrapper(activity, d3a.a.a(this.n))).inflate(R.layout.obfuscated_res_0x7f0d0695, (ViewGroup) this, true);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09230d);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0923d1);
            PayAmountAdapter payAmountAdapter = new PayAmountAdapter(this.a, this.B, this.o, this.n);
            this.m = payAmountAdapter;
            payAmountAdapter.i(this.v);
            this.k = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090cdb);
            this.m.j(new b(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090425);
            this.b = textView;
            textView.setOnClickListener(new c(this));
            R(this.m.e());
            PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f090312);
            this.l = pluginCenterTopBanner;
            PayUIKitConfig payUIKitConfig = this.n;
            if (payUIKitConfig != null) {
                pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
            }
            this.h = findViewById(R.id.obfuscated_res_0x7f091c2c);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff9);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092354);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092301);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09231b);
            m2a.d(this.z, this.A, "1", "", "", "");
        }
    }
}
