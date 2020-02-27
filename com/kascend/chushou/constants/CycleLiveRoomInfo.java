package com.kascend.chushou.constants;
/* loaded from: classes5.dex */
public class CycleLiveRoomInfo {
    public String avatar;
    public String eventDesc;
    public String eventIcon;
    public String eventName;
    public String eventUrl;
    public boolean isSubscribe;
    public String nickname;
    public long remainTime;
    public String roomId;
    public String uid;

    public void copyCycleLiveRoomInfo(CycleLiveRoomInfo cycleLiveRoomInfo) {
        this.uid = cycleLiveRoomInfo.uid;
        this.nickname = cycleLiveRoomInfo.nickname;
        this.remainTime = cycleLiveRoomInfo.remainTime;
        this.avatar = cycleLiveRoomInfo.avatar;
        this.roomId = cycleLiveRoomInfo.roomId;
        this.isSubscribe = cycleLiveRoomInfo.isSubscribe;
        this.eventDesc = cycleLiveRoomInfo.eventDesc;
        this.eventUrl = cycleLiveRoomInfo.eventUrl;
        this.eventIcon = cycleLiveRoomInfo.eventIcon;
        this.eventName = cycleLiveRoomInfo.eventName;
    }
}
