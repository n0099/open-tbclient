package com.xiaomi.clientreport.data;

import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class EventClientReport extends a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public static EventClientReport getBlankInstance() {
        return new EventClientReport();
    }

    @Override // com.xiaomi.clientreport.data.a
    public JSONObject toJson() {
        JSONObject jSONObject = null;
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put(TbEnum.SystemMessage.KEY_EVENT_ID, this.eventId);
            json.put("eventType", this.eventType);
            json.put("eventTime", this.eventTime);
            json.put("eventContent", this.eventContent == null ? "" : this.eventContent);
            jSONObject = json;
            return jSONObject;
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return jSONObject;
        }
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        return super.toJsonString();
    }
}
