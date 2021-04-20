package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f38915a;

    /* renamed from: b  reason: collision with root package name */
    public int f38916b;

    /* renamed from: c  reason: collision with root package name */
    public String f38917c;

    /* renamed from: d  reason: collision with root package name */
    public int f38918d;

    /* renamed from: e  reason: collision with root package name */
    public String f38919e;

    /* renamed from: f  reason: collision with root package name */
    public String f38920f;

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
        this.f38917c = "";
        this.f38919e = "";
        this.f38920f = "";
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
            if (this.f38915a == bVar.f38915a && this.f38916b == bVar.f38916b) {
                String str = this.f38917c;
                if (str != null) {
                    return str.equals(bVar.f38917c);
                }
                if (bVar.f38917c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f38915a * 31) + this.f38916b) * 31;
        String str = this.f38917c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38915a);
        parcel.writeInt(this.f38916b);
        parcel.writeString(this.f38917c);
        parcel.writeString(this.f38919e);
        parcel.writeString(this.f38920f);
        parcel.writeInt(this.f38918d);
    }

    public b(Parcel parcel) {
        this.f38917c = "";
        this.f38919e = "";
        this.f38920f = "";
        this.f38915a = parcel.readInt();
        this.f38916b = parcel.readInt();
        this.f38917c = parcel.readString();
        this.f38919e = parcel.readString();
        this.f38920f = parcel.readString();
        this.f38918d = parcel.readInt();
    }
}
