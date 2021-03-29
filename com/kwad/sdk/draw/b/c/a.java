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
    public DrawVideoTailFrame f34587b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f34588c;

    /* renamed from: d  reason: collision with root package name */
    public e f34589d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.f34588c == null || !a.this.f34588c.d()) {
                a.this.e();
            } else {
                a.this.f34587b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34587b.a();
        this.f34587b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34522a;
        this.f34588c = bVar.f34529g;
        this.f34587b.a(bVar.f34525c);
        this.f34587b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f34522a.f34524b);
        this.f34587b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f34522a.f34526d);
        this.f34587b.setVisibility(8);
        this.f34587b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f34522a.f34523a);
        ((com.kwad.sdk.draw.a.a) this).f34522a.f34527e.a(this.f34589d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34522a.f34527e.b(this.f34589d);
        this.f34587b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34587b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
