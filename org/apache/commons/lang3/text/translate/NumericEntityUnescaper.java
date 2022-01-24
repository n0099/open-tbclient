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
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
/* loaded from: classes5.dex */
public class NumericEntityUnescaper extends CharSequenceTranslator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EnumSet<OPTION> options;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class OPTION {
        public static final /* synthetic */ OPTION[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OPTION errorIfNoSemiColon;
        public static final OPTION semiColonOptional;
        public static final OPTION semiColonRequired;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(589590834, "Lorg/apache/commons/lang3/text/translate/NumericEntityUnescaper$OPTION;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(589590834, "Lorg/apache/commons/lang3/text/translate/NumericEntityUnescaper$OPTION;");
                    return;
                }
            }
            semiColonRequired = new OPTION("semiColonRequired", 0);
            semiColonOptional = new OPTION("semiColonOptional", 1);
            OPTION option = new OPTION("errorIfNoSemiColon", 2);
            errorIfNoSemiColon = option;
            $VALUES = new OPTION[]{semiColonRequired, semiColonOptional, option};
        }

        public OPTION(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static OPTION valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OPTION) Enum.valueOf(OPTION.class, str) : (OPTION) invokeL.objValue;
        }

        public static OPTION[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OPTION[]) $VALUES.clone() : (OPTION[]) invokeV.objValue;
        }
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {optionArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (optionArr.length > 0) {
            this.options = EnumSet.copyOf((Collection) Arrays.asList(optionArr));
        } else {
            this.options = EnumSet.copyOf((Collection) Arrays.asList(OPTION.semiColonRequired));
        }
    }

    public boolean isSet(OPTION option) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, option)) == null) {
            EnumSet<OPTION> enumSet = this.options;
            if (enumSet == null) {
                return false;
            }
            return enumSet.contains(option);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
        if (r8.charAt(r3) != ';') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
        r0 = 1;
     */
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        InterceptResult invokeLIL;
        int i3;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, writer)) == null) {
            int length = charSequence.length();
            if (charSequence.charAt(i2) == '&' && i2 < length - 2 && charSequence.charAt(i2 + 1) == '#') {
                int i4 = i2 + 2;
                char charAt = charSequence.charAt(i4);
                if (charAt == 'x' || charAt == 'X') {
                    i4++;
                    if (i4 == length) {
                        return 0;
                    }
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                int i5 = i4;
                while (i5 < length && ((charSequence.charAt(i5) >= '0' && charSequence.charAt(i5) <= '9') || ((charSequence.charAt(i5) >= 'a' && charSequence.charAt(i5) <= 'f') || (charSequence.charAt(i5) >= 'A' && charSequence.charAt(i5) <= 'F')))) {
                    i5++;
                }
                int i6 = 0;
                if (i6 == 0) {
                    if (isSet(OPTION.semiColonRequired)) {
                        return 0;
                    }
                    if (isSet(OPTION.errorIfNoSemiColon)) {
                        throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                    }
                }
                try {
                    if (i3 != 0) {
                        parseInt = Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 16);
                    } else {
                        parseInt = Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 10);
                    }
                    if (parseInt > 65535) {
                        char[] chars = Character.toChars(parseInt);
                        writer.write(chars[0]);
                        writer.write(chars[1]);
                    } else {
                        writer.write(parseInt);
                    }
                    return ((i5 + 2) - i4) + i3 + i6;
                } catch (NumberFormatException unused) {
                }
            }
            return 0;
        }
        return invokeLIL.intValue;
    }
}
