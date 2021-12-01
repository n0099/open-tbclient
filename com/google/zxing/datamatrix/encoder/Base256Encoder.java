package com.google.zxing.datamatrix.encoder;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class Base256Encoder implements Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Base256Encoder() {
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

    public static char randomize255State(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) == null) {
            int i3 = c2 + ((i2 * Opcodes.FCMPL) % 255) + 1;
            return i3 <= 255 ? (char) i3 : (char) (i3 - 256);
        }
        return invokeCommon.charValue;
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, encoderContext) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((char) 0);
            while (true) {
                if (!encoderContext.hasMoreCharacters()) {
                    break;
                }
                sb.append(encoderContext.getCurrentChar());
                encoderContext.pos++;
                int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
                if (lookAheadTest != getEncodingMode()) {
                    encoderContext.signalEncoderChange(lookAheadTest);
                    break;
                }
            }
            int length = sb.length() - 1;
            int codewordCount = encoderContext.getCodewordCount() + length + 1;
            encoderContext.updateSymbolInfo(codewordCount);
            boolean z = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0;
            if (encoderContext.hasMoreCharacters() || z) {
                if (length <= 249) {
                    sb.setCharAt(0, (char) length);
                } else if (length <= 1555) {
                    sb.setCharAt(0, (char) ((length / 250) + 249));
                    sb.insert(1, (char) (length % 250));
                } else {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
            }
            int length2 = sb.length();
            for (int i2 = 0; i2 < length2; i2++) {
                encoderContext.writeCodeword(randomize255State(sb.charAt(i2), encoderContext.getCodewordCount() + 1));
            }
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }
}
