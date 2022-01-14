package com.kwad.sdk.draw.a;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f56720b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56721c = new e() { // from class: com.kwad.sdk.draw.a.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            d.this.f56720b.setVisibility(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.f56720b.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            d.this.f56720b.setVisibility(8);
        }
    };

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i2;
        super.a();
        if (com.ksad.download.c.b.a(q())) {
            textView = this.f56720b;
            i2 = 8;
        } else {
            textView = this.f56720b;
            i2 = 0;
        }
        textView.setVisibility(i2);
        ((com.kwad.sdk.draw.kwai.a) this).a.f56741e.a(this.f56721c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f56741e.b(this.f56721c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56720b = (TextView) a(R.id.ksad_video_fail_tip);
    }
}
