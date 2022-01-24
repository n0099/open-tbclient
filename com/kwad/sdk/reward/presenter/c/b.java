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
    public static float f57496b = 0.4548105f;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f57497c;

    /* renamed from: d  reason: collision with root package name */
    public d f57498d;

    /* renamed from: e  reason: collision with root package name */
    public e f57499e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.b.a.a f57500f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f57501g;

    /* renamed from: h  reason: collision with root package name */
    public a f57502h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f57503i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f57504j;
    public int k = 15;
    public long l = -1;
    public boolean m = false;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.download.a.c implements j.b, p.b, Observer {

        /* renamed from: b  reason: collision with root package name */
        public View f57507b;

        /* renamed from: c  reason: collision with root package name */
        public KsAdWebView f57508c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f57509d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f57510e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f57511f;

        /* renamed from: g  reason: collision with root package name */
        public com.kwad.sdk.reward.b.a.a f57512g;

        /* renamed from: h  reason: collision with root package name */
        public x f57513h;

        /* renamed from: i  reason: collision with root package name */
        public b.c f57514i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2148b f57515j;
        @Nullable
        public AdTemplate k;

        public a(KsAdWebView ksAdWebView, View view, com.kwad.sdk.core.download.a.b bVar, com.kwad.sdk.reward.b.a.a aVar, b.c cVar) {
            this.f57507b = view;
            this.f57508c = ksAdWebView;
            this.f57511f = bVar;
            this.f57512g = aVar;
            this.f57514i = cVar;
        }

        private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57509d, this.f57511f, this.f57514i));
            gVar.a(new f(this.f57509d));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f57509d));
            gVar.a(new p(this));
            x xVar = new x();
            this.f57513h = xVar;
            gVar.a(xVar);
            gVar.a(new k(this.f57509d));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57509d));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new j(this.f57509d, this));
            gVar.a(new t(this.f57509d, this.f57511f));
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            if (at.a(str)) {
                c();
                return;
            }
            d();
            be.b(this.f57508c);
            this.f57508c.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.c.b.a.1
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
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57508c);
            this.f57510e = gVar;
            a(gVar);
            this.f57508c.addJavascriptInterface(this.f57510e, "KwaiAd");
            this.f57508c.loadUrl(str);
        }

        private void a(String str, int i2) {
            InterfaceC2148b interfaceC2148b = this.f57515j;
            if (interfaceC2148b != null) {
                interfaceC2148b.a(str, i2);
            }
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f57509d = aVar;
            aVar.a(adTemplate);
            com.kwad.sdk.core.webview.a aVar2 = this.f57509d;
            aVar2.a = 0;
            aVar2.f56372b = null;
            aVar2.f56374d = viewGroup;
            aVar2.f56375e = this.f57508c;
            aVar2.f56373c = null;
            aVar2.f56378h = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            View view = this.f57507b;
            if (view != null) {
                view.setVisibility(0);
            }
            a(false);
        }

        private void d() {
            com.kwad.sdk.core.webview.kwai.g gVar = this.f57510e;
            if (gVar != null) {
                gVar.a();
                this.f57510e = null;
            }
        }

        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i2) {
            a(com.kwad.sdk.core.response.a.a.b(i2), i2);
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            KsAdWebView ksAdWebView = this.f57508c;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.f57508c.getBackground() != null) {
                    this.f57508c.getBackground().setAlpha(0);
                }
            }
            this.k = adTemplate;
            b(adTemplate, viewGroup);
            a(com.kwad.sdk.core.response.a.b.b(this.k));
            com.kwad.sdk.reward.b.a.a aVar = this.f57512g;
            if (aVar != null) {
                aVar.addObserver(this);
            }
            this.f57511f.a(this);
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

        public void a(InterfaceC2148b interfaceC2148b) {
            this.f57515j = interfaceC2148b;
        }

        public void a(boolean z) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.f57508c;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }

        public void b() {
            com.kwad.sdk.reward.b.a.a aVar = this.f57512g;
            if (aVar != null) {
                aVar.deleteObserver(this);
            }
            this.f57511f.b(this);
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
                x xVar = this.f57513h;
                if (xVar != null) {
                    xVar.a(booleanValue);
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.reward.presenter.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2148b {
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
        this.f57501g = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.f57501g, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new Runnable() { // from class: com.kwad.sdk.reward.presenter.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                kSFrameLayout.getHeight();
            }
        });
        this.f57501g = (ViewGroup) a(R.id.ksad_reward_apk_info_card_native_container);
        com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f57501g);
        this.f57503i = cVar;
        cVar.a(this);
        this.f57503i.a(((g) this).a.f57252g, false);
        a aVar = new a((KsAdWebView) a(R.id.ksad_reward_apk_info_card_h5), this.f57501g, ((g) this).a.l, this.f57500f, this);
        this.f57502h = aVar;
        aVar.a(new InterfaceC2148b() { // from class: com.kwad.sdk.reward.presenter.c.b.2
            @Override // com.kwad.sdk.reward.presenter.c.b.InterfaceC2148b
            public void a(String str, int i2) {
                int i3 = com.kwad.sdk.core.response.a.d.j(((g) b.this).a.f57252g).status;
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i3);
                boolean z = true;
                b.this.f57503i.a(str, i2, (i3 == 1 || i3 == 2 || i3 == 3) ? false : false);
            }
        });
        this.f57502h.a(((g) this).a.f57252g, adBaseFrameLayout);
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
        if (com.kwad.sdk.core.response.a.d.u(((g) this).a.f57252g)) {
            this.k = com.kwad.sdk.core.config.b.az();
            com.kwad.sdk.utils.x.a().addObserver(this);
            com.kwad.sdk.reward.b.a.a a2 = com.kwad.sdk.reward.b.c.a();
            this.f57500f = a2;
            ((g) this).a.y = a2;
            a2.g();
            com.kwad.sdk.reward.b.a.a.a(this.f57500f, q(), ((g) this).a.f57252g);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.ksad_root_container);
            this.f57497c = (ViewGroup) a(R.id.ksad_activity_apk_info_area_native);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f57497c);
            this.f57504j = cVar;
            cVar.a(this);
            this.f57504j.a(((g) this).a.f57252g, false);
            ((KSFrameLayout) a(R.id.ksad_activity_apk_info_webview_container)).setWidthBasedRatio(false);
            d dVar = new d((KsAdWebView) a(R.id.ksad_activity_apk_info_webview), this.f57497c, ((g) this).a.l, this.f57500f, this);
            this.f57498d = dVar;
            dVar.a(((g) this).a.f57252g, adBaseFrameLayout);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((g) this).a.f57252g);
            e eVar = this.f57499e;
            if (eVar == null) {
                this.f57499e = new e(com.kwad.sdk.core.response.a.a.v(j2));
            } else {
                eVar.a(com.kwad.sdk.core.response.a.a.v(j2));
            }
            this.f57499e.a(q(), this);
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
        if (com.kwad.sdk.core.response.a.c.g(((g) this).a.f57252g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.utils.x.a().deleteObserver(this);
        e eVar = this.f57499e;
        if (eVar != null) {
            eVar.a(q());
        }
        a aVar = this.f57502h;
        if (aVar != null) {
            aVar.b();
            this.f57502h = null;
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
            com.kwad.sdk.reward.b.a.a aVar2 = this.f57500f;
            if (aVar2 == null) {
                return;
            }
            com.kwad.sdk.reward.b.a.a.a(aVar2, q(), ((g) this).a.f57252g);
            char c2 = 0;
            if (!this.f57500f.k()) {
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
                if (e2 && (aVar = this.f57500f) != null) {
                    aVar.j();
                    com.kwad.sdk.reward.d.a().b();
                    ((g) this).a.f57247b.e();
                }
                b(e2);
            }
        }
    }
}
