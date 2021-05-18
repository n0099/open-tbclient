package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class c implements Parcelable, Comparable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f36169a;

    /* renamed from: b  reason: collision with root package name */
    public final String f36170b;

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
        this.f36169a = str;
        this.f36170b = str2;
    }

    public String a() {
        return this.f36169a;
    }

    public String b() {
        return this.f36170b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (TextUtils.equals(this.f36169a, cVar.a())) {
                return 0;
            }
            String str = this.f36169a;
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
        return TextUtils.equals(this.f36169a, cVar.f36169a) && TextUtils.equals(this.f36170b, cVar.f36170b);
    }

    public int hashCode() {
        String str = this.f36169a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f36170b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f36169a);
        parcel.writeString(this.f36170b);
    }

    public c(Parcel parcel) {
        this.f36169a = parcel.readString();
        this.f36170b = parcel.readString();
    }
}
