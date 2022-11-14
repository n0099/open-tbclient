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
import com.baidu.tieba.d7a;
import com.baidu.tieba.k7a;
import com.baidu.tieba.k8a;
import com.baidu.tieba.l7a;
import com.baidu.tieba.l8a;
import com.baidu.tieba.n8a;
import com.baidu.tieba.q7a;
import com.baidu.tieba.r4a;
import com.baidu.tieba.r5a;
import com.baidu.tieba.s7a;
import com.baidu.tieba.v7a;
import com.baidu.tieba.x7a;
import com.baidu.tieba.z7a;
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
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
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
    public r5a A;
    public ProductListResult B;
    public MyBalanceInfo.Account C;
    public List<PayWayInfo> D;
    public String E;
    public Window F;
    public Activity a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public ImageView i;
    public RecyclerView j;
    public PluginCenterTopBanner k;
    public PayAmountAdapter l;
    public PayUIKitConfig m;
    public List<k7a> n;
    public List<BannerConfigItem.BannerInfo> o;
    public IYYPayAmountView.ViewParams p;
    public long q;
    public k7a r;
    public int s;
    public IYYPayAmountView.Callback t;
    public String u;
    public int v;
    public volatile boolean w;
    public volatile boolean x;
    public int y;
    public int z;

    public final int A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 < 5 ? 2 : 3 : invokeI.intValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.o8a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this : (View) invokeV.objValue;
    }

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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.G();
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
                this.a.I(i);
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.H();
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && i >= 0 && i < this.a.o.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.o.get(i);
                boolean D = this.a.D(bannerInfo);
                RLog.info("YYPayAmountView", "onItemClick: click=" + bannerInfo.jumpData + " innerHandle:" + D);
                if (!D && this.a.p != null && this.a.p.viewEventListener != null) {
                    this.a.p.viewEventListener.onBannerClick(bannerInfo);
                }
                q7a.d(this.a.y, this.a.z, "19", "", "", bannerInfo.id);
                if (bannerInfo.jumpType == 5) {
                    q7a.d(this.a.y, this.a.z, PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, "", "", bannerInfo.id);
                }
            }
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
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i >= 0 && i < this.a.o.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.o.get(i);
                RLog.debug("YYPayAmountView", "onItemSelected: item=" + bannerInfo);
                q7a.d(this.a.y, this.a.z, "18", "", "", bannerInfo.id);
                if (bannerInfo.jumpType == 5) {
                    q7a.d(this.a.y, this.a.z, PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, "", "", bannerInfo.id);
                }
            }
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
                this.a.w = false;
                this.a.B = productListResult;
                this.a.F();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                this.a.w = false;
                RLog.error("YYPayAmountView", "queryProductList onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.J(1021, i, str);
                this.a.E();
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
                s7a.a(String.valueOf(this.a.q), this.a.a);
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
            long j;
            MiddleRevenueConfig middleRevenueConfig;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) {
                this.a.x = false;
                RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
                if (myBalanceResult == null) {
                    RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
                    return;
                }
                YYPayAmountView yYPayAmountView = this.a;
                if (myBalanceResult.getMyBalanceInfo() != null) {
                    j = myBalanceResult.getMyBalanceInfo().getImid();
                } else {
                    j = 0;
                }
                yYPayAmountView.q = j;
                this.a.Z();
                MyBalanceInfo.Account account = null;
                if (this.a.m != null) {
                    middleRevenueConfig = this.a.m.revenueConfig;
                } else {
                    middleRevenueConfig = null;
                }
                if (middleRevenueConfig != null) {
                    account = myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType());
                }
                if (account != null) {
                    this.a.C = account;
                    this.a.F();
                    RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + account);
                    return;
                }
                RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                this.a.x = false;
                RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.J(1005, i, str);
                this.a.E();
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
                this.a.o.clear();
                if (bannerConfigResult.getBannerConfigItemList() != null && bannerConfigResult.getBannerConfigItemList().size() > 0) {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.a.s = bannerConfigItem.autoPlayTime;
                } else {
                    list = null;
                }
                if (list != null && list.size() > 0) {
                    this.a.o.addAll(list);
                    this.a.S();
                }
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
                k7a d = this.b.l.d(i);
                if (d != null && d.d) {
                    return this.a.getSpanCount();
                }
                return 1;
            }
            return invokeI.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig, IYYPayAmountView.ViewParams viewParams, r5a r5aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, viewParams, r5aVar};
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
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.u = "Y币";
        this.a = activity;
        this.m = payUIKitConfig;
        this.p = viewParams;
        this.y = i2;
        this.z = i3;
        this.A = r5aVar;
        C(activity);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, callback) == null) {
            this.t = callback;
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x7a.a(this.h, this.i);
        }
    }

    public final void H() {
        int i2;
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            z();
            k7a k7aVar = this.r;
            if (k7aVar != null && (productInfo = k7aVar.a) != null) {
                i2 = productInfo.cid;
            } else {
                i2 = 0;
            }
            q7a.d(this.y, this.z, "2", "", "", String.valueOf(i2));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<PayWayInfo> list = this.D;
            if (list == null) {
                RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.t;
            if (callback != null) {
                callback.showInputNumberDialog(this.a, list, this.E);
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            x7a.b(this.h, this.i);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.o8a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            P();
            M();
            L();
            K();
        }
    }

    public final void C(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            LayoutInflater.from(new ContextThemeWrapper(activity, l8a.a.a(this.m))).inflate(R.layout.obfuscated_res_0x7f0d06c3, (ViewGroup) this, true);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0923b2);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09247c);
            PayAmountAdapter payAmountAdapter = new PayAmountAdapter(this.a, this.A, this.n, this.m);
            this.l = payAmountAdapter;
            payAmountAdapter.i(this.u);
            this.j = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090d22);
            this.l.j(new b(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090448);
            this.b = textView;
            textView.setOnClickListener(new c(this));
            V(this.l.e());
            PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f09032b);
            this.k = pluginCenterTopBanner;
            PayUIKitConfig payUIKitConfig = this.m;
            if (payUIKitConfig != null) {
                pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
            }
            this.h = findViewById(R.id.obfuscated_res_0x7f091ccd);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f091047);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0923fe);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0923a4);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0923c2);
            q7a.d(this.y, this.z, "1", "", "", "");
        }
    }

    public final void Y(String str) {
        IFeedbackServiceProxy iFeedbackServiceProxy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (this.F != null && l7a.d() != null) {
                View findViewById = this.F.findViewById(R.id.obfuscated_res_0x7f090456);
                int i2 = 0;
                if (findViewById == null) {
                    RLog.error("YYPayAmountView", "updateTopLeftBtn error btnLeft null", new Object[0]);
                    return;
                }
                findViewById.setOnClickListener(new a(this));
                YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.y, this.z);
                if (uIKit != null) {
                    iFeedbackServiceProxy = uIKit.getFeedbackServiceProxy();
                } else {
                    iFeedbackServiceProxy = null;
                }
                boolean z = true;
                z = (l7a.d().feedbackSwitch != 1 || iFeedbackServiceProxy == null) ? false : false;
                if (!z) {
                    i2 = 8;
                }
                findViewById.setVisibility(i2);
                if (z) {
                    q7a.d(this.y, this.z, "24", "", "", "");
                }
                RLog.info("YYPayAmountView", "updateTopLeftBtn from:" + str + " proxy:" + iFeedbackServiceProxy + " feedbackSwitch:" + l7a.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
                return;
            }
            RLog.warn("YYPayAmountView", "updateTopLeftBtn from:" + str + " mWindow:" + this.F + " paysSettingInfo:" + l7a.d());
        }
    }

    public final boolean D(BannerConfigItem.BannerInfo bannerInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bannerInfo)) == null) {
            if (bannerInfo == null || bannerInfo.jumpType != 5) {
                return false;
            }
            if (!TextUtils.isEmpty(bannerInfo.jumpData)) {
                IYYPayAmountView.Callback callback = this.t;
                if (callback != null) {
                    callback.toBannerConfigWebPage(bannerInfo.jumpData);
                    return true;
                }
                return true;
            }
            RLog.error("YYPayAmountView", "innerHandleBannerClick error bannerInfo:" + bannerInfo, new Object[0]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(int i2) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            k7a d2 = this.l.d(i2);
            int i3 = 0;
            if (d2 == null) {
                RLog.error("YYPayAmountView", "onPayAmountItemClick error payAmount null", new Object[0]);
            } else if (d2.c) {
                O();
                U(true);
            } else {
                this.r = d2;
                this.l.k(i2);
                this.l.notifyDataSetChanged();
                V(d2);
                U(false);
                k7a k7aVar = this.r;
                if (k7aVar != null && (productInfo = k7aVar.a) != null) {
                    i3 = productInfo.cid;
                }
                q7a.d(this.y, this.z, "3", "", "", String.valueOf(i3));
            }
        }
    }

    public final void U(boolean z) {
        k7a k7aVar;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (!z && (k7aVar = this.r) != null && (productInfo = k7aVar.a) != null && (list = productInfo.giftbags) != null && list.size() > 0) {
                this.A.d(this.r.a.giftbags.get(0));
                PayAmountAdapter payAmountAdapter = this.l;
                payAmountAdapter.n(payAmountAdapter.f());
                return;
            }
            this.A.d(null);
            this.l.n(-1);
        }
    }

    public final void V(k7a k7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, k7aVar) == null) {
            if (this.b == null) {
                RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
            } else if (k7aVar == null) {
                RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
            } else {
                this.b.setText("立即充值" + k8a.a(k7aVar.c()) + "元");
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.o8a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, windowParams) == null) {
            RLog.debug("YYPayAmountView", "refreshWindow params:" + windowParams + " mWindow:" + this.F);
            if (this.F != null && windowParams != null) {
                IYYPayAmountView.ViewParams viewParams = this.p;
                if (viewParams != null) {
                    viewParams.windowParams = windowParams;
                }
                WindowManager.LayoutParams attributes = this.F.getAttributes();
                attributes.dimAmount = windowParams.dimAmount;
                try {
                    this.F.setAttributes(attributes);
                } catch (Exception e2) {
                    RLog.error("YYPayAmountView", "refreshWindow e:" + e2, new Object[0]);
                }
            }
        }
    }

    public final void E() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.w && !this.x) {
                z = true;
            } else {
                z = false;
            }
            RLog.info("YYPayAmountView", "notifyHideLoadingView hasLoadAllData:" + z);
            if (z) {
                B();
            }
        }
    }

    public final void F() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            E();
            if (!this.w && !this.x) {
                z = true;
            } else {
                z = false;
            }
            RLog.info("YYPayAmountView", "notifyUpdateDataView hasLoadAllData:" + z);
            if (z) {
                W();
                Q(this.B);
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            r4a yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
            if (yYPayMiddleService == null) {
                RLog.error("YYPayAmountView", "queryBannerConfig error yyPayMiddleService null", new Object[0]);
            } else {
                yYPayMiddleService.a(new int[]{1}, new i(this));
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.x = true;
            r4a yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
            if (yYPayMiddleService == null) {
                RLog.error("YYPayAmountView", "queryMyBalance error yyPayMiddleService null", new Object[0]);
            } else {
                yYPayMiddleService.c(new h(this));
            }
        }
    }

    public final void M() {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.w = true;
            IYYPayAmountView.ViewParams viewParams = this.p;
            if (viewParams != null) {
                map = viewParams.clientInfoExpand;
            } else {
                map = null;
            }
            r4a yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
            if (yYPayMiddleService == null) {
                RLog.error("YYPayAmountView", "queryProductList erro yyPayMiddleService null", new Object[0]);
            } else {
                yYPayMiddleService.e(map, new f(this));
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            k7a k7aVar = this.r;
            if (k7aVar == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mSelectedPayAmount null", new Object[0]);
                return;
            }
            List<PayWayInfo> list = this.D;
            if (list == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mPayWayInfoList null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.t;
            if (callback != null) {
                callback.toPayWayDialog(k7aVar, list, this.E);
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            IYYPayAmountView.ViewParams viewParams = this.p;
            if (viewParams == null) {
                RLog.error("YYPayAmountView", "onBtnLeftClick error mViewParams null", new Object[0]);
                return;
            }
            boolean z = viewParams.showFaqPage;
            if (z) {
                IYYPayAmountView.Callback callback = this.t;
                if (callback != null) {
                    callback.toHelpCenterPage();
                }
            } else {
                d7a.d(this.y, this.z);
            }
            q7a.d(this.y, this.z, "25", "", "", "");
            RLog.info("YYPayAmountView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.t);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            RLog.info("YYPayAmountView", "updateBubbleMsgView mBubbleActMsg:" + this.E + " mTvBubbleMsg:" + this.g);
            TextView textView = this.g;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            if (!TextUtils.isEmpty(this.E)) {
                this.g.setVisibility(0);
                this.g.setText(this.E);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final void Z() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (textView = this.e) != null && this.q != 0) {
            textView.setVisibility(0);
            this.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0dd3), Long.valueOf(this.q)));
            this.e.setOnLongClickListener(new g(this));
        }
    }

    public final void J(int i2, int i3, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, str) == null) {
            if (n8a.a.a(this.a) && i3 != -800) {
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
            IYYPayAmountView.Callback callback = this.t;
            if (callback != null) {
                callback.onRefreshViewFail(i3, str);
            }
        }
    }

    public final int N(ProductListResult productListResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, productListResult)) == null) {
            List<ProductInfo> productInfoList = productListResult.getProductInfoList();
            int i2 = 0;
            if (productInfoList != null && productInfoList.size() != 0) {
                this.n.clear();
                int i3 = 0;
                for (int i4 = 0; i4 < productInfoList.size(); i4++) {
                    k7a k7aVar = new k7a(productInfoList.get(i4), productListResult.getCurrencyType());
                    if (productInfoList.get(i4).cid == this.v) {
                        i3 = i4;
                    }
                    this.n.add(k7aVar);
                }
                if (!R()) {
                    i2 = i3;
                }
                if (this.n.size() < 6) {
                    this.n.add(new k7a(true));
                }
                return i2;
            }
            RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
            return -1;
        }
        return invokeL.intValue;
    }

    public final void Q(ProductListResult productListResult) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, productListResult) == null) {
            if (productListResult == null) {
                RLog.error("YYPayAmountView", "showProductListView error result null", new Object[0]);
            } else if (this.j != null && this.l != null) {
                this.v = productListResult.defaultCid;
                if (productListResult.getCurrencyName() != null) {
                    str = productListResult.getCurrencyName();
                } else {
                    str = "Y币";
                }
                this.u = str;
                this.l.i(str);
                int N = N(productListResult);
                if (N < 0) {
                    RLog.error("YYPayAmountView", "showProductListView error defaultSelectIndex < 0", new Object[0]);
                    return;
                }
                int i2 = 2;
                if (this.l.getCount() >= 2) {
                    z = true;
                } else {
                    z = false;
                }
                int A = A(this.l.getCount());
                if (z) {
                    if (A != 2) {
                        i2 = 3;
                    }
                    k7a k7aVar = new k7a(null, 0);
                    k7aVar.d = true;
                    this.n.add(i2, k7aVar);
                    if (N >= i2) {
                        N++;
                    }
                } else {
                    i2 = 0;
                }
                RLog.info("YYPayAmountView", "showProductListView mDefaultCid:" + this.v + " spanCount:" + A + " campaignItemPosition:" + i2 + " shouldAddCampaignItem:" + z + " defaultSelectIndex：" + N);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a, A);
                gridLayoutManager.setSpanSizeLookup(new j(this, gridLayoutManager));
                this.j.setLayoutManager(gridLayoutManager);
                this.j.setAdapter(this.l);
                this.j.addItemDecoration(new PayAmountGridItemDecoration(A, v7a.a(10.0f), v7a.a(10.0f), i2, gridLayoutManager));
                this.l.l(A);
                this.l.h(i2);
                this.l.k(N);
                this.l.notifyDataSetChanged();
                this.r = this.n.get(N);
                this.D = productListResult.getPayWayInfoList();
                this.E = productListResult.getBubbleActMsg();
                T();
                U(false);
                V(this.l.e());
                X(productListResult.getPaysSettingInfo());
                l7a.h(productListResult.getPaysSettingInfo(), "YYPayAmountView");
                Y("showProductListView");
            }
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            List<k7a> list = this.n;
            if (list != null && !list.isEmpty()) {
                IYYPayAmountView.ViewParams viewParams = this.p;
                if (viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_TARGET_PAY) {
                    z = true;
                } else {
                    z = false;
                }
                RLog.info("YYPayAmountView", "tryModifyTargetAmount modifyTargetAmount:" + z);
                if (z) {
                    if (this.C != null) {
                        RLog.info("YYPayAmountView", "tryModifyTargetAmount targetAmount:" + this.p.targetAmount + " amount:" + this.C.amount);
                        int i2 = this.p.targetAmount;
                        long j2 = this.C.amount;
                        if (i2 > j2) {
                            k7a c2 = z7a.c(this.n, this.m, i2, j2);
                            RLog.error("YYPayAmountView", "tryModifyTargetAmount payAmount:" + c2, new Object[0]);
                            if (c2 == null) {
                                return false;
                            }
                            return true;
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

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void W() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.C == null) {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
            } else if (this.d != null && (activity = this.a) != null && !activity.isFinishing()) {
                String str = null;
                MyBalanceInfo.Account account = this.C;
                int i2 = account.currencyType;
                String a2 = k8a.a(account.amount / 100.0d);
                IYYPayAmountView.ViewParams viewParams = this.p;
                if (viewParams != null) {
                    int i3 = viewParams.targetAmount;
                    long j2 = this.C.amount;
                    if (i3 > j2) {
                        str = k8a.a((i3 - j2) / 100.0d);
                    }
                }
                this.d.setVisibility(0);
                if (str != null) {
                    if (i2 == 4) {
                        this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0dc4), a2, str));
                    } else {
                        this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0dc5), a2, str));
                    }
                } else if (i2 == 4) {
                    this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0dc3), a2));
                } else {
                    this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0dc6), a2));
                }
            } else {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            RLog.debug("YYPayAmountView", "updateBanner: count=" + this.o.size());
            if (this.o.size() == 0) {
                this.k.setVisibility(8);
                return;
            }
            int i2 = this.s;
            if (i2 > 0) {
                this.k.setFlipInterval(i2);
            }
            this.k.setData(this.o);
            this.k.setOnItemClickListener(new d(this));
            this.k.setBannerItemSelectListener(new e(this));
            this.k.setVisibility(0);
        }
    }

    public final void X(PaysSettingInfo paysSettingInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, paysSettingInfo) == null) && paysSettingInfo != null && !TextUtils.isEmpty(paysSettingInfo.payRemindMsg) && this.f != null) {
            RLog.debug("YYPayAmountView", "updatePayRemindTextView payRemindMsg:" + paysSettingInfo.payRemindMsg);
            this.f.setText(paysSettingInfo.payRemindMsg);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.o8a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, window) == null) {
            RLog.debug("YYPayAmountView", "attachWindow window:" + window);
            this.F = window;
            IYYPayAmountView.ViewParams viewParams = this.p;
            if (viewParams != null) {
                refreshWindow(viewParams.windowParams);
            }
            Y(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
        }
    }
}
