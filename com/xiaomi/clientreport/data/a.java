package com.xiaomi.clientreport.data;

import com.xiaomi.push.bs;
import com.xiaomi.push.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String clientInterfaceId;
    public String pkgName;
    public int production;
    public int reportType;
    public String sdkVersion;
    public String os = bs.a();
    public String miuiVersion = j.m709a();

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
            jSONObject.put("pkgName", this.pkgName);
            jSONObject.put(com.heytap.mcssdk.constant.b.C, this.sdkVersion);
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
