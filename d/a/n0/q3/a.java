package d.a.n0.q3;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.a.n0.q3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class animation.Animation$AnimationListenerC1541a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f62037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f62038b;

        public animation.Animation$AnimationListenerC1541a(Animation.AnimationListener animationListener, View view) {
            this.f62037a = animationListener;
            this.f62038b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f62037a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f62038b;
            if (view != null) {
                view.clearAnimation();
                this.f62038b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f62037a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f62037a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f62039a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f62040b;

        public b(Animation.AnimationListener animationListener, View view) {
            this.f62039a = animationListener;
            this.f62040b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f62039a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f62040b;
            if (view != null) {
                view.clearAnimation();
                this.f62040b.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f62039a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f62039a;
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
        alphaAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1541a(animationListener, view));
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }
}
