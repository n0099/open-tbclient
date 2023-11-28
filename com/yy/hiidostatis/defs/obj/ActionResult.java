package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.log.L;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ActionResult implements IJsonSerialize {
    public Map<String, String> moreinfo;
    public long reqTime;
    public String ret;
    public long rtime;
    public int scode;
    public String uri;

    public ActionResult(int i, String str, long j, String str2) {
        this.scode = i;
        this.uri = str;
        this.reqTime = j;
        this.ret = str2;
        this.rtime = System.currentTimeMillis();
    }

    public ActionResult(int i, String str, long j, String str2, Map<String, String> map) {
        this(i, str, j, str2);
        this.moreinfo = map;
    }

    @Override // com.yy.hiidostatis.defs.obj.IJsonSerialize
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scode", this.scode);
            jSONObject.put("uri", URLEncoder.encode(this.uri, "utf-8"));
            jSONObject.put("reqtime", this.reqTime);
            jSONObject.put("ret", URLEncoder.encode(this.ret, "utf-8"));
            jSONObject.put("rtime", this.rtime);
            if (this.moreinfo != null && !this.moreinfo.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : this.moreinfo.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("moreinfo", jSONObject2);
            }
            return jSONObject;
        } catch (Exception e) {
            L.debug(this, e.getMessage(), new Object[0]);
            return null;
        }
    }
}
