package com.yy.gslbsdk.statistic;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.tencent.connect.common.Constants;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.StringTools;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class DevInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public String countryCode;
    public String devId;
    public String gslbId;
    public String platform;
    public String sdkVersion;

    public DevInfo() {
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
        this.appId = StringTools.optString(GlobalTools.ACCOUNT_ID);
        this.gslbId = StringTools.optString(DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT));
        this.countryCode = StringTools.optString(GlobalTools.APP_LOCALIZE_CODE);
        this.sdkVersion = StringTools.optString("2.2.18-lianyun");
        this.platform = "andr";
        this.devId = StringTools.optString(GlobalTools.APP_DEV_ID);
    }

    public Map<String, String> toMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            linkedHashMap.put("gslbId", this.gslbId);
            linkedHashMap.put("countryCode", this.countryCode);
            linkedHashMap.put(CommandMessage.SDK_VERSION, this.sdkVersion);
            linkedHashMap.put(Constants.PARAM_PLATFORM, this.platform);
            linkedHashMap.put("devId", this.devId);
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }
}
