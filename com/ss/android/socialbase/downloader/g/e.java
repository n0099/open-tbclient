package com.ss.android.socialbase.downloader.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public class e implements Parcelable, Comparable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.ss.android.socialbase.downloader.g.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: as */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: SZ */
        public e[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f13458a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13459b;

    public e(String str, String str2) {
        this.f13458a = str;
        this.f13459b = str2;
    }

    protected e(Parcel parcel) {
        this.f13458a = parcel.readString();
        this.f13459b = parcel.readString();
    }

    public String a() {
        return this.f13458a;
    }

    public String b() {
        return this.f13459b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13458a);
        parcel.writeString(this.f13459b);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof e) {
            if (TextUtils.equals(this.f13458a, ((e) obj).a())) {
                return 0;
            }
            if (this.f13458a == null) {
                return -1;
            }
            int compareTo = this.f13458a.compareTo(((e) obj).a());
            if (compareTo > 0) {
                return 1;
            }
            return compareTo < 0 ? -1 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return TextUtils.equals(this.f13458a, eVar.f13458a) && TextUtils.equals(this.f13459b, eVar.f13459b);
    }

    public int hashCode() {
        return ((this.f13458a == null ? 0 : this.f13458a.hashCode()) * 31) + (this.f13459b != null ? this.f13459b.hashCode() : 0);
    }
}
