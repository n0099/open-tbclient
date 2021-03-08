package com.yy.mediaframework.model;
/* loaded from: classes6.dex */
public class ChannelModel {
    public static final int FILLMODE_INNERFIT = 1;
    public static final int FILLMODE_OUTERFIT = 2;
    public int channelId;
    public int channelType;
    public int fillMode;
    public Rect location;

    /* loaded from: classes6.dex */
    public class Rect {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public Rect(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }
    }
}
