package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class AdvanceSetting implements Parcelable {
    public static final String ADVANCE_SETTING = "as";
    public static final String CLEAR_NOTIFICATION = "cn";
    public static final Parcelable.Creator<AdvanceSetting> CREATOR = new Parcelable.Creator<AdvanceSetting>() { // from class: com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvanceSetting createFromParcel(Parcel parcel) {
            return new AdvanceSetting(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvanceSetting[] newArray(int i) {
            return new AdvanceSetting[i];
        }
    };
    public static final String HEAD_UP_NOTIFICATION = "hn";
    public static final String NETWORK_TYPE = "it";
    public static final String NOTIFY_TYPE = "nt";
    public static final String TAG = "advance_setting";
    private boolean clearNotification;
    private boolean headUpNotification;
    private int netWorkType;
    private NotifyType notifyType;

    public AdvanceSetting() {
        this.netWorkType = 1;
        this.clearNotification = true;
        this.headUpNotification = true;
    }

    public AdvanceSetting(Parcel parcel) {
        this.netWorkType = 1;
        this.clearNotification = true;
        this.headUpNotification = true;
        this.netWorkType = parcel.readInt();
        this.notifyType = (NotifyType) parcel.readParcelable(NotifyType.class.getClassLoader());
        this.clearNotification = parcel.readByte() != 0;
        this.headUpNotification = parcel.readByte() != 0;
    }

    public static AdvanceSetting parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e(TAG, "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static AdvanceSetting parse(JSONObject jSONObject) {
        AdvanceSetting advanceSetting = new AdvanceSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(NETWORK_TYPE)) {
                    advanceSetting.setNetWorkType(jSONObject.getInt(NETWORK_TYPE));
                }
                if (!jSONObject.isNull("nt")) {
                    advanceSetting.setNotifyType(NotifyType.parse(jSONObject.getJSONObject("nt")));
                }
                if (!jSONObject.isNull(CLEAR_NOTIFICATION)) {
                    advanceSetting.setClearNotification(jSONObject.getInt(CLEAR_NOTIFICATION) != 0);
                }
                if (!jSONObject.isNull(HEAD_UP_NOTIFICATION)) {
                    advanceSetting.setHeadUpNotification(jSONObject.getInt(HEAD_UP_NOTIFICATION) != 0);
                }
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e(TAG, "parse json obj error " + e.getMessage());
            }
        } else {
            com.meizu.cloud.a.a.e(TAG, "no such tag advance_setting");
        }
        return advanceSetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getNetWorkType() {
        return this.netWorkType;
    }

    public NotifyType getNotifyType() {
        return this.notifyType;
    }

    public boolean isClearNotification() {
        return this.clearNotification;
    }

    public boolean isHeadUpNotification() {
        return this.headUpNotification;
    }

    public void setClearNotification(boolean z) {
        this.clearNotification = z;
    }

    public void setHeadUpNotification(boolean z) {
        this.headUpNotification = z;
    }

    public void setNetWorkType(int i) {
        this.netWorkType = i;
    }

    public void setNotifyType(NotifyType notifyType) {
        this.notifyType = notifyType;
    }

    public String toString() {
        return "AdvanceSetting{netWorkType=" + this.netWorkType + ", notifyType=" + this.notifyType + ", clearNotification=" + this.clearNotification + ", headUpNotification=" + this.headUpNotification + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.netWorkType);
        parcel.writeParcelable(this.notifyType, i);
        parcel.writeByte((byte) (this.clearNotification ? 1 : 0));
        parcel.writeByte((byte) (this.headUpNotification ? 1 : 0));
    }
}
