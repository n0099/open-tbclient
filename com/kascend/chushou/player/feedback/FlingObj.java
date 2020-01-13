package com.kascend.chushou.player.feedback;
/* loaded from: classes4.dex */
public class FlingObj {
    public int enterType;
    public String roomId;
    public long time;

    public void reset() {
        this.roomId = null;
        this.time = 0L;
        this.enterType = 0;
    }

    public FlingObj copy() {
        FlingObj flingObj = new FlingObj();
        flingObj.roomId = this.roomId;
        flingObj.time = this.time;
        flingObj.enterType = this.enterType;
        return flingObj;
    }
}
