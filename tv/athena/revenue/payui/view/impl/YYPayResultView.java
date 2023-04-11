package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.b9b;
import com.baidu.tieba.e9b;
import com.baidu.tieba.f6b;
import com.baidu.tieba.f7b;
import com.baidu.tieba.h9b;
import com.baidu.tieba.i9b;
import com.baidu.tieba.l9b;
import com.baidu.tieba.t9b;
import com.baidu.tieba.y8b;
import com.baidu.tieba.y9b;
import com.baidu.tieba.z8b;
import com.baidu.tieba.z9b;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitMinAmountInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes9.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {
    public Activity a;
    public int b;
    public int c;
    public TextView d;
    public ImageView e;
    public Button f;
    public TextView g;
    public PluginCenterTopBanner h;
    public IYYPayResultView.a i;
    public IYYPayResultView.b j;
    public PayUIKitConfig k;
    public int l;
    public List<BannerConfigItem.BannerInfo> m;
    public IYYPayResultView.c n;
    public Window o;
    public View p;
    public ImageView q;
    public RecyclerView r;
    public PaySplitOrderAdapter s;
    public List<SplitRecordItem> t;
    public String u;
    public PayFlowType v;

    @Override // com.baidu.tieba.cab
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.cab
    public void refreshView() {
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (YYPayResultView.this.i != null) {
                YYPayResultView.this.i.b();
            }
            YYPayResultView.this.I();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e9b.b(YYPayResultView.this.b, YYPayResultView.this.c, PayUIEventType.failpagecallnum);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements PaySplitOrderAdapter.c {
        public c() {
        }

        @Override // tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter.c
        public void a(SplitRecordItem splitRecordItem) {
            RLog.info("YYPayResultView", "onLinkItemClick item:" + splitRecordItem);
            t9b.a(YYPayResultView.this.a, splitRecordItem.value);
            YYPayResultView.this.C();
        }

        @Override // tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter.c
        public void b(SplitRecordItem splitRecordItem) {
            RLog.info("YYPayResultView", "onPayAmoyntItemClick item:" + splitRecordItem);
            if (YYPayResultView.this.i != null) {
                y8b a = i9b.a((int) (y9b.d(splitRecordItem.value) * 100.0d), YYPayResultView.this.k);
                a.d(splitRecordItem.id);
                YYPayResultView.this.i.a(a);
            }
            YYPayResultView.this.D(splitRecordItem);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (i >= 0 && i < YYPayResultView.this.m.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayResultView.this.m.get(i);
                RLog.info("YYPayResultView", "onItemClick: click=" + bannerInfo);
                if (YYPayResultView.this.n != null && YYPayResultView.this.n.b != null) {
                    YYPayResultView.this.n.b.onBannerClick(bannerInfo);
                }
                e9b.d(YYPayResultView.this.b, YYPayResultView.this.c, "23", "", "", bannerInfo.id);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BannerItemSelectListener {
        public e() {
        }

        @Override // tv.athena.revenue.payui.model.BannerItemSelectListener
        public void onItemSelected(int i) {
            if (i >= 0 && i < YYPayResultView.this.m.size()) {
                BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayResultView.this.m.get(i);
                RLog.debug("YYPayResultView", "onItemSelected: item=" + bannerInfo);
                e9b.d(YYPayResultView.this.b, YYPayResultView.this.c, "22", "", "", bannerInfo.id);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements IResult<BannerConfigResult> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            RLog.info("YYPayResultView", "queryBannerConfig onSuccess:" + bannerConfigResult);
            YYPayResultView.this.m.clear();
            if (bannerConfigResult.getBannerConfigItemList() != null && bannerConfigResult.getBannerConfigItemList().size() > 0) {
                BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                list = bannerConfigItem.bannerInfoList;
                YYPayResultView.this.l = bannerConfigItem.autoPlayTime;
            } else {
                list = null;
            }
            if (list != null && list.size() > 0) {
                YYPayResultView.this.m.addAll(list);
                YYPayResultView.this.J();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayResultView", "queryBannerConfig onFail code:" + i + " failReason:" + str, new Object[0]);
        }
    }

    /* loaded from: classes9.dex */
    public class g implements IResult<SplitOrderConfigResult> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(SplitOrderConfigResult splitOrderConfigResult, PayCallBackBean payCallBackBean) {
            RLog.info("YYPayResultView", "querySplitOrderConfig onSuccess result:" + splitOrderConfigResult);
            YYPayResultView.this.v();
            if (splitOrderConfigResult == null) {
                YYPayResultView.this.w();
                return;
            }
            YYPayResultView.this.H(splitOrderConfigResult.splitRecordItemList);
            YYPayResultView.this.B(splitOrderConfigResult.hintMsg, null);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayResultView", "querySplitOrderConfig onFail code:" + i + " failReason:" + str, new Object[0]);
            YYPayResultView.this.v();
            YYPayResultView.this.w();
        }
    }

    public YYPayResultView(Activity activity, PayUIKitConfig payUIKitConfig, int i, int i2, IYYPayResultView.c cVar, f7b f7bVar) {
        super(activity);
        PayFlowType payFlowType;
        this.m = new ArrayList();
        this.t = new ArrayList();
        this.u = "0";
        if (cVar == null) {
            RLog.error("YYPayResultView", "YYPayResultView construct error viewParams null", new Object[0]);
        }
        this.k = payUIKitConfig;
        LayoutInflater.from(new ContextThemeWrapper(activity, z9b.a.a(payUIKitConfig))).inflate(R.layout.pay_ui_layout_pay_result_view, (ViewGroup) this, true);
        this.a = activity;
        this.n = cVar;
        this.d = (TextView) findViewById(R.id.tv_result);
        this.b = i;
        this.c = i2;
        if (cVar != null) {
            payFlowType = cVar.f;
        } else {
            payFlowType = null;
        }
        this.v = payFlowType;
        if (cVar != null) {
            String str = cVar.k;
            this.u = str != null ? str : "0";
        }
        x(cVar);
        K(cVar != null ? cVar.a : null);
        s(cVar);
        z();
        E();
        RLog.debug("YYPayResultView", "YYPayResultView construct mPayFlowType:" + this.v);
    }

    @Override // com.baidu.tieba.cab
    public void attachWindow(Window window) {
        RLog.debug("YYPayResultView", "attachWindow window:" + window);
        this.o = window;
        IYYPayResultView.c cVar = this.n;
        if (cVar != null) {
            refreshWindow(cVar.c);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void setCallback(IYYPayResultView.a aVar) {
        RLog.info("YYPayResultView", "setCallback");
        this.i = aVar;
        G();
    }

    public final int t(List<SplitRecordItem> list) {
        int i = 0;
        if (list == null) {
            return 0;
        }
        for (SplitRecordItem splitRecordItem : list) {
            if (splitRecordItem.type == 1) {
                i++;
            }
        }
        return i;
    }

    public final int u(List<SplitMinAmountInfo> list) {
        RLog.info("YYPayResultView", "getSplitMinAmount splitMinAmountInfoList:" + list);
        for (SplitMinAmountInfo splitMinAmountInfo : list) {
            if (splitMinAmountInfo.splitType == 2) {
                return splitMinAmountInfo.minAmount;
            }
        }
        return 0;
    }

    public final void A(y8b y8bVar, String str) {
        RLog.info("YYPayResultView", "querySplitOrderConfig payAmount:" + y8bVar + " orderId:" + str);
        f6b yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.b, this.c);
        if (yYPayMiddleService == null) {
            RLog.error("YYPayResultView", "querySplitOrderConfig error yyPayMiddleService null", new Object[0]);
            return;
        }
        F();
        yYPayMiddleService.d(2, str, (long) y8bVar.c(), new g());
    }

    public final void B(String str, List<SplitRecordItem> list) {
        if (this.g != null && this.d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.d.setVisibility(8);
                this.g.setText(str);
            } else if (list != null && !list.isEmpty()) {
                this.d.setVisibility(0);
                TextView textView = this.g;
                textView.setText("还剩" + t(list) + "笔待支付");
            }
        }
    }

    public final void C() {
        String str;
        String str2;
        if (this.j == null) {
            RLog.error("YYPayResultView", "reportLinkItemClick error mPayResult null", new Object[0]);
            return;
        }
        RLog.debug("YYPayResultView", "reportLinkItemClick mPayResult:" + this.j + " mSplitOrderPayScene:" + this.u + " mPayFlowType:" + this.v);
        IYYPayResultView.Result result = this.j.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str2 = PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK;
            } else {
                str2 = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK;
            }
            e9b.d(this.b, this.c, str2, "", "", this.u);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK;
            }
            e9b.d(this.b, this.c, str, "", "", this.u);
        }
    }

    public final void E() {
        String str;
        String str2;
        if (this.j == null) {
            RLog.error("YYPayResultView", "reportPayResultViewShow error mPayResult null", new Object[0]);
            return;
        }
        RLog.debug("YYPayResultView", "reportPayResultViewShow mPayResult:" + this.j + " mSplitOrderPayScene:" + this.u + " mPayFlowType:" + this.v);
        IYYPayResultView.Result result = this.j.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str2 = PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW;
            } else {
                str2 = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW;
            }
            e9b.d(this.b, this.c, str2, "", "", this.u);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW;
            }
            e9b.d(this.b, this.c, str, "", "", this.u);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void a() {
        String str;
        String str2;
        RLog.debug("YYPayResultView", "onBtnCloseClick mPayResult:" + this.j + " mSplitOrderPayScene:" + this.u + " mPayFlowType:" + this.v);
        IYYPayResultView.b bVar = this.j;
        if (bVar == null) {
            RLog.error("YYPayResultView", "onBtnCloseClick error mPayResult null", new Object[0]);
            return;
        }
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str2 = PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK;
            } else {
                str2 = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK;
            }
            e9b.d(this.b, this.c, str2, "", "", this.u);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK;
            }
            e9b.d(this.b, this.c, str, "", "", this.u);
        }
    }

    public final void D(SplitRecordItem splitRecordItem) {
        String str;
        String str2;
        if (this.j == null) {
            RLog.error("YYPayResultView", "resportPayAmountItemClick error mPayResult null", new Object[0]);
            return;
        }
        RLog.debug("YYPayResultView", "resportPayAmountItemClick mPayResult:" + this.j + " mSplitOrderPayScene:" + this.u + " mPayFlowType:" + this.v);
        IYYPayResultView.Result result = this.j.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str2 = PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK;
            } else {
                str2 = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK;
            }
            e9b.d(this.b, this.c, str2, "", splitRecordItem.value, this.u);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            if (this.v == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK;
            }
            e9b.d(this.b, this.c, str, "", splitRecordItem.value, this.u);
        }
    }

    public final void H(List<SplitRecordItem> list) {
        Button button;
        if (list != null && !list.isEmpty() && this.r != null && this.s != null && (button = this.f) != null) {
            button.setVisibility(8);
            this.r.setVisibility(0);
            this.t.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 1 || list.get(i).type == 2) {
                    this.t.add(list.get(i));
                }
            }
            this.r.setLayoutManager(new LinearLayoutManager(this.a));
            this.r.setAdapter(this.s);
            this.s.notifyDataSetChanged();
        }
    }

    public final void x(IYYPayResultView.c cVar) {
        this.e = (ImageView) findViewById(R.id.img_result);
        this.p = findViewById(R.id.root_loading);
        this.q = (ImageView) findViewById(R.id.iv_loading_circle);
        this.g = (TextView) findViewById(R.id.tv_hint);
        Button button = (Button) findViewById(R.id.btn_confirm);
        this.f = button;
        button.setOnClickListener(new a());
        this.g.setOnClickListener(new b());
        PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f090320);
        this.h = pluginCenterTopBanner;
        PayUIKitConfig payUIKitConfig = this.k;
        if (payUIKitConfig != null) {
            pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig.imageLoaderSupplier);
        }
        this.r = (RecyclerView) findViewById(R.id.grid_recharge_split_order);
        PaySplitOrderAdapter paySplitOrderAdapter = new PaySplitOrderAdapter(this.a, this.t, this.k);
        this.s = paySplitOrderAdapter;
        paySplitOrderAdapter.l(new c());
    }

    public final void F() {
        l9b.b(this.p, this.q);
    }

    public final void G() {
        boolean z;
        IYYPayResultView.a aVar = this.i;
        if (aVar != null) {
            z = aVar.c();
        } else {
            z = false;
        }
        RLog.info("YYPayResultView", "showPayGiftDialog:" + z);
    }

    public final void I() {
        IYYPayResultView.b bVar = this.j;
        if (bVar == null) {
            return;
        }
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            e9b.b(this.b, this.c, PayUIEventType.successpageclose);
            RLog.info("YYPayResultView", PayUIEventType.successpageclose);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            e9b.b(this.b, this.c, PayUIEventType.failpageclose);
            RLog.info("YYPayResultView", PayUIEventType.failpageclose);
        }
    }

    public final void v() {
        l9b.a(this.p, this.q);
    }

    public final void w() {
        RecyclerView recyclerView = this.r;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        Button button = this.f;
        if (button != null) {
            button.setVisibility(0);
        }
    }

    public final void z() {
        f6b yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.b, this.c);
        if (yYPayMiddleService == null) {
            RLog.info("YYPayResultView", "queryBannerConfig error yyPayMiddleService null");
        } else {
            yYPayMiddleService.a(new int[]{2}, new f());
        }
    }

    public final void J() {
        RLog.info("YYPayResultView", "updateBanner: count=" + this.m.size());
        if (this.m.size() == 0) {
            this.h.setVisibility(8);
            return;
        }
        int i = this.l;
        if (i > 0) {
            this.h.setFlipInterval(i);
        }
        this.h.setData(this.m);
        this.h.setOnItemClickListener(new d());
        this.h.setBannerItemSelectListener(new e());
        this.h.setVisibility(0);
    }

    public final void K(IYYPayResultView.b bVar) {
        String str;
        String str2;
        String str3;
        if (bVar == null) {
            return;
        }
        this.j = bVar;
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.d.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.b;
            String str4 = null;
            if (currencyChargeMessage != null && currencyChargeMessage.currencyAmount > 0) {
                str4 = new DecimalFormat("#.##").format(currencyChargeMessage.currencyAmount / 100.0d);
            }
            String str5 = "";
            if (str4 != null) {
                if (currencyChargeMessage.currencyType != 4) {
                    str3 = "";
                } else {
                    str3 = "Y币";
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("成功充值" + str4 + str3);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(h9b.a("#ffb200")), 4, str4.length() + 4, 33);
                this.d.setText(spannableStringBuilder);
            } else {
                this.d.setText("充值成功");
            }
            if (z8b.d() != null && z8b.d().successMsg != null) {
                str5 = z8b.d().successMsg;
            }
            this.g.setText(str5);
            this.e.setImageResource(R.drawable.pay_ui_pay_success_icon);
            e9b.b(this.b, this.c, PayUIEventType.successpageshow);
            RLog.info("YYPayResultView", PayUIEventType.successpageshow);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            String str6 = "充值失败";
            CurrencyChargeMessage currencyChargeMessage2 = bVar.b;
            if (currencyChargeMessage2 == null) {
                String str7 = bVar.d;
                if (str7 != null) {
                    str6 = str7;
                }
                str = str6 + "(" + bVar.c + SmallTailInfo.EMOTION_SUFFIX;
                int i = bVar.c;
                if (i == -401) {
                    str = "服务请求失败(-401),请稍后重试！";
                } else if (i == -500) {
                    str = "网络请求失败(-500),请确认网络再试！";
                }
            } else {
                String str8 = currencyChargeMessage2.message;
                if (str8 != null) {
                    str6 = str8;
                }
                str = str6 + "(" + bVar.b.status + SmallTailInfo.EMOTION_SUFFIX;
            }
            this.d.setText(str);
            if (z8b.d() != null && z8b.d().customerServiceMsg != null && !z8b.d().customerServiceMsg.isEmpty()) {
                str2 = z8b.d().customerServiceMsg;
            } else {
                str2 = "如有问题可以联系客服 ";
            }
            this.g.setText(str2);
            this.e.setImageResource(R.drawable.pay_ui_pay_fail_icon);
            RLog.info("YYPayResultView", PayUIEventType.failpageshow);
            e9b.b(this.b, this.c, PayUIEventType.failpageshow);
        }
    }

    @Override // com.baidu.tieba.cab
    public void refreshWindow(WindowParams windowParams) {
        RLog.debug("YYPayResultView", "refreshWindow params:" + windowParams + " mWindow:" + this.o);
        if (this.o != null && windowParams != null) {
            IYYPayResultView.c cVar = this.n;
            if (cVar != null) {
                cVar.c = windowParams;
            }
            WindowManager.LayoutParams attributes = this.o.getAttributes();
            attributes.dimAmount = windowParams.dimAmount;
            try {
                this.o.setAttributes(attributes);
            } catch (Exception e2) {
                RLog.error("YYPayResultView", "refreshWindow e:" + e2, new Object[0]);
            }
        }
    }

    public final void s(IYYPayResultView.c cVar) {
        IYYPayResultView.b bVar;
        String str;
        if (cVar != null && (bVar = cVar.a) != null) {
            IYYPayResultView.Result result = bVar.a;
            if (result == IYYPayResultView.Result.PAY_SUUCESS) {
                List<SplitRecordItem> list = cVar.d;
                if (list != null && !list.isEmpty()) {
                    H(list);
                    B(null, list);
                    return;
                }
                w();
            } else if (result == IYYPayResultView.Result.PAY_FAIL) {
                b9b b9bVar = cVar.g;
                y8b y8bVar = cVar.e;
                boolean z = cVar.i;
                PayCallBackBean payCallBackBean = cVar.l;
                if (payCallBackBean != null) {
                    str = payCallBackBean.getOrderId();
                } else {
                    str = "";
                }
                if (!z && b9bVar != null && b9bVar.a == PayType.ALI_PAY && bVar.c == 4000 && y8bVar != null && y((int) y8bVar.c())) {
                    A(y8bVar, str);
                } else {
                    w();
                }
            }
        }
    }

    public final boolean y(int i) {
        PaysSettingInfo d2 = z8b.d();
        if (d2 == null) {
            RLog.error("YYPayResultView", "maybeShowSplitOrderDialog error settingInfo null", new Object[0]);
            return false;
        }
        List<SplitMinAmountInfo> list = d2.splitMinAmountInfoList;
        if (list != null && !list.isEmpty()) {
            int u = u(d2.splitMinAmountInfoList);
            if (u <= 0) {
                RLog.info("YYPayResultView", "maybeShowSplitOrderDialog false splitMinAmount:" + u);
                return false;
            }
            RLog.info("YYPayResultView", "maybeShowSplitOrderView inputAmount:" + i + " splitMinAmount:" + u);
            if (i < u) {
                return false;
            }
            return true;
        }
        RLog.warn("YYPayResultView", "maybeShowSplitOrderDialog error splitMinAmountInfoList null");
        return false;
    }
}
