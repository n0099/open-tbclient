package com.kwad.sdk.f.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59023b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f59024c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59025d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f59023b.getVisibility() == 0) {
                b.this.f59023b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f59026e = new Runnable() { // from class: com.kwad.sdk.f.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.a.kwai.a.a(b.this.f59023b, b.this.f59024c.c(), b.this.f59024c.b());
            b.this.f59023b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f59023b, b.this.f59024c.a(), ((com.kwad.sdk.f.kwai.a) b.this).a.f59084d);
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f59084d));
        this.f59024c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.f59026e);
        this.f59023b.setVisibility(0);
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.a(this.f59025d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.f59026e);
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.b(this.f59025d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59023b = (ImageView) a(R.id.ksad_video_first_frame);
    }
}
