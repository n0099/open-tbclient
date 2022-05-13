package com.kwad.sdk.draw.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.draw.kwai.a {
    public ImageView b;
    public com.kwad.sdk.core.response.model.c c;
    public com.kwad.sdk.contentalliance.detail.video.d d = new e() { // from class: com.kwad.sdk.draw.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.b.getVisibility() == 0) {
                b.this.b.setVisibility(8);
            }
        }
    };
    public Runnable e = new Runnable() { // from class: com.kwad.sdk.draw.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            int width = b.this.m().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.b.getLayoutParams();
            int c = b.this.c.c();
            int b = b.this.c.b();
            if (c == 0 || b == 0 || b > c) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((b / (c * 1.0f)) * width);
                b.this.b.setLayoutParams(layoutParams);
                b.this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.b, b.this.c.a(), ((com.kwad.sdk.draw.kwai.a) b.this).a.c);
        }
    };

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.draw.kwai.a) this).a.c));
        this.c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.e);
        this.b.setVisibility(0);
        ((com.kwad.sdk.draw.kwai.a) this).a.e.a(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.e);
        ((com.kwad.sdk.draw.kwai.a) this).a.e.b(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ImageView) a(R.id.obfuscated_res_0x7f091176);
    }
}
