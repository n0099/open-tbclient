package com.kwad.sdk.draw.a;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.draw.kwai.a {
    public TextView b;
    public com.kwad.sdk.contentalliance.detail.video.d c = new e() { // from class: com.kwad.sdk.draw.a.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            d.this.b.setVisibility(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.b.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            d.this.b.setVisibility(8);
        }
    };

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        super.a();
        if (com.ksad.download.c.b.a(q())) {
            textView = this.b;
            i = 8;
        } else {
            textView = this.b;
            i = 0;
        }
        textView.setVisibility(i);
        ((com.kwad.sdk.draw.kwai.a) this).a.e.a(this.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.e.b(this.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (TextView) a(R.id.obfuscated_res_0x7f091165);
    }
}
