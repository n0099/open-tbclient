package com.kwad.sdk.reward.presenter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.af;
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.reward.g {
    public ViewGroup b;
    public ViewGroup c;
    public ViewGroup d;
    public ImageView e;
    public com.kwad.sdk.reward.a.f f = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.f.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            f.this.e();
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.f.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            ((com.kwad.sdk.reward.g) f.this).a.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!((com.kwad.sdk.reward.g) this).a.t) {
            this.b.setVisibility(8);
            this.c.setVisibility(0);
        }
        Context q = q();
        if (g() && af.e(q)) {
            this.e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        int i = 0;
        if (((com.kwad.sdk.reward.g) this).a.t) {
            this.d.setVisibility(0);
            viewGroup = this.b;
            i = 8;
        } else {
            viewGroup = this.b;
        }
        viewGroup.setVisibility(i);
        ((com.kwad.sdk.reward.g) this).a.a(this.f);
        ((com.kwad.sdk.reward.g) this).a.k.a(this.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.g) this).a.b(this.f);
        ((com.kwad.sdk.reward.g) this).a.k.b(this.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f0910c8);
        this.c = (ViewGroup) a(R.id.obfuscated_res_0x7f0910c9);
        this.d = (ViewGroup) a(R.id.obfuscated_res_0x7f0910b3);
        this.e = (ImageView) a(R.id.obfuscated_res_0x7f09104e);
    }
}
