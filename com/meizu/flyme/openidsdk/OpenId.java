package com.meizu.flyme.openidsdk;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public class OpenId {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public int code;
    @Keep
    public long expiredTime;
    @Keep
    public String type;
    @Keep
    public String value;

    public OpenId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = str;
    }

    @Keep
    public native boolean isValid();

    @Keep
    public native void setDataExpired();

    @Keep
    public native void updateCode(int i);

    @Keep
    public native void updateExpiredTime(long j);

    @Keep
    public native void updateValue(String str);
}
