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
    public final List initializationData;
    public final int nalUnitLengthFieldLength;

    public HevcConfig(List list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        InterceptResult invokeL;
        List singletonList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parsableByteArray)) == null) {
            try {
                parsableByteArray.skipBytes(21);
                int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int position = parsableByteArray.getPosition();
                int i = 0;
                for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                    parsableByteArray.skipBytes(1);
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                        i += readUnsignedShort2 + 4;
                        parsableByteArray.skipBytes(readUnsignedShort2);
                    }
                }
                parsableByteArray.setPosition(position);
                byte[] bArr = new byte[i];
                int i4 = 0;
                for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                    parsableByteArray.skipBytes(1);
                    int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                    for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
                        int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, i4, NalUnitUtil.NAL_START_CODE.length);
                        int length = i4 + NalUnitUtil.NAL_START_CODE.length;
                        System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                        i4 = length + readUnsignedShort4;
                        parsableByteArray.skipBytes(readUnsignedShort4);
                    }
                }
                if (i == 0) {
                    singletonList = null;
                } else {
                    singletonList = Collections.singletonList(bArr);
                }
                return new HevcConfig(singletonList, readUnsignedByte + 1);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing HEVC config", e);
            }
        }
        return (HevcConfig) invokeL.objValue;
    }
}
