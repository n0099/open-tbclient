package d.b.i0.b2;

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
public class a extends d.b.b.a.d<PayVcodeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f52228a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f52229b;

    /* renamed from: c  reason: collision with root package name */
    public View f52230c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52231d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52232e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f52233f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52234g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f52235h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f52228a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        k(payVcodeActivity);
    }

    public View d() {
        return this.f52230c;
    }

    public TextView e() {
        return this.f52234g;
    }

    public TextView f() {
        return this.f52232e;
    }

    public ViewGroup h() {
        return this.f52231d;
    }

    public BaseWebView i() {
        return this.f52233f;
    }

    public final void k(PayVcodeActivity payVcodeActivity) {
        this.f52229b = (ViewGroup) this.f52228a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f52228a.findViewById(R.id.payment_performance);
        this.f52232e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52232e, R.color.CAM_X0101, 1);
        this.f52233f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f52234g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f52230c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f52231d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f52235h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f52233f.setHorizontalScrollBarEnabled(false);
        this.f52233f.setHorizontalScrollbarOverlay(false);
        this.f52233f.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        this.f52233f.getSettings().setJavaScriptEnabled(true);
    }

    public void l(boolean z) {
        this.f52234g.setVisibility(z ? 0 : 8);
    }

    public void m(boolean z) {
        this.f52235h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        d.b.h0.s0.a.a(this.f52228a.getPageContext(), this.f52229b);
        SkinManager.setBgColor(this.f52234g, i);
        SkinManager.setBackgroundResource(this.f52232e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52232e, R.color.CAM_X0101, 1);
    }
}
