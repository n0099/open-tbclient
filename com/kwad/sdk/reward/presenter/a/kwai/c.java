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
/* loaded from: classes7.dex */
public class c extends g {

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f40915b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f40916c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f40917d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f40918e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f40919f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f40920g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.i.b f40921h;
    public boolean i;
    public l.b j;
    public f k = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.aG(c.this.f40920g)) {
                l.a(c.this.o(), c.this.f40919f, c.this.j);
            } else if (((g) c.this).a.x) {
            } else {
                if (c.this.f40921h != null && c.this.f40921h.d()) {
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
        com.kwad.sdk.core.report.a.a(this.f40919f, z ? 2 : 153, ((g) this).a.j.getTouchCoords(), ((g) this).a.f40745e);
        ((g) this).a.f40742b.a();
    }

    private void e() {
        if (this.i) {
            this.f40915b.a();
            this.f40915b.setVisibility(8);
            this.f40916c.a();
            this.f40916c.setVisibility(8);
            this.f40917d.a();
            this.f40917d.setVisibility(8);
            this.f40918e.a();
            this.f40918e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (((g) this).a.f40746f == 0) {
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
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f40920g);
        return J.height > J.width;
    }

    private void s() {
        this.f40915b.a(this.f40919f, ((g) this).a.f40745e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.2
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f40915b.setVisibility(0);
    }

    private void t() {
        this.f40916c.a(this.f40919f, ((g) this).a.f40745e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.3
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f40916c.setVisibility(0);
    }

    private void u() {
        this.f40917d.a(this.f40919f, ((g) this).a.f40745e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.4
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f40917d.setVisibility(0);
    }

    private void v() {
        this.f40918e.a(this.f40919f, ((g) this).a.f40745e, new com.kwad.sdk.reward.widget.tailframe.a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.5
            @Override // com.kwad.sdk.reward.widget.tailframe.a
            public void a(boolean z) {
                c.this.b(z);
            }
        });
        this.f40918e.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40915b.setCallerContext(((g) this).a);
        this.f40916c.setCallerContext(((g) this).a);
        this.f40917d.setCallerContext(((g) this).a);
        this.f40918e.setCallerContext(((g) this).a);
        AdTemplate adTemplate = ((g) this).a.f40747g;
        this.f40919f = adTemplate;
        this.f40920g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f40921h = aVar.o;
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
        this.f40915b = (TailFramePortraitVertical) a(R.id.obfuscated_res_0x7f091179);
        this.f40916c = (TailFramePortraitHorizontal) a(R.id.obfuscated_res_0x7f091178);
        this.f40917d = (TailFrameLandscapeVertical) a(R.id.obfuscated_res_0x7f091171);
        this.f40918e = (TailFrameLandscapeHorizontal) a(R.id.obfuscated_res_0x7f091170);
    }
}
