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
    public DrawVideoTailFrame f33116b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f33117c;

    /* renamed from: d  reason: collision with root package name */
    public d f33118d = new e() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f33117c == null || !a.this.f33117c.d()) {
                a.this.e();
            } else {
                a.this.f33116b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33116b.a();
        this.f33116b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33049a;
        this.f33117c = bVar.f33056g;
        this.f33116b.a(bVar.f33052c);
        this.f33116b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f33049a.f33051b);
        this.f33116b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f33049a.f33053d);
        this.f33116b.setVisibility(8);
        this.f33116b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f33049a.f33050a);
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33054e.a(this.f33118d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33116b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33054e.b(this.f33118d);
        this.f33116b.b();
    }
}
