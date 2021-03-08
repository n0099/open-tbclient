package com.kwad.sdk.draw.b.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.a.a {
    private DrawVideoTailFrame b;
    @Nullable
    private c c;
    private e d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.c == null || !a.this.c.d()) {
                a.this.e();
            } else {
                a.this.b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.a();
        this.b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f6403a.g;
        this.b.a(this.f6403a.c);
        this.b.setAdBaseFrameLayout(this.f6403a.b);
        this.b.setApkDownloadHelper(this.f6403a.d);
        this.b.setVisibility(8);
        this.b.setAdInteractionListener(this.f6403a.f6404a);
        this.f6403a.e.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f6403a.e.b(this.d);
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
