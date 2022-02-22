package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f56916b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f56917c;

    /* renamed from: d  reason: collision with root package name */
    public d f56918d = new e() { // from class: com.kwad.sdk.draw.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f56917c == null || !a.this.f56917c.d()) {
                a.this.e();
            } else {
                a.this.f56916b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f56916b.a();
        this.f56916b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f56917c = bVar.f56955g;
        this.f56916b.a(bVar.f56951c);
        this.f56916b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.f56950b);
        this.f56916b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.f56952d);
        this.f56916b.setVisibility(8);
        this.f56916b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
        ((com.kwad.sdk.draw.kwai.a) this).a.f56953e.a(this.f56918d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f56953e.b(this.f56918d);
        this.f56916b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56916b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }
}
