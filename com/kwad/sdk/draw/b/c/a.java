package com.kwad.sdk.draw.b.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    private DrawVideoTailFrame f10004b;
    @Nullable
    private c c;
    private e d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.c == null || !a.this.c.d()) {
                a.this.e();
            } else {
                a.this.f10004b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f10004b.a();
        this.f10004b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f9972a.g;
        this.f10004b.a(this.f9972a.c);
        this.f10004b.setAdBaseFrameLayout(this.f9972a.f9974b);
        this.f10004b.setApkDownloadHelper(this.f9972a.d);
        this.f10004b.setVisibility(8);
        this.f10004b.setAdInteractionListener(this.f9972a.f9973a);
        this.f9972a.e.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9972a.e.b(this.d);
        this.f10004b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10004b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
