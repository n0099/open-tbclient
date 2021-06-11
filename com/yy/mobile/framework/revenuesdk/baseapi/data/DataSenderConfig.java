package com.yy.mobile.framework.revenuesdk.baseapi.data;

import android.content.Context;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
/* loaded from: classes7.dex */
public class DataSenderConfig {
    public Context appContext;
    public int authType;
    public String gslbAppId;
    public String hdid;
    public String hostId;
    public String httpUrl;
    public String pakageName;
    public ProtocolType protoType;
    public String version;

    public String toString() {
        return "DataSenderConfig { hostId=" + this.hostId + " pakageName=" + this.pakageName + " version=" + this.version + " httpUrl=" + this.httpUrl + " authType=" + this.authType + " gslbAppId=" + this.gslbAppId + " }";
    }
}
