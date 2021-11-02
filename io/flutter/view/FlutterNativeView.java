package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class FlutterNativeView implements BinaryMessenger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterNativeView";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean applicationIsRunning;
    public final DartExecutor dartExecutor;
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    public final Context mContext;
    public final FlutterJNI mFlutterJNI;
    public FlutterView mFlutterView;
    public final FlutterPluginRegistry mPluginRegistry;

    /* loaded from: classes3.dex */
    public final class EngineLifecycleListenerImpl implements FlutterEngine.EngineLifecycleListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FlutterNativeView this$0;

        public EngineLifecycleListenerImpl(FlutterNativeView flutterNativeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterNativeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterNativeView;
        }

        @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
        public void onPreEngineRestart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.this$0.mFlutterView != null) {
                    this.this$0.mFlutterView.resetAccessibilityTree();
                }
                if (this.this$0.mPluginRegistry == null) {
                    return;
                }
                this.this$0.mPluginRegistry.onPreEngineRestart();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterNativeView(@NonNull Context context) {
        this(context, false);
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
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void attach(FlutterNativeView flutterNativeView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, flutterNativeView, z) == null) {
            this.mFlutterJNI.attachToNative(z);
            this.dartExecutor.onAttachedToJNI();
        }
    }

    public static String getObservatoryUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? FlutterJNI.getObservatoryUri() : (String) invokeV.objValue;
    }

    public void assertAttached() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void attachViewAndActivity(FlutterView flutterView, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterView, activity) == null) {
            this.mFlutterView = flutterView;
            this.mPluginRegistry.attach(flutterView, activity);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mPluginRegistry.destroy();
            this.dartExecutor.onDetachedFromJNI();
            this.mFlutterView = null;
            this.mFlutterJNI.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
            this.mFlutterJNI.detachFromNativeAndReleaseResources();
            this.applicationIsRunning = false;
        }
    }

    public void detachFromFlutterView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mPluginRegistry.detach();
            this.mFlutterView = null;
        }
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.dartExecutor : (DartExecutor) invokeV.objValue;
    }

    public FlutterJNI getFlutterJNI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFlutterJNI : (FlutterJNI) invokeV.objValue;
    }

    @NonNull
    public FlutterPluginRegistry getPluginRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPluginRegistry : (FlutterPluginRegistry) invokeV.objValue;
    }

    public boolean isApplicationRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.applicationIsRunning : invokeV.booleanValue;
    }

    public boolean isAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mFlutterJNI.isAttached() : invokeV.booleanValue;
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, flutterRunArguments) == null) {
            if (flutterRunArguments.entrypoint != null) {
                assertAttached();
                if (!this.applicationIsRunning) {
                    this.mFlutterJNI.runBundleAndSnapshotFromLibrary(flutterRunArguments.bundlePath, flutterRunArguments.entrypoint, flutterRunArguments.libraryPath, this.mContext.getResources().getAssets());
                    this.applicationIsRunning = true;
                    return;
                }
                throw new AssertionError("This Flutter engine instance is already running an application");
            }
            throw new AssertionError("An entrypoint must be specified");
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void send(String str, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, byteBuffer) == null) {
            this.dartExecutor.getBinaryMessenger().send(str, byteBuffer);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, binaryMessageHandler) == null) {
            this.dartExecutor.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler);
        }
    }

    public FlutterNativeView(@NonNull Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.view.FlutterNativeView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterNativeView this$0;

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
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mFlutterView == null) {
                    return;
                }
                this.this$0.mFlutterView.onFirstFrame();
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.mContext = context;
        this.mPluginRegistry = new FlutterPluginRegistry(this, context);
        FlutterJNI flutterJNI = new FlutterJNI();
        this.mFlutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        this.dartExecutor = new DartExecutor(this.mFlutterJNI, context.getAssets());
        this.mFlutterJNI.addEngineLifecycleListener(new EngineLifecycleListenerImpl());
        attach(this, z);
        assertAttached();
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, byteBuffer, binaryReply) == null) {
            if (!isAttached()) {
                String str2 = "FlutterView.send called on a detached view, channel=" + str;
                return;
            }
            this.dartExecutor.getBinaryMessenger().send(str, byteBuffer, binaryReply);
        }
    }
}
