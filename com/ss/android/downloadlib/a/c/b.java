package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f38625a;

    /* renamed from: b  reason: collision with root package name */
    public int f38626b;

    /* renamed from: c  reason: collision with root package name */
    public String f38627c;

    /* renamed from: d  reason: collision with root package name */
    public int f38628d;

    /* renamed from: e  reason: collision with root package name */
    public String f38629e;

    /* renamed from: f  reason: collision with root package name */
    public String f38630f;

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
        this.f38627c = "";
        this.f38629e = "";
        this.f38630f = "";
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
            if (this.f38625a == bVar.f38625a && this.f38626b == bVar.f38626b) {
                String str = this.f38627c;
                if (str != null) {
                    return str.equals(bVar.f38627c);
                }
                if (bVar.f38627c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f38625a * 31) + this.f38626b) * 31;
        String str = this.f38627c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38625a);
        parcel.writeInt(this.f38626b);
        parcel.writeString(this.f38627c);
        parcel.writeString(this.f38629e);
        parcel.writeString(this.f38630f);
        parcel.writeInt(this.f38628d);
    }

    public b(Parcel parcel) {
        this.f38627c = "";
        this.f38629e = "";
        this.f38630f = "";
        this.f38625a = parcel.readInt();
        this.f38626b = parcel.readInt();
        this.f38627c = parcel.readString();
        this.f38629e = parcel.readString();
        this.f38630f = parcel.readString();
        this.f38628d = parcel.readInt();
    }
}
