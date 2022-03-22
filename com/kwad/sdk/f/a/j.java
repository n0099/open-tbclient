package com.kwad.sdk.f.a;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class j extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public View f40448b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40449c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.j.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            j.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f40448b.getVisibility() == 0) {
            return;
        }
        this.f40448b.setVisibility(0);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40448b.setVisibility(8);
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.a(this.f40449c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.f40449c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40448b = a(R.id.obfuscated_res_0x7f09116b);
    }
}
