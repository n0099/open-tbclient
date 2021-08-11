package com.meizu.cloud.pushsdk.notification;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class MPushMessage implements Serializable {
    public static final String TAG = "MPushMessage";
    public String clickType;
    public String content;
    public String isDiscard;
    public String notifyType;
    public String packageName;
    public String pushType;
    public String taskId;
    public String title;
    public Map<String, String> extra = new HashMap();
    public Map<String, String> params = new HashMap();

    public static Map<String, String> getParamsMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public static MPushMessage parsePushMessage(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        MPushMessage mPushMessage = new MPushMessage();
        try {
            mPushMessage.setTaskId(str4);
            mPushMessage.setPushType(str);
            mPushMessage.setPackageName(str3);
            JSONObject jSONObject2 = new JSONObject(str2).getJSONObject("data");
            if (!jSONObject2.isNull("content")) {
                mPushMessage.setContent(jSONObject2.getString("content"));
            }
            if (!jSONObject2.isNull(PushConstants.IS_DISCARD)) {
                mPushMessage.setIsDiscard(jSONObject2.getString(PushConstants.IS_DISCARD));
            }
            if (!jSONObject2.isNull("title")) {
                mPushMessage.setTitle(jSONObject2.getString("title"));
            }
            if (!jSONObject2.isNull(PushConstants.CLICK_TYPE)) {
                mPushMessage.setClickType(jSONObject2.getString(PushConstants.CLICK_TYPE));
            }
            if (!jSONObject2.isNull("extra") && (jSONObject = jSONObject2.getJSONObject("extra")) != null) {
                if (!jSONObject.isNull(PushConstants.PARAMS)) {
                    try {
                        JSONObject jSONObject3 = jSONObject.getJSONObject(PushConstants.PARAMS);
                        if (jSONObject3 != null) {
                            mPushMessage.setParams(getParamsMap(jSONObject3));
                        }
                    } catch (JSONException e2) {
                        c.l.a.a.a.d(TAG, "parameter parse error message " + e2.getMessage());
                    }
                    jSONObject.remove(PushConstants.PARAMS);
                }
                mPushMessage.setExtra(getParamsMap(jSONObject));
            }
        } catch (JSONException e3) {
            c.l.a.a.a.d(TAG, "parse push message error " + e3.getMessage());
        }
        c.l.a.a.a.d(TAG, " parsePushMessage " + mPushMessage);
        return mPushMessage;
    }

    public String getClickType() {
        return this.clickType;
    }

    public String getContent() {
        return this.content;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String getIsDiscard() {
        return this.isDiscard;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public String getPushType() {
        return this.pushType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setClickType(String str) {
        this.clickType = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExtra(Map<String, String> map) {
        this.extra = map;
    }

    public void setIsDiscard(String str) {
        this.isDiscard = str;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public void setPushType(String str) {
        this.pushType = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MPushMessage{taskId='" + this.taskId + ExtendedMessageFormat.QUOTE + ", pushType='" + this.pushType + ExtendedMessageFormat.QUOTE + ", packageName='" + this.packageName + ExtendedMessageFormat.QUOTE + ", title='" + this.title + ExtendedMessageFormat.QUOTE + ", content='" + this.content + ExtendedMessageFormat.QUOTE + ", notifyType='" + this.notifyType + ExtendedMessageFormat.QUOTE + ", clickType='" + this.clickType + ExtendedMessageFormat.QUOTE + ", isDiscard='" + this.isDiscard + ExtendedMessageFormat.QUOTE + ", extra=" + this.extra + ", params=" + this.params + ExtendedMessageFormat.END_FE;
    }
}
