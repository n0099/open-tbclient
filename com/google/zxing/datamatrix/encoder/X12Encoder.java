package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class X12Encoder extends C40Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public X12Encoder() {
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

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, encoderContext) == null) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (!encoderContext.hasMoreCharacters()) {
                    break;
                }
                char currentChar = encoderContext.getCurrentChar();
                encoderContext.pos++;
                encodeChar(currentChar, sb);
                if (sb.length() % 3 == 0) {
                    C40Encoder.writeNextTriplet(encoderContext, sb);
                    int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
                    if (lookAheadTest != getEncodingMode()) {
                        encoderContext.signalEncoderChange(lookAheadTest);
                        break;
                    }
                }
            }
            handleEOD(encoderContext, sb);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public int encodeChar(char c, StringBuilder sb) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c), sb})) == null) {
            if (c == '\r') {
                sb.append((char) 0);
            } else if (c == '*') {
                sb.append((char) 1);
            } else if (c == '>') {
                sb.append((char) 2);
            } else if (c == ' ') {
                sb.append((char) 3);
            } else if (c >= '0' && c <= '9') {
                sb.append((char) ((c - '0') + 4));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A') + 14));
            } else {
                HighLevelEncoder.illegalCharacter(c);
            }
            return 1;
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, encoderContext, sb) == null) {
            encoderContext.updateSymbolInfo();
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
            encoderContext.pos -= sb.length();
            if (encoderContext.getRemainingCharacters() > 1 || dataCapacity > 1 || encoderContext.getRemainingCharacters() != dataCapacity) {
                encoderContext.writeCodeword((char) 254);
            }
            if (encoderContext.getNewEncoding() < 0) {
                encoderContext.signalEncoderChange(0);
            }
        }
    }
}
