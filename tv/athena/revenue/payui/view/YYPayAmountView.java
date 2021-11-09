package tv.athena.revenue.payui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import i.a.a.e.k.i;
import i.a.a.e.n.k;
import i.a.a.e.n.l;
import i.a.a.e.n.n;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes3.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public volatile boolean B;
    public volatile boolean C;
    public int D;
    public int E;
    public i F;
    public ProductListResult G;
    public MyBalanceInfo.Account H;

    /* renamed from: e  reason: collision with root package name */
    public Activity f73140e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f73141f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f73142g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f73143h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f73144i;
    public TextView j;
    public View k;
    public ImageView l;
    public i.a.a.e.l.b m;
    public NoScrollGridView n;
    public PluginCenterTopBanner o;
    public i.a.a.e.o.e.a p;
    public PayUIKitConfig q;
    public List<i.a.a.e.l.c> r;
    public List<BannerConfigItem.BannerInfo> s;
    public IYYPayAmountView.ViewParams t;
    public long u;
    public List<PayWayInfo> v;
    public i.a.a.e.l.c w;
    public int x;
    public IYYPayAmountView.Callback y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f73145e;

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
            this.f73145e = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f73145e.z(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f73146e;

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
            this.f73146e = yYPayAmountView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f73146e.y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f73147e;

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
            this.f73147e = yYPayAmountView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || i2 >= this.f73147e.s.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.f73147e.s.get(i2);
            RLog.debug("YYPayAmountView", "updateBanner: click=" + bannerInfo.jumpData);
            if (this.f73147e.t == null || this.f73147e.t.viewEventListener == null) {
                return;
            }
            this.f73147e.t.viewEventListener.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f73148a;

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
            this.f73148a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                this.f73148a.B = false;
                this.f73148a.G = productListResult;
                this.f73148a.x();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                this.f73148a.B = false;
                RLog.error("YYPayAmountView", "queryProductList onFail code:" + i2 + " failReason:" + str, new Object[0]);
                this.f73148a.A(1021, i2, str);
                this.f73148a.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f73149e;

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
            this.f73149e = yYPayAmountView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                i.a.a.e.n.a.a(String.valueOf(this.f73149e.u), this.f73149e.f73140e);
                Toast.makeText(this.f73149e.f73140e, "YY号已复制到剪贴板", 1).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements IResult<MyBalanceResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f73150a;

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
            this.f73150a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) {
                this.f73150a.C = false;
                RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
                if (myBalanceResult == null) {
                    RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
                    return;
                }
                this.f73150a.u = myBalanceResult.getMyBalanceInfo() != null ? myBalanceResult.getMyBalanceInfo().getImid() : 0L;
                this.f73150a.O();
                MiddleRevenueConfig middleRevenueConfig = this.f73150a.q != null ? this.f73150a.q.revenueConfig : null;
                MyBalanceInfo.Account myBalance = middleRevenueConfig != null ? myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType()) : null;
                if (myBalance != null) {
                    this.f73150a.H = myBalance;
                    this.f73150a.x();
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
                this.f73150a.C = false;
                RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i2 + " failReason:" + str, new Object[0]);
                this.f73150a.A(1005, i2, str);
                this.f73150a.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayAmountView f73151a;

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
            this.f73151a = yYPayAmountView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) {
                RLog.info("YYPayAmountView", "queryBannerConfig() onSuccess:" + bannerConfigResult);
                this.f73151a.s.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.f73151a.x = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f73151a.s.addAll(list);
                this.f73151a.J();
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
    public YYPayAmountView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig, IYYPayAmountView.ViewParams viewParams, i.a.a.e.l.b bVar, i iVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, viewParams, bVar, iVar};
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
        this.f73140e = activity;
        this.m = bVar;
        this.q = payUIKitConfig;
        this.t = viewParams;
        this.D = i2;
        this.E = i3;
        this.F = iVar;
        v(activity);
    }

    public final void A(int i2, int i3, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (n.f72366a.a(this.f73140e) && i3 != -800) {
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
                Toast.makeText(this.f73140e, sb.toString(), 1).show();
            }
            IYYPayAmountView.Callback callback = this.y;
            if (callback != null) {
                callback.onRefreshViewFail(i3, str);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            GetBannerConfigReqParams a2 = this.m.a();
            a2.setTypes(new int[]{1});
            RLog.info("YYPayAmountView", "queryBannerConfig: " + a2);
            i.a.a.e.l.d.a(a2, new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            QueryCurrencyReqParams c2 = this.m.c();
            this.C = true;
            i.a.a.e.l.d.b(c2, new f(this));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.B = true;
            i.a.a.e.l.d.c(this.m.d(), new d(this));
        }
    }

    public final int E(ProductListResult productListResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, productListResult)) == null) {
            List<ProductInfo> productInfoList = productListResult.getProductInfoList();
            if (productInfoList != null && productInfoList.size() != 0) {
                this.r.clear();
                int i2 = 0;
                for (int i3 = 0; i3 < productInfoList.size(); i3++) {
                    i.a.a.e.l.c cVar = new i.a.a.e.l.c(productInfoList.get(i3), productListResult.getCurrencyType());
                    if (productInfoList.get(i3).cid == this.A) {
                        i2 = i3;
                    }
                    this.r.add(cVar);
                }
                int i4 = I() ? 0 : i2;
                if (this.r.size() < 6) {
                    this.r.add(new i.a.a.e.l.c(true));
                }
                return i4;
            }
            RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
            return -1;
        }
        return invokeL.intValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<PayWayInfo> list = this.v;
            if (list == null) {
                RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
                return;
            }
            IYYPayAmountView.Callback callback = this.y;
            if (callback != null) {
                callback.showInputNumberDialog(this.f73140e, list);
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i.a.a.e.n.e.b(this.k, this.l);
        }
    }

    public final void H(ProductListResult productListResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, productListResult) == null) {
            if (productListResult == null) {
                RLog.error("YYPayAmountView", "showProductListView error result null", new Object[0]);
            } else if (this.n == null || this.p == null) {
            } else {
                this.A = productListResult.defaultCid;
                RLog.info("YYPayAmountView", "showProductListView mDefaultCid:" + this.A);
                String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
                this.z = currencyName;
                this.p.c(currencyName);
                int E = E(productListResult);
                if (E < 0) {
                    RLog.error("YYPayAmountView", "showProductListView error defaultSelectIndex < 0", new Object[0]);
                    return;
                }
                this.n.setNumColumns(t(this.p.getCount()));
                this.w = this.r.get(E);
                this.p.d(E);
                this.p.notifyDataSetChanged();
                this.v = productListResult.getPayWayInfoList();
                K(false);
                L(this.p.b());
                N(productListResult.getPaysSettingInfo());
                i.a.a.e.l.e.f72352a = productListResult.getPaysSettingInfo();
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<i.a.a.e.l.c> list = this.r;
            if (list != null && !list.isEmpty()) {
                IYYPayAmountView.ViewParams viewParams = this.t;
                boolean z = viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_TARGET_PAY;
                RLog.info("YYPayAmountView", "tryModifyTargetAmount modifyTargetAmount:" + z);
                if (z) {
                    if (this.H != null) {
                        RLog.info("YYPayAmountView", "tryModifyTargetAmount targetAmount:" + this.t.targetAmount + " amount:" + this.H.amount);
                        int i2 = this.t.targetAmount;
                        long j = this.H.amount;
                        if (i2 > j) {
                            i.a.a.e.l.c c2 = i.a.a.e.n.g.c(this.r, this.q, i2, j);
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

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
            this.o.setVisibility(0);
        }
    }

    public final void K(boolean z) {
        i.a.a.e.l.c cVar;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            IYYPayAmountView.Callback callback = this.y;
            Dialog payAmountDialog = callback != null ? callback.getPayAmountDialog() : null;
            if (!z && (cVar = this.w) != null && (productInfo = cVar.f72346a) != null && (list = productInfo.giftbags) != null && list.size() > 0) {
                this.F.g(this.w.f72346a.giftbags.get(0), this.f73140e, payAmountDialog);
            } else {
                this.F.g(null, this.f73140e, payAmountDialog);
            }
        }
    }

    public final void L(i.a.a.e.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            if (this.f73141f == null) {
                RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
            } else if (cVar == null) {
                RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
            } else {
                this.f73141f.setText("立即充值" + k.a(cVar.b()) + "元");
            }
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void M() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.H == null) {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
            } else if (this.f73143h != null && (activity = this.f73140e) != null && !activity.isFinishing()) {
                String str = null;
                MyBalanceInfo.Account account = this.H;
                int i2 = account.currencyType;
                String a2 = k.a(account.amount / 100.0d);
                IYYPayAmountView.ViewParams viewParams = this.t;
                if (viewParams != null) {
                    int i3 = viewParams.targetAmount;
                    long j = this.H.amount;
                    if (i3 > j) {
                        str = k.a((i3 - j) / 100.0d);
                    }
                }
                this.f73143h.setVisibility(0);
                if (str != null) {
                    if (i2 == 4) {
                        this.f73143h.setText(String.format(this.f73140e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_not_enough), a2, str));
                    } else {
                        this.f73143h.setText(String.format(this.f73140e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_not_enough_other), a2, str));
                    }
                } else if (i2 == 4) {
                    this.f73143h.setText(String.format(this.f73140e.getString(i.a.a.e.f.pay_ui_str_wallet_amount), a2));
                } else {
                    this.f73143h.setText(String.format(this.f73140e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_other), a2));
                }
            } else {
                RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
            }
        }
    }

    public final void N(PaysSettingInfo paysSettingInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, paysSettingInfo) == null) || paysSettingInfo == null || TextUtils.isEmpty(paysSettingInfo.payRemindMsg) || this.j == null) {
            return;
        }
        RLog.debug("YYPayAmountView", "updatePayRemindTextView payRemindMsg:" + paysSettingInfo.payRemindMsg);
        this.j.setText(paysSettingInfo.payRemindMsg);
    }

    public final void O() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (textView = this.f73144i) == null || this.u == 0) {
            return;
        }
        textView.setVisibility(0);
        this.f73144i.setText(String.format(this.f73140e.getString(i.a.a.e.f.pay_ui_yy_number), Long.valueOf(this.u)));
        this.f73144i.setOnLongClickListener(new e(this));
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            G();
            D();
            C();
            B();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i.a.a.e.l.c cVar = this.w;
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

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, callback) == null) {
            this.y = callback;
        }
    }

    public final int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? i2 < 5 ? 2 : 3 : invokeI.intValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            i.a.a.e.n.e.a(this.k, this.l);
        }
    }

    public final void v(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            LayoutInflater.from(new ContextThemeWrapper(activity, l.f72365a.a(this.q))).inflate(i.a.a.e.e.pay_ui_layout_pay_amount_view, (ViewGroup) this, true);
            this.f73143h = (TextView) findViewById(i.a.a.e.d.tv_amount);
            this.f73144i = (TextView) findViewById(i.a.a.e.d.tv_yy);
            i.a.a.e.o.e.a aVar = new i.a.a.e.o.e.a(this.f73140e, this.r, this.q);
            this.p = aVar;
            aVar.c(this.z);
            NoScrollGridView noScrollGridView = (NoScrollGridView) findViewById(i.a.a.e.d.grid_recharge_amount);
            this.n = noScrollGridView;
            noScrollGridView.setSelector(i.a.a.e.c.pay_ui_selector_transparent);
            this.n.setAdapter((ListAdapter) this.p);
            this.n.setOnItemClickListener(new a(this));
            TextView textView = (TextView) findViewById(i.a.a.e.d.btn_confirm_recharge);
            this.f73141f = textView;
            textView.setOnClickListener(new b(this));
            L(this.p.b());
            PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(i.a.a.e.d.banner);
            this.o = pluginCenterTopBanner;
            PayUIKitConfig payUIKitConfig = this.q;
            if (payUIKitConfig != null) {
                pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
            }
            this.k = findViewById(i.a.a.e.d.root_loading);
            this.l = (ImageView) findViewById(i.a.a.e.d.iv_loading_circle);
            this.f73142g = (TextView) findViewById(i.a.a.e.d.tv_hint);
            this.j = (TextView) findViewById(i.a.a.e.d.tvPayRemind);
            i.a.a.e.m.b.d(this.D, this.E, "1", "", "", "");
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = (this.B || this.C) ? false : true;
            RLog.info("YYPayAmountView", "notifyHideLoadingView hasLoadAllData:" + z);
            if (z) {
                u();
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            w();
            boolean z = (this.B || this.C) ? false : true;
            RLog.info("YYPayAmountView", "notifyUpdateDataView hasLoadAllData:" + z);
            if (z) {
                M();
                H(this.G);
            }
        }
    }

    public final void y() {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            s();
            i.a.a.e.l.c cVar = this.w;
            i.a.a.e.m.b.d(this.D, this.E, "2", "", "", String.valueOf((cVar == null || (productInfo = cVar.f72346a) == null) ? 0 : productInfo.cid));
        }
    }

    public final void z(int i2) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            i.a.a.e.l.c item = this.p.getItem(i2);
            if (item.f72348c) {
                F();
                K(true);
                return;
            }
            this.w = item;
            this.p.d(i2);
            this.p.notifyDataSetChanged();
            L(item);
            int i3 = 0;
            K(false);
            i.a.a.e.l.c cVar = this.w;
            if (cVar != null && (productInfo = cVar.f72346a) != null) {
                i3 = productInfo.cid;
            }
            i.a.a.e.m.b.d(this.D, this.E, "3", "", "", String.valueOf(i3));
        }
    }
}
