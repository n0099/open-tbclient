package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
@TargetApi(27)
/* loaded from: classes11.dex */
public class AshmemMemoryChunk implements MemoryChunk, Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AshmemMemoryChunk";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ByteBuffer mByteBuffer;
    public final long mId;
    @Nullable
    public SharedMemory mSharedMemory;

    public AshmemMemoryChunk(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 > 0);
        try {
            SharedMemory create = SharedMemory.create(TAG, i2);
            this.mSharedMemory = create;
            this.mByteBuffer = create.mapReadWrite();
            this.mId = System.identityHashCode(this);
        } catch (ErrnoException e2) {
            throw new RuntimeException("Fail to create AshmemMemory", e2);
        }
    }

    private void doCopy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), memoryChunk, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (memoryChunk instanceof AshmemMemoryChunk) {
                Preconditions.checkState(!isClosed());
                Preconditions.checkState(!memoryChunk.isClosed());
                MemoryChunkUtil.checkBounds(i2, memoryChunk.getSize(), i3, i4, getSize());
                this.mByteBuffer.position(i2);
                memoryChunk.getByteBuffer().position(i3);
                byte[] bArr = new byte[i4];
                this.mByteBuffer.get(bArr, 0, i4);
                memoryChunk.getByteBuffer().put(bArr, 0, i4);
                return;
            }
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!isClosed()) {
                    SharedMemory.unmap(this.mByteBuffer);
                    this.mSharedMemory.close();
                    this.mByteBuffer = null;
                    this.mSharedMemory = null;
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), memoryChunk, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            Preconditions.checkNotNull(memoryChunk);
            if (memoryChunk.getUniqueId() == getUniqueId()) {
                String str = "Copying from AshmemMemoryChunk " + Long.toHexString(getUniqueId()) + " to AshmemMemoryChunk " + Long.toHexString(memoryChunk.getUniqueId()) + " which are the same ";
                Preconditions.checkArgument(false);
            }
            if (memoryChunk.getUniqueId() < getUniqueId()) {
                synchronized (memoryChunk) {
                    synchronized (this) {
                        doCopy(i2, memoryChunk, i3, i4);
                    }
                }
                return;
            }
            synchronized (this) {
                synchronized (memoryChunk) {
                    doCopy(i2, memoryChunk, i3, i4);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @Nullable
    public ByteBuffer getByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mByteBuffer : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
        }
        return invokeV.longValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Preconditions.checkState(!isClosed());
            return this.mSharedMemory.getSize();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mId : invokeV.longValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.mByteBuffer != null) {
                    z = this.mSharedMemory == null;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        int adjustByteCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(bArr);
                Preconditions.checkState(!isClosed());
                adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, getSize());
                MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, getSize());
                this.mByteBuffer.position(i2);
                this.mByteBuffer.get(bArr, i3, adjustByteCount);
            }
            return adjustByteCount;
        }
        return invokeCommon.intValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        int adjustByteCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(bArr);
                Preconditions.checkState(!isClosed());
                adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, getSize());
                MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, getSize());
                this.mByteBuffer.position(i2);
                this.mByteBuffer.put(bArr, i3, adjustByteCount);
            }
            return adjustByteCount;
        }
        return invokeCommon.intValue;
    }

    @VisibleForTesting
    public AshmemMemoryChunk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSharedMemory = null;
        this.mByteBuffer = null;
        this.mId = System.identityHashCode(this);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i2) {
        InterceptResult invokeI;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            synchronized (this) {
                boolean z = true;
                Preconditions.checkState(!isClosed());
                Preconditions.checkArgument(i2 >= 0);
                if (i2 >= getSize()) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                b2 = this.mByteBuffer.get(i2);
            }
            return b2;
        }
        return invokeI.byteValue;
    }
}
