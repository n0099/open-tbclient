package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f39448a;

    /* renamed from: b  reason: collision with root package name */
    public int f39449b;

    /* renamed from: c  reason: collision with root package name */
    public String f39450c;

    /* renamed from: d  reason: collision with root package name */
    public int f39451d;

    /* renamed from: e  reason: collision with root package name */
    public String f39452e;

    /* renamed from: f  reason: collision with root package name */
    public String f39453f;

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
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b() {
        this.f39450c = "";
        this.f39452e = "";
        this.f39453f = "";
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
            if (this.f39448a == bVar.f39448a && this.f39449b == bVar.f39449b) {
                String str = this.f39450c;
                if (str != null) {
                    return str.equals(bVar.f39450c);
                }
                if (bVar.f39450c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.f39448a * 31) + this.f39449b) * 31;
        String str = this.f39450c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f39448a);
        parcel.writeInt(this.f39449b);
        parcel.writeString(this.f39450c);
        parcel.writeString(this.f39452e);
        parcel.writeString(this.f39453f);
        parcel.writeInt(this.f39451d);
    }

    public b(Parcel parcel) {
        this.f39450c = "";
        this.f39452e = "";
        this.f39453f = "";
        this.f39448a = parcel.readInt();
        this.f39449b = parcel.readInt();
        this.f39450c = parcel.readString();
        this.f39452e = parcel.readString();
        this.f39453f = parcel.readString();
        this.f39451d = parcel.readInt();
    }
}
