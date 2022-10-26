package com.heytap.openid.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class OpenIDInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Type_AAID = 2;
    public static int Type_OAID = 8;
    public static int Type_VAID = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public final String AAID;
    public final String OAID;
    public final boolean OAIDStatus;
    public final String VAID;

    public OpenIDInfo(String str, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.OAID = str;
        this.OAIDStatus = z;
        this.VAID = str2;
        this.AAID = str3;
    }

    public native String getAAID();

    public native String getOAID();

    public native boolean getOAIDStatus();

    public native String getVAID();
}
