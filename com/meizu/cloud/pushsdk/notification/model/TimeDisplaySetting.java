package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class TimeDisplaySetting implements Parcelable {
    public static final Parcelable.Creator<TimeDisplaySetting> CREATOR = new Parcelable.Creator<TimeDisplaySetting>() { // from class: com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeDisplaySetting createFromParcel(Parcel parcel) {
            return new TimeDisplaySetting(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeDisplaySetting[] newArray(int i) {
            return new TimeDisplaySetting[i];
        }
    };
    public static final String END_SHOW_TIME = "et";
    public static final String START_SHOW_TIME = "st";
    public static final String TAG = "time_display_setting";
    public static final String TIME_DISPLAY = "td";
    public static final String TIME_DISPLAY_SETTING = "ts";
    private String endShowTime;
    private boolean isTimeDisplay;
    private String startShowTime;

    public TimeDisplaySetting() {
    }

    public TimeDisplaySetting(Parcel parcel) {
        this.isTimeDisplay = parcel.readByte() != 0;
        this.startShowTime = parcel.readString();
        this.endShowTime = parcel.readString();
    }

    public static TimeDisplaySetting parse(String str) {
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

    public static TimeDisplaySetting parse(JSONObject jSONObject) {
        TimeDisplaySetting timeDisplaySetting = new TimeDisplaySetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("td")) {
                    timeDisplaySetting.setIsTimeDisplay(jSONObject.getInt("td") != 0);
                }
                if (!jSONObject.isNull("st")) {
                    timeDisplaySetting.setStartShowTime(jSONObject.getString("st"));
                }
                if (!jSONObject.isNull("et")) {
                    timeDisplaySetting.setEndShowTime(jSONObject.getString("et"));
                }
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e(TAG, "parse json obj error " + e.getMessage());
            }
        } else {
            com.meizu.cloud.a.a.e(TAG, "no such tag time_display_setting");
        }
        return timeDisplaySetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEndShowTime() {
        return this.endShowTime;
    }

    public String getStartShowTime() {
        return this.startShowTime;
    }

    public boolean isTimeDisplay() {
        return this.isTimeDisplay;
    }

    public void setEndShowTime(String str) {
        this.endShowTime = str;
    }

    public void setIsTimeDisplay(boolean z) {
        this.isTimeDisplay = z;
    }

    public void setStartShowTime(String str) {
        this.startShowTime = str;
    }

    public String toString() {
        return "TimeDisplaySetting{isTimeDisplay=" + this.isTimeDisplay + ", startShowTime='" + this.startShowTime + "', endShowTime='" + this.endShowTime + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.isTimeDisplay ? 1 : 0));
        parcel.writeString(this.startShowTime);
        parcel.writeString(this.endShowTime);
    }
}
