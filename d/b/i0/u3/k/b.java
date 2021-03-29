package d.b.i0.u3.k;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public float f61564a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61565b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.u3.k.a f61566c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f61567d = null;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f61568e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f61569f = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61570g = null;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.r.f0.a f61571h = null;
    public d.b.h0.r.f0.c i = null;
    public boolean j = false;
    public float k = 1.2631578f;
    public Runnable l = new a();
    public Runnable m = new RunnableC1614b();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f61568e != null) {
                b.this.q(false);
                b.this.t();
            }
        }
    }

    /* renamed from: d.b.i0.u3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1614b implements Runnable {
        public RunnableC1614b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f61565b != null) {
                b.this.f61565b.ShowSoftKeyPadDelay(b.this.f61568e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f61566c.e();
            b.this.f61565b.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            b.this.j = true;
            if (b.this.f61566c != null) {
                b.this.f61566c.d();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            b.this.q(false);
            b.this.f61565b.showToast(R.string.neterror);
            b.this.f61565b.finish();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (StringUtils.isNull(str) || b.this.f61566c == null) {
                return false;
            }
            if (!b.this.j) {
                b.this.j = true;
                b.this.q(false);
                b.this.t();
                b.this.f61566c.d();
                return true;
            }
            return b.this.f61566c.f(str);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.f61565b.finish();
        }
    }

    public b(AccountAccessActivity accountAccessActivity) {
        this.f61565b = null;
        if (accountAccessActivity == null) {
            return;
        }
        this.f61565b = accountAccessActivity;
        if (k(accountAccessActivity)) {
            return;
        }
        accountAccessActivity.finish();
    }

    public Animation f(float f2, float f3) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f2, f3);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public BaseActivity g() {
        return this.f61565b;
    }

    public float h() {
        return this.f61564a;
    }

    public float i() {
        return this.k;
    }

    public WebView j() {
        return this.f61568e;
    }

    public final boolean k(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        View findViewById = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.f61567d = findViewById;
        findViewById.setOnClickListener(new c());
        View findViewById2 = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.f61569f = findViewById2;
        TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
        this.f61570g = textView;
        textView.setText(accountAccessActivity.getResources().getString(R.string.sending));
        d.b.h0.r.f0.c cVar = new d.b.h0.r.f0.c();
        this.i = cVar;
        cVar.f50484a = 1000L;
        this.f61564a = l.k(accountAccessActivity.getBaseContext()) / l.i(accountAccessActivity.getBaseContext());
        if (this.f61568e == null) {
            try {
                this.f61568e = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.f61568e, this.k);
                this.f61568e.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.f61568e.setWebViewClient(new d());
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    public void l() {
        d.b.b.e.m.e.a().removeCallbacks(this.l);
        d.b.b.e.m.e.a().removeCallbacks(this.m);
        this.f61571h = null;
    }

    public void m(d.b.i0.u3.k.a aVar) {
        this.f61566c = aVar;
    }

    public void n(float f2) {
        this.k = f2;
        UtilHelper.setSupportHeight(this.f61565b.getPageContext().getPageActivity(), this.f61568e, f2);
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.f61568e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f61568e.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.f61568e.setLayoutParams(marginLayoutParams);
        }
    }

    public void p(boolean z) {
        View view = this.f61569f;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void q(boolean z) {
        if (this.f61571h == null) {
            d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(this.f61565b.getPageContext());
            this.f61571h = aVar;
            aVar.e(new e());
        }
        this.f61571h.h(z);
    }

    public void r(boolean z) {
        BaseWebView baseWebView = this.f61568e;
        if (baseWebView != null) {
            if (z) {
                baseWebView.setVisibility(0);
            } else {
                baseWebView.setVisibility(4);
            }
        }
    }

    public void s(int i) {
        d.b.b.e.m.e.a().postDelayed(this.l, i);
    }

    public void t() {
        BaseActivity baseActivity = this.f61565b;
        if (baseActivity != null) {
            if (this.k == this.f61564a) {
                int i = l.i(baseActivity.getBaseContext());
                BaseWebView baseWebView = this.f61568e;
                baseWebView.startAnimation(f(i - (baseWebView.getWidth() * 1.2631578f), 0.0f));
                d.b.b.e.m.e.a().postDelayed(this.m, 800L);
                return;
            }
            BaseWebView baseWebView2 = this.f61568e;
            baseWebView2.startAnimation(f(baseWebView2.getHeight(), 0.0f));
        }
    }
}
