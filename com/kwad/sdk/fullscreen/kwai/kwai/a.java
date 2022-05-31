package com.kwad.sdk.fullscreen.kwai.kwai;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes5.dex */
public class a extends g {
    public TextView b;
    public com.kwad.sdk.contentalliance.detail.video.d c = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.b((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.b.setText(String.valueOf(i));
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setText(String.valueOf(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((g) this).a.g))));
        this.b.setVisibility(0);
        ((g) this).a.k.a(this.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (TextView) a(R.id.obfuscated_res_0x7f091132);
    }
}
