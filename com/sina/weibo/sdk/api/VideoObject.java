package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VideoObject extends BaseMediaObject {
    public static final Parcelable.Creator<VideoObject> CREATOR = new Parcelable.Creator<VideoObject>() { // from class: com.sina.weibo.sdk.api.VideoObject.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoObject createFromParcel(Parcel parcel) {
            return new VideoObject(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoObject[] newArray(int i) {
            return new VideoObject[i];
        }
    };
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public String dataHdUrl;
    public String dataUrl;
    public String defaultText;
    public int duration;
    public String h5Url;

    public VideoObject() {
    }

    public VideoObject(Parcel parcel) {
        super(parcel);
        this.h5Url = parcel.readString();
        this.dataUrl = parcel.readString();
        this.dataHdUrl = parcel.readString();
        this.duration = parcel.readInt();
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.h5Url);
        parcel.writeString(this.dataUrl);
        parcel.writeString(this.dataHdUrl);
        parcel.writeInt(this.duration);
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        if (super.checkArgs()) {
            if (this.dataUrl != null && this.dataUrl.length() > 512) {
                LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataUrl is invalid");
                return false;
            } else if (this.dataHdUrl != null && this.dataHdUrl.length() > 512) {
                LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataHdUrl is invalid");
                return false;
            } else if (this.duration <= 0) {
                LogUtil.e("Weibo.VideoObject", "checkArgs fail, duration is invalid");
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public BaseMediaObject toExtraMediaObject(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.defaultText = new JSONObject(str).optString("extra_key_defaulttext");
            } catch (JSONException e) {
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public String toExtraMediaString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.defaultText)) {
                jSONObject.put("extra_key_defaulttext", this.defaultText);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
