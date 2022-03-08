package com.ss.android.downloadlib.a.b;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes8.dex */
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
    public int f57957b;

    /* renamed from: c  reason: collision with root package name */
    public String f57958c;

    /* renamed from: d  reason: collision with root package name */
    public int f57959d;

    /* renamed from: e  reason: collision with root package name */
    public String f57960e;

    /* renamed from: f  reason: collision with root package name */
    public String f57961f;

    public b() {
        this.f57958c = "";
        this.f57960e = "";
        this.f57961f = "";
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
            if (this.a == bVar.a && this.f57957b == bVar.f57957b) {
                String str = this.f57958c;
                if (str != null) {
                    return str.equals(bVar.f57958c);
                }
                if (bVar.f57958c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.a * 31) + this.f57957b) * 31;
        String str = this.f57958c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f57957b);
        parcel.writeString(this.f57958c);
        parcel.writeString(this.f57960e);
        parcel.writeString(this.f57961f);
        parcel.writeInt(this.f57959d);
    }

    public b(Parcel parcel) {
        this.f57958c = "";
        this.f57960e = "";
        this.f57961f = "";
        this.a = parcel.readInt();
        this.f57957b = parcel.readInt();
        this.f57958c = parcel.readString();
        this.f57960e = parcel.readString();
        this.f57961f = parcel.readString();
        this.f57959d = parcel.readInt();
    }
}
