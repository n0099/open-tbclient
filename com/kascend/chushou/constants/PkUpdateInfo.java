package com.kascend.chushou.constants;

import java.util.List;
/* loaded from: classes6.dex */
public class PkUpdateInfo {
    public static final int TYPE_BIG_ADD = 4;
    public static final int TYPE_FIRSTBLOOD = 1;
    public static final int TYPE_SMALL_ADD = 3;
    public static final int TYPE_STRIKE = 2;
    public long endTimeStamp;
    public String opponentReceiveCount;
    public List<MyUserInfo> opponentRewardList;
    public String receiveCount;
    public long remainDuration;
    public List<MyUserInfo> rewardList;
    public List<SpecialMoment> specialMomentList;

    /* loaded from: classes6.dex */
    public static class SpecialMoment {
        public String addition;
        public long endTime;
        public long maxDuration;
        public boolean mineFirstblood;
        public long remainDuration;
        public String roomId;
        public int type;
    }
}
