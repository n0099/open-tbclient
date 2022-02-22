package com.kwad.sdk.fullscreen.kwai.kwai;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public TextView f57150b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57151c = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            a.this.b((int) ((((float) (j2 - j3)) / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f57150b.setText(String.valueOf(i2));
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57150b.setText(String.valueOf(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((g) this).a.f57419g))));
        this.f57150b.setVisibility(0);
        ((g) this).a.k.a(this.f57151c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f57151c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57150b = (TextView) a(R.id.ksad_video_count_down);
    }
}
