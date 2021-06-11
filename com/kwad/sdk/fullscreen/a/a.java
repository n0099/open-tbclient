package com.kwad.sdk.fullscreen.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes7.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35663b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f35664c;

    /* renamed from: d  reason: collision with root package name */
    public e f35665d = new e() { // from class: com.kwad.sdk.fullscreen.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f35666e = new f() { // from class: com.kwad.sdk.fullscreen.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            ((d) a.this).f37201a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f35663b.setVisibility(8);
        this.f35664c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f35663b.setVisibility(0);
        ((d) this).f37201a.n.add(this.f35665d);
        ((d) this).f37201a.f36958i.a(this.f35666e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37201a.n.remove(this.f35665d);
        ((d) this).f37201a.f36958i.b(this.f35666e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35663b = (ViewGroup) b(R.id.ksad_play_detail_top_toolbar);
        this.f35664c = (ViewGroup) b(R.id.ksad_play_end_top_toolbar);
    }
}
