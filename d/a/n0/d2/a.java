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
import com.baidubce.auth.NTLMEngineImpl;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends d.a.c.a.d<PayVcodeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f52703a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f52704b;

    /* renamed from: c  reason: collision with root package name */
    public View f52705c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52706d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52707e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f52708f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52709g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f52710h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f52703a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        j(payVcodeActivity);
    }

    public View d() {
        return this.f52705c;
    }

    public TextView e() {
        return this.f52709g;
    }

    public TextView f() {
        return this.f52707e;
    }

    public ViewGroup g() {
        return this.f52706d;
    }

    public BaseWebView h() {
        return this.f52708f;
    }

    public final void j(PayVcodeActivity payVcodeActivity) {
        this.f52704b = (ViewGroup) this.f52703a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f52703a.findViewById(R.id.payment_performance);
        this.f52707e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52707e, R.color.CAM_X0101, 1);
        this.f52708f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f52709g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f52705c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f52706d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f52710h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f52708f.setHorizontalScrollBarEnabled(false);
        this.f52708f.setHorizontalScrollbarOverlay(false);
        this.f52708f.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        this.f52708f.getSettings().setJavaScriptEnabled(true);
    }

    public void k(boolean z) {
        this.f52709g.setVisibility(z ? 0 : 8);
    }

    public void l(boolean z) {
        this.f52710h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        d.a.m0.s0.a.a(this.f52703a.getPageContext(), this.f52704b);
        SkinManager.setBgColor(this.f52709g, i2);
        SkinManager.setBackgroundResource(this.f52707e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52707e, R.color.CAM_X0101, 1);
    }
}
