package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.idlefish.flutterboost.Debuger;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.Log;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import java.util.Map;
/* loaded from: classes6.dex */
public class FlutterSplashView extends FrameLayout {
    public static String TAG = "FlutterSplashView";
    @Nullable
    public XFlutterView flutterView;
    public boolean forceShowSplash;
    public Handler handler;
    public FlutterEngine mFlutterEngine;
    @NonNull
    public final FlutterUiDisplayListener onFirstFrameRenderedListener;
    @NonNull
    public final Runnable onTransitionComplete;
    @Nullable
    public String previousCompletedSplashIsolate;
    public long removeDelay;
    @NonNull
    public final FlutterUiDisplayListener removeSplashListener;
    public final FlutterBoostPlugin.EventListener splashEventListener;
    @Nullable
    public SplashScreen splashScreen;
    @Nullable
    public Bundle splashScreenState;
    @Nullable
    public View splashScreenView;
    @NonNull
    public final Runnable transitionToFlutter;
    @Nullable
    public String transitioningIsolateId;

    public FlutterSplashView(@NonNull Context context) {
        this(context, null, 0);
    }

    public void displayFlutterViewWithSplash(@NonNull XFlutterView xFlutterView, @Nullable SplashScreen splashScreen) {
        XFlutterView xFlutterView2 = this.flutterView;
        if (xFlutterView2 != null) {
            xFlutterView2.removeOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
            removeView(this.flutterView);
        }
        View view = this.splashScreenView;
        if (view != null) {
            removeView(view);
        }
        this.flutterView = xFlutterView;
        addView(xFlutterView);
        this.splashScreen = splashScreen;
        if (splashScreen != null) {
            View createSplashView = splashScreen.createSplashView(getContext(), this.splashScreenState);
            this.splashScreenView = createSplashView;
            addView(createSplashView);
            xFlutterView.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
        }
    }

    public boolean isAttachedToFlutterEngine() {
        boolean isAttachedToFlutterEngine = this.flutterView.isAttachedToFlutterEngine();
        Debuger.log("BoostFlutterView isAttachedToFlutterEngine:" + isAttachedToFlutterEngine);
        return isAttachedToFlutterEngine;
    }

    public void onAttach() {
        View view;
        Debuger.log("BoostFlutterView onAttach");
        this.flutterView.attachToFlutterEngine(this.mFlutterEngine);
        if (this.forceShowSplash && (view = this.splashScreenView) != null && view.isAttachedToWindow()) {
            this.forceShowSplash = false;
            this.flutterView.addOnFirstFrameRenderedListener(this.removeSplashListener);
            this.handler.postDelayed(this.onTransitionComplete, 5000L);
        }
    }

    public void onDetach() {
        Debuger.log("BoostFlutterView onDetach");
        this.flutterView.detachFromFlutterEngine();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.handler.removeCallbacksAndMessages(null);
        FlutterBoostPlugin.singleton().removeEventListener(this.splashEventListener);
    }

    public void removeSplashDelay(long j) {
        this.removeDelay = j;
    }

    public void showSplash(SplashScreen splashScreen) {
        if (splashScreen == null || isAttachedToFlutterEngine()) {
            return;
        }
        if (this.splashScreenView.isAttachedToWindow()) {
            removeView(this.splashScreenView);
        }
        View createSplashView = splashScreen.createSplashView(getContext(), this.splashScreenState);
        this.splashScreenView = createSplashView;
        addView(createSplashView);
        this.forceShowSplash = true;
    }

    public final void transitionToFlutter() {
        if (this.flutterView.getAttachedFlutterEngine() != null) {
            this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
            String str = TAG;
            Log.v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
        }
        SplashScreen splashScreen = this.splashScreen;
        if (splashScreen != null) {
            splashScreen.transitionToFlutter(this.onTransitionComplete);
        }
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.handler = new Handler();
        this.forceShowSplash = false;
        this.removeDelay = 0L;
        this.onFirstFrameRenderedListener = new FlutterUiDisplayListener() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.transitionToFlutter = new Runnable() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.3
            @Override // java.lang.Runnable
            public void run() {
                FlutterSplashView.this.removeDelay = 0L;
                FlutterSplashView.this.transitionToFlutter();
            }
        };
        this.onTransitionComplete = new Runnable() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.4
            @Override // java.lang.Runnable
            public void run() {
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.removeView(flutterSplashView.splashScreenView);
                FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
                flutterSplashView2.previousCompletedSplashIsolate = flutterSplashView2.transitioningIsolateId;
            }
        };
        this.splashEventListener = new FlutterBoostPlugin.EventListener() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.5
            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                if ("flutterPostFrame".equals(str)) {
                    FlutterSplashView.this.handler.postDelayed(FlutterSplashView.this.transitionToFlutter, FlutterSplashView.this.removeDelay);
                }
            }
        };
        this.removeSplashListener = new FlutterUiDisplayListener() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.6
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                if (FlutterSplashView.this.splashScreen != null) {
                    FlutterSplashView.this.handler.removeCallbacks(FlutterSplashView.this.onTransitionComplete);
                    FlutterSplashView.this.handler.postDelayed(FlutterSplashView.this.onTransitionComplete, 100L);
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        setSaveEnabled(true);
        if (this.mFlutterEngine == null) {
            this.mFlutterEngine = FlutterBoost.instance().engineProvider();
        }
        FlutterBoostPlugin.singleton().addEventListener("flutterPostFrame", this.splashEventListener);
    }
}
