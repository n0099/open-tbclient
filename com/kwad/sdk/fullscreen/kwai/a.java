package com.kwad.sdk.fullscreen.kwai;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes7.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40526b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f40527c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f40528d;

    /* renamed from: e  reason: collision with root package name */
    public f f40529e = new f() { // from class: com.kwad.sdk.fullscreen.kwai.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public d f40530f = new e() { // from class: com.kwad.sdk.fullscreen.kwai.a.2
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
        this.f40526b.setVisibility(8);
        this.f40527c.setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        super.a();
        if (((g) this).a.t) {
            this.f40528d.setVisibility(0);
            this.f40526b.setVisibility(8);
            viewGroup = this.f40527c;
        } else {
            this.f40526b.setVisibility(0);
            viewGroup = this.f40528d;
        }
        viewGroup.setVisibility(8);
        ((g) this).a.a(this.f40529e);
        ((g) this).a.k.a(this.f40530f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f40529e);
        ((g) this).a.k.b(this.f40530f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40526b = (ViewGroup) a(R.id.obfuscated_res_0x7f0910bf);
        this.f40527c = (ViewGroup) a(R.id.obfuscated_res_0x7f0910c0);
        this.f40528d = (ViewGroup) a(R.id.obfuscated_res_0x7f0910aa);
    }
}
