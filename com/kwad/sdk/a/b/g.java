package com.kwad.sdk.a.b;

import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f31679b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f31680c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31681d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.g.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            g.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadImage(this.f31679b, com.kwad.sdk.core.response.b.a.f(this.f31680c), ((com.kwad.sdk.a.a.a) this).f31630a.f31634d);
        this.f31679b.setVisibility(0);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f31680c = com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.a.a.a) this).f31630a.f31634d);
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.a(this.f31681d);
        this.f31679b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31679b = (ImageView) a(R.id.ksad_video_cover_image);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.b(this.f31681d);
    }
}
