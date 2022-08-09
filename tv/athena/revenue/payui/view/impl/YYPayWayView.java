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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a3a;
import com.repackage.b2a;
import com.repackage.f2a;
import com.repackage.h2a;
import com.repackage.i2a;
import com.repackage.j0a;
import com.repackage.n1a;
import com.repackage.n3a;
import com.repackage.s2a;
import com.repackage.t1a;
import com.repackage.u1a;
import com.repackage.u2a;
import com.repackage.v1a;
import com.repackage.w1a;
import com.repackage.x1a;
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
    public List<x1a> a;
    public GridView b;
    public a3a c;
    public View d;
    public ImageView e;
    public int f;
    public int g;
    public IYYPayWayView.a h;
    public x1a i;
    public Button j;
    public u1a k;
    public IYYPayWayView.b l;
    public Context m;
    public TextView n;
    public PayUIKitConfig o;
    public String p;
    public AppCustomExpand q;
    public t1a r;
    public TextView s;
    public TextView t;
    public TextView u;
    public Window v;

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
                this.a.m(i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends n3a {
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

        @Override // com.repackage.n3a
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.i();
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p();
            }
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
            }
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
                    w1a.h(productListResult.getPaysSettingInfo(), "YYPayWayView");
                    this.a.u(productListResult.getPayWayInfoList());
                    this.a.s(productListResult.getBubbleActMsg());
                } else {
                    RLog.error("YYPayWayView", "server payway list empty", new Object[0]);
                    this.a.n(1021);
                }
                this.a.k();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.o(1021, i, str);
                this.a.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Activity activity, int i, int i2, IYYPayWayView.b bVar, t1a t1aVar, PayUIKitConfig payUIKitConfig, j0a j0aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), bVar, t1aVar, payUIKitConfig, j0aVar};
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
        LayoutInflater.from(new ContextThemeWrapper(activity, s2a.a.a(payUIKitConfig))).inflate(R.layout.obfuscated_res_0x7f0d0698, (ViewGroup) this, true);
        this.l = bVar;
        this.k = bVar.c;
        this.m = activity;
        this.o = payUIKitConfig;
        this.f = i;
        this.g = i2;
        this.r = t1aVar;
        this.q = bVar.d;
        this.c = new a3a(activity, payUIKitConfig, this.a);
        GridView gridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090cdb);
        this.b = gridView;
        gridView.setSelector(R.drawable.obfuscated_res_0x7f080eb1);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(new a(this));
        Button button = (Button) findViewById(R.id.obfuscated_res_0x7f090425);
        this.j = button;
        button.setOnClickListener(new b(this));
        this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f0923b7);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f0923b6);
        this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f092312);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0923bc);
        this.n = textView;
        textView.setOnClickListener(new c(this));
        this.d = findViewById(R.id.obfuscated_res_0x7f091c2a);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff7);
        IYYPayWayView.b bVar2 = this.l;
        b2a.d(this.f, this.g, (bVar2 != null ? bVar2.h : null) == PayFlowType.WALLET_PAY_FLOW ? "11" : "4", "", "", "");
        r();
        u(this.l.a);
        s(this.l.b);
    }

    @Override // com.repackage.v2a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
            RLog.debug("YYPayWayView", "attachWindow window:" + window);
            this.v = window;
            IYYPayWayView.b bVar = this.l;
            if (bVar != null) {
                refreshWindow(bVar.i);
            }
            v(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
        }
    }

    @Override // com.repackage.v2a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void i() {
        ProductInfo productInfo;
        u1a u1aVar;
        u1a u1aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x1a x1aVar = this.i;
            int i = 0;
            if (x1aVar == null) {
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            } else if (x1aVar.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            } else {
                if (Env.instance().isTestEnv() && this.i.a == PayType.MOCK_TEST_PAY && (u1aVar2 = this.k) != null) {
                    ProductInfo productInfo2 = u1aVar2.a;
                    if (productInfo2.srcAmount > 10.0d) {
                        productInfo2.srcAmount = 10.0d;
                        productInfo2.destAmount = 1000L;
                    }
                }
                IYYPayWayView.a aVar = this.h;
                if (aVar != null && (u1aVar = this.k) != null && u1aVar.a != null) {
                    aVar.a(this.i, u1aVar, this.q);
                    b2a.c(this.f, this.g, PayUIEventType.paypagepaybt, String.valueOf(this.k.a.srcAmount));
                    RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.k.a.srcAmount);
                } else {
                    RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                }
                u1a u1aVar3 = this.k;
                if (u1aVar3 != null && (productInfo = u1aVar3.a) != null) {
                    i = productInfo.cid;
                }
                IYYPayWayView.b bVar = this.l;
                b2a.d(this.f, this.g, (bVar != null ? bVar.h : null) == PayFlowType.WALLET_PAY_FLOW ? "12" : "5", this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
                RLog.info("YYPayWayView", "comfirm paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            }
        }
    }

    public List<x1a> j(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    PayWayInfo payWayInfo = list.get(i);
                    if (PayType.ALI_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.ALI_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new x1a(PayType.ALI_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.WECHAT_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new x1a(PayType.WECHAT_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new x1a(PayType.DXM_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_KJ.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_KJ.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new x1a(PayType.DXM_PAY_KJ, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.QQ_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.QQ_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new x1a(PayType.QQ_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.UNION_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.UNION_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new x1a(PayType.UNION_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_H5.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_H5.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new x1a(PayType.DXM_PAY_H5, payWayInfo.name, payWayInfo.tips));
                    }
                }
                return arrayList;
            }
            RLog.info("YYPayWayView", "createRechargeWayList but mPayWayInfoList null");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h2a.a(this.d, this.e);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
                n1a.b(this.f, this.g);
            }
            b2a.d(this.f, this.g, PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, "", "", "");
            RLog.info("YYPayWayView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.h);
        }
    }

    public final void m(int i) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.i = this.c.getItem(i);
            if (this.c.b() != i) {
                this.c.c(i);
                this.c.notifyDataSetChanged();
            }
            u1a u1aVar = this.k;
            int i2 = (u1aVar == null || (productInfo = u1aVar.a) == null) ? 0 : productInfo.cid;
            IYYPayWayView.b bVar = this.l;
            b2a.d(this.f, this.g, (bVar != null ? bVar.h : null) == PayFlowType.WALLET_PAY_FLOW ? "13" : "6", this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i2));
            RLog.info("YYPayWayView", "choose paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            if (this.i.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a != PayType.QQ_PAY || PackageInstallUtil.isInstallQQ(this.m)) {
            } else {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            }
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (u2a.a.a(this.m)) {
                Toast.makeText(this.m, "请求服务失败(" + i + "e)", 1).show();
            }
            IYYPayWayView.a aVar = this.h;
            if (aVar != null) {
                aVar.onRefreshViewFail(-1, "server payway list empty");
            }
        }
    }

    public final void o(int i, int i2, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, str) == null) {
            if (u2a.a.a(this.m)) {
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

    public final void p() {
        PayUIKitConfig payUIKitConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (payUIKitConfig = this.o) == null) {
            return;
        }
        String f = w1a.f(payUIKitConfig);
        RLog.debug("YYPayWayView", "agreeUrl:" + f);
        if (this.m instanceof Activity) {
            IYYPayWayView.b bVar = this.l;
            PayFlowType payFlowType = bVar != null ? bVar.h : null;
            if (payFlowType != null) {
                i2a.a(payFlowType, this.f, this.g, this.o, (Activity) this.m, f, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "onUserItemClick error payFlowType null", new Object[0]);
            }
        } else {
            RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
        }
        b2a.b(this.f, this.g, PayUIEventType.paypageprotocol);
        RLog.warn("YYPayWayView", PayUIEventType.paypageprotocol);
    }

    public final void q() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a.size() <= 4 || (gridView = this.b) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.height += f2a.a(24.0f);
        this.b.setLayoutParams(layoutParams);
    }

    public final void r() {
        IYYPayWayView.b bVar;
        u1a u1aVar;
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.l) == null || (u1aVar = bVar.c) == null) {
            return;
        }
        double b2 = u1aVar.b();
        if (b2 == ((double) ((long) b2))) {
            format = new DecimalFormat("0").format(b2);
        } else {
            format = new DecimalFormat("0.00").format(b2);
        }
        this.s.setText(format);
        double a2 = this.l.c.a();
        if (a2 == ((double) ((long) a2))) {
            format2 = new DecimalFormat("0").format(a2);
        } else {
            format2 = new DecimalFormat("0.00").format(a2);
        }
        TextView textView = this.t;
        textView.setText(format2 + "Y币");
        this.j.setText("确认支付 " + format2 + "元");
    }

    @Override // com.repackage.v2a
    public void refreshView() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a.size() > 0 || this.r == null) {
                z = false;
            } else {
                t();
                IYYPayWayView.b bVar = this.l;
                v1a.c(this.r.d(bVar != null ? bVar.e : null), new e(this));
                z = true;
            }
            RLog.info("YYPayWayView", "refreshView isQueryProductList:" + z);
        }
    }

    @Override // com.repackage.v2a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, windowParams) == null) {
            RLog.debug("YYPayWayView", "refreshWindow params:" + windowParams + " mWindow:" + this.v);
            if (this.v == null || windowParams == null) {
                return;
            }
            IYYPayWayView.b bVar = this.l;
            if (bVar != null) {
                bVar.i = windowParams;
            }
            WindowManager.LayoutParams attributes = this.v.getAttributes();
            attributes.dimAmount = windowParams.dimAmount;
            try {
                this.v.setAttributes(attributes);
            } catch (Exception e2) {
                RLog.error("YYPayWayView", "refreshWindow e:" + e2, new Object[0]);
            }
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
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

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.h = aVar;
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

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            h2a.b(this.d, this.e);
        }
    }

    public final void u(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.a.clear();
            this.a.addAll(j(list));
            if (this.a.size() > 0) {
                this.i = this.a.get(0);
                this.c.c(0);
            }
            if (Env.instance().isTestEnv() && this.a.size() > 0) {
                this.a.add(new x1a(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.c.notifyDataSetChanged();
            q();
            v("showPayWayListView");
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.v != null && w1a.d() != null) {
                View findViewById = this.v.findViewById(R.id.obfuscated_res_0x7f090431);
                if (findViewById == null) {
                    RLog.error("YYPayWayView", "updateTopLeftBtn error btnLeft null", new Object[0]);
                    return;
                }
                findViewById.setOnClickListener(new d(this));
                YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.f, this.g);
                IFeedbackServiceProxy feedbackServiceProxy = uIKit != null ? uIKit.getFeedbackServiceProxy() : null;
                boolean z = true;
                z = (w1a.d().feedbackSwitch != 1 || feedbackServiceProxy == null) ? false : false;
                findViewById.setVisibility(z ? 0 : 8);
                if (z) {
                    b2a.d(this.f, this.g, "26", "", "", "");
                }
                RLog.info("YYPayWayView", "updateTopLeftBtn from:" + str + " proxy:" + feedbackServiceProxy + " feedbackSwitch:" + w1a.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
                return;
            }
            RLog.warn("YYPayWayView", "updateTopLeftBtn from:" + str + " mWindow:" + this.v + " paysSettingInfo:" + w1a.d());
        }
    }
}
