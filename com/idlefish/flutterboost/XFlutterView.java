package com.idlefish.flutterboost;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.LocaleList;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.baidu.tbadk.core.util.UtilHelper;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterSurfaceView;
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
    public AccessibilityBridge accessibilityBridge;
    @Nullable
    public XAndroidKeyProcessor androidKeyProcessor;
    @Nullable
    public AndroidTouchProcessor androidTouchProcessor;
    @Nullable
    public FlutterEngine flutterEngine;
    @NonNull
    public final Set<FlutterView.FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    public boolean isFlutterUiDisplayed;
    public final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    @NonNull
    public FlutterView.RenderMode renderMode;
    @Nullable
    public RenderSurface renderSurface;
    @Nullable
    public XTextInputPlugin textInputPlugin;
    @Nullable
    public FlutterView.TransparencyMode transparencyMode;
    public final FlutterRenderer.ViewportMetrics viewportMetrics;

    /* renamed from: com.idlefish.flutterboost.XFlutterView$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode;

        static {
            int[] iArr = new int[FlutterView.RenderMode.values().length];
            $SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode = iArr;
            try {
                iArr[FlutterView.RenderMode.surface.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode[FlutterView.RenderMode.texture.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public XFlutterView(@NonNull Context context) {
        this(context, null, null, null);
    }

    public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    public void attachToFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Log.d("FlutterView", "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.flutterEngine) {
                Log.d("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.d("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.flutterEngine = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        renderer.isDisplayingFlutterUi();
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        this.flutterEngine.getPlatformViewsController().attachToView(this);
        XTextInputPlugin textInputPlugin = XTextInputPlugin.getTextInputPlugin(this.flutterEngine.getDartExecutor(), this.flutterEngine.getPlatformViewsController());
        this.textInputPlugin = textInputPlugin;
        textInputPlugin.updateView(this);
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.androidKeyProcessor = new XAndroidKeyProcessor(this.flutterEngine.getKeyEventChannel(), this.textInputPlugin);
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer());
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        sendUserSettingsToFlutter();
        sendLocalesToFlutter(getResources().getConfiguration());
        sendViewportMetricsToFlutter(5);
        for (FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine != null && view != null) {
            return flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view);
        }
        return super.checkInputConnectionProxy(view);
    }

    public void detachFromFlutterEngine() {
        Log.d("FlutterView", "Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            Log.d("FlutterView", "Not attached to an engine. Doing nothing.");
            return;
        }
        for (FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineDetachedFromFlutterView();
        }
        this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
        this.flutterEngine.getPlatformViewsController().detachFromView();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        this.renderSurface.detachFromRenderer();
        this.flutterEngine = null;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT <= 19) {
            FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
            viewportMetrics.paddingTop = rect.top;
            viewportMetrics.paddingRight = rect.right;
            viewportMetrics.paddingBottom = 0;
            viewportMetrics.paddingLeft = rect.left;
            viewportMetrics.viewInsetTop = 0;
            viewportMetrics.viewInsetRight = 0;
            viewportMetrics.viewInsetBottom = rect.bottom;
            viewportMetrics.viewInsetLeft = 0;
            Log.v("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
            sendViewportMetricsToFlutter(4);
            return true;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    @Nullable
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.accessibilityBridge;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    @Nullable
    @VisibleForTesting
    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    public final void init() {
        Log.v("FlutterView", "Initializing FlutterView");
        int i2 = AnonymousClass3.$SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode[this.renderMode.ordinal()];
        if (i2 == 1) {
            Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(getContext(), this.transparencyMode == FlutterView.TransparencyMode.transparent);
            this.renderSurface = flutterSurfaceView;
            addView(flutterSurfaceView);
        } else if (i2 == 2) {
            Log.v("FlutterView", "Internally using a FlutterTextureView.");
            XFlutterTextureView xFlutterTextureView = new XFlutterTextureView(getContext());
            this.renderSurface = xFlutterTextureView;
            addView(xFlutterTextureView);
        }
        setPadding();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        return this.flutterEngine != null;
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
        FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
        viewportMetrics.paddingBottom = 0;
        viewportMetrics.paddingLeft = windowInsets.getSystemWindowInsetLeft();
        FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
        viewportMetrics2.viewInsetTop = 0;
        viewportMetrics2.viewInsetRight = 0;
        viewportMetrics2.viewInsetBottom = windowInsets.getSystemWindowInsetBottom();
        this.viewportMetrics.viewInsetLeft = 0;
        Log.v("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter(3);
        return onApplyWindowInsets;
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
        try {
            sendLocalesToFlutter(configuration);
            sendUserSettingsToFlutter();
        } catch (Throwable unused) {
            Log.e("FlutterView", "onConfigurationChanged error ");
        }
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.textInputPlugin.createInputConnection(this, editorInfo);
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
        return this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.androidKeyProcessor.onKeyDown(keyEvent);
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onKeyUp(i2, keyEvent);
        }
        this.androidKeyProcessor.onKeyUp(keyEvent);
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Log.v("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i4 + " x " + i5 + ", it is now " + i2 + " x " + i3);
        FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
        viewportMetrics.width = i2;
        viewportMetrics.height = i3;
        sendViewportMetricsToFlutter(2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        AndroidTouchProcessor androidTouchProcessor = this.androidTouchProcessor;
        if (androidTouchProcessor == null) {
            return super.onTouchEvent(motionEvent);
        }
        return androidTouchProcessor.onTouchEvent(motionEvent);
    }

    public void release() {
        XTextInputPlugin xTextInputPlugin = this.textInputPlugin;
        if (xTextInputPlugin != null) {
            xTextInputPlugin.release(this);
        }
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    public final void resetWillNotDraw(boolean z, boolean z2) {
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

    public final void sendLocalesToFlutter(@NonNull Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            int size = locales.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(locales.get(i2));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine == null || flutterEngine.getLocalizationChannel() == null) {
            return;
        }
        this.flutterEngine.getLocalizationChannel().sendLocales(arrayList);
    }

    public final void sendUserSettingsToFlutter() {
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine == null || flutterEngine.getSettingsChannel() == null) {
            return;
        }
        this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).send();
    }

    public final void sendViewportMetricsToFlutter(int i2) {
        if (!isAttachedToFlutterEngine()) {
            Log.w("FlutterView", i2 + " Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
        if (viewportMetrics.width == 0 && viewportMetrics.height == 0) {
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }

    public final void setPadding() {
        this.viewportMetrics.paddingTop = UtilHelper.getStatusBarHeight();
        sendViewportMetricsToFlutter(1);
    }

    public XFlutterView(@NonNull Context context, @NonNull FlutterView.RenderMode renderMode, @NonNull FlutterView.TransparencyMode transparencyMode) {
        this(context, null, renderMode, transparencyMode);
    }

    public XFlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, null, null);
    }

    public XFlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @Nullable FlutterView.RenderMode renderMode, @Nullable FlutterView.TransparencyMode transparencyMode) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: com.idlefish.flutterboost.XFlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                XFlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: com.idlefish.flutterboost.XFlutterView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                XFlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : XFlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
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
}
