package com.idlefish.flutterboost;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.view.AccessibilityBridge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class XFlutterView extends FrameLayout {
    @Nullable
    private AccessibilityBridge accessibilityBridge;
    @Nullable
    private XAndroidKeyProcessor androidKeyProcessor;
    @Nullable
    private AndroidTouchProcessor androidTouchProcessor;
    @Nullable
    private FlutterEngine flutterEngine;
    @NonNull
    private final Set<FlutterView.FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    private boolean hasAddFirstFrameRenderedListener;
    private boolean isFlutterUiDisplayed;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    @NonNull
    private FlutterView.RenderMode renderMode;
    @Nullable
    private RenderSurface renderSurface;
    @Nullable
    private XTextInputPlugin textInputPlugin;
    @Nullable
    private FlutterView.TransparencyMode transparencyMode;
    private final FlutterRenderer.ViewportMetrics viewportMetrics;

    public XFlutterView(@NonNull Context context) {
        this(context, null, null, null);
    }

    public XFlutterView(@NonNull Context context, @NonNull FlutterView.RenderMode renderMode, @NonNull FlutterView.TransparencyMode transparencyMode) {
        this(context, null, renderMode, transparencyMode);
    }

    public XFlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, null, null);
    }

    private XFlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @Nullable FlutterView.RenderMode renderMode, @Nullable FlutterView.TransparencyMode transparencyMode) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.hasAddFirstFrameRenderedListener = false;
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: com.idlefish.flutterboost.XFlutterView.1
            public void onAccessibilityChanged(boolean z, boolean z2) {
                XFlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: com.idlefish.flutterboost.XFlutterView.2
            public void onFlutterUiDisplayed() {
                XFlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : XFlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                XFlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : XFlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.renderMode = renderMode == null ? FlutterView.RenderMode.surface : renderMode;
        this.transparencyMode = transparencyMode == null ? FlutterView.TransparencyMode.opaque : transparencyMode;
        init();
    }

    private void init() {
        BdLog.v("Initializing FlutterView");
        switch (AnonymousClass3.$SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode[this.renderMode.ordinal()]) {
            case 1:
                BdLog.v("Internally using a FlutterSurfaceView.");
                FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(getContext(), this.transparencyMode == FlutterView.TransparencyMode.transparent);
                this.renderSurface = flutterSurfaceView;
                addView(flutterSurfaceView);
                break;
            case 2:
                BdLog.v("Internally using a FlutterTextureView.");
                FlutterTextureView flutterTextureView = new FlutterTextureView(getContext());
                this.renderSurface = flutterTextureView;
                addView(flutterTextureView);
                break;
        }
        setPadding();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.idlefish.flutterboost.XFlutterView$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode = new int[FlutterView.RenderMode.values().length];

        static {
            try {
                $SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode[FlutterView.RenderMode.surface.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode[FlutterView.RenderMode.texture.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void setPadding() {
        this.viewportMetrics.paddingTop = UtilHelper.getStatusBarHeight();
        sendViewportMetricsToFlutter();
    }

    public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        BdLog.v("Configuration changed. Sending locales and user settings to Flutter.");
        try {
            sendLocalesToFlutter(configuration);
            sendUserSettingsToFlutter();
        } catch (Throwable th) {
            BdLog.e("onConfigurationChanged error ");
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        BdLog.v("Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.viewportMetrics.width = i;
        this.viewportMetrics.height = i2;
        sendViewportMetricsToFlutter();
    }

    @Override // android.view.View
    @NonNull
    @SuppressLint({"InlinedApi", "NewApi"})
    @RequiresApi(20)
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        this.viewportMetrics.paddingTop = windowInsets.getSystemWindowInsetTop();
        this.viewportMetrics.paddingRight = windowInsets.getSystemWindowInsetRight();
        this.viewportMetrics.paddingBottom = 0;
        this.viewportMetrics.paddingLeft = windowInsets.getSystemWindowInsetLeft();
        this.viewportMetrics.viewInsetTop = 0;
        this.viewportMetrics.viewInsetRight = 0;
        this.viewportMetrics.viewInsetBottom = windowInsets.getSystemWindowInsetBottom();
        this.viewportMetrics.viewInsetLeft = 0;
        BdLog.v("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        return onApplyWindowInsets;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT <= 19) {
            this.viewportMetrics.paddingTop = rect.top;
            this.viewportMetrics.paddingRight = rect.right;
            this.viewportMetrics.paddingBottom = 0;
            this.viewportMetrics.paddingLeft = rect.left;
            this.viewportMetrics.viewInsetTop = 0;
            this.viewportMetrics.viewInsetRight = 0;
            this.viewportMetrics.viewInsetBottom = rect.bottom;
            this.viewportMetrics.viewInsetLeft = 0;
            BdLog.v("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
            sendViewportMetricsToFlutter();
            return true;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        return !isAttachedToFlutterEngine() ? super.onCreateInputConnection(editorInfo) : this.textInputPlugin.createInputConnection(this, editorInfo);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return this.flutterEngine != null ? this.flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.androidKeyProcessor.onKeyUp(keyEvent);
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.androidKeyProcessor.onKeyDown(keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        boolean onAccessibilityHoverEvent = this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
        if (!onAccessibilityHoverEvent) {
        }
        return onAccessibilityHoverEvent;
    }

    @Override // android.view.View
    @Nullable
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.accessibilityBridge == null || !this.accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWillNotDraw(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled()) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            return;
        }
        setWillNotDraw(false);
    }

    @RequiresApi(api = 3)
    @SuppressLint({"NewApi"})
    public void attachToFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        BdLog.d("Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.flutterEngine) {
                BdLog.d("Already attached to this engine. Doing nothing.");
                return;
            } else {
                BdLog.d("Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.flutterEngine = flutterEngine;
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = renderer.isDisplayingFlutterUi();
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (this.textInputPlugin == null) {
            this.textInputPlugin = new XTextInputPlugin(this, flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
        }
        this.textInputPlugin.setTextInputMethodHandler();
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.androidKeyProcessor = new XAndroidKeyProcessor(this.flutterEngine.getKeyEventChannel(), this.textInputPlugin);
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer());
        this.accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        sendUserSettingsToFlutter();
        sendLocalesToFlutter(getResources().getConfiguration());
        sendViewportMetricsToFlutter();
        for (FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
    }

    public void detachFromFlutterEngine() {
        BdLog.d("Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            BdLog.d("Not attached to an engine. Doing nothing.");
            return;
        }
        for (FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineDetachedFromFlutterView();
        }
        this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = false;
        renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        this.renderSurface.detachFromRenderer();
        this.flutterEngine = null;
    }

    public void release() {
        if (this.textInputPlugin != null) {
            this.textInputPlugin.release();
        }
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        return this.flutterEngine != null;
    }

    @VisibleForTesting
    @Nullable
    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    @VisibleForTesting
    public void removeFlutterEngineAttachmentListener(@NonNull FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
    }

    private void sendLocalesToFlutter(@NonNull Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            int size = locales.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(locales.get(i));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        if (this.flutterEngine != null && this.flutterEngine.getLocalizationChannel() != null) {
            this.flutterEngine.getLocalizationChannel().sendLocales(arrayList);
        }
    }

    private void sendUserSettingsToFlutter() {
        if (this.flutterEngine != null && this.flutterEngine.getSettingsChannel() != null) {
            this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).send();
        }
    }

    private void sendViewportMetricsToFlutter() {
        if (!isAttachedToFlutterEngine()) {
            BdLog.w("Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }
}
