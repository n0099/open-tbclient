package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public final class TrackKey implements Parcelable, Comparable<TrackKey> {
    public static final Parcelable.Creator<TrackKey> CREATOR = new Parcelable.Creator<TrackKey>() { // from class: com.google.android.exoplayer2.source.smoothstreaming.manifest.TrackKey.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackKey createFromParcel(Parcel parcel) {
            return new TrackKey(parcel.readInt(), parcel.readInt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackKey[] newArray(int i) {
            return new TrackKey[i];
        }
    };
    public final int streamElementIndex;
    public final int trackIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.streamElementIndex + "." + this.trackIndex;
    }

    public TrackKey(int i, int i2) {
        this.streamElementIndex = i;
        this.trackIndex = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.streamElementIndex);
        parcel.writeInt(this.trackIndex);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull TrackKey trackKey) {
        int i = this.streamElementIndex - trackKey.streamElementIndex;
        if (i == 0) {
            return this.trackIndex - trackKey.trackIndex;
        }
        return i;
    }
}
