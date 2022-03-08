package com.google.android.exoplayer2.video;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class HevcConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    public HevcConfig(List<byte[]> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i2;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parsableByteArray)) == null) {
            try {
                parsableByteArray.skipBytes(21);
                int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int position = parsableByteArray.getPosition();
                int i2 = 0;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    parsableByteArray.skipBytes(1);
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                        i2 += readUnsignedShort2 + 4;
                        parsableByteArray.skipBytes(readUnsignedShort2);
                    }
                }
                parsableByteArray.setPosition(position);
                byte[] bArr = new byte[i2];
                int i5 = 0;
                for (int i6 = 0; i6 < readUnsignedByte2; i6++) {
                    parsableByteArray.skipBytes(1);
                    int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                    for (int i7 = 0; i7 < readUnsignedShort3; i7++) {
                        int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, i5, NalUnitUtil.NAL_START_CODE.length);
                        int length = i5 + NalUnitUtil.NAL_START_CODE.length;
                        System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                        i5 = length + readUnsignedShort4;
                        parsableByteArray.skipBytes(readUnsignedShort4);
                    }
                }
                return new HevcConfig(i2 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new ParserException("Error parsing HEVC config", e2);
            }
        }
        return (HevcConfig) invokeL.objValue;
    }
}
