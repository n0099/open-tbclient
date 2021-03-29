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
/* loaded from: classes3.dex */
public class a extends d.b.b.a.d<PayVcodeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f52229a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f52230b;

    /* renamed from: c  reason: collision with root package name */
    public View f52231c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52232d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52233e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f52234f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52235g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f52236h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f52229a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        k(payVcodeActivity);
    }

    public View d() {
        return this.f52231c;
    }

    public TextView e() {
        return this.f52235g;
    }

    public TextView f() {
        return this.f52233e;
    }

    public ViewGroup h() {
        return this.f52232d;
    }

    public BaseWebView i() {
        return this.f52234f;
    }

    public final void k(PayVcodeActivity payVcodeActivity) {
        this.f52230b = (ViewGroup) this.f52229a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f52229a.findViewById(R.id.payment_performance);
        this.f52233e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52233e, R.color.CAM_X0101, 1);
        this.f52234f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f52235g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f52231c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f52232d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f52236h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f52234f.setHorizontalScrollBarEnabled(false);
        this.f52234f.setHorizontalScrollbarOverlay(false);
        this.f52234f.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        this.f52234f.getSettings().setJavaScriptEnabled(true);
    }

    public void l(boolean z) {
        this.f52235g.setVisibility(z ? 0 : 8);
    }

    public void m(boolean z) {
        this.f52236h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        d.b.h0.s0.a.a(this.f52229a.getPageContext(), this.f52230b);
        SkinManager.setBgColor(this.f52235g, i);
        SkinManager.setBackgroundResource(this.f52233e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52233e, R.color.CAM_X0101, 1);
    }
}
