package com.kascend.chushou.constants;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class H5Positon implements Parcelable {
    public static final Parcelable.Creator<H5Positon> CREATOR = new Parcelable.Creator<H5Positon>() { // from class: com.kascend.chushou.constants.H5Positon.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public H5Positon createFromParcel(Parcel parcel) {
            return new H5Positon(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public H5Positon[] newArray(int i) {
            return new H5Positon[i];
        }
    };
    public int mAspectRadio;
    public int mHeight;
    public int mWidth;

    public H5Positon() {
    }

    protected H5Positon(Parcel parcel) {
        this.mWidth = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mAspectRadio = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mAspectRadio);
    }
}
