package com.yy.hiidostatis.inner.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DefaultPreference {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object KEY;
    public static DefaultPreference instance = null;
    public static String mPrefName = "hdcommon_default_pref";
    public transient /* synthetic */ FieldHolder $fh;
    public Preference preference;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(633897728, "Lcom/yy/hiidostatis/inner/util/DefaultPreference;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(633897728, "Lcom/yy/hiidostatis/inner/util/DefaultPreference;");
                return;
            }
        }
        KEY = new Object();
    }

    public DefaultPreference() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.preference = new Preference(mPrefName, false);
    }

    public static DefaultPreference getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (instance == null) {
                synchronized (KEY) {
                    if (instance == null) {
                        instance = new DefaultPreference();
                    }
                }
            }
            return instance;
        }
        return (DefaultPreference) invokeV.objValue;
    }

    public static Preference getPreference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? getInstance().preference : (Preference) invokeV.objValue;
    }

    public static void setPrefName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            mPrefName = str;
        }
    }
}
