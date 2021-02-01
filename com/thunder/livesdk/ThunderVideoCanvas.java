package com.thunder.livesdk;
/* loaded from: classes4.dex */
public class ThunderVideoCanvas {
    public int mRenderMode;
    public int mSeatIndex;
    public String mUid;
    public Object mView;

    public ThunderVideoCanvas(Object obj, int i, String str, int i2) {
        this.mView = null;
        this.mView = obj;
        this.mRenderMode = i;
        this.mUid = str;
        this.mSeatIndex = i2;
    }

    public ThunderVideoCanvas(Object obj, int i, String str) {
        this.mView = null;
        this.mView = obj;
        this.mRenderMode = i;
        this.mUid = str;
        this.mSeatIndex = -1;
    }
}
