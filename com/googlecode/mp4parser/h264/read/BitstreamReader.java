package com.googlecode.mp4parser.h264.read;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.CharCache;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class BitstreamReader {
    public static /* synthetic */ Interceptable $ic;
    public static int bitsRead;
    public transient /* synthetic */ FieldHolder $fh;
    public int curByte;
    public CharCache debugBits;
    public InputStream is;
    public int nBit;
    public int nextByte;

    public BitstreamReader(InputStream inputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.debugBits = new CharCache(50);
        this.is = inputStream;
        this.curByte = inputStream.read();
        this.nextByte = inputStream.read();
    }

    private void advance() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.curByte = this.nextByte;
            this.nextByte = this.is.read();
            this.nBit = 0;
        }
    }

    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public long getBitPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (bitsRead * 8) + (this.nBit % 8) : invokeV.longValue;
    }

    public int getCurBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nBit : invokeV.intValue;
    }

    public boolean isByteAligned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.nBit % 8 == 0 : invokeV.booleanValue;
    }

    public boolean moreRBSPData() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.nBit == 8) {
                advance();
            }
            int i = 1 << ((8 - this.nBit) - 1);
            return (this.curByte == -1 || (this.nextByte == -1 && ((((i << 1) - 1) & this.curByte) == i))) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int peakNextBits(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i <= 8) {
                if (this.nBit == 8) {
                    advance();
                    if (this.curByte == -1) {
                        return -1;
                    }
                }
                int i2 = this.nBit;
                int[] iArr = new int[16 - i2];
                int i3 = 0;
                while (i2 < 8) {
                    iArr[i3] = (this.curByte >> (7 - i2)) & 1;
                    i2++;
                    i3++;
                }
                int i4 = 0;
                while (i4 < 8) {
                    iArr[i3] = (this.nextByte >> (7 - i4)) & 1;
                    i4++;
                    i3++;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < i; i6++) {
                    i5 = (i5 << 1) | iArr[i6];
                }
                return i5;
            }
            throw new IllegalArgumentException("N should be less then 8");
        }
        return invokeI.intValue;
    }

    public int read1Bit() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.nBit == 8) {
                advance();
                if (this.curByte == -1) {
                    return -1;
                }
            }
            int i = this.curByte;
            int i2 = this.nBit;
            int i3 = (i >> (7 - i2)) & 1;
            this.nBit = i2 + 1;
            this.debugBits.append(i3 == 0 ? '0' : '1');
            bitsRead++;
            return i3;
        }
        return invokeV.intValue;
    }

    public int readByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.nBit > 0) {
                advance();
            }
            int i = this.curByte;
            advance();
            return i;
        }
        return invokeV.intValue;
    }

    public long readNBit(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i <= 64) {
                long j = 0;
                for (int i2 = 0; i2 < i; i2++) {
                    j = (j << 1) | read1Bit();
                }
                return j;
            }
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        return invokeI.longValue;
    }

    public long readRemainingByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? readNBit(8 - this.nBit) : invokeV.longValue;
    }
}
