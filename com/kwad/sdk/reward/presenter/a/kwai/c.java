package com.kwad.sdk.reward.presenter.a.kwai;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.l;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes8.dex */
public class c extends g {

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f55955b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f55956c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f55957d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f55958e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f55959f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f55960g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.i.b f55961h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55962i;

    /* renamed from: j  reason: collision with root package name */
    public l.b f55963j;
    public f k = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.aG(c.this.f55960g)) {
                l.a(c.this.o(), c.this.f55959f, c.this.f55963j);
            } else if (((g) c.this).a.x) {
            } else {
                if (c.this.f55961h != null && c.this.f55961h.d()) {
                    c.this.f55962i = false;
                    return;
                }
                c.this.f55962i = true;
                c.this.i();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.f55959f, z ? 2 : 153, ((g) this).a.f55772j.getTouchCoords(), ((g) this).a.f55767e);
        ((g) this).a.f55764b.a();
    }

    private void e() {
        if (this.f55962i) {
            this.f55955b.a();
            this.f55955b.setVisibility(8);
            this.f55956c.a();
            this.f55956c.setVisibility(8);
            this.f55957d.a();
            this.f55957d.setVisibility(8);
            this.f55958e.a();
            this.f55958e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (((g) this).a.f55768f == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f55960g);
        return J.height > J.width;
    }

    private void s() {
        this.f55955b.a(this.f55959f, ((g) this).a.f55767e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.2
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f55955b.setVisibility(0);
    }

    private void t() {
        this.f55956c.a(this.f55959f, ((g) this).a.f55767e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.3
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f55956c.setVisibility(0);
    }

    private void u() {
        this.f55957d.a(this.f55959f, ((g) this).a.f55767e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.4
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f55957d.setVisibility(0);
    }

    private void v() {
        this.f55958e.a(this.f55959f, ((g) this).a.f55767e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.5
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f55958e.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55955b.setCallerContext(((g) this).a);
        this.f55956c.setCallerContext(((g) this).a);
        this.f55957d.setCallerContext(((g) this).a);
        this.f55958e.setCallerContext(((g) this).a);
        AdTemplate adTemplate = ((g) this).a.f55769g;
        this.f55959f = adTemplate;
        this.f55960g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f55961h = aVar.o;
        aVar.a(this.k);
    }

    public void a(l.b bVar) {
        this.f55963j = bVar;
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
        this.f55955b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
        this.f55956c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
        this.f55957d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
        this.f55958e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
    }
}
