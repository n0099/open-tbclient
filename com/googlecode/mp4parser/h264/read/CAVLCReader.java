package com.googlecode.mp4parser.h264.read;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.googlecode.mp4parser.h264.BTree;
import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class CAVLCReader extends BitstreamReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CAVLCReader(InputStream inputStream) throws IOException {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int readUE() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int i = 0;
            while (read1Bit() == 0) {
                i++;
            }
            if (i <= 0) {
                return 0;
            }
            return (int) (((1 << i) - 1) + readNBit(i));
        }
        return invokeV.intValue;
    }

    public boolean readAE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new UnsupportedOperationException("Stan");
        }
        return invokeV.booleanValue;
    }

    public int readAEI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new UnsupportedOperationException("Stan");
        }
        return invokeV.intValue;
    }

    public void readTrailingBits() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            read1Bit();
            readRemainingByte();
        }
    }

    private void trace(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) {
            StringBuilder sb = new StringBuilder();
            String valueOf = String.valueOf(BitstreamReader.bitsRead - this.debugBits.length());
            int length = 8 - valueOf.length();
            sb.append("@" + valueOf);
            for (int i = 0; i < length; i++) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            sb.append(str);
            int length2 = (100 - sb.length()) - this.debugBits.length();
            for (int i2 = 0; i2 < length2; i2++) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            sb.append(this.debugBits);
            sb.append(" (" + str2 + SmallTailInfo.EMOTION_SUFFIX);
            this.debugBits.clear();
            Debug.println(sb.toString());
        }
    }

    public byte[] read(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) readByte();
            }
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public boolean readBool(String str) throws IOException {
        InterceptResult invokeL;
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (read1Bit() == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            trace(str, str2);
            return z;
        }
        return invokeL.booleanValue;
    }

    public int readME(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return readUE(str);
        }
        return invokeL.intValue;
    }

    public int readSE(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            int readUE = readUE();
            int i = readUE & 1;
            int i2 = ((readUE >> 1) + i) * ((i << 1) - 1);
            trace(str, String.valueOf(i2));
            return i2;
        }
        return invokeL.intValue;
    }

    public int readTE(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i > 1) {
                return readUE();
            }
            return (~read1Bit()) & 1;
        }
        return invokeI.intValue;
    }

    public int readUE(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int readUE = readUE();
            trace(str, String.valueOf(readUE));
            return readUE;
        }
        return invokeL.intValue;
    }

    public int readZeroBitCount(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            int i = 0;
            while (read1Bit() == 0) {
                i++;
            }
            trace(str, String.valueOf(i));
            return i;
        }
        return invokeL.intValue;
    }

    public Object readCE(BTree bTree, String str) throws IOException {
        Object value;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bTree, str)) == null) {
            do {
                bTree = bTree.down(read1Bit());
                if (bTree != null) {
                    value = bTree.getValue();
                } else {
                    throw new RuntimeException("Illegal code");
                }
            } while (value == null);
            trace(str, value.toString());
            return value;
        }
        return invokeLL.objValue;
    }

    public long readNBit(int i, String str) throws IOException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, str)) == null) {
            long readNBit = readNBit(i);
            trace(str, String.valueOf(readNBit));
            return readNBit;
        }
        return invokeIL.longValue;
    }

    public int readU(int i, String str) throws IOException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, str)) == null) {
            return (int) readNBit(i, str);
        }
        return invokeIL.intValue;
    }
}
