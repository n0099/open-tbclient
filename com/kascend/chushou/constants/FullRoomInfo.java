package com.kascend.chushou.constants;

import android.support.v4.util.SparseArrayCompat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FullRoomInfo {
    public CycleLiveRoomInfo cycleLiveRoomInfo;
    public SparseArrayCompat<BangListInfo> mBangMap;
    public GiftComboConfig mGiftComboConfig;
    public RoomInfo mRoominfo = new RoomInfo();
    public List<GeneralTabGift> mGeneralTabGifts = new ArrayList();
    public List<RoomToast> mRoomToastList = new ArrayList();
    public ArrayList<FanItem> mFanItems = new ArrayList<>();
    public ArrayList<RoomTab> mRoomTabs = new ArrayList<>();
    public MicStatus mMicStatus = new MicStatus();
    public List<PrivacyItem> mPrivacyItems = null;

    public boolean equals(Object obj) {
        RoomInfo roomInfo;
        return (obj == null || !(obj instanceof FullRoomInfo) || (roomInfo = ((FullRoomInfo) obj).mRoominfo) == null || roomInfo.mRoomID == null || !roomInfo.mRoomID.equals(this.mRoominfo.mRoomID)) ? false : true;
    }

    public void release() {
        if (this.mRoominfo != null) {
            this.mRoominfo.release();
            this.mRoominfo = null;
        }
        if (this.mGeneralTabGifts != null) {
            this.mGeneralTabGifts.clear();
            this.mGeneralTabGifts = null;
        }
        if (this.mRoomToastList != null) {
            this.mRoomToastList.clear();
            this.mRoomToastList = null;
        }
        if (this.mFanItems != null) {
            this.mFanItems.clear();
            this.mFanItems = null;
        }
        if (this.mRoomTabs != null) {
            this.mRoomTabs.clear();
            this.mRoomTabs = null;
        }
        this.mMicStatus = null;
        if (this.mPrivacyItems != null) {
            this.mPrivacyItems.clear();
            this.mPrivacyItems = null;
        }
    }
}
