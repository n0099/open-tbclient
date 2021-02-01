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
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import java.util.Map;
/* loaded from: classes5.dex */
public class FlutterSplashView extends FrameLayout {
    private static String TAG = "FlutterSplashView";
    @NonNull
    private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
    @Nullable
    private XFlutterView flutterView;
    private boolean forceShowSplash;
    private Handler handler;
    private FlutterEngine mFlutterEngine;
    @NonNull
    private final FlutterUiDisplayListener onFirstFrameRenderedListener;
    @NonNull
    private final Runnable onTransitionComplete;
    @Nullable
    private String previousCompletedSplashIsolate;
    private long removeDelay;
    @NonNull
    private final FlutterUiDisplayListener removeSplashListener;
    private final FlutterBoostPlugin.EventListener splashEventListener;
    @Nullable
    private SplashScreen splashScreen;
    @Nullable
    private Bundle splashScreenState;
    @Nullable
    private View splashScreenView;
    @NonNull
    private final Runnable transitionToFlutter;
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
        this.forceShowSplash = false;
        this.removeDelay = 0L;
        this.flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.1
            @Override // io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener
            public void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine) {
                FlutterSplashView.this.flutterView.removeFlutterEngineAttachmentListener(this);
            }

            @Override // io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener
            public void onFlutterEngineDetachedFromFlutterView() {
            }
        };
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
                FlutterSplashView.this.removeView(FlutterSplashView.this.splashScreenView);
                FlutterSplashView.this.previousCompletedSplashIsolate = FlutterSplashView.this.transitioningIsolateId;
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
            addView(this.splashScreenView);
            xFlutterView.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
        }
    }

    public void showSplash(SplashScreen splashScreen) {
        if (splashScreen != null && !isAttachedToFlutterEngine()) {
            if (this.splashScreenView.isAttachedToWindow()) {
                removeView(this.splashScreenView);
            }
            this.splashScreenView = splashScreen.createSplashView(getContext(), this.splashScreenState);
            addView(this.splashScreenView);
            this.forceShowSplash = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionToFlutter() {
        if (this.flutterView.getAttachedFlutterEngine() != null) {
            this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
            Log.v(TAG, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
        }
        if (this.splashScreen != null) {
            this.splashScreen.transitionToFlutter(this.onTransitionComplete);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.handler.removeCallbacksAndMessages(null);
        FlutterBoostPlugin.singleton().removeEventListener(this.splashEventListener);
    }

    public void onAttach() {
        Debuger.log("BoostFlutterView onAttach");
        this.flutterView.attachToFlutterEngine(this.mFlutterEngine);
        if (this.forceShowSplash && this.splashScreenView != null && this.splashScreenView.isAttachedToWindow()) {
            this.forceShowSplash = false;
            this.flutterView.addOnFirstFrameRenderedListener(this.removeSplashListener);
            this.handler.postDelayed(this.onTransitionComplete, 5000L);
        }
    }

    public void onDetach() {
        Debuger.log("BoostFlutterView onDetach");
        this.flutterView.detachFromFlutterEngine();
    }

    public boolean isAttachedToFlutterEngine() {
        boolean isAttachedToFlutterEngine = this.flutterView.isAttachedToFlutterEngine();
        Debuger.log("BoostFlutterView isAttachedToFlutterEngine:" + isAttachedToFlutterEngine);
        return isAttachedToFlutterEngine;
    }

    public void removeSplashDelay(long j) {
        this.removeDelay = j;
    }
}
