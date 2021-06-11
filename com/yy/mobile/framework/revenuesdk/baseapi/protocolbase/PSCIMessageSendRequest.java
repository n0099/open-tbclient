package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PSCIMessageSendRequest extends RequestPacket {
    public static final String TAG = "PSCIMessageRequest";
    public int appId;
    public int cmd;
    public String jsonMsg;
    public ProtocolType protocolType;
    public String requestJson;
    public int version;

    public PSCIMessageSendRequest(ProtocolType protocolType, int i2, int i3, int i4, String str) {
        this.protocolType = ProtocolType.UNKNOW;
        this.cmd = i2;
        this.appId = i3;
        this.version = i4;
        this.jsonMsg = str;
        this.protocolType = protocolType;
        RLog.debug("PSCIMessageRequest", "request info: cmd = %d, appId = %d, version = %d, jsonMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        packageRequestJson();
    }

    private void packageHttpRequestJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", this.cmd);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("jsonMsg", this.jsonMsg);
            this.requestJson = jSONObject.toString();
        } catch (JSONException e2) {
            RLog.error("PSCIMessageSendRequest", "packageRequestJson error", e2);
        }
    }

    private void packageRequestJson() {
        ProtocolType protocolType = this.protocolType;
        if (protocolType == ProtocolType.HTTP) {
            packageHttpRequestJson();
        } else if (protocolType == ProtocolType.SERVICE) {
            this.requestJson = this.jsonMsg;
        } else {
            RLog.error("PSCIMessageSendRequest", "packageRequestJson ProtocolType error ", new Object[0]);
        }
    }

    public int getAppId() {
        return this.appId;
    }

    public int getCmd() {
        return this.cmd;
    }

    public String getJsonMsg() {
        return this.jsonMsg;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.RequestPacket
    public int getPacketSize() {
        String str = this.requestJson;
        if (str == null) {
            RLog.error("PSCIMessageRequest", "getPacketSize requestJson null", new Object[0]);
            return 0;
        }
        return str.getBytes().length + 4;
    }

    public String getRequestJson() {
        return this.requestJson;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.RequestPacket
    public void pushPacketData() {
        pushString32(this.requestJson);
    }

    public String toString() {
        return "PSCIMessageRequest{cmd=" + this.cmd + ", appId=" + this.appId + ", version=" + this.version + ", jsonMsg='" + this.jsonMsg + "'}";
    }

    public PSCIMessageSendRequest(byte[] bArr) {
        this.protocolType = ProtocolType.UNKNOW;
        unmarshall(bArr);
        try {
            String popString32 = popString32();
            JSONObject jSONObject = new JSONObject(popString32);
            this.cmd = jSONObject.optInt("cmd");
            this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.version = jSONObject.optInt("version");
            if (this.protocolType == ProtocolType.SERVICE) {
                this.jsonMsg = popString32;
            } else if (this.protocolType == ProtocolType.HTTP) {
                this.jsonMsg = jSONObject.optString("jsonMsg");
            } else {
                RLog.error("PSCIMessageSendRequest", "PSCIMessageSendRequest construct ProtocolType error ", new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
