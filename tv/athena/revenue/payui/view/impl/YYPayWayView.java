package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.app.Dialog;
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
import com.baidu.tieba.a7a;
import com.baidu.tieba.b7a;
import com.baidu.tieba.c5a;
import com.baidu.tieba.g6a;
import com.baidu.tieba.h8a;
import com.baidu.tieba.l7a;
import com.baidu.tieba.m6a;
import com.baidu.tieba.n6a;
import com.baidu.tieba.n7a;
import com.baidu.tieba.o6a;
import com.baidu.tieba.p6a;
import com.baidu.tieba.q6a;
import com.baidu.tieba.t7a;
import com.baidu.tieba.u6a;
import com.baidu.tieba.y6a;
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
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes9.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<q6a> a;
    public GridView b;
    public t7a c;
    public View d;
    public ImageView e;
    public int f;
    public int g;
    public IYYPayWayView.a h;
    public q6a i;
    public Button j;
    public n6a k;
    public IYYPayWayView.b l;
    public Context m;
    public TextView n;
    public PayUIKitConfig o;
    public String p;
    public AppCustomExpand q;
    public m6a r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public Window w;

    @Override // com.baidu.tieba.o7a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
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
                this.a.n(i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends h8a {
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

        @Override // com.baidu.tieba.h8a
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j();
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
            this.a.q();
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
            this.a.m();
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
                    p6a.h(productListResult.getPaysSettingInfo(), "YYPayWayView");
                    this.a.v(productListResult.getPayWayInfoList());
                    this.a.t(productListResult.getBubbleActMsg());
                } else {
                    RLog.error("YYPayWayView", "server payway list empty", new Object[0]);
                    this.a.o(1021);
                }
                this.a.l();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.p(1021, i, str);
                this.a.l();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Activity activity, int i, int i2, IYYPayWayView.b bVar, m6a m6aVar, PayUIKitConfig payUIKitConfig, c5a c5aVar) {
        super(activity);
        PayFlowType payFlowType;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), bVar, m6aVar, payUIKitConfig, c5aVar};
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
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        LayoutInflater.from(new ContextThemeWrapper(activity, l7a.a.a(payUIKitConfig))).inflate(R.layout.obfuscated_res_0x7f0d06c6, (ViewGroup) this, true);
        this.l = bVar;
        this.k = bVar.c;
        this.m = activity;
        this.o = payUIKitConfig;
        this.f = i;
        this.g = i2;
        this.r = m6aVar;
        this.q = bVar.d;
        this.c = new t7a(activity, payUIKitConfig, this.a);
        GridView gridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090d22);
        this.b = gridView;
        gridView.setSelector(R.drawable.obfuscated_res_0x7f080f0a);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(new a(this));
        Button button = (Button) findViewById(R.id.obfuscated_res_0x7f090447);
        this.j = button;
        button.setOnClickListener(new b(this));
        this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f09245e);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09245d);
        this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f0923b3);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092463);
        this.n = textView;
        textView.setOnClickListener(new c(this));
        this.d = findViewById(R.id.obfuscated_res_0x7f091cc1);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091043);
        this.v = findViewById(R.id.obfuscated_res_0x7f0923fe);
        IYYPayWayView.b bVar2 = this.l;
        if (bVar2 != null) {
            payFlowType = bVar2.h;
        } else {
            payFlowType = null;
        }
        if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
            str = "11";
        } else {
            str = "4";
        }
        u6a.d(this.f, this.g, str, "", "", "");
        s();
        v(this.l.a);
        t(this.l.b);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.h = aVar;
        }
    }

    @Override // com.baidu.tieba.e8a
    public void a(Dialog dialog, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, dialog, z) == null) {
            RLog.info("YYPayWayView", "onWindowFocusChanged tv_ll_user_item:" + this.v);
            View view2 = this.v;
            if (view2 != null) {
                this.v.setLayoutParams((LinearLayout.LayoutParams) view2.getLayoutParams());
            }
        }
    }

    @Override // com.baidu.tieba.o7a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, window) == null) {
            RLog.debug("YYPayWayView", "attachWindow window:" + window);
            this.w = window;
            IYYPayWayView.b bVar = this.l;
            if (bVar != null) {
                refreshWindow(bVar.i);
            }
            w(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (n7a.a.a(this.m)) {
                Toast.makeText(this.m, "请求服务失败(" + i + "e)", 1).show();
            }
            IYYPayWayView.a aVar = this.h;
            if (aVar != null) {
                aVar.onRefreshViewFail(-1, "server payway list empty");
            }
        }
    }

    public void j() {
        PayFlowType payFlowType;
        String str;
        ProductInfo productInfo;
        n6a n6aVar;
        n6a n6aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            q6a q6aVar = this.i;
            int i = 0;
            if (q6aVar == null) {
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            } else if (q6aVar.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            } else {
                if (Env.instance().isTestEnv() && this.i.a == PayType.MOCK_TEST_PAY && (n6aVar2 = this.k) != null) {
                    ProductInfo productInfo2 = n6aVar2.a;
                    if (productInfo2.srcAmount > 10.0d) {
                        productInfo2.srcAmount = 10.0d;
                        productInfo2.destAmount = 1000L;
                    }
                }
                IYYPayWayView.a aVar = this.h;
                if (aVar != null && (n6aVar = this.k) != null && n6aVar.a != null) {
                    aVar.a(this.i, n6aVar, this.q);
                    u6a.c(this.f, this.g, PayUIEventType.paypagepaybt, String.valueOf(this.k.a.srcAmount));
                    RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.k.a.srcAmount);
                } else {
                    RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                }
                n6a n6aVar3 = this.k;
                if (n6aVar3 != null && (productInfo = n6aVar3.a) != null) {
                    i = productInfo.cid;
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
                u6a.d(this.f, this.g, str, this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
                RLog.info("YYPayWayView", "comfirm paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            }
        }
    }

    public List<q6a> k(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    PayWayInfo payWayInfo = list.get(i);
                    if (PayType.ALI_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.ALI_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new q6a(PayType.ALI_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.WECHAT_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new q6a(PayType.WECHAT_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new q6a(PayType.DXM_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_KJ.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_KJ.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new q6a(PayType.DXM_PAY_KJ, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.QQ_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.QQ_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new q6a(PayType.QQ_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.UNION_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.UNION_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new q6a(PayType.UNION_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_H5.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_H5.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new q6a(PayType.DXM_PAY_H5, payWayInfo.name, payWayInfo.tips));
                    }
                }
                return arrayList;
            }
            RLog.info("YYPayWayView", "createRechargeWayList but mPayWayInfoList null");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a7a.a(this.d, this.e);
        }
    }

    public final void r() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.a.size() > 4 && (gridView = this.b) != null) {
            ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
            layoutParams.height += y6a.a(24.0f);
            this.b.setLayoutParams(layoutParams);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            a7a.b(this.d, this.e);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
                g6a.b(this.f, this.g);
            }
            u6a.d(this.f, this.g, PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, "", "", "");
            RLog.info("YYPayWayView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.h);
        }
    }

    @Override // com.baidu.tieba.o7a
    public void refreshView() {
        boolean z;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a.size() <= 0 && this.r != null) {
                u();
                IYYPayWayView.b bVar = this.l;
                if (bVar != null) {
                    map = bVar.e;
                } else {
                    map = null;
                }
                o6a.c(this.r.d(map), new e(this));
                z = true;
            } else {
                z = false;
            }
            RLog.info("YYPayWayView", "refreshView isQueryProductList:" + z);
        }
    }

    public final void n(int i) {
        int i2;
        PayFlowType payFlowType;
        String str;
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i = this.c.getItem(i);
            if (this.c.b() != i) {
                this.c.c(i);
                this.c.notifyDataSetChanged();
            }
            n6a n6aVar = this.k;
            if (n6aVar != null && (productInfo = n6aVar.a) != null) {
                i2 = productInfo.cid;
            } else {
                i2 = 0;
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
            u6a.d(this.f, this.g, str, this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i2));
            RLog.info("YYPayWayView", "choose paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            if (this.i.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            }
        }
    }

    public final void w(String str) {
        IFeedbackServiceProxy iFeedbackServiceProxy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (this.w != null && p6a.d() != null) {
                View findViewById = this.w.findViewById(R.id.obfuscated_res_0x7f090455);
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
                z = (p6a.d().feedbackSwitch != 1 || iFeedbackServiceProxy == null) ? false : false;
                if (!z) {
                    i = 8;
                }
                findViewById.setVisibility(i);
                if (z) {
                    u6a.d(this.f, this.g, "26", "", "", "");
                }
                RLog.info("YYPayWayView", "updateTopLeftBtn from:" + str + " proxy:" + iFeedbackServiceProxy + " feedbackSwitch:" + p6a.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
                return;
            }
            RLog.warn("YYPayWayView", "updateTopLeftBtn from:" + str + " mWindow:" + this.w + " paysSettingInfo:" + p6a.d());
        }
    }

    public final void p(int i, int i2, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, str) == null) {
            if (n7a.a.a(this.m)) {
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

    public final void q() {
        PayUIKitConfig payUIKitConfig;
        PayFlowType payFlowType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (payUIKitConfig = this.o) != null) {
            String f = p6a.f(payUIKitConfig);
            RLog.debug("YYPayWayView", "agreeUrl:" + f);
            if (this.m instanceof Activity) {
                IYYPayWayView.b bVar = this.l;
                if (bVar != null) {
                    payFlowType = bVar.h;
                } else {
                    payFlowType = null;
                }
                if (payFlowType != null) {
                    b7a.a(payFlowType, this.f, this.g, this.o, (Activity) this.m, f, "Y币充值协议");
                } else {
                    RLog.error("YYPayWayView", "onUserItemClick error payFlowType null", new Object[0]);
                }
            } else {
                RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
            }
            u6a.b(this.f, this.g, PayUIEventType.paypageprotocol);
            RLog.warn("YYPayWayView", PayUIEventType.paypageprotocol);
        }
    }

    @Override // com.baidu.tieba.o7a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, windowParams) == null) {
            RLog.debug("YYPayWayView", "refreshWindow params:" + windowParams + " mWindow:" + this.w);
            if (this.w != null && windowParams != null) {
                IYYPayWayView.b bVar = this.l;
                if (bVar != null) {
                    bVar.i = windowParams;
                }
                WindowManager.LayoutParams attributes = this.w.getAttributes();
                attributes.dimAmount = windowParams.dimAmount;
                try {
                    this.w.setAttributes(attributes);
                } catch (Exception e2) {
                    RLog.error("YYPayWayView", "refreshWindow e:" + e2, new Object[0]);
                }
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, payViewState) == null) {
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

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            RLog.info("YYPayWayView", "showBubbleActMsgView bubbleActMsg:" + str + " mTvBubbleMsg:" + this.u);
            TextView textView = this.u;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.u.setVisibility(0);
                this.u.setText(str);
                return;
            }
            this.u.setVisibility(8);
        }
    }

    public final void s() {
        IYYPayWayView.b bVar;
        n6a n6aVar;
        boolean z;
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (bVar = this.l) != null && (n6aVar = bVar.c) != null) {
            double b2 = n6aVar.b();
            boolean z2 = true;
            if (b2 == ((long) b2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                format = new DecimalFormat("0").format(b2);
            } else {
                format = new DecimalFormat("0.00").format(b2);
            }
            this.s.setText(format);
            double a2 = this.l.c.a();
            if (a2 != ((long) a2)) {
                z2 = false;
            }
            if (z2) {
                format2 = new DecimalFormat("0").format(a2);
            } else {
                format2 = new DecimalFormat("0.00").format(a2);
            }
            TextView textView = this.t;
            textView.setText(format2 + "Y币");
            this.j.setText("确认支付 " + format2 + "元");
        }
    }

    public final void v(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.a.clear();
            this.a.addAll(k(list));
            if (this.a.size() > 0) {
                this.i = this.a.get(0);
                this.c.c(0);
            }
            if (Env.instance().isTestEnv() && this.a.size() > 0) {
                this.a.add(new q6a(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.c.notifyDataSetChanged();
            r();
            w("showPayWayListView");
        }
    }
}
