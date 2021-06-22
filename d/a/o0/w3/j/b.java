package d.a.o0.w3.j;

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
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public float f66625a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f66626b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.w3.j.a f66627c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f66628d = null;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f66629e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f66630f = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66631g = null;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r.f0.a f66632h = null;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r.f0.c f66633i = null;
    public boolean j = false;
    public float k = 1.2631578f;
    public Runnable l = new a();
    public Runnable m = new RunnableC1773b();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f66629e != null) {
                b.this.q(false);
                b.this.t();
            }
        }
    }

    /* renamed from: d.a.o0.w3.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1773b implements Runnable {
        public RunnableC1773b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f66626b != null) {
                b.this.f66626b.ShowSoftKeyPadDelay(b.this.f66629e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f66627c.e();
            b.this.f66626b.finish();
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
            if (b.this.f66627c != null) {
                b.this.f66627c.d();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            b.this.q(false);
            b.this.f66626b.showToast(R.string.neterror);
            b.this.f66626b.finish();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (StringUtils.isNull(str) || b.this.f66627c == null) {
                return false;
            }
            if (!b.this.j) {
                b.this.j = true;
                b.this.q(false);
                b.this.t();
                b.this.f66627c.d();
                return true;
            }
            return b.this.f66627c.f(str);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.f66626b.finish();
        }
    }

    public b(AccountAccessActivity accountAccessActivity) {
        this.f66626b = null;
        if (accountAccessActivity == null) {
            return;
        }
        this.f66626b = accountAccessActivity;
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
        return this.f66626b;
    }

    public float h() {
        return this.f66625a;
    }

    public float i() {
        return this.k;
    }

    public WebView j() {
        return this.f66629e;
    }

    public final boolean k(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        View findViewById = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.f66628d = findViewById;
        findViewById.setOnClickListener(new c());
        View findViewById2 = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.f66630f = findViewById2;
        TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
        this.f66631g = textView;
        textView.setText(accountAccessActivity.getResources().getString(R.string.sending));
        d.a.n0.r.f0.c cVar = new d.a.n0.r.f0.c();
        this.f66633i = cVar;
        cVar.f53491a = 1000L;
        this.f66625a = l.k(accountAccessActivity.getBaseContext()) / l.i(accountAccessActivity.getBaseContext());
        if (this.f66629e == null) {
            try {
                this.f66629e = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.f66629e, this.k);
                this.f66629e.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.f66629e.setWebViewClient(new d());
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
        d.a.c.e.m.e.a().removeCallbacks(this.l);
        d.a.c.e.m.e.a().removeCallbacks(this.m);
        this.f66632h = null;
    }

    public void m(d.a.o0.w3.j.a aVar) {
        this.f66627c = aVar;
    }

    public void n(float f2) {
        this.k = f2;
        UtilHelper.setSupportHeight(this.f66626b.getPageContext().getPageActivity(), this.f66629e, f2);
    }

    public void o(int i2, int i3, int i4, int i5) {
        if (this.f66629e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f66629e.getLayoutParams();
            marginLayoutParams.setMargins(i2, i3, i4, i5);
            this.f66629e.setLayoutParams(marginLayoutParams);
        }
    }

    public void p(boolean z) {
        View view = this.f66630f;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void q(boolean z) {
        if (this.f66632h == null) {
            d.a.n0.r.f0.a aVar = new d.a.n0.r.f0.a(this.f66626b.getPageContext());
            this.f66632h = aVar;
            aVar.e(new e());
        }
        this.f66632h.h(z);
    }

    public void r(boolean z) {
        BaseWebView baseWebView = this.f66629e;
        if (baseWebView != null) {
            if (z) {
                baseWebView.setVisibility(0);
            } else {
                baseWebView.setVisibility(4);
            }
        }
    }

    public void s(int i2) {
        d.a.c.e.m.e.a().postDelayed(this.l, i2);
    }

    public void t() {
        BaseActivity baseActivity = this.f66626b;
        if (baseActivity != null) {
            if (this.k == this.f66625a) {
                int i2 = l.i(baseActivity.getBaseContext());
                BaseWebView baseWebView = this.f66629e;
                baseWebView.startAnimation(f(i2 - (baseWebView.getWidth() * 1.2631578f), 0.0f));
                d.a.c.e.m.e.a().postDelayed(this.m, 800L);
                return;
            }
            BaseWebView baseWebView2 = this.f66629e;
            baseWebView2.startAnimation(f(baseWebView2.getHeight(), 0.0f));
        }
    }
}
