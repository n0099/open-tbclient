package com.kwad.sdk.fullscreen.a.a;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.reward.d {
    private TextView b;
    private e c = new f() { // from class: com.kwad.sdk.fullscreen.a.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            a.this.a((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.b.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f7028a.f))));
        this.b.setVisibility(0);
        this.f7028a.i.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f7028a.i.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (TextView) b(R.id.ksad_video_count_down);
    }
}
