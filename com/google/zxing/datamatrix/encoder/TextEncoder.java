package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public final class TextEncoder extends C40Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TextEncoder() {
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

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public int encodeChar(char c2, StringBuilder sb) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2), sb})) == null) {
            if (c2 == ' ') {
                sb.append((char) 3);
                return 1;
            } else if (c2 >= '0' && c2 <= '9') {
                sb.append((char) ((c2 - '0') + 4));
                return 1;
            } else if (c2 >= 'a' && c2 <= 'z') {
                sb.append((char) ((c2 - 'a') + 14));
                return 1;
            } else if (c2 >= 0 && c2 <= 31) {
                sb.append((char) 0);
                sb.append(c2);
                return 2;
            } else if (c2 >= '!' && c2 <= '/') {
                sb.append((char) 1);
                sb.append((char) (c2 - '!'));
                return 2;
            } else if (c2 >= ':' && c2 <= '@') {
                sb.append((char) 1);
                sb.append((char) ((c2 - ':') + 15));
                return 2;
            } else if (c2 >= '[' && c2 <= '_') {
                sb.append((char) 1);
                sb.append((char) ((c2 - '[') + 22));
                return 2;
            } else if (c2 == '`') {
                sb.append((char) 2);
                sb.append((char) (c2 - '`'));
                return 2;
            } else if (c2 >= 'A' && c2 <= 'Z') {
                sb.append((char) 2);
                sb.append((char) ((c2 - 'A') + 1));
                return 2;
            } else if (c2 >= '{' && c2 <= 127) {
                sb.append((char) 2);
                sb.append((char) ((c2 - ExtendedMessageFormat.START_FE) + 27));
                return 2;
            } else if (c2 >= 128) {
                sb.append("\u0001\u001e");
                return encodeChar((char) (c2 - 128), sb) + 2;
            } else {
                HighLevelEncoder.illegalCharacter(c2);
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
