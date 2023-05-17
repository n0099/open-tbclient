package tv.athena.revenue.payui.view.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.tieba.R;
import com.baidu.tieba.dfb;
import com.baidu.tieba.ffb;
import com.baidu.tieba.ggb;
import com.baidu.tieba.hfb;
import com.baidu.tieba.igb;
import com.baidu.tieba.jdb;
import com.baidu.tieba.jgb;
import com.baidu.tieba.kcb;
import com.baidu.tieba.kfb;
import com.baidu.tieba.lgb;
import com.baidu.tieba.mfb;
import com.baidu.tieba.nfb;
import com.baidu.tieba.ofb;
import com.baidu.tieba.rfb;
import com.baidu.tieba.tfb;
import com.baidu.tieba.ufb;
import com.baidu.tieba.vfb;
import com.baidu.tieba.vgb;
import com.baidu.tieba.web;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PackageInstallUtil;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PayViewState;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PayAmountAdapter;
import tv.athena.revenue.payui.view.adapter.PayAmountGridItemDecoration;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes2.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {
    public jdb A;
    public ProductListResult B;
    public MyBalanceInfo.Account C;
    public List<PayWayInfo> D;
    public String E;
    public Window F;
    public ViewFlipper G;
    public View H;
    public PayFlowType I;
    public GridView J;
    public TextView K;
    public View L;
    public List<hfb> M;
    public vgb N;
    public hfb O;
    public String P;
    public Handler Q;
    public Runnable R;
    public Runnable S;
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
    public List<dfb> n;
    public List<BannerConfigItem.BannerInfo> o;
    public IYYPayAmountView.ViewParams p;
    public long q;
    public dfb r;
    public int s;
    public IYYPayAmountView.Callback t;
    public String u;
    public int v;
    public volatile boolean w;
    public volatile boolean x;
    public int y;
    public int z;

    public final int K(int i2) {
        return i2 < 5 ? 2 : 3;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.ogb
    public View getContentView() {
        return this;
    }

    /* loaded from: classes2.dex */
    public class a implements BannerItemSelectListener {
        public a() {
        }

        @Override // tv.athena.revenue.payui.model.BannerItemSelectListener
        public void onItemSelected(int i) {
            if (i >= 0 && i < YYPayAmountView.this.o.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayAmountView.this.o.get(i);
                RLog.debug("YYPayAmountView", "onItemSelected: item=" + bannerInfo);
                nfb.b(YYPayAmountView.this.y, YYPayAmountView.this.z, "18", "", "", bannerInfo.id);
                if (bannerInfo.jumpType == 5) {
                    nfb.b(YYPayAmountView.this.y, YYPayAmountView.this.z, PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, "", "", bannerInfo.id);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("id", bannerInfo.id);
                kfb.b(YYPayAmountView.this.y, YYPayAmountView.this.z, YYPayAmountView.this.I, 100, hashMap);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IResult<ProductListResult> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.w = false;
            YYPayAmountView.this.B = productListResult;
            YYPayAmountView.this.W();
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.w = false;
            RLog.error("YYPayAmountView", "queryProductList onFail code:" + i + " failReason:" + str, new Object[0]);
            YYPayAmountView.this.c0(1021, i, str);
            YYPayAmountView.this.V();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            ofb.a(String.valueOf(YYPayAmountView.this.q), YYPayAmountView.this.a);
            Toast.makeText(YYPayAmountView.this.a, "YY号已复制到剪贴板", 1).show();
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements IResult<MyBalanceResult> {
        public d() {
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
            YYPayAmountView.this.y0();
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
                YYPayAmountView.this.W();
                RLog.info("YYPayAmountView", "queryMyBalance result yCoinsAccount:" + account);
                return;
            }
            RLog.error("YYPayAmountView", "queryMyBalance() error yCoinsAccount null", new Object[0]);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            YYPayAmountView.this.x = false;
            RLog.error("YYPayAmountView", "queryMyBalance onFail code:" + i + " failReason:" + str, new Object[0]);
            YYPayAmountView.this.c0(1005, i, str);
            YYPayAmountView.this.V();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements IResult<BannerConfigResult> {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            RLog.info("YYPayAmountView", "queryBannerConfig() onSuccess:" + bannerConfigResult + " bannerType:" + this.a);
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
                YYPayAmountView.this.r0();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayAmountView", "queryBannerConfig onFail code:" + i + " failReason:" + str + " bannerType:" + this.a, new Object[0]);
        }
    }

    /* loaded from: classes2.dex */
    public class f extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ GridLayoutManager a;

        public f(GridLayoutManager gridLayoutManager) {
            this.a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            dfb k = YYPayAmountView.this.l.k(i);
            if (k != null && k.d) {
                return this.a.getSpanCount();
            }
            return 1;
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayAmountView.this.Y();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            YYPayAmountView.this.q0(-1, false);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (YYPayAmountView.this.G != null) {
                YYPayAmountView.this.G.showNext();
                YYPayAmountView.this.G.startFlipping();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayAmountView.this.Z();
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayAmountView.this.d0();
        }
    }

    /* loaded from: classes2.dex */
    public class l implements PayAmountAdapter.d {
        public l() {
        }

        @Override // tv.athena.revenue.payui.view.adapter.PayAmountAdapter.d
        public void a(View view2, int i) {
            YYPayAmountView.this.a0(i);
        }
    }

    /* loaded from: classes2.dex */
    public class m implements PayAmountAdapter.c {
        public m() {
        }

        @Override // tv.athena.revenue.payui.view.adapter.PayAmountAdapter.c
        public void a() {
            YYPayAmountView.this.q0(-1, false);
        }
    }

    /* loaded from: classes2.dex */
    public class n implements AdapterView.OnItemClickListener {
        public n() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            YYPayAmountView.this.b0(i);
        }
    }

    /* loaded from: classes2.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            YYPayAmountView.this.G();
            if (YYPayAmountView.this.I == PayFlowType.WALLET_PAY_FLOW) {
                str = "2";
            } else {
                str = "1";
            }
            nfb.b(YYPayAmountView.this.y, YYPayAmountView.this.z, PayUVEventType.PAY_AMOUNT_MORE_PAY_WAY_CLICK, "", "", str);
            kfb.a(YYPayAmountView.this.y, YYPayAmountView.this.z, YYPayAmountView.this.I, 107);
        }
    }

    /* loaded from: classes2.dex */
    public class p implements AdapterView.OnItemClickListener {
        public p() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (i >= 0 && i < YYPayAmountView.this.o.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayAmountView.this.o.get(i);
                boolean S = YYPayAmountView.this.S(bannerInfo);
                RLog.info("YYPayAmountView", "onItemClick: click=" + bannerInfo.jumpData + " innerHandle:" + S);
                if (!S && YYPayAmountView.this.p != null && YYPayAmountView.this.p.viewEventListener != null) {
                    YYPayAmountView.this.p.viewEventListener.onBannerClick(bannerInfo);
                }
                nfb.b(YYPayAmountView.this.y, YYPayAmountView.this.z, "19", "", "", bannerInfo.id);
                if (bannerInfo.jumpType == 5) {
                    nfb.b(YYPayAmountView.this.y, YYPayAmountView.this.z, PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, "", "", bannerInfo.id);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("id", bannerInfo.id);
                kfb.b(YYPayAmountView.this.y, YYPayAmountView.this.z, YYPayAmountView.this.I, 105, hashMap);
            }
        }
    }

    public YYPayAmountView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig, IYYPayAmountView.ViewParams viewParams, jdb jdbVar) {
        super(activity);
        PayFlowType payFlowType;
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.u = "Y币";
        this.M = new ArrayList();
        this.P = "";
        this.Q = new Handler(Looper.getMainLooper());
        this.R = new h();
        this.S = new i();
        this.a = activity;
        this.m = payUIKitConfig;
        this.p = viewParams;
        this.y = i2;
        this.z = i3;
        this.A = jdbVar;
        if (viewParams != null) {
            payFlowType = viewParams.payFlowType;
        } else {
            payFlowType = null;
        }
        this.I = payFlowType;
        R(activity);
    }

    public final List<PayWayInfo> H(List<PayWayInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size() && i2 < 2; i3++) {
                if (list.get(i3).showInAmountView) {
                    arrayList.add(list.get(i3));
                    i2++;
                }
            }
        }
        return arrayList;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.ogb
    public void attachWindow(Window window) {
        RLog.debug("YYPayAmountView", "attachWindow window:" + window);
        this.F = window;
        IYYPayAmountView.ViewParams viewParams = this.p;
        if (viewParams != null) {
            refreshWindow(viewParams.windowParams);
        }
        x0(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
        w0();
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        this.t = callback;
    }

    public final void F() {
        dfb dfbVar;
        if (this.O.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.a)) {
            Toast.makeText(this.a, "未安装微信", 1).show();
        } else if (this.O.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.a)) {
            Toast.makeText(this.a, "未安装QQ", 1).show();
        } else if (T(this.O.a)) {
            Activity activity = this.a;
            Toast.makeText(activity, activity.getString(R.string.pay_ui_pay_too_frequency_msg), 1).show();
            RLog.warn("YYPayAmountView", "pay too frequency return mPayWay:" + this.O);
        } else if (this.t != null && (dfbVar = this.r) != null && dfbVar.a != null) {
            if (U(this.O, dfbVar)) {
                this.t.onStartSignPay(this.O, this.r, this.p.appCustomExpand, this.D, this.E);
            } else {
                this.t.onStartPay(this.O, this.r, this.p.appCustomExpand, this.D, this.E);
            }
            mfb.c(this.y, this.z, PayUIEventType.paypagepaybt, String.valueOf(this.r.a.srcAmount));
            RLog.warn("YYPayAmountView", "paypagepaybt amount:" + this.r.a.srcAmount);
        } else {
            RLog.error("YYPayAmountView", "mCallback or mPayAmount or productInfo null", new Object[0]);
        }
    }

    public final void G() {
        dfb dfbVar = this.r;
        if (dfbVar == null) {
            RLog.error("YYPayAmountView", "confirmToPayWayDialog error mSelectedPayAmount null", new Object[0]);
            return;
        }
        List<PayWayInfo> list = this.D;
        if (list == null) {
            RLog.error("YYPayAmountView", "confirmToPayWayDialog error mPayWayInfoList null", new Object[0]);
            return;
        }
        IYYPayAmountView.Callback callback = this.t;
        if (callback != null) {
            callback.toPayWayDialog(dfbVar, list, this.E);
        }
    }

    public final void I() {
        this.Q.removeCallbacks(this.S);
    }

    public final void J() {
        this.Q.removeCallbacks(this.R);
    }

    public final void O() {
        tfb.a(this.h, this.i);
    }

    public final void V() {
        boolean z;
        if (!this.w && !this.x) {
            z = true;
        } else {
            z = false;
        }
        RLog.info("YYPayAmountView", "notifyHideLoadingView hasLoadAllData:" + z);
        if (z) {
            O();
        }
    }

    public final void e0() {
        int i2;
        kcb yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
        if (yYPayMiddleService == null) {
            RLog.error("YYPayAmountView", "queryBannerConfig error yyPayMiddleService null", new Object[0]);
            return;
        }
        if (this.I == PayFlowType.WALLET_PAY_FLOW) {
            i2 = 3;
        } else {
            i2 = 1;
        }
        yYPayMiddleService.a(new int[]{i2}, new e(i2));
    }

    public final void f0() {
        this.x = true;
        kcb yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
        if (yYPayMiddleService == null) {
            RLog.error("YYPayAmountView", "queryMyBalance error yyPayMiddleService null", new Object[0]);
        } else {
            yYPayMiddleService.d(new d());
        }
    }

    public final void g0() {
        Map<String, String> map;
        this.w = true;
        IYYPayAmountView.ViewParams viewParams = this.p;
        if (viewParams != null) {
            map = viewParams.clientInfoExpand;
        } else {
            map = null;
        }
        kcb yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.y, this.z);
        if (yYPayMiddleService == null) {
            RLog.error("YYPayAmountView", "queryProductList erro yyPayMiddleService null", new Object[0]);
        } else {
            yYPayMiddleService.b(this.I, map, new b());
        }
    }

    public final void j0() {
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

    public final void k0() {
        tfb.b(this.h, this.i);
    }

    public final void n0() {
        I();
        this.Q.postDelayed(this.S, 3000L);
    }

    public final void o0() {
        J();
        this.Q.postDelayed(this.R, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.ogb
    public void refreshView() {
        k0();
        g0();
        f0();
        e0();
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void release() {
        RLog.info("YYPayAmountView", "release");
        J();
        I();
        ViewFlipper viewFlipper = this.G;
        if (viewFlipper != null) {
            viewFlipper.stopFlipping();
        }
    }

    public String L(String str) {
        double c2 = igb.c(str);
        if (c2 >= 10000.0d) {
            return String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_ten_thousand), igb.a(new BigDecimal(c2 / 10000.0d).setScale(2, 3).doubleValue()));
        }
        return String.format(this.a.getString(R.string.pay_ui_str_wallet_amount), str);
    }

    public String M(String str) {
        double c2 = igb.c(str);
        if (c2 >= 10000.0d) {
            return String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_gap_ten_thousand), igb.a(new BigDecimal(c2 / 10000.0d).setScale(2, 3).doubleValue()));
        }
        return String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_gap), str);
    }

    public final void N(int i2) {
        double d2;
        dfb dfbVar = this.r;
        if (dfbVar != null) {
            d2 = dfbVar.a();
        } else {
            d2 = 0.0d;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("payChannel", this.O.a.getChannel());
        hashMap.put("payMethod", this.O.a.getMethod());
        hashMap.put("charge_id", String.valueOf(i2));
        hashMap.put(PayUiEventContent.AMOUNT, String.valueOf(d2));
        kfb.b(this.y, this.z, this.I, 110, hashMap);
    }

    public final void Q(Activity activity) {
        this.N = new vgb(activity, this.m, this.M);
        this.K = (TextView) findViewById(R.id.tv_more_payway);
        GridView gridView = (GridView) findViewById(R.id.grid_recharge_way);
        this.J = gridView;
        gridView.setSelector(R.drawable.pay_ui_selector_transparent);
        this.J.setAdapter((ListAdapter) this.N);
        this.J.setOnItemClickListener(new n());
        kfb.a(this.y, this.z, this.I, 104);
        this.K.setOnClickListener(new o());
        View findViewById = findViewById(R.id.ll_pay_way);
        this.L = findViewById;
        findViewById.setVisibility(8);
    }

    public final void a0(int i2) {
        String str;
        ProductInfo productInfo;
        dfb k2 = this.l.k(i2);
        int i3 = 0;
        if (k2 == null) {
            RLog.error("YYPayAmountView", "onPayAmountItemClick error payAmount null", new Object[0]);
        } else if (k2.c) {
            j0();
            t0(true, false);
        } else {
            this.r = k2;
            this.l.s(i2);
            this.l.notifyDataSetChanged();
            u0(k2);
            t0(false, false);
            dfb dfbVar = this.r;
            if (dfbVar != null && (productInfo = dfbVar.a) != null) {
                i3 = productInfo.cid;
            }
            if (this.I == PayFlowType.WALLET_PAY_FLOW) {
                str = "10";
            } else {
                str = "3";
            }
            nfb.b(this.y, this.z, str, "", "", String.valueOf(i3));
        }
    }

    public final void l0(ProductListResult productListResult) {
        List<PayWayInfo> list;
        if (productListResult != null) {
            list = productListResult.getPayWayInfoList();
        } else {
            list = null;
        }
        List<PayWayInfo> H = H(list);
        if (H.isEmpty()) {
            this.L.setVisibility(8);
            return;
        }
        this.L.setVisibility(0);
        this.M.clear();
        this.M.addAll(ggb.a(H));
        if (this.M.size() > 0) {
            this.O = this.M.get(0);
            this.N.c(0);
        }
        this.N.notifyDataSetChanged();
        X();
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.ogb
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

    public final void P(Activity activity) {
        PayAmountAdapter payAmountAdapter = new PayAmountAdapter(this.a, this.A, this.n, this.m);
        this.l = payAmountAdapter;
        payAmountAdapter.p(this.u);
        this.j = (RecyclerView) findViewById(R.id.grid_recharge_amount);
        this.l.r(new l());
        this.l.q(new m());
    }

    public final boolean S(BannerConfigItem.BannerInfo bannerInfo) {
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

    public final boolean T(PayType payType) {
        if (payType != PayType.ALI_PAY) {
            return false;
        }
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.y, this.z);
        if (uIKit == null) {
            RLog.error("YYPayAmountView", "isPayFrequency error yyPayUIKit null", new Object[0]);
            return false;
        }
        boolean isPayFrequency = uIKit.isPayFrequency();
        RLog.info("YYPayAmountView", "isPayFrequency:" + isPayFrequency);
        return isPayFrequency;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, com.baidu.tieba.ngb
    public void setViewState(PayViewState payViewState) {
        if (payViewState == PayViewState.WAITING_VIEW_STATE) {
            RLog.debug("YYPayAmountView", "setViewState waiting");
            TextView textView = this.b;
            if (textView == null) {
                return;
            }
            this.P = textView.getText().toString();
            this.b.setText("等待支付结果...");
            this.b.setClickable(false);
        } else if (payViewState == PayViewState.SELECTING_VIEW_STATE) {
            RLog.debug("YYPayAmountView", "setViewState selecting");
            TextView textView2 = this.b;
            if (textView2 == null) {
                return;
            }
            textView2.setText(this.P);
            this.b.setClickable(true);
        }
    }

    public final void u0(dfb dfbVar) {
        if (this.b == null) {
            RLog.error("YYPayAmountView", "updateConfirmButton null mBtnConfirmRecharge", new Object[0]);
        } else if (dfbVar == null) {
            RLog.info("YYPayAmountView", "updateConfirmButton null payAmount");
        } else {
            this.b.setText("立即充值" + igb.a(dfbVar.c()) + "元");
        }
    }

    public final void R(Activity activity) {
        String str;
        LayoutInflater.from(new ContextThemeWrapper(activity, jgb.a.a(this.m))).inflate(R.layout.pay_ui_layout_pay_amount_view, (ViewGroup) this, true);
        this.d = (TextView) findViewById(R.id.tv_amount);
        this.e = (TextView) findViewById(R.id.tv_amount_gap);
        this.G = (ViewFlipper) findViewById(R.id.view_flipper__amount);
        this.H = findViewById(R.id.dv_middle);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0926a5);
        P(activity);
        TextView textView = (TextView) findViewById(R.id.btn_confirm_recharge);
        this.b = textView;
        textView.setOnClickListener(new j());
        u0(this.l.l());
        PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f09032e);
        this.k = pluginCenterTopBanner;
        PayUIKitConfig payUIKitConfig = this.m;
        if (payUIKitConfig != null) {
            pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
        }
        this.h = findViewById(R.id.root_loading);
        this.i = (ImageView) findViewById(R.id.iv_loading_circle);
        TextView textView2 = (TextView) findViewById(R.id.tv_use_item);
        this.c = textView2;
        textView2.setOnClickListener(new k());
        this.g = (TextView) findViewById(R.id.tv_bubble_msg);
        Q(activity);
        if (this.I == PayFlowType.WALLET_PAY_FLOW) {
            str = "8";
        } else {
            str = "1";
        }
        nfb.b(this.y, this.z, str, "", "", "");
    }

    public final void m0(ProductListResult productListResult) {
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
            int h0 = h0(productListResult);
            if (h0 < 0) {
                RLog.error("YYPayAmountView", "showProductListView error defaultSelectIndex < 0", new Object[0]);
                return;
            }
            int i2 = 2;
            if (this.l.getCount() >= 2) {
                z = true;
            } else {
                z = false;
            }
            int K = K(this.l.getCount());
            if (z) {
                if (K != 2) {
                    i2 = 3;
                }
                dfb dfbVar = new dfb(null, 0);
                dfbVar.d = true;
                this.n.add(i2, dfbVar);
                if (h0 >= i2) {
                    h0++;
                }
            } else {
                i2 = 0;
            }
            RLog.info("YYPayAmountView", "showProductListView mDefaultCid:" + this.v + " spanCount:" + K + " campaignItemPosition:" + i2 + " shouldAddCampaignItem:" + z + " defaultSelectIndex：" + h0);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a, K);
            gridLayoutManager.setSpanSizeLookup(new f(gridLayoutManager));
            this.j.setLayoutManager(gridLayoutManager);
            this.j.setAdapter(this.l);
            this.j.addItemDecoration(new PayAmountGridItemDecoration(K, rfb.a(10.0f), rfb.a(10.0f), i2, gridLayoutManager));
            this.l.t(K);
            this.l.o(i2);
            this.l.s(h0);
            this.l.notifyDataSetChanged();
            this.r = this.n.get(h0);
            this.D = productListResult.getPayWayInfoList();
            this.E = productListResult.getBubbleActMsg();
            s0();
            t0(false, true);
            u0(this.l.l());
            ffb.i(productListResult.getPaysSettingInfo(), "YYPayAmountView");
            x0("showProductListView");
        }
    }

    public final boolean U(hfb hfbVar, dfb dfbVar) {
        boolean z;
        if (dfbVar.c() <= hfbVar.f && hfbVar.a == PayType.ALI_PAY && dfbVar.c() > 0.0d) {
            z = true;
        } else {
            z = false;
        }
        RLog.info("YYPayAmountView", "isSupportSignPay result=" + z + ", perFreePassAmount=" + hfbVar.f + ", payType=" + hfbVar.a);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q0(int i2, boolean z) {
        int i3;
        int i4;
        boolean z2;
        int size = this.n.size();
        if (size != 0 && i2 <= size) {
            int i5 = size / 2;
            if (i2 < 0) {
                i3 = size - 1;
            } else if (i2 >= 3) {
                i3 = size - 1;
                for (i4 = 0; i4 < this.n.size(); i4++) {
                    if (i4 >= i5 && i4 <= i3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.n.get(i4).f(z2);
                }
                this.l.x(z);
                this.l.notifyDataSetChanged();
                return;
            } else {
                i3 = i5 - 1;
            }
            i5 = 0;
            while (i4 < this.n.size()) {
            }
            this.l.x(z);
            this.l.notifyDataSetChanged();
            return;
        }
        RLog.info("YYPayAmountView", "updateAmountItemViewVisibleState ignore size:" + size + " campaignSelectIndex:" + i2);
    }

    public final void t0(boolean z, boolean z2) {
        dfb dfbVar;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        if (z2) {
            o0();
        } else {
            J();
        }
        if (!z && (dfbVar = this.r) != null && (productInfo = dfbVar.a) != null && (list = productInfo.giftbags) != null && list.size() > 0) {
            this.A.d(this.r.a.giftbags.get(0));
            PayAmountAdapter payAmountAdapter = this.l;
            payAmountAdapter.y(payAmountAdapter.m());
            q0(this.l.m(), true);
            return;
        }
        this.A.d(null);
        this.l.y(-1);
        q0(-1, false);
    }

    public final void W() {
        boolean z;
        V();
        if (!this.w && !this.x) {
            z = true;
        } else {
            z = false;
        }
        RLog.info("YYPayAmountView", "notifyUpdateDataView hasLoadAllData:" + z);
        if (z) {
            v0();
            m0(this.B);
            l0(this.B);
        }
    }

    public final void X() {
        for (hfb hfbVar : this.M) {
            PayType payType = hfbVar.a;
            if (payType == PayType.ALI_PAY) {
                kfb.a(this.y, this.z, this.I, 102);
            } else if (payType == PayType.WECHAT_PAY) {
                kfb.a(this.y, this.z, this.I, 103);
            }
        }
    }

    public final void Z() {
        int i2;
        String str;
        ProductInfo productInfo;
        if (this.O == null) {
            G();
        } else {
            F();
        }
        dfb dfbVar = this.r;
        if (dfbVar != null && (productInfo = dfbVar.a) != null) {
            i2 = productInfo.cid;
        } else {
            i2 = 0;
        }
        if (this.I == PayFlowType.WALLET_PAY_FLOW) {
            str = "9";
        } else {
            str = "2";
        }
        nfb.b(this.y, this.z, str, "", "", String.valueOf(i2));
    }

    public final void w0() {
        Window window = this.F;
        int i2 = 0;
        if (window == null) {
            RLog.error("YYPayAmountView", "updateTopCloseBtn error mWindow null", new Object[0]);
        } else if (this.p == null) {
            RLog.error("YYPayAmountView", "updateTopCloseBtn error mViewParams null", new Object[0]);
        } else {
            View findViewById = window.findViewById(R.id.obfuscated_res_0x7f0904a6);
            if (findViewById == null) {
                RLog.error("YYPayAmountView", "updateTopCloseBtn error btnClose null", new Object[0]);
                return;
            }
            if (!this.p.showAmountViewCloseBtn) {
                i2 = 8;
            }
            findViewById.setVisibility(i2);
        }
    }

    public final void y0() {
        TextView textView = this.f;
        if (textView != null && this.q != 0) {
            textView.setVisibility(0);
            this.f.setText(String.format(this.a.getString(R.string.pay_ui_yy_number), Long.valueOf(this.q)));
            this.f.setOnLongClickListener(new c());
        }
    }

    public final void Y() {
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
            web.d(this.y, this.z);
        }
        nfb.b(this.y, this.z, "25", "", "", "");
        RLog.info("YYPayAmountView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.t);
    }

    public final void i0() {
        String str;
        ProductInfo productInfo;
        int i2 = 0;
        if (this.O == null) {
            RLog.error("YYPayAmountView", "reportPayWayItemClick error mPayWay null", new Object[0]);
            return;
        }
        if (this.I == PayFlowType.WALLET_PAY_FLOW) {
            str = PayUVEventType.PAY_AMOUNT_FULL_PAGE_CHANNEL_CLICK;
        } else {
            str = PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK;
        }
        String str2 = str;
        RLog.info("YYPayAmountView", "reportPayWayItemClick event:" + str2);
        dfb dfbVar = this.r;
        if (dfbVar != null && (productInfo = dfbVar.a) != null) {
            i2 = productInfo.cid;
        }
        nfb.b(this.y, this.z, str2, this.O.a.getChannel(), this.O.a.getMethod(), String.valueOf(i2));
        N(i2);
    }

    public final void r0() {
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
        this.k.setOnItemClickListener(new p());
        this.k.setBannerItemSelectListener(new a());
        this.k.setVisibility(0);
    }

    public final void s0() {
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

    public final void b0(int i2) {
        this.O = this.N.getItem(i2);
        if (this.N.b() != i2) {
            this.N.c(i2);
            this.N.notifyDataSetChanged();
        }
        i0();
        RLog.info("YYPayAmountView", "choose paychannel:" + this.O.a.getChannel() + " paymethod:" + this.O.a.getMethod());
        if (this.O.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.a)) {
            Toast.makeText(this.a, "未安装微信", 1).show();
        } else if (this.O.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.a)) {
            Toast.makeText(this.a, "未安装QQ", 1).show();
        }
    }

    public final int h0(ProductListResult productListResult) {
        List<ProductInfo> productInfoList = productListResult.getProductInfoList();
        int i2 = 0;
        if (productInfoList != null && productInfoList.size() != 0) {
            this.n.clear();
            int i3 = 0;
            for (int i4 = 0; i4 < productInfoList.size(); i4++) {
                dfb dfbVar = new dfb(productInfoList.get(i4), productListResult.getCurrencyType());
                if (productInfoList.get(i4).cid == this.v) {
                    i3 = i4;
                }
                this.n.add(dfbVar);
            }
            if (!p0()) {
                i2 = i3;
            }
            if (this.n.size() < 6) {
                this.n.add(new dfb(true));
            }
            return i2;
        }
        RLog.error("YYPayAmountView", "productInfoList null", new Object[0]);
        return -1;
    }

    public final void c0(int i2, int i3, String str) {
        StringBuilder sb;
        if (lgb.a.a(this.a) && i3 != -800) {
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

    public final void d0() {
        PayFlowType payFlowType;
        PayUIKitConfig payUIKitConfig = this.m;
        if (payUIKitConfig != null) {
            String g2 = ffb.g(payUIKitConfig);
            RLog.debug("YYPayAmountView", "agreeUrl:" + g2);
            if (this.a instanceof Activity) {
                IYYPayAmountView.ViewParams viewParams = this.p;
                if (viewParams != null) {
                    payFlowType = viewParams.payFlowType;
                } else {
                    payFlowType = null;
                }
                if (payFlowType != null) {
                    ufb.a(payFlowType, this.y, this.z, this.m, this.a, g2, "Y币充值协议");
                } else {
                    RLog.error("YYPayAmountView", "onUserItemClick error payFlowType null", new Object[0]);
                }
            } else {
                RLog.error("YYPayAmountView", "mContext not Activity", new Object[0]);
            }
            mfb.b(this.y, this.z, PayUIEventType.paypageprotocol);
            RLog.warn("YYPayAmountView", PayUIEventType.paypageprotocol);
        }
        kfb.a(this.y, this.z, this.I, 101);
    }

    public final boolean p0() {
        boolean z;
        List<dfb> list = this.n;
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
                        dfb c2 = vfb.c(this.n, this.m, i2, j2);
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
    public final void v0() {
        Activity activity;
        if (this.C == null) {
            RLog.warn("YYPayAmountView", "updateMyBalanceUI: get balance account null");
        } else if (this.d != null && (activity = this.a) != null && !activity.isFinishing()) {
            String str = null;
            MyBalanceInfo.Account account = this.C;
            int i2 = account.currencyType;
            String a2 = igb.a(account.amount / 100.0d);
            IYYPayAmountView.ViewParams viewParams = this.p;
            if (viewParams != null) {
                int i3 = viewParams.targetAmount;
                long j2 = this.C.amount;
                if (i3 > j2) {
                    str = igb.a((i3 - j2) / 100.0d);
                }
            }
            this.d.setVisibility(0);
            this.H.setVisibility(0);
            if (i2 == 4) {
                this.d.setText(L(a2));
            } else {
                this.d.setText(String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_other), a2));
            }
            if (str != null) {
                if (i2 == 4) {
                    this.e.setText(M(str));
                } else {
                    this.e.setText(String.format(this.a.getString(R.string.pay_ui_str_wallet_amount_gap_other), str));
                }
                n0();
            }
        } else {
            RLog.warn("YYPayAmountView", "updateMyBalanceUI: ignore");
        }
    }

    public final void x0(String str) {
        IFeedbackServiceProxy iFeedbackServiceProxy;
        if (this.F != null && ffb.d() != null) {
            View findViewById = this.F.findViewById(R.id.btn_left);
            int i2 = 0;
            if (findViewById == null) {
                RLog.error("YYPayAmountView", "updateTopLeftBtn error btnLeft null", new Object[0]);
                return;
            }
            findViewById.setOnClickListener(new g());
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.y, this.z);
            if (uIKit != null) {
                iFeedbackServiceProxy = uIKit.getFeedbackServiceProxy();
            } else {
                iFeedbackServiceProxy = null;
            }
            boolean z = true;
            z = (ffb.d().feedbackSwitch != 1 || iFeedbackServiceProxy == null) ? false : false;
            if (!z) {
                i2 = 8;
            }
            findViewById.setVisibility(i2);
            if (z) {
                nfb.b(this.y, this.z, "24", "", "", "");
            }
            RLog.info("YYPayAmountView", "updateTopLeftBtn from:" + str + " proxy:" + iFeedbackServiceProxy + " feedbackSwitch:" + ffb.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
            return;
        }
        RLog.warn("YYPayAmountView", "updateTopLeftBtn from:" + str + " mWindow:" + this.F + " paysSettingInfo:" + ffb.d());
    }
}
