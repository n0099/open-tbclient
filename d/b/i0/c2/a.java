package d.b.i0.c2;

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
    public PayVcodeActivity f53630a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f53631b;

    /* renamed from: c  reason: collision with root package name */
    public View f53632c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f53633d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53634e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f53635f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53636g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f53637h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f53630a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        k(payVcodeActivity);
    }

    public View d() {
        return this.f53632c;
    }

    public TextView e() {
        return this.f53636g;
    }

    public TextView f() {
        return this.f53634e;
    }

    public ViewGroup h() {
        return this.f53633d;
    }

    public BaseWebView i() {
        return this.f53635f;
    }

    public final void k(PayVcodeActivity payVcodeActivity) {
        this.f53631b = (ViewGroup) this.f53630a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f53630a.findViewById(R.id.payment_performance);
        this.f53634e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f53634e, R.color.CAM_X0101, 1);
        this.f53635f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f53636g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f53632c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f53633d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f53637h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f53635f.setHorizontalScrollBarEnabled(false);
        this.f53635f.setHorizontalScrollbarOverlay(false);
        this.f53635f.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        this.f53635f.getSettings().setJavaScriptEnabled(true);
    }

    public void l(boolean z) {
        this.f53636g.setVisibility(z ? 0 : 8);
    }

    public void m(boolean z) {
        this.f53637h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        d.b.h0.s0.a.a(this.f53630a.getPageContext(), this.f53631b);
        SkinManager.setBgColor(this.f53636g, i);
        SkinManager.setBackgroundResource(this.f53634e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f53634e, R.color.CAM_X0101, 1);
    }
}
