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
    public com.kwad.sdk.contentalliance.detail.photo.g.a.a f33023b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33025d;

    /* renamed from: c  reason: collision with root package name */
    public long f33024c = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f33026e = 2;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f33027f = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.e.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            e.this.f33023b.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            if (e.this.f33025d) {
                e.this.f33023b.setVisibility(0);
            }
        }
    };

    private boolean c(int i2) {
        return i2 == 1;
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j);
        boolean v = com.kwad.sdk.core.response.b.d.v(k);
        this.f33025d = v;
        if (v) {
            this.f33026e = com.kwad.sdk.core.response.b.d.w(k);
            long o = com.kwad.sdk.core.response.b.d.o(k);
            this.f33024c = o;
            this.f33023b.setAuthorId(o);
            this.f33023b.setAlignment(c(this.f33026e) ? 1 : 0);
            a(this.f33026e);
            this.f33023b.setVisibility(0);
            if (!com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j)) {
                return;
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.a(this.f33027f);
            if (!((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32811a.l) {
                this.f33023b.setVisibility(0);
                return;
            }
        }
        this.f33023b.setVisibility(4);
    }

    public void a(int i2) {
        Context o;
        float f2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f33023b.getLayoutParams();
        if (i2 == 2) {
            layoutParams.gravity = 3;
            layoutParams.leftMargin = ao.a(o(), 12.0f);
        } else {
            layoutParams.gravity = 5;
            layoutParams.rightMargin = ao.a(o(), 12.0f);
        }
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j;
        if (!adTemplate.mIsTubeEpisodeList) {
            if (com.kwad.sdk.core.response.b.c.B(adTemplate)) {
                o = o();
                f2 = 105.0f;
            }
            this.f33023b.setLayoutParams(layoutParams);
        }
        o = o();
        f2 = 95.0f;
        layoutParams.topMargin = ao.a(o, f2);
        this.f33023b.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.b(this.f33027f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33023b = (com.kwad.sdk.contentalliance.detail.photo.g.a.a) b(R.id.ksad_video_water_mark);
    }
}
