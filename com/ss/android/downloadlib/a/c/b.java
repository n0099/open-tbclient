package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f39010a;

    /* renamed from: b  reason: collision with root package name */
    public int f39011b;

    /* renamed from: c  reason: collision with root package name */
    public String f39012c;

    /* renamed from: d  reason: collision with root package name */
    public int f39013d;

    /* renamed from: e  reason: collision with root package name */
    public String f39014e;

    /* renamed from: f  reason: collision with root package name */
    public String f39015f;

    /* loaded from: classes6.dex */
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
        this.f39012c = "";
        this.f39014e = "";
        this.f39015f = "";
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
            if (this.f39010a == bVar.f39010a && this.f39011b == bVar.f39011b) {
                String str = this.f39012c;
                if (str != null) {
                    return str.equals(bVar.f39012c);
                }
                if (bVar.f39012c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f39010a * 31) + this.f39011b) * 31;
        String str = this.f39012c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f39010a);
        parcel.writeInt(this.f39011b);
        parcel.writeString(this.f39012c);
        parcel.writeString(this.f39014e);
        parcel.writeString(this.f39015f);
        parcel.writeInt(this.f39013d);
    }

    public b(Parcel parcel) {
        this.f39012c = "";
        this.f39014e = "";
        this.f39015f = "";
        this.f39010a = parcel.readInt();
        this.f39011b = parcel.readInt();
        this.f39012c = parcel.readString();
        this.f39014e = parcel.readString();
        this.f39015f = parcel.readString();
        this.f39013d = parcel.readInt();
    }
}
