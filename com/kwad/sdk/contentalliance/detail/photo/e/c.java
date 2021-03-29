package com.kwad.sdk.contentalliance.detail.photo.e;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32320b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32321c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f32322d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32323e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32324f;

    /* renamed from: g  reason: collision with root package name */
    public ScaleAnimSeekBar f32325g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32326h;
    public boolean i;
    public long j;
    public boolean k = false;
    public Runnable l;
    public Runnable m;
    public com.kwad.sdk.contentalliance.a.a n;
    public com.kwad.sdk.contentalliance.home.swipe.a o;
    public com.kwad.sdk.contentalliance.detail.video.e p;
    public ScaleAnimSeekBar.a q;

    public c() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.k) {
                    return;
                }
                c.this.q();
            }
        };
        this.l = runnable;
        this.m = new aq(runnable);
        this.n = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.2
            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                super.k();
                c.this.f();
                c.this.g();
            }
        };
        this.o = new com.kwad.sdk.contentalliance.home.swipe.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.3
            @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
            public void a(float f2) {
                c.this.a(f2);
            }
        };
        this.p = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.4
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                if (j != 0) {
                    c.this.j = j;
                    int i = (int) (((((float) j2) * 1.0f) * 10000.0f) / ((float) j));
                    if (c.this.k || !c.this.f32325g.a()) {
                        return;
                    }
                    c.this.f32325g.setProgress(i);
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
                if (c.this.f32320b.getVisibility() == 0) {
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
        this.q = new ScaleAnimSeekBar.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.5
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                c.this.f32321c.setVisibility(8);
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
                c.this.f32321c.setVisibility(0);
                c.this.f();
                c.this.p();
                c.this.s();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        this.f32325g.setAlpha(f2);
        this.f32325g.setThumbEnable(f2 == 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f32323e.setText(ai.a((this.j * this.f32325g.getProgress()) / 10000));
        if (this.f32322d.getVisibility() == 0) {
            return;
        }
        this.f32324f.setText(ai.a(this.j));
        this.f32322d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32322d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f32325g.setProgress(0);
        this.f32325g.setVisibility(8);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f32325g.getVisibility() == 0) {
            return;
        }
        this.f32325g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f32326h.a((this.j * this.f32325g.getProgress()) / 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        t();
        this.f32325g.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        t();
        this.f32325g.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        t();
        this.f32325g.postDelayed(this.m, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    private void t() {
        this.f32325g.removeCallbacks(this.m);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j;
        long longValue = com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(adTemplate)).longValue();
        this.j = longValue;
        if (longValue < StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD || com.kwad.sdk.core.response.b.d.F(adTemplate.photoInfo)) {
            return;
        }
        this.i = true;
        this.f32326h = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        f();
        g();
        a(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.l.getSourceType() == 0 ? 1.0f : 0.0f);
        this.f32325g.setOnSeekBarChangeListener(this.q);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.add(this.n);
        this.f32326h.a(this.p);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32156e.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32325g.removeCallbacks(this.m);
        if (this.i) {
            this.f32325g.setOnSeekBarChangeListener(null);
            this.f32325g.setVisibility(8);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.remove(this.n);
            this.f32326h.b(this.p);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32156e.remove(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32320b = (ImageView) b(R.id.ksad_video_control_button);
        this.f32321c = (ViewGroup) b(R.id.ksad_video_bottom_container);
        this.f32322d = (ViewGroup) b(R.id.ksad_video_seek_tip_layout);
        this.f32323e = (TextView) b(R.id.ksad_video_seek_progress);
        this.f32324f = (TextView) b(R.id.ksad_video_seek_duration);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) b(R.id.ksad_video_seek_bar);
        this.f32325g = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(10000);
    }
}
