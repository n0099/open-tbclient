package d.a.k0.c2;

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
    public PayVcodeActivity f52523a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f52524b;

    /* renamed from: c  reason: collision with root package name */
    public View f52525c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52526d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52527e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f52528f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52529g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f52530h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f52523a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        j(payVcodeActivity);
    }

    public View d() {
        return this.f52525c;
    }

    public TextView e() {
        return this.f52529g;
    }

    public TextView f() {
        return this.f52527e;
    }

    public ViewGroup g() {
        return this.f52526d;
    }

    public BaseWebView h() {
        return this.f52528f;
    }

    public final void j(PayVcodeActivity payVcodeActivity) {
        this.f52524b = (ViewGroup) this.f52523a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f52523a.findViewById(R.id.payment_performance);
        this.f52527e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52527e, R.color.CAM_X0101, 1);
        this.f52528f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f52529g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f52525c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f52526d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f52530h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f52528f.setHorizontalScrollBarEnabled(false);
        this.f52528f.setHorizontalScrollbarOverlay(false);
        this.f52528f.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        this.f52528f.getSettings().setJavaScriptEnabled(true);
    }

    public void k(boolean z) {
        this.f52529g.setVisibility(z ? 0 : 8);
    }

    public void l(boolean z) {
        this.f52530h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        d.a.j0.s0.a.a(this.f52523a.getPageContext(), this.f52524b);
        SkinManager.setBgColor(this.f52529g, i2);
        SkinManager.setBackgroundResource(this.f52527e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f52527e, R.color.CAM_X0101, 1);
    }
}
