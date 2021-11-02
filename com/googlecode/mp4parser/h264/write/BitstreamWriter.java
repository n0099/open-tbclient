package com.googlecode.mp4parser.h264.write;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            for (int i2 = this.curBit; i2 < 8; i2++) {
                this.curByte[i2] = 0;
            }
            this.curBit = 0;
            writeCurByte();
        }
    }

    public void write1Bit(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            Debug.print(i2);
            if (this.curBit == 8) {
                this.curBit = 0;
                writeCurByte();
            }
            int[] iArr = this.curByte;
            int i3 = this.curBit;
            this.curBit = i3 + 1;
            iArr[i3] = i2;
        }
    }

    public void writeByte(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.os.write(i2);
        }
    }

    public void writeNBit(long j, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                write1Bit(((int) (j >> ((i2 - i3) - 1))) & 1);
            }
        }
    }

    public void writeRemainingZero() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            writeNBit(0L, 8 - this.curBit);
        }
    }
}
