package com.kwad.sdk.reward.presenter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.af;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40991b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f40992c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f40993d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f40994e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f40995f = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.f.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            f.this.e();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40996g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.f.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((com.kwad.sdk.reward.g) f.this).a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!((com.kwad.sdk.reward.g) this).a.t) {
            this.f40991b.setVisibility(8);
            this.f40992c.setVisibility(0);
        }
        Context q = q();
        if (g() && af.e(q)) {
            this.f40994e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        int i = 0;
        if (((com.kwad.sdk.reward.g) this).a.t) {
            this.f40993d.setVisibility(0);
            viewGroup = this.f40991b;
            i = 8;
        } else {
            viewGroup = this.f40991b;
        }
        viewGroup.setVisibility(i);
        ((com.kwad.sdk.reward.g) this).a.a(this.f40995f);
        ((com.kwad.sdk.reward.g) this).a.k.a(this.f40996g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.g) this).a.b(this.f40995f);
        ((com.kwad.sdk.reward.g) this).a.k.b(this.f40996g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40991b = (ViewGroup) a(R.id.obfuscated_res_0x7f0910bf);
        this.f40992c = (ViewGroup) a(R.id.obfuscated_res_0x7f0910c0);
        this.f40993d = (ViewGroup) a(R.id.obfuscated_res_0x7f0910aa);
        this.f40994e = (ImageView) a(R.id.obfuscated_res_0x7f091045);
    }
}
