package d.b.j0.c2;

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
public class a extends d.b.c.a.d<PayVcodeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f54051a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f54052b;

    /* renamed from: c  reason: collision with root package name */
    public View f54053c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f54054d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54055e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f54056f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54057g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f54058h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f54051a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        k(payVcodeActivity);
    }

    public View d() {
        return this.f54053c;
    }

    public TextView e() {
        return this.f54057g;
    }

    public TextView f() {
        return this.f54055e;
    }

    public ViewGroup h() {
        return this.f54054d;
    }

    public BaseWebView i() {
        return this.f54056f;
    }

    public final void k(PayVcodeActivity payVcodeActivity) {
        this.f54052b = (ViewGroup) this.f54051a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f54051a.findViewById(R.id.payment_performance);
        this.f54055e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f54055e, R.color.CAM_X0101, 1);
        this.f54056f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f54057g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f54053c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f54054d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f54058h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f54056f.setHorizontalScrollBarEnabled(false);
        this.f54056f.setHorizontalScrollbarOverlay(false);
        this.f54056f.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        this.f54056f.getSettings().setJavaScriptEnabled(true);
    }

    public void l(boolean z) {
        this.f54057g.setVisibility(z ? 0 : 8);
    }

    public void m(boolean z) {
        this.f54058h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        d.b.i0.s0.a.a(this.f54051a.getPageContext(), this.f54052b);
        SkinManager.setBgColor(this.f54057g, i);
        SkinManager.setBackgroundResource(this.f54055e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f54055e, R.color.CAM_X0101, 1);
    }
}
