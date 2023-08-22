package tv.athena.revenue.payui.view.impl;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
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
import com.baidu.tieba.ahc;
import com.baidu.tieba.ghc;
import com.baidu.tieba.jgc;
import com.baidu.tieba.tgc;
import com.baidu.tieba.xfc;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes2.dex */
public class YYPayConfirmView extends LinearLayout implements ahc {
    public int a;
    public int b;
    public ahc.a c;
    public GridView d;
    public TextView e;
    public View f;
    public Button g;
    public TextView h;
    public PayUIKitConfig i;
    public ghc j;
    public GiftBagsInfo k;
    public List<GiftBagItemInfo> l;

    @Override // com.baidu.tieba.ygc
    public void attachWindow(Window window) {
    }

    @Override // com.baidu.tieba.ygc
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.ygc
    public void refreshWindow(WindowParams windowParams) {
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYPayConfirmView.this.f();
        }
    }

    public YYPayConfirmView(Context context, int i, int i2, PayUIKitConfig payUIKitConfig) {
        super(context);
        this.l = new ArrayList();
        this.a = i;
        this.b = i2;
        this.i = payUIKitConfig;
        e(context);
        xfc.b(this.a, this.b, "15", "", "", "");
    }

    @Override // com.baidu.tieba.ahc
    public void setCallback(ahc.a aVar) {
        this.c = aVar;
    }

    @Override // com.baidu.tieba.ahc
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        RLog.info("YYPayConfirmView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
        this.k = giftBagsInfo;
    }

    public final boolean c() {
        PayUIKitConfig payUIKitConfig = this.i;
        if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
            return true;
        }
        return false;
    }

    public final void f() {
        RLog.info("YYPayConfirmView", "onContinueBtnClick");
        ahc.a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
        xfc.b(this.a, this.b, "16", "", "", "");
    }

    public final void g() {
        if (!TextUtils.isEmpty(this.k.giveupButtonMsg)) {
            this.g.setText(this.k.giveupButtonMsg);
        }
    }

    public final void h() {
        if (TextUtils.isEmpty(this.k.giveupSubtitle)) {
            this.e.setVisibility(4);
            return;
        }
        this.e.setVisibility(0);
        this.e.setText(this.k.giveupSubtitle);
    }

    public final void i() {
        if (TextUtils.isEmpty(this.k.giveupTitle)) {
            this.h.setVisibility(4);
            return;
        }
        this.h.setVisibility(0);
        this.h.setText(this.k.giveupTitle);
    }

    public final void e(Context context) {
        LayoutInflater.from(new ContextThemeWrapper(context, tgc.a.a(this.i))).inflate(R.layout.pay_ui_layout_pay_confirm_giveup_view, (ViewGroup) this, true);
        Button button = (Button) findViewById(R.id.btn_continue);
        this.g = button;
        button.setOnClickListener(new a());
        GridView gridView = (GridView) findViewById(R.id.grid_pay_gift);
        this.d = gridView;
        int i = 0;
        gridView.setSelector(new ColorDrawable(0));
        ghc ghcVar = new ghc(context, this.l, this.i);
        this.j = ghcVar;
        this.d.setAdapter((ListAdapter) ghcVar);
        GridView gridView2 = this.d;
        if (!c()) {
            i = 8;
        }
        gridView2.setVisibility(i);
        this.e = (TextView) findViewById(R.id.tv_desc);
        this.f = findViewById(R.id.rl_container);
        this.h = (TextView) findViewById(R.id.tv_title);
    }

    @Override // com.baidu.tieba.ygc
    public void refreshView() {
        RLog.info("YYPayConfirmView", "refreshView mGiftBagsInfo:" + this.k);
        if (!c()) {
            RLog.error("YYPayConfirmView", "refreshView error imageLoaderSupplierValid false", new Object[0]);
            return;
        }
        GiftBagsInfo giftBagsInfo = this.k;
        if (giftBagsInfo == null) {
            RLog.error("YYPayConfirmView", "refreshView error mGiftBagsInfo null", new Object[0]);
            return;
        }
        List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
        if (list != null && !list.isEmpty()) {
            this.l.clear();
            this.l.addAll(this.k.giftbag);
            this.j.notifyDataSetChanged();
            jgc.a(this.l.size(), this.f, this.d);
            i();
            h();
            g();
            return;
        }
        RLog.error("YYPayConfirmView", "refreshView error giftbag empty", new Object[0]);
    }
}
