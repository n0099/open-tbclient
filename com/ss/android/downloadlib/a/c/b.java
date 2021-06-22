package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f39551a;

    /* renamed from: b  reason: collision with root package name */
    public int f39552b;

    /* renamed from: c  reason: collision with root package name */
    public String f39553c;

    /* renamed from: d  reason: collision with root package name */
    public int f39554d;

    /* renamed from: e  reason: collision with root package name */
    public String f39555e;

    /* renamed from: f  reason: collision with root package name */
    public String f39556f;

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
        this.f39553c = "";
        this.f39555e = "";
        this.f39556f = "";
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
            if (this.f39551a == bVar.f39551a && this.f39552b == bVar.f39552b) {
                String str = this.f39553c;
                if (str != null) {
                    return str.equals(bVar.f39553c);
                }
                if (bVar.f39553c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.f39551a * 31) + this.f39552b) * 31;
        String str = this.f39553c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f39551a);
        parcel.writeInt(this.f39552b);
        parcel.writeString(this.f39553c);
        parcel.writeString(this.f39555e);
        parcel.writeString(this.f39556f);
        parcel.writeInt(this.f39554d);
    }

    public b(Parcel parcel) {
        this.f39553c = "";
        this.f39555e = "";
        this.f39556f = "";
        this.f39551a = parcel.readInt();
        this.f39552b = parcel.readInt();
        this.f39553c = parcel.readString();
        this.f39555e = parcel.readString();
        this.f39556f = parcel.readString();
        this.f39554d = parcel.readInt();
    }
}
