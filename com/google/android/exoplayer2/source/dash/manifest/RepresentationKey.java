package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public final class RepresentationKey implements Parcelable, Comparable<RepresentationKey> {
    public static final Parcelable.Creator<RepresentationKey> CREATOR = new Parcelable.Creator<RepresentationKey>() { // from class: com.google.android.exoplayer2.source.dash.manifest.RepresentationKey.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aL */
        public RepresentationKey createFromParcel(Parcel parcel) {
            return new RepresentationKey(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: KP */
        public RepresentationKey[] newArray(int i) {
            return new RepresentationKey[i];
        }
    };
    public final int adaptationSetIndex;
    public final int periodIndex;
    public final int representationIndex;

    public RepresentationKey(int i, int i2, int i3) {
        this.periodIndex = i;
        this.adaptationSetIndex = i2;
        this.representationIndex = i3;
    }

    public String toString() {
        return this.periodIndex + "." + this.adaptationSetIndex + "." + this.representationIndex;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.adaptationSetIndex);
        parcel.writeInt(this.representationIndex);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull RepresentationKey representationKey) {
        int i = this.periodIndex - representationKey.periodIndex;
        if (i == 0) {
            int i2 = this.adaptationSetIndex - representationKey.adaptationSetIndex;
            if (i2 == 0) {
                return this.representationIndex - representationKey.representationIndex;
            }
            return i2;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RepresentationKey representationKey = (RepresentationKey) obj;
        return this.periodIndex == representationKey.periodIndex && this.adaptationSetIndex == representationKey.adaptationSetIndex && this.representationIndex == representationKey.representationIndex;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.adaptationSetIndex) * 31) + this.representationIndex;
    }
}
