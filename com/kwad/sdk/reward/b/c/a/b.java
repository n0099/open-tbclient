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
    public TailFramePortraitVertical f33759b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f33760c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f33761d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f33762e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33763f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33764g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.c.c f33765h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33766i;
    public f j = new f() { // from class: com.kwad.sdk.reward.b.c.a.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) b.this).f33839a.s || ((d) b.this).f33839a.t) {
                return;
            }
            if (b.this.f33765h != null && b.this.f33765h.d()) {
                b.this.f33766i = false;
                return;
            }
            b.this.f33766i = true;
            b.this.m();
        }
    };

    private void e() {
        if (this.f33766i) {
            this.f33759b.b();
            this.f33759b.setVisibility(8);
            this.f33760c.b();
            this.f33760c.setVisibility(8);
            this.f33761d.b();
            this.f33761d.setVisibility(8);
            this.f33762e.b();
            this.f33762e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (((d) this).f33839a.f33565e == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f33764g);
        return C.height > C.width;
    }

    private void o() {
        this.f33759b.a(this.f33763f, ((d) this).f33839a.f33564d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33759b.setVisibility(0);
    }

    private void p() {
        this.f33760c.a(this.f33763f, ((d) this).f33839a.f33564d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33760c.setVisibility(0);
    }

    private void q() {
        this.f33761d.a(this.f33763f, ((d) this).f33839a.f33564d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33761d.setVisibility(0);
    }

    private void r() {
        this.f33762e.a(this.f33763f, ((d) this).f33839a.f33564d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.b.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.s();
            }
        });
        this.f33762e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f33763f, 2, ((d) this).f33839a.f33568h.getTouchCoords(), ((d) this).f33839a.f33564d);
        ((d) this).f33839a.f33562b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f33839a.f33566f;
        this.f33763f = adTemplate;
        this.f33764g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f33839a;
        this.f33765h = aVar.l;
        aVar.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33759b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
        this.f33760c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
        this.f33761d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
        this.f33762e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
        ((d) this).f33839a.b(this.j);
    }
}
