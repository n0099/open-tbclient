package com.qq.e.comm;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;
/* loaded from: classes4.dex */
public class StubVisitor {
    public static /* synthetic */ Interceptable $ic;
    public static volatile StubVisitor a;
    public transient /* synthetic */ FieldHolder $fh;

    public StubVisitor() {
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

    public static StubVisitor getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (StubVisitor.class) {
                    if (a == null) {
                        a = new StubVisitor();
                    }
                }
            }
            return a;
        }
        return (StubVisitor) invokeV.objValue;
    }

    public String appendPathName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? SystemUtil.buildNewPathByProcessName(str) : (String) invokeL.objValue;
    }

    public boolean jumpToCustomLandingPage(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2)) == null) {
            CustomLandingPageListener customLandingPageListener = GlobalSetting.getCustomLandingPageListener();
            if (customLandingPageListener != null) {
                return customLandingPageListener.jumpToCustomLandingPage(context, str, str2);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
