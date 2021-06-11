package com.kwai.player;
/* loaded from: classes7.dex */
public class KwaiPlayerConfig {
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION = 2000;
    public static final int DEFAULT_QOS_TICK_DURATION = 10000;
    public int mBufferIncrementStep;
    public int mBufferSmoothTime;
    public EnumBufferStrategy mBufferStrategy;
    public boolean mEnableLiveAdaptiveAdditionalQos;
    public boolean mEnableLiveAdaptiveQos;
    public boolean mEnableQos;
    public int mFirstBufferTime;
    public long mLiveAdaptiveQosDuration;
    public int mMaxBufferDuration;
    public int mMaxBufferTime;
    public int mMinBufferTime;
    public long mQosDuration;

    /* loaded from: classes7.dex */
    public static class Builder {
        public boolean mEnableQos = false;
        public long mQosDuration = 10000;
        public boolean mEnableLiveAdaptiveQos = false;
        public boolean mEnableLiveAdaptiveAdditionalQos = false;
        public long mLiveAdaptiveQosDuration = 2000;
        public int mFirstBufferTime = 100;
        public int mMinBufferTime = 100;
        public int mMaxBufferTime = 5000;
        public int mBufferIncrementStep = 100;
        public int mBufferSmoothTime = 20000;
        public int mMaxBufferDurMs = 120000;
        public EnumBufferStrategy mBufferStrategy = EnumBufferStrategy.LINEAR_INCREASE_BUFFER_STRATEGY;

        public KwaiPlayerConfig build() {
            return new KwaiPlayerConfig(this);
        }

        public Builder setBufferIncrementStep(int i2) {
            this.mBufferIncrementStep = i2;
            return this;
        }

        public Builder setBufferSmoothTime(int i2) {
            this.mBufferSmoothTime = i2;
            return this;
        }

        public Builder setBufferStrategy(EnumBufferStrategy enumBufferStrategy) {
            this.mBufferStrategy = enumBufferStrategy;
            return this;
        }

        public Builder setEnableLiveAdaptiveAdditionalQos(boolean z) {
            this.mEnableLiveAdaptiveAdditionalQos = z;
            return this;
        }

        public Builder setEnableLiveAdaptiveQos(boolean z) {
            this.mEnableLiveAdaptiveQos = z;
            return this;
        }

        public Builder setEnableQos(boolean z) {
            this.mEnableQos = z;
            return this;
        }

        public Builder setFirstBufferTime(int i2) {
            this.mFirstBufferTime = i2;
            return this;
        }

        public Builder setLiveAdaptiveQosDuration(long j) {
            this.mLiveAdaptiveQosDuration = j;
            return this;
        }

        public Builder setMaxBufferDuration(int i2) {
            this.mMaxBufferDurMs = i2;
            return this;
        }

        public Builder setMaxBufferTime(int i2) {
            this.mMaxBufferTime = i2;
            return this;
        }

        public Builder setMinBufferTime(int i2) {
            this.mMinBufferTime = i2;
            return this;
        }

        public Builder setQosDuration(long j) {
            this.mQosDuration = j;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public enum EnumBufferStrategy {
        LINEAR_INCREASE_BUFFER_STRATEGY(1),
        LOG_INCREASE_BUFFER_STRATEGY(2);
        
        public final int value;

        EnumBufferStrategy(int i2) {
            this.value = i2;
        }

        public static EnumBufferStrategy valueOf(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return LOG_INCREASE_BUFFER_STRATEGY;
            }
            return LINEAR_INCREASE_BUFFER_STRATEGY;
        }

        public int getValue() {
            return this.value;
        }
    }

    public KwaiPlayerConfig(Builder builder) {
        this.mEnableQos = builder.mEnableQos;
        this.mQosDuration = builder.mQosDuration;
        this.mEnableLiveAdaptiveQos = builder.mEnableLiveAdaptiveQos;
        this.mEnableLiveAdaptiveAdditionalQos = builder.mEnableLiveAdaptiveAdditionalQos;
        this.mLiveAdaptiveQosDuration = builder.mLiveAdaptiveQosDuration;
        this.mBufferIncrementStep = builder.mBufferIncrementStep;
        this.mBufferSmoothTime = builder.mBufferSmoothTime;
        this.mFirstBufferTime = builder.mFirstBufferTime;
        this.mMinBufferTime = builder.mMinBufferTime;
        this.mMaxBufferTime = builder.mMaxBufferTime;
        this.mBufferStrategy = builder.mBufferStrategy;
        this.mMaxBufferDuration = builder.mMaxBufferDurMs;
    }

    public int getBufferIncrementStep() {
        return this.mBufferIncrementStep;
    }

    public int getBufferSmoothTime() {
        return this.mBufferSmoothTime;
    }

    public EnumBufferStrategy getBufferStrategy() {
        return this.mBufferStrategy;
    }

    public boolean getEnableLiveAdaptiveAdditionalQos() {
        return this.mEnableLiveAdaptiveAdditionalQos;
    }

    public boolean getEnableLiveAdaptiveQos() {
        return this.mEnableLiveAdaptiveQos;
    }

    public boolean getEnableQos() {
        return this.mEnableQos;
    }

    public int getFirstBufferTime() {
        return this.mFirstBufferTime;
    }

    public long getLiveAdaptiveQosDuration() {
        return this.mLiveAdaptiveQosDuration;
    }

    public int getMaxBufferDuration() {
        return this.mMaxBufferDuration;
    }

    public int getMaxBufferTime() {
        return this.mMaxBufferTime;
    }

    public int getMinBufferTime() {
        return this.mMinBufferTime;
    }

    public long getQosDuration() {
        return this.mQosDuration;
    }
}
