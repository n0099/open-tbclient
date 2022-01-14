package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f56704b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f56705c;

    /* renamed from: d  reason: collision with root package name */
    public d f56706d = new e() { // from class: com.kwad.sdk.draw.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f56705c == null || !a.this.f56705c.d()) {
                a.this.e();
            } else {
                a.this.f56704b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f56704b.a();
        this.f56704b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f56705c = bVar.f56743g;
        this.f56704b.a(bVar.f56739c);
        this.f56704b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.f56738b);
        this.f56704b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.f56740d);
        this.f56704b.setVisibility(8);
        this.f56704b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
        ((com.kwad.sdk.draw.kwai.a) this).a.f56741e.a(this.f56706d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f56741e.b(this.f56706d);
        this.f56704b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56704b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }
}
