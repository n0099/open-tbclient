package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;
/* loaded from: classes12.dex */
public class BaseWebViewRequestData implements Parcelable, Serializable {
    public static final Parcelable.Creator<BaseWebViewRequestData> CREATOR = new Parcelable.Creator<BaseWebViewRequestData>() { // from class: com.sina.weibo.sdk.web.BaseWebViewRequestData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseWebViewRequestData createFromParcel(Parcel parcel) {
            return new BaseWebViewRequestData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseWebViewRequestData[] newArray(int i) {
            return new BaseWebViewRequestData[i];
        }
    };
    private AuthInfo authInfo;
    private String callback;
    private int callbackType;
    private String specifyTitle;
    private WebRequestType type;
    private String url;

    public void setCallback(String str) {
        this.callback = str;
    }

    public String getCallback() {
        return this.callback;
    }

    public BaseWebViewRequestData(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3) {
        this(authInfo, webRequestType, str, 0, str2, str3);
    }

    public BaseWebViewRequestData(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3) {
        this.callbackType = 0;
        this.callback = str;
        this.authInfo = authInfo;
        this.type = webRequestType;
        this.specifyTitle = str2;
        this.url = str3;
        this.callbackType = i;
    }

    public int getCallbackType() {
        return this.callbackType;
    }

    public void setCallbackType(int i) {
        this.callbackType = i;
    }

    public String getSpecifyTitle() {
        return this.specifyTitle;
    }

    public void setSpecifyTitle(String str) {
        this.specifyTitle = str;
    }

    public String getUrl() {
        return this.url;
    }

    public AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public WebRequestType getType() {
        return this.type;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setAuthInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    public void setType(WebRequestType webRequestType) {
        this.type = webRequestType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeParcelable(this.authInfo, i);
        parcel.writeInt(this.type == null ? -1 : this.type.ordinal());
        parcel.writeString(this.callback);
        parcel.writeString(this.specifyTitle);
        parcel.writeInt(this.callbackType);
    }

    protected BaseWebViewRequestData(Parcel parcel) {
        this.callbackType = 0;
        this.url = parcel.readString();
        this.authInfo = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        int readInt = parcel.readInt();
        this.type = readInt == -1 ? null : WebRequestType.values()[readInt];
        this.callback = parcel.readString();
        this.specifyTitle = parcel.readString();
        this.callbackType = parcel.readInt();
    }
}
