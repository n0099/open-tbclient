package com.kwad.sdk.fullscreen.kwai;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes5.dex */
public class a extends g {
    public ViewGroup b;
    public ViewGroup c;
    public ViewGroup d;
    public f e = new f() { // from class: com.kwad.sdk.fullscreen.kwai.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.e();
        }
    };
    public d f = new e() { // from class: com.kwad.sdk.fullscreen.kwai.a.2
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
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        if (((g) this).a.t) {
            this.d.setVisibility(0);
            this.b.setVisibility(8);
            viewGroup = this.c;
        } else {
            this.b.setVisibility(0);
            viewGroup = this.d;
        }
        viewGroup.setVisibility(8);
        ((g) this).a.a(this.e);
        ((g) this).a.k.a(this.f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.e);
        ((g) this).a.k.b(this.f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f0910c8);
        this.c = (ViewGroup) a(R.id.obfuscated_res_0x7f0910c9);
        this.d = (ViewGroup) a(R.id.obfuscated_res_0x7f0910b3);
    }
}
