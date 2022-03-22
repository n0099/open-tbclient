package com.kwad.sdk.fullscreen.kwai.kwai;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes7.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public TextView f40531b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40532c = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.b((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.f40531b.setText(String.valueOf(i));
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40531b.setText(String.valueOf(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((g) this).a.f40747g))));
        this.f40531b.setVisibility(0);
        ((g) this).a.k.a(this.f40532c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f40532c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40531b = (TextView) a(R.id.obfuscated_res_0x7f091167);
    }
}
