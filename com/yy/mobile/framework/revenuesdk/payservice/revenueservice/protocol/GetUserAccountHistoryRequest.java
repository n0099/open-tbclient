package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetUserAccountHistoryRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int currencyType;
    public String expand;
    public long lastId;
    public String seq;
    public long uid;
    public int usedChannel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetUserAccountHistoryRequest(long j2, int i2, int i3, int i4, String str, String str2, long j3) {
        this(j2, i2, i3, i4, str, str2, j3, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (String) objArr2[4], (String) objArr2[5], ((Long) objArr2[6]).longValue(), (String) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", RevenueServerConst.GetUserAccountHistoryRequest);
                jSONObject.put("uid", this.uid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put("currencyType", this.currencyType);
                jSONObject.put("seq", this.seq);
                jSONObject.put("lastId", this.lastId);
                jSONObject.put("expand", this.expand);
                return jSONObject.toString();
            } catch (JSONException e2) {
                RLog.error("GetUserAccountHistoryRequest", "constructPSCIMessageRequest", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public GetUserAccountHistoryRequest(long j2, int i2, int i3, int i4, String str, String str2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, Long.valueOf(j3), str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.usedChannel = 10002;
        this.uid = j2;
        this.appId = i2;
        this.usedChannel = i3;
        this.currencyType = i4;
        this.seq = str;
        this.lastId = j3;
        this.expand = str3;
    }
}
