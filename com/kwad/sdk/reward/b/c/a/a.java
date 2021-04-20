package com.kwad.sdk.reward.b.c.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f36681b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f36682c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f36683d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f36684e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f36685f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f36686g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c f36687h;
    public boolean i;
    public e j = new e() { // from class: com.kwad.sdk.reward.b.c.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            if (a.this.f36687h != null && a.this.f36687h.d()) {
                a.this.i = false;
                return;
            }
            a.this.i = true;
            a.this.f();
        }
    };

    private void e() {
        if (this.i) {
            this.f36681b.b();
            this.f36681b.setVisibility(8);
            this.f36682c.b();
            this.f36682c.setVisibility(8);
            this.f36683d.b();
            this.f36683d.setVisibility(8);
            this.f36684e.b();
            this.f36684e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (((d) this).f36747a.f36510e == 0) {
            if (g()) {
                h();
            } else {
                p();
            }
        } else if (g()) {
            q();
        } else {
            r();
        }
    }

    private boolean g() {
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f36686g);
        return E.height > E.width;
    }

    private void h() {
        this.f36681b.a(this.f36685f, ((d) this).f36747a.f36509d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36681b.setVisibility(0);
    }

    private void p() {
        this.f36682c.a(this.f36685f, ((d) this).f36747a.f36509d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36682c.setVisibility(0);
    }

    private void q() {
        this.f36683d.a(this.f36685f, ((d) this).f36747a.f36509d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36683d.setVisibility(0);
    }

    private void r() {
        this.f36684e.a(this.f36685f, ((d) this).f36747a.f36509d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36684e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f36685f, 2, ((d) this).f36747a.f36513h.getTouchCoords(), ((d) this).f36747a.f36509d);
        ((d) this).f36747a.f36507b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f36747a.f36511f;
        this.f36685f = adTemplate;
        this.f36686g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f36747a;
        this.f36687h = aVar.l;
        aVar.n.add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        ((d) this).f36747a.n.remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36681b = (TailFramePortraitVertical) b(R.id.ksad_video_portrait_vertical);
        this.f36682c = (TailFramePortraitHorizontal) b(R.id.ksad_video_portrait_horizontal);
        this.f36683d = (TailFrameLandscapeVertical) b(R.id.ksad_video_landscape_vertical);
        this.f36684e = (TailFrameLandscapeHorizontal) b(R.id.ksad_video_landscape_horizontal);
    }
}
