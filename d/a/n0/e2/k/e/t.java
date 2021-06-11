package d.a.n0.e2.k.e;

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
import d.a.m0.r.q.b1;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public View f57121a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f57122b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f57123c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f57124d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f57125e;

    /* renamed from: f  reason: collision with root package name */
    public View f57126f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f57127g;

    /* loaded from: classes5.dex */
    public class a implements BaseWebView.d {
        public a(t tVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BaseWebView.e {
        public b(t tVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (t.this.f57127g != null) {
                    t.this.f57127g.destroy();
                    t.this.f57127g = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public t(View view) {
        this.f57121a = view;
        this.f57122b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f57124d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView = this.f57127g;
        if (baseWebView != null) {
            baseWebView.removeAllViews();
            this.f57127g.getSettings().setBuiltInZoomControls(true);
            this.f57127g.setVisibility(8);
            d.a.c.e.m.e.a().postDelayed(new c(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        if (b1Var != null && !ListUtils.isEmpty(b1Var.a()) && (viewStub = this.f57122b) != null) {
            if (this.f57123c == null) {
                this.f57123c = (PbGiftListView) viewStub.inflate();
            }
            this.f57123c.setVisibility(0);
            this.f57123c.g(b1Var, str, str2, j, j2, j3);
            this.f57123c.i();
            return;
        }
        PbGiftListView pbGiftListView = this.f57123c;
        if (pbGiftListView != null) {
            pbGiftListView.setVisibility(8);
        }
    }

    public void c(d.a.m0.r.q.p0 p0Var) {
        if (p0Var == null || d.a.c.e.p.k.isEmpty(p0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f57127g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && p0Var.c() == d.a.m0.r.q.p0.f53768g && this.f57124d != null) {
            if (p0Var.f()) {
                LinearLayout linearLayout = this.f57125e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f57125e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f57124d.inflate();
                this.f57125e = linearLayout2;
                this.f57126f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f57127g = (BaseWebView) this.f57125e.findViewById(R.id.link_thread_webview);
            }
            this.f57126f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f57126f, R.color.CAM_X0204);
            this.f57127g.setVisibility(0);
            this.f57127g.setFocusable(false);
            this.f57127g.setBackgroundColor(0);
            this.f57127g.getSettings().setCacheMode(-1);
            this.f57127g.setVerticalScrollBarEnabled(false);
            this.f57127g.setHorizontalScrollBarEnabled(false);
            this.f57127g.getSettings().setAllowFileAccess(true);
            this.f57127g.getSettings().setAppCacheEnabled(true);
            this.f57127g.getSettings().setDomStorageEnabled(true);
            this.f57127g.getSettings().setDatabaseEnabled(true);
            this.f57127g.setOnLoadUrlListener(new a(this));
            this.f57127g.setOnPageFinishedListener(new b(this));
            this.f57127g.loadUrl(p0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView = this.f57127g;
        if (baseWebView != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView = this.f57127g;
        if (baseWebView != null) {
            try {
                baseWebView.onResume();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(int i2) {
    }
}
