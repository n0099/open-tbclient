package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StringCodec;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.FlutterMain;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class DartExecutor implements BinaryMessenger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DartExecutor";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AssetManager assetManager;
    @NonNull
    public final BinaryMessenger binaryMessenger;
    @NonNull
    public final DartMessenger dartMessenger;
    @NonNull
    public final FlutterJNI flutterJNI;
    public boolean isApplicationRunning;
    public final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler;
    @Nullable
    public String isolateServiceId;
    @Nullable
    public IsolateServiceIdListener isolateServiceIdListener;

    /* loaded from: classes10.dex */
    public static class DartCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AssetManager androidAssetManager;
        public final FlutterCallbackInformation callbackHandle;
        public final String pathToBundle;

        public DartCallback(@NonNull AssetManager assetManager, @NonNull String str, @NonNull FlutterCallbackInformation flutterCallbackInformation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assetManager, str, flutterCallbackInformation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.androidAssetManager = assetManager;
            this.pathToBundle = str;
            this.callbackHandle = flutterCallbackInformation;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "DartCallback( bundle path: " + this.pathToBundle + ", library path: " + this.callbackHandle.callbackLibraryPath + ", function: " + this.callbackHandle.callbackName + " )";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class DartEntrypoint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String dartEntrypointFunctionName;
        @NonNull
        public final String pathToBundle;

        public DartEntrypoint(@NonNull String str, @NonNull String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pathToBundle = str;
            this.dartEntrypointFunctionName = str2;
        }

        @NonNull
        public static DartEntrypoint createDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new DartEntrypoint(FlutterMain.findAppBundlePath(), FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT) : (DartEntrypoint) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || DartEntrypoint.class != obj.getClass()) {
                    return false;
                }
                DartEntrypoint dartEntrypoint = (DartEntrypoint) obj;
                if (this.pathToBundle.equals(dartEntrypoint.pathToBundle)) {
                    return this.dartEntrypointFunctionName.equals(dartEntrypoint.dartEntrypointFunctionName);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.pathToBundle.hashCode() * 31) + this.dartEntrypointFunctionName.hashCode() : invokeV.intValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "DartEntrypoint( bundle path: " + this.pathToBundle + ", function: " + this.dartEntrypointFunctionName + " )";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class DefaultBinaryMessenger implements BinaryMessenger {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DartMessenger messenger;

        @Override // io.flutter.plugin.common.BinaryMessenger
        @UiThread
        public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, byteBuffer) == null) {
                this.messenger.send(str, byteBuffer, null);
            }
        }

        @Override // io.flutter.plugin.common.BinaryMessenger
        @UiThread
        public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, binaryMessageHandler) == null) {
                this.messenger.setMessageHandler(str, binaryMessageHandler);
            }
        }

        public DefaultBinaryMessenger(@NonNull DartMessenger dartMessenger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dartMessenger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.messenger = dartMessenger;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger
        @UiThread
        public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, byteBuffer, binaryReply) == null) {
                this.messenger.send(str, byteBuffer, binaryReply);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface IsolateServiceIdListener {
        void onIsolateServiceIdAvailable(@NonNull String str);
    }

    public DartExecutor(@NonNull FlutterJNI flutterJNI, @NonNull AssetManager assetManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterJNI, assetManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isApplicationRunning = false;
        this.isolateChannelMessageHandler = new BinaryMessenger.BinaryMessageHandler(this) { // from class: io.flutter.embedding.engine.dart.DartExecutor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DartExecutor this$0;

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

            @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
            public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, byteBuffer, binaryReply) == null) {
                    this.this$0.isolateServiceId = StringCodec.INSTANCE.decodeMessage(byteBuffer);
                    if (this.this$0.isolateServiceIdListener != null) {
                        this.this$0.isolateServiceIdListener.onIsolateServiceIdAvailable(this.this$0.isolateServiceId);
                    }
                }
            }
        };
        this.flutterJNI = flutterJNI;
        this.assetManager = assetManager;
        DartMessenger dartMessenger = new DartMessenger(flutterJNI);
        this.dartMessenger = dartMessenger;
        dartMessenger.setMessageHandler("flutter/isolate", this.isolateChannelMessageHandler);
        this.binaryMessenger = new DefaultBinaryMessenger(this.dartMessenger);
    }

    public void executeDartCallback(@NonNull DartCallback dartCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dartCallback) == null) {
            if (this.isApplicationRunning) {
                Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
                return;
            }
            Log.v(TAG, "Executing Dart callback: " + dartCallback);
            FlutterJNI flutterJNI = this.flutterJNI;
            String str = dartCallback.pathToBundle;
            FlutterCallbackInformation flutterCallbackInformation = dartCallback.callbackHandle;
            flutterJNI.runBundleAndSnapshotFromLibrary(str, flutterCallbackInformation.callbackName, flutterCallbackInformation.callbackLibraryPath, dartCallback.androidAssetManager);
            this.isApplicationRunning = true;
        }
    }

    public void executeDartEntrypoint(@NonNull DartEntrypoint dartEntrypoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dartEntrypoint) == null) {
            if (this.isApplicationRunning) {
                Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
                return;
            }
            Log.v(TAG, "Executing Dart entrypoint: " + dartEntrypoint);
            this.flutterJNI.runBundleAndSnapshotFromLibrary(dartEntrypoint.pathToBundle, dartEntrypoint.dartEntrypointFunctionName, null, this.assetManager);
            this.isApplicationRunning = true;
        }
    }

    @NonNull
    public BinaryMessenger getBinaryMessenger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.binaryMessenger : (BinaryMessenger) invokeV.objValue;
    }

    @Nullable
    public String getIsolateServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isolateServiceId : (String) invokeV.objValue;
    }

    @UiThread
    public int getPendingChannelResponseCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.dartMessenger.getPendingChannelResponseCount() : invokeV.intValue;
    }

    public boolean isExecutingDart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isApplicationRunning : invokeV.booleanValue;
    }

    public void onAttachedToJNI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Log.v(TAG, "Attached to JNI. Registering the platform message handler for this Dart execution context.");
            this.flutterJNI.setPlatformMessageHandler(this.dartMessenger);
        }
    }

    public void onDetachedFromJNI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Log.v(TAG, "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
            this.flutterJNI.setPlatformMessageHandler(null);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    @Deprecated
    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, byteBuffer) == null) {
            this.binaryMessenger.send(str, byteBuffer);
        }
    }

    public void setIsolateServiceIdListener(@Nullable IsolateServiceIdListener isolateServiceIdListener) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, isolateServiceIdListener) == null) {
            this.isolateServiceIdListener = isolateServiceIdListener;
            if (isolateServiceIdListener == null || (str = this.isolateServiceId) == null) {
                return;
            }
            isolateServiceIdListener.onIsolateServiceIdAvailable(str);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    @Deprecated
    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, binaryMessageHandler) == null) {
            this.binaryMessenger.setMessageHandler(str, binaryMessageHandler);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    @Deprecated
    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, byteBuffer, binaryReply) == null) {
            this.binaryMessenger.send(str, byteBuffer, binaryReply);
        }
    }
}
