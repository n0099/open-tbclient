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
    public TailFramePortraitVertical f57438b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f57439c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f57440d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f57441e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f57442f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f57443g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.i.b f57444h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57445i;

    /* renamed from: j  reason: collision with root package name */
    public l.b f57446j;
    public f k = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.aG(c.this.f57443g)) {
                l.a(c.this.o(), c.this.f57442f, c.this.f57446j);
            } else if (((g) c.this).a.x) {
            } else {
                if (c.this.f57444h != null && c.this.f57444h.d()) {
                    c.this.f57445i = false;
                    return;
                }
                c.this.f57445i = true;
                c.this.i();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.f57442f, z ? 2 : 153, ((g) this).a.f57255j.getTouchCoords(), ((g) this).a.f57250e);
        ((g) this).a.f57247b.a();
    }

    private void e() {
        if (this.f57445i) {
            this.f57438b.a();
            this.f57438b.setVisibility(8);
            this.f57439c.a();
            this.f57439c.setVisibility(8);
            this.f57440d.a();
            this.f57440d.setVisibility(8);
            this.f57441e.a();
            this.f57441e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (((g) this).a.f57251f == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f57443g);
        return J.height > J.width;
    }

    private void s() {
        this.f57438b.a(this.f57442f, ((g) this).a.f57250e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.2
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57438b.setVisibility(0);
    }

    private void t() {
        this.f57439c.a(this.f57442f, ((g) this).a.f57250e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.3
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57439c.setVisibility(0);
    }

    private void u() {
        this.f57440d.a(this.f57442f, ((g) this).a.f57250e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.4
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57440d.setVisibility(0);
    }

    private void v() {
        this.f57441e.a(this.f57442f, ((g) this).a.f57250e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.5
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f57441e.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57438b.setCallerContext(((g) this).a);
        this.f57439c.setCallerContext(((g) this).a);
        this.f57440d.setCallerContext(((g) this).a);
        this.f57441e.setCallerContext(((g) this).a);
        AdTemplate adTemplate = ((g) this).a.f57252g;
        this.f57442f = adTemplate;
        this.f57443g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57444h = aVar.o;
        aVar.a(this.k);
    }

    public void a(l.b bVar) {
        this.f57446j = bVar;
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
        this.f57438b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
        this.f57439c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
        this.f57440d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
        this.f57441e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
    }
}
