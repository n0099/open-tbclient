package com.yy.mobile.framework.revenuesdk.baseapi.data;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayNetStateStatistics;
/* loaded from: classes8.dex */
public class DataSenderConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context appContext;
    public int authType;
    public String gslbAppId;
    public String hdid;
    public String hostId;
    public String httpUrl;
    public String pakageName;
    public IPayNetStateStatistics payNetReporter;
    public ProtocolType protoType;
    public String version;

    public DataSenderConfig() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "DataSenderConfig { hostId=" + this.hostId + " pakageName=" + this.pakageName + " version=" + this.version + " httpUrl=" + this.httpUrl + " authType=" + this.authType + " gslbAppId=" + this.gslbAppId + " }";
        }
        return (String) invokeV.objValue;
    }
}
