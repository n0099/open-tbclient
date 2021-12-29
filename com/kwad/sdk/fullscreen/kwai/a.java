package com.kwad.sdk.fullscreen.kwai;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes3.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59161b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f59162c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59163d;

    /* renamed from: e  reason: collision with root package name */
    public f f59164e = new f() { // from class: com.kwad.sdk.fullscreen.kwai.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public d f59165f = new e() { // from class: com.kwad.sdk.fullscreen.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((g) a.this).a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (((g) this).a.t) {
            return;
        }
        this.f59161b.setVisibility(8);
        this.f59162c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        if (((g) this).a.t) {
            this.f59163d.setVisibility(0);
            this.f59161b.setVisibility(8);
            viewGroup = this.f59162c;
        } else {
            this.f59161b.setVisibility(0);
            viewGroup = this.f59163d;
        }
        viewGroup.setVisibility(8);
        ((g) this).a.a(this.f59164e);
        ((g) this).a.f59459k.a(this.f59165f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f59164e);
        ((g) this).a.f59459k.b(this.f59165f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59161b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f59162c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
        this.f59163d = (ViewGroup) a(R.id.ksad_js_top);
    }
}
