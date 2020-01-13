package com.kascend.chushou.constants;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PlayUrl implements Parcelable {
    public static final Parcelable.Creator<PlayUrl> CREATOR = new Parcelable.Creator<PlayUrl>() { // from class: com.kascend.chushou.constants.PlayUrl.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayUrl createFromParcel(Parcel parcel) {
            return new PlayUrl(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayUrl[] newArray(int i) {
            return new PlayUrl[i];
        }
    };
    public static final String P2P_CLOSE = "0";
    public static final String P2P_OPEN = "1";
    public static final String TYPE_AUDIO = "2";
    public static final String TYPE_VIDEO = "1";
    public long mEffectiveTime;
    public String mName;
    public String mProtocal;
    public String mSelectedSourceId;
    public String mSelectedType;
    public String mSelectedUrl;
    public String mType;
    public ArrayList<UrlDetails> mUrlDetails;
    public String mUseP2p;
    public String streamName;

    public PlayUrl() {
        this.mProtocal = "";
        this.mName = "";
        this.mSelectedUrl = "";
        this.mEffectiveTime = 0L;
        this.mUseP2p = "0";
        this.mUrlDetails = new ArrayList<>();
        this.mType = "";
        this.mSelectedSourceId = "";
        this.mSelectedType = "";
    }

    protected PlayUrl(Parcel parcel) {
        this.mProtocal = parcel.readString();
        this.mName = parcel.readString();
        this.streamName = parcel.readString();
        this.mEffectiveTime = parcel.readLong();
        this.mUseP2p = parcel.readString();
        this.mType = parcel.readString();
        this.mUrlDetails = parcel.createTypedArrayList(UrlDetails.CREATOR);
        this.mSelectedUrl = parcel.readString();
        this.mSelectedSourceId = parcel.readString();
        this.mSelectedType = parcel.readString();
    }

    public void release() {
        this.mProtocal = null;
        this.mName = null;
        this.mSelectedUrl = null;
        this.mEffectiveTime = 0L;
        this.mUseP2p = null;
        this.mType = null;
        if (this.mUrlDetails != null) {
            this.mUrlDetails.clear();
            this.mUrlDetails = null;
        }
        this.mSelectedSourceId = null;
        this.mSelectedType = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mProtocal);
        parcel.writeString(this.mName);
        parcel.writeString(this.streamName);
        parcel.writeLong(this.mEffectiveTime);
        parcel.writeString(this.mUseP2p);
        parcel.writeString(this.mType);
        parcel.writeTypedList(this.mUrlDetails);
        parcel.writeString(this.mSelectedUrl);
        parcel.writeString(this.mSelectedSourceId);
        parcel.writeString(this.mSelectedType);
    }
}
