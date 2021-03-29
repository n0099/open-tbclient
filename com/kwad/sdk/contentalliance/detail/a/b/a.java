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
    public LottieAnimationView f31971b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f31972c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31973d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f31974e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31975f = false;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f31976g = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (com.ksad.download.d.b.a(a.this.o()) || ((b) a.this).f32133a.m.a()) {
                a.this.f31972c.setVisibility(8);
            } else {
                a.this.g();
            }
            if (((b) a.this).f32133a.m.b() && !a.this.f31975f) {
                a.this.h();
            }
            a.this.f31975f = true;
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f();
            a.this.f31975f = false;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public Runnable f31977h;
    public Runnable i;
    public e j;

    public a() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.f();
            }
        };
        this.f31977h = runnable;
        this.i = new aq(runnable);
        this.j = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.4
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                super.a();
                a.this.f();
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayCompleted");
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i, int i2) {
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayError");
                a.this.f();
                p.a(a.this.o(), "网络错误");
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                super.b();
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayStart");
                a.this.f31974e.removeCallbacks(a.this.i);
                a.this.f31972c.setVisibility(8);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                super.d();
                a.this.f31974e.removeCallbacks(a.this.i);
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlaying");
                a.this.f();
                a.this.f31972c.setVisibility(8);
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
        int i = 0;
        if (!com.ksad.download.d.b.a(o())) {
            f();
            viewGroup = this.f31972c;
        } else if (this.f31971b.getVisibility() == 0 && this.f31971b.c()) {
            return;
        } else {
            this.f31971b.setVisibility(0);
            if (!this.f31971b.c()) {
                this.f31971b.b();
            }
            viewGroup = this.f31972c;
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        LottieAnimationView lottieAnimationView = this.f31971b;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView.c()) {
            this.f31971b.d();
        }
        this.f31971b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f31971b.d();
        this.f31971b.setVisibility(8);
        p.a(o(), "网络错误");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (com.ksad.download.d.b.a(o())) {
            e();
        } else {
            f();
        }
        this.f31974e.removeCallbacks(this.i);
        this.f31974e.postDelayed(this.i, 10000L);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onBind");
        this.f31973d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.ksad.download.d.b.a(a.this.o())) {
                    p.a(a.this.o(), "网络错误");
                } else if (((b) a.this).f32133a.m.a()) {
                } else {
                    ((b) a.this).f32133a.m.f();
                }
            }
        });
        ((b) this).f32133a.f32153b.add(this.f31976g);
        ((b) this).f32133a.m.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Handler handler = this.f31974e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ((b) this).f32133a.f32153b.remove(this.f31976g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((b) this).f32133a.m;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31974e = new Handler();
        this.f31972c = (ViewGroup) b(R.id.ksad_error_container);
        this.f31973d = (TextView) b(R.id.ksad_retry_btn);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_bottom_loading_animation_view);
        int i = R.raw.ksad_detail_loading_amin_bottom;
        ((LottieAnimationView) b(R.id.ksad_center_loading_animation_view)).setVisibility(8);
        lottieAnimationView.setVisibility(0);
        this.f31971b = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.f31971b.setRepeatCount(-1);
        this.f31971b.setAnimation(i);
        this.f31971b.setRepeatMode(1);
        this.f31971b.setRepeatCount(-1);
    }
}
