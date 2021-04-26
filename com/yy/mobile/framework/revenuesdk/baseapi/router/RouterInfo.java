package com.yy.mobile.framework.revenuesdk.baseapi.router;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class RouterInfo implements Parcelable {
    public static final Parcelable.Creator<RouterInfo> CREATOR = new a();
    public long cmd;
    public String functionName;
    public String serviceName;

    /* loaded from: classes7.dex */
    public static class a implements Parcelable.Creator<RouterInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RouterInfo createFromParcel(Parcel parcel) {
            return new RouterInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RouterInfo[] newArray(int i2) {
            return new RouterInfo[i2];
        }
    }

    public RouterInfo() {
        this(0L, "", "");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RouterInfo{cmd=" + this.cmd + "'serviceName='" + this.serviceName + "', functionName='" + this.functionName + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.cmd);
        parcel.writeString(this.serviceName);
        parcel.writeString(this.functionName);
    }

    public RouterInfo(long j, String str, String str2) {
        this.cmd = j;
        this.serviceName = str;
        this.functionName = str2;
    }

    public RouterInfo(Parcel parcel) {
        this.cmd = parcel.readLong();
        this.serviceName = parcel.readString();
        this.functionName = parcel.readString();
    }
}
