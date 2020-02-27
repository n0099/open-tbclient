package com.kascend.chushou.constants;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class RoomInfo implements Serializable {
    private static final long serialVersionUID = -6142732605146513339L;
    public int mCreatorLevel;
    public String mCreatorLevelMedal;
    public boolean mIsLive;
    public long mLastLiveTime;
    public String mLiveType;
    public int mStyle;
    public boolean mIsPushOn = false;
    public String mRoomID = "";
    public String mName = "";
    public String mRoomNotice = "";
    public String mCreatorUID = "";
    public String mCreatorNickname = "";
    public String mCreatorSignature = "";
    public String mCreatorAvatar = "";
    public String mCreatorGender = "male";
    public ShareInfo mShareInfo = new ShareInfo();
    public String mFansCount = "";
    public String mLiveTimeDesc = "";
    public String mModelName = "";
    public String mLastLiveDesc = "";
    public boolean mIsSubscribed = false;
    public String mCover = "";
    public String mOnlineCount = "";
    public String mGameId = "";
    public String mGameName = "";
    public String mSystemAnnouncement = "";
    public String mLiveTag = "";
    public String mGameIcon = "";

    public void release() {
        this.mRoomID = null;
        this.mName = null;
        this.mRoomNotice = null;
        this.mCreatorUID = null;
        this.mCreatorNickname = null;
        this.mCreatorAvatar = null;
        this.mCreatorGender = null;
        this.mFansCount = null;
        this.mLiveTimeDesc = null;
        this.mModelName = null;
        this.mShareInfo = null;
        this.mCover = null;
        this.mOnlineCount = null;
        this.mGameId = null;
        this.mGameName = null;
        this.mLiveTag = null;
        this.mGameIcon = null;
    }
}
