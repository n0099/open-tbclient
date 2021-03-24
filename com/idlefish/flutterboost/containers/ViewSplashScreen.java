package com.idlefish.flutterboost.containers;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import io.flutter.embedding.android.SplashScreen;
/* loaded from: classes6.dex */
public final class ViewSplashScreen implements SplashScreen {
    public final View splashView;

    public ViewSplashScreen(@NonNull View view) {
        this.splashView = view;
    }

    @Override // io.flutter.embedding.android.SplashScreen
    @Nullable
    public View createSplashView(@NonNull Context context, @Nullable Bundle bundle) {
        return this.splashView;
    }

    @Override // io.flutter.embedding.android.SplashScreen
    public boolean doesSplashViewRememberItsTransition() {
        return false;
    }

    @Override // io.flutter.embedding.android.SplashScreen
    public Bundle saveSplashScreenState() {
        return null;
    }

    @Override // io.flutter.embedding.android.SplashScreen
    @RequiresApi(api = 12)
    public void transitionToFlutter(@NonNull final Runnable runnable) {
        View view = this.splashView;
        if (view == null) {
            runnable.run();
        } else {
            view.animate().alpha(0.0f).setDuration(5L).setListener(new Animator.AnimatorListener(this) { // from class: com.idlefish.flutterboost.containers.ViewSplashScreen.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    runnable.run();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    runnable.run();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
    }
}
