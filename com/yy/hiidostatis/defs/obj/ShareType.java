package com.yy.hiidostatis.defs.obj;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ShareType {
    public static final /* synthetic */ ShareType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ShareType SHARE_TYPE_SHARE;
    public static final ShareType SHARE_TYPE_SHARE_RESULT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(343738856, "Lcom/yy/hiidostatis/defs/obj/ShareType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(343738856, "Lcom/yy/hiidostatis/defs/obj/ShareType;");
                return;
            }
        }
        SHARE_TYPE_SHARE = new ShareType("SHARE_TYPE_SHARE", 0);
        ShareType shareType = new ShareType("SHARE_TYPE_SHARE_RESULT", 1);
        SHARE_TYPE_SHARE_RESULT = shareType;
        $VALUES = new ShareType[]{SHARE_TYPE_SHARE, shareType};
    }

    public ShareType(String str, int i2) {
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

    public static ShareType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ShareType) Enum.valueOf(ShareType.class, str) : (ShareType) invokeL.objValue;
    }

    public static ShareType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ShareType[]) $VALUES.clone() : (ShareType[]) invokeV.objValue;
    }
}
