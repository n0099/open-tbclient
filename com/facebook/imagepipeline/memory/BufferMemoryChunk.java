package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class BufferMemoryChunk implements MemoryChunk, Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BufferMemoryChunk";
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer mBuffer;
    public final long mId;
    public final int mSize;

    public BufferMemoryChunk(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBuffer = ByteBuffer.allocateDirect(i2);
        this.mSize = i2;
        this.mId = System.identityHashCode(this);
    }

    private void doCopy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), memoryChunk, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (memoryChunk instanceof BufferMemoryChunk) {
                Preconditions.checkState(!isClosed());
                Preconditions.checkState(!memoryChunk.isClosed());
                MemoryChunkUtil.checkBounds(i2, memoryChunk.getSize(), i3, i4, this.mSize);
                this.mBuffer.position(i2);
                memoryChunk.getByteBuffer().position(i3);
                byte[] bArr = new byte[i4];
                this.mBuffer.get(bArr, 0, i4);
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
                this.mBuffer = null;
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), memoryChunk, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            Preconditions.checkNotNull(memoryChunk);
            if (memoryChunk.getUniqueId() == getUniqueId()) {
                Log.w(TAG, "Copying from BufferMemoryChunk " + Long.toHexString(getUniqueId()) + " to BufferMemoryChunk " + Long.toHexString(memoryChunk.getUniqueId()) + " which are the same ");
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
    public synchronized ByteBuffer getByteBuffer() {
        InterceptResult invokeV;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                byteBuffer = this.mBuffer;
            }
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
        }
        return invokeV.longValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSize : invokeV.intValue;
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
                z = this.mBuffer == null;
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
                adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
                MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
                this.mBuffer.position(i2);
                this.mBuffer.get(bArr, i3, adjustByteCount);
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
                adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
                MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
                this.mBuffer.position(i2);
                this.mBuffer.put(bArr, i3, adjustByteCount);
            }
            return adjustByteCount;
        }
        return invokeCommon.intValue;
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
                if (i2 >= this.mSize) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                b2 = this.mBuffer.get(i2);
            }
            return b2;
        }
        return invokeI.byteValue;
    }
}
