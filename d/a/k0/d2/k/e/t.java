package d.a.k0.d2.k.e;

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
import d.a.j0.r.q.b1;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public View f53243a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f53244b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f53245c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f53246d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f53247e;

    /* renamed from: f  reason: collision with root package name */
    public View f53248f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f53249g;

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
                if (t.this.f53249g != null) {
                    t.this.f53249g.destroy();
                    t.this.f53249g = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public t(View view) {
        this.f53243a = view;
        this.f53244b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f53246d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView = this.f53249g;
        if (baseWebView != null) {
            baseWebView.removeAllViews();
            this.f53249g.getSettings().setBuiltInZoomControls(true);
            this.f53249g.setVisibility(8);
            d.a.c.e.m.e.a().postDelayed(new c(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        if (b1Var != null && !ListUtils.isEmpty(b1Var.a()) && (viewStub = this.f53244b) != null) {
            if (this.f53245c == null) {
                this.f53245c = (PbGiftListView) viewStub.inflate();
            }
            this.f53245c.setVisibility(0);
            this.f53245c.g(b1Var, str, str2, j, j2, j3);
            this.f53245c.i();
            return;
        }
        PbGiftListView pbGiftListView = this.f53245c;
        if (pbGiftListView != null) {
            pbGiftListView.setVisibility(8);
        }
    }

    public void c(d.a.j0.r.q.p0 p0Var) {
        if (p0Var == null || d.a.c.e.p.k.isEmpty(p0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f53249g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && p0Var.c() == d.a.j0.r.q.p0.f50048g && this.f53246d != null) {
            if (p0Var.f()) {
                LinearLayout linearLayout = this.f53247e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f53247e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f53246d.inflate();
                this.f53247e = linearLayout2;
                this.f53248f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f53249g = (BaseWebView) this.f53247e.findViewById(R.id.link_thread_webview);
            }
            this.f53248f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f53248f, R.color.CAM_X0204);
            this.f53249g.setVisibility(0);
            this.f53249g.setFocusable(false);
            this.f53249g.setBackgroundColor(0);
            this.f53249g.getSettings().setCacheMode(-1);
            this.f53249g.setVerticalScrollBarEnabled(false);
            this.f53249g.setHorizontalScrollBarEnabled(false);
            this.f53249g.getSettings().setAllowFileAccess(true);
            this.f53249g.getSettings().setAppCacheEnabled(true);
            this.f53249g.getSettings().setDomStorageEnabled(true);
            this.f53249g.getSettings().setDatabaseEnabled(true);
            this.f53249g.setOnLoadUrlListener(new a(this));
            this.f53249g.setOnPageFinishedListener(new b(this));
            this.f53249g.loadUrl(p0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView = this.f53249g;
        if (baseWebView != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView = this.f53249g;
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
