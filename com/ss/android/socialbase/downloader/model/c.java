package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class c implements Parcelable, Comparable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f39880a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39881b;

    /* loaded from: classes7.dex */
    public static class a implements Parcelable.Creator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public c[] newArray(int i2) {
            return new c[i2];
        }
    }

    public c(String str, String str2) {
        this.f39880a = str;
        this.f39881b = str2;
    }

    public String a() {
        return this.f39880a;
    }

    public String b() {
        return this.f39881b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (TextUtils.equals(this.f39880a, cVar.a())) {
                return 0;
            }
            String str = this.f39880a;
            if (str == null) {
                return -1;
            }
            int compareTo = str.compareTo(cVar.a());
            if (compareTo > 0) {
                return 1;
            }
            return compareTo < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return TextUtils.equals(this.f39880a, cVar.f39880a) && TextUtils.equals(this.f39881b, cVar.f39881b);
    }

    public int hashCode() {
        String str = this.f39880a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f39881b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f39880a);
        parcel.writeString(this.f39881b);
    }

    public c(Parcel parcel) {
        this.f39880a = parcel.readString();
        this.f39881b = parcel.readString();
    }
}
