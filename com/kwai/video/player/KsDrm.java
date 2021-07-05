package com.kwai.video.player;

import android.app.Application;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes7.dex */
public class KsDrm {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_CONFIG = "wasabi";
    public static final String TAG = "KsDrm";
    public transient /* synthetic */ FieldHolder $fh;

    public KsDrm() {
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

    public static String getMarlindrmPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(null, new Object[0]);
                return ((Application) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0])).getDir(APP_CONFIG, 0).getAbsolutePath();
            } catch (Exception e2) {
                Log.w(TAG, e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
