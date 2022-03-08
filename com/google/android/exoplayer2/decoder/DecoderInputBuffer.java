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

    public DecoderInputBuffer(int i2) {
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
        this.cryptoInfo = new CryptoInfo();
        this.bufferReplacementMode = i2;
    }

    private ByteBuffer createReplacementByteBuffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int i3 = this.bufferReplacementMode;
            if (i3 == 1) {
                return ByteBuffer.allocate(i2);
            }
            if (i3 == 2) {
                return ByteBuffer.allocateDirect(i2);
            }
            ByteBuffer byteBuffer = this.data;
            int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
            throw new IllegalStateException("Buffer too small (" + capacity + " < " + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (ByteBuffer) invokeI.objValue;
    }

    public static DecoderInputBuffer newFlagsOnlyInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new DecoderInputBuffer(0) : (DecoderInputBuffer) invokeV.objValue;
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

    public void ensureSpaceForWrite(int i2) throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer == null) {
                this.data = createReplacementByteBuffer(i2);
                return;
            }
            int capacity = byteBuffer.capacity();
            int position = this.data.position();
            int i3 = i2 + position;
            if (capacity >= i3) {
                return;
            }
            ByteBuffer createReplacementByteBuffer = createReplacementByteBuffer(i3);
            if (position > 0) {
                this.data.position(0);
                this.data.limit(position);
                createReplacementByteBuffer.put(this.data);
            }
            this.data = createReplacementByteBuffer;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getFlag(1073741824) : invokeV.booleanValue;
    }

    public final boolean isFlagsOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.data == null && this.bufferReplacementMode == 0 : invokeV.booleanValue;
    }
}
