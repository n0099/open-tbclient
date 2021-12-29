package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f58924b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f58925c;

    /* renamed from: d  reason: collision with root package name */
    public d f58926d = new e() { // from class: com.kwad.sdk.draw.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f58925c == null || !a.this.f58925c.d()) {
                a.this.e();
            } else {
                a.this.f58924b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f58924b.a();
        this.f58924b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f58925c = bVar.f58964g;
        this.f58924b.a(bVar.f58960c);
        this.f58924b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.f58959b);
        this.f58924b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.f58961d);
        this.f58924b.setVisibility(8);
        this.f58924b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
        ((com.kwad.sdk.draw.kwai.a) this).a.f58962e.a(this.f58926d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f58962e.b(this.f58926d);
        this.f58924b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f58924b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }
}
