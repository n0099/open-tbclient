package io.flutter.embedding.android;

import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FlutterActivityLaunchConfigs {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DART_ENTRYPOINT_META_DATA_KEY = "io.flutter.Entrypoint";
    public static final String DEFAULT_BACKGROUND_MODE;
    public static final String DEFAULT_DART_ENTRYPOINT = "main";
    public static final String DEFAULT_INITIAL_ROUTE = "/";
    public static final String EXTRA_BACKGROUND_MODE = "background_mode";
    public static final String EXTRA_CACHED_ENGINE_ID = "cached_engine_id";
    public static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    public static final String EXTRA_INITIAL_ROUTE = "route";
    public static final String INITIAL_ROUTE_META_DATA_KEY = "io.flutter.InitialRoute";
    public static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
    public static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BackgroundMode {
        public static final /* synthetic */ BackgroundMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BackgroundMode opaque;
        public static final BackgroundMode transparent;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1274899041, "Lio/flutter/embedding/android/FlutterActivityLaunchConfigs$BackgroundMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1274899041, "Lio/flutter/embedding/android/FlutterActivityLaunchConfigs$BackgroundMode;");
                    return;
                }
            }
            opaque = new BackgroundMode("opaque", 0);
            BackgroundMode backgroundMode = new BackgroundMode(OpenFlutter.EXTRA_TRANSPARANT, 1);
            transparent = backgroundMode;
            $VALUES = new BackgroundMode[]{opaque, backgroundMode};
        }

        public BackgroundMode(String str, int i2) {
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

        public static BackgroundMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BackgroundMode) Enum.valueOf(BackgroundMode.class, str) : (BackgroundMode) invokeL.objValue;
        }

        public static BackgroundMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BackgroundMode[]) $VALUES.clone() : (BackgroundMode[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(658556128, "Lio/flutter/embedding/android/FlutterActivityLaunchConfigs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(658556128, "Lio/flutter/embedding/android/FlutterActivityLaunchConfigs;");
                return;
            }
        }
        DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
    }

    public FlutterActivityLaunchConfigs() {
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
}
