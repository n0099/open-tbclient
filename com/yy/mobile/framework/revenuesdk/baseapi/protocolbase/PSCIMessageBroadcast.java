package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PSCIMessageBroadcast extends ResponsePacket {
    public JSONObject data;
    public String jsonData;
    public long uri;

    public PSCIMessageBroadcast(String str) {
        this.jsonData = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.data = jSONObject;
            this.uri = jSONObject.optLong("uri", 0L);
        } catch (Exception e2) {
            RLog.error("PSCIMessageBroadcast", "popPacketData error.", e2);
        }
    }

    public JSONObject getData() {
        return this.data;
    }

    public String getJsonData() {
        return this.jsonData;
    }

    public long getUri() {
        return this.uri;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.ResponsePacket
    public void popPacketData() {
        try {
            this.jsonData = popStingWithOutLength();
            JSONObject jSONObject = new JSONObject(this.jsonData);
            this.data = jSONObject;
            this.uri = jSONObject.optLong("uri", 0L);
        } catch (Exception e2) {
            RLog.error("PSCIMessageBroadcast", "popPacketData error.", e2);
        }
    }

    public void setUri(long j) {
        this.uri = j;
    }

    public String toString() {
        return "PSCIMessageBroadcast{uri=" + this.uri + '}';
    }
}
