package com.kascend.chushou.constants;
/* loaded from: classes6.dex */
public class PkNotifyInfo {
    public static final int CLOSE_PK = 2;
    public static final int MODE_LINE = 1;
    public static final int MODE_SKY = 2;
    public static final int NEW_START_PK = 7;
    public static final int READY_PK = 6;
    public static final int RESULT_LOSE = -1;
    public static final int RESULT_PK = 5;
    public static final int RESULT_TIE = 0;
    public static final int RESULT_WIN = 1;
    public static final int SPECIAL_PK = 8;
    public static final int START_PK = 1;
    public static final int STOP_PK = 4;
    public static final int UPDATE_PK = 3;
    public DestinyInfo destinyInfo;
    public int liveStyle;
    public long mMaxFreeDuration;
    public long mMaxPKDuration;
    public int mMode;
    public String mPkId;
    public String mPkRoomId;
    public String mPkUid;
    public String mPkUserAvatar;
    public String mPkUserNickname;
    public String mResult;
    public long maxPrepareDuration;
    public String mvpAvatar;
    public String mvpNickname;
    public String mvpUid;
    public boolean mInPKMode = false;
    public PkUpdateInfo mPkUpdateInfo = new PkUpdateInfo();
    public int mAction = 0;

    /* loaded from: classes6.dex */
    public static class DestinyInfo {
        public int destinyId;
        public String pkBarIcon;
        public String pkBarKey;
    }

    public void copyUpdate(PkNotifyInfo pkNotifyInfo) {
        this.mPkUpdateInfo = pkNotifyInfo.mPkUpdateInfo;
        this.liveStyle = pkNotifyInfo.liveStyle;
    }

    public void copySpecial(PkNotifyInfo pkNotifyInfo) {
        if (pkNotifyInfo != null && pkNotifyInfo.mPkUpdateInfo != null) {
            if (this.mPkUpdateInfo == null) {
                this.mPkUpdateInfo = new PkUpdateInfo();
            }
            this.mPkUpdateInfo.specialMomentList = pkNotifyInfo.mPkUpdateInfo.specialMomentList;
        }
    }

    public void copyResult(PkNotifyInfo pkNotifyInfo) {
        this.mvpUid = pkNotifyInfo.mvpUid;
        this.mvpAvatar = pkNotifyInfo.mvpAvatar;
        this.mvpNickname = pkNotifyInfo.mvpNickname;
        this.mResult = pkNotifyInfo.mResult;
    }

    public void copyStop(PkNotifyInfo pkNotifyInfo) {
        this.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
    }

    public void copy(PkNotifyInfo pkNotifyInfo) {
        this.mPkId = pkNotifyInfo.mPkId;
        this.mPkRoomId = pkNotifyInfo.mPkRoomId;
        this.mPkUid = pkNotifyInfo.mPkUid;
        this.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
        this.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
        this.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
        this.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
        this.mResult = pkNotifyInfo.mResult;
        this.mvpUid = pkNotifyInfo.mvpUid;
        this.mvpAvatar = pkNotifyInfo.mvpAvatar;
        this.mvpNickname = pkNotifyInfo.mvpNickname;
        this.mPkUpdateInfo = pkNotifyInfo.mPkUpdateInfo;
        this.mAction = pkNotifyInfo.mAction;
        this.mMode = pkNotifyInfo.mMode;
        this.liveStyle = pkNotifyInfo.liveStyle;
        this.destinyInfo = pkNotifyInfo.destinyInfo;
    }
}
