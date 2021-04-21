package com.kwad.sdk.reward.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f36821b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f36822c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.e f36823d = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.e.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            e.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36824e = new f() { // from class: com.kwad.sdk.reward.b.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            ((com.kwad.sdk.reward.d) e.this).f36842a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36821b.setVisibility(8);
        this.f36822c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f36821b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f36842a.n.add(this.f36823d);
        ((com.kwad.sdk.reward.d) this).f36842a.i.a(this.f36824e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36842a.n.remove(this.f36823d);
        ((com.kwad.sdk.reward.d) this).f36842a.i.b(this.f36824e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36821b = (ViewGroup) b(R.id.ksad_play_detail_top_toolbar);
        this.f36822c = (ViewGroup) b(R.id.ksad_play_end_top_toolbar);
    }
}
