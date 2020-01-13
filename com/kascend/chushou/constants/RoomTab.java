package com.kascend.chushou.constants;

import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class RoomTab {
    public static final int H5_TYPE_CONTRIBUTION = 1001;
    public static final int H5_TYPE_LOYALFANS = 1000;
    public static final int ROOM_TAB_TYPE_BANRRAGE = 2;
    @Deprecated
    public static final int ROOM_TAB_TYPE_FANS = 3;
    public static final int ROOM_TAB_TYPE_H5 = 99;
    public static final int ROOM_TAB_TYPE_ROOMINFO = 1;
    public String mTargetKey;
    public String name;
    public int notify;
    public String notifyIcon;
    public int type;
    public String url;

    public int calculateH5Type() {
        if (this.type == 99 && !h.isEmpty(this.url)) {
            if (this.url.contains("bigfans")) {
                return 1000;
            }
            return this.url.contains("m/room-billboard") ? 1001 : -1;
        }
        return -1;
    }
}
