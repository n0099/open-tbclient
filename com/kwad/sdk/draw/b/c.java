package com.kwad.sdk.draw.b;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f35335b;

    /* renamed from: c  reason: collision with root package name */
    public e f35336c = new f() { // from class: com.kwad.sdk.draw.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            c.this.f35335b.setVisibility(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            c.this.f35335b.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            c.this.f35335b.setVisibility(8);
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i2;
        super.a();
        if (com.ksad.download.d.b.a(o())) {
            textView = this.f35335b;
            i2 = 8;
        } else {
            textView = this.f35335b;
            i2 = 0;
        }
        textView.setVisibility(i2);
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35276e.a(this.f35336c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35276e.b(this.f35336c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35335b = (TextView) b(R.id.ksad_video_fail_tip);
    }
}
