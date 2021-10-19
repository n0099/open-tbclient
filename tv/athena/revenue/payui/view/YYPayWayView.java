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
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import j.a.a.e.e;
import j.a.a.e.n.h;
import j.a.a.e.n.i;
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
    public List<j.a.a.e.l.c> f80324e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f80325f;

    /* renamed from: g  reason: collision with root package name */
    public j.a.a.e.o.b.b f80326g;

    /* renamed from: h  reason: collision with root package name */
    public View f80327h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f80328i;

    /* renamed from: j  reason: collision with root package name */
    public int f80329j;
    public int k;
    public IYYPayWayView.a l;
    public j.a.a.e.l.c m;
    public Button n;
    public j.a.a.e.l.a o;
    public IYYPayWayView.b p;
    public Context q;
    public TextView r;
    public j.a.a.e.k.c s;
    public String t;
    public AppCustomExpand u;
    public j.a.a.e.k.a v;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f80330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f80331f;

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
            this.f80331f = yYPayWayView;
            this.f80330e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                YYPayWayView yYPayWayView = this.f80331f;
                yYPayWayView.m = yYPayWayView.f80326g.getItem(i2);
                if (this.f80331f.f80326g.b() != i2) {
                    this.f80331f.f80326g.c(i2);
                    this.f80331f.f80326g.notifyDataSetChanged();
                }
                j.a.a.e.m.a.d(this.f80331f.f80329j, this.f80331f.k, (this.f80331f.p == null || this.f80331f.p.f80300f != PaySource.WALLET) ? "6" : "13", this.f80331f.m.f79520a.getChannel(), this.f80331f.m.f79520a.getMethod(), String.valueOf((this.f80331f.o == null || this.f80331f.o.f79513a == null) ? 0 : this.f80331f.o.f79513a.cid));
                RLog.info("YYPayWayView", "choose paychannel:" + this.f80331f.m.f79520a.getChannel() + " paymethod:" + this.f80331f.m.f79520a.getMethod());
                if (this.f80331f.m.f79520a != PayType.WECHAT_PAY || PackageInstallUtil.isInstallWechat(this.f80330e)) {
                    if (this.f80331f.m.f79520a != PayType.QQ_PAY || PackageInstallUtil.isInstallQQ(this.f80330e)) {
                        return;
                    }
                    Toast.makeText(this.f80330e, "未安装QQ", 1).show();
                    return;
                }
                Toast.makeText(this.f80330e, "未安装微信", 1).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends j.a.a.e.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f80332f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f80333g;

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
            this.f80333g = yYPayWayView;
            this.f80332f = context;
        }

        @Override // j.a.a.e.q.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = 0;
                if (this.f80333g.m != null) {
                    if (this.f80333g.m.f79520a != PayType.WECHAT_PAY || PackageInstallUtil.isInstallWechat(this.f80332f)) {
                        if (this.f80333g.m.f79520a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.f80332f)) {
                            Toast.makeText(this.f80332f, "未安装QQ", 1).show();
                            return;
                        }
                        if (Env.instance().isTestEnv() && this.f80333g.m.f79520a == PayType.MOCK_TEST_PAY && this.f80333g.o != null && this.f80333g.o.f79513a.srcAmount.doubleValue() > 10.0d) {
                            this.f80333g.o.f79513a.srcAmount = Double.valueOf(10.0d);
                            this.f80333g.o.f79513a.destAmount = 1000L;
                        }
                        if (this.f80333g.l != null && this.f80333g.o != null && this.f80333g.o.f79513a != null) {
                            this.f80333g.l.a(this.f80333g.m, this.f80333g.o, this.f80333g.u);
                            j.a.a.e.m.a.c(this.f80333g.f80329j, this.f80333g.k, UiEventType.paypagepaybt, String.valueOf(this.f80333g.o.f79513a.srcAmount));
                            RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.f80333g.o.f79513a.srcAmount);
                        } else {
                            RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                        }
                        if (this.f80333g.o != null && this.f80333g.o.f79513a != null) {
                            i2 = this.f80333g.o.f79513a.cid;
                        }
                        j.a.a.e.m.a.d(this.f80333g.f80329j, this.f80333g.k, (this.f80333g.p == null || this.f80333g.p.f80300f != PaySource.WALLET) ? "5" : "12", this.f80333g.m.f79520a.getChannel(), this.f80333g.m.f79520a.getMethod(), String.valueOf(i2));
                        RLog.info("YYPayWayView", "comfirm paychannel:" + this.f80333g.m.f79520a.getChannel() + " paymethod:" + this.f80333g.m.f79520a.getMethod());
                        return;
                    }
                    Toast.makeText(this.f80332f, "未安装微信", 1).show();
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
        public final /* synthetic */ YYPayWayView f80334e;

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
            this.f80334e = yYPayWayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f80334e.s == null || this.f80334e.s.getPayUIKitConfig() == null) {
                return;
            }
            String d2 = j.a.a.e.l.b.d(this.f80334e.s.getPayUIKitConfig());
            RLog.debug("YYPayWayView", "agreeUrl:" + d2);
            if (this.f80334e.q instanceof Activity) {
                this.f80334e.s.j((Activity) this.f80334e.q, d2, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
            }
            j.a.a.e.m.a.b(this.f80334e.f80329j, this.f80334e.k, UiEventType.paypageprotocol);
            RLog.warn("YYPayWayView", UiEventType.paypageprotocol);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayWayView f80335a;

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
            this.f80335a = yYPayWayView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) {
                if (productListResult != null && productListResult.getPayWayInfoList() != null) {
                    this.f80335a.q(productListResult.getPayWayInfoList());
                } else {
                    RLog.error("YYPayWayView", "onSuccess but result null", new Object[0]);
                    if (i.f79529a.a(this.f80335a.q)) {
                        Toast.makeText(this.f80335a.q, "网络不给力，请稍后重试", 1).show();
                    }
                    if (this.f80335a.l != null) {
                        this.f80335a.l.onRefreshViewFail(-1, "onSuccess but null");
                    }
                }
                this.f80335a.n();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.error("YYPayWayView", "onFail code:" + i2 + " failReason:" + str, new Object[0]);
                if (i.f79529a.a(this.f80335a.q)) {
                    Toast.makeText(this.f80335a.q, "网络不给力，请稍后重试", 1).show();
                }
                if (this.f80335a.l != null) {
                    this.f80335a.l.onRefreshViewFail(i2, str);
                }
                this.f80335a.n();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWayView(Context context, int i2, int i3, IYYPayWayView.b bVar, j.a.a.e.k.a aVar, j.a.a.e.k.c cVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), bVar, aVar, cVar};
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
        this.f80324e = new ArrayList();
        this.t = "";
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        PayUIKitConfig payUIKitConfig = cVar != null ? cVar.getPayUIKitConfig() : null;
        LayoutInflater.from(new ContextThemeWrapper(context, h.f79528a.a(payUIKitConfig))).inflate(e.pay_ui_layout_pay_way_view, (ViewGroup) this, true);
        this.p = bVar;
        this.o = bVar.f80296b;
        this.q = context;
        this.s = cVar;
        this.f80329j = i2;
        this.k = i3;
        this.v = aVar;
        this.u = bVar.f80297c;
        this.f80326g = new j.a.a.e.o.b.b(context, payUIKitConfig, this.f80324e);
        GridView gridView = (GridView) findViewById(j.a.a.e.d.grid_recharge_way);
        this.f80325f = gridView;
        gridView.setSelector(j.a.a.e.c.pay_ui_selector_transparent);
        this.f80325f.setAdapter((ListAdapter) this.f80326g);
        this.f80325f.setOnItemClickListener(new a(this, context));
        Button button = (Button) findViewById(j.a.a.e.d.btn_confirm_recharge);
        this.n = button;
        button.setOnClickListener(new b(this, context));
        TextView textView = (TextView) findViewById(j.a.a.e.d.tv_total_src_amount);
        TextView textView2 = (TextView) findViewById(j.a.a.e.d.tv_total_dst_amount);
        IYYPayWayView.b bVar2 = this.p;
        if (bVar2 != null && bVar2.f80296b != null) {
            String str = "0.00";
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            Double b2 = this.p.f80296b.b();
            if (b2 != null) {
                str = decimalFormat.format(b2);
                textView.setText(str);
            } else {
                textView.setText("0.00");
            }
            textView2.setText(decimalFormat.format(this.p.f80296b.a()));
            this.n.setText("确认支付 " + str + "元");
        }
        TextView textView3 = (TextView) findViewById(j.a.a.e.d.tv_use_item);
        this.r = textView3;
        textView3.setOnClickListener(new c(this));
        this.f80327h = findViewById(j.a.a.e.d.root_loading);
        this.f80328i = (ImageView) findViewById(j.a.a.e.d.iv_loading_circle);
        IYYPayWayView.b bVar3 = this.p;
        j.a.a.e.m.a.d(this.f80329j, this.k, (bVar3 == null || bVar3.f80300f != PaySource.WALLET) ? "4" : "11", "", "", "");
        q(this.p.f80295a);
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
                    } else if (PayType.QQ_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.QQ_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new j.a.a.e.l.c(PayType.QQ_PAY, payWayInfo.name, payWayInfo.tips));
                    } else if (PayType.UNION_PAY.getChannel().equals(payWayInfo.payChannel) && PayType.UNION_PAY.getMethod().equals(payWayInfo.payMethod)) {
                        arrayList.add(new j.a.a.e.l.c(PayType.UNION_PAY, payWayInfo.name, payWayInfo.tips));
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

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j.a.a.e.n.e.a(this.f80327h, this.f80328i);
        }
    }

    public final void o() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f80324e.size() <= 4 || (gridView = this.f80325f) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.height += j.a.a.e.n.c.a(24.0f);
        this.f80325f.setLayoutParams(layoutParams);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j.a.a.e.n.e.b(this.f80327h, this.f80328i);
        }
    }

    public final void q(List<PayWayInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f80324e.clear();
            this.f80324e.addAll(createRechargeWayList(list));
            if (this.f80324e.size() > 0) {
                this.m = this.f80324e.get(0);
                this.f80326g.c(0);
            }
            if (Env.instance().isTestEnv() && this.f80324e.size() > 0) {
                this.f80324e.add(new j.a.a.e.l.c(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
            }
            this.f80326g.notifyDataSetChanged();
            o();
        }
    }

    @Override // j.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f80324e.size() > 0 || this.s == null || this.v == null) {
            return;
        }
        p();
        this.s.queryProductList(this.v.c(), new d(this));
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.l = aVar;
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, payViewState) == null) {
            if (payViewState == IYYPayWayView.PayViewState.WAITING_VIEW_STATE) {
                RLog.info("YYPayWayView", "setViewState waiting");
                Button button = this.n;
                if (button == null) {
                    return;
                }
                this.t = button.getText().toString();
                this.n.setText("等待支付结果...");
                this.n.setClickable(false);
            } else if (payViewState == IYYPayWayView.PayViewState.SELECTING_VIEW_STATE) {
                RLog.info("YYPayWayView", "setViewState selecting");
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
