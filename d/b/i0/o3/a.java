package d.b.i0.o3;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.b.i0.o3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class animation.Animation$AnimationListenerC1374a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f57304a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f57305b;

        public animation.Animation$AnimationListenerC1374a(Animation.AnimationListener animationListener, View view) {
            this.f57304a = animationListener;
            this.f57305b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f57304a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f57305b;
            if (view != null) {
                view.clearAnimation();
                this.f57305b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f57304a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f57304a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f57306a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f57307b;

        public b(Animation.AnimationListener animationListener, View view) {
            this.f57306a = animationListener;
            this.f57307b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f57306a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f57307b;
            if (view != null) {
                view.clearAnimation();
                this.f57307b.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f57306a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f57306a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    public static void a(View view, int i) {
        b(view, i, null);
    }

    public static void b(View view, int i, Animation.AnimationListener animationListener) {
        if (view == null || i < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b(animationListener, view));
        view.setVisibility(8);
        view.startAnimation(alphaAnimation);
    }

    public static void c(View view, int i) {
        d(view, i, null);
    }

    public static void d(View view, int i, Animation.AnimationListener animationListener) {
        if (view == null || i < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1374a(animationListener, view));
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }
}
