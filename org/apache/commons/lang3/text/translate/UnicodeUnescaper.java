package org.apache.commons.lang3.text.translate;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class UnicodeUnescaper extends CharSequenceTranslator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UnicodeUnescaper() {
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

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        InterceptResult invokeLIL;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, charSequence, i2, writer)) == null) {
            if (charSequence.charAt(i2) == '\\' && (i3 = i2 + 1) < charSequence.length() && charSequence.charAt(i3) == 'u') {
                int i5 = 2;
                while (true) {
                    i4 = i2 + i5;
                    if (i4 >= charSequence.length() || charSequence.charAt(i4) != 'u') {
                        break;
                    }
                    i5++;
                }
                if (i4 < charSequence.length() && charSequence.charAt(i4) == '+') {
                    i5++;
                }
                int i6 = i2 + i5;
                int i7 = i6 + 4;
                if (i7 <= charSequence.length()) {
                    CharSequence subSequence = charSequence.subSequence(i6, i7);
                    try {
                        writer.write((char) Integer.parseInt(subSequence.toString(), 16));
                        return i5 + 4;
                    } catch (NumberFormatException e2) {
                        throw new IllegalArgumentException("Unable to parse unicode value: " + ((Object) subSequence), e2);
                    }
                }
                throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + ((Object) charSequence.subSequence(i2, charSequence.length())) + "' due to end of CharSequence");
            }
            return 0;
        }
        return invokeLIL.intValue;
    }
}
