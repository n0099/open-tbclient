package com.kwad.sdk.f.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56845b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f56846c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56847d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f56845b.getVisibility() == 0) {
                b.this.f56845b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f56848e = new Runnable() { // from class: com.kwad.sdk.f.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.a.kwai.a.a(b.this.f56845b, b.this.f56846c.c(), b.this.f56846c.b());
            b.this.f56845b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f56845b, b.this.f56846c.a(), ((com.kwad.sdk.f.kwai.a) b.this).a.f56904d);
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f56904d));
        this.f56846c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.f56848e);
        this.f56845b.setVisibility(0);
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.a(this.f56847d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.f56848e);
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.b(this.f56847d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56845b = (ImageView) a(R.id.ksad_video_first_frame);
    }
}
