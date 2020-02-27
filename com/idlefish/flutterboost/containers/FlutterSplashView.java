package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.idlefish.flutterboost.Debuger;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
/* loaded from: classes6.dex */
public class FlutterSplashView extends FrameLayout {
    private static String TAG = "FlutterSplashView";
    @NonNull
    private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
    @Nullable
    private XFlutterView flutterView;
    private Handler handler;
    private FlutterEngine mFlutterEngine;
    @NonNull
    private final FlutterUiDisplayListener onFirstFrameRenderedListener;
    @NonNull
    private final Runnable onTransitionComplete;
    @Nullable
    private String previousCompletedSplashIsolate;
    @Nullable
    private SplashScreen splashScreen;
    @Nullable
    private Bundle splashScreenState;
    @Nullable
    private View splashScreenView;
    @Nullable
    private String transitioningIsolateId;

    public FlutterSplashView(@NonNull Context context) {
        this(context, null, 0);
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.handler = new Handler();
        this.flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.1
            public void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine) {
                FlutterSplashView.this.flutterView.removeFlutterEngineAttachmentListener(this);
            }

            public void onFlutterEngineDetachedFromFlutterView() {
            }
        };
        this.onFirstFrameRenderedListener = new FlutterUiDisplayListener() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.2
            public void onFlutterUiDisplayed() {
                if (FlutterSplashView.this.splashScreen != null) {
                    FlutterSplashView.this.transitionToFlutter();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.onTransitionComplete = new Runnable() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.3
            @Override // java.lang.Runnable
            public void run() {
                FlutterSplashView.this.removeView(FlutterSplashView.this.splashScreenView);
                FlutterSplashView.this.previousCompletedSplashIsolate = FlutterSplashView.this.transitioningIsolateId;
            }
        };
        setSaveEnabled(true);
        if (this.mFlutterEngine == null) {
            this.mFlutterEngine = FlutterBoost.instance().engineProvider();
        }
    }

    public void displayFlutterViewWithSplash(@NonNull XFlutterView xFlutterView, @Nullable SplashScreen splashScreen) {
        if (this.flutterView != null) {
            this.flutterView.removeOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
            removeView(this.flutterView);
        }
        if (this.splashScreenView != null) {
            removeView(this.splashScreenView);
        }
        this.flutterView = xFlutterView;
        addView(xFlutterView);
        this.splashScreen = splashScreen;
        if (splashScreen != null) {
            this.splashScreenView = splashScreen.createSplashView(getContext(), this.splashScreenState);
            this.splashScreenView.setBackgroundColor(-1);
            addView(this.splashScreenView);
            xFlutterView.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionToFlutter() {
        this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        Log.v(TAG, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
        this.splashScreen.transitionToFlutter(this.onTransitionComplete);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.handler.removeCallbacksAndMessages(null);
    }

    public void onAttach() {
        Debuger.log("BoostFlutterView onAttach");
        this.flutterView.attachToFlutterEngine(this.mFlutterEngine);
    }

    public void onDetach() {
        Debuger.log("BoostFlutterView onDetach");
        this.flutterView.detachFromFlutterEngine();
    }
}
