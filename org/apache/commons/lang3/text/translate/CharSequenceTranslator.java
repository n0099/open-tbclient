package org.apache.commons.lang3.text.translate;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
/* loaded from: classes5.dex */
public abstract class CharSequenceTranslator {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] HEX_DIGITS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-500018910, "Lorg/apache/commons/lang3/text/translate/CharSequenceTranslator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-500018910, "Lorg/apache/commons/lang3/text/translate/CharSequenceTranslator;");
                return;
            }
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public CharSequenceTranslator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String hex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? Integer.toHexString(i2).toUpperCase(Locale.ENGLISH) : (String) invokeI.objValue;
    }

    public abstract int translate(CharSequence charSequence, int i2, Writer writer) throws IOException;

    public final String translate(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) {
            if (charSequence == null) {
                return null;
            }
            try {
                StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
                translate(charSequence, stringWriter);
                return stringWriter.toString();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public final CharSequenceTranslator with(CharSequenceTranslator... charSequenceTranslatorArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequenceTranslatorArr)) == null) {
            CharSequenceTranslator[] charSequenceTranslatorArr2 = new CharSequenceTranslator[charSequenceTranslatorArr.length + 1];
            charSequenceTranslatorArr2[0] = this;
            System.arraycopy(charSequenceTranslatorArr, 0, charSequenceTranslatorArr2, 1, charSequenceTranslatorArr.length);
            return new AggregateTranslator(charSequenceTranslatorArr2);
        }
        return (CharSequenceTranslator) invokeL.objValue;
    }

    public final void translate(CharSequence charSequence, Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, writer) == null) {
            if (writer == null) {
                throw new IllegalArgumentException("The Writer must not be null");
            }
            if (charSequence == null) {
                return;
            }
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int translate = translate(charSequence, i2, writer);
                if (translate == 0) {
                    char charAt = charSequence.charAt(i2);
                    writer.write(charAt);
                    i2++;
                    if (Character.isHighSurrogate(charAt) && i2 < length) {
                        char charAt2 = charSequence.charAt(i2);
                        if (Character.isLowSurrogate(charAt2)) {
                            writer.write(charAt2);
                            i2++;
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < translate; i3++) {
                        i2 += Character.charCount(Character.codePointAt(charSequence, i2));
                    }
                }
            }
        }
    }
}
