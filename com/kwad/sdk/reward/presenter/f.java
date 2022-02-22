package com.kwad.sdk.reward.presenter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.af;
/* loaded from: classes4.dex */
public class f extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57690b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f57691c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57692d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57693e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f57694f = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.f.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            f.this.e();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57695g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.f.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((com.kwad.sdk.reward.g) f.this).a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!((com.kwad.sdk.reward.g) this).a.t) {
            this.f57690b.setVisibility(8);
            this.f57691c.setVisibility(0);
        }
        Context q = q();
        if (g() && af.e(q)) {
            this.f57693e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        int i2 = 0;
        if (((com.kwad.sdk.reward.g) this).a.t) {
            this.f57692d.setVisibility(0);
            viewGroup = this.f57690b;
            i2 = 8;
        } else {
            viewGroup = this.f57690b;
        }
        viewGroup.setVisibility(i2);
        ((com.kwad.sdk.reward.g) this).a.a(this.f57694f);
        ((com.kwad.sdk.reward.g) this).a.k.a(this.f57695g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.g) this).a.b(this.f57694f);
        ((com.kwad.sdk.reward.g) this).a.k.b(this.f57695g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57690b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f57691c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
        this.f57692d = (ViewGroup) a(R.id.ksad_js_top);
        this.f57693e = (ImageView) a(R.id.ksad_blur_end_cover);
    }
}
