package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.Utility;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class AuthInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<AuthInfo> CREATOR = new Parcelable.Creator<AuthInfo>() { // from class: com.sina.weibo.sdk.auth.AuthInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthInfo createFromParcel(Parcel parcel) {
            return new AuthInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthInfo[] newArray(int i2) {
            return new AuthInfo[i2];
        }
    };
    public String mAppKey;
    public String mKeyHash;
    public String mPackageName;
    public String mRedirectUrl;
    public String mScope;

    public AuthInfo(Context context, String str, String str2, String str3) {
        this.mAppKey = "";
        this.mRedirectUrl = "";
        this.mScope = "";
        this.mPackageName = "";
        this.mKeyHash = "";
        this.mAppKey = str;
        this.mRedirectUrl = str2;
        this.mScope = str3;
        String packageName = context.getPackageName();
        this.mPackageName = packageName;
        this.mKeyHash = Utility.getSign(context, packageName);
    }

    public static AuthInfo parseBundleData(Context context, Bundle bundle) {
        return new AuthInfo(context, bundle.getString("appKey"), bundle.getString(WBConstants.SSO_REDIRECT_URL), bundle.getString("scope"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public Bundle getAuthBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", this.mAppKey);
        bundle.putString(WBConstants.SSO_REDIRECT_URL, this.mRedirectUrl);
        bundle.putString("scope", this.mScope);
        bundle.putString("packagename", this.mPackageName);
        bundle.putString("key_hash", this.mKeyHash);
        return bundle;
    }

    public String getKeyHash() {
        return this.mKeyHash;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getScope() {
        return this.mScope;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mAppKey);
        parcel.writeString(this.mRedirectUrl);
        parcel.writeString(this.mScope);
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mKeyHash);
    }

    public AuthInfo(Parcel parcel) {
        this.mAppKey = "";
        this.mRedirectUrl = "";
        this.mScope = "";
        this.mPackageName = "";
        this.mKeyHash = "";
        this.mAppKey = parcel.readString();
        this.mRedirectUrl = parcel.readString();
        this.mScope = parcel.readString();
        this.mPackageName = parcel.readString();
        this.mKeyHash = parcel.readString();
    }
}
