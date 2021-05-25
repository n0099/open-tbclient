package com.kwad.sdk.reward.b.c.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes6.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f33688b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f33689c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f33690d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f33691e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33692f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33693g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.c.c f33694h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33695i;
    public f j = new f() { // from class: com.kwad.sdk.reward.b.c.a.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) b.this).f33768a.s || ((d) b.this).f33768a.t) {
                return;
            }
            if (b.this.f33694h != null && b.this.f33694h.d()) {
                b.this.f33695i = false;
                return;
            }
            b.this.f33695i = true;
            b.this.m();
        }
    };

    private void e() {
        if (this.f33695i) {
            this.f33688b.b();
            this.f33688b.setVisibility(8);
            this.f33689c.b();
            this.f33689c.setVisibility(8);
            this.f33690d.b();
            this.f33690d.setVisibility(8);
            this.f33691e.b();
            this.f33691e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (((d) this).f33768a.f33494e == 0) {
            if (n()) {
                o();
            } else {
                p();
            }
        } else if (n()) {
            q();
        } else {
            r();
        }
    }

    private boolean n() {
        AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f33693g);
        return C.height > C.width;
    }

    private void o() {
        this.f33688b.a(this.f33692f, ((d) this).f33768a.f33493d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33688b.setVisibility(0);
    }

    private void p() {
        this.f33689c.a(this.f33692f, ((d) this).f33768a.f33493d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33689c.setVisibility(0);
    }

    private void q() {
        this.f33690d.a(this.f33692f, ((d) this).f33768a.f33493d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33690d.setVisibility(0);
    }

    private void r() {
        this.f33691e.a(this.f33692f, ((d) this).f33768a.f33493d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33691e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f33692f, 2, ((d) this).f33768a.f33497h.getTouchCoords(), ((d) this).f33768a.f33493d);
        ((d) this).f33768a.f33491b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f33768a.f33495f;
        this.f33692f = adTemplate;
        this.f33693g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        this.f33694h = aVar.l;
        aVar.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33688b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
        this.f33689c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
        this.f33690d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
        this.f33691e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
        ((d) this).f33768a.b(this.j);
    }
}
