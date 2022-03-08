package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.view.AccessibilityBridge;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterView";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AccessibilityBridge accessibilityBridge;
    @Nullable
    public AndroidTouchProcessor androidTouchProcessor;
    @Nullable
    public FlutterEngine flutterEngine;
    @NonNull
    public final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    @Nullable
    public FlutterImageView flutterImageView;
    @Nullable
    public FlutterSurfaceView flutterSurfaceView;
    @Nullable
    public FlutterTextureView flutterTextureView;
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    public boolean isFlutterUiDisplayed;
    @Nullable
    public KeyboardManager keyboardManager;
    @Nullable
    public LocalizationPlugin localizationPlugin;
    @Nullable
    public MouseCursorPlugin mouseCursorPlugin;
    public final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    @Nullable
    public RenderSurface previousRenderSurface;
    @Nullable
    public RenderSurface renderSurface;
    @Nullable
    public TextInputPlugin textInputPlugin;
    public final FlutterRenderer.ViewportMetrics viewportMetrics;

    @VisibleForTesting
    /* loaded from: classes8.dex */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Deprecated
    /* loaded from: classes8.dex */
    public static final class RenderMode {
        public static final /* synthetic */ RenderMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RenderMode image;
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
            texture = new RenderMode("texture", 1);
            RenderMode renderMode = new RenderMode("image", 2);
            image = renderMode;
            $VALUES = new RenderMode[]{surface, texture, renderMode};
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
    /* loaded from: classes8.dex */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class ZeroSides {
        public static final /* synthetic */ ZeroSides[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ZeroSides BOTH;
        public static final ZeroSides LEFT;
        public static final ZeroSides NONE;
        public static final ZeroSides RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1759645266, "Lio/flutter/embedding/android/FlutterView$ZeroSides;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1759645266, "Lio/flutter/embedding/android/FlutterView$ZeroSides;");
                    return;
                }
            }
            NONE = new ZeroSides("NONE", 0);
            LEFT = new ZeroSides("LEFT", 1);
            RIGHT = new ZeroSides("RIGHT", 2);
            ZeroSides zeroSides = new ZeroSides("BOTH", 3);
            BOTH = zeroSides;
            $VALUES = new ZeroSides[]{NONE, LEFT, RIGHT, zeroSides};
        }

        public ZeroSides(String str, int i2) {
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

        public static ZeroSides valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ZeroSides) Enum.valueOf(ZeroSides.class, str) : (ZeroSides) invokeL.objValue;
        }

        public static ZeroSides[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ZeroSides[]) $VALUES.clone() : (ZeroSides[]) invokeV.objValue;
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

    private ZeroSides calculateShouldZeroSides() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            Context context = getContext();
            int i2 = context.getResources().getConfiguration().orientation;
            int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            if (i2 == 2) {
                if (rotation == 1) {
                    return ZeroSides.RIGHT;
                }
                if (rotation == 3) {
                    return Build.VERSION.SDK_INT >= 23 ? ZeroSides.LEFT : ZeroSides.RIGHT;
                } else if (rotation == 0 || rotation == 2) {
                    return ZeroSides.BOTH;
                }
            }
            return ZeroSides.NONE;
        }
        return (ZeroSides) invokeV.objValue;
    }

    @SuppressLint({"PrivateApi"})
    private View findViewByAccessibilityIdRootedAtCurrentView(int i2, View view) {
        InterceptResult invokeIL;
        int i3;
        Method declaredMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65553, this, i2, view)) == null) {
            try {
                i3 = 0;
                declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
                declaredMethod.setAccessible(true);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            if (declaredMethod.invoke(view, new Object[0]).equals(Integer.valueOf(i2))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i3 >= viewGroup.getChildCount()) {
                        break;
                    }
                    View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i2, viewGroup.getChildAt(i3));
                    if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                        return findViewByAccessibilityIdRootedAtCurrentView;
                    }
                    i3++;
                }
            }
            return null;
        }
        return (View) invokeIL.objValue;
    }

    @RequiresApi(20)
    @TargetApi(20)
    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, windowInsets)) == null) {
            if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
                return 0;
            }
            return windowInsets.getSystemWindowInsetBottom();
        }
        return invokeL.intValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            Log.v("FlutterView", "Initializing FlutterView");
            if (this.flutterSurfaceView != null) {
                Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
                addView(this.flutterSurfaceView);
            } else if (this.flutterTextureView != null) {
                Log.v("FlutterView", "Internally using a FlutterTextureView.");
                addView(this.flutterTextureView);
            } else {
                Log.v("FlutterView", "Internally using a FlutterImageView.");
                addView(this.flutterImageView);
            }
            setFocusable(true);
            setFocusableInTouchMode(true);
            if (Build.VERSION.SDK_INT >= 26) {
                setImportantForAutofill(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWillNotDraw(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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

    private void sendViewportMetricsToFlutter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (!isAttachedToFlutterEngine()) {
                Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
                return;
            }
            this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
            this.viewportMetrics.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
        }
    }

    public boolean acquireLatestImageViewFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FlutterImageView flutterImageView = this.flutterImageView;
            if (flutterImageView != null) {
                return flutterImageView.acquireLatestImage();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @VisibleForTesting
    public void addFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterEngineAttachmentListener) == null) {
            this.flutterEngineAttachmentListeners.add(flutterEngineAttachmentListener);
        }
    }

    public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flutterUiDisplayListener) == null) {
            this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
        }
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, flutterImageView) == null) || (flutterEngine = this.flutterEngine) == null) {
            return;
        }
        flutterImageView.attachToRenderer(flutterEngine.getRenderer());
    }

    public void attachToFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, flutterEngine) == null) {
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
            if (Build.VERSION.SDK_INT >= 24) {
                this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
            }
            this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
            this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
            this.keyboardManager = new KeyboardManager(this, this.textInputPlugin, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
            this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
            AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
            this.accessibilityBridge = accessibilityBridge;
            accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
            resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
            this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
            this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
            this.textInputPlugin.getInputMethodManager().restartInput(this);
            sendUserSettingsToFlutter();
            this.localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
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
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sparseArray) == null) {
            this.textInputPlugin.autofill(sparseArray);
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            FlutterEngine flutterEngine = this.flutterEngine;
            if (flutterEngine != null) {
                return flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view);
            }
            return super.checkInputConnectionProxy(view);
        }
        return invokeL.booleanValue;
    }

    public void convertToImageView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.renderSurface.pause();
            FlutterImageView flutterImageView = this.flutterImageView;
            if (flutterImageView == null) {
                FlutterImageView createImageView = createImageView();
                this.flutterImageView = createImageView;
                addView(createImageView);
            } else {
                flutterImageView.resizeIfNeeded(getWidth(), getHeight());
            }
            this.previousRenderSurface = this.renderSurface;
            FlutterImageView flutterImageView2 = this.flutterImageView;
            this.renderSurface = flutterImageView2;
            FlutterEngine flutterEngine = this.flutterEngine;
            if (flutterEngine != null) {
                flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
            }
        }
    }

    @NonNull
    @VisibleForTesting
    public FlutterImageView createImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background) : (FlutterImageView) invokeV.objValue;
    }

    public void detachFromFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Log.v("FlutterView", "Detaching from a FlutterEngine: " + this.flutterEngine);
            if (!isAttachedToFlutterEngine()) {
                Log.v("FlutterView", "FlutterView not attached to an engine. Not detaching.");
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
            this.keyboardManager.destroy();
            MouseCursorPlugin mouseCursorPlugin = this.mouseCursorPlugin;
            if (mouseCursorPlugin != null) {
                mouseCursorPlugin.destroy();
            }
            FlutterRenderer renderer = this.flutterEngine.getRenderer();
            this.isFlutterUiDisplayed = false;
            renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
            renderer.stopRenderingToSurface();
            renderer.setSemanticsEnabled(false);
            this.renderSurface.detachFromRenderer();
            this.flutterImageView = null;
            this.previousRenderSurface = null;
            this.flutterEngine = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                getKeyDispatcherState().startTracking(keyEvent, this);
            } else if (keyEvent.getAction() == 1) {
                getKeyDispatcherState().handleUpEvent(keyEvent);
            }
            return (isAttachedToFlutterEngine() && this.keyboardManager.handleEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public View findViewByAccessibilityIdTraversal(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(i2, this);
            }
            try {
                Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                return (View) declaredMethod.invoke(this, Integer.valueOf(i2));
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        return (View) invokeI.objValue;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rect)) == null) {
            if (Build.VERSION.SDK_INT <= 19) {
                FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
                viewportMetrics.viewPaddingTop = rect.top;
                viewportMetrics.viewPaddingRight = rect.right;
                viewportMetrics.viewPaddingBottom = 0;
                viewportMetrics.viewPaddingLeft = rect.left;
                viewportMetrics.viewInsetTop = 0;
                viewportMetrics.viewInsetRight = 0;
                viewportMetrics.viewInsetBottom = rect.bottom;
                viewportMetrics.viewInsetLeft = 0;
                Log.v("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.flutterEngine : (FlutterEngine) invokeV.objValue;
    }

    @Override // io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate
    @NonNull
    @RequiresApi(24)
    @TargetApi(24)
    public PointerIcon getSystemPointerIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? PointerIcon.getSystemIcon(getContext(), i2) : (PointerIcon) invokeI.objValue;
    }

    public boolean hasRenderedFirstFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.isFlutterUiDisplayed : invokeV.booleanValue;
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, windowInsets)) == null) {
            WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
            if (Build.VERSION.SDK_INT == 29) {
                Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
                viewportMetrics.systemGestureInsetTop = systemGestureInsets.top;
                viewportMetrics.systemGestureInsetRight = systemGestureInsets.right;
                viewportMetrics.systemGestureInsetBottom = systemGestureInsets.bottom;
                viewportMetrics.systemGestureInsetLeft = systemGestureInsets.left;
            }
            boolean z = (getWindowSystemUiVisibility() & 4) == 0;
            boolean z2 = (getWindowSystemUiVisibility() & 2) == 0;
            if (Build.VERSION.SDK_INT >= 30) {
                int navigationBars = z2 ? 0 | WindowInsets.Type.navigationBars() : 0;
                if (z) {
                    navigationBars |= WindowInsets.Type.statusBars();
                }
                Insets insets = windowInsets.getInsets(navigationBars);
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
                viewportMetrics2.viewPaddingTop = insets.top;
                viewportMetrics2.viewPaddingRight = insets.right;
                viewportMetrics2.viewPaddingBottom = insets.bottom;
                viewportMetrics2.viewPaddingLeft = insets.left;
                Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
                viewportMetrics3.viewInsetTop = insets2.top;
                viewportMetrics3.viewInsetRight = insets2.right;
                viewportMetrics3.viewInsetBottom = insets2.bottom;
                viewportMetrics3.viewInsetLeft = insets2.left;
                Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.viewportMetrics;
                viewportMetrics4.systemGestureInsetTop = insets3.top;
                viewportMetrics4.systemGestureInsetRight = insets3.right;
                viewportMetrics4.systemGestureInsetBottom = insets3.bottom;
                viewportMetrics4.systemGestureInsetLeft = insets3.left;
                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                if (displayCutout != null) {
                    Insets waterfallInsets = displayCutout.getWaterfallInsets();
                    FlutterRenderer.ViewportMetrics viewportMetrics5 = this.viewportMetrics;
                    viewportMetrics5.viewPaddingTop = Math.max(Math.max(viewportMetrics5.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                    FlutterRenderer.ViewportMetrics viewportMetrics6 = this.viewportMetrics;
                    viewportMetrics6.viewPaddingRight = Math.max(Math.max(viewportMetrics6.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                    FlutterRenderer.ViewportMetrics viewportMetrics7 = this.viewportMetrics;
                    viewportMetrics7.viewPaddingBottom = Math.max(Math.max(viewportMetrics7.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                    FlutterRenderer.ViewportMetrics viewportMetrics8 = this.viewportMetrics;
                    viewportMetrics8.viewPaddingLeft = Math.max(Math.max(viewportMetrics8.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
                }
            } else {
                ZeroSides zeroSides = ZeroSides.NONE;
                if (!z2) {
                    zeroSides = calculateShouldZeroSides();
                }
                this.viewportMetrics.viewPaddingTop = z ? windowInsets.getSystemWindowInsetTop() : 0;
                this.viewportMetrics.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
                this.viewportMetrics.viewPaddingBottom = (z2 && guessBottomKeyboardInset(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
                this.viewportMetrics.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
                FlutterRenderer.ViewportMetrics viewportMetrics9 = this.viewportMetrics;
                viewportMetrics9.viewInsetTop = 0;
                viewportMetrics9.viewInsetRight = 0;
                viewportMetrics9.viewInsetBottom = guessBottomKeyboardInset(windowInsets);
                this.viewportMetrics.viewInsetLeft = 0;
            }
            Log.v("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
            sendViewportMetricsToFlutter();
            return onApplyWindowInsets;
        }
        return (WindowInsets) invokeL.objValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.flutterEngine != null) {
                Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
                this.localizationPlugin.sendLocalesToFlutter(configuration);
                sendUserSettingsToFlutter();
            }
        }
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, editorInfo)) == null) {
            if (!isAttachedToFlutterEngine()) {
                return super.onCreateInputConnection(editorInfo);
            }
            return this.textInputPlugin.createInputConnection(this, this.keyboardManager, editorInfo);
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            if (!isAttachedToFlutterEngine()) {
                return super.onHoverEvent(motionEvent);
            }
            return this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, viewStructure, i2) == null) {
            super.onProvideAutofillVirtualStructure(viewStructure, i2);
            this.textInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048602, this, flutterEngineAttachmentListener) == null) {
            this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
        }
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, flutterUiDisplayListener) == null) {
            this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
        }
    }

    public void revertImageView(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, runnable) == null) {
            FlutterImageView flutterImageView = this.flutterImageView;
            if (flutterImageView == null) {
                Log.v("FlutterView", "Tried to revert the image view, but no image view is used.");
                return;
            }
            RenderSurface renderSurface = this.previousRenderSurface;
            if (renderSurface == null) {
                Log.v("FlutterView", "Tried to revert the image view, but no previous surface was used.");
                return;
            }
            this.renderSurface = renderSurface;
            this.previousRenderSurface = null;
            FlutterEngine flutterEngine = this.flutterEngine;
            if (flutterEngine == null) {
                flutterImageView.detachFromRenderer();
                runnable.run();
                return;
            }
            FlutterRenderer renderer = flutterEngine.getRenderer();
            if (renderer == null) {
                this.flutterImageView.detachFromRenderer();
                runnable.run();
                return;
            }
            this.renderSurface.attachToRenderer(renderer);
            renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener(this, renderer, runnable) { // from class: io.flutter.embedding.android.FlutterView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterView this$0;
                public final /* synthetic */ Runnable val$onDone;
                public final /* synthetic */ FlutterRenderer val$renderer;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, renderer, runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$renderer = renderer;
                    this.val$onDone = runnable;
                }

                @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
                public void onFlutterUiDisplayed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$renderer.removeIsDisplayingFlutterUiListener(this);
                        this.val$onDone.run();
                        if (this.this$0.renderSurface instanceof FlutterImageView) {
                            return;
                        }
                        this.this$0.flutterImageView.detachFromRenderer();
                    }
                }

                @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
                public void onFlutterUiNoLongerDisplayed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            });
        }
    }

    @VisibleForTesting
    public void sendUserSettingsToFlutter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
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
            interceptable.invokeUnInit(65544, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
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
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
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
            interceptable.invokeUnInit(65546, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterSurfaceView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65546, newInitContext);
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
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterSurfaceView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
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
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterTextureView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @TargetApi(19)
    public FlutterView(@NonNull Context context, @NonNull FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterImageView};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterImageView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
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
            interceptable.invokeUnInit(65545, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65545, newInitContext);
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
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
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
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
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
        this.renderSurface = flutterTextureView;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(19)
    public FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterImageView flutterImageView) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, flutterImageView};
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
        this.flutterImageView = flutterImageView;
        this.renderSurface = flutterImageView;
        init();
    }
}
