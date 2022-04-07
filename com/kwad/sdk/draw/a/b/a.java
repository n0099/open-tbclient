package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.draw.kwai.a {
    public DrawVideoTailFrame b;
    @Nullable
    public com.kwad.sdk.i.b c;
    public d d = new e() { // from class: com.kwad.sdk.draw.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.c == null || !a.this.c.d()) {
                a.this.e();
            } else {
                a.this.b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.a();
        this.b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.c = bVar.g;
        this.b.a(bVar.c);
        this.b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.b);
        this.b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.d);
        this.b.setVisibility(8);
        this.b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
        ((com.kwad.sdk.draw.kwai.a) this).a.e.a(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.e.b(this.d);
        this.b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (DrawVideoTailFrame) a(R.id.obfuscated_res_0x7f091176);
    }
}
