package com.kascend.chushou.constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class GeneralGift implements Serializable {
    public static final int TYPE_DIALOG_H5 = 96;
    public static final int TYPE_GIFT = 1;
    public static final int TYPE_INNER_H5 = 98;
    public static final int TYPE_OUT_H5 = 99;
    public static final int TYPE_POCKET = 2;
    public static final int TYPE_RED_POCKET_H5 = 94;
    private static final long serialVersionUID = 1793306682862083058L;
    public int mActionType;
    public long mComboExpiryTime;
    public String mCornerImage;
    public String mDisplayDesc;
    public String mExpiredTimeDesc;
    public int mGiftDetailHeight;
    public int mGiftDetailWidth;
    public String mGroupName;
    public H5Positon mLandscape;
    public String mName;
    public H5Positon mPortrait;
    public boolean mSupportBatch;
    public List<String> mTagLists;
    public int mType;
    public String mUrl;
    public String mWorthDesc;
    public int mId = -1;
    public String mDesc = "";
    public String mIcon = null;
    public int mPoint = -1;
    public int mCount = -1;
    public String mRepeatedBg = "";
    public long mDuration = 3000;
    public boolean mSelectFlag = false;
    public int mGroup = 1;

    public void copyClone(GeneralGift generalGift) {
        if (generalGift != null) {
            this.mId = generalGift.mId;
            this.mType = generalGift.mType;
            this.mName = generalGift.mName;
            this.mDesc = generalGift.mDesc;
            this.mIcon = generalGift.mIcon;
            this.mCornerImage = generalGift.mCornerImage;
            this.mPoint = generalGift.mPoint;
            this.mCount = generalGift.mCount;
            this.mActionType = generalGift.mActionType;
            this.mRepeatedBg = generalGift.mRepeatedBg;
            this.mDuration = generalGift.mDuration;
            this.mExpiredTimeDesc = generalGift.mExpiredTimeDesc;
            if (!h.isEmpty(generalGift.mTagLists)) {
                if (this.mTagLists == null) {
                    this.mTagLists = new ArrayList();
                }
                this.mTagLists.clear();
                this.mTagLists.addAll(generalGift.mTagLists);
            }
            this.mGroup = generalGift.mGroup;
            this.mSupportBatch = generalGift.mSupportBatch;
            this.mComboExpiryTime = generalGift.mComboExpiryTime;
            this.mWorthDesc = generalGift.mWorthDesc;
            this.mDisplayDesc = generalGift.mDisplayDesc;
            this.mUrl = generalGift.mUrl;
            this.mPortrait = generalGift.mPortrait;
            this.mLandscape = generalGift.mLandscape;
            this.mGroupName = generalGift.mGroupName;
            this.mGiftDetailHeight = generalGift.mGiftDetailHeight;
            this.mGiftDetailWidth = generalGift.mGiftDetailWidth;
        }
    }

    public String toString() {
        return "GeneralGift{mId=" + this.mId + ", mType=" + this.mType + ", mName='" + this.mName + "', mDesc='" + this.mDesc + "', mIcon='" + this.mIcon + "', mCornerImage='" + this.mCornerImage + "', mPoint=" + this.mPoint + ", mCount=" + this.mCount + ", mActionType=" + this.mActionType + ", mRepeatedBg='" + this.mRepeatedBg + "', mDuration=" + this.mDuration + ", mSelectFlag=" + this.mSelectFlag + '}';
    }
}
