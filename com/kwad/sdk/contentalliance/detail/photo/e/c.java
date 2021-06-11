package com.kwad.sdk.contentalliance.detail.photo.e;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.plugin.PluginCenter;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32890b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32891c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f32892d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32893e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32894f;

    /* renamed from: g  reason: collision with root package name */
    public ScaleAnimSeekBar f32895g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32896h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32897i;
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
                    int i2 = (int) (((((float) j2) * 1.0f) * 10000.0f) / ((float) j));
                    if (c.this.k || !c.this.f32895g.a()) {
                        return;
                    }
                    c.this.f32895g.setProgress(i2);
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
                if (c.this.f32890b.getVisibility() == 0) {
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
                c.this.f32891c.setVisibility(8);
                c.this.e();
                c.this.r();
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z) {
                if (z) {
                    c.this.e();
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                c.this.f32891c.setVisibility(0);
                c.this.f();
                c.this.p();
                c.this.s();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        this.f32895g.setAlpha(f2);
        this.f32895g.setThumbEnable(f2 == 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f32893e.setText(ai.a((this.j * this.f32895g.getProgress()) / 10000));
        if (this.f32892d.getVisibility() == 0) {
            return;
        }
        this.f32894f.setText(ai.a(this.j));
        this.f32892d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32892d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f32895g.setProgress(0);
        this.f32895g.setVisibility(8);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f32895g.getVisibility() == 0) {
            return;
        }
        this.f32895g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f32896h.a((this.j * this.f32895g.getProgress()) / 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        t();
        this.f32895g.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        t();
        this.f32895g.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        t();
        this.f32895g.postDelayed(this.m, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    private void t() {
        this.f32895g.removeCallbacks(this.m);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j;
        long longValue = com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(adTemplate)).longValue();
        this.j = longValue;
        if (longValue < 30000 || com.kwad.sdk.core.response.b.d.F(adTemplate.photoInfo)) {
            return;
        }
        this.f32897i = true;
        this.f32896h = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
        f();
        g();
        a(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.l.getSourceType() == 0 ? 1.0f : 0.0f);
        this.f32895g.setOnSeekBarChangeListener(this.q);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(this.n);
        this.f32896h.a(this.p);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32717e.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32895g.removeCallbacks(this.m);
        if (this.f32897i) {
            this.f32895g.setOnSeekBarChangeListener(null);
            this.f32895g.setVisibility(8);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.n);
            this.f32896h.b(this.p);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32717e.remove(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32890b = (ImageView) b(R.id.ksad_video_control_button);
        this.f32891c = (ViewGroup) b(R.id.ksad_video_bottom_container);
        this.f32892d = (ViewGroup) b(R.id.ksad_video_seek_tip_layout);
        this.f32893e = (TextView) b(R.id.ksad_video_seek_progress);
        this.f32894f = (TextView) b(R.id.ksad_video_seek_duration);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) b(R.id.ksad_video_seek_bar);
        this.f32895g = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(10000);
    }
}
