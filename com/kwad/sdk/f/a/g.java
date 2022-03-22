package com.kwad.sdk.f.a;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f40437b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f40438c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40439d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.g.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            g.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadImage(this.f40437b, com.kwad.sdk.core.response.a.a.h(this.f40438c), ((com.kwad.sdk.f.kwai.a) this).a.f40469d);
        this.f40437b.setVisibility(0);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40438c = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f40469d);
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.a(this.f40439d);
        this.f40437b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.f40439d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40437b = (ImageView) a(R.id.obfuscated_res_0x7f09116a);
    }
}
