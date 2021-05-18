package com.kwad.sdk.a.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f31722b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f31723c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31724d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f31722b.getVisibility() == 0) {
                b.this.f31722b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f31725e = new Runnable() { // from class: com.kwad.sdk.a.b.b.2
        @Override // java.lang.Runnable
        public void run() {
            an.a(b.this.f31722b, b.this.f31723c.c(), b.this.f31723c.b());
            b.this.f31722b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f31722b, b.this.f31723c.a(), ((com.kwad.sdk.a.a.a) b.this).f31701a.f31705d);
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c Q = com.kwad.sdk.core.response.b.a.Q(com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.a.a.a) this).f31701a.f31705d));
        this.f31723c = Q;
        if (TextUtils.isEmpty(Q.a())) {
            return;
        }
        i().post(this.f31725e);
        this.f31722b.setVisibility(0);
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.a(this.f31724d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31722b = (ImageView) a(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        i().removeCallbacks(this.f31725e);
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.b(this.f31724d);
    }
}
