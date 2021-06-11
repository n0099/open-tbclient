package com.meizu.cloud.pushsdk.platform.message;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SubAliasStatus extends BasicPushStatus {
    public String alias;
    public String pushId;

    public SubAliasStatus() {
    }

    public SubAliasStatus(String str) {
        super(str);
    }

    public String getAlias() {
        return this.alias;
    }

    public String getPushId() {
        return this.pushId;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("pushId")) {
            setPushId(jSONObject.getString("pushId"));
        }
        if (jSONObject.isNull("alias")) {
            return;
        }
        setAlias(jSONObject.getString("alias"));
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + " SubAliasStatus{pushId='" + this.pushId + "', alias='" + this.alias + "'}";
    }
}
