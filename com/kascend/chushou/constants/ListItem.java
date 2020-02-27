package com.kascend.chushou.constants;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ListItem implements Serializable {
    private static final long serialVersionUID = -5786090184172371721L;
    public String borderImage;
    public long hornTimestamp;
    public int mAutoCloseTime;
    public String mBroadcastSuffixIcon;
    public String mCustomIcon;
    public String mDesc;
    public String mDisplayTagBackground;
    public int mDisplayTagBgHeight;
    public String mDisplayTagColor;
    public String mDisplayTagIcon;
    public transient Object mExtra;
    public String mGloriouslyUid;
    public String mGloriouslyUidColor;
    public String mGloriouslyUidMedal;
    public boolean mHasUp;
    public String mIcon;
    public int mLevel;
    public String mLevelMedal;
    public String mLiveCount;
    public String mLowerRightCornerIcon;
    public String mMicDisplayUid;
    public String mMicMc;
    public boolean mMicNeedApply;
    public String mNobleMedal;
    public String mOriginalCover;
    public String mPackIcon;
    public int mPackStyle;
    public String mPackTip;
    public int mPannelPos;
    public String mPlantCover;
    public String mPlayCount;
    public int mRank;
    public String mRedirectAppName;
    public String mRoomId;
    public String mShareTargetKey;
    public String mShareType;
    public ShopWindowInfo mShopWindowInfo;
    public boolean mShowClose;
    public String mSubscribeCount;
    public String mUpCount;
    public int mVideoType;
    public long remianTime;
    public long rewardCount;
    public String hornAvatar = "";
    public String hornFrontContent = "";
    public String hornContent = "";
    public int hormStyle = 0;
    public String mType = "";
    public String mLiveType = "";
    public String mName = "";
    public String mAvatar = "";
    public String mCover = "";
    public String mTargetKey = "";
    public String mTotalCount = "";
    public String mVideoDuration = "";
    public String mOnlineCount = "";
    public String mCreater = "";
    public String mUid = "";
    public String mUrl = "";
    public String mDisplayStyle = "";
    public String mCommentCount = "";
    public String mGender = "";
    public String mVideoCount = "";
    public int mLiveState = 0;
    public String mCornerIcon = "";
    public String mSC = "";
    public transient boolean mIsSelected = false;
    public String mDisplayTag = "";
    public String mAffixIcon = "";
    public transient boolean mShowKeyboard = false;
    public String mSummary = "";
    public boolean mIsSubscribed = false;
    public String mNotifyType = "";
    public boolean mAffixIconFlag = false;
    public int mMicGameId = 0;
    public boolean mIsBigFans = false;
    public AdExtraInfo mAdExtraInfo = null;
    public ArrayList<String> mRightBottomIcons = new ArrayList<>();
    public String mIndexName = "";
    public int mWidth = 0;
    public int mHeight = 0;
    public String mTimelineId = null;
    public String mImageCount = "";
    public String mCity = "";
    public String mNickname = "";
    public float mDisplayTagBgWidth = 0.0f;
    public int mAutoDisplay = -1;
    public String mPkLiveIcon = "";
    public boolean fromBaidu = false;

    public String toString() {
        return "ListItem{mType='" + this.mType + "'mLiveType='" + this.mLiveType + "'mVideoType='" + this.mVideoType + "', mTargetKey='" + this.mTargetKey + "', mName='" + this.mName + "', mDesc='" + this.mDesc + "', mCover='" + this.mCover + "', mDisplayStyle='" + this.mDisplayStyle + "', mUid='" + this.mUid + "', mCreater='" + this.mCreater + "', mAvatar='" + this.mAvatar + "', mGender='" + this.mGender + "', mRoomId='" + this.mRoomId + "', mSubscribeCount='" + this.mSubscribeCount + "', mIsSubscribed=" + this.mIsSubscribed + ", mLiveState=" + this.mLiveState + ", mIcon='" + this.mIcon + "', mUrl='" + this.mUrl + "', mSummary='" + this.mSummary + "', mPlayCount='" + this.mPlayCount + "', mCommentCount='" + this.mCommentCount + "', mVideoDuration='" + this.mVideoDuration + "', mTimelineId='" + this.mTimelineId + "', mHasUp=" + this.mHasUp + ", mUpCount='" + this.mUpCount + "', mOnlineCount='" + this.mOnlineCount + "', mDisplayTag='" + this.mDisplayTag + "', mCornerIcon='" + this.mCornerIcon + "', mIsBigFans=" + this.mIsBigFans + ", mRightBottomIcons=" + this.mRightBottomIcons + ", mLiveCount='" + this.mLiveCount + "', mVideoCount='" + this.mVideoCount + "', mTotalCount='" + this.mTotalCount + "', mAffixIcon='" + this.mAffixIcon + "', mAffixIconFlag=" + this.mAffixIconFlag + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mIndexName='" + this.mIndexName + "', mMicGameId=" + this.mMicGameId + ", mMicDisplayUid='" + this.mMicDisplayUid + "', mMicNeedApply=" + this.mMicNeedApply + ", mMicMc='" + this.mMicMc + "', mSC='" + this.mSC + "', mNotifyType='" + this.mNotifyType + "', mPlantCover='" + this.mPlantCover + "', mPackIcon='" + this.mPackIcon + "', mPackStyle=" + this.mPackStyle + ", mPackTip='" + this.mPackTip + "', mShowClose=" + this.mShowClose + ", mAutoCloseTime=" + this.mAutoCloseTime + ", mAdExtraInfo=" + this.mAdExtraInfo + ", mIsSelected=" + this.mIsSelected + ", mShowKeyboard=" + this.mShowKeyboard + ", mExtra=" + this.mExtra + ", mNickname='" + this.mNickname + "', mCity='" + this.mCity + "', mImageCount='" + this.mImageCount + "', mDisplayTagBgWidth='" + this.mDisplayTagBgWidth + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            if (this.mTargetKey.equals(listItem.mTargetKey) && this.mType.equals(listItem.mType)) {
                if (this.mAdExtraInfo != null) {
                    return this.mAdExtraInfo.equals(listItem.mAdExtraInfo);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((this.mType.hashCode() + 527) * 31) + this.mTargetKey.hashCode();
    }

    public Object deepCopy() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
            try {
                return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void adCopy(ListItem listItem) {
        this.fromBaidu = listItem.fromBaidu;
        this.mType = listItem.mType;
        this.mLiveType = listItem.mLiveType;
        this.mVideoType = listItem.mVideoType;
        this.mTargetKey = listItem.mTargetKey;
        this.mName = listItem.mName;
        this.mDesc = listItem.mDesc;
        this.mCover = listItem.mCover;
        this.mDisplayStyle = listItem.mDisplayStyle;
        this.mUid = listItem.mUid;
        this.mCreater = listItem.mCreater;
        this.mAvatar = listItem.mAvatar;
        this.mGender = listItem.mGender;
        this.mRoomId = listItem.mRoomId;
        this.mSubscribeCount = listItem.mSubscribeCount;
        this.mIsSubscribed = listItem.mIsSubscribed;
        this.mLiveState = listItem.mLiveState;
        this.mLevel = listItem.mLevel;
        this.mLevelMedal = listItem.mLevelMedal;
        this.mIcon = listItem.mIcon;
        this.mUrl = listItem.mUrl;
        this.mSummary = listItem.mSummary;
        this.mPlayCount = listItem.mPlayCount;
        this.mCommentCount = listItem.mCommentCount;
        this.mVideoDuration = listItem.mVideoDuration;
        this.mTimelineId = listItem.mTimelineId;
        this.mHasUp = listItem.mHasUp;
        this.mUpCount = listItem.mUpCount;
        this.mRank = listItem.mRank;
        this.rewardCount = listItem.rewardCount;
        this.mOnlineCount = listItem.mOnlineCount;
        this.mDisplayTag = listItem.mDisplayTag;
        this.mDisplayTagColor = listItem.mDisplayTagColor;
        this.mDisplayTagBackground = listItem.mDisplayTagBackground;
        this.mDisplayTagIcon = listItem.mDisplayTagIcon;
        this.mCornerIcon = listItem.mCornerIcon;
        this.mIsBigFans = listItem.mIsBigFans;
        this.mRightBottomIcons = listItem.mRightBottomIcons;
        this.mLiveCount = listItem.mLiveCount;
        this.mVideoCount = listItem.mVideoCount;
        this.mTotalCount = listItem.mTotalCount;
        this.mAffixIcon = listItem.mAffixIcon;
        this.mAffixIconFlag = listItem.mAffixIconFlag;
        this.mWidth = listItem.mWidth;
        this.mHeight = listItem.mHeight;
        this.mIndexName = listItem.mIndexName;
        this.mMicGameId = listItem.mMicGameId;
        this.mMicDisplayUid = listItem.mMicDisplayUid;
        this.mMicNeedApply = listItem.mMicNeedApply;
        this.mMicMc = listItem.mMicMc;
        this.mSC = listItem.mSC;
        this.mNotifyType = listItem.mNotifyType;
        this.mPlantCover = listItem.mPlantCover;
        this.mPackIcon = listItem.mPackIcon;
        this.mPackStyle = listItem.mPackStyle;
        this.mPackTip = listItem.mPackTip;
        this.mShowClose = listItem.mShowClose;
        if (this.mAdExtraInfo != null) {
            listItem.mAdExtraInfo.mAdvertAutoRefreshTimes = this.mAdExtraInfo.mAdvertAutoRefreshTimes;
            listItem.mAdExtraInfo.mAdvertMinFreshIntervalSecond = this.mAdExtraInfo.mAdvertMinFreshIntervalSecond;
            listItem.mAdExtraInfo.mAdvertMaxFreshIntervalSecond = this.mAdExtraInfo.mAdvertMaxFreshIntervalSecond;
            this.mAdExtraInfo = listItem.mAdExtraInfo;
        } else {
            this.mAdExtraInfo = listItem.mAdExtraInfo;
        }
        this.mNickname = listItem.mNickname;
        this.mCity = listItem.mCity;
        this.mImageCount = listItem.mImageCount;
        this.mDisplayTagBgWidth = listItem.mDisplayTagBgWidth;
        this.mDisplayTagBgHeight = listItem.mDisplayTagBgHeight;
    }
}
