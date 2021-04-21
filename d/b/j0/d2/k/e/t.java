package d.b.j0.d2.k.e;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import d.b.i0.r.q.b1;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public View f54728a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f54729b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f54730c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f54731d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f54732e;

    /* renamed from: f  reason: collision with root package name */
    public View f54733f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f54734g;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.d {
        public a(t tVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.e {
        public b(t tVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (t.this.f54734g != null) {
                    t.this.f54734g.destroy();
                    t.this.f54734g = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public t(View view) {
        this.f54728a = view;
        this.f54729b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f54731d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView = this.f54734g;
        if (baseWebView != null) {
            baseWebView.removeAllViews();
            this.f54734g.getSettings().setBuiltInZoomControls(true);
            this.f54734g.setVisibility(8);
            d.b.c.e.m.e.a().postDelayed(new c(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        if (b1Var != null && !ListUtils.isEmpty(b1Var.a()) && (viewStub = this.f54729b) != null) {
            if (this.f54730c == null) {
                this.f54730c = (PbGiftListView) viewStub.inflate();
            }
            this.f54730c.setVisibility(0);
            this.f54730c.g(b1Var, str, str2, j, j2, j3);
            this.f54730c.i();
            return;
        }
        PbGiftListView pbGiftListView = this.f54730c;
        if (pbGiftListView != null) {
            pbGiftListView.setVisibility(8);
        }
    }

    public void c(d.b.i0.r.q.p0 p0Var) {
        if (p0Var == null || d.b.c.e.p.k.isEmpty(p0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f54734g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && p0Var.c() == d.b.i0.r.q.p0.f51598g && this.f54731d != null) {
            if (p0Var.f()) {
                LinearLayout linearLayout = this.f54732e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f54732e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f54731d.inflate();
                this.f54732e = linearLayout2;
                this.f54733f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f54734g = (BaseWebView) this.f54732e.findViewById(R.id.link_thread_webview);
            }
            this.f54733f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f54733f, R.color.CAM_X0204);
            this.f54734g.setVisibility(0);
            this.f54734g.setFocusable(false);
            this.f54734g.setBackgroundColor(0);
            this.f54734g.getSettings().setCacheMode(-1);
            this.f54734g.setVerticalScrollBarEnabled(false);
            this.f54734g.setHorizontalScrollBarEnabled(false);
            this.f54734g.getSettings().setAllowFileAccess(true);
            this.f54734g.getSettings().setAppCacheEnabled(true);
            this.f54734g.getSettings().setDomStorageEnabled(true);
            this.f54734g.getSettings().setDatabaseEnabled(true);
            this.f54734g.setOnLoadUrlListener(new a(this));
            this.f54734g.setOnPageFinishedListener(new b(this));
            this.f54734g.loadUrl(p0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView = this.f54734g;
        if (baseWebView != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView = this.f54734g;
        if (baseWebView != null) {
            try {
                baseWebView.onResume();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(int i) {
    }
}
