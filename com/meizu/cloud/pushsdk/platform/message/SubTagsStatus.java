package com.meizu.cloud.pushsdk.platform.message;

import c.k.a.a.a;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SubTagsStatus extends BasicPushStatus {
    public String pushId;
    public List<Tag> tagList;

    /* loaded from: classes2.dex */
    public class Tag implements Serializable {
        public int tagId;
        public String tagName;

        public Tag() {
        }

        public int getTagId() {
            return this.tagId;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void setTagId(int i2) {
            this.tagId = i2;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }

        public String toString() {
            return "Tag{tagId=" + this.tagId + ", tagName='" + this.tagName + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
    }

    public SubTagsStatus() {
    }

    public SubTagsStatus(String str) {
        super(str);
    }

    public String getPushId() {
        return this.pushId;
    }

    public List<Tag> getTagList() {
        return this.tagList;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("pushId")) {
            setPushId(jSONObject.getString("pushId"));
        }
        if (jSONObject.isNull(CommandMessage.TYPE_TAGS)) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(CommandMessage.TYPE_TAGS);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            Tag tag = new Tag();
            if (!jSONObject2.isNull("tagId")) {
                tag.tagId = jSONObject2.getInt("tagId");
            }
            if (!jSONObject2.isNull("tagName")) {
                tag.tagName = jSONObject2.getString("tagName");
            }
            arrayList.add(tag);
        }
        a.b(BasicPushStatus.TAG, "tags " + arrayList);
        setTagList(arrayList);
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setTagList(List<Tag> list) {
        this.tagList = list;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + " SubTagsStatus{pushId='" + this.pushId + ExtendedMessageFormat.QUOTE + ", tagList=" + this.tagList + ExtendedMessageFormat.END_FE;
    }
}
