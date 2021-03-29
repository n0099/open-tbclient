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
    public TailFramePortraitVertical f36392b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f36393c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f36394d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f36395e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f36396f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f36397g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c f36398h;
    public boolean i;
    public e j = new e() { // from class: com.kwad.sdk.reward.b.c.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            if (a.this.f36398h != null && a.this.f36398h.d()) {
                a.this.i = false;
                return;
            }
            a.this.i = true;
            a.this.f();
        }
    };

    private void e() {
        if (this.i) {
            this.f36392b.b();
            this.f36392b.setVisibility(8);
            this.f36393c.b();
            this.f36393c.setVisibility(8);
            this.f36394d.b();
            this.f36394d.setVisibility(8);
            this.f36395e.b();
            this.f36395e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (((d) this).f36458a.f36221e == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f36397g);
        return E.height > E.width;
    }

    private void h() {
        this.f36392b.a(this.f36396f, ((d) this).f36458a.f36220d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36392b.setVisibility(0);
    }

    private void p() {
        this.f36393c.a(this.f36396f, ((d) this).f36458a.f36220d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36393c.setVisibility(0);
    }

    private void q() {
        this.f36394d.a(this.f36396f, ((d) this).f36458a.f36220d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36394d.setVisibility(0);
    }

    private void r() {
        this.f36395e.a(this.f36396f, ((d) this).f36458a.f36220d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f36395e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f36396f, 2, ((d) this).f36458a.f36224h.getTouchCoords(), ((d) this).f36458a.f36220d);
        ((d) this).f36458a.f36218b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f36458a.f36222f;
        this.f36396f = adTemplate;
        this.f36397g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f36458a;
        this.f36398h = aVar.l;
        aVar.n.add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        ((d) this).f36458a.n.remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36392b = (TailFramePortraitVertical) b(R.id.ksad_video_portrait_vertical);
        this.f36393c = (TailFramePortraitHorizontal) b(R.id.ksad_video_portrait_horizontal);
        this.f36394d = (TailFrameLandscapeVertical) b(R.id.ksad_video_landscape_vertical);
        this.f36395e = (TailFrameLandscapeHorizontal) b(R.id.ksad_video_landscape_horizontal);
    }
}
