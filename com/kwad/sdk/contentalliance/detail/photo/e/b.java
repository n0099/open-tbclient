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
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b implements com.kwad.sdk.contentalliance.a.e {

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f32975d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdFrameLayout f32976e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.c f32977f;

    /* renamed from: g  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f32978g;

    /* renamed from: h  reason: collision with root package name */
    public long f32979h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32980i;
    public int j;
    public h l;

    /* renamed from: b  reason: collision with root package name */
    public final Random f32973b = new Random();

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f32974c = new ArrayList();
    public LinkedList<LottieAnimationView> k = new LinkedList<>();
    public final Runnable m = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.f32977f.a(com.kwad.sdk.contentalliance.widget.c.f34107b);
        }
    };
    public com.kwad.sdk.contentalliance.a.e n = new com.kwad.sdk.contentalliance.a.e() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.2
    };
    public com.kwad.sdk.contentalliance.a.a o = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.3
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            ((com.kwad.sdk.contentalliance.detail.b) b.this).f32790a.f32814d.add(b.this.n);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            b.this.f32975d.removeCallbacks(b.this.m);
            b.this.f32977f.a(com.kwad.sdk.contentalliance.widget.c.f34107b);
            ((com.kwad.sdk.contentalliance.detail.b) b.this).f32790a.f32814d.remove(b.this.n);
            if (b.this.f32975d != null) {
                for (int i2 = 0; i2 < b.this.f32975d.getChildCount(); i2++) {
                    if ((b.this.f32975d.getChildAt(i2) instanceof LottieAnimationView) && ((LottieAnimationView) b.this.f32975d.getChildAt(i2)).c()) {
                        ((LottieAnimationView) b.this.f32975d.getChildAt(i2)).d();
                    }
                }
            }
            b.this.k.clear();
            if (b.this.f32975d != null) {
                b.this.f32975d.removeAllViews();
            }
        }
    };

    public b() {
        h hVar = new h();
        this.l = hVar;
        a((Presenter) hVar);
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
                if (b.this.f32975d.indexOfChild(lottieAnimationView) > -1) {
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

    private void c(float f2, float f3) {
        if (o() == null) {
            return;
        }
        boolean z = f2 > -1.0f && f3 > -1.0f;
        int i2 = this.j;
        if (!z) {
            i2 = (int) (i2 * 1.2f);
        }
        LottieAnimationView pollFirst = this.k.pollFirst();
        if (pollFirst == null) {
            pollFirst = new LottieAnimationView(o());
            pollFirst.a(true);
            RelativeLayout relativeLayout = this.f32975d;
            int i3 = this.j;
            relativeLayout.addView(pollFirst, new RelativeLayout.LayoutParams(i3, i3));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pollFirst.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        if (z) {
            float f4 = i2 / 2.0f;
            pollFirst.setTranslationX(f2 - f4);
            pollFirst.setTranslationY((f3 - f4) - (this.j / 3.0f));
            List<Integer> list = this.f32974c;
            pollFirst.setRotation(list.get(this.f32973b.nextInt(list.size())).intValue());
            layoutParams.addRule(13, 0);
        } else {
            pollFirst.setTranslationX(0.0f);
            pollFirst.setTranslationY(0.0f);
            pollFirst.setRotation(0.0f);
            layoutParams.addRule(13, -1);
        }
        pollFirst.setLayoutParams(layoutParams);
        a(pollFirst, z);
    }

    private void e() {
        if (this.f32978g == null) {
            this.f32978g = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.4
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
        if (this.f32977f == null) {
            if (this.f32978g == null) {
                e();
            }
            this.f32977f = new com.kwad.sdk.contentalliance.widget.c(o(), this.f32978g) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.5
                @Override // com.kwad.sdk.contentalliance.widget.c, android.view.GestureDetector
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return motionEvent.getActionMasked() == 6 ? b.this.d(motionEvent) : super.onTouchEvent(motionEvent);
                }
            };
        }
    }

    private boolean g() {
        return SystemClock.elapsedRealtime() - this.f32979h < ((long) ViewConfiguration.getJumpTapTimeout());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.add(this.o);
        this.f32976e.a(this.f32977f);
        this.f32975d.setVisibility(0);
    }

    public boolean a(float f2, float f3) {
        this.f32977f.a(500L);
        this.f32975d.removeCallbacks(this.m);
        this.f32975d.postDelayed(this.m, 500L);
        this.l.h();
        c(f2, f3);
        return true;
    }

    public boolean a(MotionEvent motionEvent) {
        this.f32979h = SystemClock.elapsedRealtime();
        return this.f32980i || a(motionEvent.getX(), motionEvent.getY());
    }

    public boolean b(float f2, float f3) {
        this.f32979h = SystemClock.elapsedRealtime();
        this.f32980i = true;
        return a(f2, f3);
    }

    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    @SuppressLint({"ClickableViewAccessibility"})
    public void b_() {
        super.b_();
        l().setOnTouchListener(null);
        this.f32975d.setOnTouchListener(null);
        this.f32976e.b(this.f32977f);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32814d.remove(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (o() != null) {
            this.j = o().getResources().getDimensionPixelSize(R.dimen.ksad_slide_play_center_like_view_size);
        }
        this.f32975d = (RelativeLayout) b(R.id.ksad_slide_play_like_image);
        this.f32976e = (KsAdFrameLayout) b(R.id.ksad_video_container);
        e();
        for (int i2 = -15; i2 < 15; i2++) {
            this.f32974c.add(Integer.valueOf(i2));
        }
        this.f32976e.setClickable(true);
        f();
    }

    public boolean c(MotionEvent motionEvent) {
        if (g()) {
            return b(motionEvent.getX(), motionEvent.getY());
        }
        this.f32980i = false;
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        RelativeLayout relativeLayout = this.f32975d;
        if (relativeLayout != null) {
            relativeLayout.removeCallbacks(this.m);
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
