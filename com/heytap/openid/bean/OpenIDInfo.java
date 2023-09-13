package com.heytap.openid.bean;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes10.dex */
public final class OpenIDInfo {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static int Type_AAID = 2;
    @Keep
    public static int Type_OAID = 8;
    @Keep
    public static int Type_VAID = 4;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public final String AAID;
    @Keep
    public final String OAID;
    @Keep
    public final boolean OAIDStatus;
    @Keep
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

    @Keep
    public native String getAAID();

    @Keep
    public native String getOAID();

    @Keep
    public native boolean getOAIDStatus();

    @Keep
    public native String getVAID();
}
