package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.aec;
import com.baidu.tieba.cgc;
import com.baidu.tieba.fgc;
import com.baidu.tieba.fhc;
import com.baidu.tieba.ngc;
import com.baidu.tieba.pfc;
import com.baidu.tieba.sfc;
import com.baidu.tieba.ugc;
import com.baidu.tieba.vgc;
import com.baidu.tieba.wcc;
import com.baidu.tieba.zfc;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter;
/* loaded from: classes2.dex */
public class YYPaySplitOrderView extends LinearLayout implements fhc {
    public Activity a;
    public int b;
    public int c;
    public PayUIKitConfig d;
    public fhc.b e;
    public fhc.a f;
    public View g;
    public ImageView h;
    public aec i;
    public pfc j;
    public RecyclerView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public PaySplitOrderAdapter o;
    public List<SplitRecordItem> p;
    public PayFlowType q;

    @Override // com.baidu.tieba.ahc
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.ahc
    public void refreshWindow(WindowParams windowParams) {
    }

    /* loaded from: classes2.dex */
    public class a implements PaySplitOrderAdapter.c {
        public a() {
        }

        @Override // tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter.c
        public void a(SplitRecordItem splitRecordItem) {
            long j;
            String str;
            RLog.info("YYPaySplitOrderView", "onLinkItemClick mPayAmount:" + YYPaySplitOrderView.this.j + " item:" + splitRecordItem);
            ngc.a(YYPaySplitOrderView.this.a, splitRecordItem.value);
            if (YYPaySplitOrderView.this.j != null) {
                j = (long) YYPaySplitOrderView.this.j.c();
            } else {
                j = -1;
            }
            if (YYPaySplitOrderView.this.q == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK;
            }
            String str2 = str;
            int i = YYPaySplitOrderView.this.b;
            int i2 = YYPaySplitOrderView.this.c;
            zfc.b(i, i2, str2, "", "", "" + j);
        }

        @Override // tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter.c
        public void b(SplitRecordItem splitRecordItem) {
            long j;
            String str;
            RLog.info("YYPaySplitOrderView", "onPayAmoyntItemClick mPayAmount:" + YYPaySplitOrderView.this.j + " item:" + splitRecordItem);
            if (YYPaySplitOrderView.this.f != null) {
                pfc a = cgc.a((int) (ugc.d(splitRecordItem.value) * 100.0d), YYPaySplitOrderView.this.d);
                a.e(splitRecordItem.id);
                YYPaySplitOrderView.this.f.a(a);
            }
            if (YYPaySplitOrderView.this.j != null) {
                j = (long) YYPaySplitOrderView.this.j.c();
            } else {
                j = -1;
            }
            if (YYPaySplitOrderView.this.q == PayFlowType.DIOALOG_PAY_FLOW) {
                str = "36";
            } else {
                str = "42";
            }
            String str2 = str;
            int i = YYPaySplitOrderView.this.b;
            int i2 = YYPaySplitOrderView.this.c;
            zfc.b(i, i2, str2, "", "", "" + j);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            String str;
            if (YYPaySplitOrderView.this.f != null) {
                YYPaySplitOrderView.this.f.b();
            }
            if (YYPaySplitOrderView.this.j != null) {
                j = (long) YYPaySplitOrderView.this.j.c();
            } else {
                j = -1;
            }
            if (YYPaySplitOrderView.this.q == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK;
            }
            String str2 = str;
            int i = YYPaySplitOrderView.this.b;
            int i2 = YYPaySplitOrderView.this.c;
            zfc.b(i, i2, str2, "", "", "" + j);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements IResult<SplitOrderConfigResult> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(SplitOrderConfigResult splitOrderConfigResult, PayCallBackBean payCallBackBean) {
            RLog.info("YYPaySplitOrderView", "querySplitOrderConfig onSuccess result:" + splitOrderConfigResult);
            YYPaySplitOrderView.this.n();
            YYPaySplitOrderView.this.r(splitOrderConfigResult);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPaySplitOrderView", "querySplitOrderConfig onFail code:" + i + " failReason:" + str, new Object[0]);
            YYPaySplitOrderView.this.n();
            YYPaySplitOrderView.this.q(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPaySplitOrderView.this.p();
        }
    }

    public YYPaySplitOrderView(Activity activity, PayUIKitConfig payUIKitConfig, int i, int i2, fhc.b bVar, aec aecVar) {
        super(activity);
        pfc pfcVar;
        long j;
        String str;
        this.p = new ArrayList();
        this.a = activity;
        this.d = payUIKitConfig;
        this.e = bVar;
        this.b = i;
        this.c = i2;
        this.i = aecVar;
        if (bVar != null) {
            pfcVar = bVar.a;
        } else {
            pfcVar = null;
        }
        this.j = pfcVar;
        fhc.b bVar2 = this.e;
        this.q = bVar2 != null ? bVar2.c : null;
        o(activity);
        pfc pfcVar2 = this.j;
        if (pfcVar2 != null) {
            j = (long) pfcVar2.c();
        } else {
            j = -1;
        }
        if (this.q == PayFlowType.DIOALOG_PAY_FLOW) {
            str = PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW;
        } else {
            str = "37";
        }
        String str2 = str;
        RLog.debug("YYPaySplitOrderView", "mPayFlowType:" + this.q + " event:" + str2);
        zfc.b(this.b, this.c, str2, "", "", "" + j);
    }

    @Override // com.baidu.tieba.ahc
    public void attachWindow(Window window) {
        w(window);
    }

    public final void r(SplitOrderConfigResult splitOrderConfigResult) {
        List<SplitRecordItem> list;
        if (splitOrderConfigResult != null && (list = splitOrderConfigResult.splitRecordItemList) != null && !list.isEmpty()) {
            aec aecVar = this.i;
            if (aecVar != null) {
                aecVar.c(new sfc(splitOrderConfigResult, this.e));
            }
            v(splitOrderConfigResult);
            return;
        }
        q(-1, "splitRecordItemList null");
    }

    @Override // com.baidu.tieba.fhc
    public void setCallback(fhc.a aVar) {
        this.f = aVar;
    }

    public final void w(Window window) {
        if (window == null) {
            return;
        }
        View findViewById = window.findViewById(R.id.btn_left);
        if (findViewById == null) {
            RLog.error("YYPaySplitOrderView", "updateTopLeftBtn error btnLeft null", new Object[0]);
            return;
        }
        findViewById.setOnClickListener(new d());
        findViewById.setVisibility(0);
        findViewById.setBackgroundResource(R.drawable.pay_ui_bottom_left_back_icon);
    }

    public final void q(int i, String str) {
        fhc.a aVar = this.f;
        if (aVar != null) {
            aVar.onRefreshViewFail(i, str);
        }
    }

    @Override // com.baidu.tieba.fhc
    public void a() {
        long j;
        String str;
        pfc pfcVar = this.j;
        if (pfcVar != null) {
            j = (long) pfcVar.c();
        } else {
            j = -1;
        }
        if (this.q == PayFlowType.DIOALOG_PAY_FLOW) {
            str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
        } else {
            str = PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK;
        }
        int i = this.b;
        int i2 = this.c;
        zfc.b(i, i2, str, "", "", "" + j);
        RLog.info("YYPaySplitOrderView", "onBtnCloseClick mPayFlowType:" + this.q + " event:" + str);
    }

    public final void s() {
        RLog.info("YYPaySplitOrderView", "querySplitOrderConfig mPayAmount:" + this.j);
        wcc yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.b, this.c);
        if (yYPayMiddleService == null) {
            RLog.error("YYPaySplitOrderView", "querySplitOrderConfig error yyPayMiddleService null", new Object[0]);
            return;
        }
        pfc pfcVar = this.j;
        if (pfcVar == null) {
            RLog.error("YYPaySplitOrderView", "querySplitOrderConfig error mPayAmount null", new Object[0]);
        } else {
            yYPayMiddleService.e(1, "", (long) pfcVar.c(), new c());
        }
    }

    public final void n() {
        fgc.a(this.g, this.h);
    }

    @Override // com.baidu.tieba.ahc
    public void refreshView() {
        RLog.info("YYPaySplitOrderView", "refreshView");
        u();
        s();
    }

    public final void u() {
        fgc.b(this.g, this.h);
    }

    public final void o(Activity activity) {
        LayoutInflater.from(new ContextThemeWrapper(activity, vgc.a.a(this.d))).inflate(R.layout.pay_ui_layout_pay_split_order_view, (ViewGroup) this, true);
        this.g = findViewById(R.id.root_loading);
        this.h = (ImageView) findViewById(R.id.iv_loading_circle);
        this.k = (RecyclerView) findViewById(R.id.grid_recharge_split_order);
        PaySplitOrderAdapter paySplitOrderAdapter = new PaySplitOrderAdapter(this.a, this.p, this.d);
        this.o = paySplitOrderAdapter;
        paySplitOrderAdapter.m(new a());
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0926eb);
        this.l = textView;
        textView.getPaint().setFlags(8);
        this.l.setOnClickListener(new b());
        this.m = (TextView) findViewById(R.id.tv_total_src_amount);
        this.n = (TextView) findViewById(R.id.tv_Split_Order_Hint);
        t();
    }

    public final void v(SplitOrderConfigResult splitOrderConfigResult) {
        if (this.n != null && this.k != null && this.o != null && this.l != null) {
            if (TextUtils.isEmpty(splitOrderConfigResult.bottomGuideMsg)) {
                this.l.setVisibility(4);
            } else {
                this.l.setVisibility(0);
                this.l.setText(splitOrderConfigResult.bottomGuideMsg);
            }
            this.n.setText(splitOrderConfigResult.hintMsg);
            this.p.clear();
            List<SplitRecordItem> list = splitOrderConfigResult.splitRecordItemList;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 1 || list.get(i).type == 2) {
                    this.p.add(list.get(i));
                }
            }
            this.k.setLayoutManager(new LinearLayoutManager(this.a));
            this.k.setAdapter(this.o);
            this.o.notifyDataSetChanged();
        }
    }

    public final void p() {
        long j;
        String str;
        fhc.a aVar = this.f;
        if (aVar != null) {
            aVar.b();
        }
        pfc pfcVar = this.j;
        if (pfcVar != null) {
            j = (long) pfcVar.c();
        } else {
            j = -1;
        }
        if (this.q == PayFlowType.DIOALOG_PAY_FLOW) {
            str = PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK;
        } else {
            str = PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK;
        }
        String str2 = str;
        int i = this.b;
        int i2 = this.c;
        zfc.b(i, i2, str2, "", "", "" + j);
    }

    public final void t() {
        pfc pfcVar;
        boolean z;
        String format;
        fhc.b bVar = this.e;
        if (bVar != null && (pfcVar = bVar.a) != null) {
            double c2 = pfcVar.c();
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
            this.m.setText(format);
        }
    }
}
