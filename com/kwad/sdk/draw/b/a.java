package com.kwad.sdk.draw.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34823b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f34824c;

    /* renamed from: d  reason: collision with root package name */
    public e f34825d = new f() { // from class: com.kwad.sdk.draw.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f34823b.getVisibility() == 0) {
                a.this.f34823b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f34826e = new Runnable() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            int width = a.this.l().getWidth();
            ViewGroup.LayoutParams layoutParams = a.this.f34823b.getLayoutParams();
            int c2 = a.this.f34824c.c();
            int b2 = a.this.f34824c.b();
            if (c2 == 0 || b2 == 0 || b2 > c2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.f34823b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                a.this.f34823b.setLayoutParams(layoutParams);
                a.this.f34823b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            a.this.f34823b.setImageDrawable(null);
            KSImageLoader.loadImage(a.this.f34823b, a.this.f34824c.a(), ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34814c);
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c U = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.draw.a.a) this).f34811a.f34814c));
        this.f34824c = U;
        if (TextUtils.isEmpty(U.a())) {
            return;
        }
        l().post(this.f34826e);
        this.f34823b.setVisibility(0);
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.a(this.f34825d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.f34826e);
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.b(this.f34825d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34823b = (ImageView) b(R.id.ksad_video_first_frame);
    }
}
