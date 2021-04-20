package d.b.i0.d2.k.e;

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
import d.b.h0.r.q.b1;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public View f54307a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f54308b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f54309c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f54310d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f54311e;

    /* renamed from: f  reason: collision with root package name */
    public View f54312f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f54313g;

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
                if (t.this.f54313g != null) {
                    t.this.f54313g.destroy();
                    t.this.f54313g = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public t(View view) {
        this.f54307a = view;
        this.f54308b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f54310d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView = this.f54313g;
        if (baseWebView != null) {
            baseWebView.removeAllViews();
            this.f54313g.getSettings().setBuiltInZoomControls(true);
            this.f54313g.setVisibility(8);
            d.b.c.e.m.e.a().postDelayed(new c(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        if (b1Var != null && !ListUtils.isEmpty(b1Var.a()) && (viewStub = this.f54308b) != null) {
            if (this.f54309c == null) {
                this.f54309c = (PbGiftListView) viewStub.inflate();
            }
            this.f54309c.setVisibility(0);
            this.f54309c.g(b1Var, str, str2, j, j2, j3);
            this.f54309c.i();
            return;
        }
        PbGiftListView pbGiftListView = this.f54309c;
        if (pbGiftListView != null) {
            pbGiftListView.setVisibility(8);
        }
    }

    public void c(d.b.h0.r.q.p0 p0Var) {
        if (p0Var == null || d.b.c.e.p.k.isEmpty(p0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f54313g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && p0Var.c() == d.b.h0.r.q.p0.f51262g && this.f54310d != null) {
            if (p0Var.f()) {
                LinearLayout linearLayout = this.f54311e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f54311e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f54310d.inflate();
                this.f54311e = linearLayout2;
                this.f54312f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f54313g = (BaseWebView) this.f54311e.findViewById(R.id.link_thread_webview);
            }
            this.f54312f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f54312f, R.color.CAM_X0204);
            this.f54313g.setVisibility(0);
            this.f54313g.setFocusable(false);
            this.f54313g.setBackgroundColor(0);
            this.f54313g.getSettings().setCacheMode(-1);
            this.f54313g.setVerticalScrollBarEnabled(false);
            this.f54313g.setHorizontalScrollBarEnabled(false);
            this.f54313g.getSettings().setAllowFileAccess(true);
            this.f54313g.getSettings().setAppCacheEnabled(true);
            this.f54313g.getSettings().setDomStorageEnabled(true);
            this.f54313g.getSettings().setDatabaseEnabled(true);
            this.f54313g.setOnLoadUrlListener(new a(this));
            this.f54313g.setOnPageFinishedListener(new b(this));
            this.f54313g.loadUrl(p0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView = this.f54313g;
        if (baseWebView != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView = this.f54313g;
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
