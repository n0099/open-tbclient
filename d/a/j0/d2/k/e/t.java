package d.a.j0.d2.k.e;

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
import d.a.i0.r.q.b1;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public View f52540a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f52541b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f52542c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f52543d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52544e;

    /* renamed from: f  reason: collision with root package name */
    public View f52545f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f52546g;

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
                if (t.this.f52546g != null) {
                    t.this.f52546g.destroy();
                    t.this.f52546g = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public t(View view) {
        this.f52540a = view;
        this.f52541b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f52543d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView = this.f52546g;
        if (baseWebView != null) {
            baseWebView.removeAllViews();
            this.f52546g.getSettings().setBuiltInZoomControls(true);
            this.f52546g.setVisibility(8);
            d.a.c.e.m.e.a().postDelayed(new c(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        if (b1Var != null && !ListUtils.isEmpty(b1Var.a()) && (viewStub = this.f52541b) != null) {
            if (this.f52542c == null) {
                this.f52542c = (PbGiftListView) viewStub.inflate();
            }
            this.f52542c.setVisibility(0);
            this.f52542c.g(b1Var, str, str2, j, j2, j3);
            this.f52542c.i();
            return;
        }
        PbGiftListView pbGiftListView = this.f52542c;
        if (pbGiftListView != null) {
            pbGiftListView.setVisibility(8);
        }
    }

    public void c(d.a.i0.r.q.p0 p0Var) {
        if (p0Var == null || d.a.c.e.p.k.isEmpty(p0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f52546g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && p0Var.c() == d.a.i0.r.q.p0.f49229g && this.f52543d != null) {
            if (p0Var.f()) {
                LinearLayout linearLayout = this.f52544e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f52544e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f52543d.inflate();
                this.f52544e = linearLayout2;
                this.f52545f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f52546g = (BaseWebView) this.f52544e.findViewById(R.id.link_thread_webview);
            }
            this.f52545f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f52545f, R.color.CAM_X0204);
            this.f52546g.setVisibility(0);
            this.f52546g.setFocusable(false);
            this.f52546g.setBackgroundColor(0);
            this.f52546g.getSettings().setCacheMode(-1);
            this.f52546g.setVerticalScrollBarEnabled(false);
            this.f52546g.setHorizontalScrollBarEnabled(false);
            this.f52546g.getSettings().setAllowFileAccess(true);
            this.f52546g.getSettings().setAppCacheEnabled(true);
            this.f52546g.getSettings().setDomStorageEnabled(true);
            this.f52546g.getSettings().setDatabaseEnabled(true);
            this.f52546g.setOnLoadUrlListener(new a(this));
            this.f52546g.setOnPageFinishedListener(new b(this));
            this.f52546g.loadUrl(p0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView = this.f52546g;
        if (baseWebView != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView = this.f52546g;
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
