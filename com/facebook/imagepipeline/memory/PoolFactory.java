package com.facebook.imagepipeline.memory;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class PoolFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MemoryChunkPool mAshmemMemoryChunkPool;
    public BitmapPool mBitmapPool;
    @Nullable
    public MemoryChunkPool mBufferMemoryChunkPool;
    public final PoolConfig mConfig;
    public FlexByteArrayPool mFlexByteArrayPool;
    @Nullable
    public MemoryChunkPool mNativeMemoryChunkPool;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConfig = (PoolConfig) Preconditions.checkNotNull(poolConfig);
    }

    public PooledByteBufferFactory getPooledByteBufferFactory(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.mPooledByteBufferFactory == null) {
                MemoryChunkPool memoryChunkPool = getMemoryChunkPool(i);
                Preconditions.checkNotNull(memoryChunkPool, "failed to get pool for chunk type: " + i);
                this.mPooledByteBufferFactory = new MemoryPooledByteBufferFactory(getMemoryChunkPool(i), getPooledByteStreams());
            }
            return this.mPooledByteBufferFactory;
        }
        return (PooledByteBufferFactory) invokeI.objValue;
    }

    @Nullable
    private MemoryChunkPool getAshmemMemoryChunkPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mAshmemMemoryChunkPool == null) {
                try {
                    this.mAshmemMemoryChunkPool = (MemoryChunkPool) Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
                } catch (ClassNotFoundException unused) {
                    this.mAshmemMemoryChunkPool = null;
                } catch (IllegalAccessException unused2) {
                    this.mAshmemMemoryChunkPool = null;
                } catch (InstantiationException unused3) {
                    this.mAshmemMemoryChunkPool = null;
                } catch (NoSuchMethodException unused4) {
                    this.mAshmemMemoryChunkPool = null;
                } catch (InvocationTargetException unused5) {
                    this.mAshmemMemoryChunkPool = null;
                }
            }
            return this.mAshmemMemoryChunkPool;
        }
        return (MemoryChunkPool) invokeV.objValue;
    }

    @Nullable
    public MemoryChunkPool getBufferMemoryChunkPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mBufferMemoryChunkPool == null) {
                try {
                    this.mBufferMemoryChunkPool = (MemoryChunkPool) Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
                } catch (ClassNotFoundException unused) {
                    this.mBufferMemoryChunkPool = null;
                } catch (IllegalAccessException unused2) {
                    this.mBufferMemoryChunkPool = null;
                } catch (InstantiationException unused3) {
                    this.mBufferMemoryChunkPool = null;
                } catch (NoSuchMethodException unused4) {
                    this.mBufferMemoryChunkPool = null;
                } catch (InvocationTargetException unused5) {
                    this.mBufferMemoryChunkPool = null;
                }
            }
            return this.mBufferMemoryChunkPool;
        }
        return (MemoryChunkPool) invokeV.objValue;
    }

    @Nullable
    public MemoryChunkPool getNativeMemoryChunkPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mNativeMemoryChunkPool == null) {
                try {
                    this.mNativeMemoryChunkPool = (MemoryChunkPool) Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
                } catch (ClassNotFoundException e) {
                    FLog.e("PoolFactory", "", e);
                    this.mNativeMemoryChunkPool = null;
                } catch (IllegalAccessException e2) {
                    FLog.e("PoolFactory", "", e2);
                    this.mNativeMemoryChunkPool = null;
                } catch (InstantiationException e3) {
                    FLog.e("PoolFactory", "", e3);
                    this.mNativeMemoryChunkPool = null;
                } catch (NoSuchMethodException e4) {
                    FLog.e("PoolFactory", "", e4);
                    this.mNativeMemoryChunkPool = null;
                } catch (InvocationTargetException e5) {
                    FLog.e("PoolFactory", "", e5);
                    this.mNativeMemoryChunkPool = null;
                }
            }
            return this.mNativeMemoryChunkPool;
        }
        return (MemoryChunkPool) invokeV.objValue;
    }

    @Nullable
    private MemoryChunkPool getMemoryChunkPool(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return getAshmemMemoryChunkPool();
                    }
                    throw new IllegalArgumentException("Invalid MemoryChunkType");
                }
                return getBufferMemoryChunkPool();
            }
            return getNativeMemoryChunkPool();
        }
        return (MemoryChunkPool) invokeI.objValue;
    }

    public BitmapPool getBitmapPool() {
        InterceptResult invokeV;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mBitmapPool == null) {
                String bitmapPoolType = this.mConfig.getBitmapPoolType();
                char c = 65535;
                switch (bitmapPoolType.hashCode()) {
                    case -1868884870:
                        if (bitmapPoolType.equals(BitmapPoolType.LEGACY_DEFAULT_PARAMS)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1106578487:
                        if (bitmapPoolType.equals("legacy")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -404562712:
                        if (bitmapPoolType.equals(BitmapPoolType.EXPERIMENTAL)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -402149703:
                        if (bitmapPoolType.equals(BitmapPoolType.DUMMY_WITH_TRACKING)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 95945896:
                        if (bitmapPoolType.equals(BitmapPoolType.DUMMY)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (Build.VERSION.SDK_INT >= 21) {
                                    this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                                } else {
                                    this.mBitmapPool = new DummyBitmapPool();
                                }
                            } else {
                                this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), DefaultBitmapPoolParams.get(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                            }
                        } else {
                            int bitmapPoolMaxPoolSize = this.mConfig.getBitmapPoolMaxPoolSize();
                            int bitmapPoolMaxBitmapSize = this.mConfig.getBitmapPoolMaxBitmapSize();
                            NoOpPoolStatsTracker noOpPoolStatsTracker = NoOpPoolStatsTracker.getInstance();
                            if (this.mConfig.isRegisterLruBitmapPoolAsMemoryTrimmable()) {
                                memoryTrimmableRegistry = this.mConfig.getMemoryTrimmableRegistry();
                            } else {
                                memoryTrimmableRegistry = null;
                            }
                            this.mBitmapPool = new LruBitmapPool(bitmapPoolMaxPoolSize, bitmapPoolMaxBitmapSize, noOpPoolStatsTracker, memoryTrimmableRegistry);
                        }
                    } else {
                        this.mBitmapPool = new DummyTrackingInUseBitmapPool();
                    }
                } else {
                    this.mBitmapPool = new DummyBitmapPool();
                }
            }
            return this.mBitmapPool;
        }
        return (BitmapPool) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mConfig.getFlexByteArrayPoolParams().maxNumThreads;
        }
        return invokeV.intValue;
    }

    public PooledByteBufferFactory getPooledByteBufferFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getPooledByteBufferFactory(!NativeCodeSetup.getUseNativeCode() ? 1 : 0);
        }
        return (PooledByteBufferFactory) invokeV.objValue;
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
}
