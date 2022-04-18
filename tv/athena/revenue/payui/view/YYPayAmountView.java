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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a6a;
import com.repackage.g6a;
import com.repackage.h6a;
import com.repackage.j6a;
import com.repackage.l6a;
import com.repackage.n6a;
import com.repackage.u6a;
import com.repackage.v6a;
import com.repackage.w4a;
import com.repackage.x5a;
import com.repackage.x6a;
import com.repackage.y5a;
import com.repackage.z5a;
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
/* loaded from: classes9.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public w4a B;
    public ProductListResult C;
    public MyBalanceInfo.Account D;
    public Activity a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public ImageView h;
    public x5a i;
    public RecyclerView j;
    public PluginCenterTopBanner k;
    public PayAmountAdapter l;
    public PayUIKitConfig m;
    public List<y5a> n;
    public List<BannerConfigItem.BannerInfo> o;
    public IYYPayAmountView.ViewParams p;
    public long q;
    public List<PayWayInfo> r;
    public y5a s;
    public int t;
    public IYYPayAmountView.Callback u;
    public String v;
    public int w;
    public volatile boolean x;
    public volatile boolean y;
    public int z;

    /* loaded from: classes9.dex */
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
                this.a.C(i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || i >= this.a.o.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.o.get(i);
            RLog.debug("YYPayAmountView", "onItemClick: click=" + bannerInfo.jumpData);
            if (this.a.p != null && this.a.p.viewEventListener != null) {
                this.a.p.viewEventListener.onBannerClick(bannerInfo);
            }
            g6a.d(this.a.z, this.a.A, "19", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes9.dex */
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
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i < 0 || i >= this.a.o.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.o.get(i);
            RLog.debug("YYPayAmountView", "onItemSelected: item=" + bannerInfo);
            g6a.d(this.a.z, this.a.A, "18", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes9.dex */
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
                this.a.A();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                this.a.x = false;
                RLog.error("YYPayAmountView", "queryProductList onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.D(1021, i, str);
                this.a.z();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                h6a.a(String.valueOf(this.a.q), this.a.a);
                Toast.makeText(this.a.a, "YY号已复制到剪贴板", 1).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
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
                this.a.q = myBalanceResult.getMyBalanceInfo() != null ? myBalanceResult.getMyBalanceInfo().getImid() : 0L;
                this.a.R();
                MiddleRevenueConfig middleRevenueConfig = this.a.m != null ? this.a.m.revenueConfig : null;
                MyBalanceInfo.Account myBalance = middleRevenueConfig != null ? myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType()) : null;
                if (myBalance != null) {
                    this.a.D = myBalance;
                    this.a.A();
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
                this.a.D(1005, i, str);
                this.a.z();
            }
        }
    }

    /* loaded from: classes9.dex */
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
                this.a.o.addAll(list);
                this.a.M();
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
    public class i extends GridLayoutManager.SpanSizeLookup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridLayoutManager a;
        public final /* synthetic */ YYPayAmountView b;

        public i(YYPayAmountView yYPayAmountView, GridLayoutManager gridLayoutManager) {
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
                y5a e = this.b.l.e(i);
                if (e == null || !e.d) {
                    return 1;
                }
                return this.a.getSpanCount();
            }
            return invokeI.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig, IYYPayAmountView.ViewParams viewParams, x5a x5aVar, w4a w4aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, viewParams, x5aVar, w4aVar};
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
        this.v = "Y币";
        this.a = activity;
        this.i = x5aVar;
        this.m = payUIKitConfig;
        this.p = viewParams;
        this.z = i2;
        this.A = i3;
        this.B = w4aVar;
        y(activity);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z();
            boolean z = (this.x || this.y) ? false : true;
            RLog.info("YYPayAmountView", "notifyUpdateDataView hasLoadAllData:" + z);
            if (z) {
                P();
                K(this.C);
            }
        }
    }

    public final void B() {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v();
            y5a y5aVar = this.s;
            g6a.d(this.z, this.A, "2", "", "", String.valueOf((y5aVar == null || (productInfo = y5aVar.a) == null) ? 0 : productInfo.cid));
        }
    }

    public final void C(int i2) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            y5a e2 = this.l.e(i2);
            int i3 = 0;
            if (e2 == null) {
                RLog.error("YYPayAmountView", "onPayAmountItemClick error payAmount null", new Object[0]);
            } else if (e2.c) {
                I();
                N(true);
            } else {
                this.s = e2;
                this.l.l(i2);
                this.l.notifyDataSetChanged();
                O(e2);
                N(false);
                y5a y5aVar = this.s;
                if (y5aVar != null && (productInfo = y5aVar.a) != null) {
                    i3 = productInfo.cid;
                }
                g6a.d(this.z, this.A, "3", "", "", String.valueOf(i3));
            }
        }
    }

    public final void D(int i2, int i3, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) {
            if (x6a.a.a(this.a) && i3 != -800) {
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

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            GetBannerConfigReqParams a2 = this.i.a();
            a2.setTypes(new int[]{1});
            RLog.info("YYPayAmountView", "queryBannerConfig: " + a2);
            z5a.a(a2, new h(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            QueryCurrencyReqParams c2 = this.i.c();
            this.y = true;
            z5a.b(c2, new g(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.x = true;
            z5a.c(this.i.d(), new e(this));
        }
    }

    public final int H(ProductListResult productListResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, productListResult)) == null) {
            List<ProductInfo> productInfoList = productListResult.getProductInfoList();
            if (productInfoList != null && productInfoList.size() != 0) {
                this.n.clear();
                int i2 = 0;
                for (int i3 = 0; i3 < productInfoList.size(); i3++) {
                    y5a y5aVar = new y5a(productInfoList.get(i3), productListResult.getCurrencyType());
                    if (productInfoList.get(i3).cid == this.w) {
                        i2 = i3;
                    }
                    this.n.add(y5aVar);
                }
                int i4 = L() ? 0 : i2;
                if (this.n.size() < 6) {
                    this.n.add(new y5a(true));
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
            List<PayWayInfo> list = this.r;
            if (list == null) {
                RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.u;
            if (callback != null) {
                callback.showInputNumberDialog(this.a, list);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l6a.b(this.g, this.h);
        }
    }

    public final void K(ProductListResult productListResult) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, productListResult) == null) {
            if (productListResult == null) {
                RLog.error("YYPayAmountView", "showProductListView error result null", new Object[0]);
            } else if (this.j == null || this.l == null) {
            } else {
                this.w = productListResult.defaultCid;
                String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
                this.v = currencyName;
                this.l.j(currencyName);
                int H = H(productListResult);
                if (H < 0) {
                    RLog.error("YYPayAmountView", "showProductListView error defaultSelectIndex < 0", new Object[0]);
                    return;
                }
                boolean z = this.l.getCount() >= 2;
                int w = w(this.l.getCount());
                if (z) {
                    i2 = w != 2 ? 3 : 2;
                    y5a y5aVar = new y5a(null, 0);
                    y5aVar.d = true;
                    this.n.add(i2, y5aVar);
                    if (H >= i2) {
                        H++;
                    }
                } else {
                    i2 = 0;
                }
                RLog.info("YYPayAmountView", "showProductListView mDefaultCid:" + this.w + " spanCount:" + w + " campaignItemPosition:" + i2 + " shouldAddCampaignItem:" + z + " defaultSelectIndex：" + H);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a, w);
                gridLayoutManager.setSpanSizeLookup(new i(this, gridLayoutManager));
                this.j.setLayoutManager(gridLayoutManager);
                this.j.setAdapter(this.l);
                this.j.addItemDecoration(new PayAmountGridItemDecoration(w, j6a.a(10.0f), j6a.a(10.0f), i2, gridLayoutManager));
                this.l.m(w);
                this.l.i(i2);
                this.l.l(H);
                this.l.notifyDataSetChanged();
                this.s = this.n.get(H);
                this.r = productListResult.getPayWayInfoList();
                N(false);
                O(this.l.f());
                Q(productListResult.getPaysSettingInfo());
                a6a.a = productListResult.getPaysSettingInfo();
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            List<y5a> list = this.n;
            if (list != null && !list.isEmpty()) {
                IYYPayAmountView.ViewParams viewParams = this.p;
                boolean z = viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_TARGET_PAY;
                RLog.info("YYPayAmountView", "tryModifyTargetAmount modifyTargetAmount:" + z);
                if (z) {
                    if (this.D != null) {
                        RLog.info("YYPayAmountView", "tryModifyTargetAmount targetAmount:" + this.p.targetAmount + " amount:" + this.D.amount);
                        int i2 = this.p.targetAmount;
                        long j = this.D.amount;
                        if (i2 > j) {
                            y5a c2 = n6a.c(this.n, this.m, i2, j);
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
            RLog.debug("YYPayAmountView", "updateBanner: count=" + this.o.size());
            if (this.o.size() == 0) {
                this.k.setVisibility(8);
                return;
            }
            int i2 = this.t;
            if (i2 > 0) {
                this.k.setFlipInterval(i2);
            }
            this.k.setData(this.o);
            this.k.setOnItemClickListener(new c(this));
            this.k.setBannerItemSelectListener(new d(this));
            this.k.setVisibility(0);
        }
    }

    public final void N(boolean z) {
        y5a y5aVar;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (!z && (y5aVar = this.s) != null && (productInfo = y5aVar.a) != null && (list = productInfo.giftbags) != null && list.size() > 0) {
                this.B.d(this.s.a.giftbags.get(0));
                PayAmountAdapter payAmountAdapter = this.l;
                payAmountAdapter.o(payAmountAdapter.g());
                return;
            }
            this.B.d(null);
            this.l.o(-1);
        }
    }

    public final void O(y5a y5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, y5aVar) == null) {
            if (this.b == null) {
                RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
            } else if (y5aVar == null) {
                RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
            } else {
                this.b.setText("立即充值" + u6a.a(y5aVar.b()) + "元");
            }
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void P() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.D == null) {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
            } else if (this.d != null && (activity = this.a) != null && !activity.isFinishing()) {
                String str = null;
                MyBalanceInfo.Account account = this.D;
                int i2 = account.currencyType;
                String a2 = u6a.a(account.amount / 100.0d);
                IYYPayAmountView.ViewParams viewParams = this.p;
                if (viewParams != null) {
                    int i3 = viewParams.targetAmount;
                    long j = this.D.amount;
                    if (i3 > j) {
                        str = u6a.a((i3 - j) / 100.0d);
                    }
                }
                this.d.setVisibility(0);
                if (str != null) {
                    if (i2 == 4) {
                        this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d52), a2, str));
                    } else {
                        this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d53), a2, str));
                    }
                } else if (i2 == 4) {
                    this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d51), a2));
                } else {
                    this.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d54), a2));
                }
            } else {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
            }
        }
    }

    public final void Q(PaysSettingInfo paysSettingInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, paysSettingInfo) == null) || paysSettingInfo == null || TextUtils.isEmpty(paysSettingInfo.payRemindMsg) || this.f == null) {
            return;
        }
        RLog.debug("YYPayAmountView", "updatePayRemindTextView payRemindMsg:" + paysSettingInfo.payRemindMsg);
        this.f.setText(paysSettingInfo.payRemindMsg);
    }

    public final void R() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (textView = this.e) == null || this.q == 0) {
            return;
        }
        textView.setVisibility(0);
        this.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d61), Long.valueOf(this.q)));
        this.e.setOnLongClickListener(new f(this));
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.repackage.y6a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.repackage.y6a
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
            this.u = callback;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            y5a y5aVar = this.s;
            if (y5aVar == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mSelectedPayAmount null", new Object[0]);
                return;
            }
            List<PayWayInfo> list = this.r;
            if (list == null) {
                RLog.error("YYPayAmountView", "confirmRecharge error mPayWayInfoList null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.u;
            if (callback != null) {
                callback.toPayWayDialog(y5aVar, list);
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
            l6a.a(this.g, this.h);
        }
    }

    public final void y(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, activity) == null) {
            LayoutInflater.from(new ContextThemeWrapper(activity, v6a.a.a(this.m))).inflate(R.layout.obfuscated_res_0x7f0d0665, (ViewGroup) this, true);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092163);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f092216);
            PayAmountAdapter payAmountAdapter = new PayAmountAdapter(this.a, this.B, this.n, this.m);
            this.l = payAmountAdapter;
            payAmountAdapter.j(this.v);
            this.j = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090cf5);
            this.l.k(new a(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090418);
            this.b = textView;
            textView.setOnClickListener(new b(this));
            O(this.l.f());
            PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f090300);
            this.k = pluginCenterTopBanner;
            PayUIKitConfig payUIKitConfig = this.m;
            if (payUIKitConfig != null) {
                pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
            }
            this.g = findViewById(R.id.obfuscated_res_0x7f091ad7);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fdb);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0921a6);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092156);
            g6a.d(this.z, this.A, "1", "", "", "");
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean z = (this.x || this.y) ? false : true;
            RLog.info("YYPayAmountView", "notifyHideLoadingView hasLoadAllData:" + z);
            if (z) {
                x();
            }
        }
    }
}
