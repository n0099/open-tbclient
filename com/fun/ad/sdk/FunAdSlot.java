package com.fun.ad.sdk;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class FunAdSlot {
    public AdLoadMode adLoadMode;
    public FunAdView adView;
    public int expressHeight;
    public int expressWidth;
    public String sid;
    public boolean smallImgStyle;

    /* loaded from: classes6.dex */
    public enum AdLoadMode {
        TIME_FIRST,
        PRIORITY_FIRST
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        public AdLoadMode adLoadMode = AdLoadMode.PRIORITY_FIRST;
        public FunAdView adView;
        public int expressHeight;
        public int expressWidth;
        public String sid;
        public boolean smallImgStyle;

        public FunAdSlot build() {
            FunAdSlot funAdSlot = new FunAdSlot();
            funAdSlot.sid = this.sid;
            funAdSlot.expressWidth = this.expressWidth;
            funAdSlot.expressHeight = this.expressHeight;
            funAdSlot.adLoadMode = this.adLoadMode;
            funAdSlot.smallImgStyle = this.smallImgStyle;
            funAdSlot.adView = this.adView;
            return funAdSlot;
        }

        public Builder setAdLoadMode(AdLoadMode adLoadMode) {
            this.adLoadMode = adLoadMode;
            return this;
        }

        public Builder setAdView(FunAdView funAdView) {
            this.adView = funAdView;
            return this;
        }

        public Builder setExpressHeight(int i) {
            this.expressHeight = i;
            return this;
        }

        public Builder setExpressWidth(int i) {
            this.expressWidth = i;
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

    public AdLoadMode getAdLoadMode() {
        return this.adLoadMode;
    }

    public FunAdView getAdView() {
        return this.adView;
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
