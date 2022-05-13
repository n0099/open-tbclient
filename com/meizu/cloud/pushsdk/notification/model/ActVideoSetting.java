package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.repackage.tl9;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ActVideoSetting implements Parcelable {
    public static final String ACT_URL = "au";
    public static final String ACT_VIDEO_SETTING = "acts";
    public static final Parcelable.Creator<ActVideoSetting> CREATOR = new Parcelable.Creator<ActVideoSetting>() { // from class: com.meizu.cloud.pushsdk.notification.model.ActVideoSetting.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActVideoSetting createFromParcel(Parcel parcel) {
            return new ActVideoSetting(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActVideoSetting[] newArray(int i) {
            return new ActVideoSetting[i];
        }
    };
    public static final String TAG = "ActVideoSetting";
    public static final String WIFI_DISPLAY = "wd";
    public String actUrl;
    public boolean wifiDisplay;

    public ActVideoSetting() {
    }

    public ActVideoSetting(Parcel parcel) {
        this.wifiDisplay = parcel.readByte() != 0;
        this.actUrl = parcel.readString();
    }

    public static ActVideoSetting parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                tl9.b(TAG, "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static ActVideoSetting parse(JSONObject jSONObject) {
        String str;
        ActVideoSetting actVideoSetting = new ActVideoSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(WIFI_DISPLAY)) {
                    actVideoSetting.setWifiDisplay(jSONObject.getInt(WIFI_DISPLAY) != 0);
                }
                if (!jSONObject.isNull(ACT_URL)) {
                    actVideoSetting.setActUrl(jSONObject.getString(ACT_URL));
                }
            } catch (JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return actVideoSetting;
        }
        str = "no such tag ActVideoSetting";
        tl9.b(TAG, str);
        return actVideoSetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActUrl() {
        return this.actUrl;
    }

    public boolean isWifiDisplay() {
        return this.wifiDisplay;
    }

    public void setActUrl(String str) {
        this.actUrl = str;
    }

    public void setWifiDisplay(boolean z) {
        this.wifiDisplay = z;
    }

    public String toString() {
        return "ActVideoSetting{wifiDisplay=" + this.wifiDisplay + ", actUrl='" + this.actUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.wifiDisplay ? (byte) 1 : (byte) 0);
        parcel.writeString(this.actUrl);
    }
}
