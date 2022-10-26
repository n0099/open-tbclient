package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class EdifactEncoder implements Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public EdifactEncoder() {
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

    public static void encodeChar(char c, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c), sb}) == null) {
            if (c >= ' ' && c <= '?') {
                sb.append(c);
            } else if (c >= '@' && c <= '^') {
                sb.append((char) (c - '@'));
            } else {
                HighLevelEncoder.illegalCharacter(c);
            }
        }
    }

    public static String encodeToCodewords(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        char c;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i)) == null) {
            int length = charSequence.length() - i;
            if (length != 0) {
                char charAt = charSequence.charAt(i);
                char c3 = 0;
                if (length >= 2) {
                    c = charSequence.charAt(i + 1);
                } else {
                    c = 0;
                }
                if (length >= 3) {
                    c2 = charSequence.charAt(i + 2);
                } else {
                    c2 = 0;
                }
                if (length >= 4) {
                    c3 = charSequence.charAt(i + 3);
                }
                int i2 = (charAt << 18) + (c << '\f') + (c2 << 6) + c3;
                char c4 = (char) ((i2 >> 8) & 255);
                char c5 = (char) (i2 & 255);
                StringBuilder sb = new StringBuilder(3);
                sb.append((char) ((i2 >> 16) & 255));
                if (length >= 2) {
                    sb.append(c4);
                }
                if (length >= 3) {
                    sb.append(c5);
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
                    int i = length - 1;
                    String encodeToCodewords = encodeToCodewords(charSequence, 0);
                    if (!(!encoderContext.hasMoreCharacters()) || i > 2) {
                        z = false;
                    }
                    if (i <= 2) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i);
                        if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                            encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
                            z = false;
                        }
                    }
                    if (z) {
                        encoderContext.resetSymbolInfo();
                        encoderContext.pos -= i;
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
}
