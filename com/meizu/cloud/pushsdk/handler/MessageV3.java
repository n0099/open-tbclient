package com.meizu.cloud.pushsdk.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MessageV3 implements Parcelable {
    public static final Parcelable.Creator<MessageV3> CREATOR = new Parcelable.Creator<MessageV3>() { // from class: com.meizu.cloud.pushsdk.handler.MessageV3.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageV3 createFromParcel(Parcel parcel) {
            return new MessageV3(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageV3[] newArray(int i) {
            return new MessageV3[i];
        }
    };
    private static final String TAG = "Message_V3";
    private String activity;
    private int clickType;
    private String content;
    private String deviceId;
    private boolean isDiscard;
    private AdvanceSetting mAdvanceSetting;
    private AppIconSetting mAppIconSetting;
    private NotificationStyle mNotificationStyle;
    private TimeDisplaySetting mTimeDisplaySetting;
    private String notificationMessage;
    private String packageName;
    private Map<String, String> paramsMap;
    private String pushTimestamp;
    private String seqId;
    private String taskId;
    private String throughMessage;
    private String title;
    private String uploadDataPackageName;
    private String uriPackageName;
    private String webUrl;

    public MessageV3(Parcel parcel) {
        this.paramsMap = new HashMap();
        this.taskId = parcel.readString();
        this.seqId = parcel.readString();
        this.deviceId = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.packageName = parcel.readString();
        this.clickType = parcel.readInt();
        this.isDiscard = parcel.readByte() != 0;
        this.activity = parcel.readString();
        this.webUrl = parcel.readString();
        this.uriPackageName = parcel.readString();
        this.uploadDataPackageName = parcel.readString();
        this.pushTimestamp = parcel.readString();
        this.paramsMap = parcel.readHashMap(getClass().getClassLoader());
        this.throughMessage = parcel.readString();
        this.notificationMessage = parcel.readString();
        this.mAdvanceSetting = (AdvanceSetting) parcel.readParcelable(AdvanceSetting.class.getClassLoader());
        this.mAppIconSetting = (AppIconSetting) parcel.readParcelable(AppIconSetting.class.getClassLoader());
        this.mNotificationStyle = (NotificationStyle) parcel.readParcelable(NotificationStyle.class.getClassLoader());
        this.mTimeDisplaySetting = (TimeDisplaySetting) parcel.readParcelable(TimeDisplaySetting.class.getClassLoader());
    }

    public MessageV3() {
        this.paramsMap = new HashMap();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.taskId);
        parcel.writeString(this.seqId);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.clickType);
        parcel.writeByte((byte) (this.isDiscard ? 1 : 0));
        parcel.writeString(this.activity);
        parcel.writeString(this.webUrl);
        parcel.writeString(this.uriPackageName);
        parcel.writeString(this.uploadDataPackageName);
        parcel.writeString(this.pushTimestamp);
        parcel.writeMap(this.paramsMap);
        parcel.writeString(this.throughMessage);
        parcel.writeString(this.notificationMessage);
        parcel.writeParcelable(this.mAdvanceSetting, i);
        parcel.writeParcelable(this.mAppIconSetting, i);
        parcel.writeParcelable(this.mNotificationStyle, i);
        parcel.writeParcelable(this.mTimeDisplaySetting, i);
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public AdvanceSetting getmAdvanceSetting() {
        return this.mAdvanceSetting;
    }

    public void setmAdvanceSetting(AdvanceSetting advanceSetting) {
        this.mAdvanceSetting = advanceSetting;
    }

    public AppIconSetting getmAppIconSetting() {
        return this.mAppIconSetting;
    }

    public void setmAppIconSetting(AppIconSetting appIconSetting) {
        this.mAppIconSetting = appIconSetting;
    }

    public NotificationStyle getmNotificationStyle() {
        return this.mNotificationStyle;
    }

    public void setmNotificationStyle(NotificationStyle notificationStyle) {
        this.mNotificationStyle = notificationStyle;
    }

    public TimeDisplaySetting getmTimeDisplaySetting() {
        return this.mTimeDisplaySetting;
    }

    public void setmTimeDisplaySetting(TimeDisplaySetting timeDisplaySetting) {
        this.mTimeDisplaySetting = timeDisplaySetting;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public int getClickType() {
        return this.clickType;
    }

    public void setClickType(int i) {
        this.clickType = i;
    }

    public boolean isDiscard() {
        return this.isDiscard;
    }

    public void setIsDiscard(boolean z) {
        this.isDiscard = z;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String str) {
        this.activity = str;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public String getUriPackageName() {
        return this.uriPackageName;
    }

    public void setUriPackageName(String str) {
        this.uriPackageName = str;
    }

    public String getPushTimestamp() {
        return this.pushTimestamp;
    }

    public void setPushTimestamp(String str) {
        this.pushTimestamp = str;
    }

    public Map<String, String> getParamsMap() {
        return this.paramsMap;
    }

    public void setParamsMap(Map<String, String> map) {
        this.paramsMap = map;
    }

    public String getThroughMessage() {
        return this.throughMessage;
    }

    public void setThroughMessage(String str) {
        this.throughMessage = str;
    }

    public String getNotificationMessage() {
        return this.notificationMessage;
    }

    public void setNotificationMessage(String str) {
        this.notificationMessage = str;
    }

    public String getSeqId() {
        return this.seqId;
    }

    public void setSeqId(String str) {
        this.seqId = str;
    }

    public String getUploadDataPackageName() {
        return this.uploadDataPackageName;
    }

    public void setUploadDataPackageName(String str) {
        this.uploadDataPackageName = str;
    }

    public static MessageV3 parse(String str, String str2, String str3, MPushMessage mPushMessage) {
        com.meizu.cloud.a.a.e(TAG, "V2 message " + mPushMessage);
        MessageV3 messageV3 = new MessageV3();
        messageV3.setPackageName(str);
        messageV3.setUploadDataPackageName(str);
        messageV3.setDeviceId(str2);
        messageV3.setTaskId(str3);
        messageV3.setTitle(mPushMessage.getTitle());
        messageV3.setContent(mPushMessage.getContent());
        messageV3.setIsDiscard("true".equals(mPushMessage.getIsDiscard()));
        messageV3.setClickType(Integer.valueOf(mPushMessage.getClickType()).intValue());
        for (Map.Entry<String, String> entry : mPushMessage.getExtra().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (PushConstants.INTENT_ACTIVITY_NAME.equals(key)) {
                messageV3.setActivity(value);
            }
            if ("url".equals(key)) {
                messageV3.setWebUrl(value);
            }
            if (PushConstants.URI_PACKAGE_NAME.equals(key)) {
                messageV3.setUriPackageName(value);
            }
            if (NotificationStyle.NOTIFICATION_STYLE.equals(key)) {
                messageV3.setmNotificationStyle(NotificationStyle.parse(value));
            }
            if (AdvanceSetting.ADVANCE_SETTING.equals(key)) {
                messageV3.setmAdvanceSetting(AdvanceSetting.parse(value));
            }
            if ("is".equals(key)) {
                messageV3.setmAppIconSetting(AppIconSetting.parse(value));
            }
            if (TimeDisplaySetting.TIME_DISPLAY_SETTING.equals(key)) {
                messageV3.setmTimeDisplaySetting(TimeDisplaySetting.parse(value));
            }
        }
        messageV3.setParamsMap(mPushMessage.getParams());
        com.meizu.cloud.a.a.i(TAG, "parase V2 message to V3 message " + messageV3);
        return messageV3;
    }

    public static MessageV3 parse(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        MessageV3 parse = parse(str, str4, str5, str6, str7);
        parse.setUploadDataPackageName(str2);
        parse.setPushTimestamp(str3);
        return parse;
    }

    public static MessageV3 parse(String str, String str2, String str3, String str4, String str5) {
        MessageV3 parse = parse(str, str2, str3, str5);
        parse.setSeqId(str4);
        return parse;
    }

    public static MessageV3 parse(String str, String str2, String str3, String str4) {
        MessageV3 messageV3 = new MessageV3();
        messageV3.setNotificationMessage(str4);
        messageV3.setTaskId(str3);
        messageV3.setDeviceId(str2);
        messageV3.setPackageName(str);
        try {
            JSONObject jSONObject = new JSONObject(str4).getJSONObject("data");
            if (!jSONObject.isNull("title")) {
                messageV3.setTitle(jSONObject.getString("title"));
            }
            if (!jSONObject.isNull("content")) {
                messageV3.setContent(jSONObject.getString("content"));
            }
            if (!jSONObject.isNull(PushConstants.IS_DISCARD)) {
                messageV3.setIsDiscard(jSONObject.getBoolean(PushConstants.IS_DISCARD));
            }
            if (!jSONObject.isNull(PushConstants.CLICK_TYPE)) {
                messageV3.setClickType(jSONObject.getInt(PushConstants.CLICK_TYPE));
            }
            if (!jSONObject.isNull("extra")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                if (!jSONObject2.isNull(NotificationStyle.NOTIFICATION_STYLE)) {
                    messageV3.setmNotificationStyle(NotificationStyle.parse(jSONObject2.getJSONObject(NotificationStyle.NOTIFICATION_STYLE)));
                }
                if (!jSONObject2.isNull("is")) {
                    messageV3.setmAppIconSetting(AppIconSetting.parse(jSONObject2.getJSONObject("is")));
                }
                if (!jSONObject2.isNull(AdvanceSetting.ADVANCE_SETTING)) {
                    messageV3.setmAdvanceSetting(AdvanceSetting.parse(jSONObject2.getJSONObject(AdvanceSetting.ADVANCE_SETTING)));
                }
                if (!jSONObject2.isNull(TimeDisplaySetting.TIME_DISPLAY_SETTING)) {
                    messageV3.setmTimeDisplaySetting(TimeDisplaySetting.parse(jSONObject2.getJSONObject(TimeDisplaySetting.TIME_DISPLAY_SETTING)));
                }
                if (!jSONObject2.isNull(PushConstants.INTENT_ACTIVITY_NAME)) {
                    messageV3.setActivity(jSONObject2.getString(PushConstants.INTENT_ACTIVITY_NAME));
                }
                if (!jSONObject2.isNull("url")) {
                    messageV3.setWebUrl(jSONObject2.getString("url"));
                }
                if (!jSONObject2.isNull("task_id") && TextUtils.isEmpty(str3)) {
                    com.meizu.cloud.a.a.e(TAG, "Flyme 4 notification message by through message or taskId is null");
                    messageV3.setTaskId(jSONObject2.getString("task_id"));
                }
                if (!jSONObject2.isNull(PushConstants.URI_PACKAGE_NAME)) {
                    messageV3.setUriPackageName(jSONObject2.getString(PushConstants.URI_PACKAGE_NAME));
                }
                if (!jSONObject2.isNull(PushConstants.PARAMS)) {
                    messageV3.setParamsMap(getParamsMap(jSONObject2.getJSONObject(PushConstants.PARAMS)));
                }
            }
        } catch (JSONException e) {
            com.meizu.cloud.a.a.e(TAG, "parse message error " + e.getMessage());
        }
        return messageV3;
    }

    public static Map<String, String> getParamsMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public String toString() {
        return "MessageV3{taskId='" + this.taskId + "', seqId='" + this.seqId + "', deviceId='" + this.deviceId + "', title='" + this.title + "', content='" + this.content + "', packageName='" + this.packageName + "', clickType=" + this.clickType + ", isDiscard=" + this.isDiscard + ", activity='" + this.activity + "', webUrl='" + this.webUrl + "', uriPackageName='" + this.uriPackageName + "', pushTimestamp='" + this.pushTimestamp + "', uploadDataPackageName='" + this.uploadDataPackageName + "', paramsMap=" + this.paramsMap + ", throughMessage='" + this.throughMessage + "', notificationMessage='" + this.notificationMessage + "', mAdvanceSetting=" + this.mAdvanceSetting + ", mAppIconSetting=" + this.mAppIconSetting + ", mNotificationStyle=" + this.mNotificationStyle + ", mTimeDisplaySetting=" + this.mTimeDisplaySetting + '}';
    }
}
