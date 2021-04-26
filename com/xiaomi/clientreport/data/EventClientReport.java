package com.xiaomi.clientreport.data;

import com.baidu.tbadk.core.util.TbEnum;
import com.heytap.mcssdk.mode.MessageStat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put(TbEnum.SystemMessage.KEY_EVENT_ID, this.eventId);
            json.put("eventType", this.eventType);
            json.put(MessageStat.EVENT_TIME, this.eventTime);
            json.put("eventContent", this.eventContent == null ? "" : this.eventContent);
            return json;
        } catch (JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        return super.toJsonString();
    }
}
