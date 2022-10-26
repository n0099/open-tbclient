package com.coremedia.iso;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes7.dex */
public final class IsoTypeWriterVariable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IsoTypeWriterVariable() {
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

    public static void write(long j, ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), byteBuffer, Integer.valueOf(i)}) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 8) {
                                IsoTypeWriter.writeUInt64(byteBuffer, j);
                                return;
                            }
                            throw new RuntimeException("I don't know how to read " + i + " bytes");
                        }
                        IsoTypeWriter.writeUInt32(byteBuffer, j);
                        return;
                    }
                    IsoTypeWriter.writeUInt24(byteBuffer, (int) (j & 16777215));
                    return;
                }
                IsoTypeWriter.writeUInt16(byteBuffer, (int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX));
                return;
            }
            IsoTypeWriter.writeUInt8(byteBuffer, (int) (j & 255));
        }
    }
}
