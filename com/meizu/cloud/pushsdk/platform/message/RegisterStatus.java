package com.meizu.cloud.pushsdk.platform.message;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RegisterStatus extends BasicPushStatus {
    public int expireTime;
    public String pushId;

    public RegisterStatus() {
    }

    public RegisterStatus(String str) {
        super(str);
    }

    public int getExpireTime() {
        return this.expireTime;
    }

    public String getPushId() {
        return this.pushId;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("pushId")) {
            setPushId(jSONObject.getString("pushId"));
        }
        if (jSONObject.isNull("expireTime")) {
            return;
        }
        setExpireTime(jSONObject.getInt("expireTime"));
    }

    public void setExpireTime(int i2) {
        this.expireTime = i2;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + "pushId='" + this.pushId + ExtendedMessageFormat.QUOTE + ", Become invalid after " + this.expireTime + " seconds " + ExtendedMessageFormat.END_FE;
    }
}
