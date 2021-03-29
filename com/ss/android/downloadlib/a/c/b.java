package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f38626a;

    /* renamed from: b  reason: collision with root package name */
    public int f38627b;

    /* renamed from: c  reason: collision with root package name */
    public String f38628c;

    /* renamed from: d  reason: collision with root package name */
    public int f38629d;

    /* renamed from: e  reason: collision with root package name */
    public String f38630e;

    /* renamed from: f  reason: collision with root package name */
    public String f38631f;

    /* loaded from: classes7.dex */
    public static class a implements Parcelable.Creator<b> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b() {
        this.f38628c = "";
        this.f38630e = "";
        this.f38631f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f38626a == bVar.f38626a && this.f38627b == bVar.f38627b) {
                String str = this.f38628c;
                if (str != null) {
                    return str.equals(bVar.f38628c);
                }
                if (bVar.f38628c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f38626a * 31) + this.f38627b) * 31;
        String str = this.f38628c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38626a);
        parcel.writeInt(this.f38627b);
        parcel.writeString(this.f38628c);
        parcel.writeString(this.f38630e);
        parcel.writeString(this.f38631f);
        parcel.writeInt(this.f38629d);
    }

    public b(Parcel parcel) {
        this.f38628c = "";
        this.f38630e = "";
        this.f38631f = "";
        this.f38626a = parcel.readInt();
        this.f38627b = parcel.readInt();
        this.f38628c = parcel.readString();
        this.f38630e = parcel.readString();
        this.f38631f = parcel.readString();
        this.f38629d = parcel.readInt();
    }
}
