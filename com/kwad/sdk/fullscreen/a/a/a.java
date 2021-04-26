package com.kwad.sdk.fullscreen.a.a;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public TextView f34111b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34112c = new e() { // from class: com.kwad.sdk.fullscreen.a.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.b((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f34111b.setText(String.valueOf(i2));
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34111b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.reward.d) this).f34594a.f34321f))));
        this.f34111b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.a(this.f34112c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34111b = (TextView) a(R.id.ksad_video_count_down);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.f34112c);
    }
}
