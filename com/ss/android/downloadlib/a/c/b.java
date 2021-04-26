package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f36595a;

    /* renamed from: b  reason: collision with root package name */
    public int f36596b;

    /* renamed from: c  reason: collision with root package name */
    public String f36597c;

    /* renamed from: d  reason: collision with root package name */
    public int f36598d;

    /* renamed from: e  reason: collision with root package name */
    public String f36599e;

    /* renamed from: f  reason: collision with root package name */
    public String f36600f;

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
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b() {
        this.f36597c = "";
        this.f36599e = "";
        this.f36600f = "";
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
            if (this.f36595a == bVar.f36595a && this.f36596b == bVar.f36596b) {
                String str = this.f36597c;
                if (str != null) {
                    return str.equals(bVar.f36597c);
                }
                if (bVar.f36597c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.f36595a * 31) + this.f36596b) * 31;
        String str = this.f36597c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f36595a);
        parcel.writeInt(this.f36596b);
        parcel.writeString(this.f36597c);
        parcel.writeString(this.f36599e);
        parcel.writeString(this.f36600f);
        parcel.writeInt(this.f36598d);
    }

    public b(Parcel parcel) {
        this.f36597c = "";
        this.f36599e = "";
        this.f36600f = "";
        this.f36595a = parcel.readInt();
        this.f36596b = parcel.readInt();
        this.f36597c = parcel.readString();
        this.f36599e = parcel.readString();
        this.f36600f = parcel.readString();
        this.f36598d = parcel.readInt();
    }
}
