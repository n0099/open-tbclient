package com.kwad.sdk.draw.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9681b;
    private com.kwad.sdk.core.response.model.c c;
    private e d = new f() { // from class: com.kwad.sdk.draw.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f9681b.getVisibility() == 0) {
                a.this.f9681b.setVisibility(8);
            }
        }
    };
    private Runnable e = new Runnable() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            int width = a.this.l().getWidth();
            ViewGroup.LayoutParams layoutParams = a.this.f9681b.getLayoutParams();
            int c = a.this.c.c();
            int b2 = a.this.c.b();
            if (c == 0 || b2 == 0 || b2 > c) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.f9681b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) (width * (b2 / (c * 1.0f)));
                a.this.f9681b.setLayoutParams(layoutParams);
                a.this.f9681b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            a.this.f9681b.setImageDrawable(null);
            KSImageLoader.loadImage(a.this.f9681b, a.this.c.a(), a.this.f9675a.c);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.j(this.f9675a.c));
        if (TextUtils.isEmpty(this.c.a())) {
            return;
        }
        l().post(this.e);
        this.f9681b.setVisibility(0);
        this.f9675a.e.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.e);
        this.f9675a.e.b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9681b = (ImageView) b(R.id.ksad_video_first_frame);
    }
}
