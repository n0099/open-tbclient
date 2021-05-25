package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f35769a;

    /* renamed from: b  reason: collision with root package name */
    public int f35770b;

    /* renamed from: c  reason: collision with root package name */
    public String f35771c;

    /* renamed from: d  reason: collision with root package name */
    public int f35772d;

    /* renamed from: e  reason: collision with root package name */
    public String f35773e;

    /* renamed from: f  reason: collision with root package name */
    public String f35774f;

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
        this.f35771c = "";
        this.f35773e = "";
        this.f35774f = "";
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
            if (this.f35769a == bVar.f35769a && this.f35770b == bVar.f35770b) {
                String str = this.f35771c;
                if (str != null) {
                    return str.equals(bVar.f35771c);
                }
                if (bVar.f35771c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.f35769a * 31) + this.f35770b) * 31;
        String str = this.f35771c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f35769a);
        parcel.writeInt(this.f35770b);
        parcel.writeString(this.f35771c);
        parcel.writeString(this.f35773e);
        parcel.writeString(this.f35774f);
        parcel.writeInt(this.f35772d);
    }

    public b(Parcel parcel) {
        this.f35771c = "";
        this.f35773e = "";
        this.f35774f = "";
        this.f35769a = parcel.readInt();
        this.f35770b = parcel.readInt();
        this.f35771c = parcel.readString();
        this.f35773e = parcel.readString();
        this.f35774f = parcel.readString();
        this.f35772d = parcel.readInt();
    }
}
