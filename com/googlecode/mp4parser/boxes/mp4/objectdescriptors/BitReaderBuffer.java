package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = 8 - (this.position % 8);
            if (i2 == 8) {
                i2 = 0;
            }
            readBits(i2);
            return i2;
        }
        return invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.position : invokeV.intValue;
    }

    public int readBits(int i2) {
        InterceptResult invokeI;
        int readBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int i3 = this.buffer.get(this.initialPos + (this.position / 8));
            if (i3 < 0) {
                i3 += 256;
            }
            int i4 = this.position;
            int i5 = 8 - (i4 % 8);
            if (i2 <= i5) {
                readBits = ((i3 << (i4 % 8)) & 255) >> ((i4 % 8) + (i5 - i2));
                this.position = i4 + i2;
            } else {
                int i6 = i2 - i5;
                readBits = (readBits(i5) << i6) + readBits(i6);
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
