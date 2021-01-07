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
        /* renamed from: SL */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f13439a;

    /* renamed from: b  reason: collision with root package name */
    private String f13440b;

    public a() {
    }

    public a(int i, String str) {
        super("[d-ex]:" + str);
        this.f13440b = "[d-ex]:" + str;
        this.f13439a = i;
    }

    public void a(String str) {
        this.f13440b = str;
    }

    public a(int i, Throwable th) {
        this(i, com.ss.android.socialbase.downloader.m.d.L(th));
    }

    protected a(Parcel parcel) {
        a(parcel);
    }

    public void a(Parcel parcel) {
        this.f13439a = parcel.readInt();
        this.f13440b = parcel.readString();
    }

    public int a() {
        return this.f13439a;
    }

    public String b() {
        return this.f13440b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13439a);
        parcel.writeString(this.f13440b);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.f13439a + ", errorMsg='" + this.f13440b + "'}";
    }
}
