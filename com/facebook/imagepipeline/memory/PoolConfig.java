package com.facebook.imagepipeline.memory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes4.dex */
public class PoolConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mBitmapPoolMaxBitmapSize;
    public final int mBitmapPoolMaxPoolSize;
    public final PoolParams mBitmapPoolParams;
    public final PoolStatsTracker mBitmapPoolStatsTracker;
    public final String mBitmapPoolType;
    public final PoolParams mFlexByteArrayPoolParams;
    public final boolean mIgnoreBitmapPoolHardCap;
    public final PoolParams mMemoryChunkPoolParams;
    public final PoolStatsTracker mMemoryChunkPoolStatsTracker;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
    public final PoolParams mSmallByteArrayPoolParams;
    public final PoolStatsTracker mSmallByteArrayPoolStatsTracker;

    /* renamed from: com.facebook.imagepipeline.memory.PoolConfig$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBitmapPoolMaxBitmapSize;
        public int mBitmapPoolMaxPoolSize;
        public PoolParams mBitmapPoolParams;
        public PoolStatsTracker mBitmapPoolStatsTracker;
        public String mBitmapPoolType;
        public PoolParams mFlexByteArrayPoolParams;
        public boolean mIgnoreBitmapPoolHardCap;
        public PoolParams mMemoryChunkPoolParams;
        public PoolStatsTracker mMemoryChunkPoolStatsTracker;
        public MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        public boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
        public PoolParams mSmallByteArrayPoolParams;
        public PoolStatsTracker mSmallByteArrayPoolStatsTracker;

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public PoolConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new PoolConfig(this, null) : (PoolConfig) invokeV.objValue;
        }

        public Builder setBitmapPoolMaxBitmapSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.mBitmapPoolMaxBitmapSize = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBitmapPoolMaxPoolSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.mBitmapPoolMaxPoolSize = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBitmapPoolParams(PoolParams poolParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, poolParams)) == null) {
                this.mBitmapPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBitmapPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, poolStatsTracker)) == null) {
                this.mBitmapPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBitmapPoolType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mBitmapPoolType = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFlexByteArrayPoolParams(PoolParams poolParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, poolParams)) == null) {
                this.mFlexByteArrayPoolParams = poolParams;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIgnoreBitmapPoolHardCap(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.mIgnoreBitmapPoolHardCap = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, memoryTrimmableRegistry)) == null) {
                this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNativeMemoryChunkPoolParams(PoolParams poolParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, poolParams)) == null) {
                this.mMemoryChunkPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, poolStatsTracker)) == null) {
                this.mMemoryChunkPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRegisterLruBitmapPoolAsMemoryTrimmable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.mRegisterLruBitmapPoolAsMemoryTrimmable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSmallByteArrayPoolParams(PoolParams poolParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, poolParams)) == null) {
                this.mSmallByteArrayPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, poolStatsTracker)) == null) {
                this.mSmallByteArrayPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ PoolConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder(null) : (Builder) invokeV.objValue;
    }

    public int getBitmapPoolMaxBitmapSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBitmapPoolMaxBitmapSize : invokeV.intValue;
    }

    public int getBitmapPoolMaxPoolSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBitmapPoolMaxPoolSize : invokeV.intValue;
    }

    public PoolParams getBitmapPoolParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBitmapPoolParams : (PoolParams) invokeV.objValue;
    }

    public PoolStatsTracker getBitmapPoolStatsTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBitmapPoolStatsTracker : (PoolStatsTracker) invokeV.objValue;
    }

    public String getBitmapPoolType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBitmapPoolType : (String) invokeV.objValue;
    }

    public PoolParams getFlexByteArrayPoolParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFlexByteArrayPoolParams : (PoolParams) invokeV.objValue;
    }

    public PoolParams getMemoryChunkPoolParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMemoryChunkPoolParams : (PoolParams) invokeV.objValue;
    }

    public PoolStatsTracker getMemoryChunkPoolStatsTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mMemoryChunkPoolStatsTracker : (PoolStatsTracker) invokeV.objValue;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mMemoryTrimmableRegistry : (MemoryTrimmableRegistry) invokeV.objValue;
    }

    public PoolParams getSmallByteArrayPoolParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSmallByteArrayPoolParams : (PoolParams) invokeV.objValue;
    }

    public PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSmallByteArrayPoolStatsTracker : (PoolStatsTracker) invokeV.objValue;
    }

    public boolean isIgnoreBitmapPoolHardCap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIgnoreBitmapPoolHardCap : invokeV.booleanValue;
    }

    public boolean isRegisterLruBitmapPoolAsMemoryTrimmable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRegisterLruBitmapPoolAsMemoryTrimmable : invokeV.booleanValue;
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        this.mIgnoreBitmapPoolHardCap = builder.mIgnoreBitmapPoolHardCap;
    }
}
