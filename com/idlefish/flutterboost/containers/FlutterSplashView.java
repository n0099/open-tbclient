package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.idlefish.flutterboost.Debuger;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
/* loaded from: classes19.dex */
public class FlutterSplashView extends FrameLayout {
    private static String TAG = "FlutterSplashView";
    @NonNull
    private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
    @Nullable
    private XFlutterView flutterView;
    private Handler handler;
    private boolean isFirstFrameRendered;
    private CustomMessageListener listener;
    @NonNull
    private final Runnable loadingShowTimeOut;
    private FlutterEngine mFlutterEngine;
    @NonNull
    private final FlutterUiDisplayListener onFirstFrameRenderedListener;
    @NonNull
    private final Runnable onTransitionComplete;
    @Nullable
    private String previousCompletedSplashIsolate;
    @NonNull
    private final FlutterUiDisplayListener removeSplashListener;
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
        this.isFirstFrameRendered = false;
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
                FlutterSplashView.this.isFirstFrameRendered = true;
                if (FlutterSplashView.this.splashScreen != null) {
                    FlutterSplashView.this.transitionToFlutter();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
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
        this.loadingShowTimeOut = new Runnable() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.4
            @Override // java.lang.Runnable
            public void run() {
                if (!FlutterBoost.instance().isReady) {
                    FlutterBoost.instance().isReady = true;
                    TiebaStatic.log(new ar("flutter_loading_timeout"));
                    FlutterSplashView.this.transitionToFlutter();
                }
            }
        };
        this.listener = new CustomMessageListener(2921459) { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && FlutterSplashView.this.splashScreen != null) {
                    FlutterBoost.instance().isReady = true;
                    FlutterSplashView.this.handler.removeCallbacks(FlutterSplashView.this.loadingShowTimeOut);
                    if (FlutterSplashView.this.isFirstFrameRendered) {
                        FlutterSplashView.this.transitionToFlutter();
                    }
                }
            }
        };
        this.removeSplashListener = new FlutterUiDisplayListener() { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.6
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterSplashView.this.isFirstFrameRendered = true;
                if (FlutterBoost.instance().isReady && FlutterSplashView.this.splashScreen != null) {
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
        MessageManager.getInstance().registerListener(this.listener);
    }

    public void displayFlutterViewWithSplash(@NonNull XFlutterView xFlutterView, @Nullable SplashScreen splashScreen) {
        if (this.flutterView != null) {
            this.flutterView.removeOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
            removeView(this.flutterView);
        }
        if (this.splashScreenView != null) {
            removeView(this.splashScreenView);
        }
        this.handler.removeCallbacks(this.loadingShowTimeOut);
        this.flutterView = xFlutterView;
        addView(xFlutterView);
        this.splashScreen = splashScreen;
        if (splashScreen != null) {
            this.splashScreenView = splashScreen.createSplashView(getContext(), this.splashScreenState);
            addView(this.splashScreenView);
            if (FlutterBoost.instance().isReady) {
                xFlutterView.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
                return;
            }
            this.handler.postDelayed(this.loadingShowTimeOut, 5000L);
            this.isFirstFrameRendered = true;
        }
    }

    public void showSplash(SplashScreen splashScreen) {
        if (splashScreen != null && !isAttachedToFlutterEngine()) {
            if (this.splashScreenView.isAttachedToWindow()) {
                removeView(this.splashScreenView);
            }
            this.splashScreenView = splashScreen.createSplashView(getContext(), this.splashScreenState);
            addView(this.splashScreenView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionToFlutter() {
        if (this.flutterView.getAttachedFlutterEngine() != null) {
            this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
            Log.v(TAG, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
        }
        this.splashScreen.transitionToFlutter(this.onTransitionComplete);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        super.onDetachedFromWindow();
        this.handler.removeCallbacksAndMessages(null);
    }

    public void onAttach() {
        Debuger.log("BoostFlutterView onAttach");
        this.flutterView.attachToFlutterEngine(this.mFlutterEngine);
        if (this.splashScreenView != null && this.splashScreenView.isAttachedToWindow()) {
            this.flutterView.addOnFirstFrameRenderedListener(this.removeSplashListener);
        } else {
            this.isFirstFrameRendered = true;
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
}
