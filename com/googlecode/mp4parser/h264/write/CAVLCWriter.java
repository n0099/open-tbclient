package com.googlecode.mp4parser.h264.write;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class CAVLCWriter extends BitstreamWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CAVLCWriter(OutputStream outputStream) {
        super(outputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((OutputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void writeBool(boolean z, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
            Debug.print(String.valueOf(str) + "\t");
            write1Bit(z ? 1 : 0);
            Debug.println("\t" + z);
        }
    }

    public void writeNBit(long j, int i, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            Debug.print(String.valueOf(str) + "\t");
            for (int i2 = 0; i2 < i; i2++) {
                write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
            }
            Debug.println("\t" + j);
        }
    }

    public void writeSE(int i, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            Debug.print(String.valueOf(str) + "\t");
            writeUE(((i << 1) * (i < 0 ? -1 : 1)) + (i <= 0 ? 0 : 1));
            Debug.println("\t" + i);
        }
    }

    public void writeSliceTrailingBits() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            throw new IllegalStateException("todo");
        }
    }

    public void writeTrailingBits() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            write1Bit(1);
            writeRemainingZero();
            flush();
        }
    }

    public void writeU(int i, int i2, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, str) == null) {
            Debug.print(String.valueOf(str) + "\t");
            writeNBit((long) i, i2);
            Debug.println("\t" + i);
        }
    }

    public void writeUE(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= 15) {
                    break;
                }
                int i5 = (1 << i3) + i4;
                if (i < i5) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                    i4 = i5;
                }
            }
            writeNBit(0L, i2);
            write1Bit(1);
            writeNBit(i - i4, i2);
        }
    }

    public void writeU(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            writeNBit(i, i2);
        }
    }

    public void writeUE(int i, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            Debug.print(String.valueOf(str) + "\t");
            writeUE(i);
            Debug.println("\t" + i);
        }
    }
}
