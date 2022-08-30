package com.coremedia.iso;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class IsoTypeReaderVariable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IsoTypeReaderVariable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static long read(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        int readUInt8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, byteBuffer, i)) == null) {
            if (i == 1) {
                readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            } else if (i == 2) {
                readUInt8 = IsoTypeReader.readUInt16(byteBuffer);
            } else if (i != 3) {
                if (i != 4) {
                    if (i == 8) {
                        return IsoTypeReader.readUInt64(byteBuffer);
                    }
                    throw new RuntimeException("I don't know how to read " + i + " bytes");
                }
                return IsoTypeReader.readUInt32(byteBuffer);
            } else {
                readUInt8 = IsoTypeReader.readUInt24(byteBuffer);
            }
            return readUInt8;
        }
        return invokeLI.longValue;
    }
}
