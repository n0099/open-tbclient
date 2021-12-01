package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.KeyChannelResponder;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Deprecated
/* loaded from: classes3.dex */
public class FlutterView extends SurfaceView implements BinaryMessenger, TextureRegistry, MouseCursorPlugin.MouseCursorViewDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterView";
    public transient /* synthetic */ FieldHolder $fh;
    public final AndroidTouchProcessor androidTouchProcessor;
    public final DartExecutor dartExecutor;
    public boolean didRenderFirstFrame;
    public final FlutterRenderer flutterRenderer;
    public final KeyEventChannel keyEventChannel;
    public final LifecycleChannel lifecycleChannel;
    public final LocalizationChannel localizationChannel;
    public AccessibilityBridge mAccessibilityNodeProvider;
    public final List<ActivityLifecycleListener> mActivityLifecycleListeners;
    public final List<FirstFrameListener> mFirstFrameListeners;
    public final InputMethodManager mImm;
    public boolean mIsSoftwareRenderingEnabled;
    public final KeyboardManager mKeyboardManager;
    public final LocalizationPlugin mLocalizationPlugin;
    public final ViewportMetrics mMetrics;
    public final MouseCursorPlugin mMouseCursorPlugin;
    public FlutterNativeView mNativeView;
    public final SurfaceHolder.Callback mSurfaceCallback;
    public final TextInputPlugin mTextInputPlugin;
    public final NavigationChannel navigationChannel;
    public final AtomicLong nextTextureId;
    public final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    public final PlatformChannel platformChannel;
    public final SettingsChannel settingsChannel;
    public final SystemChannel systemChannel;

    /* loaded from: classes3.dex */
    public interface FirstFrameListener {
        void onFirstFrame();
    }

    /* loaded from: classes3.dex */
    public interface Provider {
        FlutterView getFlutterView();
    }

    /* loaded from: classes3.dex */
    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long id;
        public SurfaceTexture.OnFrameAvailableListener onFrameListener;
        public boolean released;
        public final SurfaceTextureWrapper textureWrapper;
        public final /* synthetic */ FlutterView this$0;

        public SurfaceTextureRegistryEntry(FlutterView flutterView, long j2, SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterView, Long.valueOf(j2), surfaceTexture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterView;
            this.onFrameListener = new SurfaceTexture.OnFrameAvailableListener(this) { // from class: io.flutter.view.FlutterView.SurfaceTextureRegistryEntry.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SurfaceTextureRegistryEntry this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceTexture2) == null) || this.this$1.released || this.this$1.this$0.mNativeView == null) {
                        return;
                    }
                    this.this$1.this$0.mNativeView.getFlutterJNI().markTextureFrameAvailable(this.this$1.id);
                }
            };
            this.id = j2;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture);
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.longValue;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.released) {
                return;
            }
            this.released = true;
            surfaceTexture().setOnFrameAvailableListener(null);
            this.textureWrapper.release();
            this.this$0.mNativeView.getFlutterJNI().unregisterTexture(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.textureWrapper.surfaceTexture() : (SurfaceTexture) invokeV.objValue;
        }

        public SurfaceTextureWrapper textureWrapper() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.textureWrapper : (SurfaceTextureWrapper) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ViewportMetrics {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float devicePixelRatio;
        public int physicalHeight;
        public int physicalTouchSlop;
        public int physicalViewInsetBottom;
        public int physicalViewInsetLeft;
        public int physicalViewInsetRight;
        public int physicalViewInsetTop;
        public int physicalViewPaddingBottom;
        public int physicalViewPaddingLeft;
        public int physicalViewPaddingRight;
        public int physicalViewPaddingTop;
        public int physicalWidth;
        public int systemGestureInsetBottom;
        public int systemGestureInsetLeft;
        public int systemGestureInsetRight;
        public int systemGestureInsetTop;

        public ViewportMetrics() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.devicePixelRatio = 1.0f;
            this.physicalWidth = 0;
            this.physicalHeight = 0;
            this.physicalViewPaddingTop = 0;
            this.physicalViewPaddingRight = 0;
            this.physicalViewPaddingBottom = 0;
            this.physicalViewPaddingLeft = 0;
            this.physicalViewInsetTop = 0;
            this.physicalViewInsetRight = 0;
            this.physicalViewInsetBottom = 0;
            this.physicalViewInsetLeft = 0;
            this.systemGestureInsetTop = 0;
            this.systemGestureInsetRight = 0;
            this.systemGestureInsetBottom = 0;
            this.systemGestureInsetLeft = 0;
            this.physicalTouchSlop = -1;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-89207676, "Lio/flutter/view/FlutterView$ZeroSides;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-89207676, "Lio/flutter/view/FlutterView$ZeroSides;");
                    return;
                }
            }
            NONE = new ZeroSides(PolyActivity.NONE_PANEL_TYPE, 0);
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
    public FlutterView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private ZeroSides calculateShouldZeroSides() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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

    @RequiresApi(20)
    @TargetApi(20)
    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, windowInsets)) == null) {
            if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
                return 0;
            }
            return windowInsets.getSystemWindowInsetBottom();
        }
        return invokeL.intValue;
    }

    private boolean isAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            FlutterNativeView flutterNativeView = this.mNativeView;
            return flutterNativeView != null && flutterNativeView.isAttached();
        }
        return invokeV.booleanValue;
    }

    private void postRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
        }
    }

    private void preRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            resetAccessibilityTree();
        }
    }

    private void releaseAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (accessibilityBridge = this.mAccessibilityNodeProvider) == null) {
            return;
        }
        accessibilityBridge.release();
        this.mAccessibilityNodeProvider = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWillNotDraw(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = false;
            if (!this.mIsSoftwareRenderingEnabled) {
                if (!z && !z2) {
                    z3 = true;
                }
                setWillNotDraw(z3);
                return;
            }
            setWillNotDraw(false);
        }
    }

    private void sendUserPlatformSettingsToDart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
        }
    }

    private void updateViewportMetrics() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && isAttached()) {
            FlutterJNI flutterJNI = this.mNativeView.getFlutterJNI();
            ViewportMetrics viewportMetrics = this.mMetrics;
            flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.physicalWidth, viewportMetrics.physicalHeight, viewportMetrics.physicalViewPaddingTop, viewportMetrics.physicalViewPaddingRight, viewportMetrics.physicalViewPaddingBottom, viewportMetrics.physicalViewPaddingLeft, viewportMetrics.physicalViewInsetTop, viewportMetrics.physicalViewInsetRight, viewportMetrics.physicalViewInsetBottom, viewportMetrics.physicalViewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft, viewportMetrics.physicalTouchSlop);
        }
    }

    public void addActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activityLifecycleListener) == null) {
            this.mActivityLifecycleListeners.add(activityLifecycleListener);
        }
    }

    public void addFirstFrameListener(FirstFrameListener firstFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, firstFrameListener) == null) {
            this.mFirstFrameListeners.add(firstFrameListener);
        }
    }

    public void assertAttached() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sparseArray) == null) {
            this.mTextInputPlugin.autofill(sparseArray);
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) ? this.mNativeView.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(view) : invokeL.booleanValue;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            surfaceTexture.detachFromGLContext();
            SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this, this.nextTextureId.getAndIncrement(), surfaceTexture);
            this.mNativeView.getFlutterJNI().registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
            return surfaceTextureRegistryEntry;
        }
        return (TextureRegistry.SurfaceTextureEntry) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && isAttached()) {
            getHolder().removeCallback(this.mSurfaceCallback);
            releaseAccessibilityNodeProvider();
            this.mNativeView.destroy();
            this.mNativeView = null;
        }
    }

    public FlutterNativeView detach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (isAttached()) {
                getHolder().removeCallback(this.mSurfaceCallback);
                this.mNativeView.detachFromFlutterView();
                FlutterNativeView flutterNativeView = this.mNativeView;
                this.mNativeView = null;
                return flutterNativeView;
            }
            return null;
        }
        return (FlutterNativeView) invokeV.objValue;
    }

    public void disableTransparentBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setZOrderOnTop(false);
            getHolder().setFormat(-1);
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, keyEvent)) == null) {
            Log.e("FlutterView", "dispatchKeyEvent: " + keyEvent.toString());
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                getKeyDispatcherState().startTracking(keyEvent, this);
            } else if (keyEvent.getAction() == 1) {
                getKeyDispatcherState().handleUpEvent(keyEvent);
            }
            return (isAttached() && this.mKeyboardManager.handleEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public void enableTransparentBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Log.w("FlutterView", "FlutterView in the v1 embedding is always a SurfaceView and will cover accessibility highlights when transparent. Consider migrating to the v2 Android embedding. https://github.com/flutter/flutter/wiki/Upgrading-pre-1.12-Android-projects");
            setZOrderOnTop(true);
            getHolder().setFormat(-2);
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, rect)) == null) {
            if (Build.VERSION.SDK_INT <= 19) {
                ViewportMetrics viewportMetrics = this.mMetrics;
                viewportMetrics.physicalViewPaddingTop = rect.top;
                viewportMetrics.physicalViewPaddingRight = rect.right;
                viewportMetrics.physicalViewPaddingBottom = 0;
                viewportMetrics.physicalViewPaddingLeft = rect.left;
                viewportMetrics.physicalViewInsetTop = 0;
                viewportMetrics.physicalViewInsetRight = 0;
                viewportMetrics.physicalViewInsetBottom = rect.bottom;
                viewportMetrics.physicalViewInsetLeft = 0;
                updateViewportMetrics();
                return true;
            }
            return super.fitSystemWindows(rect);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
            if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
                return null;
            }
            return this.mAccessibilityNodeProvider;
        }
        return (AccessibilityNodeProvider) invokeV.objValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            assertAttached();
            return this.mNativeView.getFlutterJNI().getBitmap();
        }
        return (Bitmap) invokeV.objValue;
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.dartExecutor : (DartExecutor) invokeV.objValue;
    }

    public float getDevicePixelRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mMetrics.devicePixelRatio : invokeV.floatValue;
    }

    public FlutterNativeView getFlutterNativeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mNativeView : (FlutterNativeView) invokeV.objValue;
    }

    public String getLookupKeyForAsset(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? FlutterMain.getLookupKeyForAsset(str) : (String) invokeL.objValue;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mNativeView.getPluginRegistry() : (FlutterPluginRegistry) invokeV.objValue;
    }

    @Override // io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate
    @NonNull
    @RequiresApi(24)
    @TargetApi(24)
    public PointerIcon getSystemPointerIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? PointerIcon.getSystemIcon(getContext(), i2) : (PointerIcon) invokeI.objValue;
    }

    public boolean hasRenderedFirstFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.didRenderFirstFrame : invokeV.booleanValue;
    }

    @Override // android.view.View
    @RequiresApi(20)
    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, windowInsets)) == null) {
            if (Build.VERSION.SDK_INT == 29) {
                Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
                ViewportMetrics viewportMetrics = this.mMetrics;
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
                ViewportMetrics viewportMetrics2 = this.mMetrics;
                viewportMetrics2.physicalViewPaddingTop = insets.top;
                viewportMetrics2.physicalViewPaddingRight = insets.right;
                viewportMetrics2.physicalViewPaddingBottom = insets.bottom;
                viewportMetrics2.physicalViewPaddingLeft = insets.left;
                Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
                ViewportMetrics viewportMetrics3 = this.mMetrics;
                viewportMetrics3.physicalViewInsetTop = insets2.top;
                viewportMetrics3.physicalViewInsetRight = insets2.right;
                viewportMetrics3.physicalViewInsetBottom = insets2.bottom;
                viewportMetrics3.physicalViewInsetLeft = insets2.left;
                Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
                ViewportMetrics viewportMetrics4 = this.mMetrics;
                viewportMetrics4.systemGestureInsetTop = insets3.top;
                viewportMetrics4.systemGestureInsetRight = insets3.right;
                viewportMetrics4.systemGestureInsetBottom = insets3.bottom;
                viewportMetrics4.systemGestureInsetLeft = insets3.left;
                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                if (displayCutout != null) {
                    Insets waterfallInsets = displayCutout.getWaterfallInsets();
                    ViewportMetrics viewportMetrics5 = this.mMetrics;
                    viewportMetrics5.physicalViewPaddingTop = Math.max(Math.max(viewportMetrics5.physicalViewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                    ViewportMetrics viewportMetrics6 = this.mMetrics;
                    viewportMetrics6.physicalViewPaddingRight = Math.max(Math.max(viewportMetrics6.physicalViewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                    ViewportMetrics viewportMetrics7 = this.mMetrics;
                    viewportMetrics7.physicalViewPaddingBottom = Math.max(Math.max(viewportMetrics7.physicalViewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                    ViewportMetrics viewportMetrics8 = this.mMetrics;
                    viewportMetrics8.physicalViewPaddingLeft = Math.max(Math.max(viewportMetrics8.physicalViewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
                }
            } else {
                ZeroSides zeroSides = ZeroSides.NONE;
                if (!z2) {
                    zeroSides = calculateShouldZeroSides();
                }
                this.mMetrics.physicalViewPaddingTop = z ? windowInsets.getSystemWindowInsetTop() : 0;
                this.mMetrics.physicalViewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
                this.mMetrics.physicalViewPaddingBottom = (z2 && guessBottomKeyboardInset(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
                this.mMetrics.physicalViewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
                ViewportMetrics viewportMetrics9 = this.mMetrics;
                viewportMetrics9.physicalViewInsetTop = 0;
                viewportMetrics9.physicalViewInsetRight = 0;
                viewportMetrics9.physicalViewInsetBottom = guessBottomKeyboardInset(windowInsets);
                this.mMetrics.physicalViewInsetLeft = 0;
            }
            updateViewportMetrics();
            return super.onApplyWindowInsets(windowInsets);
        }
        return (WindowInsets) invokeL.objValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onAttachedToWindow();
            AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, new AccessibilityChannel(this.dartExecutor, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().getPlatformViewsController());
            this.mAccessibilityNodeProvider = accessibilityBridge;
            accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
            resetWillNotDraw(this.mAccessibilityNodeProvider.isAccessibilityEnabled(), this.mAccessibilityNodeProvider.isTouchExplorationEnabled());
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mLocalizationPlugin.sendLocalesToFlutter(configuration);
            sendUserPlatformSettingsToDart();
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, editorInfo)) == null) ? this.mTextInputPlugin.createInputConnection(this, this.mKeyboardManager, editorInfo) : (InputConnection) invokeL.objValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            releaseAccessibilityNodeProvider();
        }
    }

    public void onFirstFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.didRenderFirstFrame = true;
            for (FirstFrameListener firstFrameListener : new ArrayList(this.mFirstFrameListeners)) {
                firstFrameListener.onFirstFrame();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, motionEvent)) == null) {
            if (isAttached() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
                return true;
            }
            return super.onGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            if (!isAttached()) {
                return super.onHoverEvent(motionEvent);
            }
            return this.mAccessibilityNodeProvider.onAccessibilityHoverEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void onMemoryPressure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.mNativeView.getFlutterJNI().notifyLowMemoryWarning();
            this.systemChannel.sendMemoryPressureWarning();
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.lifecycleChannel.appIsInactive();
        }
    }

    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            for (ActivityLifecycleListener activityLifecycleListener : this.mActivityLifecycleListeners) {
                activityLifecycleListener.onPostResume();
            }
            this.lifecycleChannel.appIsResumed();
        }
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, viewStructure, i2) == null) {
            super.onProvideAutofillVirtualStructure(viewStructure, i2);
            this.mTextInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048610, this, i2, i3, i4, i5) == null) {
            ViewportMetrics viewportMetrics = this.mMetrics;
            viewportMetrics.physicalWidth = i2;
            viewportMetrics.physicalHeight = i3;
            updateViewportMetrics();
            super.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.lifecycleChannel.appIsInactive();
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.lifecycleChannel.appIsPaused();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, motionEvent)) == null) {
            if (!isAttached()) {
                return super.onTouchEvent(motionEvent);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                requestUnbufferedDispatch(motionEvent);
            }
            return this.androidTouchProcessor.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void popRoute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.navigationChannel.popRoute();
        }
    }

    public void pushRoute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.navigationChannel.pushRoute(str);
        }
    }

    public void removeFirstFrameListener(FirstFrameListener firstFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, firstFrameListener) == null) {
            this.mFirstFrameListeners.remove(firstFrameListener);
        }
    }

    public void resetAccessibilityTree() {
        AccessibilityBridge accessibilityBridge;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (accessibilityBridge = this.mAccessibilityNodeProvider) == null) {
            return;
        }
        accessibilityBridge.reset();
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, flutterRunArguments) == null) {
            assertAttached();
            preRun();
            this.mNativeView.runFromBundle(flutterRunArguments);
            postRun();
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void send(String str, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, str, byteBuffer) == null) {
            send(str, byteBuffer, null);
        }
    }

    public void setInitialRoute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.navigationChannel.setInitialRoute(str);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, str, binaryMessageHandler) == null) {
            this.mNativeView.setMessageHandler(str, binaryMessageHandler);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (FlutterNativeView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public String getLookupKeyForAsset(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) ? FlutterMain.getLookupKeyForAsset(str, str2) : (String) invokeLL.objValue;
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048620, this, str, byteBuffer, binaryReply) == null) {
            if (!isAttached()) {
                Log.d("FlutterView", "FlutterView.send called on a detached view, channel=" + str);
                return;
            }
            this.mNativeView.send(str, byteBuffer, binaryReply);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterView(Context context, AttributeSet attributeSet, FlutterNativeView flutterNativeView) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, flutterNativeView};
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
        this.nextTextureId = new AtomicLong(0L);
        this.mIsSoftwareRenderingEnabled = false;
        this.didRenderFirstFrame = false;
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener(this) { // from class: io.flutter.view.FlutterView.1
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
        Activity activity = ViewUtils.getActivity(getContext());
        if (activity != null) {
            if (flutterNativeView == null) {
                this.mNativeView = new FlutterNativeView(activity.getApplicationContext());
            } else {
                this.mNativeView = flutterNativeView;
            }
            this.dartExecutor = this.mNativeView.getDartExecutor();
            this.flutterRenderer = new FlutterRenderer(this.mNativeView.getFlutterJNI());
            this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().getIsSoftwareRenderingEnabled();
            ViewportMetrics viewportMetrics = new ViewportMetrics();
            this.mMetrics = viewportMetrics;
            viewportMetrics.devicePixelRatio = context.getResources().getDisplayMetrics().density;
            this.mMetrics.physicalTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.mNativeView.attachViewAndActivity(this, activity);
            this.mSurfaceCallback = new SurfaceHolder.Callback(this) { // from class: io.flutter.view.FlutterView.2
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

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, surfaceHolder, i4, i5, i6) == null) {
                        this.this$0.assertAttached();
                        this.this$0.mNativeView.getFlutterJNI().onSurfaceChanged(i5, i6);
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                        this.this$0.assertAttached();
                        this.this$0.mNativeView.getFlutterJNI().onSurfaceCreated(surfaceHolder.getSurface());
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                        this.this$0.assertAttached();
                        this.this$0.mNativeView.getFlutterJNI().onSurfaceDestroyed();
                    }
                }
            };
            getHolder().addCallback(this.mSurfaceCallback);
            this.mActivityLifecycleListeners = new ArrayList();
            this.mFirstFrameListeners = new ArrayList();
            this.navigationChannel = new NavigationChannel(this.dartExecutor);
            this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
            this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
            this.localizationChannel = new LocalizationChannel(this.dartExecutor);
            this.platformChannel = new PlatformChannel(this.dartExecutor);
            this.systemChannel = new SystemChannel(this.dartExecutor);
            this.settingsChannel = new SettingsChannel(this.dartExecutor);
            addActivityLifecycleListener(new ActivityLifecycleListener(this, new PlatformPlugin(activity, this.platformChannel)) { // from class: io.flutter.view.FlutterView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterView this$0;
                public final /* synthetic */ PlatformPlugin val$platformPlugin;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this, r7};
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
                    this.val$platformPlugin = r7;
                }

                @Override // io.flutter.plugin.common.ActivityLifecycleListener
                public void onPostResume() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$platformPlugin.updateSystemUiOverlays();
                    }
                }
            });
            this.mImm = (InputMethodManager) getContext().getSystemService("input_method");
            PlatformViewsController platformViewsController = this.mNativeView.getPluginRegistry().getPlatformViewsController();
            TextInputPlugin textInputPlugin = new TextInputPlugin(this, new TextInputChannel(this.dartExecutor), platformViewsController);
            this.mTextInputPlugin = textInputPlugin;
            this.mKeyboardManager = new KeyboardManager(this, textInputPlugin, new KeyChannelResponder[]{new KeyChannelResponder(this.keyEventChannel)});
            if (Build.VERSION.SDK_INT >= 24) {
                this.mMouseCursorPlugin = new MouseCursorPlugin(this, new MouseCursorChannel(this.dartExecutor));
            } else {
                this.mMouseCursorPlugin = null;
            }
            this.mLocalizationPlugin = new LocalizationPlugin(context, this.localizationChannel);
            this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterRenderer, false);
            platformViewsController.attachToFlutterRenderer(this.flutterRenderer);
            this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.mTextInputPlugin);
            this.mNativeView.getFlutterJNI().setLocalizationPlugin(this.mLocalizationPlugin);
            this.mLocalizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
            sendUserPlatformSettingsToDart();
            return;
        }
        throw new IllegalArgumentException("Bad context");
    }
}
