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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public class XFlutterView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AccessibilityBridge accessibilityBridge;
    @Nullable
    public XAndroidKeyProcessor androidKeyProcessor;
    @Nullable
    public AndroidTouchProcessor androidTouchProcessor;
    public boolean didRenderFirstFrame;
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
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(697876644, "Lcom/idlefish/flutterboost/XFlutterView$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(697876644, "Lcom/idlefish/flutterboost/XFlutterView$3;");
                    return;
                }
            }
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XFlutterView(@NonNull Context context) {
        this(context, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterView.RenderMode) objArr2[2], (FlutterView.TransparencyMode) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public void addFlutterEngineAttachmentListener(@NonNull FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterEngineAttachmentListener) == null) {
            this.flutterEngineAttachmentListeners.add(flutterEngineAttachmentListener);
        }
    }

    public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterUiDisplayListener) == null) {
            this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
        }
    }

    public void attachToFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flutterEngine) == null) {
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
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            FlutterEngine flutterEngine = this.flutterEngine;
            if (flutterEngine != null && view != null) {
                return flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view);
            }
            return super.checkInputConnectionProxy(view);
        }
        return invokeL.booleanValue;
    }

    public void detachFromFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
    }

    @Override // android.view.View
    public boolean fitSystemWindows(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rect)) == null) {
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
                Log.v("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + StringUtils.LF + "Keyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
                sendViewportMetricsToFlutter(4);
                return true;
            }
            return super.fitSystemWindows(rect);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    @Nullable
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AccessibilityBridge accessibilityBridge = this.accessibilityBridge;
            if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
                return null;
            }
            return this.accessibilityBridge;
        }
        return (AccessibilityNodeProvider) invokeV.objValue;
    }

    @Nullable
    @VisibleForTesting
    public FlutterEngine getAttachedFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.flutterEngine : (FlutterEngine) invokeV.objValue;
    }

    public boolean hasRenderedFirstFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.didRenderFirstFrame : invokeV.booleanValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.flutterEngine != null : invokeV.booleanValue;
    }

    @Override // android.view.View
    @NonNull
    @SuppressLint({"InlinedApi", "NewApi"})
    @RequiresApi(20)
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, windowInsets)) == null) {
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
            Log.v("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + StringUtils.LF + "Keyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
            sendViewportMetricsToFlutter(3);
            return onApplyWindowInsets;
        }
        return (WindowInsets) invokeL.objValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            try {
                sendLocalesToFlutter(configuration);
                sendUserSettingsToFlutter();
            } catch (Throwable unused) {
                Log.e("FlutterView", "onConfigurationChanged error ");
            }
        }
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, editorInfo)) == null) {
            if (!isAttachedToFlutterEngine()) {
                return super.onCreateInputConnection(editorInfo);
            }
            return this.textInputPlugin.createInputConnection(this, editorInfo);
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            if (isAttachedToFlutterEngine() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
                return true;
            }
            return super.onGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if (!isAttachedToFlutterEngine()) {
                return super.onHoverEvent(motionEvent);
            }
            return this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i2, keyEvent)) == null) {
            if (!isAttachedToFlutterEngine()) {
                return super.onKeyDown(i2, keyEvent);
            }
            this.androidKeyProcessor.onKeyDown(keyEvent);
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i2, keyEvent)) == null) {
            if (!isAttachedToFlutterEngine()) {
                return super.onKeyUp(i2, keyEvent);
            }
            this.androidKeyProcessor.onKeyUp(keyEvent);
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048594, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            Log.v("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i4 + " x " + i5 + ", it is now " + i2 + " x " + i3);
            FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
            viewportMetrics.width = i2;
            viewportMetrics.height = i3;
            sendViewportMetricsToFlutter(2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                requestUnbufferedDispatch(motionEvent);
            }
            AndroidTouchProcessor androidTouchProcessor = this.androidTouchProcessor;
            if (androidTouchProcessor == null) {
                return super.onTouchEvent(motionEvent);
            }
            return androidTouchProcessor.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void release() {
        XTextInputPlugin xTextInputPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (xTextInputPlugin = this.textInputPlugin) == null) {
            return;
        }
        xTextInputPlugin.release(this);
    }

    @VisibleForTesting
    public void removeFlutterEngineAttachmentListener(@NonNull FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, flutterEngineAttachmentListener) == null) {
            this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
        }
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, flutterUiDisplayListener) == null) {
            this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
        }
    }

    public final void resetWillNotDraw(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
    }

    public final void sendLocalesToFlutter(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, configuration) == null) {
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
    }

    public final void sendUserSettingsToFlutter() {
        FlutterEngine flutterEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (flutterEngine = this.flutterEngine) == null || flutterEngine.getSettingsChannel() == null) {
            return;
        }
        this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).send();
    }

    public final void sendViewportMetricsToFlutter(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
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
    }

    public final void setPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.viewportMetrics.paddingTop = UtilHelper.getStatusBarHeight();
            sendViewportMetricsToFlutter(1);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XFlutterView(@NonNull Context context, @NonNull FlutterView.RenderMode renderMode) {
        this(context, null, renderMode, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, renderMode};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterView.RenderMode) objArr2[2], (FlutterView.TransparencyMode) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XFlutterView(@NonNull Context context, @NonNull FlutterView.TransparencyMode transparencyMode) {
        this(context, null, FlutterView.RenderMode.surface, transparencyMode);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transparencyMode};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterView.RenderMode) objArr2[2], (FlutterView.TransparencyMode) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XFlutterView(@NonNull Context context, @NonNull FlutterView.RenderMode renderMode, @NonNull FlutterView.TransparencyMode transparencyMode) {
        this(context, null, renderMode, transparencyMode);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, renderMode, transparencyMode};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterView.RenderMode) objArr2[2], (FlutterView.TransparencyMode) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XFlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterView.RenderMode) objArr2[2], (FlutterView.TransparencyMode) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XFlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @Nullable FlutterView.RenderMode renderMode, @Nullable FlutterView.TransparencyMode transparencyMode) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, renderMode, transparencyMode};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener(this) { // from class: com.idlefish.flutterboost.XFlutterView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XFlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    this.this$0.resetWillNotDraw(z, z2);
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: com.idlefish.flutterboost.XFlutterView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XFlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.isFlutterUiDisplayed = true;
                    for (FlutterUiDisplayListener flutterUiDisplayListener : this.this$0.flutterUiDisplayListeners) {
                        flutterUiDisplayListener.onFlutterUiDisplayed();
                    }
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.isFlutterUiDisplayed = false;
                    for (FlutterUiDisplayListener flutterUiDisplayListener : this.this$0.flutterUiDisplayListeners) {
                        flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                    }
                }
            }
        };
        this.renderMode = renderMode == null ? FlutterView.RenderMode.surface : renderMode;
        this.transparencyMode = transparencyMode == null ? FlutterView.TransparencyMode.opaque : transparencyMode;
        init();
    }
}
