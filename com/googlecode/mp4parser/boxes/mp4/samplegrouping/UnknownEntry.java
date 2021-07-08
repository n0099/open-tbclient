package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class UnknownEntry extends GroupEntry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer content;

    public UnknownEntry() {
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || UnknownEntry.class != obj.getClass()) {
                return false;
            }
            ByteBuffer byteBuffer = this.content;
            ByteBuffer byteBuffer2 = ((UnknownEntry) obj).content;
            return byteBuffer == null ? byteBuffer2 == null : byteBuffer.equals(byteBuffer2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.content.duplicate() : (ByteBuffer) invokeV.objValue;
    }

    public ByteBuffer getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.content : (ByteBuffer) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ByteBuffer byteBuffer = this.content;
            if (byteBuffer != null) {
                return byteBuffer.hashCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
            this.content = (ByteBuffer) byteBuffer.duplicate().rewind();
        }
    }

    public void setContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, byteBuffer) == null) {
            this.content = (ByteBuffer) byteBuffer.duplicate().rewind();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ByteBuffer duplicate = this.content.duplicate();
            duplicate.rewind();
            byte[] bArr = new byte[duplicate.limit()];
            duplicate.get(bArr);
            return "UnknownEntry{content=" + Hex.encodeHex(bArr) + '}';
        }
        return (String) invokeV.objValue;
    }
}
