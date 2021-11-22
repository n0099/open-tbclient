package io.flutter.embedding.engine.plugins;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.TextureRegistry;
/* loaded from: classes2.dex */
public interface FlutterPlugin {

    /* loaded from: classes2.dex */
    public interface FlutterAssets {
        String getAssetFilePathByName(@NonNull String str);

        String getAssetFilePathByName(@NonNull String str, @NonNull String str2);

        String getAssetFilePathBySubpath(@NonNull String str);

        String getAssetFilePathBySubpath(@NonNull String str, @NonNull String str2);
    }

    /* loaded from: classes2.dex */
    public static class FlutterPluginBinding {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context applicationContext;
        public final BinaryMessenger binaryMessenger;
        public final FlutterAssets flutterAssets;
        public final FlutterEngine flutterEngine;
        public final PlatformViewRegistry platformViewRegistry;
        public final TextureRegistry textureRegistry;

        public FlutterPluginBinding(@NonNull Context context, @NonNull FlutterEngine flutterEngine, @NonNull BinaryMessenger binaryMessenger, @NonNull TextureRegistry textureRegistry, @NonNull PlatformViewRegistry platformViewRegistry, @NonNull FlutterAssets flutterAssets) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, flutterEngine, binaryMessenger, textureRegistry, platformViewRegistry, flutterAssets};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.applicationContext = context;
            this.flutterEngine = flutterEngine;
            this.binaryMessenger = binaryMessenger;
            this.textureRegistry = textureRegistry;
            this.platformViewRegistry = platformViewRegistry;
            this.flutterAssets = flutterAssets;
        }

        @NonNull
        public Context getApplicationContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.applicationContext : (Context) invokeV.objValue;
        }

        @NonNull
        public BinaryMessenger getBinaryMessenger() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.binaryMessenger : (BinaryMessenger) invokeV.objValue;
        }

        @NonNull
        public FlutterAssets getFlutterAssets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.flutterAssets : (FlutterAssets) invokeV.objValue;
        }

        @NonNull
        @Deprecated
        public FlutterEngine getFlutterEngine() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.flutterEngine : (FlutterEngine) invokeV.objValue;
        }

        @NonNull
        public PlatformViewRegistry getPlatformViewRegistry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.platformViewRegistry : (PlatformViewRegistry) invokeV.objValue;
        }

        @NonNull
        public TextureRegistry getTextureRegistry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.textureRegistry : (TextureRegistry) invokeV.objValue;
        }
    }

    void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding);

    void onDetachedFromEngine(@NonNull FlutterPluginBinding flutterPluginBinding);
}
