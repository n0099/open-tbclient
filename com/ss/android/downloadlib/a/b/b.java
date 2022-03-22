package com.ss.android.downloadlib.a.b;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
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
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f42708b;

    /* renamed from: c  reason: collision with root package name */
    public String f42709c;

    /* renamed from: d  reason: collision with root package name */
    public int f42710d;

    /* renamed from: e  reason: collision with root package name */
    public String f42711e;

    /* renamed from: f  reason: collision with root package name */
    public String f42712f;

    public b() {
        this.f42709c = "";
        this.f42711e = "";
        this.f42712f = "";
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
            if (this.a == bVar.a && this.f42708b == bVar.f42708b) {
                String str = this.f42709c;
                if (str != null) {
                    return str.equals(bVar.f42709c);
                }
                if (bVar.f42709c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.f42708b) * 31;
        String str = this.f42709c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f42708b);
        parcel.writeString(this.f42709c);
        parcel.writeString(this.f42711e);
        parcel.writeString(this.f42712f);
        parcel.writeInt(this.f42710d);
    }

    public b(Parcel parcel) {
        this.f42709c = "";
        this.f42711e = "";
        this.f42712f = "";
        this.a = parcel.readInt();
        this.f42708b = parcel.readInt();
        this.f42709c = parcel.readString();
        this.f42711e = parcel.readString();
        this.f42712f = parcel.readString();
        this.f42710d = parcel.readInt();
    }
}
