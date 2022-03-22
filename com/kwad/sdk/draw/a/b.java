package com.kwad.sdk.draw.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f40323b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f40324c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40325d = new e() { // from class: com.kwad.sdk.draw.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f40323b.getVisibility() == 0) {
                b.this.f40323b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f40326e = new Runnable() { // from class: com.kwad.sdk.draw.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            int width = b.this.m().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.f40323b.getLayoutParams();
            int c2 = b.this.f40324c.c();
            int b2 = b.this.f40324c.b();
            if (c2 == 0 || b2 == 0 || b2 > c2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.f40323b.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                b.this.f40323b.setLayoutParams(layoutParams);
                b.this.f40323b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.f40323b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f40323b, b.this.f40324c.a(), ((com.kwad.sdk.draw.kwai.a) b.this).a.f40360c);
        }
    };

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.draw.kwai.a) this).a.f40360c));
        this.f40324c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.f40326e);
        this.f40323b.setVisibility(0);
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.a(this.f40325d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.f40326e);
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.b(this.f40325d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40323b = (ImageView) a(R.id.obfuscated_res_0x7f09116d);
    }
}
