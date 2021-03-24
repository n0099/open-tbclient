package com.kwad.sdk.contentalliance.detail.photo.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32160b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.a f32161c = new com.kwad.sdk.contentalliance.home.swipe.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.a.1
        @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
        public void a(float f2) {
            a.this.a(f2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        this.f32160b.setAlpha(f2);
        this.f32160b.setVisibility(f2 == 0.0f ? 8 : 0);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        a(((com.kwad.sdk.contentalliance.detail.b) this).f32132a.l.getSourceType() == 0 ? 1.0f : 0.0f);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32155e.add(this.f32161c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32155e.remove(this.f32161c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32160b = (ViewGroup) b(R.id.ksad_video_bottom_container);
    }
}
