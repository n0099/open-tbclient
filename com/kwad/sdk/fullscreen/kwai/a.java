package com.kwad.sdk.fullscreen.kwai;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55495b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f55496c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f55497d;

    /* renamed from: e  reason: collision with root package name */
    public f f55498e = new f() { // from class: com.kwad.sdk.fullscreen.kwai.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public d f55499f = new e() { // from class: com.kwad.sdk.fullscreen.kwai.a.2
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
        this.f55495b.setVisibility(8);
        this.f55496c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        if (((g) this).a.t) {
            this.f55497d.setVisibility(0);
            this.f55495b.setVisibility(8);
            viewGroup = this.f55496c;
        } else {
            this.f55495b.setVisibility(0);
            viewGroup = this.f55497d;
        }
        viewGroup.setVisibility(8);
        ((g) this).a.a(this.f55498e);
        ((g) this).a.k.a(this.f55499f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f55498e);
        ((g) this).a.k.b(this.f55499f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55495b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
        this.f55496c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
        this.f55497d = (ViewGroup) a(R.id.ksad_js_top);
    }
}
