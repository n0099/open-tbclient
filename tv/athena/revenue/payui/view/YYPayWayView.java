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
/* loaded from: classes8.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {

    /* renamed from: e  reason: collision with root package name */
    public List<i.a.a.e.l.c> f72946e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f72947f;

    /* renamed from: g  reason: collision with root package name */
    public i.a.a.e.o.b.b f72948g;

    /* renamed from: h  reason: collision with root package name */
    public View f72949h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f72950i;
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

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f72951e;

        public a(Context context) {
            this.f72951e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            YYPayWayView yYPayWayView = YYPayWayView.this;
            yYPayWayView.m = yYPayWayView.f72948g.getItem(i2);
            if (YYPayWayView.this.f72948g.b() != i2) {
                YYPayWayView.this.f72948g.c(i2);
                YYPayWayView.this.f72948g.notifyDataSetChanged();
            }
            i.a.a.e.m.a.d(YYPayWayView.this.j, YYPayWayView.this.k, (YYPayWayView.this.p == null || YYPayWayView.this.p.f72925f != PaySource.WALLET) ? "6" : "13", YYPayWayView.this.m.f72159a.getChannel(), YYPayWayView.this.m.f72159a.getMethod(), String.valueOf((YYPayWayView.this.o == null || YYPayWayView.this.o.f72152a == null) ? 0 : YYPayWayView.this.o.f72152a.cid));
            RLog.info("YYPayWayView", "choose paychannel:" + YYPayWayView.this.m.f72159a.getChannel() + " paymethod:" + YYPayWayView.this.m.f72159a.getMethod());
            if (YYPayWayView.this.m.f72159a != PayType.WECHAT_PAY || PackageInstallUtil.isInstallWechat(this.f72951e)) {
                return;
            }
            Toast.makeText(this.f72951e, "未安装微信", 1).show();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends i.a.a.e.q.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f72953f;

        public b(Context context) {
            this.f72953f = context;
        }

        @Override // i.a.a.e.q.a
        public void a(View view) {
            int i2 = 0;
            if (YYPayWayView.this.m != null) {
                if (YYPayWayView.this.m.f72159a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.f72953f)) {
                    Toast.makeText(this.f72953f, "未安装微信", 1).show();
                    return;
                }
                if (Env.instance().isTestEnv() && YYPayWayView.this.m.f72159a == PayType.MOCK_TEST_PAY && YYPayWayView.this.o != null && YYPayWayView.this.o.f72152a.srcAmount.doubleValue() > 10.0d) {
                    YYPayWayView.this.o.f72152a.srcAmount = Double.valueOf(10.0d);
                    YYPayWayView.this.o.f72152a.destAmount = 1000L;
                }
                if (YYPayWayView.this.l != null && YYPayWayView.this.o != null && YYPayWayView.this.o.f72152a != null) {
                    YYPayWayView.this.l.a(YYPayWayView.this.m, YYPayWayView.this.o, YYPayWayView.this.w);
                    i.a.a.e.m.a.c(YYPayWayView.this.j, YYPayWayView.this.k, UiEventType.paypagepaybt, String.valueOf(YYPayWayView.this.o.f72152a.srcAmount));
                    RLog.warn("YYPayWayView", "paypagepaybt amount:" + YYPayWayView.this.o.f72152a.srcAmount);
                } else {
                    RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                }
                if (YYPayWayView.this.o != null && YYPayWayView.this.o.f72152a != null) {
                    i2 = YYPayWayView.this.o.f72152a.cid;
                }
                i.a.a.e.m.a.d(YYPayWayView.this.j, YYPayWayView.this.k, (YYPayWayView.this.p == null || YYPayWayView.this.p.f72925f != PaySource.WALLET) ? "5" : "12", YYPayWayView.this.m.f72159a.getChannel(), YYPayWayView.this.m.f72159a.getMethod(), String.valueOf(i2));
                RLog.info("YYPayWayView", "comfirm paychannel:" + YYPayWayView.this.m.f72159a.getChannel() + " paymethod:" + YYPayWayView.this.m.f72159a.getMethod());
                return;
            }
            RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (YYPayWayView.this.t == null || YYPayWayView.this.t.getPayUIKitConfig() == null) {
                return;
            }
            String d2 = i.a.a.e.l.b.d(YYPayWayView.this.t.getPayUIKitConfig());
            RLog.debug("YYPayWayView", "agreeUrl:" + d2);
            if (YYPayWayView.this.q instanceof Activity) {
                YYPayWayView.this.t.j((Activity) YYPayWayView.this.q, d2, "Y币充值协议");
            } else {
                RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
            }
            i.a.a.e.m.a.b(YYPayWayView.this.j, YYPayWayView.this.k, UiEventType.paypageprotocol);
            RLog.warn("YYPayWayView", UiEventType.paypageprotocol);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f72956e;

        public d(int i2) {
            this.f72956e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = !YYPayWayView.this.n.isEnabled();
            YYPayWayView.this.n.setEnabled(z);
            YYPayWayView.this.u.edit().putBoolean("yy_paysdk_sp_use_item_state_key", z).commit();
            YYPayWayView.this.s.setBackgroundResource(z ? this.f72956e : i.a.a.e.c.pay_ui_pay_way_item_unselect);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements IResult<ProductListResult> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            if (productListResult != null && productListResult.getPayWayInfoList() != null) {
                YYPayWayView.this.t(productListResult.getPayWayInfoList());
            } else {
                RLog.error("YYPayWayView", "onSuccess but result null", new Object[0]);
                if (h.f72168a.a(YYPayWayView.this.q)) {
                    Toast.makeText(YYPayWayView.this.q, "网络不给力，请稍后重试", 1).show();
                }
                if (YYPayWayView.this.l != null) {
                    YYPayWayView.this.l.onRefreshViewFail(-1, "onSuccess but null");
                }
            }
            YYPayWayView.this.r();
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayWayView", "onFail code:" + i2 + " failReason:" + str, new Object[0]);
            if (h.f72168a.a(YYPayWayView.this.q)) {
                Toast.makeText(YYPayWayView.this.q, "网络不给力，请稍后重试", 1).show();
            }
            if (YYPayWayView.this.l != null) {
                YYPayWayView.this.l.onRefreshViewFail(i2, str);
            }
            YYPayWayView.this.r();
        }
    }

    public YYPayWayView(Context context, int i2, int i3, IYYPayWayView.b bVar, i.a.a.e.k.a aVar, i.a.a.e.k.b bVar2) {
        super(context);
        this.f72946e = new ArrayList();
        this.v = "";
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        PayUIKitConfig payUIKitConfig = bVar2 != null ? bVar2.getPayUIKitConfig() : null;
        LayoutInflater.from(new ContextThemeWrapper(context, g.f72167a.a(payUIKitConfig))).inflate(i.a.a.e.e.pay_ui_layout_pay_way_view, (ViewGroup) this, true);
        this.p = bVar;
        this.o = bVar.f72921b;
        this.q = context;
        this.t = bVar2;
        this.j = i2;
        this.k = i3;
        this.x = aVar;
        this.w = bVar.f72922c;
        this.f72948g = new i.a.a.e.o.b.b(context, payUIKitConfig, this.f72946e);
        t(this.p.f72920a);
        GridView gridView = (GridView) findViewById(i.a.a.e.d.grid_recharge_way);
        this.f72947f = gridView;
        gridView.setSelector(i.a.a.e.c.pay_ui_selector_transparent);
        this.f72947f.setAdapter((ListAdapter) this.f72948g);
        this.f72947f.setOnItemClickListener(new a(context));
        Button button = (Button) findViewById(i.a.a.e.d.btn_confirm_recharge);
        this.n = button;
        button.setOnClickListener(new b(context));
        TextView textView = (TextView) findViewById(i.a.a.e.d.tv_total_src_amount);
        TextView textView2 = (TextView) findViewById(i.a.a.e.d.tv_total_dst_amount);
        IYYPayWayView.b bVar3 = this.p;
        if (bVar3 != null && bVar3.f72921b != null) {
            String str = "0.00";
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            Double b2 = this.p.f72921b.b();
            if (b2 != null) {
                str = decimalFormat.format(b2);
                textView.setText(str);
            } else {
                textView.setText("0.00");
            }
            textView2.setText(decimalFormat.format(this.p.f72921b.a()));
            this.n.setText("确认支付 " + str + "元");
        }
        TextView textView3 = (TextView) findViewById(i.a.a.e.d.tv_use_item);
        this.r = textView3;
        textView3.setOnClickListener(new c());
        this.u = this.q.getSharedPreferences("yy_paysdk_sp_name", 0);
        this.s = (ImageView) findViewById(i.a.a.e.d.img_select);
        boolean z = this.u.getBoolean("yy_paysdk_sp_use_item_state_key", true);
        this.n.setEnabled(z);
        int i4 = g.f72167a.b(payUIKitConfig) ? i.a.a.e.c.pay_ui_pay_way_item_select : i.a.a.e.c.pay_ui_pay_way_item_select_y;
        this.s.setBackgroundResource(z ? i4 : i.a.a.e.c.pay_ui_pay_way_item_unselect);
        this.s.setOnClickListener(new d(i4));
        this.f72949h = findViewById(i.a.a.e.d.root_loading);
        this.f72950i = (ImageView) findViewById(i.a.a.e.d.iv_loading_circle);
        IYYPayWayView.b bVar4 = this.p;
        i.a.a.e.m.a.d(this.j, this.k, (bVar4 == null || bVar4.f72925f != PaySource.WALLET) ? "4" : "11", "", "", "");
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        return this;
    }

    public List<i.a.a.e.l.c> q(List<PayWayInfo> list) {
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

    public final void r() {
        i.a.a.e.n.d.a(this.f72949h, this.f72950i);
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
        if (this.f72946e.size() > 0 || this.t == null || this.x == null) {
            return;
        }
        s();
        this.t.queryProductList(this.x.c(), new e());
    }

    public final void s() {
        i.a.a.e.n.d.b(this.f72949h, this.f72950i);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        this.l = aVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
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

    public final void t(List<PayWayInfo> list) {
        this.f72946e.clear();
        this.f72946e.addAll(q(list));
        if (this.f72946e.size() > 0) {
            this.m = this.f72946e.get(0);
            this.f72948g.c(0);
        }
        if (Env.instance().isTestEnv() && this.f72946e.size() > 0) {
            this.f72946e.add(new i.a.a.e.l.c(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
        }
        this.f72948g.notifyDataSetChanged();
    }
}
