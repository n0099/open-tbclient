package com.kwad.sdk.a.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.a.a.a {
    private ImageView b;
    private com.kwad.sdk.core.response.model.c c;
    private com.kwad.sdk.contentalliance.detail.video.e d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (b.this.b.getVisibility() == 0) {
                b.this.b.setVisibility(8);
            }
        }
    };
    private Runnable e = new Runnable() { // from class: com.kwad.sdk.a.b.b.2
        @Override // java.lang.Runnable
        public void run() {
            ao.a(b.this.b, b.this.c.c(), b.this.c.b());
            b.this.b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.b, b.this.c.a(), b.this.f5425a.d);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.j(this.f5425a.d));
        if (TextUtils.isEmpty(this.c.a())) {
            return;
        }
        l().post(this.e);
        this.b.setVisibility(0);
        this.f5425a.f.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.e);
        this.f5425a.f.b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (ImageView) b(R.id.ksad_video_first_frame);
    }
}
