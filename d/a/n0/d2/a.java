package d.a.n0.d2;

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
    public PayVcodeActivity f56392a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56393b;

    /* renamed from: c  reason: collision with root package name */
    public View f56394c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56395d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56396e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f56397f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56398g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f56399h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f56392a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        k(payVcodeActivity);
    }

    public View d() {
        return this.f56394c;
    }

    public TextView e() {
        return this.f56398g;
    }

    public TextView f() {
        return this.f56396e;
    }

    public ViewGroup h() {
        return this.f56395d;
    }

    public BaseWebView i() {
        return this.f56397f;
    }

    public final void k(PayVcodeActivity payVcodeActivity) {
        this.f56393b = (ViewGroup) this.f56392a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f56392a.findViewById(R.id.payment_performance);
        this.f56396e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f56396e, R.color.CAM_X0101, 1);
        this.f56397f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f56398g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f56394c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f56395d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f56399h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f56397f.setHorizontalScrollBarEnabled(false);
        this.f56397f.setHorizontalScrollbarOverlay(false);
        this.f56397f.setScrollBarStyle(33554432);
        this.f56397f.getSettings().setJavaScriptEnabled(true);
    }

    public void l(boolean z) {
        this.f56398g.setVisibility(z ? 0 : 8);
    }

    public void m(boolean z) {
        this.f56399h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        d.a.m0.s0.a.a(this.f56392a.getPageContext(), this.f56393b);
        SkinManager.setBgColor(this.f56398g, i2);
        SkinManager.setBackgroundResource(this.f56396e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f56396e, R.color.CAM_X0101, 1);
    }
}
