package com.kwad.sdk.draw.b.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f35338b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f35339c;

    /* renamed from: d  reason: collision with root package name */
    public e f35340d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.f35339c == null || !a.this.f35339c.d()) {
                a.this.e();
            } else {
                a.this.f35338b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f35338b.a();
        this.f35338b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f35271a;
        this.f35339c = bVar.f35278g;
        this.f35338b.a(bVar.f35274c);
        this.f35338b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f35271a.f35273b);
        this.f35338b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f35271a.f35275d);
        this.f35338b.setVisibility(8);
        this.f35338b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f35271a.f35272a);
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35276e.a(this.f35340d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35276e.b(this.f35340d);
        this.f35338b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35338b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
