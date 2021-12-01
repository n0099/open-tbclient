package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class EdifactEncoder implements Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EdifactEncoder() {
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

    public static void encodeChar(char c2, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2), sb}) == null) {
            if (c2 >= ' ' && c2 <= '?') {
                sb.append(c2);
            } else if (c2 >= '@' && c2 <= '^') {
                sb.append((char) (c2 - '@'));
            } else {
                HighLevelEncoder.illegalCharacter(c2);
            }
        }
    }

    public static String encodeToCodewords(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i2)) == null) {
            int length = charSequence.length() - i2;
            if (length != 0) {
                int charAt = (charSequence.charAt(i2) << 18) + ((length >= 2 ? charSequence.charAt(i2 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i2 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i2 + 3) : (char) 0);
                char c2 = (char) ((charAt >> 8) & 255);
                char c3 = (char) (charAt & 255);
                StringBuilder sb = new StringBuilder(3);
                sb.append((char) ((charAt >> 16) & 255));
                if (length >= 2) {
                    sb.append(c2);
                }
                if (length >= 3) {
                    sb.append(c3);
                }
                return sb.toString();
            }
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        return (String) invokeLI.objValue;
    }

    public static void handleEOD(EncoderContext encoderContext, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, encoderContext, charSequence) == null) {
            try {
                int length = charSequence.length();
                if (length == 0) {
                    return;
                }
                boolean z = true;
                if (length == 1) {
                    encoderContext.updateSymbolInfo();
                    int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                    if (encoderContext.getRemainingCharacters() == 0 && dataCapacity <= 2) {
                        return;
                    }
                }
                if (length <= 4) {
                    int i2 = length - 1;
                    String encodeToCodewords = encodeToCodewords(charSequence, 0);
                    if (!(!encoderContext.hasMoreCharacters()) || i2 > 2) {
                        z = false;
                    }
                    if (i2 <= 2) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i2);
                        if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                            encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
                            z = false;
                        }
                    }
                    if (z) {
                        encoderContext.resetSymbolInfo();
                        encoderContext.pos -= i2;
                    } else {
                        encoderContext.writeCodewords(encodeToCodewords);
                    }
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            } finally {
                encoderContext.signalEncoderChange(0);
            }
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, encoderContext) == null) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (!encoderContext.hasMoreCharacters()) {
                    break;
                }
                encodeChar(encoderContext.getCurrentChar(), sb);
                encoderContext.pos++;
                if (sb.length() >= 4) {
                    encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                    sb.delete(0, 4);
                    if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                        encoderContext.signalEncoderChange(0);
                        break;
                    }
                }
            }
            sb.append((char) 31);
            handleEOD(encoderContext, sb);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }
}
