package tv.athena.revenue.payui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import i.a.a.e.n.g;
import i.a.a.e.n.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes8.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public int A;
    public int B;

    /* renamed from: e  reason: collision with root package name */
    public Activity f72926e;

    /* renamed from: f  reason: collision with root package name */
    public Button f72927f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f72928g;

    /* renamed from: h  reason: collision with root package name */
    public View f72929h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f72930i;
    public i.a.a.e.k.a j;
    public NoScrollGridView k;
    public PluginCenterTopBanner l;
    public i.a.a.e.o.b.a m;
    public QueryCurrencyReqParams n;
    public i.a.a.e.k.b o;
    public List<i.a.a.e.l.a> p;
    public List<BannerConfigItem.BannerInfo> q;
    public IYYPayAmountView.ViewParams r;
    public MyBalanceInfo.Account s;
    public List<PayWayInfo> t;
    public i.a.a.e.l.a u;
    public int v;
    public IYYPayAmountView.Callback w;
    public String x;
    public volatile boolean y;
    public volatile boolean z;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            i.a.a.e.l.a item = YYPayAmountView.this.m.getItem(i2);
            if (item.f72154c) {
                YYPayAmountView.this.D();
                return;
            }
            YYPayAmountView.this.u = item;
            YYPayAmountView.this.m.d(i2);
            YYPayAmountView.this.m.notifyDataSetChanged();
            YYPayAmountView.this.H(item);
            i.a.a.e.m.a.d(YYPayAmountView.this.A, YYPayAmountView.this.B, "3", "", "", String.valueOf((YYPayAmountView.this.u == null || YYPayAmountView.this.u.f72152a == null) ? 0 : YYPayAmountView.this.u.f72152a.cid));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YYPayAmountView.this.v();
            i.a.a.e.m.a.d(YYPayAmountView.this.A, YYPayAmountView.this.B, "2", "", "", String.valueOf((YYPayAmountView.this.u == null || YYPayAmountView.this.u.f72152a == null) ? 0 : YYPayAmountView.this.u.f72152a.cid));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (i2 < 0 || i2 >= YYPayAmountView.this.q.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayAmountView.this.q.get(i2);
            RLog.debug("YYPayAmountView", "updateBanner: click=" + bannerInfo.jumpData);
            if (YYPayAmountView.this.r == null || YYPayAmountView.this.r.viewEventListener == null) {
                return;
            }
            YYPayAmountView.this.r.viewEventListener.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements IResult<ProductListResult> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.y = false;
            YYPayAmountView.this.F(productListResult);
            YYPayAmountView.this.z();
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.y = false;
            RLog.error("YYPayAmountView", "queryProductList onFail code:" + i2 + " failReason:" + str, new Object[0]);
            if (h.f72168a.a(YYPayAmountView.this.f72926e)) {
                String str2 = "请求服务失败 code:" + i2 + " failReason:" + str;
                if (i2 == -500) {
                    str2 = "网络不给力，请稍后重试";
                }
                Toast.makeText(YYPayAmountView.this.f72926e, str2, 1).show();
            }
            if (YYPayAmountView.this.w != null) {
                YYPayAmountView.this.w.onRefreshViewFail(i2, str);
            }
            YYPayAmountView.this.z();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements IResult<MyBalanceResult> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.z = false;
            RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
            if (myBalanceResult != null) {
                PayUIKitConfig payUIKitConfig = YYPayAmountView.this.o.getPayUIKitConfig();
                MiddleRevenueConfig middleRevenueConfig = payUIKitConfig != null ? payUIKitConfig.revenueConfig : null;
                MyBalanceInfo.Account myBalance = middleRevenueConfig != null ? myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType()) : null;
                if (myBalance != null) {
                    YYPayAmountView.this.s = myBalance;
                    YYPayAmountView.this.I();
                    RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + myBalance);
                    YYPayAmountView.this.z();
                    return;
                }
                RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
                return;
            }
            RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.z = false;
            RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i2 + " failReason:" + str, new Object[0]);
            YYPayAmountView.this.z();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements IResult<BannerConfigResult> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            RLog.info("YYPayAmountView", "queryBannerConfig() onSuccess:" + bannerConfigResult);
            YYPayAmountView.this.q.clear();
            if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                list = null;
            } else {
                BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                list = bannerConfigItem.bannerInfoList;
                YYPayAmountView.this.v = bannerConfigItem.autoPlayTime;
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            YYPayAmountView.this.q.addAll(list);
            YYPayAmountView.this.G();
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayAmountView", "queryBannerConfig onFail code:" + i2 + " failReason:" + str, new Object[0]);
        }
    }

    public YYPayAmountView(Activity activity, int i2, int i3, i.a.a.e.k.b bVar, IYYPayAmountView.ViewParams viewParams, i.a.a.e.k.a aVar) {
        super(activity);
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.x = "Y币";
        this.f72926e = activity;
        this.j = aVar;
        this.o = bVar;
        this.r = viewParams;
        this.n = aVar.c();
        this.A = i2;
        this.B = i3;
        y(activity);
    }

    public final void A() {
        if (this.o == null) {
            return;
        }
        GetBannerConfigReqParams a2 = this.j.a();
        if (a2 == null) {
            RLog.error("YYPayAmountView", "queryBannerConfig error reqParams null", new Object[0]);
            return;
        }
        a2.setTypes(new int[]{1});
        RLog.info("YYPayAmountView", "queryBannerConfig: " + a2);
        this.o.h(a2, new f());
    }

    public final void B() {
        if (this.o == null) {
            return;
        }
        QueryCurrencyReqParams b2 = this.j.b();
        if (b2 == null) {
            RLog.error("YYPayAmountView", "queryMyBalance error reqParams null", new Object[0]);
            return;
        }
        this.z = true;
        this.o.queryMyBalance(b2, new e());
    }

    public final void C() {
        if (this.o == null) {
            return;
        }
        this.y = true;
        this.o.queryProductList(this.n, new d());
    }

    public final void D() {
        List<PayWayInfo> list = this.t;
        if (list == null) {
            RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
            return;
        }
        IYYPayAmountView.Callback callback = this.w;
        if (callback != null) {
            callback.showInputNumberDialog(this.f72926e, list);
        }
    }

    public final void E() {
        i.a.a.e.n.d.b(this.f72929h, this.f72930i);
    }

    public final void F(ProductListResult productListResult) {
        if (productListResult == null) {
            RLog.error("YYPayAmountView", "showProductListView null", new Object[0]);
        } else if (this.k != null && this.m != null) {
            String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
            this.x = currencyName;
            this.m.c(currencyName);
            List<ProductInfo> productInfoList = productListResult.getProductInfoList();
            if (productInfoList != null && productInfoList.size() != 0) {
                this.p.clear();
                int i2 = 0;
                for (int i3 = 0; i3 < productInfoList.size(); i3++) {
                    i.a.a.e.l.a aVar = new i.a.a.e.l.a(productInfoList.get(i3), productListResult.getCurrencyType());
                    if (aVar.a() == 10.0d) {
                        i2 = i3;
                    }
                    this.p.add(aVar);
                }
                if (this.p.size() < 6) {
                    this.p.add(new i.a.a.e.l.a(true));
                }
                this.k.setNumColumns(w(this.m.getCount()));
                this.m.notifyDataSetChanged();
                List<PayWayInfo> payWayInfoList = productListResult.getPayWayInfoList();
                this.t = payWayInfoList;
                if (payWayInfoList != null) {
                    Iterator<PayWayInfo> it = payWayInfoList.iterator();
                    while (it.hasNext()) {
                        RLog.debug("YYPayAmountView", "payWayInfo-> " + it.next());
                    }
                }
                this.u = this.p.get(i2);
                this.m.d(i2);
                this.m.notifyDataSetChanged();
                H(this.m.b());
                i.a.a.e.l.b.f72155a = productListResult.getPaysSettingInfo();
                return;
            }
            RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
        }
    }

    public final void G() {
        RLog.debug("YYPayAmountView", "updateBanner: count=" + this.q.size());
        if (this.q.size() == 0) {
            this.l.setVisibility(8);
            return;
        }
        int i2 = this.v;
        if (i2 > 0) {
            this.l.setFlipInterval(i2);
        }
        this.l.setData(this.q);
        this.l.setOnItemClickListener(new c());
        this.l.setVisibility(0);
    }

    public final void H(i.a.a.e.l.a aVar) {
        if (this.f72927f == null) {
            RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
        } else if (aVar == null) {
            RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
        } else {
            this.f72927f.setText("立即充值" + i.a.a.e.n.f.a(aVar.b().doubleValue()) + "元");
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void I() {
        Activity activity;
        if (this.s == null) {
            RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
        } else if (this.f72928g != null && (activity = this.f72926e) != null && !activity.isFinishing()) {
            String str = null;
            MyBalanceInfo.Account account = this.s;
            int i2 = account.currencyType;
            String a2 = i.a.a.e.n.f.a(account.amount / 100.0d);
            IYYPayAmountView.ViewParams viewParams = this.r;
            if (viewParams != null) {
                int i3 = viewParams.targetAmount;
                long j = this.s.amount;
                if (i3 > j) {
                    str = i.a.a.e.n.f.a((i3 - j) / 100.0d);
                }
            }
            this.f72928g.setVisibility(0);
            if (str == null) {
                if (i2 == 4) {
                    this.f72928g.setText(String.format(this.f72926e.getString(i.a.a.e.f.pay_ui_str_wallet_amount), a2));
                    return;
                } else {
                    this.f72928g.setText(String.format(this.f72926e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_other), a2));
                    return;
                }
            }
            this.f72928g.setTextColor(this.f72926e.getResources().getColor(i.a.a.e.a.pay_ui_color_FF3355));
            if (i2 == 4) {
                this.f72928g.setText(String.format(this.f72926e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_not_enough), a2, str));
            } else {
                this.f72928g.setText(String.format(this.f72926e.getString(i.a.a.e.f.pay_ui_str_wallet_amount_not_enough_other), a2, str));
            }
        } else {
            RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, i.a.a.e.o.a
    public View getContentView() {
        return this;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, i.a.a.e.o.a
    public void refreshView() {
        E();
        C();
        B();
        A();
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        this.w = callback;
    }

    public final void v() {
        List<PayWayInfo> list;
        i.a.a.e.l.a aVar = this.u;
        if (aVar != null && (list = this.t) != null) {
            IYYPayAmountView.Callback callback = this.w;
            if (callback != null) {
                callback.toPayWayDialog(aVar, list);
                return;
            }
            return;
        }
        RLog.error("YYPayAmountView", "confirmRecharge data null", new Object[0]);
    }

    public final int w(int i2) {
        return i2 < 5 ? 2 : 3;
    }

    public final void x() {
        i.a.a.e.n.d.a(this.f72929h, this.f72930i);
    }

    public final void y(Activity activity) {
        i.a.a.e.k.b bVar = this.o;
        PayUIKitConfig payUIKitConfig = bVar != null ? bVar.getPayUIKitConfig() : null;
        LayoutInflater.from(new ContextThemeWrapper(activity, g.f72167a.a(payUIKitConfig))).inflate(i.a.a.e.e.pay_ui_layout_pay_amount_view, (ViewGroup) this, true);
        this.f72928g = (TextView) findViewById(i.a.a.e.d.tv_amount);
        i.a.a.e.o.b.a aVar = new i.a.a.e.o.b.a(this.f72926e, this.p, payUIKitConfig);
        this.m = aVar;
        aVar.c(this.x);
        NoScrollGridView noScrollGridView = (NoScrollGridView) findViewById(i.a.a.e.d.grid_recharge_amount);
        this.k = noScrollGridView;
        noScrollGridView.setSelector(i.a.a.e.c.pay_ui_selector_transparent);
        this.k.setAdapter((ListAdapter) this.m);
        this.k.setOnItemClickListener(new a());
        Button button = (Button) findViewById(i.a.a.e.d.btn_confirm_recharge);
        this.f72927f = button;
        button.setOnClickListener(new b());
        H(this.m.b());
        this.l = (PluginCenterTopBanner) findViewById(i.a.a.e.d.banner);
        i.a.a.e.k.b bVar2 = this.o;
        if (bVar2 != null && bVar2.getPayUIKitConfig() != null) {
            this.l.setImageLoaderSupplier(this.o.getPayUIKitConfig().imageLoaderSupplier);
        }
        this.f72929h = findViewById(i.a.a.e.d.root_loading);
        this.f72930i = (ImageView) findViewById(i.a.a.e.d.iv_loading_circle);
        i.a.a.e.m.a.d(this.A, this.B, "1", "", "", "");
    }

    public final void z() {
        if (this.y || this.z) {
            return;
        }
        x();
    }
}
