package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes6.dex */
public class PoolConfig {
    public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;
    public final int mBitmapPoolMaxBitmapSize;
    public final int mBitmapPoolMaxPoolSize;
    public final PoolParams mBitmapPoolParams;
    public final PoolStatsTracker mBitmapPoolStatsTracker;
    public final String mBitmapPoolType;
    public final PoolParams mFlexByteArrayPoolParams;
    public final PoolParams mMemoryChunkPoolParams;
    public final PoolStatsTracker mMemoryChunkPoolStatsTracker;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
    public final PoolParams mSmallByteArrayPoolParams;
    public final PoolStatsTracker mSmallByteArrayPoolStatsTracker;

    /* loaded from: classes6.dex */
    public static class Builder {
        public int mBitmapPoolMaxBitmapSize;
        public int mBitmapPoolMaxPoolSize;
        public PoolParams mBitmapPoolParams;
        public PoolStatsTracker mBitmapPoolStatsTracker;
        public String mBitmapPoolType;
        public PoolParams mFlexByteArrayPoolParams;
        public PoolParams mMemoryChunkPoolParams;
        public PoolStatsTracker mMemoryChunkPoolStatsTracker;
        public MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        public boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
        public PoolParams mSmallByteArrayPoolParams;
        public PoolStatsTracker mSmallByteArrayPoolStatsTracker;

        public PoolConfig build() {
            return new PoolConfig(this);
        }

        public Builder setBitmapPoolMaxBitmapSize(int i) {
            this.mBitmapPoolMaxBitmapSize = i;
            return this;
        }

        public Builder setBitmapPoolMaxPoolSize(int i) {
            this.mBitmapPoolMaxPoolSize = i;
            return this;
        }

        public Builder setBitmapPoolParams(PoolParams poolParams) {
            this.mBitmapPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setBitmapPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.mBitmapPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public Builder setBitmapPoolType(String str) {
            this.mBitmapPoolType = str;
            return this;
        }

        public Builder setFlexByteArrayPoolParams(PoolParams poolParams) {
            this.mFlexByteArrayPoolParams = poolParams;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public Builder setNativeMemoryChunkPoolParams(PoolParams poolParams) {
            this.mMemoryChunkPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.mMemoryChunkPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public void setRegisterLruBitmapPoolAsMemoryTrimmable(boolean z) {
            this.mRegisterLruBitmapPoolAsMemoryTrimmable = z;
        }

        public Builder setSmallByteArrayPoolParams(PoolParams poolParams) {
            this.mSmallByteArrayPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.mSmallByteArrayPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getBitmapPoolMaxBitmapSize() {
        return this.mBitmapPoolMaxBitmapSize;
    }

    public int getBitmapPoolMaxPoolSize() {
        return this.mBitmapPoolMaxPoolSize;
    }

    public PoolParams getBitmapPoolParams() {
        return this.mBitmapPoolParams;
    }

    public PoolStatsTracker getBitmapPoolStatsTracker() {
        return this.mBitmapPoolStatsTracker;
    }

    public String getBitmapPoolType() {
        return this.mBitmapPoolType;
    }

    public PoolParams getFlexByteArrayPoolParams() {
        return this.mFlexByteArrayPoolParams;
    }

    public PoolParams getMemoryChunkPoolParams() {
        return this.mMemoryChunkPoolParams;
    }

    public PoolStatsTracker getMemoryChunkPoolStatsTracker() {
        return this.mMemoryChunkPoolStatsTracker;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public PoolParams getSmallByteArrayPoolParams() {
        return this.mSmallByteArrayPoolParams;
    }

    public PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        return this.mSmallByteArrayPoolStatsTracker;
    }

    public boolean isRegisterLruBitmapPoolAsMemoryTrimmable() {
        return this.mRegisterLruBitmapPoolAsMemoryTrimmable;
    }

    public PoolConfig(Builder builder) {
        PoolParams poolParams;
        PoolStatsTracker poolStatsTracker;
        PoolParams poolParams2;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        PoolParams poolParams3;
        PoolStatsTracker poolStatsTracker2;
        PoolParams poolParams4;
        PoolStatsTracker poolStatsTracker3;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PoolConfig()");
        }
        if (builder.mBitmapPoolParams != null) {
            poolParams = builder.mBitmapPoolParams;
        } else {
            poolParams = DefaultBitmapPoolParams.get();
        }
        this.mBitmapPoolParams = poolParams;
        if (builder.mBitmapPoolStatsTracker != null) {
            poolStatsTracker = builder.mBitmapPoolStatsTracker;
        } else {
            poolStatsTracker = NoOpPoolStatsTracker.getInstance();
        }
        this.mBitmapPoolStatsTracker = poolStatsTracker;
        if (builder.mFlexByteArrayPoolParams != null) {
            poolParams2 = builder.mFlexByteArrayPoolParams;
        } else {
            poolParams2 = DefaultFlexByteArrayPoolParams.get();
        }
        this.mFlexByteArrayPoolParams = poolParams2;
        if (builder.mMemoryTrimmableRegistry != null) {
            memoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        } else {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        }
        this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
        if (builder.mMemoryChunkPoolParams != null) {
            poolParams3 = builder.mMemoryChunkPoolParams;
        } else {
            poolParams3 = DefaultNativeMemoryChunkPoolParams.get();
        }
        this.mMemoryChunkPoolParams = poolParams3;
        if (builder.mMemoryChunkPoolStatsTracker != null) {
            poolStatsTracker2 = builder.mMemoryChunkPoolStatsTracker;
        } else {
            poolStatsTracker2 = NoOpPoolStatsTracker.getInstance();
        }
        this.mMemoryChunkPoolStatsTracker = poolStatsTracker2;
        if (builder.mSmallByteArrayPoolParams != null) {
            poolParams4 = builder.mSmallByteArrayPoolParams;
        } else {
            poolParams4 = DefaultByteArrayPoolParams.get();
        }
        this.mSmallByteArrayPoolParams = poolParams4;
        if (builder.mSmallByteArrayPoolStatsTracker != null) {
            poolStatsTracker3 = builder.mSmallByteArrayPoolStatsTracker;
        } else {
            poolStatsTracker3 = NoOpPoolStatsTracker.getInstance();
        }
        this.mSmallByteArrayPoolStatsTracker = poolStatsTracker3;
        this.mBitmapPoolType = builder.mBitmapPoolType == null ? "legacy" : builder.mBitmapPoolType;
        this.mBitmapPoolMaxPoolSize = builder.mBitmapPoolMaxPoolSize;
        this.mBitmapPoolMaxBitmapSize = builder.mBitmapPoolMaxBitmapSize > 0 ? builder.mBitmapPoolMaxBitmapSize : 4194304;
        this.mRegisterLruBitmapPoolAsMemoryTrimmable = builder.mRegisterLruBitmapPoolAsMemoryTrimmable;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }
}
