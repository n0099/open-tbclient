package com.coremedia.iso;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public final class IsoTypeReaderVariable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IsoTypeReaderVariable() {
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

    public static long read(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        int readUInt8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, byteBuffer, i2)) == null) {
            if (i2 == 1) {
                readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            } else if (i2 == 2) {
                readUInt8 = IsoTypeReader.readUInt16(byteBuffer);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 8) {
                        return IsoTypeReader.readUInt64(byteBuffer);
                    }
                    throw new RuntimeException("I don't know how to read " + i2 + " bytes");
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
