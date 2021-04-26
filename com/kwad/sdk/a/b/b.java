package com.kwad.sdk.a.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32477b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f32478c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f32479d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f32477b.getVisibility() == 0) {
                b.this.f32477b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f32480e = new Runnable() { // from class: com.kwad.sdk.a.b.b.2
        @Override // java.lang.Runnable
        public void run() {
            an.a(b.this.f32477b, b.this.f32478c.c(), b.this.f32478c.b());
            b.this.f32477b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f32477b, b.this.f32478c.a(), ((com.kwad.sdk.a.a.a) b.this).f32456a.f32460d);
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c Q = com.kwad.sdk.core.response.b.a.Q(com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.a.a.a) this).f32456a.f32460d));
        this.f32478c = Q;
        if (TextUtils.isEmpty(Q.a())) {
            return;
        }
        i().post(this.f32480e);
        this.f32477b.setVisibility(0);
        ((com.kwad.sdk.a.a.a) this).f32456a.f32462f.a(this.f32479d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f32477b = (ImageView) a(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        i().removeCallbacks(this.f32480e);
        ((com.kwad.sdk.a.a.a) this).f32456a.f32462f.b(this.f32479d);
    }
}
