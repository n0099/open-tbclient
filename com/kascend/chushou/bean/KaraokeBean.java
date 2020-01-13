package com.kascend.chushou.bean;
/* loaded from: classes4.dex */
public class KaraokeBean {
    public ActingInfo actingInfo;
    public int actorState = -1;
    public IconMap iconMap;
    public SequenceInfo sequenceInfo;

    /* loaded from: classes4.dex */
    public static class ActingInfo {
        public long currentTime;
        public long finishTime;
        public GiftPower giftPower;
        public String musicName;
        public String roomId;
    }

    /* loaded from: classes4.dex */
    public static class GiftPower {
        public long current;
        public long end;
        public int rank;
        public long start;
    }

    /* loaded from: classes4.dex */
    public static class IconMap {
        public String icon;
        public String title;
    }

    /* loaded from: classes4.dex */
    public static class SequenceInfo {
        public int rank;
        public String roomId;
        public String uid;
    }
}
