package d.b.j0.v3.k;

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
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public float f63723a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f63724b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.v3.k.a f63725c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f63726d = null;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f63727e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f63728f = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63729g = null;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.r.f0.a f63730h = null;
    public d.b.i0.r.f0.c i = null;
    public boolean j = false;
    public float k = 1.2631578f;
    public Runnable l = new a();
    public Runnable m = new RunnableC1697b();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f63727e != null) {
                b.this.q(false);
                b.this.t();
            }
        }
    }

    /* renamed from: d.b.j0.v3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1697b implements Runnable {
        public RunnableC1697b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f63724b != null) {
                b.this.f63724b.ShowSoftKeyPadDelay(b.this.f63727e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f63725c.e();
            b.this.f63724b.finish();
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
            if (b.this.f63725c != null) {
                b.this.f63725c.d();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            b.this.q(false);
            b.this.f63724b.showToast(R.string.neterror);
            b.this.f63724b.finish();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (StringUtils.isNull(str) || b.this.f63725c == null) {
                return false;
            }
            if (!b.this.j) {
                b.this.j = true;
                b.this.q(false);
                b.this.t();
                b.this.f63725c.d();
                return true;
            }
            return b.this.f63725c.f(str);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.f63724b.finish();
        }
    }

    public b(AccountAccessActivity accountAccessActivity) {
        this.f63724b = null;
        if (accountAccessActivity == null) {
            return;
        }
        this.f63724b = accountAccessActivity;
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
        return this.f63724b;
    }

    public float h() {
        return this.f63723a;
    }

    public float i() {
        return this.k;
    }

    public WebView j() {
        return this.f63727e;
    }

    public final boolean k(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        View findViewById = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.f63726d = findViewById;
        findViewById.setOnClickListener(new c());
        View findViewById2 = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.f63728f = findViewById2;
        TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
        this.f63729g = textView;
        textView.setText(accountAccessActivity.getResources().getString(R.string.sending));
        d.b.i0.r.f0.c cVar = new d.b.i0.r.f0.c();
        this.i = cVar;
        cVar.f51227a = 1000L;
        this.f63723a = l.k(accountAccessActivity.getBaseContext()) / l.i(accountAccessActivity.getBaseContext());
        if (this.f63727e == null) {
            try {
                this.f63727e = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.f63727e, this.k);
                this.f63727e.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.f63727e.setWebViewClient(new d());
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
        d.b.c.e.m.e.a().removeCallbacks(this.l);
        d.b.c.e.m.e.a().removeCallbacks(this.m);
        this.f63730h = null;
    }

    public void m(d.b.j0.v3.k.a aVar) {
        this.f63725c = aVar;
    }

    public void n(float f2) {
        this.k = f2;
        UtilHelper.setSupportHeight(this.f63724b.getPageContext().getPageActivity(), this.f63727e, f2);
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.f63727e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f63727e.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.f63727e.setLayoutParams(marginLayoutParams);
        }
    }

    public void p(boolean z) {
        View view = this.f63728f;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void q(boolean z) {
        if (this.f63730h == null) {
            d.b.i0.r.f0.a aVar = new d.b.i0.r.f0.a(this.f63724b.getPageContext());
            this.f63730h = aVar;
            aVar.e(new e());
        }
        this.f63730h.h(z);
    }

    public void r(boolean z) {
        BaseWebView baseWebView = this.f63727e;
        if (baseWebView != null) {
            if (z) {
                baseWebView.setVisibility(0);
            } else {
                baseWebView.setVisibility(4);
            }
        }
    }

    public void s(int i) {
        d.b.c.e.m.e.a().postDelayed(this.l, i);
    }

    public void t() {
        BaseActivity baseActivity = this.f63724b;
        if (baseActivity != null) {
            if (this.k == this.f63723a) {
                int i = l.i(baseActivity.getBaseContext());
                BaseWebView baseWebView = this.f63727e;
                baseWebView.startAnimation(f(i - (baseWebView.getWidth() * 1.2631578f), 0.0f));
                d.b.c.e.m.e.a().postDelayed(this.m, 800L);
                return;
            }
            BaseWebView baseWebView2 = this.f63727e;
            baseWebView2.startAnimation(f(baseWebView2.getHeight(), 0.0f));
        }
    }
}
