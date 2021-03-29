package d.b.i0.c2.k.e;

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
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public View f52812a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f52813b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f52814c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f52815d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52816e;

    /* renamed from: f  reason: collision with root package name */
    public View f52817f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f52818g;

    /* loaded from: classes4.dex */
    public class a implements BaseWebView.d {
        public a(r rVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BaseWebView.e {
        public b(r rVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (r.this.f52818g != null) {
                    r.this.f52818g.destroy();
                    r.this.f52818g = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public r(View view) {
        this.f52812a = view;
        this.f52813b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f52815d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView = this.f52818g;
        if (baseWebView != null) {
            baseWebView.removeAllViews();
            this.f52818g.getSettings().setBuiltInZoomControls(true);
            this.f52818g.setVisibility(8);
            d.b.b.e.m.e.a().postDelayed(new c(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        if (b1Var != null && !ListUtils.isEmpty(b1Var.a()) && (viewStub = this.f52813b) != null) {
            if (this.f52814c == null) {
                this.f52814c = (PbGiftListView) viewStub.inflate();
            }
            this.f52814c.setVisibility(0);
            this.f52814c.g(b1Var, str, str2, j, j2, j3);
            this.f52814c.i();
            return;
        }
        PbGiftListView pbGiftListView = this.f52814c;
        if (pbGiftListView != null) {
            pbGiftListView.setVisibility(8);
        }
    }

    public void c(d.b.h0.r.q.p0 p0Var) {
        if (p0Var == null || d.b.b.e.p.k.isEmpty(p0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f52818g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && p0Var.c() == d.b.h0.r.q.p0.f50855g && this.f52815d != null) {
            if (p0Var.f()) {
                LinearLayout linearLayout = this.f52816e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f52816e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f52815d.inflate();
                this.f52816e = linearLayout2;
                this.f52817f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f52818g = (BaseWebView) this.f52816e.findViewById(R.id.link_thread_webview);
            }
            this.f52817f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f52817f, R.color.CAM_X0204);
            this.f52818g.setVisibility(0);
            this.f52818g.setFocusable(false);
            this.f52818g.setBackgroundColor(0);
            this.f52818g.getSettings().setCacheMode(-1);
            this.f52818g.setVerticalScrollBarEnabled(false);
            this.f52818g.setHorizontalScrollBarEnabled(false);
            this.f52818g.getSettings().setAllowFileAccess(true);
            this.f52818g.getSettings().setAppCacheEnabled(true);
            this.f52818g.getSettings().setDomStorageEnabled(true);
            this.f52818g.getSettings().setDatabaseEnabled(true);
            this.f52818g.setOnLoadUrlListener(new a(this));
            this.f52818g.setOnPageFinishedListener(new b(this));
            this.f52818g.loadUrl(p0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView = this.f52818g;
        if (baseWebView != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView = this.f52818g;
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
