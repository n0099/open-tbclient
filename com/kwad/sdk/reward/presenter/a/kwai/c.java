package com.kwad.sdk.reward.presenter.a.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.l;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes3.dex */
public class c extends g {

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f57393b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f57394c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f57395d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f57396e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f57397f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f57398g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.i.b f57399h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57400i;

    /* renamed from: j  reason: collision with root package name */
    public l.b f57401j;
    public f k = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.aG(c.this.f57398g)) {
                l.a(c.this.o(), c.this.f57397f, c.this.f57401j);
            } else if (((g) c.this).a.x) {
            } else {
                if (c.this.f57399h != null && c.this.f57399h.d()) {
                    c.this.f57400i = false;
                    return;
                }
                c.this.f57400i = true;
                c.this.i();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.f57397f, z ? 2 : 153, ((g) this).a.f57210j.getTouchCoords(), ((g) this).a.f57205e);
        ((g) this).a.f57202b.a();
    }

    private void e() {
        if (this.f57400i) {
            this.f57393b.a();
            this.f57393b.setVisibility(8);
            this.f57394c.a();
            this.f57394c.setVisibility(8);
            this.f57395d.a();
            this.f57395d.setVisibility(8);
            this.f57396e.a();
            this.f57396e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (((g) this).a.f57206f == 0) {
            if (r()) {
                s();
            } else {
                t();
            }
        } else if (r()) {
            u();
        } else {
            v();
        }
    }

    private boolean r() {
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f57398g);
        return J.height > J.width;
    }

    private void s() {
        this.f57393b.a(this.f57397f, ((g) this).a.f57205e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.2
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57393b.setVisibility(0);
    }

    private void t() {
        this.f57394c.a(this.f57397f, ((g) this).a.f57205e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.3
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57394c.setVisibility(0);
    }

    private void u() {
        this.f57395d.a(this.f57397f, ((g) this).a.f57205e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.4
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57395d.setVisibility(0);
    }

    private void v() {
        this.f57396e.a(this.f57397f, ((g) this).a.f57205e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.5
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57396e.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57393b.setCallerContext(((g) this).a);
        this.f57394c.setCallerContext(((g) this).a);
        this.f57395d.setCallerContext(((g) this).a);
        this.f57396e.setCallerContext(((g) this).a);
        AdTemplate adTemplate = ((g) this).a.f57207g;
        this.f57397f = adTemplate;
        this.f57398g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57399h = aVar.o;
        aVar.a(this.k);
    }

    public void a(l.b bVar) {
        this.f57401j = bVar;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
        ((g) this).a.b(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57393b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
        this.f57394c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
        this.f57395d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
        this.f57396e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
    }
}
