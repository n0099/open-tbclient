package com.yy.hiidostatis.inner.util.hdid;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class Device {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HFROM_NEW_INNER = 4;
    public static final int HFROM_NEW_OUTER = 5;
    public static final int HFROM_NEW_SETTING = 6;
    public static final int HFROM_OLD_INNER = 1;
    public static final int HFROM_OLD_NEW = 0;
    public static final int HFROM_OLD_OUT1 = 2;
    public static final int HFROM_OLD_OUT2 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String arid;
    public long crtTime;
    public int hFrom;
    public String hdid;
    public String imei;
    public JSONObject json;
    public String mac;
    public String sdPermission;
    public String type;

    public Device() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = "0";
        this.crtTime = 0L;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj != null && hashCode() == obj.hashCode() : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? toString().hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return String.format("%s,%s,%s", this.hdid + "", this.imei + "", this.mac + "");
        }
        return (String) invokeV.objValue;
    }
}
