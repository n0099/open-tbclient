package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.tieba.R;
import com.baidu.tieba.aad;
import com.baidu.tieba.cad;
import com.baidu.tieba.dad;
import com.baidu.tieba.dbd;
import com.baidu.tieba.f9d;
import com.baidu.tieba.gbd;
import com.baidu.tieba.m9d;
import com.baidu.tieba.o9d;
import com.baidu.tieba.p9d;
import com.baidu.tieba.pad;
import com.baidu.tieba.q9d;
import com.baidu.tieba.sad;
import com.baidu.tieba.t6d;
import com.baidu.tieba.t9d;
import com.baidu.tieba.tbd;
import com.baidu.tieba.uad;
import com.baidu.tieba.v9d;
import com.baidu.tieba.w9d;
import com.baidu.tieba.x7d;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PackageInstallUtil;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.PayViewState;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes2.dex */
public class YYPayWayView extends LinearLayout implements dbd {
    public List<q9d> a;
    public GridView b;
    public gbd c;
    public View d;
    public ImageView e;
    public int f;
    public int g;
    public dbd.a h;
    public q9d i;
    public Button j;
    public m9d k;
    public dbd.b l;
    public Context m;
    public TextView n;
    public PayUIKitConfig o;
    public String p;
    public AppCustomExpand q;
    public TextView r;
    public TextView s;
    public TextView t;
    public Window u;
    public x7d v;
    public String w;
    public PayFlowType x;

    @Override // com.baidu.tieba.xad
    public View getContentView() {
        return this;
    }

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            YYPayWayView.this.r(i);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends tbd {
        public b() {
        }

        @Override // com.baidu.tieba.tbd
        public void a(View view2) {
            YYPayWayView.this.l();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayWayView.this.u();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayWayView.this.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements IResult<ProductListResult> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            if (productListResult != null && productListResult.getPayWayInfoList() != null) {
                o9d.i(productListResult.getPaysSettingInfo(), "YYPayWayView");
                YYPayWayView.this.B(productListResult.getPayWayInfoList());
                YYPayWayView.this.z(productListResult.getBubbleActMsg());
            } else {
                RLog.error("YYPayWayView", "server payway list empty", new Object[0]);
                YYPayWayView.this.s(1021);
            }
            YYPayWayView.this.n();
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayWayView", "onFail code:" + i + " failReason:" + str, new Object[0]);
            YYPayWayView.this.t(1021, i, str);
            YYPayWayView.this.n();
        }
    }

    public YYPayWayView(Activity activity, int i, int i2, dbd.b bVar, PayUIKitConfig payUIKitConfig, x7d x7dVar) {
        super(activity);
        PayFlowType payFlowType;
        String str;
        this.a = new ArrayList();
        this.p = "";
        this.w = "0";
        if (bVar == null) {
            RLog.error("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        LayoutInflater.from(new ContextThemeWrapper(activity, sad.a.a(payUIKitConfig))).inflate(R.layout.pay_ui_layout_pay_way_view, (ViewGroup) this, true);
        this.l = bVar;
        this.k = bVar.c;
        this.m = activity;
        this.o = payUIKitConfig;
        this.f = i;
        this.g = i2;
        this.q = bVar.d;
        this.v = x7dVar;
        if (bVar != null) {
            String str2 = bVar.j;
            this.w = str2 != null ? str2 : "0";
        }
        RLog.debug("YYPayWayView", "mSplitOrderPayScene:" + this.w);
        this.c = new gbd(activity, payUIKitConfig, this.a);
        GridView gridView = (GridView) findViewById(R.id.grid_recharge_way);
        this.b = gridView;
        gridView.setSelector(R.drawable.pay_ui_selector_transparent);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(new a());
        Button button = (Button) findViewById(R.id.btn_confirm_recharge);
        this.j = button;
        button.setOnClickListener(new b());
        this.r = (TextView) findViewById(R.id.tv_total_src_amount);
        this.s = (TextView) findViewById(R.id.tv_total_dst_amount);
        this.t = (TextView) findViewById(R.id.tv_bubble_msg);
        TextView textView = (TextView) findViewById(R.id.tv_use_item);
        this.n = textView;
        textView.setOnClickListener(new c());
        this.d = findViewById(R.id.root_loading);
        this.e = (ImageView) findViewById(R.id.iv_loading_circle);
        dbd.b bVar2 = this.l;
        if (bVar2 != null) {
            payFlowType = bVar2.g;
        } else {
            payFlowType = null;
        }
        this.x = payFlowType;
        if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
            str = "11";
        } else {
            str = "4";
        }
        w9d.b(this.f, this.g, str, "", "", this.w);
        y();
        B(this.l.a);
        z(this.l.b);
    }

    @Override // com.baidu.tieba.xad
    public void attachWindow(Window window) {
        RLog.debug("YYPayWayView", "attachWindow window:" + window);
        this.u = window;
        dbd.b bVar = this.l;
        if (bVar != null) {
            refreshWindow(bVar.h);
        }
        C(SpeedStatsMainTable.ATTACH_WINDOW_STAGE);
    }

    public final boolean k(p9d p9dVar) {
        SplitOrderConfigResult splitOrderConfigResult;
        List<SplitRecordItem> list;
        if (p9dVar != null && (splitOrderConfigResult = p9dVar.a) != null && (list = splitOrderConfigResult.splitRecordItemList) != null && !list.isEmpty() && p9dVar.b != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.dbd
    public void setCallback(dbd.a aVar) {
        this.h = aVar;
    }

    public final void A() {
        cad.b(this.d, this.e);
    }

    @Override // com.baidu.tieba.dbd
    public boolean d() {
        dbd.a aVar;
        p9d b2 = this.v.b();
        if (k(b2) && (aVar = this.h) != null) {
            aVar.c(b2);
            return true;
        }
        return false;
    }

    public final void n() {
        cad.a(this.d, this.e);
    }

    public final void w() {
        GridView gridView;
        if (this.a.size() > 4 && (gridView = this.b) != null) {
            ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
            layoutParams.height += aad.a(24.0f);
            this.b.setLayoutParams(layoutParams);
        }
    }

    public final void B(List<PayWayInfo> list) {
        this.a.clear();
        this.a.addAll(pad.a(list));
        if (this.a.size() > 0) {
            this.i = this.a.get(0);
            this.c.c(0);
        }
        if (Env.instance().isTestEnv() && this.a.size() > 0) {
            this.a.add(new q9d(PayType.MOCK_TEST_PAY, "MOCK支付", ""));
        }
        this.c.notifyDataSetChanged();
        w();
        C("showPayWayListView");
    }

    public final void m(int i) {
        double d2;
        m9d m9dVar = this.k;
        if (m9dVar != null) {
            d2 = m9dVar.a();
        } else {
            d2 = 0.0d;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("payChannel", this.i.a.getChannel());
        hashMap.put("payMethod", this.i.a.getMethod());
        hashMap.put("charge_id", String.valueOf(i));
        hashMap.put(PayUiEventContent.AMOUNT, String.valueOf(d2));
        t9d.b(this.f, this.g, this.x, 106, hashMap);
    }

    @Override // com.baidu.tieba.xad
    public void refreshWindow(WindowParams windowParams) {
        RLog.debug("YYPayWayView", "refreshWindow params:" + windowParams + " mWindow:" + this.u);
        if (this.u != null && windowParams != null) {
            dbd.b bVar = this.l;
            if (bVar != null) {
                bVar.h = windowParams;
            }
            WindowManager.LayoutParams attributes = this.u.getAttributes();
            attributes.dimAmount = windowParams.dimAmount;
            try {
                this.u.setAttributes(attributes);
            } catch (Exception e2) {
                RLog.error("YYPayWayView", "refreshWindow e:" + e2, new Object[0]);
            }
        }
    }

    public final void C(String str) {
        IFeedbackServiceProxy iFeedbackServiceProxy;
        if (this.u != null && o9d.d() != null) {
            View findViewById = this.u.findViewById(R.id.btn_left);
            int i = 0;
            if (findViewById == null) {
                RLog.error("YYPayWayView", "updateTopLeftBtn error btnLeft null", new Object[0]);
                return;
            }
            findViewById.setOnClickListener(new d());
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.f, this.g);
            if (uIKit != null) {
                iFeedbackServiceProxy = uIKit.getFeedbackServiceProxy();
            } else {
                iFeedbackServiceProxy = null;
            }
            boolean z = true;
            z = (o9d.d().feedbackSwitch != 1 || iFeedbackServiceProxy == null) ? false : false;
            if (!z) {
                i = 8;
            }
            findViewById.setVisibility(i);
            if (z) {
                w9d.b(this.f, this.g, "26", "", "", "");
            }
            RLog.info("YYPayWayView", "updateTopLeftBtn from:" + str + " proxy:" + iFeedbackServiceProxy + " feedbackSwitch:" + o9d.d().feedbackSwitch + " yyPayUIKit:" + uIKit);
            return;
        }
        RLog.warn("YYPayWayView", "updateTopLeftBtn from:" + str + " mWindow:" + this.u + " paysSettingInfo:" + o9d.d());
    }

    @Override // com.baidu.tieba.dbd
    public void a() {
        String str;
        RLog.info("YYPayWayView", "onBtnCloseClick mSplitOrderPayScene:" + this.w + " mPayFlowType:" + this.x);
        if (this.i == null) {
            RLog.error("YYPayWayView", "onBtnCloseClick error mPayWay null", new Object[0]);
            return;
        }
        if (this.x == PayFlowType.WALLET_PAY_FLOW) {
            str = PayUVEventType.PAY_WAY_FULL_PAGE_CLOSE_BTN_CLICK;
        } else {
            str = PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK;
        }
        w9d.b(this.f, this.g, str, this.i.a.getChannel(), this.i.a.getMethod(), this.w);
    }

    public final void q() {
        dbd.b bVar = this.l;
        if (bVar == null) {
            RLog.error("YYPayWayView", "onBtnLeftClick error mViewParams null", new Object[0]);
            return;
        }
        boolean z = bVar.i;
        if (z) {
            dbd.a aVar = this.h;
            if (aVar != null) {
                aVar.toHelpCenterPage();
            }
        } else {
            f9d.d(this.f, this.g);
        }
        w9d.b(this.f, this.g, PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, "", "", "");
        RLog.info("YYPayWayView", "onBtnLeftClick showFaqPage:" + z + " mCallback:" + this.h);
    }

    @Override // com.baidu.tieba.xad
    public void refreshView() {
        Map<String, String> map;
        boolean z = false;
        if (this.a.size() <= 0) {
            A();
            dbd.b bVar = this.l;
            if (bVar != null) {
                map = bVar.e;
            } else {
                map = null;
            }
            t6d yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.f, this.g);
            if (yYPayMiddleService == null) {
                RLog.error("YYPayWayView", "refreshView error yyPayMiddleService null", new Object[0]);
                return;
            } else {
                yYPayMiddleService.b(this.x, map, new e());
                z = true;
            }
        }
        RLog.info("YYPayWayView", "refreshView isQueryProductList:" + z);
    }

    public final void u() {
        PayFlowType payFlowType;
        PayUIKitConfig payUIKitConfig = this.o;
        if (payUIKitConfig != null) {
            String g = o9d.g(payUIKitConfig);
            RLog.debug("YYPayWayView", "agreeUrl:" + g);
            if (this.m instanceof Activity) {
                dbd.b bVar = this.l;
                if (bVar != null) {
                    payFlowType = bVar.g;
                } else {
                    payFlowType = null;
                }
                if (payFlowType != null) {
                    dad.a(payFlowType, this.f, this.g, this.o, (Activity) this.m, g, "Y币充值协议");
                } else {
                    RLog.error("YYPayWayView", "onUserItemClick error payFlowType null", new Object[0]);
                }
            } else {
                RLog.error("YYPayWayView", "mContext not Activity", new Object[0]);
            }
            v9d.b(this.f, this.g, PayUIEventType.paypageprotocol);
            RLog.warn("YYPayWayView", PayUIEventType.paypageprotocol);
        }
    }

    public void l() {
        m9d m9dVar;
        m9d m9dVar2;
        q9d q9dVar = this.i;
        if (q9dVar == null) {
            RLog.error("YYPayWayView", "mPayWay null", new Object[0]);
        } else if (this.c == null) {
            RLog.error("YYPayWayView", "mPayWayListAdapter null", new Object[0]);
        } else if (q9dVar.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
            Toast.makeText(this.m, "未安装微信", 1).show();
        } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
            Toast.makeText(this.m, "未安装QQ", 1).show();
        } else if (o(this.i.a)) {
            Context context = this.m;
            Toast.makeText(context, context.getString(R.string.pay_ui_pay_too_frequency_msg), 1).show();
            RLog.warn("YYPayWayView", "pay too frequency return mPayWay:" + this.i);
        } else {
            if (Env.instance().isTestEnv() && this.i.a == PayType.MOCK_TEST_PAY && (m9dVar2 = this.k) != null) {
                ProductInfo productInfo = m9dVar2.a;
                if (productInfo.srcAmount > 10.0d) {
                    productInfo.srcAmount = 10.0d;
                    productInfo.destAmount = 1000L;
                }
            }
            if (this.h != null && (m9dVar = this.k) != null && m9dVar.a != null) {
                if (p(this.i, m9dVar)) {
                    this.h.a(this.i, this.k, this.q);
                } else {
                    this.h.b(this.i, this.k, this.q);
                }
                v9d.c(this.f, this.g, PayUIEventType.paypagepaybt, String.valueOf(this.k.a.srcAmount));
                RLog.warn("YYPayWayView", "paypagepaybt amount:" + this.k.a.srcAmount);
            } else {
                RLog.error("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
            }
            x();
            RLog.info("YYPayWayView", "comfirm paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
        }
    }

    public final boolean o(PayType payType) {
        if (payType != PayType.ALI_PAY) {
            return false;
        }
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.f, this.g);
        if (uIKit == null) {
            RLog.error("YYPayWayView", "isPayFrequency error yyPayUIKit null", new Object[0]);
            return false;
        }
        boolean isPayFrequency = uIKit.isPayFrequency();
        RLog.info("YYPayWayView", "isPayFrequency:" + isPayFrequency);
        return isPayFrequency;
    }

    public final void s(int i) {
        if (uad.a.a(this.m)) {
            Toast.makeText(this.m, "请求服务失败(" + i + "e)", 1).show();
        }
        dbd.a aVar = this.h;
        if (aVar != null) {
            aVar.onRefreshViewFail(-1, "server payway list empty");
        }
    }

    @Override // com.baidu.tieba.wad
    public void setViewState(PayViewState payViewState) {
        if (payViewState == PayViewState.WAITING_VIEW_STATE) {
            RLog.debug("YYPayWayView", "setViewState waiting");
            Button button = this.j;
            if (button == null) {
                return;
            }
            this.p = button.getText().toString();
            this.j.setText("等待支付结果...");
            this.j.setClickable(false);
        } else if (payViewState == PayViewState.SELECTING_VIEW_STATE) {
            RLog.debug("YYPayWayView", "setViewState selecting");
            Button button2 = this.j;
            if (button2 == null) {
                return;
            }
            button2.setText(this.p);
            this.j.setClickable(true);
        }
    }

    public final void z(String str) {
        RLog.info("YYPayWayView", "showBubbleActMsgView bubbleActMsg:" + str + " mTvBubbleMsg:" + this.t);
        TextView textView = this.t;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.t.setVisibility(0);
            this.t.setText(str);
            return;
        }
        this.t.setVisibility(8);
    }

    public final boolean p(q9d q9dVar, m9d m9dVar) {
        boolean z;
        if (m9dVar.c() <= q9dVar.f && q9dVar.a == PayType.ALI_PAY && m9dVar.c() > 0.0d) {
            z = true;
        } else {
            z = false;
        }
        RLog.info("YYPayWayView", "isSupportSignPay result=" + z + ", perFreePassAmount=" + q9dVar.f + ", payType=" + q9dVar.a);
        return z;
    }

    public final void r(int i) {
        this.i = this.c.getItem(i);
        if (this.c.b() != i) {
            this.c.c(i);
            this.c.notifyDataSetChanged();
        }
        v();
        RLog.info("YYPayWayView", "choose paychannel:" + this.i.a.getChannel() + " paymethod:" + this.i.a.getMethod());
        if (this.i.a == PayType.WECHAT_PAY && !PackageInstallUtil.isInstallWechat(this.m)) {
            Toast.makeText(this.m, "未安装微信", 1).show();
        } else if (this.i.a == PayType.QQ_PAY && !PackageInstallUtil.isInstallQQ(this.m)) {
            Toast.makeText(this.m, "未安装QQ", 1).show();
        }
    }

    public final void t(int i, int i2, String str) {
        StringBuilder sb;
        if (uad.a.a(this.m)) {
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
        dbd.a aVar = this.h;
        if (aVar != null) {
            aVar.onRefreshViewFail(i2, str);
        }
    }

    public final void v() {
        int i;
        PayFlowType payFlowType;
        String str;
        ProductInfo productInfo;
        m9d m9dVar = this.k;
        if (m9dVar != null && (productInfo = m9dVar.a) != null) {
            i = productInfo.cid;
        } else {
            i = 0;
        }
        dbd.b bVar = this.l;
        if (bVar != null) {
            payFlowType = bVar.g;
        } else {
            payFlowType = null;
        }
        if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
            str = "13";
        } else {
            str = "6";
        }
        String str2 = str;
        RLog.info("YYPayWayView", "reportPayWayItemClick mSplitOrderPayScene:" + this.w);
        if (!"1".equals(this.w) && !"2".equals(this.w)) {
            w9d.b(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
        } else {
            w9d.b(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), this.w);
        }
        m(i);
    }

    public final void x() {
        int i;
        PayFlowType payFlowType;
        String str;
        ProductInfo productInfo;
        RLog.info("YYPayWayView", "resportConfirmBtnClick mSplitOrderPayScene:" + this.w);
        m9d m9dVar = this.k;
        if (m9dVar != null && (productInfo = m9dVar.a) != null) {
            i = productInfo.cid;
        } else {
            i = 0;
        }
        dbd.b bVar = this.l;
        if (bVar != null) {
            payFlowType = bVar.g;
        } else {
            payFlowType = null;
        }
        if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
            str = "12";
        } else {
            str = "5";
        }
        String str2 = str;
        if (!"1".equals(this.w) && !"2".equals(this.w)) {
            w9d.b(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), String.valueOf(i));
        } else {
            w9d.b(this.f, this.g, str2, this.i.a.getChannel(), this.i.a.getMethod(), this.w);
        }
    }

    public final void y() {
        m9d m9dVar;
        boolean z;
        String format;
        String format2;
        dbd.b bVar = this.l;
        if (bVar != null && (m9dVar = bVar.c) != null) {
            double c2 = m9dVar.c();
            boolean z2 = true;
            if (c2 == ((long) c2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                format = new DecimalFormat("0").format(c2);
            } else {
                format = new DecimalFormat("0.00").format(c2);
            }
            this.r.setText(format);
            double a2 = this.l.c.a();
            if (a2 != ((long) a2)) {
                z2 = false;
            }
            if (z2) {
                format2 = new DecimalFormat("0").format(a2);
            } else {
                format2 = new DecimalFormat("0.00").format(a2);
            }
            TextView textView = this.s;
            textView.setText(format2 + "Y币");
            this.j.setText("确认支付 " + format2 + "元");
        }
    }
}
