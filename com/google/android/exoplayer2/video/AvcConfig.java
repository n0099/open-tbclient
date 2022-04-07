package com.google.android.exoplayer2.video;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class AvcConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    public AvcConfig(List<byte[]> list, int i, int i2, int i3, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidthAspectRatio = f;
    }

    public static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parsableByteArray)) == null) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int position = parsableByteArray.getPosition();
            parsableByteArray.skipBytes(readUnsignedShort);
            return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.data, position, readUnsignedShort);
        }
        return (byte[]) invokeL.objValue;
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        InterceptResult invokeL;
        int i;
        int i2;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, parsableByteArray)) == null) {
            try {
                parsableByteArray.skipBytes(4);
                int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
                if (readUnsignedByte != 3) {
                    ArrayList arrayList = new ArrayList();
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                    for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                        arrayList.add(buildNalUnitForChild(parsableByteArray));
                    }
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                        arrayList.add(buildNalUnitForChild(parsableByteArray));
                    }
                    if (readUnsignedByte2 > 0) {
                        NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                        int i5 = parseSpsNalUnit.width;
                        int i6 = parseSpsNalUnit.height;
                        f = parseSpsNalUnit.pixelWidthAspectRatio;
                        i = i5;
                        i2 = i6;
                    } else {
                        i = -1;
                        i2 = -1;
                        f = 1.0f;
                    }
                    return new AvcConfig(arrayList, readUnsignedByte, i, i2, f);
                }
                throw new IllegalStateException();
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing AVC config", e);
            }
        }
        return (AvcConfig) invokeL.objValue;
    }
}
