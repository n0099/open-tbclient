package com.kascend.chushou.constants;

import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.toolkit.richtext.RichTextPlus;
/* loaded from: classes4.dex */
public class ChatInfo {
    public static final int GIFT_EMOJI = 2;
    public static final int GIFT_NORMAL = 1;
    public static final String POS_DOWN_BARRAGE = "2";
    public static final String POS_PLAYER_BARRAGE = "3";
    public static final String POS_SHOWTIP = "1";
    public static final String TYPE_ALARM = "2";
    public static final String TYPE_GIFT = "3";
    public static final String TYPE_NORMAL = "1";
    public static final String TYPE_SYSTEM = "4";
    public int giftDisplayHeight;
    public int giftDisplayWidth;
    public boolean isBatchGift;
    public int mAnimSubType;
    public int mAnimType;
    public String mAnimationDisplayText;
    public int mAnimationPluginId;
    public int mAnimationPriority;
    public int mAnimationStage;
    public int mAnimationType;
    public ArrayList<RichText> mContentRichText;
    public long mCreatedTime;
    public List<String> mDisplayPosition;
    public Object mJsonData;
    public ArrayList<RichText> mNicknameRichText;
    public int mRoomComboCount;
    public String mType;
    public int mUserComboCount;
    public boolean mFilter = false;
    public int giftType = 1;
    public String mRoomID = "";
    public String mID = "";
    public String mUserID = "";
    public String mUserNickname = "";
    public String mContent = "";
    public String mHeadIcon = "";
    public String mGender = "";
    public GiftInfo mGift = new GiftInfo();
    public PrivilegeInfo mPrivilegeInfo = new PrivilegeInfo();
    public RichTextPlus mCoolNickname = null;
    public RichTextPlus mCoolContent = null;
    public RichTextPlus mCoolMessage = null;
    public ListItem mItem = new ListItem();

    public boolean equals(Object obj) {
        return (obj instanceof ChatInfo) && this.mID != null && this.mID.equals(((ChatInfo) obj).mID);
    }

    public ChatInfo() {
        this.mType = "1";
        this.mType = "";
    }

    public boolean isShare() {
        return this.mItem != null && "18".equals(this.mItem.mType);
    }
}
