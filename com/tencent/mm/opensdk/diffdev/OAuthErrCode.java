package com.tencent.mm.opensdk.diffdev;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class OAuthErrCode {
    public static final /* synthetic */ OAuthErrCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final OAuthErrCode WechatAuth_Err_Auth_Stopped;
    public static final OAuthErrCode WechatAuth_Err_Cancel;
    public static final OAuthErrCode WechatAuth_Err_JsonDecodeErr;
    public static final OAuthErrCode WechatAuth_Err_NetworkErr;
    public static final OAuthErrCode WechatAuth_Err_NormalErr;
    public static final OAuthErrCode WechatAuth_Err_OK;
    public static final OAuthErrCode WechatAuth_Err_Timeout;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1602707639, "Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1602707639, "Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;");
                return;
            }
        }
        WechatAuth_Err_OK = new OAuthErrCode("WechatAuth_Err_OK", 0, 0);
        WechatAuth_Err_NormalErr = new OAuthErrCode("WechatAuth_Err_NormalErr", 1, -1);
        WechatAuth_Err_NetworkErr = new OAuthErrCode("WechatAuth_Err_NetworkErr", 2, -2);
        WechatAuth_Err_JsonDecodeErr = new OAuthErrCode("WechatAuth_Err_JsonDecodeErr", 3, -3);
        WechatAuth_Err_Cancel = new OAuthErrCode("WechatAuth_Err_Cancel", 4, -4);
        WechatAuth_Err_Timeout = new OAuthErrCode("WechatAuth_Err_Timeout", 5, -5);
        OAuthErrCode oAuthErrCode = new OAuthErrCode("WechatAuth_Err_Auth_Stopped", 6, -6);
        WechatAuth_Err_Auth_Stopped = oAuthErrCode;
        $VALUES = new OAuthErrCode[]{WechatAuth_Err_OK, WechatAuth_Err_NormalErr, WechatAuth_Err_NetworkErr, WechatAuth_Err_JsonDecodeErr, WechatAuth_Err_Cancel, WechatAuth_Err_Timeout, oAuthErrCode};
    }

    public OAuthErrCode(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i3;
    }

    public static OAuthErrCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OAuthErrCode) Enum.valueOf(OAuthErrCode.class, str) : (OAuthErrCode) invokeL.objValue;
    }

    public static OAuthErrCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OAuthErrCode[]) $VALUES.clone() : (OAuthErrCode[]) invokeV.objValue;
    }

    public final int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
    }

    @Override // java.lang.Enum
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "OAuthErrCode:" + this.code;
        }
        return (String) invokeV.objValue;
    }
}
