package com.xiaomi.clientreport.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PerfClientReport extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_VALUE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;
    public long perfCounts;
    public long perfLatencies;

    public PerfClientReport() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.perfCounts = -1L;
        this.perfLatencies = -1L;
    }

    public static PerfClientReport getBlankInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new PerfClientReport() : (PerfClientReport) invokeV.objValue;
    }

    @Override // com.xiaomi.clientreport.data.a
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject json = super.toJson();
                if (json == null) {
                    return null;
                }
                json.put("code", this.code);
                json.put("perfCounts", this.perfCounts);
                json.put("perfLatencies", this.perfLatencies);
                return json;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.toJsonString() : (String) invokeV.objValue;
    }
}
