package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
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
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class FlutterView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterView";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AccessibilityBridge accessibilityBridge;
    @Nullable
    public AndroidKeyProcessor androidKeyProcessor;
    @Nullable
    public AndroidTouchProcessor androidTouchProcessor;
    @Nullable
    public FlutterEngine flutterEngine;
    @NonNull
    public final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    @Nullable
    public FlutterSurfaceView flutterSurfaceView;
    @Nullable
    public FlutterTextureView flutterTextureView;
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    public boolean isFlutterUiDisplayed;
    public final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    @Nullable
    public RenderSurface renderSurface;
    @Nullable
    public TextInputPlugin textInputPlugin;
    public final FlutterRenderer.ViewportMetrics viewportMetrics;

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Deprecated
    /* loaded from: classes10.dex */
    public static final class RenderMode {
        public static final /* synthetic */ RenderMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RenderMode surface;
        public static final RenderMode texture;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(180846743, "Lio/flutter/embedding/android/FlutterView$RenderMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(180846743, "Lio/flutter/embedding/android/FlutterView$RenderMode;");
                    return;
                }
            }
            surface = new RenderMode("surface", 0);
            RenderMode renderMode = new RenderMode("texture", 1);
            texture = renderMode;
            $VALUES = new RenderMode[]{surface, renderMode};
        }

        public RenderMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RenderMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RenderMode) Enum.valueOf(RenderMode.class, str) : (RenderMode) invokeL.objValue;
        }

        public static RenderMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RenderMode[]) $VALUES.clone() : (RenderMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Deprecated
    /* loaded from: classes10.dex */
    public static final class TransparencyMode {
        public static final /* synthetic */ TransparencyMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TransparencyMode opaque;
        public static final TransparencyMode transparent;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(264961109, "Lio/flutter/embedding/android/FlutterView$TransparencyMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(264961109, "Lio/flutter/embedding/android/FlutterView$TransparencyMode;");
                    return;
                }
            }
            opaque = new TransparencyMode("opaque", 0);
            TransparencyMode transparencyMode = new TransparencyMode(OpenFlutter.EXTRA_TRANSPARANT, 1);
            transparent = transparencyMode;
            $VALUES = new TransparencyMode[]{opaque, transparencyMode};
        }

        public TransparencyMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TransparencyMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TransparencyMode) Enum.valueOf(TransparencyMode.class, str) : (TransparencyMode) invokeL.objValue;
        }

        public static TransparencyMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TransparencyMode[]) $VALUES.clone() : (TransparencyMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterView(@NonNull Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterSurfaceView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Log.v("FlutterView", "Initializing FlutterView");
            if (this.flutterSurfaceView != null) {
                Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
                addView(this.flutterSurfaceView);
            } else {
                Log.v("FlutterView", "Internally using a FlutterTextureView.");
                addView(this.flutterTextureView);
            }
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWillNotDraw(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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

    private void sendLocalesToFlutter(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, configuration) == null) {
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
            this.flutterEngine.getLocalizationChannel().sendLocales(arrayList);
        }
    }

    private void sendViewportMetricsToFlutter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (!isAttachedToFlutterEngine()) {
                Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
                return;
            }
            this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
            this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
        }
    }

    @VisibleForTesting
    public void addFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
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
            Log.v("FlutterView", "Attaching to a FlutterEngine: " + flutterEngine);
            if (isAttachedToFlutterEngine()) {
                if (flutterEngine == this.flutterEngine) {
                    Log.v("FlutterView", "Already attached to this engine. Doing nothing.");
                    return;
                } else {
                    Log.v("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                    detachFromFlutterEngine();
                }
            }
            this.flutterEngine = flutterEngine;
            FlutterRenderer renderer = flutterEngine.getRenderer();
            this.isFlutterUiDisplayed = renderer.isDisplayingFlutterUi();
            this.renderSurface.attachToRenderer(renderer);
            renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
            this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getDartExecutor(), this.flutterEngine.getPlatformViewsController());
            this.androidKeyProcessor = new AndroidKeyProcessor(this.flutterEngine.getKeyEventChannel(), this.textInputPlugin);
            this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer());
            AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
            this.accessibilityBridge = accessibilityBridge;
            accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
            resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
            this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
            this.textInputPlugin.getInputMethodManager().restartInput(this);
            sendUserSettingsToFlutter();
            sendLocalesToFlutter(getResources().getConfiguration());
            sendViewportMetricsToFlutter();
            flutterEngine.getPlatformViewsController().attachToView(this);
            for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
                flutterEngineAttachmentListener.onFlutterEngineAttachedToFlutterView(flutterEngine);
            }
            if (this.isFlutterUiDisplayed) {
                this.flutterUiDisplayListener.onFlutterUiDisplayed();
            }
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            FlutterEngine flutterEngine = this.flutterEngine;
            if (flutterEngine != null) {
                return flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view);
            }
            return super.checkInputConnectionProxy(view);
        }
        return invokeL.booleanValue;
    }

    public void detachFromFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Log.v("FlutterView", "Detaching from a FlutterEngine: " + this.flutterEngine);
            if (!isAttachedToFlutterEngine()) {
                Log.v("FlutterView", "Not attached to an engine. Doing nothing.");
                return;
            }
            for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
                flutterEngineAttachmentListener.onFlutterEngineDetachedFromFlutterView();
            }
            this.flutterEngine.getPlatformViewsController().detachFromView();
            this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
            this.accessibilityBridge.release();
            this.accessibilityBridge = null;
            this.textInputPlugin.getInputMethodManager().restartInput(this);
            this.textInputPlugin.destroy();
            FlutterRenderer renderer = this.flutterEngine.getRenderer();
            this.isFlutterUiDisplayed = false;
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
                Log.v("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
                sendViewportMetricsToFlutter();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isFlutterUiDisplayed : invokeV.booleanValue;
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FlutterEngine flutterEngine = this.flutterEngine;
            return flutterEngine != null && flutterEngine.getRenderer() == this.renderSurface.getAttachedRenderer();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    @NonNull
    @SuppressLint({"InlinedApi", "NewApi"})
    @RequiresApi(20)
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, windowInsets)) == null) {
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
            if (Build.VERSION.SDK_INT >= 29) {
                Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
                this.viewportMetrics.systemGestureInsetTop = systemGestureInsets.top;
                this.viewportMetrics.systemGestureInsetRight = systemGestureInsets.right;
                this.viewportMetrics.systemGestureInsetBottom = systemGestureInsets.bottom;
                this.viewportMetrics.systemGestureInsetLeft = systemGestureInsets.left;
            }
            Log.v("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
            sendViewportMetricsToFlutter();
            return onApplyWindowInsets;
        }
        return (WindowInsets) invokeL.objValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.flutterEngine != null) {
                Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
                sendLocalesToFlutter(configuration);
                sendUserSettingsToFlutter();
            }
        }
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, editorInfo)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeIIII(1048593, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            Log.v("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i4 + " x " + i5 + ", it is now " + i2 + " x " + i3);
            FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
            viewportMetrics.width = i2;
            viewportMetrics.height = i3;
            sendViewportMetricsToFlutter();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            if (!isAttachedToFlutterEngine()) {
                return super.onTouchEvent(motionEvent);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                requestUnbufferedDispatch(motionEvent);
            }
            return this.androidTouchProcessor.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    public void removeFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, flutterEngineAttachmentListener) == null) {
            this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
        }
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, flutterUiDisplayListener) == null) {
            this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
        }
    }

    @VisibleForTesting
    public void sendUserSettingsToFlutter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, renderMode};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener(this) { // from class: io.flutter.embedding.android.FlutterView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

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
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.embedding.android.FlutterView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

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
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.flutterSurfaceView = flutterSurfaceView;
            this.renderSurface = flutterSurfaceView;
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        }
        init();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transparencyMode};
            interceptable.invokeUnInit(65544, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterSurfaceView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterView(@NonNull Context context, @NonNull FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterSurfaceView};
            interceptable.invokeUnInit(65540, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterSurfaceView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65540, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterView(@NonNull Context context, @NonNull FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterTextureView};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterTextureView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterSurfaceView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode, @NonNull TransparencyMode transparencyMode) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, renderMode, transparencyMode};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener(this) { // from class: io.flutter.embedding.android.FlutterView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.embedding.android.FlutterView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent);
            this.flutterSurfaceView = flutterSurfaceView;
            this.renderSurface = flutterSurfaceView;
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        }
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, flutterSurfaceView};
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
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener(this) { // from class: io.flutter.embedding.android.FlutterView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.embedding.android.FlutterView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
        this.flutterSurfaceView = flutterSurfaceView;
        this.renderSurface = flutterSurfaceView;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, flutterTextureView};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener(this) { // from class: io.flutter.embedding.android.FlutterView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.embedding.android.FlutterView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
        this.flutterTextureView = flutterTextureView;
        this.renderSurface = this.flutterSurfaceView;
        init();
    }
}
