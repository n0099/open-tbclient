package com.kwad.sdk.f.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f40416b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f40417c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40418d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (b.this.f40416b.getVisibility() == 0) {
                b.this.f40416b.setVisibility(8);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f40419e = new Runnable() { // from class: com.kwad.sdk.f.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.a.kwai.a.a(b.this.f40416b, b.this.f40417c.c(), b.this.f40417c.b());
            b.this.f40416b.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.f40416b, b.this.f40417c.a(), ((com.kwad.sdk.f.kwai.a) b.this).a.f40469d);
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f40469d));
        this.f40417c = aa;
        if (TextUtils.isEmpty(aa.a())) {
            return;
        }
        m().post(this.f40419e);
        this.f40416b.setVisibility(0);
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.a(this.f40418d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m().removeCallbacks(this.f40419e);
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.f40418d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40416b = (ImageView) a(R.id.obfuscated_res_0x7f09116d);
    }
}
