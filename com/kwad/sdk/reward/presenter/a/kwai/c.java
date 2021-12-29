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
    public TailFramePortraitVertical f59647b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f59648c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f59649d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f59650e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59651f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59652g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.i.b f59653h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59654i;

    /* renamed from: j  reason: collision with root package name */
    public l.b f59655j;

    /* renamed from: k  reason: collision with root package name */
    public f f59656k = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.aG(c.this.f59652g)) {
                l.a(c.this.o(), c.this.f59651f, c.this.f59655j);
            } else if (((g) c.this).a.x) {
            } else {
                if (c.this.f59653h != null && c.this.f59653h.d()) {
                    c.this.f59654i = false;
                    return;
                }
                c.this.f59654i = true;
                c.this.i();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.f59651f, z ? 2 : 153, ((g) this).a.f59458j.getTouchCoords(), ((g) this).a.f59453e);
        ((g) this).a.f59450b.a();
    }

    private void e() {
        if (this.f59654i) {
            this.f59647b.a();
            this.f59647b.setVisibility(8);
            this.f59648c.a();
            this.f59648c.setVisibility(8);
            this.f59649d.a();
            this.f59649d.setVisibility(8);
            this.f59650e.a();
            this.f59650e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (((g) this).a.f59454f == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f59652g);
        return J.height > J.width;
    }

    private void s() {
        this.f59647b.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.2
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f59647b.setVisibility(0);
    }

    private void t() {
        this.f59648c.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.3
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f59648c.setVisibility(0);
    }

    private void u() {
        this.f59649d.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.4
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f59649d.setVisibility(0);
    }

    private void v() {
        this.f59650e.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.5
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f59650e.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f59647b.setCallerContext(((g) this).a);
        this.f59648c.setCallerContext(((g) this).a);
        this.f59649d.setCallerContext(((g) this).a);
        this.f59650e.setCallerContext(((g) this).a);
        AdTemplate adTemplate = ((g) this).a.f59455g;
        this.f59651f = adTemplate;
        this.f59652g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f59653h = aVar.o;
        aVar.a(this.f59656k);
    }

    public void a(l.b bVar) {
        this.f59655j = bVar;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
        ((g) this).a.b(this.f59656k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59647b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
        this.f59648c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
        this.f59649d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
        this.f59650e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
    }
}
