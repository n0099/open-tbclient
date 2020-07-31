package com.kascend.chushou.constants;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ShareInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<ShareInfo> CREATOR = new Parcelable.Creator<ShareInfo>() { // from class: com.kascend.chushou.constants.ShareInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareInfo createFromParcel(Parcel parcel) {
            return new ShareInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareInfo[] newArray(int i) {
            return new ShareInfo[i];
        }
    };
    private static final long serialVersionUID = 3769719016256143588L;
    public String mContent;
    public String mImagePath;
    public String mLiveType;
    public String mMiniProgramThumbnail;
    public String mMiniProgramUrl;
    public boolean mNeedShowIM;
    public String mPic;
    public String mPlatform;
    public String mShareType;
    public ArrayList<Integer> mShowPlatform;
    public String mTargetKey;
    public String mThumbnail;
    public String mTitle;
    public String mUrl;
    public int mVideoType;

    public ShareInfo() {
        this.mNeedShowIM = true;
        this.mNeedShowIM = true;
        this.mMiniProgramThumbnail = "";
        this.mThumbnail = "";
        this.mTitle = "";
        this.mContent = "";
        this.mUrl = "";
        this.mTargetKey = "";
        this.mShareType = "";
        this.mShowPlatform = new ArrayList<>();
        this.mImagePath = "";
        this.mPlatform = "";
    }

    protected ShareInfo(Parcel parcel) {
        this.mNeedShowIM = true;
        this.mThumbnail = parcel.readString();
        this.mMiniProgramThumbnail = parcel.readString();
        this.mTitle = parcel.readString();
        this.mContent = parcel.readString();
        this.mUrl = parcel.readString();
        this.mPic = parcel.readString();
        this.mNeedShowIM = parcel.readByte() != 0;
        this.mTargetKey = parcel.readString();
        this.mShareType = parcel.readString();
        this.mLiveType = parcel.readString();
        this.mVideoType = parcel.readInt();
        this.mMiniProgramUrl = parcel.readString();
        this.mImagePath = parcel.readString();
        this.mPlatform = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mThumbnail);
        parcel.writeString(this.mMiniProgramThumbnail);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mContent);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mPic);
        parcel.writeByte((byte) (this.mNeedShowIM ? 1 : 0));
        parcel.writeString(this.mTargetKey);
        parcel.writeString(this.mShareType);
        parcel.writeString(this.mLiveType);
        parcel.writeInt(this.mVideoType);
        parcel.writeString(this.mMiniProgramUrl);
        parcel.writeString(this.mImagePath);
        parcel.writeString(this.mPlatform);
    }
}
