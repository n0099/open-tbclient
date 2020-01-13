package com.xiaomi.clientreport.data;

import com.coloros.mcssdk.mode.CommandMessage;
import com.vivo.push.PushClientConstants;
import com.xiaomi.push.be;
import com.xiaomi.push.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public String clientInterfaceId;
    private String pkgName;
    public int production;
    public int reportType;
    private String sdkVersion;
    private String os = be.a();
    private String miuiVersion = l.m475a();

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
            jSONObject.put("os", this.os);
            jSONObject.put("miuiVersion", this.miuiVersion);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.pkgName);
            jSONObject.put(CommandMessage.SDK_VERSION, this.sdkVersion);
            return jSONObject;
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public String toJsonString() {
        JSONObject json = toJson();
        return json == null ? "" : json.toString();
    }
}
