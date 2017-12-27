package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NotifyType implements Parcelable {
    public static final Parcelable.Creator<NotifyType> CREATOR = new Parcelable.Creator<NotifyType>() { // from class: com.meizu.cloud.pushsdk.notification.model.NotifyType.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotifyType createFromParcel(Parcel parcel) {
            return new NotifyType(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotifyType[] newArray(int i) {
            return new NotifyType[i];
        }
    };
    public static final String LIGHTS = "l";
    public static final String NOTIFY_TYPE = "nt";
    public static final String SOUND = "s";
    public static final String TAG = "notify_type";
    public static final String VIBRATE = "v";
    boolean lights;
    boolean sound;
    boolean vibrate;

    public NotifyType() {
    }

    public NotifyType(Parcel parcel) {
        this.vibrate = parcel.readByte() != 0;
        this.lights = parcel.readByte() != 0;
        this.sound = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.vibrate ? 1 : 0));
        parcel.writeByte((byte) (this.lights ? 1 : 0));
        parcel.writeByte((byte) (this.sound ? 1 : 0));
    }

    public boolean isVibrate() {
        return this.vibrate;
    }

    public void setVibrate(boolean z) {
        this.vibrate = z;
    }

    public boolean isLights() {
        return this.lights;
    }

    public void setLights(boolean z) {
        this.lights = z;
    }

    public boolean isSound() {
        return this.sound;
    }

    public void setSound(boolean z) {
        this.sound = z;
    }

    public static NotifyType parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                a.e("notify_type", "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static NotifyType parse(JSONObject jSONObject) {
        NotifyType notifyType = new NotifyType();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(VIBRATE)) {
                    notifyType.setVibrate(jSONObject.getInt(VIBRATE) != 0);
                }
                if (!jSONObject.isNull(LIGHTS)) {
                    notifyType.setLights(jSONObject.getInt(LIGHTS) != 0);
                }
                if (!jSONObject.isNull(SOUND)) {
                    notifyType.setSound(jSONObject.getInt(SOUND) != 0);
                }
            } catch (JSONException e) {
                a.e("notify_type", "parse json obj error " + e.getMessage());
            }
        } else {
            a.e("notify_type", "no such tag notify_type");
        }
        return notifyType;
    }

    public String toString() {
        return "NotifyType{vibrate=" + this.vibrate + ", lights=" + this.lights + ", sound=" + this.sound + '}';
    }
}
