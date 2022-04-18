package com.kwad.sdk.f.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.f.kwai.a {
    public ImageView b;
    public com.kwad.sdk.core.response.model.c c;
    public com.kwad.sdk.contentalliance.detail.video.d d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.b.getVisibility() == 0) {
                b.this.b.setVisibility(8);
            }
        }
    };
    public Runnable e = new Runnable() { // from class: com.kwad.sdk.f.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.a.kwai.a.a(b.this.b, b.this.c.c(), b.this.c.b());
            b.this.b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.b, b.this.c.a(), ((com.kwad.sdk.f.kwai.a) b.this).a.d);
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.d));
        this.c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.e);
        this.b.setVisibility(0);
        ((com.kwad.sdk.f.kwai.a) this).a.f.a(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.e);
        ((com.kwad.sdk.f.kwai.a) this).a.f.b(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ImageView) a(R.id.obfuscated_res_0x7f091167);
    }
}
