package com.kwad.sdk.a.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.ao;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8143b;
    private com.kwad.sdk.core.response.model.c c;
    private com.kwad.sdk.contentalliance.detail.video.e d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (b.this.f8143b.getVisibility() == 0) {
                b.this.f8143b.setVisibility(8);
            }
        }
    };
    private Runnable e = new Runnable() { // from class: com.kwad.sdk.a.b.b.2
        @Override // java.lang.Runnable
        public void run() {
            ao.a(b.this.f8143b, b.this.c.c(), b.this.c.b());
            b.this.f8143b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f8143b, b.this.c.a(), b.this.f8136a.d);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.j(this.f8136a.d));
        if (TextUtils.isEmpty(this.c.a())) {
            return;
        }
        l().post(this.e);
        this.f8143b.setVisibility(0);
        this.f8136a.f.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.e);
        this.f8136a.f.b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8143b = (ImageView) b(R.id.ksad_video_first_frame);
    }
}
