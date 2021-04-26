package com.kwad.sdk.fullscreen.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34105b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34106c;

    /* renamed from: d  reason: collision with root package name */
    public f f34107d = new f() { // from class: com.kwad.sdk.fullscreen.a.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34108e = new e() { // from class: com.kwad.sdk.fullscreen.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((d) a.this).f34594a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34105b.setVisibility(8);
        this.f34106c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34105b.setVisibility(0);
        ((d) this).f34594a.a(this.f34107d);
        ((d) this).f34594a.f34324i.a(this.f34108e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34105b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f34106c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f34594a.b(this.f34107d);
        ((d) this).f34594a.f34324i.b(this.f34108e);
    }
}
