package com.kwad.sdk.f.a;

import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56868b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56869c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56870d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.g.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            g.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadImage(this.f56868b, com.kwad.sdk.core.response.a.a.h(this.f56869c), ((com.kwad.sdk.f.kwai.a) this).a.f56904d);
        this.f56868b.setVisibility(0);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f56869c = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f56904d);
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.a(this.f56870d);
        this.f56868b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.b(this.f56870d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56868b = (ImageView) a(R.id.ksad_video_cover_image);
    }
}
