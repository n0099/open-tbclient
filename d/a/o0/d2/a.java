package d.a.o0.d2;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.PayVcodeActivity;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class a extends d.a.c.a.d<PayVcodeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f56517a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56518b;

    /* renamed from: c  reason: collision with root package name */
    public View f56519c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56520d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56521e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f56522f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56523g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f56524h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f56517a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        k(payVcodeActivity);
    }

    public View d() {
        return this.f56519c;
    }

    public TextView e() {
        return this.f56523g;
    }

    public TextView f() {
        return this.f56521e;
    }

    public ViewGroup h() {
        return this.f56520d;
    }

    public BaseWebView i() {
        return this.f56522f;
    }

    public final void k(PayVcodeActivity payVcodeActivity) {
        this.f56518b = (ViewGroup) this.f56517a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f56517a.findViewById(R.id.payment_performance);
        this.f56521e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f56521e, R.color.CAM_X0101, 1);
        this.f56522f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f56523g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f56519c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f56520d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f56524h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f56522f.setHorizontalScrollBarEnabled(false);
        this.f56522f.setHorizontalScrollbarOverlay(false);
        this.f56522f.setScrollBarStyle(33554432);
        this.f56522f.getSettings().setJavaScriptEnabled(true);
    }

    public void l(boolean z) {
        this.f56523g.setVisibility(z ? 0 : 8);
    }

    public void m(boolean z) {
        this.f56524h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        d.a.n0.s0.a.a(this.f56517a.getPageContext(), this.f56518b);
        SkinManager.setBgColor(this.f56523g, i2);
        SkinManager.setBackgroundResource(this.f56521e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f56521e, R.color.CAM_X0101, 1);
    }
}
