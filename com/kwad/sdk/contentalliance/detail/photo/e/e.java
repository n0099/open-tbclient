package com.kwad.sdk.contentalliance.detail.photo.e;

import android.content.Context;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.g.a.a f32925b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32927d;

    /* renamed from: c  reason: collision with root package name */
    public long f32926c = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f32928e = 2;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f32929f = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.e.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            e.this.f32925b.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            if (e.this.f32927d) {
                e.this.f32925b.setVisibility(0);
            }
        }
    };

    private boolean c(int i2) {
        return i2 == 1;
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j);
        boolean v = com.kwad.sdk.core.response.b.d.v(k);
        this.f32927d = v;
        if (v) {
            this.f32928e = com.kwad.sdk.core.response.b.d.w(k);
            long o = com.kwad.sdk.core.response.b.d.o(k);
            this.f32926c = o;
            this.f32925b.setAuthorId(o);
            this.f32925b.setAlignment(c(this.f32928e) ? 1 : 0);
            a(this.f32928e);
            this.f32925b.setVisibility(0);
            if (!com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j)) {
                return;
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.a(this.f32929f);
            if (!((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32713a.l) {
                this.f32925b.setVisibility(0);
                return;
            }
        }
        this.f32925b.setVisibility(4);
    }

    public void a(int i2) {
        Context o;
        float f2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f32925b.getLayoutParams();
        if (i2 == 2) {
            layoutParams.gravity = 3;
            layoutParams.leftMargin = ao.a(o(), 12.0f);
        } else {
            layoutParams.gravity = 5;
            layoutParams.rightMargin = ao.a(o(), 12.0f);
        }
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j;
        if (!adTemplate.mIsTubeEpisodeList) {
            if (com.kwad.sdk.core.response.b.c.B(adTemplate)) {
                o = o();
                f2 = 105.0f;
            }
            this.f32925b.setLayoutParams(layoutParams);
        }
        o = o();
        f2 = 95.0f;
        layoutParams.topMargin = ao.a(o, f2);
        this.f32925b.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.b(this.f32929f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32925b = (com.kwad.sdk.contentalliance.detail.photo.g.a.a) b(R.id.ksad_video_water_mark);
    }
}
