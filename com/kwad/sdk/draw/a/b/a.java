package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f55266b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f55267c;

    /* renamed from: d  reason: collision with root package name */
    public d f55268d = new e() { // from class: com.kwad.sdk.draw.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f55267c == null || !a.this.f55267c.d()) {
                a.this.e();
            } else {
                a.this.f55266b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f55266b.a();
        this.f55266b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f55267c = bVar.f55305g;
        this.f55266b.a(bVar.f55301c);
        this.f55266b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.f55300b);
        this.f55266b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.f55302d);
        this.f55266b.setVisibility(8);
        this.f55266b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
        ((com.kwad.sdk.draw.kwai.a) this).a.f55303e.a(this.f55268d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f55303e.b(this.f55268d);
        this.f55266b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55266b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }
}
