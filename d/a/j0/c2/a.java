package d.a.j0.c2;

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
public class a extends d.a.c.a.d<PayVcodeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f51824a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f51825b;

    /* renamed from: c  reason: collision with root package name */
    public View f51826c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f51827d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51828e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f51829f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51830g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f51831h;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.f51824a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        j(payVcodeActivity);
    }

    public View d() {
        return this.f51826c;
    }

    public TextView e() {
        return this.f51830g;
    }

    public TextView f() {
        return this.f51828e;
    }

    public ViewGroup g() {
        return this.f51827d;
    }

    public BaseWebView h() {
        return this.f51829f;
    }

    public final void j(PayVcodeActivity payVcodeActivity) {
        this.f51825b = (ViewGroup) this.f51824a.findViewById(R.id.payvcode_parent);
        TextView textView = (TextView) this.f51824a.findViewById(R.id.payment_performance);
        this.f51828e = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f51828e, R.color.CAM_X0101, 1);
        this.f51829f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.f51830g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.f51826c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.f51827d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.f51831h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.f51829f.setHorizontalScrollBarEnabled(false);
        this.f51829f.setHorizontalScrollbarOverlay(false);
        this.f51829f.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        this.f51829f.getSettings().setJavaScriptEnabled(true);
    }

    public void k(boolean z) {
        this.f51830g.setVisibility(z ? 0 : 8);
    }

    public void l(boolean z) {
        this.f51831h.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        d.a.i0.s0.a.a(this.f51824a.getPageContext(), this.f51825b);
        SkinManager.setBgColor(this.f51830g, i2);
        SkinManager.setBackgroundResource(this.f51828e, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.f51828e, R.color.CAM_X0101, 1);
    }
}
