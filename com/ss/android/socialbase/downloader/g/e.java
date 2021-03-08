package com.ss.android.socialbase.downloader.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes6.dex */
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
        /* renamed from: RS */
        public e[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f7836a;
    private final String b;

    public e(String str, String str2) {
        this.f7836a = str;
        this.b = str2;
    }

    protected e(Parcel parcel) {
        this.f7836a = parcel.readString();
        this.b = parcel.readString();
    }

    public String a() {
        return this.f7836a;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7836a);
        parcel.writeString(this.b);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof e) {
            if (TextUtils.equals(this.f7836a, ((e) obj).a())) {
                return 0;
            }
            if (this.f7836a == null) {
                return -1;
            }
            int compareTo = this.f7836a.compareTo(((e) obj).a());
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
        return TextUtils.equals(this.f7836a, eVar.f7836a) && TextUtils.equals(this.b, eVar.b);
    }

    public int hashCode() {
        return ((this.f7836a == null ? 0 : this.f7836a.hashCode()) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }
}
