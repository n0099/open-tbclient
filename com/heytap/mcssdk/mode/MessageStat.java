package com.heytap.mcssdk.mode;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MessageStat {
    public static final String APP_PACKAGE = "appPackage";
    public static final String EVENT_ID = "eventID";
    public static final String EVENT_TIME = "eventTime";
    public static final String GLOBAL_ID = "globalID";
    public static final String MESSAGE_TYPE = "messageType";
    public static final String PROPERTY = "property";
    public static final String TASK_ID = "taskID";
    public String mAppPackage;
    public String mEventId;
    public long mEventTime;
    public String mGlobalId;
    public String mProperty;
    public String mTaskID;
    public int mType;

    public MessageStat() {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
    }

    public MessageStat(int i2, String str, String str2, String str3) {
        this(i2, str, null, null, str2, str3);
    }

    public MessageStat(int i2, String str, String str2, String str3, String str4, String str5) {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
        setType(i2);
        setAppPackage(str);
        setGlobalId(str2);
        setTaskID(str3);
        setEventId(str4);
        setProperty(str5);
    }

    public MessageStat(String str, String str2) {
        this(4096, str, null, null, str2, "");
    }

    public MessageStat(String str, String str2, String str3) {
        this(4096, str, null, null, str2, str3);
    }

    public static MessageStat parse(String str) {
        MessageStat messageStat = new MessageStat();
        try {
            JSONObject jSONObject = new JSONObject(str);
            messageStat.setType(jSONObject.optInt("messageType", 0));
            messageStat.setAppPackage(jSONObject.optString("appPackage"));
            messageStat.setEventId(jSONObject.optString("eventID"));
            messageStat.setGlobalId(jSONObject.optString("globalID", ""));
            messageStat.setTaskID(jSONObject.optString("taskID", ""));
            messageStat.setProperty(jSONObject.optString(PROPERTY, ""));
            messageStat.setEventTime(jSONObject.optLong(EVENT_TIME, System.currentTimeMillis()));
            return messageStat;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getEventId() {
        return this.mEventId;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public String getGlobalId() {
        return this.mGlobalId;
    }

    public String getProperty() {
        return this.mProperty;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public int getType() {
        return this.mType;
    }

    public void setAppPackage(String str) {
        this.mAppPackage = str;
    }

    public void setEventId(String str) {
        this.mEventId = str;
    }

    public void setEventTime(long j) {
        this.mEventTime = j;
    }

    public void setGlobalId(String str) {
        this.mGlobalId = str;
    }

    public void setProperty(String str) {
        this.mProperty = str;
    }

    public void setTaskID(int i2) {
        this.mTaskID = String.valueOf(i2);
    }

    public void setTaskID(String str) {
        this.mTaskID = str;
    }

    public void setType(int i2) {
        this.mType = i2;
    }

    public String toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("messageType", Integer.valueOf(this.mType));
            jSONObject.putOpt("eventID", this.mEventId);
            jSONObject.putOpt("appPackage", this.mAppPackage);
            jSONObject.putOpt(EVENT_TIME, Long.valueOf(this.mEventTime));
            if (!TextUtils.isEmpty(this.mGlobalId)) {
                jSONObject.putOpt("globalID", this.mGlobalId);
            }
            if (!TextUtils.isEmpty(this.mTaskID)) {
                jSONObject.putOpt("taskID", this.mTaskID);
            }
            if (!TextUtils.isEmpty(this.mProperty)) {
                jSONObject.putOpt(PROPERTY, this.mProperty);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
