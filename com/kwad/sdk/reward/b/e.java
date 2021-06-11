package com.kwad.sdk.reward.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f37179b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f37180c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.e f37181d = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.e.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            e.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f37182e = new f() { // from class: com.kwad.sdk.reward.b.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            ((com.kwad.sdk.reward.d) e.this).f37201a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f37179b.setVisibility(8);
        this.f37180c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f37179b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f37201a.n.add(this.f37181d);
        ((com.kwad.sdk.reward.d) this).f37201a.f36958i.a(this.f37182e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f37201a.n.remove(this.f37181d);
        ((com.kwad.sdk.reward.d) this).f37201a.f36958i.b(this.f37182e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37179b = (ViewGroup) b(R.id.ksad_play_detail_top_toolbar);
        this.f37180c = (ViewGroup) b(R.id.ksad_play_end_top_toolbar);
    }
}
