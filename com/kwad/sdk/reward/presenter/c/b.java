package com.kwad.sdk.reward.presenter.c;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.x;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d.c;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.e;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class b extends g implements b.c, c.a, e.a, com.kwad.sdk.widget.d, Observer {

    /* renamed from: b  reason: collision with root package name */
    public static float f57451b = 0.4548105f;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f57452c;

    /* renamed from: d  reason: collision with root package name */
    public d f57453d;

    /* renamed from: e  reason: collision with root package name */
    public e f57454e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.b.a.a f57455f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f57456g;

    /* renamed from: h  reason: collision with root package name */
    public a f57457h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f57458i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f57459j;
    public int k = 15;
    public long l = -1;
    public boolean m = false;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.download.a.c implements j.b, p.b, Observer {

        /* renamed from: b  reason: collision with root package name */
        public View f57462b;

        /* renamed from: c  reason: collision with root package name */
        public KsAdWebView f57463c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f57464d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f57465e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f57466f;

        /* renamed from: g  reason: collision with root package name */
        public com.kwad.sdk.reward.b.a.a f57467g;

        /* renamed from: h  reason: collision with root package name */
        public x f57468h;

        /* renamed from: i  reason: collision with root package name */
        public b.c f57469i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2142b f57470j;
        @Nullable
        public AdTemplate k;

        public a(KsAdWebView ksAdWebView, View view, com.kwad.sdk.core.download.a.b bVar, com.kwad.sdk.reward.b.a.a aVar, b.c cVar) {
            this.f57462b = view;
            this.f57463c = ksAdWebView;
            this.f57466f = bVar;
            this.f57467g = aVar;
            this.f57469i = cVar;
        }

        private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57464d, this.f57466f, this.f57469i));
            gVar.a(new f(this.f57464d));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f57464d));
            gVar.a(new p(this));
            x xVar = new x();
            this.f57468h = xVar;
            gVar.a(xVar);
            gVar.a(new k(this.f57464d));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57464d));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new j(this.f57464d, this));
            gVar.a(new t(this.f57464d, this.f57466f));
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            if (at.a(str)) {
                c();
                return;
            }
            d();
            be.b(this.f57463c);
            this.f57463c.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.c.b.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onReceivedHttpError: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                    a.this.c();
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57463c);
            this.f57465e = gVar;
            a(gVar);
            this.f57463c.addJavascriptInterface(this.f57465e, "KwaiAd");
            this.f57463c.loadUrl(str);
        }

        private void a(String str, int i2) {
            InterfaceC2142b interfaceC2142b = this.f57470j;
            if (interfaceC2142b != null) {
                interfaceC2142b.a(str, i2);
            }
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f57464d = aVar;
            aVar.a(adTemplate);
            com.kwad.sdk.core.webview.a aVar2 = this.f57464d;
            aVar2.a = 0;
            aVar2.f56327b = null;
            aVar2.f56329d = viewGroup;
            aVar2.f56330e = this.f57463c;
            aVar2.f56328c = null;
            aVar2.f56333h = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            View view = this.f57462b;
            if (view != null) {
                view.setVisibility(0);
            }
            a(false);
        }

        private void d() {
            com.kwad.sdk.core.webview.kwai.g gVar = this.f57465e;
            if (gVar != null) {
                gVar.a();
                this.f57465e = null;
            }
        }

        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i2) {
            a(com.kwad.sdk.core.response.a.a.b(i2), i2);
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            KsAdWebView ksAdWebView = this.f57463c;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.f57463c.getBackground() != null) {
                    this.f57463c.getBackground().setAlpha(0);
                }
            }
            this.k = adTemplate;
            b(adTemplate, viewGroup);
            a(com.kwad.sdk.core.response.a.b.b(this.k));
            com.kwad.sdk.reward.b.a.a aVar = this.f57467g;
            if (aVar != null) {
                aVar.addObserver(this);
            }
            this.f57466f.a(this);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(@NonNull j.a aVar) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onAdFrameValid : " + aVar.toJson());
        }

        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", getClass().getName() + " updatePageStatus: " + aVar);
            if (aVar.a == 1) {
                a(true);
            } else {
                c();
            }
        }

        public void a(InterfaceC2142b interfaceC2142b) {
            this.f57470j = interfaceC2142b;
        }

        public void a(boolean z) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.f57463c;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }

        public void b() {
            com.kwad.sdk.reward.b.a.a aVar = this.f57467g;
            if (aVar != null) {
                aVar.deleteObserver(this);
            }
            this.f57466f.b(this);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            AdTemplate adTemplate = this.k;
            a(adTemplate != null ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.j(adTemplate)) : "立即下载", 100);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            AdTemplate adTemplate = this.k;
            a(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.a(adTemplate), 100);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            AdTemplate adTemplate = this.k;
            a(adTemplate != null ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.j(adTemplate)) : "立即下载", 100);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            AdTemplate adTemplate = this.k;
            a(adTemplate != null ? com.kwad.sdk.core.response.a.a.m(com.kwad.sdk.core.response.a.d.j(adTemplate)) : "立即打开", 100);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            a(com.kwad.sdk.core.response.a.a.a(i2), i2);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "BottomCardWebViewHelper update: " + obj);
            if (obj instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                x xVar = this.f57468h;
                if (xVar != null) {
                    xVar.a(booleanValue);
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.reward.presenter.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2142b {
        void a(String str, int i2);
    }

    /* loaded from: classes3.dex */
    public static class c extends com.kwad.sdk.reward.presenter.a {
        public c() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return (!f() || af.e(q())) ? 8 : 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends a {
        public d(KsAdWebView ksAdWebView, View view, com.kwad.sdk.core.download.a.b bVar, com.kwad.sdk.reward.b.a.a aVar, b.c cVar) {
            super(ksAdWebView, view, bVar, aVar, cVar);
        }
    }

    public b() {
        a((Presenter) new c());
    }

    private void a(View view, boolean z) {
        ((g) this).a.a(q(), z ? 1 : 153, 1);
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        if (!af.e(q())) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) a(R.id.ksad_reward_apk_info_stub)).inflate();
        ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_apk_info_card_native_container);
        this.f57456g = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.f57456g, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new Runnable() { // from class: com.kwad.sdk.reward.presenter.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                kSFrameLayout.getHeight();
            }
        });
        this.f57456g = (ViewGroup) a(R.id.ksad_reward_apk_info_card_native_container);
        com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f57456g);
        this.f57458i = cVar;
        cVar.a(this);
        this.f57458i.a(((g) this).a.f57207g, false);
        a aVar = new a((KsAdWebView) a(R.id.ksad_reward_apk_info_card_h5), this.f57456g, ((g) this).a.l, this.f57455f, this);
        this.f57457h = aVar;
        aVar.a(new InterfaceC2142b() { // from class: com.kwad.sdk.reward.presenter.c.b.2
            @Override // com.kwad.sdk.reward.presenter.c.b.InterfaceC2142b
            public void a(String str, int i2) {
                int i3 = com.kwad.sdk.core.response.a.d.j(((g) b.this).a.f57207g).status;
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i3);
                boolean z = true;
                b.this.f57458i.a(str, i2, (i3 == 1 || i3 == 2 || i3 == 3) ? false : false);
            }
        });
        this.f57457h.a(((g) this).a.f57207g, adBaseFrameLayout);
    }

    private void b(boolean z) {
        com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.m + " completed: " + z);
        if (this.m) {
            return;
        }
        u.a(q(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z) {
            this.m = true;
        }
    }

    private boolean e() {
        com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.l);
        return this.l >= 0 && System.currentTimeMillis() - this.l > ((long) (this.k * 1000));
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onBind");
        if (com.kwad.sdk.core.response.a.d.u(((g) this).a.f57207g)) {
            this.k = com.kwad.sdk.core.config.b.az();
            com.kwad.sdk.utils.x.a().addObserver(this);
            com.kwad.sdk.reward.b.a.a a2 = com.kwad.sdk.reward.b.c.a();
            this.f57455f = a2;
            ((g) this).a.y = a2;
            a2.g();
            com.kwad.sdk.reward.b.a.a.a(this.f57455f, q(), ((g) this).a.f57207g);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.ksad_root_container);
            this.f57452c = (ViewGroup) a(R.id.ksad_activity_apk_info_area_native);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f57452c);
            this.f57459j = cVar;
            cVar.a(this);
            this.f57459j.a(((g) this).a.f57207g, false);
            ((KSFrameLayout) a(R.id.ksad_activity_apk_info_webview_container)).setWidthBasedRatio(false);
            d dVar = new d((KsAdWebView) a(R.id.ksad_activity_apk_info_webview), this.f57452c, ((g) this).a.l, this.f57455f, this);
            this.f57453d = dVar;
            dVar.a(((g) this).a.f57207g, adBaseFrameLayout);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((g) this).a.f57207g);
            e eVar = this.f57454e;
            if (eVar == null) {
                this.f57454e = new e(com.kwad.sdk.core.response.a.a.v(j2));
            } else {
                eVar.a(com.kwad.sdk.core.response.a.a.v(j2));
            }
            this.f57454e.a(q(), this);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.b.c
    public void a(@Nullable b.a aVar) {
    }

    @Override // com.kwad.sdk.reward.d.c.a
    public void a(com.kwad.sdk.reward.d.c cVar, View view, boolean z) {
        ((g) this).a.a(q(), z ? 1 : 153, 1);
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        if (((g) this).a.y == null || !f()) {
            return;
        }
        ((g) this).a.y.h();
        if (com.kwad.sdk.utils.x.a().b()) {
            return;
        }
        this.l = System.currentTimeMillis();
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(((g) this).a.f57207g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.utils.x.a().deleteObserver(this);
        e eVar = this.f57454e;
        if (eVar != null) {
            eVar.a(q());
        }
        a aVar = this.f57457h;
        if (aVar != null) {
            aVar.b();
            this.f57457h = null;
        }
        ((g) this).a.y = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r7.equals("ACTION_APP_GO_TO_BACKGROUND") == false) goto L29;
     */
    @Override // java.util.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Observable observable, Object obj) {
        com.kwad.sdk.reward.b.a.a aVar;
        if (observable.equals(com.kwad.sdk.utils.x.a()) && (obj instanceof String)) {
            String str = (String) obj;
            com.kwad.sdk.reward.b.a.a aVar2 = this.f57455f;
            if (aVar2 == null) {
                return;
            }
            com.kwad.sdk.reward.b.a.a.a(aVar2, q(), ((g) this).a.f57207g);
            char c2 = 0;
            if (!this.f57455f.k()) {
                if ("ACTION_APP_BACK_TO_FOREGROUND".equals(str)) {
                    b(false);
                    return;
                }
                return;
            }
            int hashCode = str.hashCode();
            if (hashCode != -1891028138) {
                if (hashCode == 321925954) {
                }
                c2 = 65535;
            } else {
                if (str.equals("ACTION_APP_BACK_TO_FOREGROUND")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                this.l = System.currentTimeMillis();
            } else if (c2 != 1) {
            } else {
                boolean e2 = e();
                if (e2 && (aVar = this.f57455f) != null) {
                    aVar.j();
                    com.kwad.sdk.reward.d.a().b();
                    ((g) this).a.f57202b.e();
                }
                b(e2);
            }
        }
    }
}
