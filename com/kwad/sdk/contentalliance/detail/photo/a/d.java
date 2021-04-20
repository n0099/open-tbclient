package com.kwad.sdk.contentalliance.detail.photo.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.a.l;
import com.kwad.sdk.core.g.f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.p;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public Runnable B;
    public Runnable C;
    public Runnable D;
    public Runnable E;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f32471b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32472c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f32473d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f32474e;

    /* renamed from: f  reason: collision with root package name */
    public ViewStub f32475f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f32476g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f32477h;
    public TextView i;
    public View j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public AdTemplate n;
    public boolean o;
    public AdTemplate r;
    public AdStyleInfo.PlayDetailInfo.PatchAdInfo s;
    @Nullable
    public com.kwad.sdk.core.download.b.b t;
    @Nullable
    public KsAppDownloadListener u;
    @Nullable
    public b v;
    public ValueAnimator w;
    public ValueAnimator x;
    public boolean p = false;
    public boolean q = false;
    public boolean y = false;
    public boolean z = false;
    public com.kwad.sdk.contentalliance.a.a A = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            d.this.p = true;
            d.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            d.this.p = false;
            d.this.e();
        }
    };

    public d() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                int i = -d.this.f32476g.getWidth();
                d.this.f32476g.setTranslationX(i);
                d.this.f32476g.setVisibility(0);
                d.this.h();
                d dVar = d.this;
                dVar.w = am.c(dVar.f32476g, i, 0);
                d.this.w.start();
                d.this.w();
                d.this.f32476g.setOnClickListener(d.this);
            }
        };
        this.B = runnable;
        this.C = new aq(runnable);
        Runnable runnable2 = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.y || d.this.v == null || d.this.u()) {
                    return;
                }
                d.this.v.c();
            }
        };
        this.D = runnable2;
        this.E = new aq(runnable2);
    }

    private KsAppDownloadListener a(AdInfo adInfo) {
        com.kwad.sdk.core.download.b.c cVar = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.4
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                d dVar = d.this;
                String str = dVar.s.weakStyleDownloadingTitle;
                dVar.a(str, "继续下载 " + i + "%");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                d dVar = d.this;
                dVar.a(dVar.s.weakStyleTitle, "");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                d dVar = d.this;
                dVar.a(dVar.s.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.a(d.this.r));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                d dVar = d.this;
                dVar.a(dVar.s.weakStyleTitle, "");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                d dVar = d.this;
                dVar.a(dVar.s.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.b());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                d dVar = d.this;
                String str = dVar.s.weakStyleDownloadingTitle;
                dVar.a(str, "正在下载 " + i + "%");
            }
        };
        this.u = cVar;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull AdTemplate adTemplate) {
        if (this.p) {
            this.r = adTemplate;
            this.s = com.kwad.sdk.core.response.b.b.a(adTemplate);
            q();
            r();
            t();
            g();
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        View view;
        int i;
        int c2 = ((ao.c(o()) - ao.a(o(), 12.0f)) - ao.a(o(), 93.0f)) - (ao.a(o(), 8.0f) * 2);
        if (!TextUtils.isEmpty(this.s.weakStyleIcon)) {
            c2 -= ao.a(o(), 22.0f);
        }
        if (!TextUtils.isEmpty(this.s.weakStyleAdMark)) {
            c2 -= ao.a(o(), 20.0f);
        }
        if (this.s.weakStyleEnableClose) {
            c2 -= ao.a(o(), 20.0f);
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            view = this.j;
            i = 8;
        } else {
            if (!ag.a(str)) {
                this.k.setText(str2);
                c2 -= (int) (ao.a(o(), 17.0f) + this.k.getPaint().measureText(str2));
                int measureText = (int) this.i.getPaint().measureText(str);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
                if (measureText > c2) {
                    marginLayoutParams.leftMargin = ao.a(o(), 4.0f);
                    c2 += ao.a(o(), 4.0f);
                } else {
                    marginLayoutParams.leftMargin = ao.a(o(), 8.0f);
                }
            }
            view = this.j;
            i = 0;
        }
        view.setVisibility(i);
        this.k.setVisibility(i);
        this.i.setMaxWidth(c2);
        this.i.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.q = false;
        this.y = false;
        this.z = false;
        ViewGroup viewGroup = this.f32476g;
        if (viewGroup != null) {
            viewGroup.removeCallbacks(this.C);
            this.f32476g.setVisibility(8);
        }
        this.f32473d.setTranslationX(0.0f);
        this.f32471b.setVisibility(8);
        this.f32471b.removeCallbacks(this.E);
        b bVar = this.v;
        if (bVar != null) {
            bVar.b();
            this.v = null;
        }
        h();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.q) {
            return;
        }
        this.q = true;
        SceneImpl sceneImpl = this.n.mAdScene;
        f fVar = new f(sceneImpl);
        if (sceneImpl instanceof SceneImpl) {
            fVar.f33941b = this.n.mAdScene.getPageScene();
        }
        fVar.f33942c = 101L;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.n);
        final long k2 = com.kwad.sdk.core.response.b.d.k(k);
        l lVar = new l();
        lVar.f33962a = k2;
        lVar.f33963b = com.kwad.sdk.core.response.b.d.o(k);
        com.kwad.sdk.core.g.f.a(k2, fVar, lVar, new f.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.2
            @Override // com.kwad.sdk.core.g.f.a
            public void a(int i, String str) {
                d.this.q = false;
            }

            @Override // com.kwad.sdk.core.g.f.a
            public void a(long j, AdTemplate adTemplate) {
                d.this.q = false;
                if (adTemplate == null || j != k2) {
                    return;
                }
                d.this.a(adTemplate);
            }
        });
    }

    private void g() {
        this.f32476g.removeCallbacks(this.C);
        long j = this.s.weakStyleAppearTime;
        if (j <= 0) {
            j = 0;
        }
        this.f32476g.postDelayed(this.C, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.x;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    private void p() {
        if (ao.a((View) this.f32476g, 50, false)) {
            ValueAnimator c2 = am.c(this.f32476g, 0, -this.f32476g.getWidth());
            this.x = c2;
            c2.start();
            this.m.setOnClickListener(null);
            this.f32476g.setOnClickListener(null);
            s();
        }
    }

    private void q() {
        if (this.f32475f.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) this.f32475f.inflate();
            this.f32476g = viewGroup;
            viewGroup.setVisibility(8);
            this.f32477h = (ImageView) b(R.id.ksad_patch_icon);
            this.i = (TextView) b(R.id.ksad_patch_ad_title);
            this.j = b(R.id.ksad_patch_ad_mid_line);
            this.k = (TextView) b(R.id.ksad_patch_ad_app_status);
            this.l = (ImageView) b(R.id.ksad_patch_ad_mark);
            this.m = (ImageView) b(R.id.ksad_patch_ad_close_btn);
        }
    }

    private void r() {
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.r);
        String str = this.s.weakStyleIcon;
        if (ag.a(str)) {
            this.f32477h.setVisibility(8);
        } else {
            KSImageLoader.loadImage(this.f32477h, str, this.r);
            this.f32477h.setVisibility(0);
        }
        if (com.kwad.sdk.core.response.b.a.y(j)) {
            s();
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.r);
            this.t = bVar;
            bVar.a(a(j));
        } else {
            a(this.s.weakStyleTitle, "");
        }
        String str2 = this.s.weakStyleAdMark;
        if (ag.a(str2)) {
            this.l.setVisibility(8);
        } else {
            KSImageLoader.loadImage(this.l, str2, this.r);
            this.l.setVisibility(0);
        }
        if (this.s.weakStyleEnableClose) {
            this.m.setOnClickListener(this);
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
        this.f32476g.setVisibility(4);
    }

    private void s() {
        KsAppDownloadListener ksAppDownloadListener;
        com.kwad.sdk.core.download.b.b bVar = this.t;
        if (bVar == null || (ksAppDownloadListener = this.u) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    private void t() {
        if (ag.a(this.s.strongStyleCardUrl)) {
            return;
        }
        b bVar = new b();
        this.v = bVar;
        bVar.a(this.f32473d, this.f32476g, this.f32471b, this.f32474e, this.f32472c, this.r, this.t);
        this.v.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        DOWNLOADSTAUS downloadstaus;
        if (com.kwad.sdk.core.config.c.z()) {
            return false;
        }
        if (this.z) {
            return true;
        }
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.r);
        return (!com.kwad.sdk.core.response.b.a.y(j) || (downloadstaus = j.status) == DOWNLOADSTAUS.UNKNOWN || downloadstaus == DOWNLOADSTAUS.FAILED) ? false : true;
    }

    private void v() {
        if (u()) {
            return;
        }
        this.f32471b.removeCallbacks(this.E);
        long j = this.s.strongStyleAppearTime;
        if (j <= 0) {
            j = 5000;
        }
        this.f32471b.postDelayed(this.E, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.kwad.sdk.core.report.b.a(this.r, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        AdTemplate adTemplate = this.r;
        AdBaseFrameLayout adBaseFrameLayout = this.f32472c;
        com.kwad.sdk.core.report.b.a(adTemplate, 51, adBaseFrameLayout == null ? null : adBaseFrameLayout.getTouchCoords());
    }

    private void y() {
        com.kwad.sdk.core.report.b.a(this.r, 9, (JSONObject) null);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j;
        this.n = adTemplate;
        if (!com.kwad.sdk.core.response.b.d.H(com.kwad.sdk.core.response.b.c.k(adTemplate))) {
            this.o = false;
            return;
        }
        this.o = true;
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.A);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.o) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.remove(this.A);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32472c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32473d = (ViewGroup) b(R.id.ksad_bottom_content_container);
        this.f32471b = (FrameLayout) b(R.id.ksad_web_card_container);
        this.f32474e = (WebView) b(R.id.ksad_actionbar_web_card);
        this.f32475f = (ViewStub) b(R.id.ksad_patch_ad_view_stub);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.m) {
            p();
            this.y = true;
            this.f32471b.removeCallbacks(this.E);
            y();
        } else if (view == this.f32476g) {
            if (!com.ksad.download.d.b.a(view.getContext())) {
                p.a(view.getContext(), "网络错误");
            }
            com.kwad.sdk.core.download.b.b.a(this.t, true);
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.r, new a.InterfaceC0393a() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.6
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    d.this.z = true;
                    d.this.x();
                }
            }, this.t);
        }
    }
}
