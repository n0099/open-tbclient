package tv.athena.revenue.payui.view.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.tieba.R;
import com.baidu.tieba.bab;
import com.baidu.tieba.e9b;
import com.baidu.tieba.f6b;
import com.baidu.tieba.f7b;
import com.baidu.tieba.g9b;
import com.baidu.tieba.j9b;
import com.baidu.tieba.l9b;
import com.baidu.tieba.n9b;
import com.baidu.tieba.r8b;
import com.baidu.tieba.y8b;
import com.baidu.tieba.y9b;
import com.baidu.tieba.z8b;
import com.baidu.tieba.z9b;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PayAmountAdapter;
import tv.athena.revenue.payui.view.adapter.PayAmountGridItemDecoration;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes9.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public f7b A;
    public ProductListResult B;
    public MyBalanceInfo.Account C;
    public List<PayWayInfo> D;
    public String E;
    public Window F;
    public Activity a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public ImageView i;
    public RecyclerView j;
    public PluginCenterTopBanner k;
    public PayAmountAdapter l;
    public PayUIKitConfig m;
    public List<y8b> n;
    public List<BannerConfigItem.BannerInfo> o;
    public IYYPayAmountView.ViewParams p;
    public long q;
    public y8b r;
    public int s;
    public IYYPayAmountView.Callback t;
    public String u;
    public int v;
    public volatile boolean w;
    public volatile boolean x;
    public int y;
    public int z;

    public final int A(int i2) {
        return i2 < 5 ? 2 : 3;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.cab
    public View getContentView() {
        return this;
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayAmountView.this.G();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements PayAmountAdapter.b {
        public b() {
        }

        @Override // tv.athena.revenue.payui.view.adapter.PayAmountAdapter.b
        public void a(View view2, int i) {
            YYPayAmountView.this.I(i);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayAmountView.this.H();
        }
    }

    /* loaded from: classes9.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (i >= 0 && i < YYPayAmountView.this.o.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayAmountView.this.o.get(i);
                boolean D = YYPayAmountView.this.D(bannerInfo);
                RLog.info("YYPayAmountView", "onItemClick: click=" + bannerInfo.jumpData + " innerHandle:" + D);
                if (!D && YYPayAmountView.this.p != null && YYPayAmountView.this.p.viewEventListener != null) {
                    YYPayAmountView.this.p.viewEventListener.onBannerClick(bannerInfo);
                }
                e9b.d(YYPayAmountView.this.y, YYPayAmountView.this.z, "19", "", "", bannerInfo.id);
                if (bannerInfo.jumpType == 5) {
                    e9b.d(YYPayAmountView.this.y, YYPayAmountView.this.z, PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, "", "", bannerInfo.id);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BannerItemSelectListener {
        public e() {
        }

        @Override // tv.athena.revenue.payui.model.BannerItemSelectListener
        public void onItemSelected(int i) {
            if (i >= 0 && i < YYPayAmountView.this.o.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayAmountView.this.o.get(i);
                RLog.debug("YYPayAmountView", "onItemSelected: item=" + bannerInfo);
                e9b.d(YYPayAmountView.this.y, YYPayAmountView.this.z, "18", "", "", bannerInfo.id);
                if (bannerInfo.jumpType == 5) {
                    e9b.d(YYPayAmountView.this.y, YYPayAmountView.this.z, PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, "", "", bannerInfo.id);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements IResult<ProductListResult> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.w = false;
            YYPayAmountView.this.B = productListResult;
            YYPayAmountView.this.F();
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.w = false;
            RLog.error("YYPayAmountView", "queryProductList onFail code:" + i + " failReason:" + str, new Object[0]);
            YYPayAmountView.this.J(1021, i, str);
            YYPayAmountView.this.E();
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnLongClickListener {
        public g() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            g9b.a(String.valueOf(YYPayAmountView.this.q), YYPayAmountView.this.a);
            Toast.makeText(YYPayAmountView.this.a, "YY号已复制到剪贴板", 1).show();
            return true;
        }
    }

    /* loaded from: classes9.dex */
    public class h implements IResult<MyBalanceResult> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            long j;
            MiddleRevenueConfig middleRevenueConfig;
            YYPayAmountView.this.x = false;
            RLog.info("YYPayAmountView", "queryMyBalance result:" + myBalanceResult);
            if (myBalanceResult == null) {
                RLog.error("YYPayAmountView", "queryMyBalance error result null", new Object[0]);
                return;
            }
            YYPayAmountView yYPayAmountView = YYPayAmountView.this;
            if (myBalanceResult.getMyBalanceInfo() != null) {
                j = myBalanceResult.getMyBalanceInfo().getImid();
            } else {
                j = 0;
            }
            yYPayAmountView.q = j;
            YYPayAmountView.this.Z();
            MyBalanceInfo.Account account = null;
            if (YYPayAmountView.this.m != null) {
                middleRevenueConfig = YYPayAmountView.this.m.revenueConfig;
            } else {
                middleRevenueConfig = null;
            }
            if (middleRevenueConfig != null) {
                account = myBalanceResult.getMyBalance(middleRevenueConfig.getCurrencyType());
            }
            if (account != null) {
                YYPayAmountView.this.C = account;
                YYPayAmountView.this.F();
                RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + account);
                return;
            }
            RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.x = false;
            RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i + " failReason:" + str, new Object[0]);
            YYPayAmountView.this.J(1005, i, str);
            YYPayAmountView.this.E();
        }
    }

    /* loaded from: classes9.dex */
    public class i implements IResult<BannerConfigResult> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            RLog.info("YYPayAmountView", "queryBannerConfig() onSuccess:" + bannerConfigResult);
            YYPayAmountView.this.o.clear();
            if (bannerConfigResult.getBannerConfigItemList() != null && bannerConfigResult.getBannerConfigItemList().size() > 0) {
                BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                list = bannerConfigItem.bannerInfoList;
                YYPayAmountView.this.s = bannerConfigItem.autoPlayTime;
            } else {
                list = null;
            }
            if (list != null && list.size() > 0) {
                YYPayAmountView.this.o.addAll(list);
                YYPayAmountView.this.S();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayAmountView", "queryBannerConfig onFail code:" + i + " failReason:" + str, new Object[0]);
        }
    }

    /* loaded from: classes9.dex */
    public class j extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ GridLayoutManager a;

        public j(GridLayoutManager gridLayoutManager) {
            this.a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            y8b k = YYPayAmountView.this.l.k(i);
            if (k != null && k.d) {
                return this.a.getSpanCount();
            }
            return 1;
        }
    }

    public YYPayAmountView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig, IYYPayAmountView.ViewParams viewParams, f7b f7bVar) {
        super(activity);
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.u = "Y币";
        this.a = activity;
        this.m = payUIKitConfig;
        this.p = viewParams;
        this.y = i2;
        this.z = i3;
        this.A = f7bVar;
        C(activity);
    }

    public final void X(PaysSettingInfo paysSettingInfo) {
        if (paysSettingInfo != null && !TextUtils.isEmpty(paysSettingInfo.payRemindMsg) && this.f != null) {
            RLog.debug("YYPayAmountView", "updatePayRemindTextView payRemindMsg:" + paysSettingInfo.payRemindMsg);
            this.f.setText(paysSettingInfo.payRemindMsg);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.cab
    public void attachWindow(Window window) {
        RLog.debug("YYPayAmountView", "attachWindow window:" + window);
        this.F = window;
        IYYPayAmountView.ViewParams viewParams = this.p;
        if (viewParams != null) {
            refreshWindow(viewParams.windowParams);
        }
        Y(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        this.t = callback;
    }

    public final void B() {
        l9b.a(this.h, this.i);
    }

    public final void E() {
        boolean z;
        if (!this.w && !this.x) {
            z = true;
        } else {
            z = false;
        }
        RLog.info("YYPayAmountView", "notifyHideLoadingView hasLoadAllData:" + z);
        if (z) {
            B();
        }
    }

    public final void F() {
        boolean z;
        E();
        if (!this.w && !this.x) {
            z = true;
        } else {
            z = false;
        }
        RLog.info("YYPayAmountView", "notifyUpdateDataView hasLoadAllData:" + z);
        if (z) {
            W();
            Q(this.B);
        }
    }

    public final void H() {
        int i2;
        ProductInfo productInfo;
        z();
        y8b y8bVar = this.r;
        if (y8bVar != null && (productInfo = y8bVar.a) != null) {
            i2 = productInfo.cid;
        } else {
            i2 = 0;
        }
        e9b.d(this.y, this.z, "2", "", "", String.valueOf(i2));
    }

    public final void K() {
        f6b yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
        if (yYPayMiddleService == null) {
            RLog.error("YYPayAmountView", "queryBannerConfig error yyPayMiddleService null", new Object[0]);
        } else {
            yYPayMiddleService.a(new int[]{1}, new i());
        }
    }

    public final void L() {
        this.x = true;
        f6b yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
        if (yYPayMiddleService == null) {
            RLog.error("YYPayAmountView", "queryMyBalance error yyPayMiddleService null", new Object[0]);
        } else {
            yYPayMiddleService.c(new h());
        }
    }

    public final void M() {
        Map<String, String> map;
        this.w = true;
        IYYPayAmountView.ViewParams viewParams = this.p;
        if (viewParams != null) {
            map = viewParams.clientInfoExpand;
        } else {
            map = null;
        }
        f6b yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
        if (yYPayMiddleService == null) {
            RLog.error("YYPayAmountView", "queryProductList erro yyPayMiddleService null", new Object[0]);
        } else {
            yYPayMiddleService.e(map, new f());
        }
    }

    public final void O() {
        List<PayWayInfo> list = this.D;
        if (list == null) {
            RLog.error("YYPayAmountView", "showInputNumberDialog mPayWayInfoList data null", new Object[0]);
            return;
        }
        IYYPayAmountView.Callback callback = this.t;
        if (callback != null) {
            callback.showInputNumberDialog(this.a, list, this.E);
        }
    }

    public final void P() {
        l9b.b(this.h, this.i);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.cab
    public void refreshView() {
        P();
        M();
        L();
        K();
    }

    public final void z() {
        y8b y8bVar = this.r;
        if (y8bVar == null) {
            RLog.error("YYPayAmountView", "confirmRecharge error mSelectedPayAmount null", new Object[0]);
            return;
        }
        List<PayWayInfo> list = this.D;
        if (list == null) {
            RLog.error("YYPayAmountView", "confirmRecharge error mPayWayInfoList null", new Object[0]);
            return;
        }
        IYYPayAmountView.Callback callback = this.t;
        if (callback != null) {
            callback.toPayWayDialog(y8bVar, list, this.E);
        }
    }

    public final void C(Activity activity) {
        LayoutInflater.from(new ContextThemeWrapper(activity, z9b.a.a(this.m))).inflate(R.layout.pay_ui_layout_pay_amount_view, (ViewGroup) this, true);
        this.d = (TextView) findViewById(R.id.tv_amount);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f092620);
        PayAmountAdapter payAmountAdapter = new PayAmountAdapter(this.a, this.A, this.n, this.m);
        this.l = payAmountAdapter;
        payAmountAdapter.p(this.u);
        this.j = (RecyclerView) findViewById(R.id.grid_recharge_amount);
        this.l.q(new b());
        TextView textView = (TextView) findViewById(R.id.btn_confirm_recharge);
        this.b = textView;
        textView.setOnClickListener(new c());
        V(this.l.l());
        PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f090320);
        this.k = pluginCenterTopBanner;
        PayUIKitConfig payUIKitConfig = this.m;
        if (payUIKitConfig != null) {
            pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
        }
        this.h = findViewById(R.id.root_loading);
        this.i = (ImageView) findViewById(R.id.iv_loading_circle);
        this.c = (TextView) findViewById(R.id.tv_hint);
        this.f = (TextView) findViewById(R.id.tvPayRemind);
        this.g = (TextView) findViewById(R.id.tv_bubble_msg);
        e9b.d(this.y, this.z, "1", "", "", "");
    }

    public final void Q(ProductListResult productListResult) {
        String str;
        boolean z;
        if (productListResult == null) {
            RLog.error("YYPayAmountView", "showProductListView error result null", new Object[0]);
        } else if (this.j != null && this.l != null) {
            this.v = productListResult.defaultCid;
            if (productListResult.getCurrencyName() != null) {
                str = productListResult.getCurrencyName();
            } else {
                str = "Y币";
            }
            this.u = str;
            this.l.p(str);
            int N = N(productListResult);
            if (N < 0) {
                RLog.error("YYPayAmountView", "showProductListView error defaultSelectIndex < 0", new Object[0]);
                return;
            }
            int i2 = 2;
            if (this.l.getCount() >= 2) {
                z = true;
            } else {
                z = false;
            }
            int A = A(this.l.getCount());
            if (z) {
                if (A != 2) {
                    i2 = 3;
                }
                y8b y8bVar = new y8b(null, 0);
                y8bVar.d = true;
                this.n.add(i2, y8bVar);
                if (N >= i2) {
                    N++;
                }
            } else {
                i2 = 0;
            }
            RLog.info("YYPayAmountView", "showProductListView mDefaultCid:" + this.v + " spanCount:" + A + " campaignItemPosition:" + i2 + " shouldAddCampaignItem:" + z + " defaultSelectIndex：" + N);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a, A);
            gridLayoutManager.setSpanSizeLookup(new j(gridLayoutManager));
            this.j.setLayoutManager(gridLayoutManager);
            this.j.setAdapter(this.l);
            this.j.addItemDecoration(new PayAmountGridItemDecoration(A, j9b.a(10.0f), j9b.a(10.0f), i2, gridLayoutManager));
            this.l.s(A);
            this.l.o(i2);
            this.l.r(N);
            this.l.notifyDataSetChanged();
            this.r = this.n.get(N);
            this.D = productListResult.getPayWayInfoList();
            this.E = productListResult.getBubbleActMsg();
            T();
            U(false);
            V(this.l.l());
            X(productListResult.getPaysSettingInfo());
            z8b.h(productListResult.getPaysSettingInfo(), "YYPayAmountView");
            Y("showProductListView");
        }
    }

    public final boolean D(BannerConfigItem.BannerInfo bannerInfo) {
        if (bannerInfo == null || bannerInfo.jumpType != 5) {
            return false;
        }
        if (!TextUtils.isEmpty(bannerInfo.jumpData)) {
            IYYPayAmountView.Callback callback = this.t;
            if (callback != null) {
                callback.toBannerConfigWebPage(bannerInfo.jumpData);
                return true;
            }
            return true;
        }
        RLog.error("YYPayAmountView", "innerHandleBannerClick error bannerInfo:" + bannerInfo, new Object[0]);
        return true;
    }

    public final void U(boolean z) {
        y8b y8bVar;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        if (!z && (y8bVar = this.r) != null && (productInfo = y8bVar.a) != null && (list = productInfo.giftbags) != null && list.size() > 0) {
            this.A.d(this.r.a.giftbags.get(0));
            PayAmountAdapter payAmountAdapter = this.l;
            payAmountAdapter.u(payAmountAdapter.m());
            return;
        }
        this.A.d(null);
        this.l.u(-1);
    }

    public final void V(y8b y8bVar) {
        if (this.b == null) {
            RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
        } else if (y8bVar == null) {
            RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
        } else {
            this.b.setText("立即充值" + y9b.a(y8bVar.c()) + "元");
        }
    }

    public final void G() {
        IYYPayAmountView.ViewParams viewParams = this.p;
        if (viewParams == null) {
            RLog.error("YYPayAmountView", "onBtnLeftClick error mViewParams null", new Object[0]);
            return;
        }
        boolean z = viewParams.showFaqPage;
        if (z) {
            IYYPayAmountView.Callback callback = this.t;
            if (callback != null) {
                callback.toHelpCenterPage();
            }
        } else {
            r8b.d(this.y, this.z);
        }
        e9b.d(this.y, this.z, "25", "", "", "");
        RLog.info("YYPayAmountView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.t);
    }

    public final void S() {
        RLog.debug("YYPayAmountView", "updateBanner: count=" + this.o.size());
        if (this.o.size() == 0) {
            this.k.setVisibility(8);
            return;
        }
        int i2 = this.s;
        if (i2 > 0) {
            this.k.setFlipInterval(i2);
        }
        this.k.setData(this.o);
        this.k.setOnItemClickListener(new d());
        this.k.setBannerItemSelectListener(new e());
        this.k.setVisibility(0);
    }

    public final void T() {
        RLog.info("YYPayAmountView", "updateBubbleMsgView mBubbleActMsg:" + this.E + " mTvBubbleMsg:" + this.g);
        TextView textView = this.g;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
        if (!TextUtils.isEmpty(this.E)) {
            this.g.setVisibility(0);
            this.g.setText(this.E);
            return;
        }
        this.g.setVisibility(8);
    }

    public final void I(int i2) {
        ProductInfo productInfo;
        y8b k = this.l.k(i2);
        int i3 = 0;
        if (k == null) {
            RLog.error("YYPayAmountView", "onPayAmountItemClick error payAmount null", new Object[0]);
        } else if (k.c) {
            O();
            U(true);
        } else {
            this.r = k;
            this.l.r(i2);
            this.l.notifyDataSetChanged();
            V(k);
            U(false);
            y8b y8bVar = this.r;
            if (y8bVar != null && (productInfo = y8bVar.a) != null) {
                i3 = productInfo.cid;
            }
            e9b.d(this.y, this.z, "3", "", "", String.valueOf(i3));
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.cab
    public void refreshWindow(WindowParams windowParams) {
        RLog.debug("YYPayAmountView", "refreshWindow params:" + windowParams + " mWindow:" + this.F);
        if (this.F != null && windowParams != null) {
            IYYPayAmountView.ViewParams viewParams = this.p;
            if (viewParams != null) {
                viewParams.windowParams = windowParams;
            }
            WindowManager.LayoutParams attributes = this.F.getAttributes();
            attributes.dimAmount = windowParams.dimAmount;
            try {
                this.F.setAttributes(attributes);
            } catch (Exception e2) {
                RLog.error("YYPayAmountView", "refreshWindow e:" + e2, new Object[0]);
            }
        }
    }

    public final void J(int i2, int i3, String str) {
        StringBuilder sb;
        if (bab.a.a(this.a) && i3 != -800) {
            if (i3 == -500) {
                sb = new StringBuilder();
                sb.append("网络不给力,请稍后重试(");
                sb.append(i2);
                sb.append("a)");
            } else {
                sb = new StringBuilder();
                sb.append("请求服务失败(");
                sb.append(i2);
                sb.append("a) code:");
                sb.append(i3);
                sb.append(" failReason:");
                sb.append(str);
            }
            Toast.makeText(this.a, sb.toString(), 1).show();
        }
        IYYPayAmountView.Callback callback = this.t;
        if (callback != null) {
            callback.onRefreshViewFail(i3, str);
        }
    }

    public final int N(ProductListResult productListResult) {
        List<ProductInfo> productInfoList = productListResult.getProductInfoList();
        int i2 = 0;
        if (productInfoList != null && productInfoList.size() != 0) {
            this.n.clear();
            int i3 = 0;
            for (int i4 = 0; i4 < productInfoList.size(); i4++) {
                y8b y8bVar = new y8b(productInfoList.get(i4), productListResult.getCurrencyType());
                if (productInfoList.get(i4).cid == this.v) {
                    i3 = i4;
                }
                this.n.add(y8bVar);
            }
            if (!R()) {
                i2 = i3;
            }
            if (this.n.size() < 6) {
                this.n.add(new y8b(true));
            }
            return i2;
        }
        RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
        return -1;
    }

    public final boolean R() {
        boolean z;
        List<y8b> list = this.n;
        if (list != null && !list.isEmpty()) {
            IYYPayAmountView.ViewParams viewParams = this.p;
            if (viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_TARGET_PAY) {
                z = true;
            } else {
                z = false;
            }
            RLog.info("YYPayAmountView", "tryModifyTargetAmount modifyTargetAmount:" + z);
            if (z) {
                if (this.C != null) {
                    RLog.info("YYPayAmountView", "tryModifyTargetAmount targetAmount:" + this.p.targetAmount + " amount:" + this.C.amount);
                    int i2 = this.p.targetAmount;
                    long j2 = this.C.amount;
                    if (i2 > j2) {
                        y8b c2 = n9b.c(this.n, this.m, i2, j2);
                        RLog.error("YYPayAmountView", "tryModifyTargetAmount payAmount:" + c2, new Object[0]);
                        if (c2 == null) {
                            return false;
                        }
                        return true;
                    }
                    RLog.error("YYPayAmountView", "tryModifyTargetAmount but targetAmount <= mMyBalanceAccount.amount", new Object[0]);
                } else {
                    RLog.error("YYPayAmountView", "tryModifyTargetAmount error mMyBalanceAccount null", new Object[0]);
                }
            }
            return false;
        }
        RLog.error("YYPayAmountView", "tryModifyTargetAmount error mNormalPayAmountList null", new Object[0]);
        return false;
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public final void W() {
        Activity activity;
        if (this.C == null) {
            RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
        } else if (this.d != null && (activity = this.a) != null && !activity.isFinishing()) {
            String str = null;
            MyBalanceInfo.Account account = this.C;
            int i2 = account.currencyType;
            String a2 = y9b.a(account.amount / 100.0d);
            IYYPayAmountView.ViewParams viewParams = this.p;
            if (viewParams != null) {
                int i3 = viewParams.targetAmount;
                long j2 = this.C.amount;
                if (i3 > j2) {
                    str = y9b.a((i3 - j2) / 100.0d);
                }
            }
            this.d.setVisibility(0);
            if (str != null) {
                if (i2 == 4) {
                    this.d.setText(String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_not_enough), a2, str));
                } else {
                    this.d.setText(String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_not_enough_other), a2, str));
                }
            } else if (i2 == 4) {
                this.d.setText(String.format(this.a.getString(R.string.pay_ui_str_wallet_amount), a2));
            } else {
                this.d.setText(String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_other), a2));
            }
        } else {
            RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
        }
    }

    public final void Y(String str) {
        IFeedbackServiceProxy iFeedbackServiceProxy;
        if (this.F != null && z8b.d() != null) {
            View findViewById = this.F.findViewById(R.id.btn_left);
            int i2 = 0;
            if (findViewById == null) {
                RLog.error("YYPayAmountView", "updateTopLeftBtn error btnLeft null", new Object[0]);
                return;
            }
            findViewById.setOnClickListener(new a());
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.y, this.z);
            if (uIKit != null) {
                iFeedbackServiceProxy = uIKit.getFeedbackServiceProxy();
            } else {
                iFeedbackServiceProxy = null;
            }
            boolean z = true;
            z = (z8b.d().feedbackSwitch != 1 || iFeedbackServiceProxy == null) ? false : false;
            if (!z) {
                i2 = 8;
            }
            findViewById.setVisibility(i2);
            if (z) {
                e9b.d(this.y, this.z, "24", "", "", "");
            }
            RLog.info("YYPayAmountView", "updateTopLeftBtn from:" + str + " proxy:" + iFeedbackServiceProxy + " feedbackSwitch:" + z8b.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
            return;
        }
        RLog.warn("YYPayAmountView", "updateTopLeftBtn from:" + str + " mWindow:" + this.F + " paysSettingInfo:" + z8b.d());
    }

    public final void Z() {
        TextView textView = this.e;
        if (textView != null && this.q != 0) {
            textView.setVisibility(0);
            this.e.setText(String.format(this.a.getString(R.string.pay_ui_yy_number), Long.valueOf(this.q)));
            this.e.setOnLongClickListener(new g());
        }
    }
}
