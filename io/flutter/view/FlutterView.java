package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidKeyProcessor;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public class FlutterView extends SurfaceView implements BinaryMessenger, TextureRegistry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterView";
    public transient /* synthetic */ FieldHolder $fh;
    public final AndroidKeyProcessor androidKeyProcessor;
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
    public final ViewportMetrics mMetrics;
    public FlutterNativeView mNativeView;
    public final SurfaceHolder.Callback mSurfaceCallback;
    public final TextInputPlugin mTextInputPlugin;
    public final NavigationChannel navigationChannel;
    public final AtomicLong nextTextureId;
    public final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    public final PlatformChannel platformChannel;
    public final SettingsChannel settingsChannel;
    public final SystemChannel systemChannel;

    /* loaded from: classes9.dex */
    public interface FirstFrameListener {
        void onFirstFrame();
    }

    /* loaded from: classes9.dex */
    public interface Provider {
        FlutterView getFlutterView();
    }

    /* loaded from: classes9.dex */
    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long id;
        public SurfaceTexture.OnFrameAvailableListener onFrameListener;
        public boolean released;
        public final SurfaceTexture surfaceTexture;
        public final /* synthetic */ FlutterView this$0;

        public SurfaceTextureRegistryEntry(FlutterView flutterView, long j, SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterView, Long.valueOf(j), surfaceTexture};
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
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener(this) { // from class: io.flutter.view.FlutterView.SurfaceTextureRegistryEntry.1
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
            this.onFrameListener = onFrameAvailableListener;
            this.id = j;
            this.surfaceTexture = surfaceTexture;
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, new Handler());
            } else {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
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
            this.surfaceTexture.setOnFrameAvailableListener(null);
            this.surfaceTexture.release();
            this.this$0.mNativeView.getFlutterJNI().unregisterTexture(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.surfaceTexture : (SurfaceTexture) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ViewportMetrics {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float devicePixelRatio;
        public int physicalHeight;
        public int physicalPaddingBottom;
        public int physicalPaddingLeft;
        public int physicalPaddingRight;
        public int physicalPaddingTop;
        public int physicalViewInsetBottom;
        public int physicalViewInsetLeft;
        public int physicalViewInsetRight;
        public int physicalViewInsetTop;
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
            this.physicalPaddingTop = 0;
            this.physicalPaddingRight = 0;
            this.physicalPaddingBottom = 0;
            this.physicalPaddingLeft = 0;
            this.physicalViewInsetTop = 0;
            this.physicalViewInsetRight = 0;
            this.physicalViewInsetBottom = 0;
            this.physicalViewInsetLeft = 0;
            this.systemGestureInsetTop = 0;
            this.systemGestureInsetRight = 0;
            this.systemGestureInsetBottom = 0;
            this.systemGestureInsetLeft = 0;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

    public static Activity getActivity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                return getActivity(((ContextWrapper) context).getBaseContext());
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    private boolean isAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            FlutterNativeView flutterNativeView = this.mNativeView;
            return flutterNativeView != null && flutterNativeView.isAttached();
        }
        return invokeV.booleanValue;
    }

    private void postRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
        }
    }

    private void preRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            resetAccessibilityTree();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWillNotDraw(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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

    private void sendLocalesToDart(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, configuration) == null) {
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
            this.localizationChannel.sendLocales(arrayList);
        }
    }

    private void sendUserPlatformSettingsToDart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
        }
    }

    private void updateViewportMetrics() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && isAttached()) {
            FlutterJNI flutterJNI = this.mNativeView.getFlutterJNI();
            ViewportMetrics viewportMetrics = this.mMetrics;
            flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.physicalWidth, viewportMetrics.physicalHeight, viewportMetrics.physicalPaddingTop, viewportMetrics.physicalPaddingRight, viewportMetrics.physicalPaddingBottom, viewportMetrics.physicalPaddingLeft, viewportMetrics.physicalViewInsetTop, viewportMetrics.physicalViewInsetRight, viewportMetrics.physicalViewInsetBottom, viewportMetrics.physicalViewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft);
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

    @RequiresApi(20)
    @TargetApi(20)
    public int calculateBottomKeyboardInset(WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, windowInsets)) == null) {
            if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
                return 0;
            }
            return windowInsets.getSystemWindowInsetBottom();
        }
        return invokeL.intValue;
    }

    public ZeroSides calculateShouldZeroSides() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity activity = (Activity) getContext();
            int i2 = activity.getResources().getConfiguration().orientation;
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
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

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) ? this.mNativeView.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(view) : invokeL.booleanValue;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            surfaceTexture.detachFromGLContext();
            SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this, this.nextTextureId.getAndIncrement(), surfaceTexture);
            this.mNativeView.getFlutterJNI().registerTexture(surfaceTextureRegistryEntry.id(), surfaceTexture);
            return surfaceTextureRegistryEntry;
        }
        return (TextureRegistry.SurfaceTextureEntry) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && isAttached()) {
            getHolder().removeCallback(this.mSurfaceCallback);
            this.mNativeView.destroy();
            this.mNativeView = null;
        }
    }

    public FlutterNativeView detach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setZOrderOnTop(false);
            getHolder().setFormat(-1);
        }
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
                viewportMetrics.physicalPaddingTop = rect.top;
                viewportMetrics.physicalPaddingRight = rect.right;
                viewportMetrics.physicalPaddingBottom = 0;
                viewportMetrics.physicalPaddingLeft = rect.left;
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

    public boolean hasRenderedFirstFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.didRenderFirstFrame : invokeV.booleanValue;
    }

    @Override // android.view.View
    @RequiresApi(20)
    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        InterceptResult invokeL;
        int systemWindowInsetBottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, windowInsets)) == null) {
            boolean z = (getWindowSystemUiVisibility() & 4) != 0;
            boolean z2 = (getWindowSystemUiVisibility() & 2) != 0;
            ZeroSides zeroSides = ZeroSides.NONE;
            if (z2) {
                zeroSides = calculateShouldZeroSides();
            }
            this.mMetrics.physicalPaddingTop = z ? 0 : windowInsets.getSystemWindowInsetTop();
            this.mMetrics.physicalPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            ViewportMetrics viewportMetrics = this.mMetrics;
            viewportMetrics.physicalPaddingBottom = 0;
            viewportMetrics.physicalPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            ViewportMetrics viewportMetrics2 = this.mMetrics;
            viewportMetrics2.physicalViewInsetTop = 0;
            viewportMetrics2.physicalViewInsetRight = 0;
            if (z2) {
                systemWindowInsetBottom = calculateBottomKeyboardInset(windowInsets);
            } else {
                systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
            }
            viewportMetrics2.physicalViewInsetBottom = systemWindowInsetBottom;
            this.mMetrics.physicalViewInsetLeft = 0;
            if (Build.VERSION.SDK_INT >= 29) {
                Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
                this.mMetrics.systemGestureInsetTop = systemGestureInsets.top;
                this.mMetrics.systemGestureInsetRight = systemGestureInsets.right;
                this.mMetrics.systemGestureInsetBottom = systemGestureInsets.bottom;
                this.mMetrics.systemGestureInsetLeft = systemGestureInsets.left;
            }
            updateViewportMetrics();
            return super.onApplyWindowInsets(windowInsets);
        }
        return (WindowInsets) invokeL.objValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            sendLocalesToDart(configuration);
            sendUserPlatformSettingsToDart();
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, editorInfo)) == null) ? this.mTextInputPlugin.createInputConnection(this, editorInfo) : (InputConnection) invokeL.objValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            this.mAccessibilityNodeProvider.release();
            this.mAccessibilityNodeProvider = null;
        }
    }

    public void onFirstFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, motionEvent)) == null) {
            if (!isAttached()) {
                return super.onHoverEvent(motionEvent);
            }
            return this.mAccessibilityNodeProvider.onAccessibilityHoverEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, keyEvent)) == null) {
            if (!isAttached()) {
                return super.onKeyDown(i2, keyEvent);
            }
            this.androidKeyProcessor.onKeyDown(keyEvent);
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            if (!isAttached()) {
                return super.onKeyUp(i2, keyEvent);
            }
            this.androidKeyProcessor.onKeyUp(keyEvent);
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void onMemoryPressure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.systemChannel.sendMemoryPressureWarning();
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.lifecycleChannel.appIsInactive();
        }
    }

    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            for (ActivityLifecycleListener activityLifecycleListener : this.mActivityLifecycleListeners) {
                activityLifecycleListener.onPostResume();
            }
            this.lifecycleChannel.appIsResumed();
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
        Activity activity = getActivity(getContext());
        if (activity != null) {
            if (flutterNativeView == null) {
                this.mNativeView = new FlutterNativeView(activity.getApplicationContext());
            } else {
                this.mNativeView = flutterNativeView;
            }
            this.dartExecutor = this.mNativeView.getDartExecutor();
            this.flutterRenderer = new FlutterRenderer(this.mNativeView.getFlutterJNI());
            this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().nativeGetIsSoftwareRenderingEnabled();
            ViewportMetrics viewportMetrics = new ViewportMetrics();
            this.mMetrics = viewportMetrics;
            viewportMetrics.devicePixelRatio = context.getResources().getDisplayMetrics().density;
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
            TextInputPlugin textInputPlugin = new TextInputPlugin(this, this.dartExecutor, this.mNativeView.getPluginRegistry().getPlatformViewsController());
            this.mTextInputPlugin = textInputPlugin;
            this.androidKeyProcessor = new AndroidKeyProcessor(this.keyEventChannel, textInputPlugin);
            this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterRenderer);
            this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.mTextInputPlugin);
            sendLocalesToDart(getResources().getConfiguration());
            sendUserPlatformSettingsToDart();
            return;
        }
        throw new IllegalArgumentException("Bad context");
    }
}
