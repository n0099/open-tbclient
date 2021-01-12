package com.kwai.player;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes4.dex */
public class KwaiPlayerConfig {
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION = 2000;
    public static final int DEFAULT_QOS_TICK_DURATION = 10000;
    private int mBufferIncrementStep;
    private int mBufferSmoothTime;
    private EnumBufferStrategy mBufferStrategy;
    private boolean mEnableLiveAdaptiveAdditionalQos;
    private boolean mEnableLiveAdaptiveQos;
    private boolean mEnableQos;
    private int mFirstBufferTime;
    private long mLiveAdaptiveQosDuration;
    private int mMaxBufferDuration;
    private int mMaxBufferTime;
    private int mMinBufferTime;
    private long mQosDuration;

    /* loaded from: classes4.dex */
    public static class Builder {
        private boolean mEnableQos = false;
        private long mQosDuration = 10000;
        private boolean mEnableLiveAdaptiveQos = false;
        private boolean mEnableLiveAdaptiveAdditionalQos = false;
        private long mLiveAdaptiveQosDuration = 2000;
        private int mFirstBufferTime = 100;
        private int mMinBufferTime = 100;
        private int mMaxBufferTime = 5000;
        private int mBufferIncrementStep = 100;
        private int mBufferSmoothTime = 20000;
        private int mMaxBufferDurMs = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        private EnumBufferStrategy mBufferStrategy = EnumBufferStrategy.LINEAR_INCREASE_BUFFER_STRATEGY;

        public KwaiPlayerConfig build() {
            return new KwaiPlayerConfig(this);
        }

        public Builder setBufferIncrementStep(int i) {
            this.mBufferIncrementStep = i;
            return this;
        }

        public Builder setBufferSmoothTime(int i) {
            this.mBufferSmoothTime = i;
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

        public Builder setFirstBufferTime(int i) {
            this.mFirstBufferTime = i;
            return this;
        }

        public Builder setLiveAdaptiveQosDuration(long j) {
            this.mLiveAdaptiveQosDuration = j;
            return this;
        }

        public Builder setMaxBufferDuration(int i) {
            this.mMaxBufferDurMs = i;
            return this;
        }

        public Builder setMaxBufferTime(int i) {
            this.mMaxBufferTime = i;
            return this;
        }

        public Builder setMinBufferTime(int i) {
            this.mMinBufferTime = i;
            return this;
        }

        public Builder setQosDuration(long j) {
            this.mQosDuration = j;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public enum EnumBufferStrategy {
        LINEAR_INCREASE_BUFFER_STRATEGY(1),
        LOG_INCREASE_BUFFER_STRATEGY(2);
        
        private final int value;

        EnumBufferStrategy(int i) {
            this.value = i;
        }

        public static EnumBufferStrategy valueOf(int i) {
            switch (i) {
                case 1:
                    return LINEAR_INCREASE_BUFFER_STRATEGY;
                case 2:
                    return LOG_INCREASE_BUFFER_STRATEGY;
                default:
                    return null;
            }
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
