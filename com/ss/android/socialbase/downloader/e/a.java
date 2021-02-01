package com.ss.android.socialbase.downloader.e;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class a extends Exception implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.ss.android.socialbase.downloader.e.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ap */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Rz */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f13141a;

    /* renamed from: b  reason: collision with root package name */
    private String f13142b;

    public a() {
    }

    public a(int i, String str) {
        super("[d-ex]:" + str);
        this.f13142b = "[d-ex]:" + str;
        this.f13141a = i;
    }

    public void a(String str) {
        this.f13142b = str;
    }

    public a(int i, Throwable th) {
        this(i, com.ss.android.socialbase.downloader.m.d.K(th));
    }

    protected a(Parcel parcel) {
        a(parcel);
    }

    public void a(Parcel parcel) {
        this.f13141a = parcel.readInt();
        this.f13142b = parcel.readString();
    }

    public int a() {
        return this.f13141a;
    }

    public String b() {
        return this.f13142b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13141a);
        parcel.writeString(this.f13142b);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.f13141a + ", errorMsg='" + this.f13142b + "'}";
    }
}
