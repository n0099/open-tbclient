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
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private TailFramePortraitVertical f10916b;
    private TailFramePortraitHorizontal c;
    private TailFrameLandscapeVertical d;
    private TailFrameLandscapeHorizontal e;
    private AdTemplate f;
    private AdInfo g;
    @Nullable
    private c h;
    private boolean i;
    private e j = new e() { // from class: com.kwad.sdk.reward.b.c.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            if (a.this.h != null && a.this.h.d()) {
                a.this.i = false;
                return;
            }
            a.this.i = true;
            a.this.f();
        }
    };

    private void e() {
        if (this.i) {
            this.f10916b.b();
            this.f10916b.setVisibility(8);
            this.c.b();
            this.c.setVisibility(8);
            this.d.b();
            this.d.setVisibility(8);
            this.e.b();
            this.e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f10949a.e == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.g);
        return E.height > E.width;
    }

    private void h() {
        this.f10916b.a(this.f, this.f10949a.d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.2
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.f10916b.setVisibility(0);
    }

    private void p() {
        this.c.a(this.f, this.f10949a.d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.3
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.c.setVisibility(0);
    }

    private void q() {
        this.d.a(this.f, this.f10949a.d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.d.setVisibility(0);
    }

    private void r() {
        this.e.a(this.f, this.f10949a.d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.c.a.a.5
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                a.this.s();
            }
        });
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.report.b.a(this.f, 2, this.f10949a.h.getTouchCoords(), this.f10949a.d);
        this.f10949a.f10824b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f = this.f10949a.f;
        this.g = com.kwad.sdk.core.response.b.c.j(this.f);
        this.h = this.f10949a.l;
        this.f10949a.n.add(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        this.f10949a.n.remove(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10916b = (TailFramePortraitVertical) b(R.id.ksad_video_portrait_vertical);
        this.c = (TailFramePortraitHorizontal) b(R.id.ksad_video_portrait_horizontal);
        this.d = (TailFrameLandscapeVertical) b(R.id.ksad_video_landscape_vertical);
        this.e = (TailFrameLandscapeHorizontal) b(R.id.ksad_video_landscape_horizontal);
    }
}
