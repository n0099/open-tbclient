package com.google.android.exoplayer2.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class DecoderInputBuffer extends Buffer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo;
    public ByteBuffer data;
    public long timeUs;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface BufferReplacementMode {
    }

    public DecoderInputBuffer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cryptoInfo = new CryptoInfo();
        this.bufferReplacementMode = i;
    }

    public void ensureSpaceForWrite(int i) throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer == null) {
                this.data = createReplacementByteBuffer(i);
                return;
            }
            int capacity = byteBuffer.capacity();
            int position = this.data.position();
            int i2 = i + position;
            if (capacity >= i2) {
                return;
            }
            ByteBuffer createReplacementByteBuffer = createReplacementByteBuffer(i2);
            if (position > 0) {
                this.data.position(0);
                this.data.limit(position);
                createReplacementByteBuffer.put(this.data);
            }
            this.data = createReplacementByteBuffer;
        }
    }

    private ByteBuffer createReplacementByteBuffer(int i) {
        InterceptResult invokeI;
        int capacity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            int i2 = this.bufferReplacementMode;
            if (i2 == 1) {
                return ByteBuffer.allocate(i);
            }
            if (i2 == 2) {
                return ByteBuffer.allocateDirect(i);
            }
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer == null) {
                capacity = 0;
            } else {
                capacity = byteBuffer.capacity();
            }
            throw new IllegalStateException("Buffer too small (" + capacity + " < " + i + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (ByteBuffer) invokeI.objValue;
    }

    public static DecoderInputBuffer newFlagsOnlyInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new DecoderInputBuffer(0);
        }
        return (DecoderInputBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.clear();
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
        }
    }

    public final void flip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.data.flip();
        }
    }

    public final boolean isEncrypted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getFlag(1073741824);
        }
        return invokeV.booleanValue;
    }

    public final boolean isFlagsOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.data == null && this.bufferReplacementMode == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
