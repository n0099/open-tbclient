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
    public TailFramePortraitVertical f36391b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f36392c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f36393d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f36394e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f36395f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f36396g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c f36397h;
    public boolean i;
    public e j = new e() { // from class: com.kwad.sdk.reward.b.c.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            if (a.this.f36397h != null && a.this.f36397h.d()) {
                a.this.i = false;
                return;
            }
            a.this.i = true;
            a.this.f();
        }
    };

    private void e() {
        if (this.i) {
            this.f36391b.b();
            this.f36391b.setVisibility(8);
            this.f36392c.b();
            this.f36392c.setVisibility(8);
            this.f36393d.b();
            this.f36393d.setVisibility(8);
            this.f36394e.b();
            this.f36394e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (((d) this).f36457a.f36220e == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f36396g);
        return E.height > E.width;
    }

    private void h() {
        this.f36391b.a(this.f36395f, ((d) this).f36457a.f36219d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36391b.setVisibility(0);
    }

    private void p() {
        this.f36392c.a(this.f36395f, ((d) this).f36457a.f36219d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36392c.setVisibility(0);
    }

    private void q() {
        this.f36393d.a(this.f36395f, ((d) this).f36457a.f36219d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36393d.setVisibility(0);
    }

    private void r() {
        this.f36394e.a(this.f36395f, ((d) this).f36457a.f36219d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36394e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f36395f, 2, ((d) this).f36457a.f36223h.getTouchCoords(), ((d) this).f36457a.f36219d);
        ((d) this).f36457a.f36217b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f36457a.f36221f;
        this.f36395f = adTemplate;
        this.f36396g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f36457a;
        this.f36397h = aVar.l;
        aVar.n.add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        ((d) this).f36457a.n.remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36391b = (TailFramePortraitVertical) b(R.id.ksad_video_portrait_vertical);
        this.f36392c = (TailFramePortraitHorizontal) b(R.id.ksad_video_portrait_horizontal);
        this.f36393d = (TailFrameLandscapeVertical) b(R.id.ksad_video_landscape_vertical);
        this.f36394e = (TailFrameLandscapeHorizontal) b(R.id.ksad_video_landscape_horizontal);
    }
}
