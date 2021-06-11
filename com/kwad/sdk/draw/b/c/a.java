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
    public DrawVideoTailFrame f35240b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f35241c;

    /* renamed from: d  reason: collision with root package name */
    public e f35242d = new f() { // from class: com.kwad.sdk.draw.b.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            if (a.this.f35241c == null || !a.this.f35241c.d()) {
                a.this.e();
            } else {
                a.this.f35240b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f35240b.a();
        this.f35240b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f35173a;
        this.f35241c = bVar.f35180g;
        this.f35240b.a(bVar.f35176c);
        this.f35240b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f35173a.f35175b);
        this.f35240b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f35173a.f35177d);
        this.f35240b.setVisibility(8);
        this.f35240b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f35173a.f35174a);
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.a(this.f35242d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.b(this.f35242d);
        this.f35240b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35240b = (DrawVideoTailFrame) b(R.id.ksad_video_tail_frame);
    }
}
