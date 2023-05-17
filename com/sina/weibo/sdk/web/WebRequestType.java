package com.sina.weibo.sdk.web;

import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class WebRequestType {
    public static final /* synthetic */ WebRequestType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final WebRequestType AUTH;
    public static final WebRequestType DEFAULT;
    public static final WebRequestType SHARE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161274275, "Lcom/sina/weibo/sdk/web/WebRequestType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1161274275, "Lcom/sina/weibo/sdk/web/WebRequestType;");
                return;
            }
        }
        SHARE = new WebRequestType("SHARE", 0);
        AUTH = new WebRequestType("AUTH", 1);
        WebRequestType webRequestType = new WebRequestType(EngineName.DEFAULT_ENGINE, 2);
        DEFAULT = webRequestType;
        $VALUES = new WebRequestType[]{SHARE, AUTH, webRequestType};
    }

    public WebRequestType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static WebRequestType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (WebRequestType) Enum.valueOf(WebRequestType.class, str);
        }
        return (WebRequestType) invokeL.objValue;
    }

    public static WebRequestType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (WebRequestType[]) $VALUES.clone();
        }
        return (WebRequestType[]) invokeV.objValue;
    }
}
