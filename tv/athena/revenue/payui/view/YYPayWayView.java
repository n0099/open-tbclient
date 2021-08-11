package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import j.a.a.e.n.g;
import j.a.a.e.n.h;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes2.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<j.a.a.e.l.c> f79527e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f79528f;

    /* renamed from: g  reason: collision with root package name */
    public j.a.a.e.o.b.b f79529g;

    /* renamed from: h  reason: collision with root package name */
    public View f79530h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f79531i;

    /* renamed from: j  reason: collision with root package name */
    public int f79532j;
    public int k;
    public IYYPayWayView.a l;
    public j.a.a.e.l.c m;
    public Button n;
    public j.a.a.e.l.a o;
    public IYYPayWayView.b p;
    public Context q;
    public TextView r;
    public ImageView s;
    public j.a.a.e.k.b t;
    public SharedPreferences u;
    public String v;
    public AppCustomExpand w;
    public j.a.a.e.k.a x;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f79533e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f79534f;

        public a(YYPayWayView yYPayWayView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79534f = yYPayWayView;
            this.f79533e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                YYPayWayView yYPayWayView = this.f79534f;
                yYPayWayView.m = yYPayWayView.f79529g.getItem(i2);
                if (this.f79534f.f79529g.b() != i2) {
                    this.f79534f.f79529g.c(i2);
                    this.f79534f.f79529g.notifyDataSetChanged();
                }
                j.a.a.e.m.a.d(this.f79534f.f79532j, this.f79534f.k, (this.f79534f.p == null || this.f79534f.p.f79504f != PaySource.WALLET) ? "6" : "13", this.f79534f.m.f78727a.getChannel(), this.f79534f.m.f78727a.getMethod(), String.valueOf((this.f79534f.o == null || this.f79534f.o.f78720a == null) ? 0 : this.f79534f.o.f78720a.cid));
                RLog.info("YYPayWayView", "choose paychannel:" + this.f79534f.m.f78727a.getChannel() + " paymethod:" + this.f79534f.m.f78727a.getMethod());
                if (this.f79534f.m.f78727a != PayType.WECHAT_PAY || PackageInstallUtil.isInstallWechat(this.f79533e)) {
                    return;
                }
                Toast.makeText(this.f79533e, "未安装微信", 1).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends j.a.a.e.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f79535f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f79536g;

        public b(YYPayWayView yYPayWayView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79536g = yYPayWayView;
            this.f79535f = context;
        }

        @Override // j.a.a.e.q.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = 0;
                if (this.f79536g.m != null) {
                    if (this.f79536g.m.f78727a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.f79535f)) {
                        Toast.makeText(this.f79535f, "未安装微信", 1).show();
                        return;
                    }
                    if (Env.instance().isTestEnv() && this.f79536g.m.f78727a == PayType.MOCK_TEST_PAY && this.f79536g.o != null && this.f79536g.o.f78720a.srcAmount.doubleValue() > 10.0d) {
                        this.f79536g.o.f78720a.srcAmount = Double.valueOf(10.0d);
                        this.f79536g.o.f78720a.destAmount = 1000L;
                    }
                    if (this.f79536g.l != null && this.f79536g.o != null && this.f79536g.o.f78720a != null) {
                        this.f79536g.l.a(this.f79536g.m, this.f79536g.o, this.f79536g.w);
                        j.a.a.e.m.a.c(this.f79536g.f79532j, this.f79536g.k, UiEventType.paypagepaybt, String.valueOf(this.f79536g.o.f78720a.srcAmount));
                        RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.f79536g.o.f78720a.srcAmount);
                    } else {
                        RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                    }
                    if (this.f79536g.o != null && this.f79536g.o.f78720a != null) {
                        i2 = this.f79536g.o.f78720a.cid;
                    }
                    j.a.a.e.m.a.d(this.f79536g.f79532j, this.f79536g.k, (this.f79536g.p == null || this.f79536g.p.f79504f != PaySource.WALLET) ? "5" : "12", this.f79536g.m.f78727a.getChannel(), this.f79536g.m.f78727a.getMethod(), String.valueOf(i2));
                    RLog.info("YYPayWayView", "comfirm paychannel:" + this.f79536g.m.f78727a.getChannel() + " paymethod:" + this.f79536g.m.f78727a.getMethod());
                    return;
                }
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f79537e;

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
            this.f79537e = yYPayWayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f79537e.t == null || this.f79537e.t.getPayUIKitConfig() == null) {
                return;
            }
            String d2 = j.a.a.e.l.b.d(this.f79537e.t.getPayUIKitConfig());
            RLog.debug("YYPayWayView", "agreeUrl:" + d2);
            if (this.f79537e.q instanceof Activity) {
                this.f79537e.t.j((Activity) this.f79537e.q, d2, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
            }
            j.a.a.e.m.a.b(this.f79537e.f79532j, this.f79537e.k, UiEventType.paypageprotocol);
            RLog.warn("YYPayWayView", UiEventType.paypageprotocol);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f79538e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f79539f;

        public d(YYPayWayView yYPayWayView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWayView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79539f = yYPayWayView;
            this.f79538e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.f79539f.n.isEnabled();
                this.f79539f.n.setEnabled(z);
                this.f79539f.u.edit().putBoolean("yy_paysdk_sp_use_item_state_key", z).commit();
                this.f79539f.s.setBackgroundResource(z ? this.f79538e : j.a.a.e.c.pay_ui_pay_way_item_unselect);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f79540a;

        public e(YYPayWayView yYPayWayView) {
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
            this.f79540a = yYPayWayView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                if (productListResult != null && productListResult.getPayWayInfoList() != null) {
                    this.f79540a.s(productListResult.getPayWayInfoList());
                } else {
                    RLog.error("YYPayWayView", "onSuccess but result null", new Object[0]);
                    if (h.f78736a.a(this.f79540a.q)) {
                        Toast.makeText(this.f79540a.q, "网络不给力，请稍后重试", 1).show();
                    }
                    if (this.f79540a.l != null) {
                        this.f79540a.l.onRefreshViewFail(-1, "onSuccess but null");
                    }
                }
                this.f79540a.q();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i2 + " failReason:" + str, new Object[0]);
                if (h.f78736a.a(this.f79540a.q)) {
                    Toast.makeText(this.f79540a.q, "网络不给力，请稍后重试", 1).show();
                }
                if (this.f79540a.l != null) {
                    this.f79540a.l.onRefreshViewFail(i2, str);
                }
                this.f79540a.q();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Context context, int i2, int i3, IYYPayWayView.b bVar, j.a.a.e.k.a aVar, j.a.a.e.k.b bVar2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), bVar, aVar, bVar2};
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
        this.f79527e = new ArrayList();
        this.v = "";
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        PayUIKitConfig payUIKitConfig = bVar2 != null ? bVar2.getPayUIKitConfig() : null;
        LayoutInflater.from(new ContextThemeWrapper(context, g.f78735a.a(payUIKitConfig))).inflate(j.a.a.e.e.pay_ui_layout_pay_way_view, (ViewGroup) this, true);
        this.p = bVar;
        this.o = bVar.f79500b;
        this.q = context;
        this.t = bVar2;
        this.f79532j = i2;
        this.k = i3;
        this.x = aVar;
        this.w = bVar.f79501c;
        this.f79529g = new j.a.a.e.o.b.b(context, payUIKitConfig, this.f79527e);
        s(this.p.f79499a);
        GridView gridView = (GridView) findViewById(j.a.a.e.d.grid_recharge_way);
        this.f79528f = gridView;
        gridView.setSelector(j.a.a.e.c.pay_ui_selector_transparent);
        this.f79528f.setAdapter((ListAdapter) this.f79529g);
        this.f79528f.setOnItemClickListener(new a(this, context));
        Button button = (Button) findViewById(j.a.a.e.d.btn_confirm_recharge);
        this.n = button;
        button.setOnClickListener(new b(this, context));
        TextView textView = (TextView) findViewById(j.a.a.e.d.tv_total_src_amount);
        TextView textView2 = (TextView) findViewById(j.a.a.e.d.tv_total_dst_amount);
        IYYPayWayView.b bVar3 = this.p;
        if (bVar3 != null && bVar3.f79500b != null) {
            String str = "0.00";
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            Double b2 = this.p.f79500b.b();
            if (b2 != null) {
                str = decimalFormat.format(b2);
                textView.setText(str);
            } else {
                textView.setText("0.00");
            }
            textView2.setText(decimalFormat.format(this.p.f79500b.a()));
            this.n.setText("确认支付 " + str + "元");
        }
        TextView textView3 = (TextView) findViewById(j.a.a.e.d.tv_use_item);
        this.r = textView3;
        textView3.setOnClickListener(new c(this));
        this.u = this.q.getSharedPreferences("yy_paysdk_sp_name", 0);
        this.s = (ImageView) findViewById(j.a.a.e.d.img_select);
        boolean z = this.u.getBoolean("yy_paysdk_sp_use_item_state_key", true);
        this.n.setEnabled(z);
        int i6 = g.f78735a.b(payUIKitConfig) ? j.a.a.e.c.pay_ui_pay_way_item_select : j.a.a.e.c.pay_ui_pay_way_item_select_y;
        this.s.setBackgroundResource(z ? i6 : j.a.a.e.c.pay_ui_pay_way_item_unselect);
        this.s.setOnClickListener(new d(this, i6));
        this.f79530h = findViewById(j.a.a.e.d.root_loading);
        this.f79531i = (ImageView) findViewById(j.a.a.e.d.iv_loading_circle);
        IYYPayWayView.b bVar4 = this.p;
        j.a.a.e.m.a.d(this.f79532j, this.k, (bVar4 == null || bVar4.f79504f != PaySource.WALLET) ? "4" : "11", "", "", "");
    }

    public List<j.a.a.e.l.c> createRechargeWayList(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PayWayInfo payWayInfo = list.get(i2);
                    if (PayType.ALI_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.ALI_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new j.a.a.e.l.c(PayType.ALI_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.WECHAT_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new j.a.a.e.l.c(PayType.WECHAT_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new j.a.a.e.l.c(PayType.DXM_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_KJ.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_KJ.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new j.a.a.e.l.c(PayType.DXM_PAY_KJ, payWayInfo.name, payWayInfo.tips));
                    }
                }
                return arrayList;
            }
            RLog.error("YYPayWayView", "createRechargeWayList error mPayWayInfoList null", new Object[0]);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // j.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j.a.a.e.n.d.a(this.f79530h, this.f79531i);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j.a.a.e.n.d.b(this.f79530h, this.f79531i);
        }
    }

    @Override // j.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f79527e.size() > 0 || this.t == null || this.x == null) {
            return;
        }
        r();
        this.t.queryProductList(this.x.c(), new e(this));
    }

    public final void s(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f79527e.clear();
            this.f79527e.addAll(createRechargeWayList(list));
            if (this.f79527e.size() > 0) {
                this.m = this.f79527e.get(0);
                this.f79529g.c(0);
            }
            if (Env.instance().isTestEnv() && this.f79527e.size() > 0) {
                this.f79527e.add(new j.a.a.e.l.c(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.f79529g.notifyDataSetChanged();
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.l = aVar;
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, payViewState) == null) {
            if (payViewState == IYYPayWayView.PayViewState.WAITING_VIEW_STATE) {
                RLog.info("YYPayWayView", "setViewState waiting");
                Button button = this.n;
                if (button == null) {
                    return;
                }
                this.v = button.getText().toString();
                this.n.setText("等待支付结果...");
                this.n.setClickable(false);
            } else if (payViewState == IYYPayWayView.PayViewState.SELECTING_VIEW_STATE) {
                RLog.info("YYPayWayView", "setViewState selecting");
                Button button2 = this.n;
                if (button2 == null) {
                    return;
                }
                button2.setText(this.v);
                this.n.setClickable(true);
            }
        }
    }
}
