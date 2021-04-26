package tv.athena.revenue.payui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.c.h;
import i.a.a.e.c;
import java.text.DecimalFormat;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes7.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {

    /* renamed from: e  reason: collision with root package name */
    public int f68892e;

    /* renamed from: f  reason: collision with root package name */
    public int f68893f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f68894g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f68895h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f68896i;
    public Button j;
    public IYYPayResultView.a k;
    public IYYPayResultView.b l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (YYPayResultView.this.k != null) {
                YYPayResultView.this.k.onClose();
            }
            YYPayResultView.this.e();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.a.a.e.k.a.b(YYPayResultView.this.f68892e, YYPayResultView.this.f68893f, "failpagecallnum");
        }
    }

    public YYPayResultView(Context context, int i2, int i3, IYYPayResultView.c cVar) {
        super(context);
        if (cVar == null) {
            d.e("YYPayResultView", "YYPayResultView construct error viewParams null", new Object[0]);
        }
        LayoutInflater.from(context).inflate(i.a.a.e.d.yy_layout_pay_result_view, (ViewGroup) this, true);
        this.f68894g = (TextView) findViewById(c.tv_result);
        this.j = (Button) findViewById(c.btn_confirm);
        this.f68892e = i2;
        this.f68893f = i3;
        this.f68895h = (ImageView) findViewById(c.img_result);
        this.f68896i = (TextView) findViewById(c.tv_hint);
        f(cVar.f68880a);
        this.j.setOnClickListener(new a());
        this.f68896i.setOnClickListener(new b());
    }

    public final void e() {
        IYYPayResultView.b bVar = this.l;
        if (bVar == null) {
            return;
        }
        IYYPayResultView.Result result = bVar.f68878a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            i.a.a.e.k.a.b(this.f68892e, this.f68893f, "successpageclose");
            d.h("YYPayResultView", "successpageclose");
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            i.a.a.e.k.a.b(this.f68892e, this.f68893f, "failpageclose");
            d.h("YYPayResultView", "failpageclose");
        }
    }

    public final void f(IYYPayResultView.b bVar) {
        String str;
        String str2;
        if (bVar == null) {
            return;
        }
        this.l = bVar;
        IYYPayResultView.Result result = bVar.f68878a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.f68894g.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.f68879b;
            String str3 = null;
            if (currencyChargeMessage != null && currencyChargeMessage.amount > 0) {
                str3 = new DecimalFormat("#.##").format(((float) currencyChargeMessage.currencyAmount) / 100.0f);
            }
            if (str3 != null) {
                str2 = "成功充值" + str3 + "Y币";
            } else {
                str2 = "充值成功";
            }
            this.f68894g.setText(str2);
            h hVar = i.a.a.e.j.c.f68151a;
            this.f68896i.setText((hVar == null || (r7 = hVar.f67099d) == null) ? "" : "");
            this.f68895h.setImageResource(i.a.a.e.b.yy_pay_success_icon);
            i.a.a.e.k.a.b(this.f68892e, this.f68893f, "successpageshow");
            d.h("YYPayResultView", "successpageshow");
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            this.f68894g.setText("充值失败");
            h hVar2 = i.a.a.e.j.c.f68151a;
            if (hVar2 != null) {
                String str4 = hVar2.f67097b;
                if (str4 != null && !str4.isEmpty()) {
                    String str5 = i.a.a.e.j.c.f68151a.f67097b;
                }
                String str6 = i.a.a.e.j.c.f68151a.f67098c;
                if (str6 != null && !str6.isEmpty()) {
                    str = i.a.a.e.j.c.f68151a.f67098c;
                    this.f68896i.setText(str);
                    this.f68895h.setImageResource(i.a.a.e.b.yy_pay_fail_icon);
                    i.a.a.e.k.a.b(this.f68892e, this.f68893f, "failpageshow");
                }
            }
            str = "如有问题可以联系客服 ";
            this.f68896i.setText(str);
            this.f68895h.setImageResource(i.a.a.e.b.yy_pay_fail_icon);
            i.a.a.e.k.a.b(this.f68892e, this.f68893f, "failpageshow");
        }
    }

    @Override // i.a.a.e.m.a
    public View getContentView() {
        return this;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void setCallback(IYYPayResultView.a aVar) {
        this.k = aVar;
    }
}
