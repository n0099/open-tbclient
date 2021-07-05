package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ASCIIEncoder implements Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ASCIIEncoder() {
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

    public static char encodeASCIIDigits(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (HighLevelEncoder.isDigit(c2) && HighLevelEncoder.isDigit(c3)) {
                return (char) (((c2 - '0') * 10) + (c3 - '0') + IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
            throw new IllegalArgumentException("not digits: " + c2 + c3);
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
            if (lookAheadTest == getEncodingMode()) {
                if (HighLevelEncoder.isExtendedASCII(currentChar)) {
                    encoderContext.writeCodeword(HighLevelEncoder.UPPER_SHIFT);
                    encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
                    encoderContext.pos++;
                    return;
                }
                encoderContext.writeCodeword((char) (currentChar + 1));
                encoderContext.pos++;
            } else if (lookAheadTest == 1) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_C40);
                encoderContext.signalEncoderChange(1);
            } else if (lookAheadTest == 2) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_TEXT);
                encoderContext.signalEncoderChange(2);
            } else if (lookAheadTest == 3) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_ANSIX12);
                encoderContext.signalEncoderChange(3);
            } else if (lookAheadTest == 4) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_EDIFACT);
                encoderContext.signalEncoderChange(4);
            } else if (lookAheadTest == 5) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_BASE256);
                encoderContext.signalEncoderChange(5);
            } else {
                throw new IllegalStateException("Illegal mode: " + lookAheadTest);
            }
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
