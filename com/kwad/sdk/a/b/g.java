package com.kwad.sdk.a.b;

import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f31711b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f31712c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31713d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.g.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            g.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadImage(this.f31711b, com.kwad.sdk.core.response.b.a.f(this.f31712c), ((com.kwad.sdk.a.a.a) this).f31664a.f31668d);
        this.f31711b.setVisibility(0);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f31712c = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.a.a.a) this).f31664a.f31668d);
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.a(this.f31713d);
        this.f31711b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.b(this.f31713d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31711b = (ImageView) b(R.id.ksad_video_cover_image);
    }
}
