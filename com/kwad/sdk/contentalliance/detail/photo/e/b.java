package com.kwad.sdk.contentalliance.detail.photo.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.f.h;
import com.kwad.sdk.contentalliance.widget.KsAdFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b implements com.kwad.sdk.contentalliance.a.e {
    private RelativeLayout d;
    private KsAdFrameLayout e;
    private com.kwad.sdk.contentalliance.widget.c f;
    private GestureDetector.SimpleOnGestureListener g;
    private long h;
    private boolean i;
    private int j;

    /* renamed from: b  reason: collision with root package name */
    private final Random f8484b = new Random();
    private List<Integer> c = new ArrayList();
    private LinkedList<LottieAnimationView> k = new LinkedList<>();
    private final Runnable m = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.f.a(com.kwad.sdk.contentalliance.widget.c.f9021b);
        }
    };
    private com.kwad.sdk.contentalliance.a.e n = new com.kwad.sdk.contentalliance.a.e() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.2
    };
    private com.kwad.sdk.contentalliance.a.a o = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.3
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            b.this.f8393a.d.add(b.this.n);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            b.this.d.removeCallbacks(b.this.m);
            b.this.f.a(com.kwad.sdk.contentalliance.widget.c.f9021b);
            b.this.f8393a.d.remove(b.this.n);
            if (b.this.d != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= b.this.d.getChildCount()) {
                        break;
                    }
                    if ((b.this.d.getChildAt(i2) instanceof LottieAnimationView) && ((LottieAnimationView) b.this.d.getChildAt(i2)).c()) {
                        ((LottieAnimationView) b.this.d.getChildAt(i2)).d();
                    }
                    i = i2 + 1;
                }
            }
            b.this.k.clear();
            if (b.this.d != null) {
                b.this.d.removeAllViews();
            }
        }
    };
    private h l = new h();

    public b() {
        a((Presenter) this.l);
    }

    private void a(final LottieAnimationView lottieAnimationView, boolean z) {
        lottieAnimationView.d();
        lottieAnimationView.setVisibility(4);
        lottieAnimationView.setAnimation(R.raw.ksad_detail_center_like_anim_new_ui);
        lottieAnimationView.setSpeed(z ? 2.0f : 1.5f);
        lottieAnimationView.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                lottieAnimationView.b(this);
                if (b.this.d.indexOfChild(lottieAnimationView) > -1) {
                    lottieAnimationView.setVisibility(4);
                    if (b.this.k.contains(lottieAnimationView)) {
                        b.this.k.offer(lottieAnimationView);
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                lottieAnimationView.setVisibility(0);
            }
        });
        lottieAnimationView.b();
    }

    private void c(float f, float f2) {
        LottieAnimationView lottieAnimationView;
        if (o() == null) {
            return;
        }
        boolean z = f > -1.0f && f2 > -1.0f;
        int i = z ? this.j : (int) (this.j * 1.2f);
        LottieAnimationView pollFirst = this.k.pollFirst();
        if (pollFirst == null) {
            LottieAnimationView lottieAnimationView2 = new LottieAnimationView(o());
            lottieAnimationView2.a(true);
            this.d.addView(lottieAnimationView2, new RelativeLayout.LayoutParams(this.j, this.j));
            lottieAnimationView = lottieAnimationView2;
        } else {
            lottieAnimationView = pollFirst;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lottieAnimationView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        if (z) {
            lottieAnimationView.setTranslationX(f - (i / 2.0f));
            lottieAnimationView.setTranslationY((f2 - (i / 2.0f)) - (this.j / 3.0f));
            lottieAnimationView.setRotation(this.c.get(this.f8484b.nextInt(this.c.size())).intValue());
            layoutParams.addRule(13, 0);
        } else {
            lottieAnimationView.setTranslationX(0.0f);
            lottieAnimationView.setTranslationY(0.0f);
            lottieAnimationView.setRotation(0.0f);
            layoutParams.addRule(13, -1);
        }
        lottieAnimationView.setLayoutParams(layoutParams);
        a(lottieAnimationView, z);
    }

    private void e() {
        if (this.g == null) {
            this.g = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.4
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return b.this.a(motionEvent);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    b.this.b(motionEvent);
                    return super.onSingleTapConfirmed(motionEvent);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    b.this.c(motionEvent);
                    return super.onSingleTapUp(motionEvent);
                }
            };
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        if (this.f == null) {
            if (this.g == null) {
                e();
            }
            this.f = new com.kwad.sdk.contentalliance.widget.c(o(), this.g) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.5
                @Override // com.kwad.sdk.contentalliance.widget.c, android.view.GestureDetector
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return motionEvent.getActionMasked() == 6 ? b.this.d(motionEvent) : super.onTouchEvent(motionEvent);
                }
            };
        }
    }

    private boolean g() {
        return SystemClock.elapsedRealtime() - this.h < ((long) ViewConfiguration.getJumpTapTimeout());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8393a.f8403b.add(this.o);
        this.e.a(this.f);
        this.d.setVisibility(0);
    }

    public boolean a(float f, float f2) {
        this.f.a(500L);
        this.d.removeCallbacks(this.m);
        this.d.postDelayed(this.m, 500L);
        this.l.h();
        c(f, f2);
        return true;
    }

    public boolean a(MotionEvent motionEvent) {
        this.h = SystemClock.elapsedRealtime();
        return this.i || a(motionEvent.getX(), motionEvent.getY());
    }

    public boolean b(float f, float f2) {
        this.h = SystemClock.elapsedRealtime();
        this.i = true;
        return a(f, f2);
    }

    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    @SuppressLint({"ClickableViewAccessibility"})
    public void b_() {
        super.b_();
        l().setOnTouchListener(null);
        this.d.setOnTouchListener(null);
        this.e.b(this.f);
        this.f8393a.d.remove(this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (o() != null) {
            this.j = o().getResources().getDimensionPixelSize(R.dimen.ksad_slide_play_center_like_view_size);
        }
        this.d = (RelativeLayout) b(R.id.ksad_slide_play_like_image);
        this.e = (KsAdFrameLayout) b(R.id.ksad_video_container);
        e();
        for (int i = -15; i < 15; i++) {
            this.c.add(Integer.valueOf(i));
        }
        this.e.setClickable(true);
        f();
    }

    public boolean c(MotionEvent motionEvent) {
        if (g()) {
            return b(motionEvent.getX(), motionEvent.getY());
        }
        this.i = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        if (this.d != null) {
            this.d.removeCallbacks(this.m);
        }
        super.d();
    }

    public boolean d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (g()) {
            return b(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
        }
        return false;
    }
}
