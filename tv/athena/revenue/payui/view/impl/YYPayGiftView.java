package tv.athena.revenue.payui.view.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.bbd;
import com.baidu.tieba.gbd;
import com.baidu.tieba.jad;
import com.baidu.tieba.tad;
import com.baidu.tieba.x9d;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes2.dex */
public class YYPayGiftView extends LinearLayout implements bbd {
    public int a;
    public int b;
    public Button c;
    public GridView d;
    public View e;
    public TextView f;
    public bbd.a g;
    public GiftBagsInfo h;
    public PayUIKitConfig i;
    public List<GiftBagItemInfo> j;
    public gbd k;

    @Override // com.baidu.tieba.yad
    public void attachWindow(Window window) {
    }

    @Override // com.baidu.tieba.yad
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.yad
    public void refreshWindow(WindowParams windowParams) {
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (YYPayGiftView.this.g != null) {
                YYPayGiftView.this.g.a();
            }
        }
    }

    public YYPayGiftView(Context context, int i, int i2, PayUIKitConfig payUIKitConfig) {
        super(context);
        this.j = new ArrayList();
        this.a = i;
        this.b = i2;
        this.i = payUIKitConfig;
        c(context);
        x9d.b(this.a, this.b, "17", "", "", "");
    }

    @Override // com.baidu.tieba.bbd
    public void setCallback(bbd.a aVar) {
        this.g = aVar;
    }

    @Override // com.baidu.tieba.bbd
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        RLog.info("YYPayGiftView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
        this.h = giftBagsInfo;
    }

    public final void c(Context context) {
        LayoutInflater.from(new ContextThemeWrapper(context, tad.a.a(this.i))).inflate(R.layout.pay_ui_layout_pay_success_gift_view, (ViewGroup) this, true);
        Button button = (Button) findViewById(R.id.btn_know);
        this.c = button;
        button.setOnClickListener(new a());
        this.f = (TextView) findViewById(R.id.tv_title);
        this.e = findViewById(R.id.rl_container);
        this.d = (GridView) findViewById(R.id.grid_pay_gift);
        gbd gbdVar = new gbd(context, this.j, this.i);
        this.k = gbdVar;
        this.d.setAdapter((ListAdapter) gbdVar);
    }

    public final void e() {
        if (!TextUtils.isEmpty(this.h.successButtonMsg)) {
            this.c.setText(this.h.successButtonMsg);
        }
    }

    public final void f() {
        if (!TextUtils.isEmpty(this.h.successTitle)) {
            this.f.setText(this.h.successTitle);
        }
    }

    @Override // com.baidu.tieba.yad
    public void refreshView() {
        RLog.info("YYPayGiftView", "refreshView mGiftBagsInfo:" + this.h);
        GiftBagsInfo giftBagsInfo = this.h;
        if (giftBagsInfo == null) {
            RLog.error("YYPayGiftView", "refreshView error mGiftBagsInfo null", new Object[0]);
            return;
        }
        List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
        if (list != null && !list.isEmpty()) {
            this.j.clear();
            this.j.addAll(this.h.giftbag);
            this.k.notifyDataSetChanged();
            jad.a(this.j.size(), this.e, this.d);
            f();
            e();
            return;
        }
        RLog.error("YYPayGiftView", "refreshView error giftbag empty", new Object[0]);
    }
}
