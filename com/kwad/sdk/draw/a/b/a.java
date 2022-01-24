package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f56749b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f56750c;

    /* renamed from: d  reason: collision with root package name */
    public d f56751d = new e() { // from class: com.kwad.sdk.draw.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f56750c == null || !a.this.f56750c.d()) {
                a.this.e();
            } else {
                a.this.f56749b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f56749b.a();
        this.f56749b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f56750c = bVar.f56788g;
        this.f56749b.a(bVar.f56784c);
        this.f56749b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.f56783b);
        this.f56749b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.f56785d);
        this.f56749b.setVisibility(8);
        this.f56749b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
        ((com.kwad.sdk.draw.kwai.a) this).a.f56786e.a(this.f56751d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f56786e.b(this.f56751d);
        this.f56749b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56749b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }
}
