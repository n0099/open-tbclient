package tv.athena.revenue.payui.view.impl;

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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.tieba.R;
import com.baidu.tieba.bka;
import com.baidu.tieba.bma;
import com.baidu.tieba.bna;
import com.baidu.tieba.dma;
import com.baidu.tieba.ema;
import com.baidu.tieba.jla;
import com.baidu.tieba.ona;
import com.baidu.tieba.qla;
import com.baidu.tieba.rla;
import com.baidu.tieba.rma;
import com.baidu.tieba.sla;
import com.baidu.tieba.tla;
import com.baidu.tieba.tma;
import com.baidu.tieba.wla;
import com.baidu.tieba.xia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PackageInstallUtil;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes9.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<tla> a;
    public GridView b;
    public bna c;
    public View d;
    public ImageView e;
    public int f;
    public int g;
    public IYYPayWayView.a h;
    public tla i;
    public Button j;
    public qla k;
    public IYYPayWayView.b l;
    public Context m;
    public TextView n;
    public PayUIKitConfig o;
    public String p;
    public AppCustomExpand q;
    public TextView r;
    public TextView s;
    public TextView t;
    public Window u;
    public bka v;
    public String w;
    public PayFlowType x;

    @Override // com.baidu.tieba.uma
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWayView a;

        public a(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWayView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.r(i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends ona {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWayView b;

        public b(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yYPayWayView;
        }

        @Override // com.baidu.tieba.ona
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.l();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWayView a;

        public c(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.u();
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWayView a;

        public d(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.q();
        }
    }

    /* loaded from: classes9.dex */
    public class e implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWayView a;

        public e(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWayView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                if (productListResult != null && productListResult.getPayWayInfoList() != null) {
                    rla.h(productListResult.getPaysSettingInfo(), "YYPayWayView");
                    this.a.B(productListResult.getPayWayInfoList());
                    this.a.z(productListResult.getBubbleActMsg());
                } else {
                    RLog.error("YYPayWayView", "server payway list empty", new Object[0]);
                    this.a.s(1021);
                }
                this.a.n();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.t(1021, i, str);
                this.a.n();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Activity activity, int i, int i2, IYYPayWayView.b bVar, PayUIKitConfig payUIKitConfig, bka bkaVar) {
        super(activity);
        PayFlowType payFlowType;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), bVar, payUIKitConfig, bkaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.p = "";
        this.w = "0";
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        LayoutInflater.from(new ContextThemeWrapper(activity, rma.a.a(payUIKitConfig))).inflate(R.layout.pay_ui_layout_pay_way_view, (ViewGroup) this, true);
        this.l = bVar;
        this.k = bVar.c;
        this.m = activity;
        this.o = payUIKitConfig;
        this.f = i;
        this.g = i2;
        this.q = bVar.d;
        this.v = bkaVar;
        if (bVar != null) {
            String str2 = bVar.k;
            this.w = str2 != null ? str2 : "0";
        }
        RLog.debug("YYPayWayView", "mSplitOrderPayScene:" + this.w);
        this.c = new bna(activity, payUIKitConfig, this.a);
        GridView gridView = (GridView) findViewById(R.id.grid_recharge_way);
        this.b = gridView;
        gridView.setSelector(R.drawable.pay_ui_selector_transparent);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(new a(this));
        Button button = (Button) findViewById(R.id.btn_confirm_recharge);
        this.j = button;
        button.setOnClickListener(new b(this));
        this.r = (TextView) findViewById(R.id.tv_total_src_amount);
        this.s = (TextView) findViewById(R.id.tv_total_dst_amount);
        this.t = (TextView) findViewById(R.id.tv_bubble_msg);
        TextView textView = (TextView) findViewById(R.id.tv_use_item);
        this.n = textView;
        textView.setOnClickListener(new c(this));
        this.d = findViewById(R.id.root_loading);
        this.e = (ImageView) findViewById(R.id.iv_loading_circle);
        IYYPayWayView.b bVar2 = this.l;
        if (bVar2 != null) {
            payFlowType = bVar2.h;
        } else {
            payFlowType = null;
        }
        this.x = payFlowType;
        if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
            str = "11";
        } else {
            str = "4";
        }
        wla.d(this.f, this.g, str, "", "", this.w);
        y();
        B(this.l.a);
        z(this.l.b);
    }

    public final boolean k(sla slaVar) {
        InterceptResult invokeL;
        SplitOrderConfigResult splitOrderConfigResult;
        List<SplitRecordItem> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, slaVar)) == null) {
            if (slaVar != null && (splitOrderConfigResult = slaVar.a) != null && (list = splitOrderConfigResult.splitRecordItemList) != null && !list.isEmpty() && slaVar.b != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.h = aVar;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dma.b(this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public boolean d() {
        InterceptResult invokeV;
        IYYPayWayView.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            sla b2 = this.v.b();
            if (k(b2) && (aVar = this.h) != null) {
                aVar.c(b2);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            dma.a(this.d, this.e);
        }
    }

    public final void w() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.a.size() > 4 && (gridView = this.b) != null) {
            ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
            layoutParams.height += bma.a(24.0f);
            this.b.setLayoutParams(layoutParams);
        }
    }

    public final void B(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a.clear();
            this.a.addAll(m(list));
            if (this.a.size() > 0) {
                this.i = this.a.get(0);
                this.c.c(0);
            }
            if (Env.instance().isTestEnv() && this.a.size() > 0) {
                this.a.add(new tla(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.c.notifyDataSetChanged();
            w();
            C("showPayWayListView");
        }
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i = this.c.getItem(i);
            if (this.c.b() != i) {
                this.c.c(i);
                this.c.notifyDataSetChanged();
            }
            v();
            RLog.info("YYPayWayView", "choose paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            if (this.i.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            }
        }
    }

    public final void C(String str) {
        IFeedbackServiceProxy iFeedbackServiceProxy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.u != null && rla.d() != null) {
                View findViewById = this.u.findViewById(R.id.btn_left);
                int i = 0;
                if (findViewById == null) {
                    RLog.error("YYPayWayView", "updateTopLeftBtn error btnLeft null", new Object[0]);
                    return;
                }
                findViewById.setOnClickListener(new d(this));
                YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.f, this.g);
                if (uIKit != null) {
                    iFeedbackServiceProxy = uIKit.getFeedbackServiceProxy();
                } else {
                    iFeedbackServiceProxy = null;
                }
                boolean z = true;
                z = (rla.d().feedbackSwitch != 1 || iFeedbackServiceProxy == null) ? false : false;
                if (!z) {
                    i = 8;
                }
                findViewById.setVisibility(i);
                if (z) {
                    wla.d(this.f, this.g, "26", "", "", "");
                }
                RLog.info("YYPayWayView", "updateTopLeftBtn from:" + str + " proxy:" + iFeedbackServiceProxy + " feedbackSwitch:" + rla.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
                return;
            }
            RLog.warn("YYPayWayView", "updateTopLeftBtn from:" + str + " mWindow:" + this.u + " paysSettingInfo:" + rla.d());
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void a() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RLog.info("YYPayWayView", "onBtnCloseClick mSplitOrderPayScene:" + this.w + " mPayFlowType:" + this.x);
            if (this.i == null) {
                RLog.error("YYPayWayView", "onBtnCloseClick error mPayWay null", new Object[0]);
                return;
            }
            if (this.x == PayFlowType.WALLET_PAY_FLOW) {
                str = PayUVEventType.PAY_WAY_FULL_PAGE_CLOSE_BTN_CLICK;
            } else {
                str = PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK;
            }
            wla.d(this.f, this.g, str, this.i.a.getChannel(), this.i.a.getMethod(), this.w);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            IYYPayWayView.b bVar = this.l;
            if (bVar == null) {
                RLog.error("YYPayWayView", "onBtnLeftClick error mViewParams null", new Object[0]);
                return;
            }
            boolean z = bVar.j;
            if (z) {
                IYYPayWayView.a aVar = this.h;
                if (aVar != null) {
                    aVar.toHelpCenterPage();
                }
            } else {
                jla.d(this.f, this.g);
            }
            wla.d(this.f, this.g, PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, "", "", "");
            RLog.info("YYPayWayView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.h);
        }
    }

    @Override // com.baidu.tieba.uma
    public void refreshView() {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean z = false;
            if (this.a.size() <= 0) {
                A();
                IYYPayWayView.b bVar = this.l;
                if (bVar != null) {
                    map = bVar.e;
                } else {
                    map = null;
                }
                xia yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.f, this.g);
                if (yYPayMiddleService == null) {
                    RLog.error("YYPayWayView", "refreshView error yyPayMiddleService null", new Object[0]);
                    return;
                } else {
                    yYPayMiddleService.e(map, new e(this));
                    z = true;
                }
            }
            RLog.info("YYPayWayView", "refreshView isQueryProductList:" + z);
        }
    }

    @Override // com.baidu.tieba.uma
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, window) == null) {
            RLog.debug("YYPayWayView", "attachWindow window:" + window);
            this.u = window;
            IYYPayWayView.b bVar = this.l;
            if (bVar != null) {
                refreshWindow(bVar.i);
            }
            C(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
        }
    }

    public final boolean o(PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, payType)) == null) {
            if (payType != PayType.ALI_PAY) {
                return false;
            }
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.f, this.g);
            if (uIKit == null) {
                RLog.error("YYPayWayView", "isPayFrequency error yyPayUIKit null", new Object[0]);
                return false;
            }
            boolean isPayFrequency = uIKit.isPayFrequency();
            RLog.info("YYPayWayView", "isPayFrequency:" + isPayFrequency);
            return isPayFrequency;
        }
        return invokeL.booleanValue;
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            if (tma.a.a(this.m)) {
                Toast.makeText(this.m, "请求服务失败(" + i + "e)", 1).show();
            }
            IYYPayWayView.a aVar = this.h;
            if (aVar != null) {
                aVar.onRefreshViewFail(-1, "server payway list empty");
            }
        }
    }

    public void l() {
        qla qlaVar;
        qla qlaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            tla tlaVar = this.i;
            if (tlaVar == null) {
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            } else if (this.c == null) {
                RLog.error("YYPayWayView", "mPayWayListAdapter null", new Object[0]);
            } else if (tlaVar.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            } else if (o(this.i.a)) {
                Context context = this.m;
                Toast.makeText(context, context.getString(R.string.pay_ui_pay_too_frequency_msg), 1).show();
                RLog.warn("YYPayWayView", "pay too frequency return mPayWay:" + this.i);
            } else {
                if (Env.instance().isTestEnv() && this.i.a == PayType.MOCK_TEST_PAY && (qlaVar2 = this.k) != null) {
                    ProductInfo productInfo = qlaVar2.a;
                    if (productInfo.srcAmount > 10.0d) {
                        productInfo.srcAmount = 10.0d;
                        productInfo.destAmount = 1000L;
                    }
                }
                if (this.h != null && (qlaVar = this.k) != null && qlaVar.a != null) {
                    if (p(this.i, qlaVar)) {
                        this.h.a(this.i, this.k, this.q);
                    } else {
                        this.h.b(this.i, this.k, this.q);
                    }
                    wla.c(this.f, this.g, PayUIEventType.paypagepaybt, String.valueOf(this.k.a.srcAmount));
                    RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.k.a.srcAmount);
                } else {
                    RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                }
                x();
                RLog.info("YYPayWayView", "comfirm paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            }
        }
    }

    public List<tla> m(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    PayWayInfo payWayInfo = list.get(i);
                    if (PayType.ALI_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.ALI_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new tla(PayType.ALI_PAY, payWayInfo.name, payWayInfo.tips, payWayInfo.perFreePassAmount));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.WECHAT_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new tla(PayType.WECHAT_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new tla(PayType.DXM_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_KJ.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_KJ.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new tla(PayType.DXM_PAY_KJ, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.QQ_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.QQ_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new tla(PayType.QQ_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.UNION_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.UNION_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new tla(PayType.UNION_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_H5.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_H5.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new tla(PayType.DXM_PAY_H5, payWayInfo.name, payWayInfo.tips));
                    }
                }
                return arrayList;
            }
            RLog.info("YYPayWayView", "createRechargeWayList but mPayWayInfoList null");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean p(tla tlaVar, qla qlaVar) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, tlaVar, qlaVar)) == null) {
            if (qlaVar.c() <= tlaVar.f && tlaVar.a == PayType.ALI_PAY && qlaVar.c() > 0.0d) {
                z = true;
            } else {
                z = false;
            }
            RLog.info("YYPayWayView", "isSupportSignPay result=" + z + ", perFreePassAmount=" + tlaVar.f + ", payType=" + tlaVar.a);
            return z;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.uma
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, windowParams) == null) {
            RLog.debug("YYPayWayView", "refreshWindow params:" + windowParams + " mWindow:" + this.u);
            if (this.u != null && windowParams != null) {
                IYYPayWayView.b bVar = this.l;
                if (bVar != null) {
                    bVar.i = windowParams;
                }
                WindowManager.LayoutParams attributes = this.u.getAttributes();
                attributes.dimAmount = windowParams.dimAmount;
                try {
                    this.u.setAttributes(attributes);
                } catch (Exception e2) {
                    RLog.error("YYPayWayView", "refreshWindow e:" + e2, new Object[0]);
                }
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, payViewState) == null) {
            if (payViewState == IYYPayWayView.PayViewState.WAITING_VIEW_STATE) {
                RLog.debug("YYPayWayView", "setViewState waiting");
                Button button = this.j;
                if (button == null) {
                    return;
                }
                this.p = button.getText().toString();
                this.j.setText("等待支付结果...");
                this.j.setClickable(false);
            } else if (payViewState == IYYPayWayView.PayViewState.SELECTING_VIEW_STATE) {
                RLog.debug("YYPayWayView", "setViewState selecting");
                Button button2 = this.j;
                if (button2 == null) {
                    return;
                }
                button2.setText(this.p);
                this.j.setClickable(true);
            }
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            RLog.info("YYPayWayView", "showBubbleActMsgView bubbleActMsg:" + str + " mTvBubbleMsg:" + this.t);
            TextView textView = this.t;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.t.setVisibility(0);
                this.t.setText(str);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public final void t(int i, int i2, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048596, this, i, i2, str) == null) {
            if (tma.a.a(this.m)) {
                if (i2 == -500) {
                    sb = new StringBuilder();
                    sb.append("网络不给力,请稍后重试(");
                    sb.append(i);
                    sb.append("w)");
                } else {
                    sb = new StringBuilder();
                    sb.append("请求服务失败(");
                    sb.append(i);
                    sb.append("w) code:");
                    sb.append(i2);
                    sb.append(" failReason:");
                    sb.append(str);
                }
                Toast.makeText(this.m, sb.toString(), 1).show();
            }
            IYYPayWayView.a aVar = this.h;
            if (aVar != null) {
                aVar.onRefreshViewFail(i2, str);
            }
        }
    }

    public final void u() {
        PayUIKitConfig payUIKitConfig;
        PayFlowType payFlowType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (payUIKitConfig = this.o) != null) {
            String f = rla.f(payUIKitConfig);
            RLog.debug("YYPayWayView", "agreeUrl:" + f);
            if (this.m instanceof Activity) {
                IYYPayWayView.b bVar = this.l;
                if (bVar != null) {
                    payFlowType = bVar.h;
                } else {
                    payFlowType = null;
                }
                if (payFlowType != null) {
                    ema.a(payFlowType, this.f, this.g, this.o, (Activity) this.m, f, "Y币充值协议");
                } else {
                    RLog.error("YYPayWayView", "onUserItemClick error payFlowType null", new Object[0]);
                }
            } else {
                RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
            }
            wla.b(this.f, this.g, PayUIEventType.paypageprotocol);
            RLog.warn("YYPayWayView", PayUIEventType.paypageprotocol);
        }
    }

    public final void v() {
        int i;
        PayFlowType payFlowType;
        String str;
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            qla qlaVar = this.k;
            if (qlaVar != null && (productInfo = qlaVar.a) != null) {
                i = productInfo.cid;
            } else {
                i = 0;
            }
            IYYPayWayView.b bVar = this.l;
            if (bVar != null) {
                payFlowType = bVar.h;
            } else {
                payFlowType = null;
            }
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                str = "13";
            } else {
                str = "6";
            }
            String str2 = str;
            RLog.info("YYPayWayView", "reportPayWayItemClick mSplitOrderPayScene:" + this.w);
            if (!"1".equals(this.w) && !"2".equals(this.w)) {
                wla.d(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
            } else {
                wla.d(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), this.w);
            }
        }
    }

    public final void x() {
        int i;
        PayFlowType payFlowType;
        String str;
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            RLog.info("YYPayWayView", "resportConfirmBtnClick mSplitOrderPayScene:" + this.w);
            qla qlaVar = this.k;
            if (qlaVar != null && (productInfo = qlaVar.a) != null) {
                i = productInfo.cid;
            } else {
                i = 0;
            }
            IYYPayWayView.b bVar = this.l;
            if (bVar != null) {
                payFlowType = bVar.h;
            } else {
                payFlowType = null;
            }
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                str = "12";
            } else {
                str = "5";
            }
            String str2 = str;
            if (!"1".equals(this.w) && !"2".equals(this.w)) {
                wla.d(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
            } else {
                wla.d(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), this.w);
            }
        }
    }

    public final void y() {
        IYYPayWayView.b bVar;
        qla qlaVar;
        boolean z;
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (bVar = this.l) != null && (qlaVar = bVar.c) != null) {
            double c2 = qlaVar.c();
            boolean z2 = true;
            if (c2 == ((long) c2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                format = new DecimalFormat("0").format(c2);
            } else {
                format = new DecimalFormat("0.00").format(c2);
            }
            this.r.setText(format);
            double a2 = this.l.c.a();
            if (a2 != ((long) a2)) {
                z2 = false;
            }
            if (z2) {
                format2 = new DecimalFormat("0").format(a2);
            } else {
                format2 = new DecimalFormat("0.00").format(a2);
            }
            TextView textView = this.s;
            textView.setText(format2 + "Y币");
            this.j.setText("确认支付 " + format2 + "元");
        }
    }
}
