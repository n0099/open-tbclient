package com.google.android.exoplayer2;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes7.dex */
public final class ExoPlayerLibraryInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.6.0";
    public static final int VERSION_INT = 2006000;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.6.0";
    public static final HashSet<String> registeredModules;
    public static String registeredModulesString;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737983377, "Lcom/google/android/exoplayer2/ExoPlayerLibraryInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737983377, "Lcom/google/android/exoplayer2/ExoPlayerLibraryInfo;");
                return;
            }
        }
        registeredModules = new HashSet<>();
        registeredModulesString = "goog.exo.core";
    }

    public ExoPlayerLibraryInfo() {
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

    public static synchronized void registerModule(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            synchronized (ExoPlayerLibraryInfo.class) {
                if (registeredModules.add(str)) {
                    registeredModulesString += StringUtil.ARRAY_ELEMENT_SEPARATOR + str;
                }
            }
        }
    }

    public static synchronized String registeredModules() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (ExoPlayerLibraryInfo.class) {
                str = registeredModulesString;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
