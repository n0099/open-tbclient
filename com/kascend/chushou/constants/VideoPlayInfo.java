package com.kascend.chushou.constants;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPlayInfo implements Parcelable {
    public static final Parcelable.Creator<VideoPlayInfo> CREATOR = new Parcelable.Creator<VideoPlayInfo>() { // from class: com.kascend.chushou.constants.VideoPlayInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoPlayInfo createFromParcel(Parcel parcel) {
            return new VideoPlayInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoPlayInfo[] newArray(int i) {
            return new VideoPlayInfo[i];
        }
    };
    public long mEffectiveTime;
    public List<PlayUrl> mPlayUrls;
    public int mPos;
    public long mTime;

    public VideoPlayInfo() {
    }

    protected VideoPlayInfo(Parcel parcel) {
        this.mPos = parcel.readInt();
        this.mPlayUrls = parcel.createTypedArrayList(PlayUrl.CREATOR);
        this.mTime = parcel.readLong();
        this.mEffectiveTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPos);
        parcel.writeTypedList(this.mPlayUrls);
        parcel.writeLong(this.mTime);
        parcel.writeLong(this.mEffectiveTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.mPlayUrls != null ? this.mPlayUrls.toString() : "";
    }
}
