package com.kwad.sdk.reward.presenter.c;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class b extends g implements b.c, c.a, e.a, com.kwad.sdk.widget.d, Observer {

    /* renamed from: b  reason: collision with root package name */
    public static float f40968b = 0.4548105f;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f40969c;

    /* renamed from: d  reason: collision with root package name */
    public d f40970d;

    /* renamed from: e  reason: collision with root package name */
    public e f40971e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.b.a.a f40972f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f40973g;

    /* renamed from: h  reason: collision with root package name */
    public a f40974h;
    public com.kwad.sdk.reward.d.c i;
    public com.kwad.sdk.reward.d.c j;
    public int k = 15;
    public long l = -1;
    public boolean m = false;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.download.a.c implements j.b, p.b, Observer {

        /* renamed from: b  reason: collision with root package name */
        public View f40977b;

        /* renamed from: c  reason: collision with root package name */
        public KsAdWebView f40978c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f40979d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f40980e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f40981f;

        /* renamed from: g  reason: collision with root package name */
        public com.kwad.sdk.reward.b.a.a f40982g;

        /* renamed from: h  reason: collision with root package name */
        public x f40983h;
        public b.c i;
        public InterfaceC1998b j;
        @Nullable
        public AdTemplate k;

        public a(KsAdWebView ksAdWebView, View view, com.kwad.sdk.core.download.a.b bVar, com.kwad.sdk.reward.b.a.a aVar, b.c cVar) {
            this.f40977b = view;
            this.f40978c = ksAdWebView;
            this.f40981f = bVar;
            this.f40982g = aVar;
            this.i = cVar;
        }

        private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f40979d, this.f40981f, this.i));
            gVar.a(new f(this.f40979d));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f40979d));
            gVar.a(new p(this));
            x xVar = new x();
            this.f40983h = xVar;
            gVar.a(xVar);
            gVar.a(new k(this.f40979d));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f40979d));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new j(this.f40979d, this));
            gVar.a(new t(this.f40979d, this.f40981f));
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            if (at.a(str)) {
                c();
                return;
            }
            d();
            be.b(this.f40978c);
            this.f40978c.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.c.b.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i, String str2, String str3) {
                    com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onReceivedHttpError: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                    a.this.c();
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f40978c);
            this.f40980e = gVar;
            a(gVar);
            this.f40978c.addJavascriptInterface(this.f40980e, "KwaiAd");
            this.f40978c.loadUrl(str);
        }

        private void a(String str, int i) {
            InterfaceC1998b interfaceC1998b = this.j;
            if (interfaceC1998b != null) {
                interfaceC1998b.a(str, i);
            }
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f40979d = aVar;
            aVar.a(adTemplate);
            com.kwad.sdk.core.webview.a aVar2 = this.f40979d;
            aVar2.a = 0;
            aVar2.f39981b = null;
            aVar2.f39983d = viewGroup;
            aVar2.f39984e = this.f40978c;
            aVar2.f39982c = null;
            aVar2.f39987h = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            View view = this.f40977b;
            if (view != null) {
                view.setVisibility(0);
            }
            a(false);
        }

        private void d() {
            com.kwad.sdk.core.webview.kwai.g gVar = this.f40980e;
            if (gVar != null) {
                gVar.a();
                this.f40980e = null;
            }
        }

        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i) {
            a(com.kwad.sdk.core.response.a.a.b(i), i);
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            KsAdWebView ksAdWebView = this.f40978c;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.f40978c.getBackground() != null) {
                    this.f40978c.getBackground().setAlpha(0);
                }
            }
            this.k = adTemplate;
            b(adTemplate, viewGroup);
            a(com.kwad.sdk.core.response.a.b.b(this.k));
            com.kwad.sdk.reward.b.a.a aVar = this.f40982g;
            if (aVar != null) {
                aVar.addObserver(this);
            }
            this.f40981f.a(this);
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

        public void a(InterfaceC1998b interfaceC1998b) {
            this.j = interfaceC1998b;
        }

        public void a(boolean z) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.f40978c;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }

        public void b() {
            com.kwad.sdk.reward.b.a.a aVar = this.f40982g;
            if (aVar != null) {
                aVar.deleteObserver(this);
            }
            this.f40981f.b(this);
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
        public void onProgressUpdate(int i) {
            a(com.kwad.sdk.core.response.a.a.a(i), i);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "BottomCardWebViewHelper update: " + obj);
            if (obj instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                x xVar = this.f40983h;
                if (xVar != null) {
                    xVar.a(booleanValue);
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.reward.presenter.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1998b {
        void a(String str, int i);
    }

    /* loaded from: classes7.dex */
    public static class c extends com.kwad.sdk.reward.presenter.a {
        public c() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return (!f() || af.e(q())) ? 8 : 0;
        }
    }

    /* loaded from: classes7.dex */
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
        ((ViewStub) a(R.id.obfuscated_res_0x7f0910ec)).inflate();
        ViewGroup viewGroup = (ViewGroup) a(R.id.obfuscated_res_0x7f0910e2);
        this.f40973g = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.f40973g, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.obfuscated_res_0x7f0910e3);
        kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.obfuscated_res_0x7f070370));
        final float dimension = q().getResources().getDimension(R.dimen.obfuscated_res_0x7f07036b);
        kSFrameLayout.post(new Runnable() { // from class: com.kwad.sdk.reward.presenter.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                kSFrameLayout.getHeight();
            }
        });
        this.f40973g = (ViewGroup) a(R.id.obfuscated_res_0x7f0910e2);
        com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f40973g);
        this.i = cVar;
        cVar.a(this);
        this.i.a(((g) this).a.f40747g, false);
        a aVar = new a((KsAdWebView) a(R.id.obfuscated_res_0x7f0910e1), this.f40973g, ((g) this).a.l, this.f40972f, this);
        this.f40974h = aVar;
        aVar.a(new InterfaceC1998b() { // from class: com.kwad.sdk.reward.presenter.c.b.2
            @Override // com.kwad.sdk.reward.presenter.c.b.InterfaceC1998b
            public void a(String str, int i) {
                int i2 = com.kwad.sdk.core.response.a.d.j(((g) b.this).a.f40747g).status;
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i2);
                boolean z = true;
                b.this.i.a(str, i, (i2 == 1 || i2 == 2 || i2 == 3) ? false : false);
            }
        });
        this.f40974h.a(((g) this).a.f40747g, adBaseFrameLayout);
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
        if (com.kwad.sdk.core.response.a.d.u(((g) this).a.f40747g)) {
            this.k = com.kwad.sdk.core.config.b.az();
            com.kwad.sdk.utils.x.a().addObserver(this);
            com.kwad.sdk.reward.b.a.a a2 = com.kwad.sdk.reward.b.c.a();
            this.f40972f = a2;
            ((g) this).a.y = a2;
            a2.g();
            com.kwad.sdk.reward.b.a.a.a(this.f40972f, q(), ((g) this).a.f40747g);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.obfuscated_res_0x7f091131);
            this.f40969c = (ViewGroup) a(R.id.obfuscated_res_0x7f091010);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f40969c);
            this.j = cVar;
            cVar.a(this);
            this.j.a(((g) this).a.f40747g, false);
            ((KSFrameLayout) a(R.id.obfuscated_res_0x7f091012)).setWidthBasedRatio(false);
            d dVar = new d((KsAdWebView) a(R.id.obfuscated_res_0x7f091011), this.f40969c, ((g) this).a.l, this.f40972f, this);
            this.f40970d = dVar;
            dVar.a(((g) this).a.f40747g, adBaseFrameLayout);
            AdInfo j = com.kwad.sdk.core.response.a.d.j(((g) this).a.f40747g);
            e eVar = this.f40971e;
            if (eVar == null) {
                this.f40971e = new e(com.kwad.sdk.core.response.a.a.v(j));
            } else {
                eVar.a(com.kwad.sdk.core.response.a.a.v(j));
            }
            this.f40971e.a(q(), this);
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
        if (com.kwad.sdk.core.response.a.c.g(((g) this).a.f40747g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.utils.x.a().deleteObserver(this);
        e eVar = this.f40971e;
        if (eVar != null) {
            eVar.a(q());
        }
        a aVar = this.f40974h;
        if (aVar != null) {
            aVar.b();
            this.f40974h = null;
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
            com.kwad.sdk.reward.b.a.a aVar2 = this.f40972f;
            if (aVar2 == null) {
                return;
            }
            com.kwad.sdk.reward.b.a.a.a(aVar2, q(), ((g) this).a.f40747g);
            char c2 = 0;
            if (!this.f40972f.k()) {
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
                if (e2 && (aVar = this.f40972f) != null) {
                    aVar.j();
                    com.kwad.sdk.reward.d.a().b();
                    ((g) this).a.f40742b.e();
                }
                b(e2);
            }
        }
    }
}
