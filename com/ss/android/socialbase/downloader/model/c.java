package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class c implements Parcelable, Comparable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f39332a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39333b;

    /* loaded from: classes6.dex */
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
        public c[] newArray(int i) {
            return new c[i];
        }
    }

    public c(String str, String str2) {
        this.f39332a = str;
        this.f39333b = str2;
    }

    public String a() {
        return this.f39332a;
    }

    public String b() {
        return this.f39333b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (TextUtils.equals(this.f39332a, cVar.a())) {
                return 0;
            }
            String str = this.f39332a;
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
        return TextUtils.equals(this.f39332a, cVar.f39332a) && TextUtils.equals(this.f39333b, cVar.f39333b);
    }

    public int hashCode() {
        String str = this.f39332a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f39333b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f39332a);
        parcel.writeString(this.f39333b);
    }

    public c(Parcel parcel) {
        this.f39332a = parcel.readString();
        this.f39333b = parcel.readString();
    }
}
