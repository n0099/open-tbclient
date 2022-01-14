package com.kwad.sdk.f.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56800b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f56801c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56802d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f56800b.getVisibility() == 0) {
                b.this.f56800b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f56803e = new Runnable() { // from class: com.kwad.sdk.f.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.a.kwai.a.a(b.this.f56800b, b.this.f56801c.c(), b.this.f56801c.b());
            b.this.f56800b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f56800b, b.this.f56801c.a(), ((com.kwad.sdk.f.kwai.a) b.this).a.f56859d);
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f56859d));
        this.f56801c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.f56803e);
        this.f56800b.setVisibility(0);
        ((com.kwad.sdk.f.kwai.a) this).a.f56861f.a(this.f56802d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.f56803e);
        ((com.kwad.sdk.f.kwai.a) this).a.f56861f.b(this.f56802d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56800b = (ImageView) a(R.id.ksad_video_first_frame);
    }
}
