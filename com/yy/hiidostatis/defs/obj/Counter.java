package com.yy.hiidostatis.defs.obj;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class Counter implements IJsonSerialize, Cloneable {
    public String counterName;
    public int invokeCount;
    public int scode;
    public String uri;
    public long value;

    public Counter(int i, String str, String str2) {
        this.scode = i;
        this.uri = str;
        this.counterName = str2;
    }

    public Object clone() {
        Counter counter = new Counter(this.scode, this.uri, this.counterName);
        counter.value = this.value;
        counter.invokeCount = this.invokeCount;
        return counter;
    }

    public int getInvokeCount() {
        return this.invokeCount;
    }

    public String getKey() {
        return String.format("%d&%s&%s", Integer.valueOf(this.scode), this.uri, this.counterName);
    }

    public long getValue() {
        return this.value;
    }

    public synchronized void count(long j, int i) {
        this.value += j;
        this.invokeCount += i;
    }

    @Override // com.yy.hiidostatis.defs.obj.IJsonSerialize
    public JSONObject toJson() {
        long j;
        long j2;
        synchronized (this) {
            j = this.value;
            j2 = this.invokeCount;
        }
        if (j == 0 && j2 == 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scode", this.scode);
            jSONObject.put("uri", URLEncoder.encode(this.uri, IMAudioTransRequest.CHARSET));
            jSONObject.put("counterName", URLEncoder.encode(this.counterName, IMAudioTransRequest.CHARSET));
            jSONObject.put("value", j);
            jSONObject.put("invokecount", (int) j2);
            return jSONObject;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
