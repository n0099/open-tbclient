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
    public LottieAnimationView f32618b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32619c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32620d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f32621e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32622f = false;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32623g = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (com.ksad.download.d.b.a(a.this.o()) || ((b) a.this).f32790a.m.a()) {
                a.this.f32619c.setVisibility(8);
            } else {
                a.this.g();
            }
            if (((b) a.this).f32790a.m.b() && !a.this.f32622f) {
                a.this.h();
            }
            a.this.f32622f = true;
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f();
            a.this.f32622f = false;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public Runnable f32624h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f32625i;
    public e j;

    public a() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.f();
            }
        };
        this.f32624h = runnable;
        this.f32625i = new aq(runnable);
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
                a.this.f32621e.removeCallbacks(a.this.f32625i);
                a.this.f32619c.setVisibility(8);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                super.d();
                a.this.f32621e.removeCallbacks(a.this.f32625i);
                com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlaying");
                a.this.f();
                a.this.f32619c.setVisibility(8);
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
            viewGroup = this.f32619c;
        } else if (this.f32618b.getVisibility() == 0 && this.f32618b.c()) {
            return;
        } else {
            this.f32618b.setVisibility(0);
            if (!this.f32618b.c()) {
                this.f32618b.b();
            }
            viewGroup = this.f32619c;
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        LottieAnimationView lottieAnimationView = this.f32618b;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView.c()) {
            this.f32618b.d();
        }
        this.f32618b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f32618b.d();
        this.f32618b.setVisibility(8);
        p.a(o(), "网络错误");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (com.ksad.download.d.b.a(o())) {
            e();
        } else {
            f();
        }
        this.f32621e.removeCallbacks(this.f32625i);
        this.f32621e.postDelayed(this.f32625i, 10000L);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onBind");
        this.f32620d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.ksad.download.d.b.a(a.this.o())) {
                    p.a(a.this.o(), "网络错误");
                } else if (((b) a.this).f32790a.m.a()) {
                } else {
                    ((b) a.this).f32790a.m.f();
                }
            }
        });
        ((b) this).f32790a.f32812b.add(this.f32623g);
        ((b) this).f32790a.m.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Handler handler = this.f32621e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ((b) this).f32790a.f32812b.remove(this.f32623g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((b) this).f32790a.m;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32621e = new Handler();
        this.f32619c = (ViewGroup) b(R.id.ksad_error_container);
        this.f32620d = (TextView) b(R.id.ksad_retry_btn);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_bottom_loading_animation_view);
        int i2 = R.raw.ksad_detail_loading_amin_bottom;
        ((LottieAnimationView) b(R.id.ksad_center_loading_animation_view)).setVisibility(8);
        lottieAnimationView.setVisibility(0);
        this.f32618b = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.f32618b.setRepeatCount(-1);
        this.f32618b.setAnimation(i2);
        this.f32618b.setRepeatMode(1);
        this.f32618b.setRepeatCount(-1);
    }
}
