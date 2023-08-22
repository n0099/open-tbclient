package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ContextHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ContextHolder";
    @SuppressLint({"StaticFieldLeak"})
    public static Context sAppContext;
    @SuppressLint({"StaticFieldLeak"})
    public static Context sKitContext;
    public transient /* synthetic */ FieldHolder $fh;

    public ContextHolder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return sAppContext;
        }
        return (Context) invokeV.objValue;
    }

    public static Context getKitContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sKitContext;
        }
        return (Context) invokeV.objValue;
    }

    public static Context getResourceContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (getKitContext() != null) {
                return getKitContext();
            }
            return getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    public static void setAppContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            CheckParamUtils.checkNotNull(context, "sAppContext == null");
            sAppContext = context.getApplicationContext();
        }
    }

    public static void setKitContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            CheckParamUtils.checkNotNull(context, "sKitContext == null");
            sKitContext = context;
        }
    }
}
