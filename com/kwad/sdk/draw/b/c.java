package com.kwad.sdk.draw.b;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f33184b;

    /* renamed from: c  reason: collision with root package name */
    public d f33185c = new e() { // from class: com.kwad.sdk.draw.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            c.this.f33184b.setVisibility(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            c.this.f33184b.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            c.this.f33184b.setVisibility(8);
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i2;
        super.a();
        if (com.ksad.download.d.b.a(l())) {
            textView = this.f33184b;
            i2 = 8;
        } else {
            textView = this.f33184b;
            i2 = 0;
        }
        textView.setVisibility(i2);
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.a(this.f33185c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33184b = (TextView) a(R.id.ksad_video_fail_tip);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.b(this.f33185c);
    }
}
