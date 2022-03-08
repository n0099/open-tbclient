package com.kwad.sdk.draw.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes8.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f55262b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f55263c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55264d = new e() { // from class: com.kwad.sdk.draw.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f55262b.getVisibility() == 0) {
                b.this.f55262b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f55265e = new Runnable() { // from class: com.kwad.sdk.draw.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            int width = b.this.m().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.f55262b.getLayoutParams();
            int c2 = b.this.f55263c.c();
            int b2 = b.this.f55263c.b();
            if (c2 == 0 || b2 == 0 || b2 > c2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.f55262b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                b.this.f55262b.setLayoutParams(layoutParams);
                b.this.f55262b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.f55262b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f55262b, b.this.f55263c.a(), ((com.kwad.sdk.draw.kwai.a) b.this).a.f55301c);
        }
    };

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.draw.kwai.a) this).a.f55301c));
        this.f55263c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.f55265e);
        this.f55262b.setVisibility(0);
        ((com.kwad.sdk.draw.kwai.a) this).a.f55303e.a(this.f55264d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.f55265e);
        ((com.kwad.sdk.draw.kwai.a) this).a.f55303e.b(this.f55264d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55262b = (ImageView) a(R.id.ksad_video_first_frame);
    }
}
