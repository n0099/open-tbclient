package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class C40Encoder implements Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C40Encoder() {
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

    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, this, encoderContext, sb, sb2, i2)) == null) {
            int length = sb.length();
            sb.delete(length - i2, length);
            encoderContext.pos--;
            int encodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
            encoderContext.resetSymbolInfo();
            return encodeChar;
        }
        return invokeLLLI.intValue;
    }

    public static String encodeToCodewords(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i2)) == null) {
            int charAt = (charSequence.charAt(i2) * 1600) + (charSequence.charAt(i2 + 1) * '(') + charSequence.charAt(i2 + 2) + 1;
            return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
        }
        return (String) invokeLI.objValue;
    }

    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, encoderContext, sb) == null) {
            encoderContext.writeCodewords(encodeToCodewords(sb, 0));
            sb.delete(0, 3);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        int lookAheadTest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, encoderContext) == null) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (!encoderContext.hasMoreCharacters()) {
                    break;
                }
                char currentChar = encoderContext.getCurrentChar();
                encoderContext.pos++;
                int encodeChar = encodeChar(currentChar, sb);
                int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
                encoderContext.updateSymbolInfo(codewordCount);
                int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
                if (!encoderContext.hasMoreCharacters()) {
                    StringBuilder sb2 = new StringBuilder();
                    if (sb.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                        encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                    }
                    while (sb.length() % 3 == 1 && ((encodeChar <= 3 && dataCapacity != 1) || encodeChar > 3)) {
                        encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                    }
                } else if (sb.length() % 3 == 0 && (lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode())) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(lookAheadTest);
                    break;
                }
            }
            handleEOD(encoderContext, sb);
        }
    }

    public int encodeChar(char c2, StringBuilder sb) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c2), sb})) == null) {
            if (c2 == ' ') {
                sb.append((char) 3);
                return 1;
            } else if (c2 >= '0' && c2 <= '9') {
                sb.append((char) ((c2 - '0') + 4));
                return 1;
            } else if (c2 >= 'A' && c2 <= 'Z') {
                sb.append((char) ((c2 - 'A') + 14));
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
            } else if (c2 >= '`' && c2 <= 127) {
                sb.append((char) 2);
                sb.append((char) (c2 - '`'));
                return 2;
            } else if (c2 >= 128) {
                sb.append("\u0001\u001e");
                return encodeChar((char) (c2 - 128), sb) + 2;
            } else {
                throw new IllegalArgumentException("Illegal character: " + c2);
            }
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, encoderContext, sb) == null) {
            int length = sb.length() % 3;
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (length == 2) {
                sb.append((char) 0);
                while (sb.length() >= 3) {
                    writeNextTriplet(encoderContext, sb);
                }
                if (encoderContext.hasMoreCharacters()) {
                    encoderContext.writeCodeword((char) 254);
                }
            } else if (dataCapacity == 1 && length == 1) {
                while (sb.length() >= 3) {
                    writeNextTriplet(encoderContext, sb);
                }
                if (encoderContext.hasMoreCharacters()) {
                    encoderContext.writeCodeword((char) 254);
                }
                encoderContext.pos--;
            } else if (length == 0) {
                while (sb.length() >= 3) {
                    writeNextTriplet(encoderContext, sb);
                }
                if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                    encoderContext.writeCodeword((char) 254);
                }
            } else {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            encoderContext.signalEncoderChange(0);
        }
    }
}
