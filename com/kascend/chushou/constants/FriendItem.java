package com.kascend.chushou.constants;

import java.util.ArrayList;
import java.util.List;
import tv.chushou.a.a.a.b;
/* loaded from: classes5.dex */
public class FriendItem {
    public String mGloriouslyUidMedal;
    public boolean mIsChcedked;
    public int mLevel;
    public String mLevelMedal;
    public String mLiveType;
    public String mUid = "";
    public String mNickname = "";
    public String mAvatar = "";
    public String mGender = "";
    public String mSignature = "";
    public String mShowName = "";
    public String mOnlineDesc = "";
    public boolean mAppOnline = false;
    public boolean mDisplay = true;
    public String mTargetKey = "";
    public String mRelation = "-1";
    public String mStatus = "-1";
    public String mDesc = "";
    public String mNobleMedal = "";
    public List<String> mAvatarFrame = new ArrayList();

    public int hashCode() {
        if (this.mUid == null) {
            return 0;
        }
        return this.mUid.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FriendItem)) {
            return false;
        }
        return b.equals(((FriendItem) obj).mUid, this.mUid);
    }

    public String toString() {
        return "FriendItem{mUid='" + this.mUid + "', mNickname='" + this.mNickname + "', mAvatar='" + this.mAvatar + "', mGender='" + this.mGender + "', mSignature='" + this.mSignature + "', mShowName='" + this.mShowName + "', mOnlineDesc='" + this.mOnlineDesc + "', mRelation=" + this.mRelation + ", mStatus=" + this.mStatus + ", mAppOnline='" + this.mAppOnline + "', mTargetKey='" + this.mTargetKey + "', mDisplay='" + this.mDisplay + "', mDesc='" + this.mDesc + "'}";
    }
}
