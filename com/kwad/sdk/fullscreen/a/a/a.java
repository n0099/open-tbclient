package com.kwad.sdk.fullscreen.a.a;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public TextView f35381b;

    /* renamed from: c  reason: collision with root package name */
    public e f35382c = new f() { // from class: com.kwad.sdk.fullscreen.a.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            a.this.a((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f35381b.setText(String.valueOf(i));
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f35381b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f36842a.f36606f))));
        this.f35381b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f36842a.i.a(this.f35382c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36842a.i.b(this.f35382c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35381b = (TextView) b(R.id.ksad_video_count_down);
    }
}
