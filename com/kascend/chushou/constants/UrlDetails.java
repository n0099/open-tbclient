package com.kascend.chushou.constants;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public class UrlDetails implements Parcelable {
    public static final Parcelable.Creator<UrlDetails> CREATOR = new Parcelable.Creator<UrlDetails>() { // from class: com.kascend.chushou.constants.UrlDetails.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlDetails createFromParcel(Parcel parcel) {
            return new UrlDetails(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlDetails[] newArray(int i) {
            return new UrlDetails[i];
        }
    };
    public String mBitrate;
    public String mDefinitionName;
    public String mDefinitionType;
    public String mSourceId;
    public String mUrl;

    public UrlDetails() {
    }

    protected UrlDetails(Parcel parcel) {
        this.mDefinitionName = parcel.readString();
        this.mDefinitionType = parcel.readString();
        this.mUrl = parcel.readString();
        this.mBitrate = parcel.readString();
        this.mSourceId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDefinitionName);
        parcel.writeString(this.mDefinitionType);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mBitrate);
        parcel.writeString(this.mSourceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
