package com.kwad.sdk.f.a;

import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class k extends com.kwad.sdk.f.kwai.a {
    public ProgressBar b;
    public com.kwad.sdk.contentalliance.detail.video.d c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.k.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            k.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            k.this.b(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            k.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.b.setProgress(i);
        if (this.b.getVisibility() == 0) {
            return;
        }
        this.b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.getVisibility() != 0) {
            return;
        }
        this.b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setProgress(0);
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
        this.b = (ProgressBar) a(R.id.obfuscated_res_0x7f091173);
    }
}
