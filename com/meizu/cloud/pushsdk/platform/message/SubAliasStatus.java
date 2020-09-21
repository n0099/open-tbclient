package com.meizu.cloud.pushsdk.platform.message;

import com.heytap.mcssdk.mode.CommandMessage;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SubAliasStatus extends BasicPushStatus {
    private String alias;
    private String pushId;

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
        if (!jSONObject.isNull(PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(PushConstants.KEY_PUSH_ID));
        }
        if (jSONObject.isNull(CommandMessage.TYPE_ALIAS)) {
            return;
        }
        setAlias(jSONObject.getString(CommandMessage.TYPE_ALIAS));
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
