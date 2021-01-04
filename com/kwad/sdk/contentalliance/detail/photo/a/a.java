package com.kwad.sdk.contentalliance.detail.photo.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8703b;
    private com.kwad.sdk.contentalliance.home.swipe.a c = new com.kwad.sdk.contentalliance.home.swipe.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.a.1
        @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
        public void a(float f) {
            a.this.a(f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        this.f8703b.setAlpha(f);
        this.f8703b.setVisibility(f == 0.0f ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        a(this.f8692a.l.getSourceType() == 0 ? 1.0f : 0.0f);
        this.f8692a.e.add(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8692a.e.remove(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8703b = (ViewGroup) b(R.id.ksad_video_bottom_container);
    }
}
