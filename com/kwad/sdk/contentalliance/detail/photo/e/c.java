package com.kwad.sdk.contentalliance.detail.photo.e;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8492b;
    private ViewGroup c;
    private ViewGroup d;
    private TextView e;
    private TextView f;
    private ScaleAnimSeekBar g;
    private com.kwad.sdk.contentalliance.detail.video.b h;
    private boolean i;
    private long j;
    private boolean k = false;
    private Runnable l = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.k) {
                return;
            }
            c.this.q();
        }
    };
    private Runnable m = new aq(this.l);
    private com.kwad.sdk.contentalliance.a.a n = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.k();
            c.this.f();
            c.this.g();
        }
    };
    private com.kwad.sdk.contentalliance.home.swipe.a o = new com.kwad.sdk.contentalliance.home.swipe.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.3
        @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
        public void a(float f) {
            c.this.a(f);
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e p = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.4
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j != 0) {
                c.this.j = j;
                int i = (int) (((((float) j2) * 1.0f) * 10000.0f) / ((float) j));
                if (c.this.k || !c.this.g.a()) {
                    return;
                }
                c.this.g.setProgress(i);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            c.this.k = false;
            c.this.h();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            c.this.k = true;
            if (c.this.f8492b.getVisibility() == 0) {
                c.this.r();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            c.this.k = false;
            c.this.h();
            c.this.s();
        }
    };
    private ScaleAnimSeekBar.a q = new ScaleAnimSeekBar.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.5
        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
            c.this.c.setVisibility(8);
            c.this.e();
            c.this.r();
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i, boolean z) {
            if (z) {
                c.this.e();
            }
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
            c.this.c.setVisibility(0);
            c.this.f();
            c.this.p();
            c.this.s();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        this.g.setAlpha(f);
        this.g.setThumbEnable(f == 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.e.setText(ai.a((this.j * this.g.getProgress()) / 10000));
        if (this.d.getVisibility() == 0) {
            return;
        }
        this.f.setText(ai.a(this.j));
        this.d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.g.setProgress(0);
        this.g.setVisibility(8);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.g.getVisibility() == 0) {
            return;
        }
        this.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.h.a((this.j * this.g.getProgress()) / 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        t();
        this.g.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        t();
        this.g.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        t();
        this.g.postDelayed(this.m, 4000L);
    }

    private void t() {
        this.g.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = this.f8393a.j;
        this.j = com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(adTemplate)).longValue();
        if (this.j < 30000 || com.kwad.sdk.core.response.b.d.F(adTemplate.photoInfo)) {
            return;
        }
        this.i = true;
        this.h = this.f8393a.m;
        f();
        g();
        a(this.f8393a.l.getSourceType() == 0 ? 1.0f : 0.0f);
        this.g.setOnSeekBarChangeListener(this.q);
        this.f8393a.f8403b.add(this.n);
        this.h.a(this.p);
        this.f8393a.e.add(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.g.removeCallbacks(this.m);
        if (this.i) {
            this.g.setOnSeekBarChangeListener(null);
            this.g.setVisibility(8);
            this.f8393a.f8403b.remove(this.n);
            this.h.b(this.p);
            this.f8393a.e.remove(this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8492b = (ImageView) b(R.id.ksad_video_control_button);
        this.c = (ViewGroup) b(R.id.ksad_video_bottom_container);
        this.d = (ViewGroup) b(R.id.ksad_video_seek_tip_layout);
        this.e = (TextView) b(R.id.ksad_video_seek_progress);
        this.f = (TextView) b(R.id.ksad_video_seek_duration);
        this.g = (ScaleAnimSeekBar) b(R.id.ksad_video_seek_bar);
        this.g.setMaxProgress(10000);
    }
}
