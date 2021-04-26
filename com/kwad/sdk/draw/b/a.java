package com.kwad.sdk.draw.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33887b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f33888c;

    /* renamed from: d  reason: collision with root package name */
    public d f33889d = new e() { // from class: com.kwad.sdk.draw.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (a.this.f33887b.getVisibility() == 0) {
                a.this.f33887b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f33890e = new Runnable() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            int width = a.this.i().getWidth();
            ViewGroup.LayoutParams layoutParams = a.this.f33887b.getLayoutParams();
            int c2 = a.this.f33888c.c();
            int b2 = a.this.f33888c.b();
            if (c2 == 0 || b2 == 0 || b2 > c2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.f33887b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                a.this.f33887b.setLayoutParams(layoutParams);
                a.this.f33887b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            a.this.f33887b.setImageDrawable(null);
            KSImageLoader.loadImage(a.this.f33887b, a.this.f33888c.a(), ((com.kwad.sdk.draw.a.a) a.this).f33875a.f33878c);
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c Q = com.kwad.sdk.core.response.b.a.Q(com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.draw.a.a) this).f33875a.f33878c));
        this.f33888c = Q;
        if (TextUtils.isEmpty(Q.a())) {
            return;
        }
        i().post(this.f33890e);
        this.f33887b.setVisibility(0);
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33880e.a(this.f33889d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33887b = (ImageView) a(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        i().removeCallbacks(this.f33890e);
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33880e.b(this.f33889d);
    }
}
