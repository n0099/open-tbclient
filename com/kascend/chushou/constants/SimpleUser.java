package com.kascend.chushou.constants;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SimpleUser implements Parcelable, Serializable {
    public static final Parcelable.Creator<SimpleUser> CREATOR = new Parcelable.Creator<SimpleUser>() { // from class: com.kascend.chushou.constants.SimpleUser.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimpleUser createFromParcel(Parcel parcel) {
            return new SimpleUser(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimpleUser[] newArray(int i) {
            return new SimpleUser[i];
        }
    };
    private static final long serialVersionUID = -4914101084862426592L;
    public String mAvatar;
    public List<String> mAvatarFrame;
    public String mGender;
    public int mLevel;
    public String mLevelMedal;
    public String mNickName;
    public String mSignature;
    public String mUid;

    public SimpleUser() {
        this.mUid = "";
        this.mNickName = "";
        this.mAvatar = "";
        this.mGender = "";
        this.mSignature = "";
        this.mAvatarFrame = new ArrayList();
    }

    protected SimpleUser(Parcel parcel) {
        this.mUid = parcel.readString();
        this.mNickName = parcel.readString();
        this.mAvatar = parcel.readString();
        this.mGender = parcel.readString();
        this.mSignature = parcel.readString();
        this.mLevel = parcel.readInt();
        this.mLevelMedal = parcel.readString();
        this.mAvatarFrame = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUid);
        parcel.writeString(this.mNickName);
        parcel.writeString(this.mAvatar);
        parcel.writeString(this.mGender);
        parcel.writeString(this.mSignature);
        parcel.writeInt(this.mLevel);
        parcel.writeString(this.mLevelMedal);
        parcel.writeStringList(this.mAvatarFrame);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
