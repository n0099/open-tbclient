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
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f8716b;
    private AdBaseFrameLayout c;
    private ViewGroup d;
    private WebView e;
    private ViewStub f;
    private ViewGroup g;
    private ImageView h;
    private TextView i;
    private View j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private AdTemplate n;
    private boolean o;
    private AdTemplate r;
    private AdStyleInfo.PlayDetailInfo.PatchAdInfo s;
    @Nullable
    private com.kwad.sdk.core.download.b.b t;
    @Nullable
    private KsAppDownloadListener u;
    @Nullable
    private b v;
    private ValueAnimator w;
    private ValueAnimator x;
    private boolean p = false;
    private boolean q = false;
    private boolean y = false;
    private boolean z = false;
    private com.kwad.sdk.contentalliance.a.a A = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.1
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
    private Runnable B = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.3
        @Override // java.lang.Runnable
        public void run() {
            int width = d.this.g.getWidth();
            d.this.g.setTranslationX(-width);
            d.this.g.setVisibility(0);
            d.this.h();
            d.this.w = am.c(d.this.g, -width, 0);
            d.this.w.start();
            d.this.w();
            d.this.g.setOnClickListener(d.this);
        }
    };
    private Runnable C = new aq(this.B);
    private Runnable D = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.5
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.y || d.this.v == null || d.this.u()) {
                return;
            }
            d.this.v.c();
        }
    };
    private Runnable E = new aq(this.D);

    private KsAppDownloadListener a(AdInfo adInfo) {
        this.u = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.4
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                d.this.a(d.this.s.weakStyleDownloadingTitle, "继续下载 " + i + "%");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                d.this.a(d.this.s.weakStyleTitle, "");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                d.this.a(d.this.s.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.a(d.this.r));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                d.this.a(d.this.s.weakStyleTitle, "");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                d.this.a(d.this.s.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.b());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                d.this.a(d.this.s.weakStyleDownloadingTitle, "正在下载 " + i + "%");
            }
        };
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull AdTemplate adTemplate) {
        if (this.p) {
            this.r = adTemplate;
            this.s = com.kwad.sdk.core.response.b.b.a(this.r);
            q();
            r();
            t();
            g();
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        int c = ((ao.c(o()) - ao.a(o(), 12.0f)) - ao.a(o(), 93.0f)) - (ao.a(o(), 8.0f) * 2);
        if (!TextUtils.isEmpty(this.s.weakStyleIcon)) {
            c -= ao.a(o(), 22.0f);
        }
        if (!TextUtils.isEmpty(this.s.weakStyleAdMark)) {
            c -= ao.a(o(), 20.0f);
        }
        if (this.s.weakStyleEnableClose) {
            c -= ao.a(o(), 20.0f);
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        } else {
            if (!ag.a(str)) {
                this.k.setText(str2);
                int a2 = c - ((int) (ao.a(o(), 17.0f) + this.k.getPaint().measureText(str2)));
                int measureText = (int) this.i.getPaint().measureText(str);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
                if (measureText > a2) {
                    marginLayoutParams.leftMargin = ao.a(o(), 4.0f);
                    c = ao.a(o(), 4.0f) + a2;
                } else {
                    marginLayoutParams.leftMargin = ao.a(o(), 8.0f);
                    c = a2;
                }
            }
            this.j.setVisibility(0);
            this.k.setVisibility(0);
        }
        this.i.setMaxWidth(c);
        this.i.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.q = false;
        this.y = false;
        this.z = false;
        if (this.g != null) {
            this.g.removeCallbacks(this.C);
            this.g.setVisibility(8);
        }
        this.d.setTranslationX(0.0f);
        this.f8716b.setVisibility(8);
        this.f8716b.removeCallbacks(this.E);
        if (this.v != null) {
            this.v.b();
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
            fVar.f9465b = this.n.mAdScene.getPageScene();
        }
        fVar.c = 101L;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.n);
        final long k2 = com.kwad.sdk.core.response.b.d.k(k);
        l lVar = new l();
        lVar.f9475a = k2;
        lVar.f9476b = com.kwad.sdk.core.response.b.d.o(k);
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
        this.g.removeCallbacks(this.C);
        long j = this.s.weakStyleAppearTime;
        this.g.postDelayed(this.C, j > 0 ? j : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.x != null) {
            this.x.cancel();
        }
    }

    private void p() {
        if (ao.a((View) this.g, 50, false)) {
            this.x = am.c(this.g, 0, -this.g.getWidth());
            this.x.start();
            this.m.setOnClickListener(null);
            this.g.setOnClickListener(null);
            s();
        }
    }

    private void q() {
        if (this.f.getParent() != null) {
            this.g = (ViewGroup) this.f.inflate();
            this.g.setVisibility(8);
            this.h = (ImageView) b(R.id.ksad_patch_icon);
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
            this.h.setVisibility(8);
        } else {
            KSImageLoader.loadImage(this.h, str, this.r);
            this.h.setVisibility(0);
        }
        if (com.kwad.sdk.core.response.b.a.y(j)) {
            s();
            this.t = new com.kwad.sdk.core.download.b.b(this.r);
            this.t.a(a(j));
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
        this.g.setVisibility(4);
    }

    private void s() {
        if (this.t == null || this.u == null) {
            return;
        }
        this.t.b(this.u);
    }

    private void t() {
        if (ag.a(this.s.strongStyleCardUrl)) {
            return;
        }
        this.v = new b();
        this.v.a(this.d, this.g, this.f8716b, this.e, this.c, this.r, this.t);
        this.v.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        boolean z = true;
        if (com.kwad.sdk.core.config.c.z()) {
            return false;
        }
        if (this.z) {
            return true;
        }
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.r);
        if (com.kwad.sdk.core.response.b.a.y(j)) {
            if (j.status == DOWNLOADSTAUS.UNKNOWN || j.status == DOWNLOADSTAUS.FAILED) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private void v() {
        if (u()) {
            return;
        }
        this.f8716b.removeCallbacks(this.E);
        long j = this.s.strongStyleAppearTime;
        if (j <= 0) {
            j = 5000;
        }
        this.f8716b.postDelayed(this.E, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.kwad.sdk.core.report.b.a(this.r, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.kwad.sdk.core.report.b.a(this.r, 51, this.c == null ? null : this.c.getTouchCoords());
    }

    private void y() {
        com.kwad.sdk.core.report.b.a(this.r, 9, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.n = this.f8692a.j;
        if (!com.kwad.sdk.core.response.b.d.H(com.kwad.sdk.core.response.b.c.k(this.n))) {
            this.o = false;
            return;
        }
        this.o = true;
        this.f8692a.f8702b.add(this.A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.o) {
            this.f8692a.f8702b.remove(this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.d = (ViewGroup) b(R.id.ksad_bottom_content_container);
        this.f8716b = (FrameLayout) b(R.id.ksad_web_card_container);
        this.e = (WebView) b(R.id.ksad_actionbar_web_card);
        this.f = (ViewStub) b(R.id.ksad_patch_ad_view_stub);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.m) {
            p();
            this.y = true;
            this.f8716b.removeCallbacks(this.E);
            y();
        } else if (view == this.g) {
            if (!com.ksad.download.d.b.a(view.getContext())) {
                p.a(view.getContext(), "网络错误");
            }
            com.kwad.sdk.core.download.b.b.a(this.t, true);
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.r, new a.InterfaceC1064a() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.6
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
                public void a() {
                    d.this.z = true;
                    d.this.x();
                }
            }, this.t);
        }
    }
}
