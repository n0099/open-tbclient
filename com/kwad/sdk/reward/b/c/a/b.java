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
    public TailFramePortraitVertical f34514b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f34515c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f34516d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f34517e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34518f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34519g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.c.c f34520h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34521i;
    public f j = new f() { // from class: com.kwad.sdk.reward.b.c.a.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) b.this).f34594a.s || ((d) b.this).f34594a.t) {
                return;
            }
            if (b.this.f34520h != null && b.this.f34520h.d()) {
                b.this.f34521i = false;
                return;
            }
            b.this.f34521i = true;
            b.this.m();
        }
    };

    private void e() {
        if (this.f34521i) {
            this.f34514b.b();
            this.f34514b.setVisibility(8);
            this.f34515c.b();
            this.f34515c.setVisibility(8);
            this.f34516d.b();
            this.f34516d.setVisibility(8);
            this.f34517e.b();
            this.f34517e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (((d) this).f34594a.f34320e == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f34519g);
        return C.height > C.width;
    }

    private void o() {
        this.f34514b.a(this.f34518f, ((d) this).f34594a.f34319d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f34514b.setVisibility(0);
    }

    private void p() {
        this.f34515c.a(this.f34518f, ((d) this).f34594a.f34319d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f34515c.setVisibility(0);
    }

    private void q() {
        this.f34516d.a(this.f34518f, ((d) this).f34594a.f34319d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f34516d.setVisibility(0);
    }

    private void r() {
        this.f34517e.a(this.f34518f, ((d) this).f34594a.f34319d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f34517e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f34518f, 2, ((d) this).f34594a.f34323h.getTouchCoords(), ((d) this).f34594a.f34319d);
        ((d) this).f34594a.f34317b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f34594a.f34321f;
        this.f34518f = adTemplate;
        this.f34519g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        this.f34520h = aVar.l;
        aVar.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34514b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
        this.f34515c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
        this.f34516d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
        this.f34517e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
        ((d) this).f34594a.b(this.j);
    }
}
