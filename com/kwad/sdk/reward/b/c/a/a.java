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
/* loaded from: classes7.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f37231b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f37232c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f37233d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f37234e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f37235f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f37236g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c f37237h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37238i;
    public e j = new e() { // from class: com.kwad.sdk.reward.b.c.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            if (a.this.f37237h != null && a.this.f37237h.d()) {
                a.this.f37238i = false;
                return;
            }
            a.this.f37238i = true;
            a.this.f();
        }
    };

    private void e() {
        if (this.f37238i) {
            this.f37231b.b();
            this.f37231b.setVisibility(8);
            this.f37232c.b();
            this.f37232c.setVisibility(8);
            this.f37233d.b();
            this.f37233d.setVisibility(8);
            this.f37234e.b();
            this.f37234e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (((d) this).f37299a.f37052e == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f37236g);
        return E.height > E.width;
    }

    private void h() {
        this.f37231b.a(this.f37235f, ((d) this).f37299a.f37051d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37231b.setVisibility(0);
    }

    private void p() {
        this.f37232c.a(this.f37235f, ((d) this).f37299a.f37051d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37232c.setVisibility(0);
    }

    private void q() {
        this.f37233d.a(this.f37235f, ((d) this).f37299a.f37051d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37233d.setVisibility(0);
    }

    private void r() {
        this.f37234e.a(this.f37235f, ((d) this).f37299a.f37051d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37234e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f37235f, 2, ((d) this).f37299a.f37055h.getTouchCoords(), ((d) this).f37299a.f37051d);
        ((d) this).f37299a.f37049b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f37299a.f37053f;
        this.f37235f = adTemplate;
        this.f37236g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f37299a;
        this.f37237h = aVar.l;
        aVar.n.add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        ((d) this).f37299a.n.remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37231b = (TailFramePortraitVertical) b(R.id.ksad_video_portrait_vertical);
        this.f37232c = (TailFramePortraitHorizontal) b(R.id.ksad_video_portrait_horizontal);
        this.f37233d = (TailFrameLandscapeVertical) b(R.id.ksad_video_landscape_vertical);
        this.f37234e = (TailFrameLandscapeHorizontal) b(R.id.ksad_video_landscape_horizontal);
    }
}
