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
/* loaded from: classes3.dex */
public class a extends b {
    private LottieAnimationView b;
    private ViewGroup c;
    private TextView d;
    private Handler e;
    private boolean f = false;
    private com.kwad.sdk.contentalliance.a.a g = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (com.ksad.download.d.b.a(a.this.o()) || a.this.f5594a.m.a()) {
                a.this.c.setVisibility(8);
            } else {
                a.this.g();
            }
            if (a.this.f5594a.m.b() && !a.this.f) {
                a.this.h();
            }
            a.this.f = true;
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f();
            a.this.f = false;
        }
    };
    private Runnable h = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    };
    private Runnable i = new aq(this.h);
    private e j = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.4
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
            a.this.e.removeCallbacks(a.this.i);
            a.this.c.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            a.this.e.removeCallbacks(a.this.i);
            com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlaying");
            a.this.f();
            a.this.c.setVisibility(8);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!com.ksad.download.d.b.a(o())) {
            f();
            this.c.setVisibility(0);
        } else if (this.b.getVisibility() == 0 && this.b.c()) {
        } else {
            this.b.setVisibility(0);
            if (!this.b.c()) {
                this.b.b();
            }
            this.c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.b == null) {
            return;
        }
        if (this.b.c()) {
            this.b.d();
        }
        this.b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.b.d();
        this.b.setVisibility(8);
        p.a(o(), "网络错误");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (com.ksad.download.d.b.a(o())) {
            e();
        } else {
            f();
        }
        this.e.removeCallbacks(this.i);
        this.e.postDelayed(this.i, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onBind");
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.ksad.download.d.b.a(a.this.o())) {
                    p.a(a.this.o(), "网络错误");
                } else if (a.this.f5594a.m.a()) {
                } else {
                    a.this.f5594a.m.f();
                }
            }
        });
        this.f5594a.b.add(this.g);
        this.f5594a.m.a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.e != null) {
            this.e.removeCallbacksAndMessages(null);
        }
        this.f5594a.b.remove(this.g);
        if (this.f5594a.m != null) {
            this.f5594a.m.b(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.e = new Handler();
        this.c = (ViewGroup) b(R.id.ksad_error_container);
        this.d = (TextView) b(R.id.ksad_retry_btn);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_bottom_loading_animation_view);
        int i = R.raw.ksad_detail_loading_amin_bottom;
        ((LottieAnimationView) b(R.id.ksad_center_loading_animation_view)).setVisibility(8);
        lottieAnimationView.setVisibility(0);
        this.b = lottieAnimationView;
        this.b.setRepeatMode(1);
        this.b.setRepeatCount(-1);
        this.b.setAnimation(i);
        this.b.setRepeatMode(1);
        this.b.setRepeatCount(-1);
    }
}
