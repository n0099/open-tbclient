package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
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
import io.flutter.embedding.engine.loader.FlutterLoader;
/* loaded from: classes3.dex */
public class FlutterMain {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isRunningInRobolectricTest;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1053198752, "Lio/flutter/view/FlutterMain;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1053198752, "Lio/flutter/view/FlutterMain;");
        }
    }

    public FlutterMain() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, strArr) == null) || isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.getInstance().ensureInitializationComplete(context, strArr);
    }

    public static void ensureInitializationCompleteAsync(@NonNull Context context, @Nullable String[] strArr, @NonNull Handler handler, @NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, context, strArr, handler, runnable) == null) || isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.getInstance().ensureInitializationCompleteAsync(context, strArr, handler, runnable);
    }

    @NonNull
    public static String findAppBundlePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? FlutterLoader.getInstance().findAppBundlePath() : (String) invokeV.objValue;
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? FlutterLoader.getInstance().getLookupKeyForAsset(str) : (String) invokeL.objValue;
    }

    @VisibleForTesting
    @Deprecated
    public static void setIsRunningInRobolectricTest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            isRunningInRobolectricTest = z;
        }
    }

    public static void startInitialization(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, context) == null) || isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.getInstance().startInitialization(context);
    }

    @Nullable
    @Deprecated
    public static String findAppBundlePath(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? FlutterLoader.getInstance().findAppBundlePath() : (String) invokeL.objValue;
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? FlutterLoader.getInstance().getLookupKeyForAsset(str, str2) : (String) invokeLL.objValue;
    }

    public static void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, settings) == null) || isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.Settings settings2 = new FlutterLoader.Settings();
        settings2.setLogTag(settings.getLogTag());
        FlutterLoader.getInstance().startInitialization(context, settings2);
    }
}
