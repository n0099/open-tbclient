package com.kwad.sdk.reward.presenter.a.kwai;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.l;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes5.dex */
public class c extends g {
    public TailFramePortraitVertical b;
    public TailFramePortraitHorizontal c;
    public TailFrameLandscapeVertical d;
    public TailFrameLandscapeHorizontal e;
    public AdTemplate f;
    public AdInfo g;
    @Nullable
    public com.kwad.sdk.i.b h;
    public boolean i;
    public l.b j;
    public f k = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.aG(c.this.g)) {
                l.a(c.this.o(), c.this.f, c.this.j);
            } else if (((g) c.this).a.x) {
            } else {
                if (c.this.h != null && c.this.h.d()) {
                    c.this.i = false;
                    return;
                }
                c.this.i = true;
                c.this.i();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.f, z ? 2 : 153, ((g) this).a.j.getTouchCoords(), ((g) this).a.e);
        ((g) this).a.b.a();
    }

    private void e() {
        if (this.i) {
            this.b.a();
            this.b.setVisibility(8);
            this.c.a();
            this.c.setVisibility(8);
            this.d.a();
            this.d.setVisibility(8);
            this.e.a();
            this.e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (((g) this).a.f == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.g);
        return J.height > J.width;
    }

    private void s() {
        this.b.a(this.f, ((g) this).a.e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.2
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.b.setVisibility(0);
    }

    private void t() {
        this.c.a(this.f, ((g) this).a.e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.3
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.c.setVisibility(0);
    }

    private void u() {
        this.d.a(this.f, ((g) this).a.e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.4
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.d.setVisibility(0);
    }

    private void v() {
        this.e.a(this.f, ((g) this).a.e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.5
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.e.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setCallerContext(((g) this).a);
        this.c.setCallerContext(((g) this).a);
        this.d.setCallerContext(((g) this).a);
        this.e.setCallerContext(((g) this).a);
        AdTemplate adTemplate = ((g) this).a.g;
        this.f = adTemplate;
        this.g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.h = aVar.o;
        aVar.a(this.k);
    }

    public void a(l.b bVar) {
        this.j = bVar;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
        ((g) this).a.b(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (TailFramePortraitVertical) a(R.id.obfuscated_res_0x7f091134);
        this.c = (TailFramePortraitHorizontal) a(R.id.obfuscated_res_0x7f091133);
        this.d = (TailFrameLandscapeVertical) a(R.id.obfuscated_res_0x7f09112c);
        this.e = (TailFrameLandscapeHorizontal) a(R.id.obfuscated_res_0x7f09112b);
    }
}
