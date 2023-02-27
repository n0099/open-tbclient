package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.hva;
import com.baidu.tieba.lua;
import com.baidu.tieba.mva;
import com.baidu.tieba.rua;
import com.baidu.tieba.tva;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes9.dex */
public class YYPaySignView extends LinearLayout implements tva {
    public Activity a;
    public tva.b b;
    public tva.a c;
    public PayUIKitConfig d;
    public TextView e;
    public int f;
    public int g;
    public long h;

    @Override // com.baidu.tieba.pva
    public void attachWindow(Window window) {
    }

    @Override // com.baidu.tieba.pva
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.pva
    public void refreshView() {
    }

    @Override // com.baidu.tieba.pva
    public void refreshWindow(WindowParams windowParams) {
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ CheckBox a;

        public a(CheckBox checkBox) {
            this.a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            CheckBox checkBox = this.a;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    /* loaded from: classes9.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            rua.d(YYPaySignView.this.f, YYPaySignView.this.g, PayUVEventType.PAY_SIGN_DIALOG_DONT_REMIND_CLICK, "", "", "");
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ CheckBox a;

        public c(CheckBox checkBox) {
            this.a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (YYPaySignView.this.c != null) {
                YYPaySignView.this.c.b();
            }
            Context applicationContext = YYPaySignView.this.a.getApplicationContext();
            hva.b(applicationContext, YYPaySignView.this.h + "").c("pay_sp_key_sign_pay_skip_remind", this.a.isChecked());
            RLog.info("YYPaySignView", "click remind. uid=" + YYPaySignView.this.h + ", is skip remind=" + this.a.isChecked());
            rua.d(YYPaySignView.this.f, YYPaySignView.this.g, PayUVEventType.PAY_SIGN_DIALOG_CONFIRM_BTN_CLICK, "", "", "");
        }
    }

    public YYPaySignView(Activity activity, tva.b bVar, PayUIKitConfig payUIKitConfig, int i, int i2) {
        super(activity);
        MiddleRevenueConfig middleRevenueConfig;
        this.h = 0L;
        if (bVar == null) {
            RLog.error("YYPaySignView", "YYPaySignView construct error viewParams null", new Object[0]);
        } else {
            RLog.info("YYPaySignView", "YYPaySignView construct, viewParams=" + bVar);
        }
        this.a = activity;
        this.b = bVar;
        this.d = payUIKitConfig;
        this.f = i;
        this.g = i2;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null) {
            this.h = middleRevenueConfig.getUid();
        }
        h();
        rua.d(this.f, this.g, PayUVEventType.PAY_SIGN_DIALOG_SHOW, "", "", "");
    }

    @Override // com.baidu.tieba.tva
    public void setCallback(tva.a aVar) {
        this.c = aVar;
    }

    public final void h() {
        LayoutInflater.from(new ContextThemeWrapper(this.a, mva.a.a(this.d))).inflate(R.layout.pay_ui_layout_sign_pay_view, (ViewGroup) this, true);
        this.e = (TextView) findViewById(R.id.btn_confirm_recharge);
        View findViewById = findViewById(R.id.ll_check_remind);
        CheckBox checkBox = (CheckBox) findViewById(R.id.btn_check_remind);
        i();
        findViewById.setOnClickListener(new a(checkBox));
        Context applicationContext = this.a.getApplicationContext();
        checkBox.setChecked(hva.b(applicationContext, this.h + "").a("pay_sp_key_sign_pay_skip_remind", true));
        checkBox.setOnCheckedChangeListener(new b());
        this.e.setOnClickListener(new c(checkBox));
    }

    public final void i() {
        lua luaVar;
        boolean z;
        String format;
        tva.b bVar = this.b;
        if (bVar != null && (luaVar = bVar.a) != null) {
            double c2 = luaVar.c();
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
            TextView textView = this.e;
            textView.setText("确认支付" + format + "元");
        }
    }
}
