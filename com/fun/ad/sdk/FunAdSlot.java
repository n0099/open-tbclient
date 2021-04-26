package com.fun.ad.sdk;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class FunAdSlot {
    public int expressHeight;
    public int expressWidth;
    public String sid;
    public boolean smallImgStyle;

    /* loaded from: classes6.dex */
    public static class Builder {
        public int expressHeight;
        public int expressWidth;
        public String sid;
        public boolean smallImgStyle;

        public FunAdSlot build() {
            FunAdSlot funAdSlot = new FunAdSlot();
            funAdSlot.sid = this.sid;
            funAdSlot.expressWidth = this.expressWidth;
            funAdSlot.expressHeight = this.expressHeight;
            funAdSlot.smallImgStyle = this.smallImgStyle;
            return funAdSlot;
        }

        public Builder setExpressHeight(int i2) {
            this.expressHeight = i2;
            return this;
        }

        public Builder setExpressWidth(int i2) {
            this.expressWidth = i2;
            return this;
        }

        public Builder setSid(@NonNull String str) {
            this.sid = str;
            return this;
        }

        public Builder setSmallImgStyle(boolean z) {
            this.smallImgStyle = z;
            return this;
        }
    }

    public FunAdSlot() {
    }

    public int getExpressHeight() {
        return this.expressHeight;
    }

    public int getExpressWidth() {
        return this.expressWidth;
    }

    public String getSid() {
        return this.sid;
    }

    public boolean isSmallImgStyle() {
        return this.smallImgStyle;
    }
}
