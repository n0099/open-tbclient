package com.kwad.sdk.contentalliance.detail.a.b;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.b;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f32520b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32521c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32522d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f32523e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32524f = false;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32525g = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (com.ksad.download.d.b.a(a.this.o()) || ((b) a.this).f32692a.m.a()) {
                a.this.f32521c.setVisibility(8);
            } else {
                a.this.g();
            }
            if (((b) a.this).f32692a.m.b() && !a.this.f32524f) {
                a.this.h();
            }
            a.this.f32524f = true;
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f();
            a.this.f32524f = false;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public Runnable f32526h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f32527i;
    public e j;

    public a() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.f();
            }
        };
        this.f32526h = runnable;
        this.f32527i = new aq(runnable);
        this.j = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.4
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                super.a();
                a.this.f();
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayCompleted");
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i2, int i3) {
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayError");
                a.this.f();
                p.a(a.this.o(), "网络错误");
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                super.b();
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayStart");
                a.this.f32523e.removeCallbacks(a.this.f32527i);
                a.this.f32521c.setVisibility(8);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                super.d();
                a.this.f32523e.removeCallbacks(a.this.f32527i);
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlaying");
                a.this.f();
                a.this.f32521c.setVisibility(8);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void e() {
                super.e();
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPreparing");
                a.this.h();
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void f() {
                super.f();
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayBufferingPaused");
                a.this.e();
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void g() {
                super.g();
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayBufferingPlaying");
                a.this.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewGroup viewGroup;
        int i2 = 0;
        if (!com.ksad.download.d.b.a(o())) {
            f();
            viewGroup = this.f32521c;
        } else if (this.f32520b.getVisibility() == 0 && this.f32520b.c()) {
            return;
        } else {
            this.f32520b.setVisibility(0);
            if (!this.f32520b.c()) {
                this.f32520b.b();
            }
            viewGroup = this.f32521c;
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        LottieAnimationView lottieAnimationView = this.f32520b;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView.c()) {
            this.f32520b.d();
        }
        this.f32520b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f32520b.d();
        this.f32520b.setVisibility(8);
        p.a(o(), "网络错误");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (com.ksad.download.d.b.a(o())) {
            e();
        } else {
            f();
        }
        this.f32523e.removeCallbacks(this.f32527i);
        this.f32523e.postDelayed(this.f32527i, 10000L);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onBind");
        this.f32522d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.ksad.download.d.b.a(a.this.o())) {
                    p.a(a.this.o(), "网络错误");
                } else if (((b) a.this).f32692a.m.a()) {
                } else {
                    ((b) a.this).f32692a.m.f();
                }
            }
        });
        ((b) this).f32692a.f32714b.add(this.f32525g);
        ((b) this).f32692a.m.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Handler handler = this.f32523e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ((b) this).f32692a.f32714b.remove(this.f32525g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((b) this).f32692a.m;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32523e = new Handler();
        this.f32521c = (ViewGroup) b(R.id.ksad_error_container);
        this.f32522d = (TextView) b(R.id.ksad_retry_btn);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_bottom_loading_animation_view);
        int i2 = R.raw.ksad_detail_loading_amin_bottom;
        ((LottieAnimationView) b(R.id.ksad_center_loading_animation_view)).setVisibility(8);
        lottieAnimationView.setVisibility(0);
        this.f32520b = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.f32520b.setRepeatCount(-1);
        this.f32520b.setAnimation(i2);
        this.f32520b.setRepeatMode(1);
        this.f32520b.setRepeatCount(-1);
    }
}
