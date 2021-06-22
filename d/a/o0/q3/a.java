package d.a.o0.q3;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.a.o0.q3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class animation.Animation$AnimationListenerC1545a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f62162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f62163b;

        public animation.Animation$AnimationListenerC1545a(Animation.AnimationListener animationListener, View view) {
            this.f62162a = animationListener;
            this.f62163b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f62162a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f62163b;
            if (view != null) {
                view.clearAnimation();
                this.f62163b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f62162a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f62162a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f62164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f62165b;

        public b(Animation.AnimationListener animationListener, View view) {
            this.f62164a = animationListener;
            this.f62165b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f62164a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f62165b;
            if (view != null) {
                view.clearAnimation();
                this.f62165b.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f62164a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f62164a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    public static void a(View view, int i2) {
        b(view, i2, null);
    }

    public static void b(View view, int i2, Animation.AnimationListener animationListener) {
        if (view == null || i2 < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b(animationListener, view));
        view.setVisibility(8);
        view.startAnimation(alphaAnimation);
    }

    public static void c(View view, int i2) {
        d(view, i2, null);
    }

    public static void d(View view, int i2, Animation.AnimationListener animationListener) {
        if (view == null || i2 < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1545a(animationListener, view));
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }
}
