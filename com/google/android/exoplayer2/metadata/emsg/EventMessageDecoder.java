package com.google.android.exoplayer2.metadata.emsg;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class EventMessageDecoder implements MetadataDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EventMessageDecoder() {
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

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, metadataInputBuffer)) == null) {
            ByteBuffer byteBuffer = metadataInputBuffer.data;
            byte[] array = byteBuffer.array();
            int limit = byteBuffer.limit();
            ParsableByteArray parsableByteArray = new ParsableByteArray(array, limit);
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString();
            String readNullTerminatedString2 = parsableByteArray.readNullTerminatedString();
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            parsableByteArray.skipBytes(4);
            return new Metadata(new EventMessage(readNullTerminatedString, readNullTerminatedString2, (parsableByteArray.readUnsignedInt() * 1000) / readUnsignedInt, parsableByteArray.readUnsignedInt(), Arrays.copyOfRange(array, parsableByteArray.getPosition(), limit)));
        }
        return (Metadata) invokeL.objValue;
    }
}
