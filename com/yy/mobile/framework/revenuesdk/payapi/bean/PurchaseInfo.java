package com.yy.mobile.framework.revenuesdk.payapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class PurchaseInfo implements Parcelable {
    public static final Parcelable.Creator<PurchaseInfo> CREATOR = new Parcelable.Creator<PurchaseInfo>() { // from class: com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PurchaseInfo createFromParcel(Parcel parcel) {
            return new PurchaseInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PurchaseInfo[] newArray(int i) {
            return new PurchaseInfo[i];
        }
    };
    public final String data;
    public final String signature;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PurchaseInfo() {
        this("", "");
    }

    public String toString() {
        return "PurchaseInfo{data='" + this.data + "', signature='" + this.signature + "'}";
    }

    public PurchaseInfo(Parcel parcel) {
        this.data = parcel.readString();
        this.signature = parcel.readString();
    }

    public PurchaseInfo(String str, String str2) {
        this.data = str;
        this.signature = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.data);
        parcel.writeString(this.signature);
    }
}
