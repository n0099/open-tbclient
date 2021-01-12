package com.kwad.sdk.lib.desigin;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public class CustomAppBarBehaviorParams {
    public final boolean mEnableNestedFling;
    public final boolean mEnableRebound;
    public final int mExtraFixedSize;
    public final int mFlingConsumeViewId;
    public final int mReboundMaxOffset;
    public final int mReboundViewId;

    /* loaded from: classes4.dex */
    public static class Builder {
        private boolean mEnableNestedFling;
        private boolean mEnableRebound = true;
        private int mExtraFixedSize;
        private int mFlingConsumeViewId;
        private int mReboundMaxOffset;
        private int mReboundViewId;

        public CustomAppBarBehaviorParams build() {
            return new CustomAppBarBehaviorParams(this);
        }

        public Builder setEnableNestedFling(boolean z) {
            this.mEnableNestedFling = z;
            return this;
        }

        public Builder setEnableRebound(boolean z) {
            this.mEnableRebound = z;
            return this;
        }

        public Builder setExtraFixedSize(int i) {
            this.mExtraFixedSize = i;
            return this;
        }

        public Builder setFlingConsumeViewId(int i) {
            this.mFlingConsumeViewId = i;
            return this;
        }

        public Builder setReboundMaxOffset(int i) {
            this.mReboundMaxOffset = i;
            return this;
        }

        public Builder setReboundViewId(int i) {
            this.mReboundViewId = i;
            return this;
        }
    }

    private CustomAppBarBehaviorParams(Builder builder) {
        this.mFlingConsumeViewId = builder.mFlingConsumeViewId;
        this.mExtraFixedSize = builder.mExtraFixedSize;
        this.mEnableNestedFling = builder.mEnableNestedFling;
        this.mReboundMaxOffset = builder.mReboundMaxOffset;
        this.mReboundViewId = builder.mReboundViewId;
        this.mEnableRebound = builder.mEnableRebound;
    }
}
