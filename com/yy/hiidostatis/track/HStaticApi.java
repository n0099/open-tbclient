package com.yy.hiidostatis.track;

import android.content.Context;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.inner.util.ThreadPool;
import java.util.Map;
/* loaded from: classes10.dex */
public enum HStaticApi {
    instante;
    
    public StatisAPI mStatisAPI;
    public StatisAPI mStatisAPI_3;

    public void init(Context context, StatisOption statisOption, String str) {
        this.mStatisAPI = HiidoSDK.instance().createNewStatisApi();
        StatisOption statisOption2 = new StatisOption();
        statisOption2.setAppkey("t2-" + statisOption.getAppkey());
        statisOption2.setAppId(statisOption.getAppId());
        statisOption2.setFrom(statisOption.getFrom());
        statisOption2.setVer(statisOption.getVer());
        this.mStatisAPI.init(context, statisOption2);
        this.mStatisAPI.setAbroad(false);
        this.mStatisAPI_3 = HiidoSDK.instance().createNewStatisApi();
        StatisOption statisOption3 = new StatisOption();
        statisOption3.setAppkey("t3-" + statisOption.getAppkey());
        statisOption3.setAppId(statisOption.getAppId());
        statisOption3.setFrom(statisOption.getFrom());
        statisOption3.setVer(statisOption.getVer());
        this.mStatisAPI_3.init(context, statisOption3);
        this.mStatisAPI_3.setBusinessType(HiidoSDK.instance().getOptions().businessType);
        this.mStatisAPI_3.setAbroad(true);
    }

    public void reportReg(final String str, final String str2, final String str3, final Map<String, String> map) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.track.HStaticApi.1
            @Override // java.lang.Runnable
            public void run() {
                if (HStaticApi.this.mStatisAPI != null) {
                    HStaticApi.this.mStatisAPI.reportReg(str, str2, str3, map);
                }
                if (HStaticApi.this.mStatisAPI_3 != null) {
                    HStaticApi.this.mStatisAPI_3.reportReg(str, str2, str3, map);
                }
            }
        });
    }
}
