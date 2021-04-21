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
    public DrawVideoTailFrame f34971b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f34972c;

    /* renamed from: d  reason: collision with root package name */
    public e f34973d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.f34972c == null || !a.this.f34972c.d()) {
                a.this.e();
            } else {
                a.this.f34971b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34971b.a();
        this.f34971b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34906a;
        this.f34972c = bVar.f34913g;
        this.f34971b.a(bVar.f34909c);
        this.f34971b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f34906a.f34908b);
        this.f34971b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f34906a.f34910d);
        this.f34971b.setVisibility(8);
        this.f34971b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f34906a.f34907a);
        ((com.kwad.sdk.draw.a.a) this).f34906a.f34911e.a(this.f34973d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34906a.f34911e.b(this.f34973d);
        this.f34971b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34971b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
