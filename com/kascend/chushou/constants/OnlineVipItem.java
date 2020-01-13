package com.kascend.chushou.constants;
/* loaded from: classes4.dex */
public class OnlineVipItem {
    public String mAvatar;
    public String mScore;
    public String mUid;

    public boolean compare(OnlineVipItem onlineVipItem) {
        return (onlineVipItem == null || this.mUid == null || !this.mUid.equals(onlineVipItem.mUid) || this.mAvatar == null || !this.mAvatar.equals(onlineVipItem.mAvatar) || this.mScore == null || !this.mScore.equals(onlineVipItem.mScore)) ? false : true;
    }
}
