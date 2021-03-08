package com.kwad.sdk.contentalliance.detail.photo.e;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.contentalliance.detail.b {
    private com.kwad.sdk.contentalliance.detail.photo.g.a.a b;
    private boolean d;
    private long c = 0;
    private int e = 2;
    private com.kwad.sdk.contentalliance.trends.view.c f = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.e.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            e.this.b.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            if (e.this.d) {
                e.this.b.setVisibility(0);
            }
        }
    };

    private boolean c(int i) {
        return i == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.f5594a.j);
        this.d = com.kwad.sdk.core.response.b.d.v(k);
        if (!this.d) {
            this.b.setVisibility(4);
            return;
        }
        this.e = com.kwad.sdk.core.response.b.d.w(k);
        this.c = com.kwad.sdk.core.response.b.d.o(k);
        this.b.setAuthorId(this.c);
        this.b.setAlignment(c(this.e) ? 1 : 0);
        a(this.e);
        this.b.setVisibility(0);
        if (com.kwad.sdk.core.response.b.c.B(this.f5594a.j)) {
            this.f5594a.a(this.f);
            if (this.f5594a.f5600a.l) {
                this.b.setVisibility(4);
            } else {
                this.b.setVisibility(0);
            }
        }
    }

    public void a(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        if (i == 2) {
            layoutParams.gravity = 3;
            layoutParams.leftMargin = ao.a(o(), 12.0f);
        } else {
            layoutParams.gravity = 5;
            layoutParams.rightMargin = ao.a(o(), 12.0f);
        }
        if (this.f5594a.j.mIsTubeEpisodeList) {
            layoutParams.topMargin = ao.a(o(), 95.0f);
        } else if (com.kwad.sdk.core.response.b.c.B(this.f5594a.j)) {
            layoutParams.topMargin = ao.a(o(), 105.0f);
        }
        this.b.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f5594a.b(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (com.kwad.sdk.contentalliance.detail.photo.g.a.a) b(R.id.ksad_video_water_mark);
    }
}
