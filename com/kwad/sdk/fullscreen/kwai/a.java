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
    public ViewGroup f56978b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f56979c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56980d;

    /* renamed from: e  reason: collision with root package name */
    public f f56981e = new f() { // from class: com.kwad.sdk.fullscreen.kwai.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public d f56982f = new e() { // from class: com.kwad.sdk.fullscreen.kwai.a.2
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
        this.f56978b.setVisibility(8);
        this.f56979c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        if (((g) this).a.t) {
            this.f56980d.setVisibility(0);
            this.f56978b.setVisibility(8);
            viewGroup = this.f56979c;
        } else {
            this.f56978b.setVisibility(0);
            viewGroup = this.f56980d;
        }
        viewGroup.setVisibility(8);
        ((g) this).a.a(this.f56981e);
        ((g) this).a.k.a(this.f56982f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f56981e);
        ((g) this).a.k.b(this.f56982f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56978b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f56979c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
        this.f56980d = (ViewGroup) a(R.id.ksad_js_top);
    }
}
