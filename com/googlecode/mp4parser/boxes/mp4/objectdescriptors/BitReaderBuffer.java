package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class BitReaderBuffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer buffer;
    public int initialPos;
    public int position;

    public BitReaderBuffer(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public int byteSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = 8 - (this.position % 8);
            if (i == 8) {
                i = 0;
            }
            readBits(i);
            return i;
        }
        return invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.position : invokeV.intValue;
    }

    public int readBits(int i) {
        InterceptResult invokeI;
        int readBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int i2 = this.buffer.get(this.initialPos + (this.position / 8));
            if (i2 < 0) {
                i2 += 256;
            }
            int i3 = this.position;
            int i4 = 8 - (i3 % 8);
            if (i <= i4) {
                readBits = ((i2 << (i3 % 8)) & 255) >> ((i3 % 8) + (i4 - i));
                this.position = i3 + i;
            } else {
                int i5 = i - i4;
                readBits = (readBits(i4) << i5) + readBits(i5);
            }
            this.buffer.position(this.initialPos + ((int) Math.ceil(this.position / 8.0d)));
            return readBits;
        }
        return invokeI.intValue;
    }

    public int remainingBits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.buffer.limit() * 8) - this.position : invokeV.intValue;
    }
}
