package d.b.i0.p3;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.b.i0.p3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class animation.Animation$AnimationListenerC1432a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f58950a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f58951b;

        public animation.Animation$AnimationListenerC1432a(Animation.AnimationListener animationListener, View view) {
            this.f58950a = animationListener;
            this.f58951b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f58950a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f58951b;
            if (view != null) {
                view.clearAnimation();
                this.f58951b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f58950a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f58950a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f58952a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f58953b;

        public b(Animation.AnimationListener animationListener, View view) {
            this.f58952a = animationListener;
            this.f58953b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f58952a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            View view = this.f58953b;
            if (view != null) {
                view.clearAnimation();
                this.f58953b.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f58952a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f58952a;
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
        alphaAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1432a(animationListener, view));
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }
}
