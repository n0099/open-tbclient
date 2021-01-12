package com.kwad.sdk.a.b;

import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes4.dex */
public class g extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8156b;
    private AdInfo c;
    private com.kwad.sdk.contentalliance.detail.video.e d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.g.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            g.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadImage(this.f8156b, com.kwad.sdk.core.response.b.a.f(this.c), this.f8136a.d);
        this.f8156b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = com.kwad.sdk.core.response.b.c.j(this.f8136a.d);
        this.f8136a.f.a(this.d);
        this.f8156b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8136a.f.b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8156b = (ImageView) b(R.id.ksad_video_cover_image);
    }
}
