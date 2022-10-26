package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
@Descriptor(tags = {19})
/* loaded from: classes7.dex */
public class ExtensionProfileLevelDescriptor extends BaseDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] bytes;

    public ExtensionProfileLevelDescriptor() {
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

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) && getSize() > 0) {
            byte[] bArr = new byte[getSize()];
            this.bytes = bArr;
            byteBuffer.get(bArr);
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        InterceptResult invokeV;
        String encodeHex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ExtensionDescriptor");
            sb.append("{bytes=");
            byte[] bArr = this.bytes;
            if (bArr == null) {
                encodeHex = StringUtil.NULL_STRING;
            } else {
                encodeHex = Hex.encodeHex(bArr);
            }
            sb.append(encodeHex);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
