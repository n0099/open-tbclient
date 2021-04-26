package com.kwad.sdk.reward.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34560b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34561c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f34562d = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.b.e.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            e.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34563e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((com.kwad.sdk.reward.d) e.this).f34594a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34560b.setVisibility(8);
        this.f34561c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34560b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f34594a.a(this.f34562d);
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.a(this.f34563e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34560b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f34561c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.b(this.f34562d);
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.f34563e);
    }
}
