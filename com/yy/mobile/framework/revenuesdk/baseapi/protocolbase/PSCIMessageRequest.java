package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PSCIMessageRequest extends RequestPacket {
    public static final String TAG = "PSCIMessageRequest";
    public int appId;
    public int cmd;
    public String jsonMsg;
    public ProtocolType protocolType;
    public String requestJson;
    public String ticket;
    public String traceid;
    public int version;

    public PSCIMessageRequest(ProtocolType protocolType, int i, int i2, int i3, String str, String str2, String str3) {
        this.protocolType = ProtocolType.UNKNOW;
        this.cmd = i;
        this.appId = i2;
        this.version = i3;
        this.ticket = str;
        this.traceid = str2;
        this.jsonMsg = str3;
        this.protocolType = protocolType;
        RLog.debug(TAG, "request info: cmd = " + i + " appId = " + i2 + " traceid =" + str2 + " jsonMsg =" + str3);
        packageRequestJson();
    }

    public PSCIMessageRequest(byte[] bArr, ProtocolType protocolType) {
        this.protocolType = ProtocolType.UNKNOW;
        this.protocolType = protocolType;
        unmarshall(bArr);
        try {
            String popString32 = popString32();
            JSONObject jSONObject = new JSONObject(popString32);
            this.cmd = jSONObject.optInt("cmd");
            this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.version = jSONObject.optInt("version");
            this.ticket = jSONObject.optString("ticket");
            this.traceid = jSONObject.optString("traceId");
            if (protocolType == ProtocolType.SERVICE) {
                this.jsonMsg = popString32;
            } else if (protocolType == ProtocolType.HTTP) {
                this.jsonMsg = jSONObject.optString("jsonMsg");
            } else {
                RLog.error(TAG, "PSCIMessageRequest construct ProtocolType error ", new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void packageHttpRequestJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", this.cmd);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("ticket", this.ticket);
            jSONObject.put("traceid", this.traceid);
            jSONObject.put("jsonMsg", this.jsonMsg);
            this.requestJson = jSONObject.toString();
        } catch (JSONException e) {
            RLog.error(TAG, "packageRequestJson error", e);
        }
    }

    public String toString() {
        return "PSCIMessageRequest{cmd=" + this.cmd + ", appId=" + this.appId + ", version=" + this.version + ", traceid=" + this.traceid + ", jsonMsg='" + this.jsonMsg + "'}";
    }

    private void packageRequestJson() {
        ProtocolType protocolType = this.protocolType;
        if (protocolType == ProtocolType.HTTP) {
            packageHttpRequestJson();
        } else if (protocolType == ProtocolType.SERVICE) {
            this.requestJson = this.jsonMsg;
        } else {
            RLog.error(TAG, "packageRequestJson ProtocolType error ", new Object[0]);
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
            RLog.error(TAG, "getPacketSize requestJson null", new Object[0]);
            return 0;
        }
        return str.getBytes().length + 4;
    }

    public String getRequestJson() {
        return this.requestJson;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getTraceid() {
        return this.traceid;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.RequestPacket
    public void pushPacketData() {
        pushString32(this.requestJson);
    }

    public void setTicket(String str) {
        this.ticket = str;
    }
}
