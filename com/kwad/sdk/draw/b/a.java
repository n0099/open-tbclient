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
    public ImageView f33132b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f33133c;

    /* renamed from: d  reason: collision with root package name */
    public d f33134d = new e() { // from class: com.kwad.sdk.draw.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (a.this.f33132b.getVisibility() == 0) {
                a.this.f33132b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f33135e = new Runnable() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            int width = a.this.i().getWidth();
            ViewGroup.LayoutParams layoutParams = a.this.f33132b.getLayoutParams();
            int c2 = a.this.f33133c.c();
            int b2 = a.this.f33133c.b();
            if (c2 == 0 || b2 == 0 || b2 > c2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.f33132b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                a.this.f33132b.setLayoutParams(layoutParams);
                a.this.f33132b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            a.this.f33132b.setImageDrawable(null);
            KSImageLoader.loadImage(a.this.f33132b, a.this.f33133c.a(), ((com.kwad.sdk.draw.a.a) a.this).f33120a.f33123c);
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c Q = com.kwad.sdk.core.response.b.a.Q(com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.draw.a.a) this).f33120a.f33123c));
        this.f33133c = Q;
        if (TextUtils.isEmpty(Q.a())) {
            return;
        }
        i().post(this.f33135e);
        this.f33132b.setVisibility(0);
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.a(this.f33134d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33132b = (ImageView) a(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        i().removeCallbacks(this.f33135e);
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.b(this.f33134d);
    }
}
