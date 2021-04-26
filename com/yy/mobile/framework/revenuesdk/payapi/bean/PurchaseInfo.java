package com.yy.mobile.framework.revenuesdk.payapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class PurchaseInfo implements Parcelable {
    public static final Parcelable.Creator<PurchaseInfo> CREATOR = new a();
    public final String data;
    public final String signature;

    /* loaded from: classes7.dex */
    public static class a implements Parcelable.Creator<PurchaseInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PurchaseInfo createFromParcel(Parcel parcel) {
            return new PurchaseInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PurchaseInfo[] newArray(int i2) {
            return new PurchaseInfo[i2];
        }
    }

    public PurchaseInfo() {
        this("", "");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PurchaseInfo{data='" + this.data + "', signature='" + this.signature + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.data);
        parcel.writeString(this.signature);
    }

    public PurchaseInfo(String str, String str2) {
        this.data = str;
        this.signature = str2;
    }

    public PurchaseInfo(Parcel parcel) {
        this.data = parcel.readString();
        this.signature = parcel.readString();
    }
}
