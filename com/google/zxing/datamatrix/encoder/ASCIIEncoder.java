package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ASCIIEncoder implements Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ASCIIEncoder() {
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

    public static char encodeASCIIDigits(char c, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c), Character.valueOf(c2)})) == null) {
            if (HighLevelEncoder.isDigit(c) && HighLevelEncoder.isDigit(c2)) {
                return (char) (((c - '0') * 10) + (c2 - '0') + 130);
            }
            throw new IllegalArgumentException("not digits: " + c + c2);
        }
        return invokeCommon.charValue;
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, encoderContext) == null) {
            if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
                encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
                encoderContext.pos += 2;
                return;
            }
            char currentChar = encoderContext.getCurrentChar();
            int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
            if (lookAheadTest != getEncodingMode()) {
                if (lookAheadTest != 1) {
                    if (lookAheadTest != 2) {
                        if (lookAheadTest != 3) {
                            if (lookAheadTest != 4) {
                                if (lookAheadTest == 5) {
                                    encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_BASE256);
                                    encoderContext.signalEncoderChange(5);
                                    return;
                                }
                                throw new IllegalStateException("Illegal mode: " + lookAheadTest);
                            }
                            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_EDIFACT);
                            encoderContext.signalEncoderChange(4);
                            return;
                        }
                        encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_ANSIX12);
                        encoderContext.signalEncoderChange(3);
                        return;
                    }
                    encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_TEXT);
                    encoderContext.signalEncoderChange(2);
                    return;
                }
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_C40);
                encoderContext.signalEncoderChange(1);
            } else if (HighLevelEncoder.isExtendedASCII(currentChar)) {
                encoderContext.writeCodeword(HighLevelEncoder.UPPER_SHIFT);
                encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
                encoderContext.pos++;
            } else {
                encoderContext.writeCodeword((char) (currentChar + 1));
                encoderContext.pos++;
            }
        }
    }
}
