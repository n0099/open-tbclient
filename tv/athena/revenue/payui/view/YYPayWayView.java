package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import j.a.a.e.e;
import j.a.a.e.g;
import j.a.a.e.n.f;
import j.a.a.e.p.o;
import j.a.a.e.p.q;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes5.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f> f65429e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f65430f;

    /* renamed from: g  reason: collision with root package name */
    public j.a.a.e.q.e.b f65431g;

    /* renamed from: h  reason: collision with root package name */
    public View f65432h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f65433i;

    /* renamed from: j  reason: collision with root package name */
    public int f65434j;

    /* renamed from: k  reason: collision with root package name */
    public int f65435k;
    public IYYPayWayView.a l;
    public f m;
    public Button n;
    public j.a.a.e.n.c o;
    public IYYPayWayView.b p;
    public Context q;
    public TextView r;
    public PayUIKitConfig s;
    public String t;
    public AppCustomExpand u;
    public j.a.a.e.n.b v;
    public TextView w;
    public TextView x;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f65436e;

        public a(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65436e = yYPayWayView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f65436e.h(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends j.a.a.e.s.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f65437f;

        public b(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65437f = yYPayWayView;
        }

        @Override // j.a.a.e.s.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65437f.confirmPayBtnClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f65438e;

        public c(YYPayWayView yYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65438e = yYPayWayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65438e.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements IResult<ProductListResult> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.o(productListResult.getPayWayInfoList());
                } else {
                    RLog.error("YYPayWayView", "server payway list empty", new Object[0]);
                    this.a.i(1021);
                }
                this.a.g();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i2 + " failReason:" + str, new Object[0]);
                this.a.j(1021, i2, str);
                this.a.g();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Activity activity, int i2, int i3, IYYPayWayView.b bVar, j.a.a.e.n.b bVar2, PayUIKitConfig payUIKitConfig, j.a.a.e.m.d dVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), bVar, bVar2, payUIKitConfig, dVar};
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
        this.f65429e = new ArrayList();
        this.t = "";
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        LayoutInflater.from(new ContextThemeWrapper(activity, o.a.a(payUIKitConfig))).inflate(g.pay_ui_layout_pay_way_view, (ViewGroup) this, true);
        this.p = bVar;
        this.o = bVar.f65380b;
        this.q = activity;
        this.s = payUIKitConfig;
        this.f65434j = i2;
        this.f65435k = i3;
        this.v = bVar2;
        this.u = bVar.f65381c;
        this.f65431g = new j.a.a.e.q.e.b(activity, payUIKitConfig, this.f65429e);
        GridView gridView = (GridView) findViewById(j.a.a.e.f.grid_recharge_way);
        this.f65430f = gridView;
        gridView.setSelector(e.pay_ui_selector_transparent);
        this.f65430f.setAdapter((ListAdapter) this.f65431g);
        this.f65430f.setOnItemClickListener(new a(this));
        Button button = (Button) findViewById(j.a.a.e.f.btn_confirm_recharge);
        this.n = button;
        button.setOnClickListener(new b(this));
        this.w = (TextView) findViewById(j.a.a.e.f.tv_total_src_amount);
        this.x = (TextView) findViewById(j.a.a.e.f.tv_total_dst_amount);
        TextView textView = (TextView) findViewById(j.a.a.e.f.tv_use_item);
        this.r = textView;
        textView.setOnClickListener(new c(this));
        this.f65432h = findViewById(j.a.a.e.f.root_loading);
        this.f65433i = (ImageView) findViewById(j.a.a.e.f.iv_loading_circle);
        IYYPayWayView.b bVar3 = this.p;
        j.a.a.e.o.b.d(this.f65434j, this.f65435k, (bVar3 != null ? bVar3.f65384f : null) == PayFlowType.WALLET_PAY_FLOW ? "11" : "4", "", "", "");
        m();
        o(this.p.a);
    }

    public void confirmPayBtnClick() {
        ProductInfo productInfo;
        j.a.a.e.n.c cVar;
        j.a.a.e.n.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f fVar = this.m;
            int i2 = 0;
            if (fVar == null) {
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            } else if (fVar.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.q)) {
                Toast.makeText(this.q, "未安装微信", 1).show();
            } else if (this.m.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.q)) {
                Toast.makeText(this.q, "未安装QQ", 1).show();
            } else {
                if (Env.instance().isTestEnv() && this.m.a == PayType.MOCK_TEST_PAY && (cVar2 = this.o) != null) {
                    ProductInfo productInfo2 = cVar2.a;
                    if (productInfo2.srcAmount > 10.0d) {
                        productInfo2.srcAmount = 10.0d;
                        productInfo2.destAmount = 1000L;
                    }
                }
                IYYPayWayView.a aVar = this.l;
                if (aVar != null && (cVar = this.o) != null && cVar.a != null) {
                    aVar.a(this.m, cVar, this.u);
                    j.a.a.e.o.b.c(this.f65434j, this.f65435k, UiEventType.paypagepaybt, String.valueOf(this.o.a.srcAmount));
                    RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.o.a.srcAmount);
                } else {
                    RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                }
                j.a.a.e.n.c cVar3 = this.o;
                if (cVar3 != null && (productInfo = cVar3.a) != null) {
                    i2 = productInfo.cid;
                }
                IYYPayWayView.b bVar = this.p;
                j.a.a.e.o.b.d(this.f65434j, this.f65435k, (bVar != null ? bVar.f65384f : null) == PayFlowType.WALLET_PAY_FLOW ? "12" : "5", this.m.a.getChannel(), this.m.a.getMethod(), String.valueOf(i2));
                RLog.info("YYPayWayView", "comfirm paychannel:" + this.m.a.getChannel() + " paymethod:" + this.m.a.getMethod());
            }
        }
    }

    public List<f> createRechargeWayList(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PayWayInfo payWayInfo = list.get(i2);
                    if (PayType.ALI_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.ALI_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new f(PayType.ALI_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.WECHAT_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new f(PayType.WECHAT_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new f(PayType.DXM_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_KJ.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_KJ.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new f(PayType.DXM_PAY_KJ, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.QQ_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.QQ_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new f(PayType.QQ_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.UNION_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.UNION_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new f(PayType.UNION_PAY, payWayInfo.name, payWayInfo.tips));
                    }
                }
                return arrayList;
            }
            RLog.info("YYPayWayView", "createRechargeWayList but mPayWayInfoList null");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j.a.a.e.p.e.a(this.f65432h, this.f65433i);
        }
    }

    @Override // j.a.a.e.q.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h(int i2) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.m = this.f65431g.getItem(i2);
            if (this.f65431g.b() != i2) {
                this.f65431g.c(i2);
                this.f65431g.notifyDataSetChanged();
            }
            j.a.a.e.n.c cVar = this.o;
            int i3 = (cVar == null || (productInfo = cVar.a) == null) ? 0 : productInfo.cid;
            IYYPayWayView.b bVar = this.p;
            j.a.a.e.o.b.d(this.f65434j, this.f65435k, (bVar != null ? bVar.f65384f : null) == PayFlowType.WALLET_PAY_FLOW ? "13" : "6", this.m.a.getChannel(), this.m.a.getMethod(), String.valueOf(i3));
            RLog.info("YYPayWayView", "choose paychannel:" + this.m.a.getChannel() + " paymethod:" + this.m.a.getMethod());
            if (this.m.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.q)) {
                Toast.makeText(this.q, "未安装微信", 1).show();
            } else if (this.m.a != PayType.QQ_PAY || PackageInstallUtil.isInstallQQ(this.q)) {
            } else {
                Toast.makeText(this.q, "未安装QQ", 1).show();
            }
        }
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (q.a.a(this.q)) {
                Toast.makeText(this.q, "请求服务失败(" + i2 + "e)", 1).show();
            }
            IYYPayWayView.a aVar = this.l;
            if (aVar != null) {
                aVar.onRefreshViewFail(-1, "server payway list empty");
            }
        }
    }

    public void interruptePayFlow() {
        IYYPayWayView.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.b();
    }

    public final void j(int i2, int i3, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, str) == null) {
            if (q.a.a(this.q)) {
                if (i3 == -500) {
                    sb = new StringBuilder();
                    sb.append("网络不给力,请稍后重试(");
                    sb.append(i2);
                    sb.append("w)");
                } else {
                    sb = new StringBuilder();
                    sb.append("请求服务失败(");
                    sb.append(i2);
                    sb.append("w) code:");
                    sb.append(i3);
                    sb.append(" failReason:");
                    sb.append(str);
                }
                Toast.makeText(this.q, sb.toString(), 1).show();
            }
            IYYPayWayView.a aVar = this.l;
            if (aVar != null) {
                aVar.onRefreshViewFail(i3, str);
            }
        }
    }

    public final void k() {
        PayUIKitConfig payUIKitConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (payUIKitConfig = this.s) == null) {
            return;
        }
        String d2 = j.a.a.e.n.e.d(payUIKitConfig);
        RLog.debug("YYPayWayView", "agreeUrl:" + d2);
        if (this.q instanceof Activity) {
            IYYPayWayView.b bVar = this.p;
            PayFlowType payFlowType = bVar != null ? bVar.f65384f : null;
            if (payFlowType != null) {
                j.a.a.e.p.f.a(payFlowType, this.f65434j, this.f65435k, this.s, (Activity) this.q, d2, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "onUserItemClick error payFlowType null", new Object[0]);
            }
        } else {
            RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
        }
        j.a.a.e.o.b.b(this.f65434j, this.f65435k, UiEventType.paypageprotocol);
        RLog.warn("YYPayWayView", UiEventType.paypageprotocol);
    }

    public final void l() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f65429e.size() <= 4 || (gridView = this.f65430f) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.height += j.a.a.e.p.c.a(24.0f);
        this.f65430f.setLayoutParams(layoutParams);
    }

    public final void m() {
        IYYPayWayView.b bVar;
        j.a.a.e.n.c cVar;
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.p) == null || (cVar = bVar.f65380b) == null) {
            return;
        }
        double b2 = cVar.b();
        if (b2 == ((double) ((long) b2))) {
            format = new DecimalFormat("0").format(b2);
        } else {
            format = new DecimalFormat("0.00").format(b2);
        }
        this.w.setText(format);
        double a2 = this.p.f65380b.a();
        if (a2 == ((double) ((long) a2))) {
            format2 = new DecimalFormat("0").format(a2);
        } else {
            format2 = new DecimalFormat("0.00").format(a2);
        }
        TextView textView = this.x;
        textView.setText(format2 + "Y币");
        this.n.setText("确认支付 " + format2 + "元");
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            j.a.a.e.p.e.b(this.f65432h, this.f65433i);
        }
    }

    public final void o(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f65429e.clear();
            this.f65429e.addAll(createRechargeWayList(list));
            if (this.f65429e.size() > 0) {
                this.m = this.f65429e.get(0);
                this.f65431g.c(0);
            }
            if (Env.instance().isTestEnv() && this.f65429e.size() > 0) {
                this.f65429e.add(new f(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.f65431g.notifyDataSetChanged();
            l();
        }
    }

    @Override // j.a.a.e.q.a
    public void refreshView() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f65429e.size() > 0 || this.v == null) {
                z = false;
            } else {
                n();
                j.a.a.e.n.d.c(this.v.d(), new d(this));
                z = true;
            }
            RLog.info("YYPayWayView", "refreshView isQueryProductList:" + z);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.l = aVar;
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, payViewState) == null) {
            if (payViewState == IYYPayWayView.PayViewState.WAITING_VIEW_STATE) {
                RLog.debug("YYPayWayView", "setViewState waiting");
                Button button = this.n;
                if (button == null) {
                    return;
                }
                this.t = button.getText().toString();
                this.n.setText("等待支付结果...");
                this.n.setClickable(false);
            } else if (payViewState == IYYPayWayView.PayViewState.SELECTING_VIEW_STATE) {
                RLog.debug("YYPayWayView", "setViewState selecting");
                Button button2 = this.n;
                if (button2 == null) {
                    return;
                }
                button2.setText(this.t);
                this.n.setClickable(true);
            }
        }
    }
}
