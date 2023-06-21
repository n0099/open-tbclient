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
import com.baidu.tieba.ixb;
import com.baidu.tieba.mwb;
import com.baidu.tieba.pxb;
import com.baidu.tieba.vxb;
import com.baidu.tieba.ywb;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes2.dex */
public class YYPayConfirmView extends LinearLayout implements pxb {
    public int a;
    public int b;
    public pxb.a c;
    public GridView d;
    public TextView e;
    public View f;
    public Button g;
    public TextView h;
    public PayUIKitConfig i;
    public vxb j;
    public GiftBagsInfo k;
    public List<GiftBagItemInfo> l;

    @Override // com.baidu.tieba.nxb
    public void attachWindow(Window window) {
    }

    @Override // com.baidu.tieba.nxb
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.nxb
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
        mwb.b(this.a, this.b, "15", "", "", "");
    }

    @Override // com.baidu.tieba.pxb
    public void setCallback(pxb.a aVar) {
        this.c = aVar;
    }

    @Override // com.baidu.tieba.pxb
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
        pxb.a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
        mwb.b(this.a, this.b, "16", "", "", "");
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
        LayoutInflater.from(new ContextThemeWrapper(context, ixb.a.a(this.i))).inflate(R.layout.pay_ui_layout_pay_confirm_giveup_view, (ViewGroup) this, true);
        Button button = (Button) findViewById(R.id.btn_continue);
        this.g = button;
        button.setOnClickListener(new a());
        GridView gridView = (GridView) findViewById(R.id.grid_pay_gift);
        this.d = gridView;
        int i = 0;
        gridView.setSelector(new ColorDrawable(0));
        vxb vxbVar = new vxb(context, this.l, this.i);
        this.j = vxbVar;
        this.d.setAdapter((ListAdapter) vxbVar);
        GridView gridView2 = this.d;
        if (!c()) {
            i = 8;
        }
        gridView2.setVisibility(i);
        this.e = (TextView) findViewById(R.id.tv_desc);
        this.f = findViewById(R.id.rl_container);
        this.h = (TextView) findViewById(R.id.tv_title);
    }

    @Override // com.baidu.tieba.nxb
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
            ywb.a(this.l.size(), this.f, this.d);
            i();
            h();
            g();
            return;
        }
        RLog.error("YYPayConfirmView", "refreshView error giftbag empty", new Object[0]);
    }
}
