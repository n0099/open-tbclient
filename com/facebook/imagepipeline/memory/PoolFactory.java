package com.facebook.imagepipeline.memory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class PoolFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BitmapPool mBitmapPool;
    public BufferMemoryChunkPool mBufferMemoryChunkPool;
    public final PoolConfig mConfig;
    public FlexByteArrayPool mFlexByteArrayPool;
    public NativeMemoryChunkPool mNativeMemoryChunkPool;
    public PooledByteBufferFactory mPooledByteBufferFactory;
    public PooledByteStreams mPooledByteStreams;
    public SharedByteArray mSharedByteArray;
    public ByteArrayPool mSmallByteArrayPool;

    public PoolFactory(PoolConfig poolConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poolConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConfig = (PoolConfig) Preconditions.checkNotNull(poolConfig);
    }

    private MemoryChunkPool getMemoryChunkPool(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            if (i2 != 0) {
                if (i2 == 1) {
                    return getBufferMemoryChunkPool();
                }
                throw new IllegalArgumentException("Invalid MemoryChunkType");
            }
            return getNativeMemoryChunkPool();
        }
        return (MemoryChunkPool) invokeI.objValue;
    }

    public BitmapPool getBitmapPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mBitmapPool == null) {
                String bitmapPoolType = this.mConfig.getBitmapPoolType();
                char c2 = 65535;
                switch (bitmapPoolType.hashCode()) {
                    case -1868884870:
                        if (bitmapPoolType.equals(BitmapPoolType.LEGACY_DEFAULT_PARAMS)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1106578487:
                        if (bitmapPoolType.equals("legacy")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -404562712:
                        if (bitmapPoolType.equals(BitmapPoolType.EXPERIMENTAL)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 95945896:
                        if (bitmapPoolType.equals(BitmapPoolType.DUMMY)) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    this.mBitmapPool = new DummyBitmapPool();
                } else if (c2 == 1) {
                    this.mBitmapPool = new LruBitmapPool(this.mConfig.getBitmapPoolMaxPoolSize(), this.mConfig.getBitmapPoolMaxBitmapSize(), NoOpPoolStatsTracker.getInstance(), this.mConfig.isRegisterLruBitmapPoolAsMemoryTrimmable() ? this.mConfig.getMemoryTrimmableRegistry() : null);
                } else if (c2 != 2) {
                    this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker());
                } else {
                    this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), DefaultBitmapPoolParams.get(), this.mConfig.getBitmapPoolStatsTracker());
                }
            }
            return this.mBitmapPool;
        }
        return (BitmapPool) invokeV.objValue;
    }

    public BufferMemoryChunkPool getBufferMemoryChunkPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mBufferMemoryChunkPool == null) {
                this.mBufferMemoryChunkPool = new BufferMemoryChunkPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
            }
            return this.mBufferMemoryChunkPool;
        }
        return (BufferMemoryChunkPool) invokeV.objValue;
    }

    public FlexByteArrayPool getFlexByteArrayPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mFlexByteArrayPool == null) {
                this.mFlexByteArrayPool = new FlexByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
            }
            return this.mFlexByteArrayPool;
        }
        return (FlexByteArrayPool) invokeV.objValue;
    }

    public int getFlexByteArrayPoolMaxNumThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mConfig.getFlexByteArrayPoolParams().maxNumThreads : invokeV.intValue;
    }

    public NativeMemoryChunkPool getNativeMemoryChunkPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mNativeMemoryChunkPool == null) {
                this.mNativeMemoryChunkPool = new NativeMemoryChunkPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
            }
            return this.mNativeMemoryChunkPool;
        }
        return (NativeMemoryChunkPool) invokeV.objValue;
    }

    public PooledByteBufferFactory getPooledByteBufferFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getPooledByteBufferFactory(0) : (PooledByteBufferFactory) invokeV.objValue;
    }

    public PooledByteStreams getPooledByteStreams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mPooledByteStreams == null) {
                this.mPooledByteStreams = new PooledByteStreams(getSmallByteArrayPool());
            }
            return this.mPooledByteStreams;
        }
        return (PooledByteStreams) invokeV.objValue;
    }

    public SharedByteArray getSharedByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mSharedByteArray == null) {
                this.mSharedByteArray = new SharedByteArray(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
            }
            return this.mSharedByteArray;
        }
        return (SharedByteArray) invokeV.objValue;
    }

    public ByteArrayPool getSmallByteArrayPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mSmallByteArrayPool == null) {
                this.mSmallByteArrayPool = new GenericByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getSmallByteArrayPoolParams(), this.mConfig.getSmallByteArrayPoolStatsTracker());
            }
            return this.mSmallByteArrayPool;
        }
        return (ByteArrayPool) invokeV.objValue;
    }

    public PooledByteBufferFactory getPooledByteBufferFactory(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.mPooledByteBufferFactory == null) {
                this.mPooledByteBufferFactory = new MemoryPooledByteBufferFactory(getMemoryChunkPool(i2), getPooledByteStreams());
            }
            return this.mPooledByteBufferFactory;
        }
        return (PooledByteBufferFactory) invokeI.objValue;
    }
}
