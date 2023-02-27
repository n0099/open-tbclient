package com.yy.gslbsdk.statistic;

import com.baidu.sapi2.activity.BaseActivity;
import com.heytap.mcssdk.constant.b;
import com.tencent.connect.common.Constants;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.StringTools;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class DevInfo {
    public String appId = StringTools.optString(GlobalTools.ACCOUNT_ID);
    public String gslbId = StringTools.optString(DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT));
    public String countryCode = StringTools.optString(GlobalTools.APP_LOCALIZE_CODE);
    public String sdkVersion = StringTools.optString("2.2.28-live");
    public String platform = "andr";
    public String devId = StringTools.optString(GlobalTools.APP_DEV_ID);

    public Map<String, String> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
        linkedHashMap.put("gslbId", this.gslbId);
        linkedHashMap.put("countryCode", this.countryCode);
        linkedHashMap.put(b.C, this.sdkVersion);
        linkedHashMap.put(Constants.PARAM_PLATFORM, this.platform);
        linkedHashMap.put("devId", this.devId);
        return linkedHashMap;
    }
}
