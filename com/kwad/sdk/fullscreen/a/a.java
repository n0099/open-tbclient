package com.kwad.sdk.fullscreen.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33279b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33280c;

    /* renamed from: d  reason: collision with root package name */
    public f f33281d = new f() { // from class: com.kwad.sdk.fullscreen.a.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33282e = new e() { // from class: com.kwad.sdk.fullscreen.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((d) a.this).f33768a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33279b.setVisibility(8);
        this.f33280c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33279b.setVisibility(0);
        ((d) this).f33768a.a(this.f33281d);
        ((d) this).f33768a.f33498i.a(this.f33282e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33279b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f33280c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f33768a.b(this.f33281d);
        ((d) this).f33768a.f33498i.b(this.f33282e);
    }
}
