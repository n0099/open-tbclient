package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes12.dex */
public final class DrawableSplashScreen implements SplashScreen {
    private final long crossfadeDurationInMillis;
    private final Drawable drawable;
    private final ImageView.ScaleType scaleType;
    private DrawableSplashScreenView splashView;

    @Override // io.flutter.embedding.android.SplashScreen
    public boolean doesSplashViewRememberItsTransition() {
        return SplashScreen$$CC.doesSplashViewRememberItsTransition(this);
    }

    @Override // io.flutter.embedding.android.SplashScreen
    public Bundle saveSplashScreenState() {
        return SplashScreen$$CC.saveSplashScreenState(this);
    }

    public DrawableSplashScreen(@NonNull Drawable drawable) {
        this(drawable, ImageView.ScaleType.FIT_XY, 500L);
    }

    public DrawableSplashScreen(@NonNull Drawable drawable, @NonNull ImageView.ScaleType scaleType, long j) {
        this.drawable = drawable;
        this.scaleType = scaleType;
        this.crossfadeDurationInMillis = j;
    }

    @Override // io.flutter.embedding.android.SplashScreen
    @Nullable
    public View createSplashView(@NonNull Context context, @Nullable Bundle bundle) {
        this.splashView = new DrawableSplashScreenView(context);
        this.splashView.setSplashDrawable(this.drawable, this.scaleType);
        return this.splashView;
    }

    @Override // io.flutter.embedding.android.SplashScreen
    public void transitionToFlutter(@NonNull final Runnable runnable) {
        if (this.splashView == null) {
            runnable.run();
        } else {
            this.splashView.animate().alpha(0.0f).setDuration(this.crossfadeDurationInMillis).setListener(new Animator.AnimatorListener() { // from class: io.flutter.embedding.android.DrawableSplashScreen.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    runnable.run();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    runnable.run();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public static class DrawableSplashScreenView extends ImageView {
        public DrawableSplashScreenView(@NonNull Context context) {
            this(context, null, 0);
        }

        public DrawableSplashScreenView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public DrawableSplashScreenView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public void setSplashDrawable(@Nullable Drawable drawable) {
            setSplashDrawable(drawable, ImageView.ScaleType.FIT_XY);
        }

        public void setSplashDrawable(@Nullable Drawable drawable, @NonNull ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }
    }
}
