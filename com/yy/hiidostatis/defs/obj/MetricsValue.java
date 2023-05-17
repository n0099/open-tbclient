package com.yy.hiidostatis.defs.obj;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.yy.hiidostatis.inner.util.log.L;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class MetricsValue implements IJsonSerialize {
    public Map<String, String> extra;
    public int scode;
    public String topic;
    public String uri;
    public long val;

    public MetricsValue() {
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public int getScode() {
        return this.scode;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUri() {
        return this.uri;
    }

    public long getVal() {
        return this.val;
    }

    public MetricsValue(int i, String str, String str2, long j, Map<String, String> map) {
        this.scode = i;
        this.uri = str;
        this.topic = str2;
        this.val = j;
        this.extra = map;
    }

    public void setExtra(Map<String, String> map) {
        this.extra = map;
    }

    public void setScode(int i) {
        this.scode = i;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setVal(long j) {
        this.val = j;
    }

    @Override // com.yy.hiidostatis.defs.obj.IJsonSerialize
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scode", this.scode);
            jSONObject.put("uri", URLEncoder.encode(this.uri, IMAudioTransRequest.CHARSET));
            jSONObject.put("topic", URLEncoder.encode(this.topic, IMAudioTransRequest.CHARSET));
            jSONObject.put("val", this.val);
            if (this.extra != null && !this.extra.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : this.extra.entrySet()) {
                    jSONObject2.put(URLEncoder.encode(entry.getKey(), IMAudioTransRequest.CHARSET), URLEncoder.encode(entry.getValue(), IMAudioTransRequest.CHARSET));
                }
                jSONObject.put("extra", jSONObject2);
            } else {
                jSONObject.put("extra", new JSONObject());
            }
            return jSONObject;
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
            return null;
        }
    }
}
