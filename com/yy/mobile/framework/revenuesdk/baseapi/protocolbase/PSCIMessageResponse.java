package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PSCIMessageResponse extends ResponsePacket {
    public int appId;
    public int cmd;
    public String jsonMsg;
    public String responseJson;
    public int result;
    public String seq;
    public int version;

    public PSCIMessageResponse(byte[] bArr) {
        super(bArr);
    }

    public String targetJson(ProtocolType protocolType) {
        if (protocolType == ProtocolType.HTTP) {
            return this.jsonMsg;
        }
        if (protocolType == ProtocolType.SERVICE) {
            return this.responseJson;
        }
        return "";
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.ResponsePacket
    public void popPacketData() {
        try {
            this.responseJson = popStingWithOutLength();
            JSONObject jSONObject = new JSONObject(this.responseJson);
            this.seq = jSONObject.optString("seq");
            this.result = jSONObject.optInt("result");
            this.cmd = jSONObject.optInt("cmd");
            this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.version = jSONObject.optInt("version");
            this.jsonMsg = jSONObject.optString("jsonMsg");
        } catch (Exception e) {
            RLog.error("PSCIMessageResponse", "popPacketData error", e);
        }
    }

    public String toString() {
        return "PSCIMessageResponse{result=" + this.result + ", cmd=" + this.cmd + ", appId=" + this.appId + ", version=" + this.version + ", seq=" + this.seq + ",responseJson=" + this.responseJson + '}';
    }
}
