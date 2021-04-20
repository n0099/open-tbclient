package com.xiaomi.clientreport.data;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.heytap.mcssdk.mode.CommandMessage;
import com.vivo.push.PushClientConstants;
import com.xiaomi.push.bq;
import com.xiaomi.push.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String clientInterfaceId;
    public String pkgName;
    public int production;
    public int reportType;
    public String sdkVersion;
    public String os = bq.a();
    public String miuiVersion = l.m517a();

    public String getPackageName() {
        return this.pkgName;
    }

    public void setAppPackageName(String str) {
        this.pkgName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.production);
            jSONObject.put("reportType", this.reportType);
            jSONObject.put("clientInterfaceId", this.clientInterfaceId);
            jSONObject.put(IAdRequestParam.OS, this.os);
            jSONObject.put("miuiVersion", this.miuiVersion);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.pkgName);
            jSONObject.put(CommandMessage.SDK_VERSION, this.sdkVersion);
            return jSONObject;
        } catch (JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    public String toJsonString() {
        JSONObject json = toJson();
        return json == null ? "" : json.toString();
    }
}
