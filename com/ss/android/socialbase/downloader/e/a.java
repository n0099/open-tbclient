package com.ss.android.socialbase.downloader.e;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
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
        /* renamed from: Re */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f13139a;

    /* renamed from: b  reason: collision with root package name */
    private String f13140b;

    public a() {
    }

    public a(int i, String str) {
        super("[d-ex]:" + str);
        this.f13140b = "[d-ex]:" + str;
        this.f13139a = i;
    }

    public void a(String str) {
        this.f13140b = str;
    }

    public a(int i, Throwable th) {
        this(i, com.ss.android.socialbase.downloader.m.d.L(th));
    }

    protected a(Parcel parcel) {
        a(parcel);
    }

    public void a(Parcel parcel) {
        this.f13139a = parcel.readInt();
        this.f13140b = parcel.readString();
    }

    public int a() {
        return this.f13139a;
    }

    public String b() {
        return this.f13140b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13139a);
        parcel.writeString(this.f13140b);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.f13139a + ", errorMsg='" + this.f13140b + "'}";
    }
}
