package com.kwad.sdk.a.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f31974b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f31975c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31976d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (b.this.f31974b.getVisibility() == 0) {
                b.this.f31974b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f31977e = new Runnable() { // from class: com.kwad.sdk.a.b.b.2
        @Override // java.lang.Runnable
        public void run() {
            ao.a(b.this.f31974b, b.this.f31975c.c(), b.this.f31975c.b());
            b.this.f31974b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f31974b, b.this.f31975c.a(), ((com.kwad.sdk.a.a.a) b.this).f31954a.f31958d);
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c U = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.a.a.a) this).f31954a.f31958d));
        this.f31975c = U;
        if (TextUtils.isEmpty(U.a())) {
            return;
        }
        l().post(this.f31977e);
        this.f31974b.setVisibility(0);
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.a(this.f31976d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.f31977e);
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.b(this.f31976d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31974b = (ImageView) b(R.id.ksad_video_first_frame);
    }
}
