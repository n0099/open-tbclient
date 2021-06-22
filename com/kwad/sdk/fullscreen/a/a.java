package com.kwad.sdk.fullscreen.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes7.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35761b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f35762c;

    /* renamed from: d  reason: collision with root package name */
    public e f35763d = new e() { // from class: com.kwad.sdk.fullscreen.a.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f35764e = new f() { // from class: com.kwad.sdk.fullscreen.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            ((d) a.this).f37299a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f35761b.setVisibility(8);
        this.f35762c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f35761b.setVisibility(0);
        ((d) this).f37299a.n.add(this.f35763d);
        ((d) this).f37299a.f37056i.a(this.f35764e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37299a.n.remove(this.f35763d);
        ((d) this).f37299a.f37056i.b(this.f35764e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35761b = (ViewGroup) b(R.id.ksad_play_detail_top_toolbar);
        this.f35762c = (ViewGroup) b(R.id.ksad_play_end_top_toolbar);
    }
}
