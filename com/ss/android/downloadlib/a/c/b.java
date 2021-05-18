package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f35840a;

    /* renamed from: b  reason: collision with root package name */
    public int f35841b;

    /* renamed from: c  reason: collision with root package name */
    public String f35842c;

    /* renamed from: d  reason: collision with root package name */
    public int f35843d;

    /* renamed from: e  reason: collision with root package name */
    public String f35844e;

    /* renamed from: f  reason: collision with root package name */
    public String f35845f;

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
        this.f35842c = "";
        this.f35844e = "";
        this.f35845f = "";
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
            if (this.f35840a == bVar.f35840a && this.f35841b == bVar.f35841b) {
                String str = this.f35842c;
                if (str != null) {
                    return str.equals(bVar.f35842c);
                }
                if (bVar.f35842c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.f35840a * 31) + this.f35841b) * 31;
        String str = this.f35842c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f35840a);
        parcel.writeInt(this.f35841b);
        parcel.writeString(this.f35842c);
        parcel.writeString(this.f35844e);
        parcel.writeString(this.f35845f);
        parcel.writeInt(this.f35843d);
    }

    public b(Parcel parcel) {
        this.f35842c = "";
        this.f35844e = "";
        this.f35845f = "";
        this.f35840a = parcel.readInt();
        this.f35841b = parcel.readInt();
        this.f35842c = parcel.readString();
        this.f35844e = parcel.readString();
        this.f35845f = parcel.readString();
        this.f35843d = parcel.readInt();
    }
}
