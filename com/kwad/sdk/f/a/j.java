package com.kwad.sdk.f.a;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class j extends com.kwad.sdk.f.kwai.a {
    public View b;
    public com.kwad.sdk.contentalliance.detail.video.d c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.j.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            j.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.getVisibility() == 0) {
            return;
        }
        this.b.setVisibility(0);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setVisibility(8);
        ((com.kwad.sdk.f.kwai.a) this).a.f.a(this.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f.b(this.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = a(R.id.obfuscated_res_0x7f091126);
    }
}
