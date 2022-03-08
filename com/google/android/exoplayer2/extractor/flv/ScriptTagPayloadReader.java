package com.google.android.exoplayer2.extractor.flv;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class ScriptTagPayloadReader extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AMF_TYPE_BOOLEAN = 1;
    public static final int AMF_TYPE_DATE = 11;
    public static final int AMF_TYPE_ECMA_ARRAY = 8;
    public static final int AMF_TYPE_END_MARKER = 9;
    public static final int AMF_TYPE_NUMBER = 0;
    public static final int AMF_TYPE_OBJECT = 3;
    public static final int AMF_TYPE_STRICT_ARRAY = 10;
    public static final int AMF_TYPE_STRING = 2;
    public static final String KEY_DURATION = "duration";
    public static final String NAME_METADATA = "onMetaData";
    public transient /* synthetic */ FieldHolder $fh;
    public long durationUs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trackOutput};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TrackOutput) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.durationUs = C.TIME_UNSET;
    }

    public static Boolean readAmfBoolean(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parsableByteArray)) == null) {
            return Boolean.valueOf(parsableByteArray.readUnsignedByte() == 1);
        }
        return (Boolean) invokeL.objValue;
    }

    public static Object readAmfData(ParsableByteArray parsableByteArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, parsableByteArray, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 8) {
                                if (i2 != 10) {
                                    if (i2 != 11) {
                                        return null;
                                    }
                                    return readAmfDate(parsableByteArray);
                                }
                                return readAmfStrictArray(parsableByteArray);
                            }
                            return readAmfEcmaArray(parsableByteArray);
                        }
                        return readAmfObject(parsableByteArray);
                    }
                    return readAmfString(parsableByteArray);
                }
                return readAmfBoolean(parsableByteArray);
            }
            return readAmfDouble(parsableByteArray);
        }
        return invokeLI.objValue;
    }

    public static Date readAmfDate(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parsableByteArray)) == null) {
            Date date = new Date((long) readAmfDouble(parsableByteArray).doubleValue());
            parsableByteArray.skipBytes(2);
            return date;
        }
        return (Date) invokeL.objValue;
    }

    public static Double readAmfDouble(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) ? Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong())) : (Double) invokeL.objValue;
    }

    public static HashMap<String, Object> readAmfEcmaArray(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, parsableByteArray)) == null) {
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            HashMap<String, Object> hashMap = new HashMap<>(readUnsignedIntToInt);
            for (int i2 = 0; i2 < readUnsignedIntToInt; i2++) {
                hashMap.put(readAmfString(parsableByteArray), readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, Object> readAmfObject(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, null, parsableByteArray)) != null) {
            return (HashMap) invokeL.objValue;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String readAmfString = readAmfString(parsableByteArray);
            int readAmfType = readAmfType(parsableByteArray);
            if (readAmfType == 9) {
                return hashMap;
            }
            hashMap.put(readAmfString, readAmfData(parsableByteArray, readAmfType));
        }
    }

    public static ArrayList<Object> readAmfStrictArray(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, parsableByteArray)) == null) {
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            ArrayList<Object> arrayList = new ArrayList<>(readUnsignedIntToInt);
            for (int i2 = 0; i2 < readUnsignedIntToInt; i2++) {
                arrayList.add(readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String readAmfString(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, parsableByteArray)) == null) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int position = parsableByteArray.getPosition();
            parsableByteArray.skipBytes(readUnsignedShort);
            return new String(parsableByteArray.data, position, readUnsignedShort);
        }
        return (String) invokeL.objValue;
    }

    public static int readAmfType(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, parsableByteArray)) == null) ? parsableByteArray.readUnsignedByte() : invokeL.intValue;
    }

    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.durationUs : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parsableByteArray)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void parsePayload(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, parsableByteArray, j2) == null) {
            if (readAmfType(parsableByteArray) == 2) {
                if (NAME_METADATA.equals(readAmfString(parsableByteArray)) && readAmfType(parsableByteArray) == 8) {
                    HashMap<String, Object> readAmfEcmaArray = readAmfEcmaArray(parsableByteArray);
                    if (readAmfEcmaArray.containsKey("duration")) {
                        double doubleValue = ((Double) readAmfEcmaArray.get("duration")).doubleValue();
                        if (doubleValue > 0.0d) {
                            this.durationUs = (long) (doubleValue * 1000000.0d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new ParserException();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
