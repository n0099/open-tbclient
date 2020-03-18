package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.ApicFrame.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ar */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ko */
        public ApicFrame[] newArray(int i) {
            return new ApicFrame[i];
        }
    };
    public static final String ID = "APIC";
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super(ID);
        this.mimeType = str;
        this.description = str2;
        this.pictureType = i;
        this.pictureData = bArr;
    }

    ApicFrame(Parcel parcel) {
        super(ID);
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.pictureType = parcel.readInt();
        this.pictureData = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.pictureType == apicFrame.pictureType && v.h(this.mimeType, apicFrame.mimeType) && v.h(this.description, apicFrame.description) && Arrays.equals(this.pictureData, apicFrame.pictureData);
    }

    public int hashCode() {
        return (((((this.mimeType != null ? this.mimeType.hashCode() : 0) + ((this.pictureType + 527) * 31)) * 31) + (this.description != null ? this.description.hashCode() : 0)) * 31) + Arrays.hashCode(this.pictureData);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.pictureType);
        parcel.writeByteArray(this.pictureData);
    }
}
