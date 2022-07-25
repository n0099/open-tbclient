package com.meizu.cloud.pushsdk.platform.message;

import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class UnRegisterStatus extends BasicPushStatus {
    public boolean isUnRegisterSuccess;

    public UnRegisterStatus() {
    }

    public UnRegisterStatus(String str) {
        super(str);
    }

    public boolean isUnRegisterSuccess() {
        return this.isUnRegisterSuccess;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) throws JSONException {
        if (jSONObject.isNull(TiebaStatic.LogFields.RESULT)) {
            return;
        }
        setIsUnRegisterSuccess(jSONObject.getBoolean(TiebaStatic.LogFields.RESULT));
    }

    public void setIsUnRegisterSuccess(boolean z) {
        this.isUnRegisterSuccess = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + " UnRegisterStatus{isUnRegisterSuccess=" + this.isUnRegisterSuccess + '}';
    }
}
