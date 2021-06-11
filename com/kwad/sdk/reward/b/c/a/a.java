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
    public TailFramePortraitVertical f37133b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f37134c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f37135d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f37136e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f37137f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f37138g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c f37139h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37140i;
    public e j = new e() { // from class: com.kwad.sdk.reward.b.c.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            if (a.this.f37139h != null && a.this.f37139h.d()) {
                a.this.f37140i = false;
                return;
            }
            a.this.f37140i = true;
            a.this.f();
        }
    };

    private void e() {
        if (this.f37140i) {
            this.f37133b.b();
            this.f37133b.setVisibility(8);
            this.f37134c.b();
            this.f37134c.setVisibility(8);
            this.f37135d.b();
            this.f37135d.setVisibility(8);
            this.f37136e.b();
            this.f37136e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (((d) this).f37201a.f36954e == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f37138g);
        return E.height > E.width;
    }

    private void h() {
        this.f37133b.a(this.f37137f, ((d) this).f37201a.f36953d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37133b.setVisibility(0);
    }

    private void p() {
        this.f37134c.a(this.f37137f, ((d) this).f37201a.f36953d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37134c.setVisibility(0);
    }

    private void q() {
        this.f37135d.a(this.f37137f, ((d) this).f37201a.f36953d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37135d.setVisibility(0);
    }

    private void r() {
        this.f37136e.a(this.f37137f, ((d) this).f37201a.f36953d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f37136e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f37137f, 2, ((d) this).f37201a.f36957h.getTouchCoords(), ((d) this).f37201a.f36953d);
        ((d) this).f37201a.f36951b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f37201a.f36955f;
        this.f37137f = adTemplate;
        this.f37138g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((d) this).f37201a;
        this.f37139h = aVar.l;
        aVar.n.add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        ((d) this).f37201a.n.remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37133b = (TailFramePortraitVertical) b(R.id.ksad_video_portrait_vertical);
        this.f37134c = (TailFramePortraitHorizontal) b(R.id.ksad_video_portrait_horizontal);
        this.f37135d = (TailFrameLandscapeVertical) b(R.id.ksad_video_landscape_vertical);
        this.f37136e = (TailFrameLandscapeHorizontal) b(R.id.ksad_video_landscape_horizontal);
    }
}
