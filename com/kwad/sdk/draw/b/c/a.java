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
    public DrawVideoTailFrame f33187b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f33188c;

    /* renamed from: d  reason: collision with root package name */
    public d f33189d = new e() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f33188c == null || !a.this.f33188c.d()) {
                a.this.e();
            } else {
                a.this.f33187b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33187b.a();
        this.f33187b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33120a;
        this.f33188c = bVar.f33127g;
        this.f33187b.a(bVar.f33123c);
        this.f33187b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f33120a.f33122b);
        this.f33187b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f33120a.f33124d);
        this.f33187b.setVisibility(8);
        this.f33187b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f33120a.f33121a);
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.a(this.f33189d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33187b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.b(this.f33189d);
        this.f33187b.b();
    }
}
