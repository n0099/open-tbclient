package com.kwad.sdk.a.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32227b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f32228c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32229d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (b.this.f32227b.getVisibility() == 0) {
                b.this.f32227b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f32230e = new Runnable() { // from class: com.kwad.sdk.a.b.b.2
        @Override // java.lang.Runnable
        public void run() {
            ao.a(b.this.f32227b, b.this.f32228c.c(), b.this.f32228c.b());
            b.this.f32227b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f32227b, b.this.f32228c.a(), ((com.kwad.sdk.a.a.a) b.this).f32206a.f32210d);
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c U = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.a.a.a) this).f32206a.f32210d));
        this.f32228c = U;
        if (TextUtils.isEmpty(U.a())) {
            return;
        }
        l().post(this.f32230e);
        this.f32227b.setVisibility(0);
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.a(this.f32229d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.f32230e);
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32229d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32227b = (ImageView) b(R.id.ksad_video_first_frame);
    }
}
