package com.kwad.sdk.reward.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33805b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33806c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f33807d = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.b.e.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            e.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33808e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((com.kwad.sdk.reward.d) e.this).f33839a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33805b.setVisibility(8);
        this.f33806c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33805b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f33839a.a(this.f33807d);
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.a(this.f33808e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33805b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f33806c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33839a.b(this.f33807d);
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.b(this.f33808e);
    }
}
