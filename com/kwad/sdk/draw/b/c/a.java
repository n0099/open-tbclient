package com.kwad.sdk.draw.b.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f34876b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f34877c;

    /* renamed from: d  reason: collision with root package name */
    public e f34878d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.f34877c == null || !a.this.f34877c.d()) {
                a.this.e();
            } else {
                a.this.f34876b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34876b.a();
        this.f34876b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34811a;
        this.f34877c = bVar.f34818g;
        this.f34876b.a(bVar.f34814c);
        this.f34876b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f34811a.f34813b);
        this.f34876b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f34811a.f34815d);
        this.f34876b.setVisibility(8);
        this.f34876b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f34811a.f34812a);
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.a(this.f34878d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.b(this.f34878d);
        this.f34876b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34876b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
