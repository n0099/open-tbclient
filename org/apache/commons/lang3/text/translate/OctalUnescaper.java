package org.apache.commons.lang3.text.translate;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class OctalUnescaper extends CharSequenceTranslator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OctalUnescaper() {
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

    private boolean isOctalDigit(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= '0' && c2 <= '7' : invokeCommon.booleanValue;
    }

    private boolean isZeroToThree(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= '0' && c2 <= '3' : invokeCommon.booleanValue;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, charSequence, i2, writer)) == null) {
            int length = (charSequence.length() - i2) - 1;
            StringBuilder sb = new StringBuilder();
            if (charSequence.charAt(i2) != '\\' || length <= 0) {
                return 0;
            }
            int i3 = i2 + 1;
            if (isOctalDigit(charSequence.charAt(i3))) {
                int i4 = i2 + 2;
                int i5 = i2 + 3;
                sb.append(charSequence.charAt(i3));
                if (length > 1 && isOctalDigit(charSequence.charAt(i4))) {
                    sb.append(charSequence.charAt(i4));
                    if (length > 2 && isZeroToThree(charSequence.charAt(i3)) && isOctalDigit(charSequence.charAt(i5))) {
                        sb.append(charSequence.charAt(i5));
                    }
                }
                writer.write(Integer.parseInt(sb.toString(), 8));
                return sb.length() + 1;
            }
            return 0;
        }
        return invokeLIL.intValue;
    }
}
