package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = new a();
    public static final String TAG = "[d-ex]:";
    public int errorCode;
    public String errorMsg;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<BaseException> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BaseException[] newArray(int i2) {
            return new BaseException[i2];
        }
    }

    public BaseException() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public void readFromParcel(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
    }

    public BaseException(int i2, String str) {
        super(TAG + str);
        this.errorMsg = TAG + str;
        this.errorCode = i2;
    }

    public BaseException(int i2, Throwable th) {
        this(i2, d.o.a.e.b.l.e.R0(th));
    }

    public BaseException(Parcel parcel) {
        readFromParcel(parcel);
    }
}
