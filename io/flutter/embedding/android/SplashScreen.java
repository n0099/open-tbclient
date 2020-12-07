package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes9.dex */
public interface SplashScreen {
    View createSplashView(Context context, Bundle bundle);

    @SuppressLint({"NewApi"})
    boolean doesSplashViewRememberItsTransition();

    @SuppressLint({"NewApi"})
    Bundle saveSplashScreenState();

    void transitionToFlutter(Runnable runnable);
}
