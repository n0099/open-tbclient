package com.kwad.sdk.f.a;

import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class k extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f40450b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40451c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.k.1
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
        this.f40450b.setProgress(i);
        if (this.f40450b.getVisibility() == 0) {
            return;
        }
        this.f40450b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f40450b.getVisibility() != 0) {
            return;
        }
        this.f40450b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40450b.setProgress(0);
        this.f40450b.setVisibility(8);
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.a(this.f40451c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.f40451c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40450b = (ProgressBar) a(R.id.obfuscated_res_0x7f09117a);
    }
}
