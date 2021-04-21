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
    public RelativeLayout f32692d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdFrameLayout f32693e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.c f32694f;

    /* renamed from: g  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f32695g;

    /* renamed from: h  reason: collision with root package name */
    public long f32696h;
    public boolean i;
    public int j;
    public h l;

    /* renamed from: b  reason: collision with root package name */
    public final Random f32690b = new Random();

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f32691c = new ArrayList();
    public LinkedList<LottieAnimationView> k = new LinkedList<>();
    public final Runnable m = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.f32694f.a(com.kwad.sdk.contentalliance.widget.c.f33775b);
        }
    };
    public com.kwad.sdk.contentalliance.a.e n = new com.kwad.sdk.contentalliance.a.e() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.2
    };
    public com.kwad.sdk.contentalliance.a.a o = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.3
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            ((com.kwad.sdk.contentalliance.detail.b) b.this).f32517a.f32539d.add(b.this.n);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            b.this.f32692d.removeCallbacks(b.this.m);
            b.this.f32694f.a(com.kwad.sdk.contentalliance.widget.c.f33775b);
            ((com.kwad.sdk.contentalliance.detail.b) b.this).f32517a.f32539d.remove(b.this.n);
            if (b.this.f32692d != null) {
                for (int i = 0; i < b.this.f32692d.getChildCount(); i++) {
                    if ((b.this.f32692d.getChildAt(i) instanceof LottieAnimationView) && ((LottieAnimationView) b.this.f32692d.getChildAt(i)).c()) {
                        ((LottieAnimationView) b.this.f32692d.getChildAt(i)).d();
                    }
                }
            }
            b.this.k.clear();
            if (b.this.f32692d != null) {
                b.this.f32692d.removeAllViews();
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
                if (b.this.f32692d.indexOfChild(lottieAnimationView) > -1) {
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
        int i = this.j;
        if (!z) {
            i = (int) (i * 1.2f);
        }
        LottieAnimationView pollFirst = this.k.pollFirst();
        if (pollFirst == null) {
            pollFirst = new LottieAnimationView(o());
            pollFirst.a(true);
            RelativeLayout relativeLayout = this.f32692d;
            int i2 = this.j;
            relativeLayout.addView(pollFirst, new RelativeLayout.LayoutParams(i2, i2));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pollFirst.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        if (z) {
            float f4 = i / 2.0f;
            pollFirst.setTranslationX(f2 - f4);
            pollFirst.setTranslationY((f3 - f4) - (this.j / 3.0f));
            List<Integer> list = this.f32691c;
            pollFirst.setRotation(list.get(this.f32690b.nextInt(list.size())).intValue());
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
        if (this.f32695g == null) {
            this.f32695g = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.4
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
        if (this.f32694f == null) {
            if (this.f32695g == null) {
                e();
            }
            this.f32694f = new com.kwad.sdk.contentalliance.widget.c(o(), this.f32695g) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.b.5
                @Override // com.kwad.sdk.contentalliance.widget.c, android.view.GestureDetector
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return motionEvent.getActionMasked() == 6 ? b.this.d(motionEvent) : super.onTouchEvent(motionEvent);
                }
            };
        }
    }

    private boolean g() {
        return SystemClock.elapsedRealtime() - this.f32696h < ((long) ViewConfiguration.getJumpTapTimeout());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(this.o);
        this.f32693e.a(this.f32694f);
        this.f32692d.setVisibility(0);
    }

    public boolean a(float f2, float f3) {
        this.f32694f.a(500L);
        this.f32692d.removeCallbacks(this.m);
        this.f32692d.postDelayed(this.m, 500L);
        this.l.h();
        c(f2, f3);
        return true;
    }

    public boolean a(MotionEvent motionEvent) {
        this.f32696h = SystemClock.elapsedRealtime();
        return this.i || a(motionEvent.getX(), motionEvent.getY());
    }

    public boolean b(float f2, float f3) {
        this.f32696h = SystemClock.elapsedRealtime();
        this.i = true;
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
        this.f32692d.setOnTouchListener(null);
        this.f32693e.b(this.f32694f);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32539d.remove(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (o() != null) {
            this.j = o().getResources().getDimensionPixelSize(R.dimen.ksad_slide_play_center_like_view_size);
        }
        this.f32692d = (RelativeLayout) b(R.id.ksad_slide_play_like_image);
        this.f32693e = (KsAdFrameLayout) b(R.id.ksad_video_container);
        e();
        for (int i = -15; i < 15; i++) {
            this.f32691c.add(Integer.valueOf(i));
        }
        this.f32693e.setClickable(true);
        f();
    }

    public boolean c(MotionEvent motionEvent) {
        if (g()) {
            return b(motionEvent.getX(), motionEvent.getY());
        }
        this.i = false;
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        RelativeLayout relativeLayout = this.f32692d;
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
