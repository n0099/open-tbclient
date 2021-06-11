package com.kwad.sdk.draw.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35185b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f35186c;

    /* renamed from: d  reason: collision with root package name */
    public e f35187d = new f() { // from class: com.kwad.sdk.draw.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f35185b.getVisibility() == 0) {
                a.this.f35185b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f35188e = new Runnable() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            int width = a.this.l().getWidth();
            ViewGroup.LayoutParams layoutParams = a.this.f35185b.getLayoutParams();
            int c2 = a.this.f35186c.c();
            int b2 = a.this.f35186c.b();
            if (c2 == 0 || b2 == 0 || b2 > c2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.f35185b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                a.this.f35185b.setLayoutParams(layoutParams);
                a.this.f35185b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            a.this.f35185b.setImageDrawable(null);
            KSImageLoader.loadImage(a.this.f35185b, a.this.f35186c.a(), ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35176c);
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c U = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.draw.a.a) this).f35173a.f35176c));
        this.f35186c = U;
        if (TextUtils.isEmpty(U.a())) {
            return;
        }
        l().post(this.f35188e);
        this.f35185b.setVisibility(0);
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.a(this.f35187d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.f35188e);
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.b(this.f35187d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35185b = (ImageView) b(R.id.ksad_video_first_frame);
    }
}
