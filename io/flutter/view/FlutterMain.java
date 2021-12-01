package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;
@Deprecated
/* loaded from: classes3.dex */
public class FlutterMain {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class Settings {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String logTag;

        public Settings() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Nullable
        public String getLogTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.logTag : (String) invokeV.objValue;
        }

        public void setLogTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.logTag = str;
            }
        }
    }

    public FlutterMain() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, strArr) == null) {
            FlutterInjector.instance().flutterLoader().ensureInitializationComplete(context, strArr);
        }
    }

    public static void ensureInitializationCompleteAsync(@NonNull Context context, @Nullable String[] strArr, @NonNull Handler handler, @NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, strArr, handler, runnable) == null) {
            FlutterInjector.instance().flutterLoader().ensureInitializationCompleteAsync(context, strArr, handler, runnable);
        }
    }

    @NonNull
    public static String findAppBundlePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? FlutterInjector.instance().flutterLoader().findAppBundlePath() : (String) invokeV.objValue;
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str) : (String) invokeL.objValue;
    }

    public static void startInitialization(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            FlutterInjector.instance().flutterLoader().startInitialization(context);
        }
    }

    @Nullable
    @Deprecated
    public static String findAppBundlePath(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? FlutterInjector.instance().flutterLoader().findAppBundlePath() : (String) invokeL.objValue;
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) ? FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str, str2) : (String) invokeLL.objValue;
    }

    public static void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, settings) == null) {
            FlutterLoader.Settings settings2 = new FlutterLoader.Settings();
            settings2.setLogTag(settings.getLogTag());
            FlutterInjector.instance().flutterLoader().startInitialization(context, settings2);
        }
    }
}
