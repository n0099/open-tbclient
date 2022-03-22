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
import h.a.a.e.f.f;
import h.a.a.e.h.e;
import h.a.a.e.h.o;
import h.a.a.e.h.q;
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
    public List<f> a;

    /* renamed from: b  reason: collision with root package name */
    public GridView f45878b;

    /* renamed from: c  reason: collision with root package name */
    public h.a.a.e.i.e.b f45879c;

    /* renamed from: d  reason: collision with root package name */
    public View f45880d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f45881e;

    /* renamed from: f  reason: collision with root package name */
    public int f45882f;

    /* renamed from: g  reason: collision with root package name */
    public int f45883g;

    /* renamed from: h  reason: collision with root package name */
    public IYYPayWayView.a f45884h;
    public f i;
    public Button j;
    public h.a.a.e.f.c k;
    public IYYPayWayView.b l;
    public Context m;
    public TextView n;
    public PayUIKitConfig o;
    public String p;
    public AppCustomExpand q;
    public h.a.a.e.f.b r;
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.j(i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends h.a.a.e.k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f45885b;

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
            this.f45885b = yYPayWayView;
        }

        @Override // h.a.a.e.k.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45885b.g();
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
    public YYPayWayView(Activity activity, int i, int i2, IYYPayWayView.b bVar, h.a.a.e.f.b bVar2, PayUIKitConfig payUIKitConfig, h.a.a.e.e.d dVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), bVar, bVar2, payUIKitConfig, dVar};
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
        LayoutInflater.from(new ContextThemeWrapper(activity, o.a.a(payUIKitConfig))).inflate(R.layout.obfuscated_res_0x7f0d066e, (ViewGroup) this, true);
        this.l = bVar;
        this.k = bVar.f45837b;
        this.m = activity;
        this.o = payUIKitConfig;
        this.f45882f = i;
        this.f45883g = i2;
        this.r = bVar2;
        this.q = bVar.f45838c;
        this.f45879c = new h.a.a.e.i.e.b(activity, payUIKitConfig, this.a);
        GridView gridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090cee);
        this.f45878b = gridView;
        gridView.setSelector(R.drawable.obfuscated_res_0x7f080ea0);
        this.f45878b.setAdapter((ListAdapter) this.f45879c);
        this.f45878b.setOnItemClickListener(new a(this));
        Button button = (Button) findViewById(R.id.obfuscated_res_0x7f09040f);
        this.j = button;
        button.setOnClickListener(new b(this));
        this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f092222);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f092221);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092227);
        this.n = textView;
        textView.setOnClickListener(new c(this));
        this.f45880d = findViewById(R.id.obfuscated_res_0x7f091ae6);
        this.f45881e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe1);
        IYYPayWayView.b bVar3 = this.l;
        h.a.a.e.g.b.d(this.f45882f, this.f45883g, (bVar3 != null ? bVar3.f45841f : null) == PayFlowType.WALLET_PAY_FLOW ? "11" : "4", "", "", "");
        o();
        q(this.l.a);
    }

    public void g() {
        ProductInfo productInfo;
        h.a.a.e.f.c cVar;
        h.a.a.e.f.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f fVar = this.i;
            int i = 0;
            if (fVar == null) {
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            } else if (fVar.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
                Toast.makeText(this.m, "未安装微信", 1).show();
            } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
                Toast.makeText(this.m, "未安装QQ", 1).show();
            } else {
                if (Env.instance().isTestEnv() && this.i.a == PayType.MOCK_TEST_PAY && (cVar2 = this.k) != null) {
                    ProductInfo productInfo2 = cVar2.a;
                    if (productInfo2.srcAmount > 10.0d) {
                        productInfo2.srcAmount = 10.0d;
                        productInfo2.destAmount = 1000L;
                    }
                }
                IYYPayWayView.a aVar = this.f45884h;
                if (aVar != null && (cVar = this.k) != null && cVar.a != null) {
                    aVar.a(this.i, cVar, this.q);
                    h.a.a.e.g.b.c(this.f45882f, this.f45883g, UiEventType.paypagepaybt, String.valueOf(this.k.a.srcAmount));
                    RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.k.a.srcAmount);
                } else {
                    RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                }
                h.a.a.e.f.c cVar3 = this.k;
                if (cVar3 != null && (productInfo = cVar3.a) != null) {
                    i = productInfo.cid;
                }
                IYYPayWayView.b bVar = this.l;
                h.a.a.e.g.b.d(this.f45882f, this.f45883g, (bVar != null ? bVar.f45841f : null) == PayFlowType.WALLET_PAY_FLOW ? "12" : "5", this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
                RLog.info("YYPayWayView", "comfirm paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
            }
        }
    }

    @Override // h.a.a.e.i.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    public List<f> h(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    PayWayInfo payWayInfo = list.get(i);
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

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e.a(this.f45880d, this.f45881e);
        }
    }

    public final void j(int i) {
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.i = this.f45879c.getItem(i);
            if (this.f45879c.b() != i) {
                this.f45879c.c(i);
                this.f45879c.notifyDataSetChanged();
            }
            h.a.a.e.f.c cVar = this.k;
            int i2 = (cVar == null || (productInfo = cVar.a) == null) ? 0 : productInfo.cid;
            IYYPayWayView.b bVar = this.l;
            h.a.a.e.g.b.d(this.f45882f, this.f45883g, (bVar != null ? bVar.f45841f : null) == PayFlowType.WALLET_PAY_FLOW ? "13" : "6", this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i2));
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
            if (q.a.a(this.m)) {
                Toast.makeText(this.m, "请求服务失败(" + i + "e)", 1).show();
            }
            IYYPayWayView.a aVar = this.f45884h;
            if (aVar != null) {
                aVar.onRefreshViewFail(-1, "server payway list empty");
            }
        }
    }

    public final void l(int i, int i2, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, str) == null) {
            if (q.a.a(this.m)) {
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
            IYYPayWayView.a aVar = this.f45884h;
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
        String d2 = h.a.a.e.f.e.d(payUIKitConfig);
        RLog.debug("YYPayWayView", "agreeUrl:" + d2);
        if (this.m instanceof Activity) {
            IYYPayWayView.b bVar = this.l;
            PayFlowType payFlowType = bVar != null ? bVar.f45841f : null;
            if (payFlowType != null) {
                h.a.a.e.h.f.a(payFlowType, this.f45882f, this.f45883g, this.o, (Activity) this.m, d2, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "onUserItemClick error payFlowType null", new Object[0]);
            }
        } else {
            RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
        }
        h.a.a.e.g.b.b(this.f45882f, this.f45883g, UiEventType.paypageprotocol);
        RLog.warn("YYPayWayView", UiEventType.paypageprotocol);
    }

    public final void n() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.size() <= 4 || (gridView = this.f45878b) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.height += h.a.a.e.h.c.a(24.0f);
        this.f45878b.setLayoutParams(layoutParams);
    }

    public final void o() {
        IYYPayWayView.b bVar;
        h.a.a.e.f.c cVar;
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.l) == null || (cVar = bVar.f45837b) == null) {
            return;
        }
        double b2 = cVar.b();
        if (b2 == ((double) ((long) b2))) {
            format = new DecimalFormat("0").format(b2);
        } else {
            format = new DecimalFormat("0.00").format(b2);
        }
        this.s.setText(format);
        double a2 = this.l.f45837b.a();
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
            e.b(this.f45880d, this.f45881e);
        }
    }

    public final void q(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.a.clear();
            this.a.addAll(h(list));
            if (this.a.size() > 0) {
                this.i = this.a.get(0);
                this.f45879c.c(0);
            }
            if (Env.instance().isTestEnv() && this.a.size() > 0) {
                this.a.add(new f(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.f45879c.notifyDataSetChanged();
            n();
        }
    }

    @Override // h.a.a.e.i.a
    public void refreshView() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a.size() > 0 || this.r == null) {
                z = false;
            } else {
                p();
                h.a.a.e.f.d.c(this.r.d(), new d(this));
                z = true;
            }
            RLog.info("YYPayWayView", "refreshView isQueryProductList:" + z);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f45884h = aVar;
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
