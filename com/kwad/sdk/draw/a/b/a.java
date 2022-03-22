package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f40327b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f40328c;

    /* renamed from: d  reason: collision with root package name */
    public d f40329d = new e() { // from class: com.kwad.sdk.draw.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            if (a.this.f40328c == null || !a.this.f40328c.d()) {
                a.this.e();
            } else {
                a.this.f40327b.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f40327b.a();
        this.f40327b.setVisibility(0);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f40328c = bVar.f40364g;
        this.f40327b.a(bVar.f40360c);
        this.f40327b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.f40359b);
        this.f40327b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.f40361d);
        this.f40327b.setVisibility(8);
        this.f40327b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.a(this.f40329d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.b(this.f40329d);
        this.f40327b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40327b = (DrawVideoTailFrame) a(R.id.obfuscated_res_0x7f09117d);
    }
}
