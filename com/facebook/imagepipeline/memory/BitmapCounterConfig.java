package com.facebook.imagepipeline.memory;
/* loaded from: classes9.dex */
public class BitmapCounterConfig {
    public static final int DEFAULT_MAX_BITMAP_COUNT = 384;
    public int mMaxBitmapCount;

    /* loaded from: classes9.dex */
    public static class Builder {
        public int mMaxBitmapCount;

        public Builder() {
            this.mMaxBitmapCount = 384;
        }

        public BitmapCounterConfig build() {
            return new BitmapCounterConfig(this);
        }

        public int getMaxBitmapCount() {
            return this.mMaxBitmapCount;
        }

        public Builder setMaxBitmapCount(int i) {
            this.mMaxBitmapCount = i;
            return this;
        }
    }

    public BitmapCounterConfig(Builder builder) {
        this.mMaxBitmapCount = 384;
        this.mMaxBitmapCount = builder.getMaxBitmapCount();
    }

    public void setMaxBitmapCount(int i) {
        this.mMaxBitmapCount = i;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getMaxBitmapCount() {
        return this.mMaxBitmapCount;
    }
}
