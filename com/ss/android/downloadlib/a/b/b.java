package com.ss.android.downloadlib.a.b;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
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
    public int f59440b;

    /* renamed from: c  reason: collision with root package name */
    public String f59441c;

    /* renamed from: d  reason: collision with root package name */
    public int f59442d;

    /* renamed from: e  reason: collision with root package name */
    public String f59443e;

    /* renamed from: f  reason: collision with root package name */
    public String f59444f;

    public b() {
        this.f59441c = "";
        this.f59443e = "";
        this.f59444f = "";
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
            if (this.a == bVar.a && this.f59440b == bVar.f59440b) {
                String str = this.f59441c;
                if (str != null) {
                    return str.equals(bVar.f59441c);
                }
                if (bVar.f59441c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.a * 31) + this.f59440b) * 31;
        String str = this.f59441c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f59440b);
        parcel.writeString(this.f59441c);
        parcel.writeString(this.f59443e);
        parcel.writeString(this.f59444f);
        parcel.writeInt(this.f59442d);
    }

    public b(Parcel parcel) {
        this.f59441c = "";
        this.f59443e = "";
        this.f59444f = "";
        this.a = parcel.readInt();
        this.f59440b = parcel.readInt();
        this.f59441c = parcel.readString();
        this.f59443e = parcel.readString();
        this.f59444f = parcel.readString();
        this.f59442d = parcel.readInt();
    }
}
