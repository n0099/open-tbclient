package com.kwad.sdk.draw.b.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f33942b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f33943c;

    /* renamed from: d  reason: collision with root package name */
    public d f33944d = new e() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f33943c == null || !a.this.f33943c.d()) {
                a.this.e();
            } else {
                a.this.f33942b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33942b.a();
        this.f33942b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33875a;
        this.f33943c = bVar.f33882g;
        this.f33942b.a(bVar.f33878c);
        this.f33942b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f33875a.f33877b);
        this.f33942b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f33875a.f33879d);
        this.f33942b.setVisibility(8);
        this.f33942b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f33875a.f33876a);
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33880e.a(this.f33944d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33942b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33880e.b(this.f33944d);
        this.f33942b.b();
    }
}
