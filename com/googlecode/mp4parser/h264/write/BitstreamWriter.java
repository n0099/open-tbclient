package com.googlecode.mp4parser.h264.write;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public class BitstreamWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int curBit;
    public int[] curByte;
    public final OutputStream os;

    public BitstreamWriter(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.curByte = new int[8];
        this.os = outputStream;
    }

    private void writeCurByte() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int[] iArr = this.curByte;
            this.os.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
        }
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i = this.curBit; i < 8; i++) {
                this.curByte[i] = 0;
            }
            this.curBit = 0;
            writeCurByte();
        }
    }

    public void writeRemainingZero() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            writeNBit(0L, 8 - this.curBit);
        }
    }

    public void write1Bit(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            Debug.print(i);
            if (this.curBit == 8) {
                this.curBit = 0;
                writeCurByte();
            }
            int[] iArr = this.curByte;
            int i2 = this.curBit;
            this.curBit = i2 + 1;
            iArr[i2] = i;
        }
    }

    public void writeByte(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.os.write(i);
        }
    }

    public void writeNBit(long j, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
            }
        }
    }
}
