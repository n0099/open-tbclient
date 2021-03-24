package com.kwad.sdk.draw.b;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f34583b;

    /* renamed from: c  reason: collision with root package name */
    public e f34584c = new f() { // from class: com.kwad.sdk.draw.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            c.this.f34583b.setVisibility(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            c.this.f34583b.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            c.this.f34583b.setVisibility(8);
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        super.a();
        if (com.ksad.download.d.b.a(o())) {
            textView = this.f34583b;
            i = 8;
        } else {
            textView = this.f34583b;
            i = 0;
        }
        textView.setVisibility(i);
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34526e.a(this.f34584c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34526e.b(this.f34584c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34583b = (TextView) b(R.id.ksad_video_fail_tip);
    }
}
