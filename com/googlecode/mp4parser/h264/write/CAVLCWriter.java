package com.googlecode.mp4parser.h264.write;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
            write1Bit(z ? 1 : 0);
            Debug.println(TrackUI.SEPERATOR + z);
        }
    }

    public void writeNBit(long j2, int i2, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str}) == null) {
            Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
            for (int i3 = 0; i3 < i2; i3++) {
                write1Bit(((int) (j2 >> ((i2 - i3) - 1))) & 1);
            }
            Debug.println(TrackUI.SEPERATOR + j2);
        }
    }

    public void writeSE(int i2, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
            writeUE(((i2 << 1) * (i2 < 0 ? -1 : 1)) + (i2 <= 0 ? 0 : 1));
            Debug.println(TrackUI.SEPERATOR + i2);
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

    public void writeU(int i2, int i3, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, str) == null) {
            Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
            writeNBit((long) i2, i3);
            Debug.println(TrackUI.SEPERATOR + i2);
        }
    }

    public void writeUE(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= 15) {
                    break;
                }
                int i6 = (1 << i4) + i5;
                if (i2 < i6) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                    i5 = i6;
                }
            }
            writeNBit(0L, i3);
            write1Bit(1);
            writeNBit(i2 - i5, i3);
        }
    }

    public void writeU(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            writeNBit(i2, i3);
        }
    }

    public void writeUE(int i2, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
            writeUE(i2);
            Debug.println(TrackUI.SEPERATOR + i2);
        }
    }
}
