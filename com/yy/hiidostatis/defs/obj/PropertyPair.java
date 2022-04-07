package com.yy.hiidostatis.defs.obj;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.Util;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class PropertyPair implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIVIDE_FIELD = "=";
    public static final int TYPE_COUNT = 0;
    public static final int TYPE_TIMES = 1;
    public static final long serialVersionUID = 807395322993363767L;
    public transient /* synthetic */ FieldHolder $fh;
    public String key;
    public int type;
    public String value;

    public PropertyPair(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.key = str;
        this.value = str2;
        this.type = 1;
    }

    public String getConnectedPair() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return Util.replaceEncode(this.key, "=") + "=" + Util.replaceEncode(this.value, "=") + "=" + this.type;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.key + "=" + this.value + "=" + this.type;
        }
        return (String) invokeV.objValue;
    }

    public PropertyPair(String str, double d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Double.valueOf(d)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.key = str;
        this.value = String.valueOf(d);
        this.type = 0;
    }
}
