package com.kwad.sdk.reward.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.reward.d {
    private ViewGroup b;
    private ViewGroup c;
    private com.kwad.sdk.reward.a.e d = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.e.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            e.this.e();
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e e = new f() { // from class: com.kwad.sdk.reward.b.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            e.this.f7028a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setVisibility(0);
        this.f7028a.n.add(this.d);
        this.f7028a.i.a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f7028a.n.remove(this.d);
        this.f7028a.i.b(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (ViewGroup) b(R.id.ksad_play_detail_top_toolbar);
        this.c = (ViewGroup) b(R.id.ksad_play_end_top_toolbar);
    }
}
