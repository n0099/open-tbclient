package com.ss.android.downloadlib.a.b;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.downloadlib.a.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f61735b;

    /* renamed from: c  reason: collision with root package name */
    public String f61736c;

    /* renamed from: d  reason: collision with root package name */
    public int f61737d;

    /* renamed from: e  reason: collision with root package name */
    public String f61738e;

    /* renamed from: f  reason: collision with root package name */
    public String f61739f;

    public b() {
        this.f61736c = "";
        this.f61738e = "";
        this.f61739f = "";
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
            if (this.a == bVar.a && this.f61735b == bVar.f61735b) {
                String str = this.f61736c;
                if (str != null) {
                    return str.equals(bVar.f61736c);
                }
                if (bVar.f61736c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.a * 31) + this.f61735b) * 31;
        String str = this.f61736c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f61735b);
        parcel.writeString(this.f61736c);
        parcel.writeString(this.f61738e);
        parcel.writeString(this.f61739f);
        parcel.writeInt(this.f61737d);
    }

    public b(Parcel parcel) {
        this.f61736c = "";
        this.f61738e = "";
        this.f61739f = "";
        this.a = parcel.readInt();
        this.f61735b = parcel.readInt();
        this.f61736c = parcel.readString();
        this.f61738e = parcel.readString();
        this.f61739f = parcel.readString();
        this.f61737d = parcel.readInt();
    }
}
