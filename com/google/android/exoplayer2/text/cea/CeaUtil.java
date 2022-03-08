package com.google.android.exoplayer2.text.cea;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
/* loaded from: classes7.dex */
public final class CeaUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COUNTRY_CODE = 181;
    public static final int PAYLOAD_TYPE_CC = 4;
    public static final int PROVIDER_CODE = 49;
    public static final String TAG = "CeaUtil";
    public static final int USER_DATA_TYPE_CODE = 3;
    public static final int USER_ID = 1195456820;
    public transient /* synthetic */ FieldHolder $fh;

    public CeaUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void consume(long j2, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), parsableByteArray, trackOutputArr}) == null) {
            while (parsableByteArray.bytesLeft() > 1) {
                int readNon255TerminatedValue = readNon255TerminatedValue(parsableByteArray);
                int readNon255TerminatedValue2 = readNon255TerminatedValue(parsableByteArray);
                if (readNon255TerminatedValue2 != -1 && readNon255TerminatedValue2 <= parsableByteArray.bytesLeft()) {
                    if (isSeiMessageCea608(readNon255TerminatedValue, readNon255TerminatedValue2, parsableByteArray)) {
                        parsableByteArray.skipBytes(8);
                        parsableByteArray.skipBytes(1);
                        int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 31) * 3;
                        int position = parsableByteArray.getPosition();
                        for (TrackOutput trackOutput : trackOutputArr) {
                            parsableByteArray.setPosition(position);
                            trackOutput.sampleData(parsableByteArray, readUnsignedByte);
                            trackOutput.sampleMetadata(j2, 1, readUnsignedByte, 0, null);
                        }
                        parsableByteArray.skipBytes(readNon255TerminatedValue2 - (readUnsignedByte + 10));
                    } else {
                        parsableByteArray.skipBytes(readNon255TerminatedValue2);
                    }
                } else {
                    parsableByteArray.setPosition(parsableByteArray.limit());
                }
            }
        }
    }

    public static boolean isSeiMessageCea608(int i2, int i3, ParsableByteArray parsableByteArray) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, parsableByteArray)) == null) {
            if (i2 != 4 || i3 < 8) {
                return false;
            }
            int position = parsableByteArray.getPosition();
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int readInt = parsableByteArray.readInt();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            parsableByteArray.setPosition(position);
            return readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3;
        }
        return invokeIIL.booleanValue;
    }

    public static int readNon255TerminatedValue(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parsableByteArray)) == null) {
            int i2 = 0;
            while (parsableByteArray.bytesLeft() != 0) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                i2 += readUnsignedByte;
                if (readUnsignedByte != 255) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
