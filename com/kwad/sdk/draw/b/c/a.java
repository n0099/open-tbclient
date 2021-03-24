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
    public DrawVideoTailFrame f34586b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f34587c;

    /* renamed from: d  reason: collision with root package name */
    public e f34588d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.f34587c == null || !a.this.f34587c.d()) {
                a.this.e();
            } else {
                a.this.f34586b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34586b.a();
        this.f34586b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34521a;
        this.f34587c = bVar.f34528g;
        this.f34586b.a(bVar.f34524c);
        this.f34586b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f34521a.f34523b);
        this.f34586b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f34521a.f34525d);
        this.f34586b.setVisibility(8);
        this.f34586b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f34521a.f34522a);
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34526e.a(this.f34588d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34526e.b(this.f34588d);
        this.f34586b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34586b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
