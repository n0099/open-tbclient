package com.kwad.sdk.draw.a;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f40341b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40342c = new e() { // from class: com.kwad.sdk.draw.a.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            d.this.f40341b.setVisibility(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.f40341b.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            d.this.f40341b.setVisibility(8);
        }
    };

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        super.a();
        if (com.ksad.download.c.b.a(q())) {
            textView = this.f40341b;
            i = 8;
        } else {
            textView = this.f40341b;
            i = 0;
        }
        textView.setVisibility(i);
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.a(this.f40342c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.b(this.f40342c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40341b = (TextView) a(R.id.obfuscated_res_0x7f09116c);
    }
}
