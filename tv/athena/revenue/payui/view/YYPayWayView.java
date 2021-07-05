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
import i.a.a.e.n.g;
import i.a.a.e.n.h;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes10.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<i.a.a.e.l.c> f76726e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f76727f;

    /* renamed from: g  reason: collision with root package name */
    public i.a.a.e.o.b.b f76728g;

    /* renamed from: h  reason: collision with root package name */
    public View f76729h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f76730i;
    public int j;
    public int k;
    public IYYPayWayView.a l;
    public i.a.a.e.l.c m;
    public Button n;
    public i.a.a.e.l.a o;
    public IYYPayWayView.b p;
    public Context q;
    public TextView r;
    public ImageView s;
    public i.a.a.e.k.b t;
    public SharedPreferences u;
    public String v;
    public AppCustomExpand w;
    public i.a.a.e.k.a x;

    /* loaded from: classes10.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f76731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f76732f;

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
            this.f76732f = yYPayWayView;
            this.f76731e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                YYPayWayView yYPayWayView = this.f76732f;
                yYPayWayView.m = yYPayWayView.f76728g.getItem(i2);
                if (this.f76732f.f76728g.b() != i2) {
                    this.f76732f.f76728g.c(i2);
                    this.f76732f.f76728g.notifyDataSetChanged();
                }
                i.a.a.e.m.a.d(this.f76732f.j, this.f76732f.k, (this.f76732f.p == null || this.f76732f.p.f76705f != PaySource.WALLET) ? "6" : "13", this.f76732f.m.f75855a.getChannel(), this.f76732f.m.f75855a.getMethod(), String.valueOf((this.f76732f.o == null || this.f76732f.o.f75848a == null) ? 0 : this.f76732f.o.f75848a.cid));
                RLog.info("YYPayWayView", "choose paychannel:" + this.f76732f.m.f75855a.getChannel() + " paymethod:" + this.f76732f.m.f75855a.getMethod());
                if (this.f76732f.m.f75855a != PayType.WECHAT_PAY || PackageInstallUtil.isInstallWechat(this.f76731e)) {
                    return;
                }
                Toast.makeText(this.f76731e, "未安装微信", 1).show();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends i.a.a.e.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f76733f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f76734g;

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
            this.f76734g = yYPayWayView;
            this.f76733f = context;
        }

        @Override // i.a.a.e.q.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = 0;
                if (this.f76734g.m != null) {
                    if (this.f76734g.m.f75855a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.f76733f)) {
                        Toast.makeText(this.f76733f, "未安装微信", 1).show();
                        return;
                    }
                    if (Env.instance().isTestEnv() && this.f76734g.m.f75855a == PayType.MOCK_TEST_PAY && this.f76734g.o != null && this.f76734g.o.f75848a.srcAmount.doubleValue() > 10.0d) {
                        this.f76734g.o.f75848a.srcAmount = Double.valueOf(10.0d);
                        this.f76734g.o.f75848a.destAmount = 1000L;
                    }
                    if (this.f76734g.l != null && this.f76734g.o != null && this.f76734g.o.f75848a != null) {
                        this.f76734g.l.a(this.f76734g.m, this.f76734g.o, this.f76734g.w);
                        i.a.a.e.m.a.c(this.f76734g.j, this.f76734g.k, UiEventType.paypagepaybt, String.valueOf(this.f76734g.o.f75848a.srcAmount));
                        RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.f76734g.o.f75848a.srcAmount);
                    } else {
                        RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                    }
                    if (this.f76734g.o != null && this.f76734g.o.f75848a != null) {
                        i2 = this.f76734g.o.f75848a.cid;
                    }
                    i.a.a.e.m.a.d(this.f76734g.j, this.f76734g.k, (this.f76734g.p == null || this.f76734g.p.f76705f != PaySource.WALLET) ? "5" : "12", this.f76734g.m.f75855a.getChannel(), this.f76734g.m.f75855a.getMethod(), String.valueOf(i2));
                    RLog.info("YYPayWayView", "comfirm paychannel:" + this.f76734g.m.f75855a.getChannel() + " paymethod:" + this.f76734g.m.f75855a.getMethod());
                    return;
                }
                RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f76735e;

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
            this.f76735e = yYPayWayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f76735e.t == null || this.f76735e.t.getPayUIKitConfig() == null) {
                return;
            }
            String d2 = i.a.a.e.l.b.d(this.f76735e.t.getPayUIKitConfig());
            RLog.debug("YYPayWayView", "agreeUrl:" + d2);
            if (this.f76735e.q instanceof Activity) {
                this.f76735e.t.j((Activity) this.f76735e.q, d2, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
            }
            i.a.a.e.m.a.b(this.f76735e.j, this.f76735e.k, UiEventType.paypageprotocol);
            RLog.warn("YYPayWayView", UiEventType.paypageprotocol);
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f76736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f76737f;

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
            this.f76737f = yYPayWayView;
            this.f76736e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.f76737f.n.isEnabled();
                this.f76737f.n.setEnabled(z);
                this.f76737f.u.edit().putBoolean("yy_paysdk_sp_use_item_state_key", z).commit();
                this.f76737f.s.setBackgroundResource(z ? this.f76736e : i.a.a.e.c.pay_ui_pay_way_item_unselect);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f76738a;

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
            this.f76738a = yYPayWayView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                if (productListResult != null && productListResult.getPayWayInfoList() != null) {
                    this.f76738a.t(productListResult.getPayWayInfoList());
                } else {
                    RLog.error("YYPayWayView", "onSuccess but result null", new Object[0]);
                    if (h.f75864a.a(this.f76738a.q)) {
                        Toast.makeText(this.f76738a.q, "网络不给力，请稍后重试", 1).show();
                    }
                    if (this.f76738a.l != null) {
                        this.f76738a.l.onRefreshViewFail(-1, "onSuccess but null");
                    }
                }
                this.f76738a.r();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i2 + " failReason:" + str, new Object[0]);
                if (h.f75864a.a(this.f76738a.q)) {
                    Toast.makeText(this.f76738a.q, "网络不给力，请稍后重试", 1).show();
                }
                if (this.f76738a.l != null) {
                    this.f76738a.l.onRefreshViewFail(i2, str);
                }
                this.f76738a.r();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Context context, int i2, int i3, IYYPayWayView.b bVar, i.a.a.e.k.a aVar, i.a.a.e.k.b bVar2) {
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
        this.f76726e = new ArrayList();
        this.v = "";
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        PayUIKitConfig payUIKitConfig = bVar2 != null ? bVar2.getPayUIKitConfig() : null;
        LayoutInflater.from(new ContextThemeWrapper(context, g.f75863a.a(payUIKitConfig))).inflate(i.a.a.e.e.pay_ui_layout_pay_way_view, (ViewGroup) this, true);
        this.p = bVar;
        this.o = bVar.f76701b;
        this.q = context;
        this.t = bVar2;
        this.j = i2;
        this.k = i3;
        this.x = aVar;
        this.w = bVar.f76702c;
        this.f76728g = new i.a.a.e.o.b.b(context, payUIKitConfig, this.f76726e);
        t(this.p.f76700a);
        GridView gridView = (GridView) findViewById(i.a.a.e.d.grid_recharge_way);
        this.f76727f = gridView;
        gridView.setSelector(i.a.a.e.c.pay_ui_selector_transparent);
        this.f76727f.setAdapter((ListAdapter) this.f76728g);
        this.f76727f.setOnItemClickListener(new a(this, context));
        Button button = (Button) findViewById(i.a.a.e.d.btn_confirm_recharge);
        this.n = button;
        button.setOnClickListener(new b(this, context));
        TextView textView = (TextView) findViewById(i.a.a.e.d.tv_total_src_amount);
        TextView textView2 = (TextView) findViewById(i.a.a.e.d.tv_total_dst_amount);
        IYYPayWayView.b bVar3 = this.p;
        if (bVar3 != null && bVar3.f76701b != null) {
            String str = "0.00";
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            Double b2 = this.p.f76701b.b();
            if (b2 != null) {
                str = decimalFormat.format(b2);
                textView.setText(str);
            } else {
                textView.setText("0.00");
            }
            textView2.setText(decimalFormat.format(this.p.f76701b.a()));
            this.n.setText("确认支付 " + str + "元");
        }
        TextView textView3 = (TextView) findViewById(i.a.a.e.d.tv_use_item);
        this.r = textView3;
        textView3.setOnClickListener(new c(this));
        this.u = this.q.getSharedPreferences("yy_paysdk_sp_name", 0);
        this.s = (ImageView) findViewById(i.a.a.e.d.img_select);
        boolean z = this.u.getBoolean("yy_paysdk_sp_use_item_state_key", true);
        this.n.setEnabled(z);
        int i6 = g.f75863a.b(payUIKitConfig) ? i.a.a.e.c.pay_ui_pay_way_item_select : i.a.a.e.c.pay_ui_pay_way_item_select_y;
        this.s.setBackgroundResource(z ? i6 : i.a.a.e.c.pay_ui_pay_way_item_unselect);
        this.s.setOnClickListener(new d(this, i6));
        this.f76729h = findViewById(i.a.a.e.d.root_loading);
        this.f76730i = (ImageView) findViewById(i.a.a.e.d.iv_loading_circle);
        IYYPayWayView.b bVar4 = this.p;
        i.a.a.e.m.a.d(this.j, this.k, (bVar4 == null || bVar4.f76705f != PaySource.WALLET) ? "4" : "11", "", "", "");
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    public List<i.a.a.e.l.c> q(List<PayWayInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PayWayInfo payWayInfo = list.get(i2);
                    if (PayType.ALI_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.ALI_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new i.a.a.e.l.c(PayType.ALI_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.WECHAT_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new i.a.a.e.l.c(PayType.WECHAT_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new i.a.a.e.l.c(PayType.DXM_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.DXM_PAY_KJ.getChannel().equals(payWayInfo.payChannel) && PayType.DXM_PAY_KJ.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new i.a.a.e.l.c(PayType.DXM_PAY_KJ, payWayInfo.name, payWayInfo.tips));
                    }
                }
                return arrayList;
            }
            RLog.error("YYPayWayView", "createRechargeWayList error mPayWayInfoList null", new Object[0]);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i.a.a.e.n.d.a(this.f76729h, this.f76730i);
        }
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f76726e.size() > 0 || this.t == null || this.x == null) {
            return;
        }
        s();
        this.t.queryProductList(this.x.c(), new e(this));
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i.a.a.e.n.d.b(this.f76729h, this.f76730i);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.l = aVar;
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, payViewState) == null) {
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

    public final void t(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f76726e.clear();
            this.f76726e.addAll(q(list));
            if (this.f76726e.size() > 0) {
                this.m = this.f76726e.get(0);
                this.f76728g.c(0);
            }
            if (Env.instance().isTestEnv() && this.f76726e.size() > 0) {
                this.f76726e.add(new i.a.a.e.l.c(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.f76728g.notifyDataSetChanged();
        }
    }
}
