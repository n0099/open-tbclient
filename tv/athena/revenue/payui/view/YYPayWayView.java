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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a2a;
import com.repackage.e3a;
import com.repackage.j2a;
import com.repackage.k0a;
import com.repackage.l1a;
import com.repackage.l2a;
import com.repackage.m1a;
import com.repackage.n1a;
import com.repackage.o1a;
import com.repackage.p1a;
import com.repackage.r2a;
import com.repackage.u1a;
import com.repackage.x1a;
import com.repackage.z1a;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes8.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<p1a> a;
    public GridView b;
    public r2a c;
    public View d;
    public ImageView e;
    public int f;
    public int g;
    public IYYPayWayView.a h;
    public p1a i;
    public Button j;
    public m1a k;
    public IYYPayWayView.b l;
    public Context m;
    public TextView n;
    public PayUIKitConfig o;
    public String p;
    public AppCustomExpand q;
    public l1a r;
    public TextView s;
    public TextView t;

    /* loaded from: classes8.dex */
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
                this.a.j(i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends e3a {
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

        @Override // com.repackage.e3a
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.g();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.m();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    this.a.q(productListResult.getPayWayInfoList());
                } else {
                    RLog.error("YYPayWayView", "server payway list empty", new Object[0]);
                    this.a.k(1021);
                }
                this.a.i();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.l(1021, i, str);
                this.a.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Activity activity, int i, int i2, IYYPayWayView.b bVar, l1a l1aVar, PayUIKitConfig payUIKitConfig, k0a k0aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), bVar, l1aVar, payUIKitConfig, k0aVar};
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
        LayoutInflater.from(new ContextThemeWrapper(activity, j2a.a.a(payUIKitConfig))).inflate(R.layout.obfuscated_res_0x7f0d0652, (ViewGroup) this, true);
        this.l = bVar;
        this.k = bVar.b;
        this.m = activity;
        this.o = payUIKitConfig;
        this.f = i;
        this.g = i2;
        this.r = l1aVar;
        this.q = bVar.c;
        this.c = new r2a(activity, payUIKitConfig, this.a);
        GridView gridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090ca6);
        this.b = gridView;
        gridView.setSelector(R.drawable.obfuscated_res_0x7f080eda);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(new a(this));
        Button button = (Button) findViewById(R.id.obfuscated_res_0x7f09040f);
        this.j = button;
        button.setOnClickListener(new b(this));
        this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f092203);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f092202);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092208);
        this.n = textView;
        textView.setOnClickListener(new c(this));
        this.d = findViewById(R.id.obfuscated_res_0x7f091ad4);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090faa);
        IYYPayWayView.b bVar2 = this.l;
        u1a.d(this.f, this.g, (bVar2 != null ? bVar2.f : null) == PayFlowType.WALLET_PAY_FLOW ? "11" : "4", "", "", "");
        o();
        q(this.l.a);
    }

    public void g() {
        ProductInfo productInfo;
        m1a m1aVar;
        m1a m1aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p1a p1aVar = this.i;
            int i = 0;
            if (p1aVar == null) {
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            } else if (p1aVar.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            } else {
                if (Env.instance().isTestEnv() && this.i.a == PayType.MOCK_TEST_PAY && (m1aVar2 = this.k) != null) {
                    ProductInfo productInfo2 = m1aVar2.a;
                    if (productInfo2.srcAmount > 10.0d) {
                        productInfo2.srcAmount = 10.0d;
                        productInfo2.destAmount = 1000L;
                    }
                }
                IYYPayWayView.a aVar = this.h;
                if (aVar != null && (m1aVar = this.k) != null && m1aVar.a != null) {
                    aVar.a(this.i, m1aVar, this.q);
                    u1a.c(this.f, this.g, UiEventType.paypagepaybt, String.valueOf(this.k.a.srcAmount));
                    RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.k.a.srcAmount);
                } else {
                    RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                }
                m1a m1aVar3 = this.k;
                if (m1aVar3 != null && (productInfo = m1aVar3.a) != null) {
                    i = productInfo.cid;
                }
                IYYPayWayView.b bVar = this.l;
                u1a.d(this.f, this.g, (bVar != null ? bVar.f : null) == PayFlowType.WALLET_PAY_FLOW ? "12" : "5", this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
                RLog.info("YYPayWayView", "comfirm paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            }
        }
    }

    @Override // com.repackage.m2a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    public List<p1a> h(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    PayWayInfo payWayInfo = list.get(i);
                    if (PayType.ALI_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.ALI_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new p1a(PayType.ALI_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.WECHAT_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new p1a(PayType.WECHAT_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new p1a(PayType.DXM_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_KJ.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_KJ.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new p1a(PayType.DXM_PAY_KJ, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.QQ_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.QQ_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new p1a(PayType.QQ_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.UNION_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.UNION_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new p1a(PayType.UNION_PAY, payWayInfo.name, payWayInfo.tips));
                    }
                }
                return arrayList;
            }
            RLog.info("YYPayWayView", "createRechargeWayList but mPayWayInfoList null");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            z1a.a(this.d, this.e);
        }
    }

    public final void j(int i) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.i = this.c.getItem(i);
            if (this.c.b() != i) {
                this.c.c(i);
                this.c.notifyDataSetChanged();
            }
            m1a m1aVar = this.k;
            int i2 = (m1aVar == null || (productInfo = m1aVar.a) == null) ? 0 : productInfo.cid;
            IYYPayWayView.b bVar = this.l;
            u1a.d(this.f, this.g, (bVar != null ? bVar.f : null) == PayFlowType.WALLET_PAY_FLOW ? "13" : "6", this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i2));
            RLog.info("YYPayWayView", "choose paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            if (this.i.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a != PayType.QQ_PAY || PackageInstallUtil.isInstallQQ(this.m)) {
            } else {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            }
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (l2a.a.a(this.m)) {
                Toast.makeText(this.m, "请求服务失败(" + i + "e)", 1).show();
            }
            IYYPayWayView.a aVar = this.h;
            if (aVar != null) {
                aVar.onRefreshViewFail(-1, "server payway list empty");
            }
        }
    }

    public final void l(int i, int i2, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, str) == null) {
            if (l2a.a.a(this.m)) {
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

    public final void m() {
        PayUIKitConfig payUIKitConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (payUIKitConfig = this.o) == null) {
            return;
        }
        String d2 = o1a.d(payUIKitConfig);
        RLog.debug("YYPayWayView", "agreeUrl:" + d2);
        if (this.m instanceof Activity) {
            IYYPayWayView.b bVar = this.l;
            PayFlowType payFlowType = bVar != null ? bVar.f : null;
            if (payFlowType != null) {
                a2a.a(payFlowType, this.f, this.g, this.o, (Activity) this.m, d2, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "onUserItemClick error payFlowType null", new Object[0]);
            }
        } else {
            RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
        }
        u1a.b(this.f, this.g, UiEventType.paypageprotocol);
        RLog.warn("YYPayWayView", UiEventType.paypageprotocol);
    }

    public final void n() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.size() <= 4 || (gridView = this.b) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.height += x1a.a(24.0f);
        this.b.setLayoutParams(layoutParams);
    }

    public final void o() {
        IYYPayWayView.b bVar;
        m1a m1aVar;
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.l) == null || (m1aVar = bVar.b) == null) {
            return;
        }
        double b2 = m1aVar.b();
        if (b2 == ((double) ((long) b2))) {
            format = new DecimalFormat("0").format(b2);
        } else {
            format = new DecimalFormat("0.00").format(b2);
        }
        this.s.setText(format);
        double a2 = this.l.b.a();
        if (a2 == ((double) ((long) a2))) {
            format2 = new DecimalFormat("0").format(a2);
        } else {
            format2 = new DecimalFormat("0.00").format(a2);
        }
        TextView textView = this.t;
        textView.setText(format2 + "Y币");
        this.j.setText("确认支付 " + format2 + "元");
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            z1a.b(this.d, this.e);
        }
    }

    public final void q(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.a.clear();
            this.a.addAll(h(list));
            if (this.a.size() > 0) {
                this.i = this.a.get(0);
                this.c.c(0);
            }
            if (Env.instance().isTestEnv() && this.a.size() > 0) {
                this.a.add(new p1a(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.c.notifyDataSetChanged();
            n();
        }
    }

    @Override // com.repackage.m2a
    public void refreshView() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a.size() > 0 || this.r == null) {
                z = false;
            } else {
                p();
                n1a.c(this.r.d(), new d(this));
                z = true;
            }
            RLog.info("YYPayWayView", "refreshView isQueryProductList:" + z);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.h = aVar;
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payViewState) == null) {
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
}
