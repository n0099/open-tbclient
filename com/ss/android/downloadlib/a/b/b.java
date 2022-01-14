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
    public int f59395b;

    /* renamed from: c  reason: collision with root package name */
    public String f59396c;

    /* renamed from: d  reason: collision with root package name */
    public int f59397d;

    /* renamed from: e  reason: collision with root package name */
    public String f59398e;

    /* renamed from: f  reason: collision with root package name */
    public String f59399f;

    public b() {
        this.f59396c = "";
        this.f59398e = "";
        this.f59399f = "";
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
            if (this.a == bVar.a && this.f59395b == bVar.f59395b) {
                String str = this.f59396c;
                if (str != null) {
                    return str.equals(bVar.f59396c);
                }
                if (bVar.f59396c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.a * 31) + this.f59395b) * 31;
        String str = this.f59396c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f59395b);
        parcel.writeString(this.f59396c);
        parcel.writeString(this.f59398e);
        parcel.writeString(this.f59399f);
        parcel.writeInt(this.f59397d);
    }

    public b(Parcel parcel) {
        this.f59396c = "";
        this.f59398e = "";
        this.f59399f = "";
        this.a = parcel.readInt();
        this.f59395b = parcel.readInt();
        this.f59396c = parcel.readString();
        this.f59398e = parcel.readString();
        this.f59399f = parcel.readString();
        this.f59397d = parcel.readInt();
    }
}
